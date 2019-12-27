package generidao;

import java.util.ArrayList;



public interface GnericDAO<E,key> {
	//增删改查
	public boolean add(E data);
	
	public boolean delete(key id);
	
	public boolean updata(E data);
	
	public ArrayList<E> findall();
	
	public E findid(key id);
	
}
