package service;

import cn.pzhu.class1.Bean.User;

public interface UserService {
	public boolean login(User user);
	public boolean regist(User user);
	public boolean changePwd(User user);
	public boolean findUser (String id);
	public String findpasswd(String id);
}
