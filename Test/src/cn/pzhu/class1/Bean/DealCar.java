package cn.pzhu.class1.Bean;

import java.beans.beancontext.BeanContextMembershipListener;

public class DealCar {
	/**
	 * 
	 * @param Car_id
	 * @param Car_name
	 * @param Car_type
	 * @param Car_price
	 * @param car
	 * @return
	 */
	public boolean DealCar(String Car_id,String Car_name,String Car_type,String Car_price,Car car) {
		try {
			int id=Integer.parseInt(Car_id);
			double price=Double.parseDouble(Car_price);
			String name=Car_name;
			String type=Car_type;
			if(name==null&&type==null){
				throw new Exception();
			}else{
				car.setId(id);
				car.setName(name);
				car.setType(type);
				car.setPrice(price);
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	/**
	 * 
	 * @param sid
	 * @return
	 */
	public Integer DealCar(String sid){
		boolean flag=true;
		Integer id=0;
		try {
			id=Integer.parseInt(sid);
		} catch (Exception e) {
			id=0;
		}
		return id;
	}

}
