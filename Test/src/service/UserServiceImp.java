package service;

import cn.pzhu.class1.Bean.User;
import generidao.UserDAO;
import generidao.UserDAOimp;

public class UserServiceImp implements UserService{

	@Override
	public boolean login(User user) {
		// TODO Auto-generated method stub
		boolean flag=false;
		//调用DAO层的接口给来实现业务
		UserDAO dao=new UserDAOimp();
		flag=dao.fundByUser(user);
		return flag;
	}

	@Override
	public boolean regist(User user) {
		boolean flag=false;
		//调用dao层接口实现业务
		UserDAO dao= new UserDAOimp();
		if(dao.findid(user.getName())==null&&dao.add(user)){
			flag=true;
		}
		return flag;
	}

	@Override
	public boolean changePwd(User user) {
		boolean flag=false;
		UserDAO dao= new UserDAOimp();
		if(dao.updata(user)){
			flag=true;
		}
		return flag;
	}

	@Override
	public boolean findUser(String id) {
		boolean flag=false;
		//调用dao层接口实现业务
		UserDAO dao= new UserDAOimp();
		if(dao.findid(id)!=null){
			flag=true;
		}
		return flag;
	}

	@Override
	public String findpasswd(String id) {
		User user =new User();
		//调用dao层接口实现业务
		UserDAO dao= new UserDAOimp();
		user=dao.findid(id);
		if(user!=null){
			return user.getPassword();
		}
		return null;
	}

	

}
