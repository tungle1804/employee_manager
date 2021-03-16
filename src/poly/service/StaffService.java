package poly.service;

import java.io.Serializable;
import java.util.List;

import poly.entity.Contract;
import poly.entity.Depart;
import poly.entity.Dependent;
import poly.entity.Record;
import poly.entity.Salary;
import poly.entity.Staff;
import poly.entity.User;

public interface StaffService extends Serializable{
	public List<Staff> listStaff(Integer offset, Integer maxResult);
    public Long count();
    public List<Contract> listContract(Integer offset, Integer maxResult);
    public Long count1();
    public List<Depart> listDepartment(Integer offset, Integer maxResult);
    public Long count2();
    public List<Record> listAchievement(Integer offset, Integer maxResult);
    public Long count3();
   public List<Salary> listSalary(Integer offset, Integer maxResult);
   public Long count4();
   public List<Dependent> listDependent(Integer offset, Integer maxResult);
   public Long count5();
   public List<User> listUser(Integer offset, Integer maxResult);
   public Long count6();
}
