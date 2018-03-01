/**
 * Created by Administrator on 2017/7/10.
 */
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.*;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * 调用图灵机器人api接口，获取智能回复内容
 * @author pamchen-1
 *
 */
public class TulingApiProcess {
    /**
     * 调用图灵机器人api接口，获取智能回复内容，解析获取自己所需结果
     * @param content
     * @return
     */
    public String getTulingResult(String content){
        /** 此处为图灵api接口，参数key需要自己去注册申请*/
        String apiUrl = "http://www.tuling123.com/openapi/api?key=5b236e41f86643f4b2156cfa3cc7f7e1&info=";
        String param = "";
        try {
            param = apiUrl+URLEncoder.encode(content,"utf-8")+"&userid=103553";
            System.out.println(content);

        } catch (UnsupportedEncodingException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } //将参数转为url编码

        /** 发送httppost请求 */
        HttpPost request = new HttpPost(param);
        String result = "";
        try {
            HttpResponse response=HttpClients.createDefault().execute(request);
            if (response==null){
            }
            if(response.getStatusLine().getStatusCode()==200){
                result = EntityUtils.toString(response.getEntity());

            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //如果请求失败
        if(null==result){
            return "对不起，你说的话真是太高深了……";
        }

        try {
            JSONObject json = new JSONObject(result);
            result = json.getString("text");
            System.out.println(result);

        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }
}
