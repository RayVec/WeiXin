import Info.MyBatisUtil;
import Info.User;
import Info.UserMapperI;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONObject;

import java.io.File;

/**
 * Created by Administrator on 2017/7/12.
 */
public class UserInfo {
    public static String getUserInfo(String openId,String token)throws Exception{
        JSONObject jsonObject=getJson(openId,token);
        int subscreibe=jsonObject.getInt("subscribe");
        String nickname=jsonObject.getString("nickname");
        String city=jsonObject.getString("city");
        String province=jsonObject.getString("province");
        String subscribe;
        if(subscreibe==1){
            subscribe="已订阅";
        }
        else {
            subscribe="未订阅";
        }
        String info=subscribe+" "+"昵称:"+nickname+" "+"省份:"+province+" "+"城市:"+city;
        return info;
    }
    //返回一组字符串，0为openId，1为昵称，2为省份，3为城市
    public static String[] getUserInfoArray(String openId,String token)throws  Exception{
        JSONObject jsonObject=getJson(openId,token);
        String[] infos=new String[4];
        infos[0]=openId;
        infos[1]=jsonObject.getString("nickname");
        infos[2]=jsonObject.getString("province");
        infos[3]=jsonObject.getString("city");
        return infos;
    }
    public static JSONObject getJson(String openId,String  token)throws Exception{
        String url="http://api.weixin.qq.com/cgi-bin/user/info?access_token="+token+"&openid="+openId+"&lang=zh_CN";
        HttpGet get=new HttpGet(url);
        HttpResponse response = HttpClients.createDefault().execute(get);
        String result= EntityUtils.toString(response.getEntity());
        JSONObject jsonObject=new JSONObject(result);
        return jsonObject;
    }
    public static int addUser(String openId)throws Exception{
        String url="http://api.weixin.qq.com/cgi-bin/user/info?access_token="+Token.getToken(Servlet.appid,Servlet.secret)+"&openid="+openId+"&lang=zh_CN";
        HttpGet get=new HttpGet(url);
        HttpResponse response = HttpClients.createDefault().execute(get);
        String result= EntityUtils.toString(response.getEntity());
        JSONObject jsonObject=new JSONObject(result);
        String nickname=jsonObject.getString("nickname");
        String city=jsonObject.getString("city");
        String province=jsonObject.getString("province");
        User user=new User();
        user.setOpenId(openId);
        user.setCity(city);
        user.setNickname(nickname);
        user.setProvince(province);
        SqlSession session= MyBatisUtil.getSqlSession(true);
        UserMapperI userMapperI=session.getMapper(UserMapperI.class);
        int a= userMapperI.insertUser(user);
        return  a;
    }
    public static int deleteUser(String openId)throws Exception{
       SqlSession session=MyBatisUtil.getSqlSession(true);
       UserMapperI userMapperI=session.getMapper(UserMapperI.class);
       int result=userMapperI.deleteUser(openId);
       File file=new File("F:/file/"+openId);
       deleteAll(file);
       return  result;
    }
    public static void deleteAll(File path){
        if (!path.exists())   //路径存在
        return;
        if (path.isFile()) {  //是文件
            path.delete();
            return;
        }
        File[] files = path.listFiles();
        for (int i = 0; i < files.length; i++) {
            deleteAll(files[i]);
        }
        path.delete();
    }
}
