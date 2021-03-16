package poly.dao;

import java.io.Serializable;
import java.util.List;

public interface StatisticalDAO extends Serializable {
	public List<Object> top10Staff();
	public List<Object> listnameStaff();
	public List<Object> totalStaff();
	public List<Object> totalDepartment();
	public List<Object> totalSalary();
	public List<Object> listDepartment();
	public List<Object> Staffsalary();
	public List<Object> Departmentsalary();
	public List<Object> DateDiff();
	public List<Object> totalContract();
	public List<Object> totalRecord();
	public List<Object> totalRecord1();
	public List<Object> totalDependent();
	List<Object> totalstaffachievement(String id);
	List<Object> totalstaffachievement1(String id);
	List<Object> totalstaffachievement2(String id);

}
