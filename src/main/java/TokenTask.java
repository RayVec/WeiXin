import java.util.TimerTask;

/**
 * Created by Administrator on 2017/7/28.
 */
public class TokenTask extends TimerTask{
    public void run() {
        try {
            Servlet.token = Token.getToken(Servlet.appid, Servlet.secret);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
