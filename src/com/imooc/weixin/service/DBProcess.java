package service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.imooc.weixin.util.DB2Entity;
import jdbc.JdbcConn;

/**
 * @author conshu
 * @date 2018/7/25.
 */
public class DBProcess {

    private Connection dbconn;
    private Statement stmt;
    private ResultSet rs;
    private String sql;
    private String rString;

    public String getPayRoller() {

        sql = "select top 20 yymmdd,empno,0 reqovertime,id from v_web_overtime_report";
        rString=null;
        try (Connection dbconn = JdbcConn.getConnection()) {
            stmt = dbconn.createStatement();
            rs = stmt.executeQuery(sql);
            rString=DB2Entity.DB2String(rs,"  ");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rString;
    }
}
