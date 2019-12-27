package generidao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import cn.pzhu.class1.Bean.User;
import util.DBUtil;

public class UserDAOimp implements UserDAO {

	@Override
	public boolean add(User data) {
		boolean flag=false;
		Connection con =DBUtil.getConnection();
		String username = data.getName();
		String password = data.getPassword();
//		String sql = "select * from users where name = '"+ username +"'  AND password='"+ password +"'";
		String sql = "INSERT INTO test (name, password) VALUES (?, ?)";
		PreparedStatement sta = null;
		//ResultSet res =null;
		try {
			// 4.创建命令对象
			//		Statement sta = con.createStatement();
			sta = con.prepareStatement(sql);
			// 5.发送命令并执行
			//		ResultSet res = sta.executeQuery(sql);
			sta.setString(1, username);
			sta.setString(2, password);
			if(sta.executeUpdate()>0){
				flag=true;
			};
			
			// 6.处理结果
			/*if (res.next()) {
				flag = true;
			}*/
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//7.释放资源
			DBUtil.close(sta, con);
		//	res.close();
		//	sta.close();
		//	con.close();
		}
		return flag;
	}
	

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updata(User data) {
		boolean flag=false;
		Connection con =DBUtil.getConnection();
		String username = data.getName();
		String password = data.getPassword();
//		String sql = "select * from users where name = '"+ username +"'  AND password='"+ password +"'";
		String sql = "UPDATE test SET password = ? WHERE name = ?";
		PreparedStatement sta = null;
		//ResultSet res =null;
		try {
			// 4.创建命令对象
			//		Statement sta = con.createStatement();
			sta = con.prepareStatement(sql);
			// 5.发送命令并执行
			//		ResultSet res = sta.executeQuery(sql);
			sta.setString(1, password);
			sta.setString(2, username);
			if(sta.executeUpdate()>0){
				flag=true;
			};
			
			// 6.处理结果
			/*if (res.next()) {
				flag = true;
			}*/
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//7.释放资源
			DBUtil.close(sta, con);
		//	res.close();
		//	sta.close();
		//	con.close();
		}
		return flag;
	}

	@Override
	public ArrayList<User> findall() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findid(String id) {
		User user=new User();
		Connection con =DBUtil.getConnection();
		String username = user.getName();
		String password = user.getPassword();
//		String sql = "select * from users where name = '"+ username +"'  AND password='"+ password +"'";
		String sql = "SELECT * FROM test WHERE name=?";
		PreparedStatement sta = null;
		ResultSet res =null;
		
		try {
			// 4.创建命令对象
			//		Statement sta = con.createStatement();
			sta = con.prepareStatement(sql);
			// 5.发送命令并执行
			//		ResultSet res = sta.executeQuery(sql);
			sta.setString(1, id);
			res = sta.executeQuery();
			
			// 6.处理结果
			if(res.next()==true){
				user = new User(id,res.getString(2));
			}else {
				user=null;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//7.释放资源
			DBUtil.close(res, sta, con);
		//	res.close();
		//	sta.close();
		//	con.close();
		}
		return user;
	}

	
	@Override
	
	public boolean fundByUser(User user) {
		boolean flag=false;
		Connection con =DBUtil.getConnection();
		String username = user.getName();
		String password = user.getPassword();
		//	String sql = "select * from users where name = '"+ username +"'  AND password='"+ password +"'";
		String sql = "SELECT * FROM test WHERE name=? AND password=?";
		
		PreparedStatement sta = null;
		ResultSet res =null;
		
		
		try {
			// 4.创建命令对象
			//		Statement sta = con.createStatement();
			sta = con.prepareStatement(sql);
			// 5.发送命令并执行
			//		ResultSet res = sta.executeQuery(sql);
			sta.setString(1, username);
			sta.setString(2, password);
			res = sta.executeQuery();
			
			// 6.处理结果
			if (res.next()) {
				flag = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//7.释放资源
			DBUtil.close(res, sta, con);
		//	res.close();
		//	sta.close();
		//	con.close();
		}
		return flag;
	}

}
