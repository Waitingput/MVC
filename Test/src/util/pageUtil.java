package util;

import java.util.ArrayList;

import cn.pzhu.class1.Bean.Car;

public class pageUtil {
	public static ArrayList<Car> pageCars(ArrayList<Car> cars,int page,int num){
		ArrayList<Car> list = new ArrayList<>();
		for(int i=(page-1)*num;i<page*num&&i<cars.size();i++){
			list.add(cars.get(i));
		}
		return list;
	}

	public static StringBuffer creatBar(ArrayList<Car> list, int page, int num) {
		StringBuffer bar=new StringBuffer();
		int count = (list.size()-1)/num+1;//总页数
		if(page<1){
			page=1;
		}
		if(page>count){
			page=count;
		}
		if(page>1){
			bar.append("<a href='SelectAllCar?page="+(page-1)+"&num="+num+"'>"+"上一页</a> ");
		}
		
		for(int i=1;i<=count;i++){
			if(i!=page){
				
				bar.append("<a href='SelectAllCar?page="+i+"&num="+num+"'>"+i+"</a>"+" ");
			}else{
				bar.append("["+i+"]");
			}
			
		}
		if(page<count){
			bar.append("<a href='SelectAllCar?page="+(page+1)+"&num="+num+"'>"+"下一页</a> ");
		}

		return bar;
	}

}
