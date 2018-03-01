import org.apache.http.client.methods.HttpGet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2017/7/12.
 */
public class SubmitPage extends HttpServlet{
    public static String openId;
    public void doGet(HttpServletRequest req,HttpServletResponse res) {
        try {
            req.setAttribute("openId",openId);
            req.getRequestDispatcher("upload.jsp").forward(req,res);
            //res.sendRedirect("SubmitPage.jsp");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
