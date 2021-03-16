package poly.dao;

import java.io.Serializable;
import java.util.List;

import poly.entity.Staff;
import poly.entity.User;

public interface UserDAO extends Serializable{
	public List<User> searchUser(String search);

	public List<User> listUser(Integer offset, Integer maxResult);

	public Long count6();

	public User infoUser(String id);

	public boolean editUser(User user);

	
	public boolean creatUser(User user);
	public boolean deleteUser(String id);
	
	public boolean checkUser(String Username , String Password);
	public boolean checkRole(String Username , String Password);

	int checkname(String name);
	
}
