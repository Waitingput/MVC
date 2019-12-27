package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.jdbc.Statement;



/**
 * @author Xiaoyi
 *
 */
public class DBUtil {
	private static String driver=null;
	private static String url=null;
	private static String user=null;
	private static String password=null;
	//注册驱动
	static{//获取数据库连接信息
		InputStream in = DBUtil.class.getClassLoader().getResourceAsStream("db.properties");
		Properties pro = new Properties();
		try {
			pro.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		driver = pro.getProperty("driver");
		url = pro.getProperty("url");
		user = pro.getProperty("user");
		password = pro.getProperty("password");
		
		try {//注册驱动
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//获取连接
	public static Connection getConnection(){
		try {
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	//释放资源
	/**
	 * 对资源的释放
	 * @param resultSet	结果集
	 * @param statement	预编译命令对象
	 * @param connection	数据库连接
	 */
	public static void close( ResultSet resultSet,Statement statement,Connection connection){
		if(resultSet!=null){
			try {
				resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(statement!=null){
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(connection!=null){
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/**
	 * 
	 * @param resultSet 结果集
	 * @param statement 预编译处理对象
	 * @param connection 数据库连接对象
	 */
	public static void close( ResultSet resultSet,PreparedStatement statement,Connection connection){
		if(resultSet!=null){
			try {
				resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(statement!=null){
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(connection!=null){
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/**
	 * 
	 * @param statement 预处理对象
	 * @param connection 数据库连接对象
	 */
	public static void close(Statement statement,Connection connection){
		if(statement!=null){
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(connection!=null){
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/**
	 * 
	 * @param statement 预处理对象
	 * @param connection 数据库连接对象
	 */
	public static void close(PreparedStatement statement,Connection connection){
		if(statement!=null){
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(connection!=null){
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
}
