/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dbsetting;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class DBTest {

    static String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";  //加载JDBC驱动
    public static String test(String host, String port, String db, String userName, String userPwd) {
        String dbURL = "jdbc:sqlserver://" + host + ":" + port + ";DatabaseName=" + db;
        Connection conn = null;
        try {
            Class.forName(driverName);
            conn = DriverManager.getConnection(dbURL, userName, userPwd);
            System.out.println("Connection Successful!"); 
            return "连接成功";
        } catch (Exception e) {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
            }
            return "连接失败";
        }
    }
}
