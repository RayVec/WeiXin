import Info.MyBatisUtil;
import Info.TextFile;
import Info.User;
import Info.UserMapperI;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Administrator on 2017/7/12.
 */
public class MyInfoPage extends HttpServlet{
    public static String openId;
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) {
        try {
            SqlSession session= MyBatisUtil.getSqlSession();
            UserMapperI userMapperI=session.getMapper(UserMapperI.class);
            req.setAttribute("openId",openId);
            req.setAttribute("nickname",userMapperI.getNickname(openId));
            req.setAttribute("province",userMapperI.getProvince(openId));
            req.setAttribute("city",userMapperI.getCity(openId));
            String oldimg=UserInfo.getJson(openId,Servlet.token).getString("headimgurl");
            String newimg=oldimg.substring(0,oldimg.length()-1)+64;
            System.out.println(newimg);
            req.setAttribute("headimgurl",newimg);
            User user=new User(openId);
            List<TextFile> files=user.getFiles();
            req.setAttribute("files",files);
            RequestDispatcher dispatcher=req.getRequestDispatcher("MyInfoPage.jsp");
            dispatcher.forward(req,res);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
