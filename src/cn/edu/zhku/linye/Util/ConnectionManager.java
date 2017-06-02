package cn.edu.zhku.linye.Util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionManager {
	
	private static String driverName= "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://127.0.0.1:3306/web_shop?unicode=true&characterEncoding=utf-8";
	private static String userName = "root";
	private static String password = "";
	
	public static Connection getConnection() throws Exception {
		Connection con = null;
		//通过反射机制动态的引入应用的数据库的驱动
		Class.forName( ConnectionManager.driverName );
		con = DriverManager.getConnection(ConnectionManager.url,ConnectionManager.userName,ConnectionManager.password);
		return con;
	}

}
