import org.apache.http.HttpResponse;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;

/**
 * Created by Administrator on 2017/7/10.
 */
public class WechatProcess {
    public static void processWechatMag(String xml, HttpServletResponse response){
        /** 解析xml数据 */
        ReceiveXmlEntity xmlEntity = new ReceiveXmlProcess().getMsgEntity(xml);

        /** 以文本消息为例，调用图灵机器人api接口，获取回复内容 */
        String result = "";
        String messageType=xmlEntity.getMsgType();
        if("text".endsWith(messageType)){
            result = new TulingApiProcess().getTulingResult(xmlEntity.getContent());
            /** 此时，如果用户输入的是“你好”，在经过上面的过程之后，result为“你也好”类似的内容
             *  因为最终回复给微信的也是xml格式的数据，所有需要将其封装为文本类型返回消息
             * */
            result = new FormatXmlProcess().formatXmlAnswer(xmlEntity.getFromUserName(), xmlEntity.getToUserName(), result);
            try {
                OutputStream os = response.getOutputStream();
                os.write(result.getBytes("UTF-8"));
                os.flush();
                os.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if("event".endsWith(messageType)){
            if(xmlEntity.getEvent().equals("VIEW")){
                if(xmlEntity.getEventKey().equals("http://weirui.natapp1.cc/SubmitPage")){
                    SubmitPage.openId=xmlEntity.getFromUserName();
                }
                if(xmlEntity.getEventKey().equals("http://weirui.natapp1.cc/MyInfoPage")){
                    MyInfoPage.openId=xmlEntity.getFromUserName();
                }
            }
            if(xmlEntity.getEvent().equals("subscribe")){
                String  openId=xmlEntity.getFromUserName();
                int a=0;
                try {
                    a = UserInfo.addUser(openId);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                if(a==1){
                    System.out.println("添加用户id为"+openId+"的用户在数据库成功");
                }
            }
            if(xmlEntity.getEvent().equals("unsubscribe")){
                String openId=xmlEntity.getFromUserName();
                int a=0;
                   try {
                       a=UserInfo.deleteUser(openId);
                   }
                   catch (Exception e){
                       e.printStackTrace();
                   }
                   if(a==1){
                       System.out.println("用户id为"+openId+"的用户已经取消关注，删除其信息成功");
                   }
                   else { System.out.println("用户id为"+openId+"的用户已经取消关注，但删除其信息失败");}
            }
        }
    }
}

