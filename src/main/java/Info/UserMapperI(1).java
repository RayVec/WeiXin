package Info;

import org.apache.ibatis.annotations.Select;

/**
 * Created by Administrator on 2017/7/18.
 */
public interface UserMapperI {
    public int insertUser(User user);

    public String getProvince(String openId);

    public String getNickname(String openId);

    public String getCity(String openId);

    public int deleteUser(String openId);
}
