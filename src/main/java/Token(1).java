import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

/**
 * Created by Administrator on 2017/7/12.
 */
public class Token {
    public static String getToken(String appid,String secret)throws  Exception{
        String getTokenUrl="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+appid+"&secret="+secret;
        HttpGet tokenget=new HttpGet(getTokenUrl);
        System.out.println("开始更新token");
        HttpResponse response1= HttpClients.createDefault().execute(tokenget);
        String token= EntityUtils.toString(response1.getEntity());
        JSONObject jsonObject=new JSONObject(token);
        String result=jsonObject.getString("access_token");
        System.out.println("获得的token为"+result);
        return result;
    }
}
