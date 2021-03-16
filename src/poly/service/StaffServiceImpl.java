package poly.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poly.dao.AchievementDAO;
import poly.dao.ContractDAO;
import poly.dao.DepartmentDAO;
import poly.dao.DependentDAO;
import poly.dao.SalaryDAO;
import poly.dao.StaffDAO;
import poly.dao.UserDAO;
import poly.entity.Contract;
import poly.entity.Depart;
import poly.entity.Dependent;
import poly.entity.Record;
import poly.entity.Salary;
import poly.entity.Staff;
import poly.entity.User;
@Service
public class StaffServiceImpl implements StaffService {
	@Autowired
    private StaffDAO staffdao;
	@Autowired
    private ContractDAO contractdao;
	@Autowired
    private DepartmentDAO departmentdao;
	@Autowired
    private AchievementDAO achievementdao;
	@Autowired
   private SalaryDAO salarydao;
	@Autowired
	   private DependentDAO dependent;
	@Autowired
	   private UserDAO user;



    public List<Staff> listStaff(Integer offset, Integer maxResult) {
        return staffdao.listStaff(offset, maxResult);
    }

    public Long count() {
        return staffdao.count();
    }

	@Override
	public List<Contract> listContract(Integer offset, Integer maxResult) {
		 return contractdao.listContract(offset, maxResult);
	
	}
	public Long count1() {
        return contractdao.count1();
    }

	@Override
	public List<Depart> listDepartment(Integer offset, Integer maxResult) {
		 return departmentdao.listDepartment(offset, maxResult);
	
	}

	@Override
	public Long count2() {
		   return departmentdao.count2();
	}

	@Override
	public List<Record> listAchievement(Integer offset, Integer maxResult) {
		 return achievementdao.listAchievement(offset, maxResult);
	}

	@Override
	public Long count3() {
		 return achievementdao.count3();
	}

	@Override
	public List<Salary> listSalary(Integer offset, Integer maxResult) {
		return salarydao.listSalary(offset, maxResult);
	
	}

	@Override
	public Long count4() {
		
		return salarydao.count4();
	}

	@Override
	public List<Dependent> listDependent(Integer offset, Integer maxResult) {
		return dependent.listDependent(offset, maxResult);
	}

	@Override
	public Long count5() {
		return dependent.count5();
	}

	@Override
	public List<User> listUser(Integer offset, Integer maxResult) {
	return user.listUser(offset, maxResult);
	}

	@Override
	public Long count6() {
	return user.count6();
	}


}
