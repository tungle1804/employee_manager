package poly.dao;

import java.io.Serializable;
import java.util.List;

import poly.entity.Depart;
import poly.entity.Staff;

public interface DepartmentDAO extends Serializable {
	
	public List<Depart> listDepartment(Integer offset, Integer maxResult);
	public List<Depart> listfromDepartment();
	public Long count2();
	public List<Depart> searchDepart(String search);
	public boolean creatDepartment(Depart depart);
	public boolean deleteDepartment(String id);
	public Depart infoDepartment(String id);
	public boolean editDepartment(Depart depart);
	int checkCodeId(String codeId);
	int departstaff(String id);
	
}
