package Info; /**
 * Created by Administrator on 2017/7/19.
 */
import java.io.InputStream;
import java.io.Reader;
import org.apache.ibatis.io.*;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {

    /**
     * 获取SqlSessionFactory
     * @return SqlSessionFactory
     */
    public static SqlSessionFactory getSqlSessionFactory() throws  Exception{
        String resource = "conf.xml";
        Reader reader= Resources.getResourceAsReader(resource);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
        return factory;
    }

    /**
     * 获取SqlSession
     * @return SqlSession
     */
    public static SqlSession getSqlSession()throws Exception {
        return getSqlSessionFactory().openSession();
    }

    /**
     * 获取SqlSession
     * @param isAutoCommit
     *         true 表示创建的SqlSession对象在执行完SQL之后会自动提交事务
     *         false 表示创建的SqlSession对象在执行完SQL之后不会自动提交事务，这时就需要我们手动调用sqlSession.commit()提交事务
     * @return SqlSession
     */
    public static SqlSession getSqlSession(boolean isAutoCommit)throws Exception {
        return getSqlSessionFactory().openSession(isAutoCommit);
    }
}