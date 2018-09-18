package jdbc;


import java.sql.*;
import java.lang.Exception;


/**
 * @author conshu
 * @date 2018/7/25.
 */
public class JdbcConn {

    private static String url = jdbc.IniRead.iniFileRead(Thread.currentThread().getContextClassLoader().getResource("/").getPath()+"/Config.ini","DBServer" );
    public static Connection conn;
    public static Statement stmt;
    public static ResultSet rs;

    public static Connection getConnection() {

        try {

            //String filePath=Thread.currentThread().getContextClassLoader().getResource("/").getPath();
            //加载数据库驱动程序，对于jdbc4版本可以不用写这段代码
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //连接数据库
            conn = DriverManager.getConnection(url);
            //建立Statement对象
            //stmt = conn.createStatement();
            //执行数据库查询语句
            //rs = stmt.executeQuery(sql);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return conn;
    }
}
