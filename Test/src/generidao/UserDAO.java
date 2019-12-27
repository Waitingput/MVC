package generidao;

import cn.pzhu.class1.Bean.User;

public interface UserDAO extends GnericDAO<User, String> {
	public boolean fundByUser(User user);
}
