package tools.descartes.teastore.auth.security;

import java.sql.*;

public class SQLTest {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://8.219.217.128:3306/teadb";
        String username = "teauser";
        String pwd = "teapassword";
        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, username, pwd);
        Long userId = null;
        String name = "user50";
        String password = "$2a$06$9W6QVlk8aE.Kq0VtEX.2VeF8iFbedkfPhzN5cNvVVdU0uHBNN/pZO";
        String sql = "select ID from PERSISTENCEUSER where USERNAME = ? and PASSWORD = ? or 1 = 1";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setString(1, name);
        pst.setString(2, password);
        ResultSet rs = pst.executeQuery();
        while(rs.next()) {
            userId = rs.getLong(1);
        }
        System.out.println(userId);
    }
}
