package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Utils {
    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/test";
    private static String username = "root";
    private static String password = "123456789";
    private static Connection connection = null;

    static {
        try {
            //1.注册驱动
            //2.不要把connection=getConnection(url,username,password)放在这里，
            // 因为这样每次都是同一个connection，静态模块只会加载一次
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() {
        try {
            connection = (Connection) DriverManager.getConnection(url,username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return connection;
        }
    }
    public static void main(String[] args) {
        connection = getConnection();
        if (connection != null) {
            System.out.println("连接成功");
        } else {
            System.out.println("连接失败");
        }
    }
}
