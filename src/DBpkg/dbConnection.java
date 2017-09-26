/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DBpkg;

import java.sql.*;

/**
 *
 * @author Banu Nissanka
 */
public class dbConnection {

    public static Connection createDatabaseConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql:///examdb", "root", "root");
        return conn;
    }
}


