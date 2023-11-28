/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package springHibernate;

import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;
import com.mysql.cj.jdbc.MysqlDataSource;
//import com.mysql.cj.jdbc.Driver;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Tamcin
 */
public class Koneksi {
    static Connection c;
    
    public static Connection connection(){
        if(c == null) {
            MysqlDataSource data = new MysqlConnectionPoolDataSource();
            data.setDatabaseName("belajar");
            data.setUser("root");
            data.setPassword("");
            try {
                c = data.getConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return c;
    }
}
