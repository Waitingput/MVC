package generidao;

import java.util.ArrayList;

import cn.pzhu.class1.Bean.Car;

public interface CarDAO extends GnericDAO<Car, Integer>{
	public ArrayList<Car> fuzzycar (String str);
}
