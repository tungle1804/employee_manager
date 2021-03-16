package poly.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import poly.dao.DepartmentDAO;
import poly.dao.DependentDAO;
import poly.dao.SalaryDAO;
import poly.dao.StaffDAO;
import poly.dao.StatisticalDAO;
import poly.dao.UserDAO;
import poly.entity.Depart;
import poly.entity.Record;
import poly.entity.Salary;
import poly.entity.Staff;
import poly.entity.User;

@Transactional
@Controller
@RequestMapping("/home/")
public class ClientController {
	@Autowired
	SessionFactory factory;
	@Autowired
	@Qualifier("StatisticalDAO")
    private StatisticalDAO statisticaldao;
	@Autowired
	@Qualifier("UserDAO")
    private UserDAO userdao;
	@Autowired
	@Qualifier("StaffDAO")
    private StaffDAO staffdao;
	@Autowired
	@Qualifier("SalaryDAO")
	private SalaryDAO salarydao;
	@Autowired
	@Qualifier("DepartmentDAO")
	private DepartmentDAO departDAO;
	@RequestMapping("personal")
	public String StaffList(ModelMap modelMap) {
		org.hibernate.Session session = factory.getCurrentSession();
		
		List<Object> list = statisticaldao.listnameStaff();
		modelMap.addAttribute("personal", list);
		return "client/personal";
	}
	@RequestMapping("department")
	public String DepartmentList(ModelMap modelMap) {			
		List<Object> list = statisticaldao.listDepartment();
		modelMap.addAttribute("department1", list);
		return "client/department-list";
	}
	
	@ModelAttribute("departss")
	public List<Depart> getMajor() {

		List<Depart> depart = departDAO.listfromDepartment();
		return depart;
	}
	@ModelAttribute("totalstaffachievement")
	public List<Object> totalstaffachievement(HttpSession session) {
		String id = (String) session.getAttribute("id");

		List<Object> totalstaff = statisticaldao.totalstaffachievement(id) ;
		return totalstaff;
	}
	@ModelAttribute("totalstaffachievement1")
	public List<Object> totalstaffachievement1(HttpSession session) {
		String id = (String) session.getAttribute("id");

		List<Object> totalstaff = statisticaldao.totalstaffachievement1(id) ;
		return totalstaff;
	}
	@ModelAttribute("totalstaffachievement2")
	public List<Object> totalstaffachievement2(HttpSession session) {
		String id = (String) session.getAttribute("id");

		List<Object> totalstaff = statisticaldao.totalstaffachievement2(id) ;
		return totalstaff;
	}
	@ModelAttribute("salaryss")
	public List<Salary> getSalary() {
		List<Salary> salary = salarydao.listfromSalary();
		return salary;

	}
	@RequestMapping("client")
	public String index1(ModelMap model,HttpSession session) {
		List<Object> list = statisticaldao.top10Staff();
		model.addAttribute("top", list);
		session.setAttribute("role", true);
		return "client/client";
	}
	@RequestMapping("edit-information")
	public String geteditinformation(HttpServletRequest request, ModelMap model,HttpSession sessions) {
	String id = (String) sessions.getAttribute("id");
	Staff staff = staffdao.infoStaff(id);
		model.addAttribute("user", staff);
		return "client/infomation-client";
	}
	@RequestMapping(value = "edit-infomation", method = RequestMethod.POST)
	public String getedituserinformation(HttpServletRequest request, ModelMap model, @ModelAttribute("user") Staff staff) {
		if (staffdao.editStaff(staff)) {
			model.addAttribute("Alert",  "Sửa phòng ban thành công");
		
	} else {
		model.addAttribute("Alert",  "Phòng ban đã tồn tại");
	}
		return "redirect:/home/client.htm";
	}
}
