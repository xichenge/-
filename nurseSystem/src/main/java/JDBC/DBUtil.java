package JDBC;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DBUtil {

    //配置对象
    private static Properties properties = new Properties();

    static{
        //加载配置文件(输入流)
        try {
            InputStream in = DBUtil.class.getClassLoader().getResourceAsStream("jd.properties");
            //通过load(方法加载到配置文件对象中
            properties.load(in);
            Class.forName(properties.getProperty("driverClass"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库链接
     * @return
     */
    public static Connection getConnection(){
        Connection connection = null;
        //得到数据库链接
        try {
            String dbUrl = properties.getProperty("url");
            String dbName = properties.getProperty("username");
            String dbPwd = properties.getProperty("password");
            connection = DriverManager.getConnection(dbUrl, dbName, dbPwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    public static void close(ResultSet resultSet,
                             PreparedStatement preparedStatement,
                             Connection connection){
        try{
            if(resultSet!=null){
                resultSet.close();
            }
            if(preparedStatement!=null){
                preparedStatement.close();
            }
            if(connection!=null){
                connection.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}

