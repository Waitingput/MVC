package generidao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import cn.pzhu.class1.Bean.Car;
import util.DBUtil;

public class CarDAOimp implements CarDAO{

	@Override
	public boolean add(Car data) {
		boolean flag=false;
		Connection con =DBUtil.getConnection();
		int id = data.getId();
		String name = data.getName();
		String type = data.getType();
		double price = data.getPrice();
		String sql = "INSERT INTO car (id, name, type, price) VALUES (?, ?, ?, ?)";
		PreparedStatement sta = null;
		//ResultSet res =null;
		try {
			// 4.创建命令对象
			//		Statement sta = con.createStatement();
			sta = con.prepareStatement(sql);
			// 5.发送命令并执行
			//		ResultSet res = sta.executeQuery(sql);
			sta.setInt(1, id);
			sta.setString(2, name);
			sta.setString(3, type);
			sta.setDouble(4, price);
			if(sta.executeUpdate()>0){
				flag=true;// 6.处理结果
			};
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//7.释放资源
			DBUtil.close(sta, con);
		}
		return flag;
	}

	@Override
	public boolean delete(Integer id) {
		boolean flag=false;
		Connection con =DBUtil.getConnection();
		String sql="DELETE FROM car WHERE id = ?";
		PreparedStatement sta = null;
		try {
			sta = con.prepareStatement(sql);
			sta.setInt(1, id);
			if(sta.executeUpdate()>0){
				flag = true;
			}
		} catch (SQLException e) {
			System.out.print("数据库删除失败");
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean updata(Car data) {
		boolean flag=false;
		Connection con =DBUtil.getConnection();
		int id= data.getId();
		String name=data.getName();
		String type = data.getType();
		Double price = data.getPrice();
		String sql="UPDATE car SET name = ? , type = ? , price = ? WHERE id = ?";
		PreparedStatement sta = null;
		try {
			sta = con.prepareStatement(sql);
			sta.setString(1, name);
			sta.setString(2, type);
			sta.setDouble(3, price);
			sta.setInt(4, id);
			if(sta.executeUpdate()>0){
				flag = true;
			}
		} catch (SQLException e) {
			System.out.print("数据库跟新失败");
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public ArrayList<Car> findall() {

		ArrayList<Car> list=new ArrayList<>();
		Connection con = DBUtil.getConnection();
		Statement sta=null;
		ResultSet res=null;
		try {
			sta = con.createStatement();
			String sql="select * from car";
			res = sta.executeQuery(sql);
			//循环遍历添加car->list
			while(res.next()){
				Car car=new Car();
				car.setId(res.getInt(1));
				car.setName(res.getString(2));
				car.setType(res.getString(3));
				car.setPrice(res.getDouble(4));
				list.add(car);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("数据库查询执行异常");
		}
		return list;
	}

	@Override
	public Car findid(Integer id) {
		Car car= new Car();
		Connection con = DBUtil.getConnection();
		PreparedStatement sta=null;
		ResultSet res=null;
		String sql="select * from car where id = ?";
		try {
			sta = con.prepareStatement(sql);
			sta.setInt(1, id);
			res = sta.executeQuery();
			res.next();
			car.setId(res.getInt(1));
			car.setName(res.getString(2));
			car.setType(res.getString(3));
			car.setPrice(res.getDouble(4));
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("数据库id查询执行异常");
		}
		return car;
	}

	@Override
	public ArrayList<Car> fuzzycar(String str) {
		ArrayList<Car> list=new ArrayList<>();
		Connection con = DBUtil.getConnection();
		PreparedStatement sta=null;
		ResultSet res=null;
		String sql="select * from car where id like concat('%',?,'%') or name like concat('%',?,'%') or type like concat('%',?,'%') or price like concat('%',?,'%')";
		try {
			
			sta = con.prepareStatement(sql);
			sta.setString(1, str);
			sta.setString(2, str);
			sta.setString(3, str);
			sta.setString(4, str);
			res = sta.executeQuery();
			//循环遍历添加car->list
			while(res.next()){
				Car car=new Car();
				car.setId(res.getInt(1));
				car.setName(res.getString(2));
				car.setType(res.getString(3));
				car.setPrice(res.getDouble(4));
				list.add(car);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.print("数据库模糊查询失败");
			// TODO: handle exception
		}
		return list;
	}
	
	
}
