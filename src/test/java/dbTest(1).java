/**
 * Created by Administrator on 2017/7/17.
 */
import Info.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.*;

public class dbTest {
    public static void main(String args[])throws Exception{
         /*TextFile file=new TextFile();
         file.setOpenId("1234");
         file.setFilename("haha");
         file.setLocalurl("/wer/wew/wew");
         file.setStatus("未处理");
         file.setWordNum(222);
        String resource = "conf.xml";
        Reader reader = Resources.getResourceAsReader(resource);
        //构建sqlSession的工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        //创建能执行映射文件中sql的sqlSession
        SqlSession session = sessionFactory.openSession();
        String  statment="InfoMapping.textFileMapper.insertFile";
        int result=session.insert(statment,file);
        session.commit();
        session.close();
        System.out.println(result);*/
        /*String openId="otctjwGpS6wK4hf_BVUAPatKXtk8";
        User user=new User(openId);
        List<TextFile> files=user.getFiles();
        List<String> names=new LinkedList<String>();
        for(TextFile file:files){
            names.add(file.getFilename());
        }
        for(String name:names){
            System.out.println(name);
        }*/
        /**SqlSession session=MyBatisUtil.getSqlSession();
        String openId="otctjwGpS6wK4hf_BVUAPatKXtk8";
        String filename="shumei.txt";
        TextFile textFile=new TextFile();
        textFile.setOpenId(openId);
        textFile.setFilename(filename);
        TextFileMapperI textFileMapperI=session.getMapper(TextFileMapperI.class);
        String newurl=textFileMapperI.getNewurl(textFile);
        if(newurl==null){
            System.out.println("为空");
        }
        else {
            System.out.println(newurl);
        }*/
        SqlSession session= MyBatisUtil.getSqlSession(true);
        UserMapperI userMapperI=session.getMapper(UserMapperI.class);
        int result=userMapperI.deleteUser("12345");
        System.out.print(result);
    }
}
