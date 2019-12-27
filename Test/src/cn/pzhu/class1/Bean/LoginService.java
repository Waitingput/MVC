package cn.pzhu.class1.Bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import service.UserService;
import service.UserServiceImp;
import util.DBUtil;



public class LoginService {
	public boolean login(User user){
		Boolean flag = false;
		UserService service=new UserServiceImp();
		flag = service.login(user);
		return flag;
		/*		
 		// 1.注册驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		// 2.建立连接
		/*String db_url = "jdbc:mysql://localhost:3306/test";
		String db_user = "root";
		String db_pwd = "11111";*/
		
/*		
		try {
			
		//Connection con = DriverManager.getConnection(db_url,db_user,db_pwd);
			
		//调用DBUtil包方法处理数据库连接
		Connection con =DBUtil.getConnection();
			
			// 3.编写SQL语句
			String username = user.getName();
			String password = user.getPassword();
			//直接传参
			//String sql = "select * from users where name = '"+ username +"'  AND password='"+ password +"'";
			String sql = "SELECT * FROM test WHERE name=? AND password=?";
			
			// 4.创建命令对象
			//Statement sta = con.createStatement();
			PreparedStatement sta = con.prepareStatement(sql);
			// 5.发送命令并执行
			//ResultSet res = sta.executeQuery(sql);
			
			sta.setString(1, username);
			sta.setString(2, password);
			
			ResultSet res = sta.executeQuery();
			// 6.处理结果
			if(res.next()) {
				flag = true;
			}
			res.close();
			sta.close();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print(user.getName()+user.getPassword());
		return flag;
		
*/		
		/*if(user.getPassword().equals("12345")&&user.getName().equals("zhangsan"))
		return true;
		else {
			return false;
		}*/
	}
	
	
	//1.注册驱动
	//2.建立链接
	//3.编写sql语句
	//4.创建命令对象
	//5.发送命令对象
	//处理结果

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
