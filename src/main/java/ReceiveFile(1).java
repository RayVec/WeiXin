import Info.MyBatisUtil;
import Info.TextFile;
import Info.TextFileMapperI;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.FileItem;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;


/**
 * Created by Administrator on 2017/7/13.
 */
public class ReceiveFile  extends HttpServlet{
    public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException{
        req.setCharacterEncoding("UTF-8");
        res.setContentType("text/html;charset=UTF-8");//更改响应字符流使用的编码，还能告知浏览器用什么编码进行显示
        String openId="";
        //从request中获取文本输入流信息
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        // 创建服务器文件上传处理对象
        ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
        try {
            List<FileItem> items = servletFileUpload.parseRequest(req);
            for (FileItem item : items) {
                if(!item.isFormField()) {
                    InputStream fileSourceStream = item.getInputStream();
                    String tempFileName = "F:/weixintesttempFile/tempFile";


                    //设置临时文件，保存待上传的文本输入流
                    File tempFile = new File(tempFileName);

                    //outputStram文件输出流指向这个tempFile
                    FileOutputStream outputStream = new FileOutputStream(tempFile);

                    //读取文件流
                    int wordNum = 0;
                    byte temp[] = new byte[1024];
                    int n;
                    while ((n = fileSourceStream.read(temp)) != -1) {
                        String temps = new String(temp, "UTF-8");
                        System.out.println(temps);
                        wordNum += getMSWordsCount(temps);
                        outputStream.write(temp, 0, n);
                    }
                    outputStream.close();
                    fileSourceStream.close();
                    System.out.println("文件字数为" + wordNum);

                    //获取上传文件的名称

                    RandomAccessFile randomFile = new RandomAccessFile(tempFile, "r");
                    String str = item.getName();
                    String filename;
                    if (str.contains("\\")) {
                        filename = str.substring(str.lastIndexOf("\\"), str.length());
                    } else {
                        filename = str;
                    }
                    System.out.println("已获得文件" + filename);
                    //定位文件指针到文件头
                    randomFile.seek(0);
                    long startIndex = 0;
                    //获取文件内容结束位置
                    randomFile.seek(randomFile.length());
                    long endIndex = randomFile.getFilePointer();
                    //设置保存上传文件的路径
                    String realPath = "F:/file/" + openId;
                    File fileupload = new File(realPath);
                    if (!fileupload.exists()) {
                        fileupload.mkdir();
                    }
                    File saveFile = new File(realPath, filename);
                    RandomAccessFile randomAccessFile = new RandomAccessFile(saveFile, "rw");
                    //根据起止位置从临时文件中读取文件内容
                    randomFile.seek(startIndex);
                    while (startIndex < endIndex) {
                        randomAccessFile.write(randomFile.readByte());
                        startIndex = randomFile.getFilePointer();
                    }
                    //关闭输入输出流并 删除临时文件
                    randomAccessFile.close();
                    randomFile.close();
                    tempFile.delete();

                    //获取文件名，路径，字数，用户openId并储存
                    TextFile textFile = new TextFile();
                    textFile.setFilename(filename);
                    textFile.setStatus("处理中");
                    textFile.setOpenId(openId);
                    textFile.setLocalurl(realPath + "/" + filename);
                    textFile.setWordNum(wordNum);
                    SqlSessionFactory sqlSessionFactory = MyBatisUtil.getSqlSessionFactory();
                    SqlSession session = sqlSessionFactory.openSession(true);
                    TextFileMapperI textFileMapperI = session.getMapper(TextFileMapperI.class);
                    int insertResult = textFileMapperI.insertFile(textFile);
                    if (insertResult == 1) {
                        System.out.println("添加文件名为" + filename + "在数据库中成功");
                    }
                }
                else {
                    if(item.getFieldName().equals("openId")){
                        openId=item.getString();
                        System.out.println("用户id为"+openId);
                    }
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
            req.setAttribute("openId",openId);
            RequestDispatcher dispatcher = req.getRequestDispatcher("fail.jsp");
            dispatcher.forward(req, res);
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("success.jsp");
        dispatcher.forward(req, res);
    }

    private int getMSWordsCount(String context){
        int words_count = 0;
//中文单词
        String cn_words = context.replaceAll("[^(\\u4e00-\\u9fa5，。《》？；’‘：“”【】、）（……￥！·)]", "");
        int cn_words_count = cn_words.length();
//非中文单词
        String non_cn_words = context.replaceAll("[^(a-zA-Z0-9`\\-=\';.,/~!@#$%^&*()_+|}{\":><?\\[\\])]", " ");
        int non_cn_words_count = 0;
        String[] ss = non_cn_words.split(" ");
        for(String s:ss){
            if(s.trim().length()!=0) non_cn_words_count++;
        }
//中文和非中文单词合计
        words_count = cn_words_count + non_cn_words_count;
        return words_count;
    }
}
