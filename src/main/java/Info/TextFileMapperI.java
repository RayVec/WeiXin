package Info;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Administrator on 2017/7/18.
 */
public interface TextFileMapperI {
    public List<TextFile> selectFile(String openId);
    public int insertFile(TextFile textFile);
    public String getNewurl(TextFile textFile);
}
