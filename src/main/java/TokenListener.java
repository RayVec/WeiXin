import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpServlet;
import java.util.Timer;

/**
 * Created by Administrator on 2017/7/28.
 */
public class TokenListener extends HttpServlet implements ServletContextListener{
   public void contextDestroyed(ServletContextEvent event){

   }
   public void contextInitialized(ServletContextEvent sce){
       Timer timer=new Timer();
       TokenTask tokenTask=new TokenTask();
       timer.schedule(tokenTask,7200000);
   }
}
