package service;

import java.util.ArrayList;

import cn.pzhu.class1.Bean.Car;
import generidao.CarDAO;
import generidao.CarDAOimp;

public class CarServiceimp implements CarService{

	@Override
	public ArrayList<Car> showAllcar() {
		CarDAO dao=new CarDAOimp();
		return dao.findall();
	}

	@Override
	public boolean updataCar(Car car) {
		boolean flag=false;
		CarDAO dao=new CarDAOimp();
		if(dao.updata(car))
			flag=true;
		return flag;
	}

	@Override
	public boolean insertCar(Car car) {
		boolean flag=false;
		CarDAO dao=new CarDAOimp();
		if(dao.add(car))
			flag=true;
		return flag;
	}

	@Override
	public boolean deleteCar(Integer id) {
		boolean flag=false;
		CarDAO dao=new CarDAOimp();
		if(dao.delete(id))
			flag=true;
		return flag;
	}

	@Override
	public Car idquery(Integer id) {
		Car car=new Car();
		CarDAO dao = new CarDAOimp();
		return dao.findid(id);
	}

	@Override
	public ArrayList<Car> fuzzyquery(String str) {
		CarDAO dao = new CarDAOimp();
		return dao.fuzzycar(str);
	}

}
