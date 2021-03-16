package poly.dao;

import java.io.Serializable;
import java.util.List;

import poly.entity.Staff;

public interface StaffDAO extends Serializable {

	public List<Staff> searchStaff(String search);

	public List<Staff> listStaff(Integer offset, Integer maxResult);
	public List<Staff> listfromStaff();
	public Long count();

	public Staff infoStaff(String id);
	public Staff infoStaffEmail(String Email);
	public boolean editStaff(Staff staff);

	
	public boolean creatStaff(Staff Staff);
	public boolean deleteStaff(String id);

	int checkCodeId(String codeId);

	int checkEmail(String email);

	int Staffrecord(String id);

	int Staffcontract(String id);
	public List<Object> staffdepartment(String id);

	



}
