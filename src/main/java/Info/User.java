package Info;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.io.Reader;
import java.util.List;

/**
 * Created by Administrator on 2017/7/16.
 */
public class User {
    private String openId;
    private String nickname;
    private String province;
    private String city;
    private List<TextFile> files;

    public void setOpenId(String openId){
        this.openId=openId;
    }
    public void setNickname(String nickname){
        this.nickname=nickname;
    }
    public void setProvince(String province){
        this.province=province;
    }
    public void setCity(String city){
        this.city=city;
    }
    public User(){}
    public User(String openId)throws Exception{
        this.openId=openId;

        //构建sqlSession的工厂
        SqlSessionFactory sessionFactory =MyBatisUtil.getSqlSessionFactory();
        //创建能执行映射文件中sql的sqlSession
        SqlSession session = sessionFactory.openSession();
        TextFileMapperI textFileMapperI=session.getMapper(TextFileMapperI.class);
        SqlSession session1=sessionFactory.openSession();
        UserMapperI userMapperI=session1.getMapper(UserMapperI.class);
        files=textFileMapperI.selectFile(openId);
        this.nickname=userMapperI.getNickname(openId);
        this.province=userMapperI.getProvince(openId);
        this.city=userMapperI.getCity(openId);
        session.close();
    }
    public List<TextFile> getFiles(){
        return files;
    }
    public String getOpenId(){
        return openId;
    }
    public String getNickname(){
        return nickname;
    }
    public String getProvince(){
        return province;
    }
    public String getCity(){
        return city;
    }
}
