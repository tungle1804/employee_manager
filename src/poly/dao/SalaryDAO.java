package poly.dao;

import java.io.Serializable;
import java.util.List;

import poly.entity.Salary;
import poly.entity.Staff;


public interface SalaryDAO extends Serializable {
	
	public List<Salary> listSalary(Integer offset, Integer maxResult);
	public List<Salary> listfromSalary();
	public Long count4();
	public boolean creatSalary(Salary salary);
	public boolean deleteSalary(String id);
	public Salary infoSalary(String id);
	public boolean editSalary(Salary salary);
	int checkidsalary(String codeId);
	int Salarystaff(String id);

}
