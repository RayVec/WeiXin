import java.io.File;

/**
 * Created by Administrator on 2017/7/26.
 */
public class DirectoryTest {
    public static void main(String args[]){
        File file=new File("F:/file/null");
        UserInfo.deleteAll(file);
    }
}
