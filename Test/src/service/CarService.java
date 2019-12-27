package service;

import java.util.ArrayList;

import cn.pzhu.class1.Bean.Car;

public interface CarService {
	public ArrayList<Car> showAllcar();
	public boolean updataCar(Car car);
	public boolean insertCar(Car car);
	public boolean deleteCar(Integer id);
	public Car idquery(Integer id);
	public ArrayList<Car> fuzzyquery(String str);
}
