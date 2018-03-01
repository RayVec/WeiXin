/**
 * Created by Administrator on 2017/7/25.
 */
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadFile extends HttpServlet {

    private static final long serialVersionUID = 6765085208899952414L;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String filedisplay = request.getParameter("filename");
        filedisplay=new String(filedisplay.getBytes("UTF-8"),"ISO-8859-1");
        String filedownload = request.getParameter("newurl");
        response.setContentType("applicaiton/x-msdownload");
        response.addHeader("Content-Disposition", "attachment;filename="+filedisplay);

        InputStream is = null;
        OutputStream os = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        is = new FileInputStream(new File(filedownload));
        bis = new BufferedInputStream(is);
        os = response.getOutputStream();
        bos = new BufferedOutputStream(os);

        byte[] b = new byte[1024];
        int len = 0;
        while((len = bis.read(b)) != -1){
            bos.write(b,0,len);
        }
        bis.close();
        is.close();
        bos.close();
        os.close();
    }
}
