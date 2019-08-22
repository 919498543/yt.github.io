package LoginTest;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/*
 * Druid连接池的工具类
 *
 * */
public class DruidUtils
{
    //定义成员变量
    private static DataSource ds;

    //静态代码块，加载配置文件
    static
    {
        try
        {
            Properties properties = new Properties();//创建properties
            //使用classLoader加载配置文件，获取字节输入流
            InputStream is = DruidUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            properties.load(is);
//            properties.load(DruidUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
            //初始化连接对象
            ds = DruidDataSourceFactory.createDataSource(properties);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    //获取连接Connection对象
    public static Connection getConnection() throws SQLException
    {
        return ds.getConnection();
    }

    //获取连接池//获取连接对象
    public static DataSource getDataSource()
    {
        return ds;
    }
}
