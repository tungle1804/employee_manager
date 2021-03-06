package poly.controller;

import java.awt.PageAttributes.MediaType;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import poly.dao.AchievementDAO;
import poly.dao.ContractDAO;
import poly.dao.DepartmentDAO;
import poly.dao.DependentDAO;
import poly.dao.SalaryDAO;
import poly.dao.StaffDAO;
import poly.dao.StatisticalDAO;
import poly.dao.UserDAO;
import poly.entity.Contract;
import poly.entity.Depart;
import poly.entity.Dependent;
import poly.entity.Record;
import poly.entity.Salary;
import poly.entity.Staff;
import poly.entity.User;
import poly.service.StaffService;

@Transactional
@Controller
@RequestMapping("/admin/")
public class AdminController {
	@Autowired
	SessionFactory factory;

	@Autowired
	@Qualifier("StaffDAO")
	private StaffDAO staffDAO;
	@Autowired
	@Qualifier("ContractDAO")
	private ContractDAO contractDAO;
	@Autowired
	private StaffService staffService;
	@Autowired
	@Qualifier("DepartmentDAO")
	private DepartmentDAO departDAO;
	@Autowired
	@Qualifier("AchievementDAO")
	private AchievementDAO achievementDAO;
	@Autowired
	@Qualifier("SalaryDAO")
	private SalaryDAO salarydao;
	@Autowired
	@Qualifier("DependentDAO")
	private DependentDAO dependentdao;
	@Autowired
	@Qualifier("UserDAO")
	private UserDAO userdao;
	@Autowired
	@Qualifier("StatisticalDAO")
	private StatisticalDAO statisticaldao;

	@RequestMapping(value = "search", method = RequestMethod.GET)
	public String search(ModelMap model, @RequestParam("search") String search, HttpServletRequest request) {

		model.addAttribute("staffs", staffDAO.searchStaff(search));
		return "static/staff";
	}

	@RequestMapping(value = "search-user", method = RequestMethod.GET)
	public String searchuser(ModelMap model, @RequestParam("search") String search) {

		model.addAttribute("users", userdao.searchUser(search));
		return "static/list-user";
	}

	@RequestMapping(value = "search-department", method = RequestMethod.GET)
	public String searcdepartment(ModelMap model, @RequestParam("search") String search) {

		model.addAttribute("departs", departDAO.searchDepart(search));
		return "static/department";
	}

	@RequestMapping(value = "search-contract", method = RequestMethod.GET)
	public String searchcontract(ModelMap model, @RequestParam("search") String search) {

		model.addAttribute("contracts", contractDAO.searchContract(search));
		return "static/list-contract";
	}

	@RequestMapping(value = "search-record", method = RequestMethod.GET)
	public String searcrecord(ModelMap model, @RequestParam("search") String search) {

		model.addAttribute("records", achievementDAO.searchAchievement(search));
		return "static/achievement";
	}

	@RequestMapping("static")
	public String index1(ModelMap model,HttpSession session) {

		List<Object> listS = statisticaldao.top10Staff();
		model.addAttribute("top", listS);
		session.setAttribute("role", false);
		return "static/admin";
	}

	@RequestMapping("dayleft")
	public String dayleft(ModelMap model) {

		List<Object> listS = statisticaldao.DateDiff();
		model.addAttribute("dayleft1", listS);

		return "static/dayleft";
	}

	@RequestMapping("user")
	public String index(ModelMap model,HttpSession session, Integer offset, Integer maxResults) {

		List<User> list = staffService.listUser(offset, maxResults);
		model.addAttribute("users", list);
		model.addAttribute("count", staffService.count6());
		model.addAttribute("offset", offset);
		
		return "static/list-user";
	}

	@RequestMapping(value = "add-user", method = RequestMethod.GET)
	public String adduser(ModelMap model) {
		model.addAttribute("user", new User());
		return "static/add-user";
	}

	@RequestMapping(value = "add-user", method = RequestMethod.POST)
	public String insert(ModelMap model, @Validated @ModelAttribute("user") User user, BindingResult error) {

		if (user.getUsername().trim().length() == 0) {
			error.rejectValue("username", "user", "Vui l??ng nh???p T??n t??i kho???n !");
		} else if (user.getUsername().indexOf(" ") > 0) {
			error.rejectValue("username", "user", "T??n t??i kho???n kh??ng c?? kho???ng tr???ng !");
		} else if (userdao.checkname(user.getUsername()) > 0) {
			error.rejectValue("username", "user", "T??n t??i kho???n ???? t???n t???i !");
		} else if (staffDAO.checkEmail(user.getUsername()) <= 0) {
			error.rejectValue("username", "user", "T??n ????ng nh???p ph???i tr??ng v???i email !");
		}
		if (user.getFullname().trim().length() == 0) {
			error.rejectValue("fullname", "user", "Vui l??ng ??i???n h??? t??n!");
		}if(user.getFullname().length()>50) {
			error.rejectValue("fullname", "user", "Vu???t qu?? k?? t??? cho ph??p");
		}
		if (user.getPass().trim().length() == 0) {
			error.rejectValue("pass", "user", "Vui l??ng ??i???n m???t kh???u!");
		}
		if(user.getPass().length()>50) {
			error.rejectValue("pass", "user", "Vu???t qu?? k?? t??? cho ph??p");
		}

		if (error.hasErrors()) {
			model.addAttribute("message", error.toString());
			return "static/add-user";
		}
		try {

			if (userdao.creatUser(user)) {
				model.addAttribute("Alert", "Th??m t??i kho???n th??nh c??ng");

			}

		} catch (Exception e) {
			model.addAttribute("Alert", "Th??m t??i kho???n kh??ng th??nh c??ng");
		}
		return "static/add-user";
	}

	@RequestMapping("delete-user")
	public String getdeleteuser(@RequestParam("username") String username,HttpSession sessions, ModelMap model) {
		String id = (String) sessions.getAttribute("usernames");
		
		try {
			if(id.equals(username)) {
				model.addAttribute("Alert", "Xin l???i , kh??ng th??? x??a user ");
				return "error";
			}
			if (userdao.deleteUser(username)) {
				model.addAttribute("Alert", "X??a nh??n vi??n th??nh c??ng");
			}
		} catch (Exception e) {
			model.addAttribute("Alert", "X??a nh??n vi??n kh??ng th??nh c??ng");
		}

		return "redirect:/admin/user.htm";
	}

	@RequestMapping("edit-user")
	public String getedituser(ModelMap model, @RequestParam("username") String username) {

		User user = userdao.infoUser(username);
		model.addAttribute("user", user);
		return "static/edit-user";
	}

	@RequestMapping("edit-information")
	public String geteditinformation(HttpServletRequest request, ModelMap model, HttpSession sessions) {

		String username = (String) sessions.getAttribute("usernames");

		User user = userdao.infoUser(username);
		model.addAttribute("user", user);
		return "static/infomation-admin";
	}

	@RequestMapping(value = "edit-infomation", method = RequestMethod.POST)
	public String getedituserinformation(HttpServletRequest request, ModelMap model,
			@ModelAttribute("user") User user) {
		if (userdao.editUser(user)) {
			model.addAttribute("Alert", "S???a ph??ng ban th??nh c??ng");

		} else {
			model.addAttribute("Alert", "Ph??ng ban ???? t???n t???i");
		}
		return "redirect:/admin/static.htm";
	}

	@RequestMapping(value = "edit-user", method = RequestMethod.POST)
	public String getedituser1(HttpServletRequest request, ModelMap model, @ModelAttribute("user") User user, BindingResult error) {
		if (user.getFullname().trim().length() == 0) {
			error.rejectValue("fullname", "user", "Vui l??ng ??i???n h??? t??n!");
		}
		if (user.getPass().trim().length() == 0) {
			error.rejectValue("pass", "user", "Vui l??ng ??i???n m???t kh???u!");
		}

		if (error.hasErrors()) {
			model.addAttribute("message", error.toString());
			return "static/edit-user";
		}
		
		if (userdao.editUser(user)) {
			model.addAttribute("Alert", "S???a t??i kho???n th??nh c??ng");

		} else {
			model.addAttribute("Alert", "S???a t??i kho???n kh??ng th??nh c??ngi");
		}
		return "static/edit-user";
	}

	@RequestMapping("department")
	public String department(ModelMap model, Integer offset, Integer maxResults) {

		List<Depart> list = staffService.listDepartment(offset, maxResults);
		model.addAttribute("departs", list);

		model.addAttribute("count", staffService.count2());
		model.addAttribute("offset", offset);

		return "static/department";
	}

	@RequestMapping(value = "add-department", method = RequestMethod.GET)
	public String adddepartment(ModelMap model) {
		model.addAttribute("depart", new Depart());
		return "static/add-department";
	}

	@RequestMapping(value = "add-department", method = RequestMethod.POST)
	public String adddepartment1(ModelMap model, @Validated @ModelAttribute("depart") Depart depart,
			BindingResult error) {

		if (depart.getId().trim().length() == 0) {
			error.rejectValue("id", "depart", "Vui l??ng ??i???n m?? ph??ng ban !");
		} else if (depart.getId().indexOf(" ") > 0) {
			error.rejectValue("id", "depart", "M?? ph??ng ban kh??ng c?? kho???ng tr???ng !");
		} else if (departDAO.checkCodeId(depart.getId()) > 0) {
			error.rejectValue("id", "depart", "Xin l???i , M?? ph??ng ban b??? tr??ng!");
		}
		if (depart.getName().trim().length() == 0) {
			error.rejectValue("name", "depart", "Vui l??ng ??i???n t??n ph??ng ban !");
		}
		if (error.hasErrors()) {
			model.addAttribute("message", "Vui long dien day du cac thong tin !");
			return "static/add-department";
		}
		try {
			if (departDAO.creatDepartment(depart)) {
			
				model.addAttribute("Alert",  "Th??m ph??ng ban th??nh c??ng");

			}

		} catch (Exception e) {
			model.addAttribute("Alert", "Th??m ph??ng ban kh??ng th??nh c??ng");
		}

//		return "redirect:/admin/department.htm";
		return "static/add-department";
	}

	@RequestMapping("delete-department")
	public String getdeletedepartment(@RequestParam("id") String id, ModelMap modelMap) {
		try {
			if (departDAO.deleteDepartment(id)) {
				modelMap.addAttribute("Alert", "X??a ph??ng ban th??nh c??ng");
			} else {
				
				modelMap.addAttribute("Alert", "Xin l???i , kh??ng th??? x??a ph??ng ban ");
				return "error";
			}

		} catch (Exception e) {
			modelMap.addAttribute("Alert", "X??a ph??ng ban kh??ng th??nh c??ng");
		}

		return "redirect:/admin/department.htm";
	}

	@RequestMapping(value = "edit-department", method = RequestMethod.GET)
	public String editdepartment(ModelMap modelMap, @RequestParam("id") String id) {
		Depart depart = departDAO.infoDepartment(id);
		modelMap.addAttribute("depart", depart);
		return "static/edit-department";
	}

	@RequestMapping(value = "edit-department", method = RequestMethod.POST)
	public String getedituser1(HttpServletRequest request, ModelMap model, @ModelAttribute("depart") Depart depart,BindingResult error) {
		if (depart.getName().trim().length() == 0) {
			error.rejectValue("name", "depart", "Vui l??ng ??i???n t??n ph??ng ban !");
		}
		if (error.hasErrors()) {
			model.addAttribute("message", "Vui l??ng ??i???n ?????y ????? c??c th??ng tin !");
			return "static/edit-department";
		}
		
		if (departDAO.editDepartment(depart)) {
			model.addAttribute("Alert", "S???a ph??ng ban th??nh c??ng");

		} else {
			model.addAttribute("Alert", "Ph??ng ban ???? t???n t???i");
		}
		return "static/edit-department";
	}

	@RequestMapping("staff")
	public String staffHome(ModelMap modelMap, Integer offset, Integer maxResults) {
//		List<Staff> list = staffDAO.listStaff(offset, maxResults);
		List<Staff> list = staffService.listStaff(offset, maxResults);
		modelMap.addAttribute("staffs", list);
		modelMap.addAttribute("count", staffService.count());
		modelMap.addAttribute("offset", offset);

		return "static/staff";
	}

	@RequestMapping(value = "add-staff", method = RequestMethod.GET)
	public String adddstaff(ModelMap model) {
		model.addAttribute("staff", new Staff());

		return "static/add-staff";
	}

	@Autowired
	ServletContext context;

	@RequestMapping(value = "add-staff", method = RequestMethod.POST)
	public String adddepartment1(ModelMap model, @Validated @ModelAttribute(value = "staff") Staff staff,
			@RequestParam("img") MultipartFile photo, BindingResult error) throws IllegalStateException, IOException {
		if (photo.isEmpty()) {
			model.addAttribute("message", "Vui l??ng ch???n file !");
		} else {
			String path = context.getRealPath("/upload/" + staff.getId()) + photo.getOriginalFilename();

			staff.setPhoto(staff.getId() + photo.getOriginalFilename());
			photo.transferTo(new File(path));
		}
		if (staff.getId().trim().length() == 0) {
			error.rejectValue("id", "staff", "Vui l??ng nh???p m?? nh??n vi??n !");
		} else if (staff.getId().indexOf(" ") > 0) {
			error.rejectValue("id", "staff", "M?? nh??n vi??n kh??ng c?? kho???ng tr???ng !");
		} else if (staffDAO.checkCodeId(staff.getId()) > 0) {
			error.rejectValue("id", "staff", "M?? nh??n vi??n ???? t???n t???i !");
		}
		if (staff.getName().trim().length() == 0) {
			error.rejectValue("name", "staff", "Vui l??ng nh???p t??n nh??n vi??n !");
		}

		if (staff.getEmail().trim().length() == 0) {
			error.rejectValue("email", "staff", "Vui l??ng ??i???n email !");
		} else if (staff.getEmail().indexOf(" ") > 0) {
			error.rejectValue("email", "staff", "Email kh??ng c?? kho???ng tr???ng !");
		} else if (!staff.getEmail().endsWith("@gmail.com")) {
			error.rejectValue("email", "staff", "Email pph???i c?? ??u??i l?? '@gmail.com' !");
		} else if (staffDAO.checkEmail(staff.getEmail()) > 0) {
			error.rejectValue("email", "staff", "Email ???? t???n t???i !");
		}

		if (staff.getPhone().trim().length() == 0) {
			error.rejectValue("phone", "staff", "Vui l??ng ??i???n S??T !");
		}
//		if (staff.getBirthday().toString().length()==0) {
//			error.rejectValue("birthday", "staff", "Vui l??ng ??i???n ng??y sinh !");
//		}
		if (staff.getNotes().trim().length() == 0) {
			error.rejectValue("notes", "staff", "Vui l??ng ??i???n ghi ch?? !");
		}

		if (error.hasErrors()) {
			model.addAttribute("message", error.toString());

			return "static/add-staff";
		}
		if (staffDAO.creatStaff(staff)) {
			model.addAttribute("Alert", "Th??m nh??n vi??n th??nh c??ng");

		} else {
			model.addAttribute("Alert", "Th??m nh??n vi??n kh??ng th??nh c??ng");
		}

		;
		return "static/add-staff";

	}

	@RequestMapping("delete-staff")
	public String getdeletestaff(@RequestParam("id") String id, ModelMap modelmap) {
		try {
			if (staffDAO.deleteStaff(id)) {
				modelmap.addAttribute("Alert", "X??a nh??n vi??n th??nh c??ng");
			} else {
				modelmap.addAttribute("Alert", "Xin l???i , kh??ng th??? x??a nh??n vi??n ");
				return "error";
			}
		} catch (Exception e) {
			modelmap.addAttribute("Alert", "X??a nh??n vi??n kh??ng th??nh c??ng");
		}

		return "redirect:/admin/staff.htm";
	}

	@RequestMapping(value = "edit-staff", method = RequestMethod.GET)
	public String editstafft(ModelMap modelMap, @RequestParam("id") String id) {
		Staff staff = staffDAO.infoStaff(id);
		modelMap.addAttribute("staff", staff);
		return "static/edit-staff";
	}

	@RequestMapping(value = "edit-staff", method = RequestMethod.POST)
	public String geteditstaff(ModelMap model, @ModelAttribute(value = "staff") Staff staff,
			@RequestParam("img") MultipartFile image,BindingResult error) throws IllegalStateException, IOException {

		
		if (!image.getOriginalFilename().equals("")) {

			String path = context.getRealPath("/upload/" + staff.getId() + image.getOriginalFilename());
			staff.setPhoto(staff.getId() + image.getOriginalFilename());
			image.transferTo(new File(path));

		}
		if (staff.getName().trim().length() == 0) {
			error.rejectValue("name", "staff", "Vui l??ng nh???p t??n nh??n vi??n !");
		}

		if (staff.getEmail().trim().length() == 0) {
			error.rejectValue("email", "staff", "Vui l??ng ??i???n email !");
		} else if (staff.getEmail().indexOf(" ") > 0) {
			error.rejectValue("email", "staff", "Email kh??ng c?? kho???ng tr???ng !");
		} else if (!staff.getEmail().endsWith("@gmail.com")) {
			error.rejectValue("email", "staff", "Email pph???i c?? ??u??i l?? '@gmail.com' !");
		} 

		if (staff.getPhone().trim().length() == 0) {
			error.rejectValue("phone", "staff", "Vui l??ng ??i???n S??T !");
		}
//		if (staff.getBirthday().toString().length()==0) {
//			error.rejectValue("birthday", "staff", "Vui l??ng ??i???n ng??y sinh !");
//		}
		if (staff.getNotes().trim().length() == 0) {
			error.rejectValue("notes", "staff", "Vui l??ng ??i???n ghi ch?? !");
		}

		if (error.hasErrors()) {
			model.addAttribute("message", "Vui l??ng ??i???n ?????y ????? th??ng tin");

			return "static/edit-staff";
		}
		staffDAO.editStaff(staff);
		model.addAttribute("message", "Th??m m???i th??nh c??ng !");

		return "redirect:/admin/staff.htm";
	}

	@ModelAttribute("departss")
	public List<Depart> getMajor() {

		List<Depart> depart = departDAO.listfromDepartment();
		return depart;
	}

	@ModelAttribute("totalstaff")
	public List<Object> gettotalstaff() {

		List<Object> totalstaff = statisticaldao.totalStaff();
		return totalstaff;
	}

	@ModelAttribute("totaldepartment")
	public List<Object> gettotaldepartment() {

		List<Object> totaldepart = statisticaldao.totalDepartment();
		return totaldepart;
	}

	@ModelAttribute("totalsalary")
	public List<Object> gettotalsalary() {

		List<Object> totalsalary = statisticaldao.totalSalary();
		return totalsalary;
	}

	@ModelAttribute("salaryss")
	public List<Salary> getSalary() {
		List<Salary> salary = salarydao.listfromSalary();
		return salary;

	}

	@ModelAttribute("totalcontract")
	public List<Object> getContract() {
		List<Object> contract = statisticaldao.totalContract();
		return contract;

	}

	@ModelAttribute("totalrecord")
	public List<Object> getRecord() {
		List<Object> record = statisticaldao.totalRecord();
		return record;

	}

	@ModelAttribute("totalrecord1")
	public List<Object> getRecord1() {
		List<Object> record = statisticaldao.totalRecord1();
		return record;

	}

	@ModelAttribute("totaldependent")
	public List<Object> getDependent() {
		List<Object> dependent = statisticaldao.totalDependent();
		return dependent;

	}

	@RequestMapping("achievement")
	public String achievement(ModelMap model, Integer offset, Integer maxResults) {
		List<Record> list = staffService.listAchievement(offset, maxResults);
		model.addAttribute("records", list);

		model.addAttribute("count", staffService.count3());
		model.addAttribute("offset", offset);

//		
		return "static/achievement";
	}

	@RequestMapping( value="changepassword",method=RequestMethod.GET)
	public String changepassword(ModelMap model, HttpSession sessions) {
		

		return "static/changepassword";
	}

//	@RequestMapping(value="changepassword1",method=RequestMethod.POST)
//	public String changepassword1(ModelMap model, HttpRequest request
//		) {
//		System.out.println("ssssssssssss");
////System.out.println(pwcu);
////		if (pwcu.length() == 0) {
////			model.addAttribute("loi", "Kh??ng ???????c ????? tr???ng m???t kh???u");
////			return "static/changepassword";
////		}
//		return "redirect:/admin/static.htm";
////		return "static/changepassword";
//	}

	@RequestMapping(value = "add-achievement", method = RequestMethod.GET)
	public String addachievement(ModelMap model) {
		model.addAttribute("record", new Record());

		return "static/add-achievement";
	}

	@RequestMapping(value = "add-achievement", method = RequestMethod.POST)
	public String adddepartment1(ModelMap model, @Validated @ModelAttribute("record") Record record,
			BindingResult error) {

		if (record.getReason().trim().length() == 0) {
			error.rejectValue("reason", "record", "Vui l??ng nh???p l?? do !");
		}
		if (error.hasErrors()) {
			model.addAttribute("message", error.toString());

			return "static/add-achievement";
		}
		try {
			if (achievementDAO.createAchievement(record)) {
				String to = "tunglaph09448@fpt.edu.vn";
				boolean tieude = record.isType();
				String noidung = record.getReason();
				achievementDAO.sentMail(to, tieude, noidung);
				model.addAttribute("Alert", "Th??m ????nh gi?? th??nh c??ng");

			}

		} catch (Exception e) {
			model.addAttribute("Alert", "Th??m ????nh gi?? kh??ng th??nh c??ng");
		}
		return "static/add-achievement";
	}

	@RequestMapping("delete-achievement")
	public String getdeleteuser(ModelMap modelMap, @RequestParam("id") String id) {
		try {

			if (achievementDAO.deleteAchievement(id)) {
				modelMap.addAttribute("Alert", "X??a ????nh gi?? th??nh c??ng");
			}
		} catch (Exception e) {
			modelMap.addAttribute("Alert", "X??a ????nh gi?? kh??ng th??nh c??ng");
		}

		return "redirect:/admin/achievement.htm";
	}

	@RequestMapping(value = "edit-achievement", method = RequestMethod.GET)
	public String geteditachievement(@RequestParam("id") String id, ModelMap model) {

		Record record = achievementDAO.infoAchievement(id);
		model.addAttribute("record", record);
		return "static/edit-achievement";
	}

	@RequestMapping(value = "edit-achievement", method = RequestMethod.POST)
	public String getedituser1(ModelMap model, @ModelAttribute("record") Record record) {
		if (achievementDAO.editAchievement(record)) {
			model.addAttribute("Alert", "S???a ????nh gi?? th??nh c??ng");

		} else {
			model.addAttribute("Alert", "S???a ????nh gi?? kh??ng th??nh c??ng");
		}

		return "static/edit-achievement";
	}

	@ModelAttribute("liststaff")
	public List<Staff> getStaff() {
		List<Staff> list = staffDAO.listfromStaff();
		return list;

	}

	@RequestMapping("salary")
	public String listSalary(ModelMap model, Integer offset, Integer maxResult) {

		List<Salary> list = staffService.listSalary(offset, maxResult);
		model.addAttribute("salarys", list);
		model.addAttribute("count", staffService.count4());
		model.addAttribute("offset", offset);
		return "static/salary";
	}

	@RequestMapping("delete-salary")
	public String getdeletesalary(ModelMap modelmap, @RequestParam("id") String id) {
		try {

			if (salarydao.deleteSalary(id)) {
				modelmap.addAttribute("Alert", "X??a l????ng th??nh c??ng");
			} else {
				modelmap.addAttribute("Alert", "Xin l???i , kh??ng th??? x??a l????ng ");
				return "error";
			}
		} catch (Exception e) {
			modelmap.addAttribute("Alert", "X??a l????ng kh??ng th??nh c??ng");
		}

		return "redirect:/admin/salary.htm";
	}

	@RequestMapping(value = "add-salary", method = RequestMethod.GET)
	public String addsalary(ModelMap model) {
		model.addAttribute("salary", new Salary());

		return "static/add-salary";
	}

	@RequestMapping(value = "add-salary", method = RequestMethod.POST)
	public String addsalary(ModelMap model, @Validated @ModelAttribute("salary") Salary salary, BindingResult error) {

		if (salary.getId().trim().length() == 0) {
			error.rejectValue("id", "salary", "Vui l??ng ??i???n m?? l????ng !");
		}
//else if (salary.getId().indexOf(" ") > 0) {
//			error.rejectValue("id", "salary", "M?? l????ng kh??ng c?? kho???ng tr???ng !");
//		}

		else if (salarydao.checkidsalary(salary.getId()) > 0) {
			error.rejectValue("id", "salary", "Xin l???i , M?? l????ng b??? tr??ng!");
		}
//		if ( salary.getBasicsalary() ) {
//			error.rejectValue("basicsalary", "salary", "Vui l??ng ??i???n l????ng c?? b???n !");
//		}
//		if (salary.getAllowance() <0) {
//			error.rejectValue("allowance", "salary", "Vui l??ng ??i???n l????ng ph??? c???p !");
//		}
//		if (salary.getSalary_factor() <0) {
//			error.rejectValue("salary_factor", "salary", "Vui l??ng ??i???n h??? s??? l????ng !");
//		}
		if (error.hasErrors()) {
			model.addAttribute("message", "Vui long dien day du cac thong tin !");
			return "static/add-salary";
		}
		try {
			if (salarydao.creatSalary(salary)) {
				model.addAttribute("Alert", "Th??m l????ng th??nh c??ng");

			}

		} catch (Exception e) {
			model.addAttribute("Alert", "Th??m l????ng kh??ng th??nh c??ng");
		}
		return "static/add-salary";
	}

	@RequestMapping(value = "edit-salary", method = RequestMethod.GET)
	public String editsalary(ModelMap model, @RequestParam("id") String id) {

		Salary salary = salarydao.infoSalary(id);
		model.addAttribute("salary", salary);
		return "static/edit-salary";
	}

	@RequestMapping(value = "edit-salary", method = RequestMethod.POST)
	public String editsalary(ModelMap model, @ModelAttribute("salary") Salary salary) {
		if (salarydao.editSalary(salary)) {
			model.addAttribute("Alert", "S???a l????ng th??nh c??ng");

		} else {
			model.addAttribute("Alert", "Ph??ng ban ???? t???n t???i");
		}
		return "static/edit-salary";
	}

	@RequestMapping("staff-salary")
	public String staffsalary(ModelMap model) {
		List<Object> listS = statisticaldao.Staffsalary();
		model.addAttribute("staff_salary", listS);

		return "static/staff-salary";
	}

	@RequestMapping("department-salary")
	public String departmentsalary(ModelMap model) {
		List<Object> list = statisticaldao.Departmentsalary();
		model.addAttribute("staff_salary1", list);

		return "static/department-salary";
	}

	@RequestMapping("dependent")
	public String dependent(ModelMap model, Integer offset, Integer maxResults) {

		List<Dependent> list = staffService.listDependent(offset, maxResults);
		model.addAttribute("dependents", list);
		model.addAttribute("count", staffService.count5());
		model.addAttribute("offset", offset);

		return "static/list-dependent";
	}

	@RequestMapping("delete-dependent")
	public String getdeletedependent(ModelMap model, @RequestParam("id") String id) {
		try {

			if (dependentdao.deleteDependent(id)) {
				model.addAttribute("Alert", "X??a quan h??? th??nh c??ng");
			}
		} catch (Exception e) {
			model.addAttribute("Alert", "X??a quan h??? kh??ng th??nh c??ng");
		}

		return "redirect:/admin/dependent.htm";
	}

	@RequestMapping(value = "add-dependent", method = RequestMethod.GET)
	public String adddependent(ModelMap model) {
		model.addAttribute("dependent", new Dependent());
		return "static/add-dependent";
	}

	@RequestMapping(value = "add-dependent", method = RequestMethod.POST)
	public String insertdependent(ModelMap model, @Validated @ModelAttribute("dependent") Dependent dependent,
			BindingResult error) {

		if (dependent.getId().trim().length() == 0) {
			error.rejectValue("id", "dependent", "Vui l??ng ??i???n m?? quan h???!");
		} else if (dependent.getId().indexOf(" ") > 0) {
			error.rejectValue("id", "dependent", "M?? quan h??? kh??ng c?? kho???ng tr???ng !");
		} else if (dependentdao.checkcodeID(dependent.getId()) > 0) {
			error.rejectValue("id", "dependent", "Xin l???i , M?? ph??ng ban b??? tr??ng!");
		}
		if (dependent.getName().trim().length() == 0) {
			error.rejectValue("name", "dependent", "Vui l??ng ??i???n t??n ng?????i th??n !");
		}
		if (dependent.getRelationship().trim().length() == 0) {
			error.rejectValue("relationship", "dependent", "Vui l??ng ??i???n quan h??? v???i ng?????i th??n !");
		}
		if (error.hasErrors()) {
			model.addAttribute("message", error.toString());

			return "static/add-dependent";
		}
		try {
			if (dependentdao.creatDependent(dependent)) {
				model.addAttribute("Alert", "Th??m quan h??? th??nh c??ng");

			}

		} catch (Exception e) {
			model.addAttribute("Alert", "Th??m quan h??? kh??ng th??nh c??ng");
		}
		return "static/add-dependent";
	}

	@RequestMapping("edit-dependent")
	public String geteditdepentent(@RequestParam("id") String id, ModelMap model) {

		Dependent dependent = dependentdao.infoDependent(id);
		model.addAttribute("dependent", dependent);
		return "static/edit-dependent";
	}

	@RequestMapping(value = "edit-dependent", method = RequestMethod.POST)
	public String geteditdependent(ModelMap model, @ModelAttribute("dependent") Dependent dependent) {
		if (dependentdao.editDependent(dependent)) {
			model.addAttribute("Alert", "S???a quan h??? th??nh c??ng");

		} else {
			model.addAttribute("Alert", "S???a quan h??? kh??ng th??nh c??ng");
		}
		return "static/edit-dependent";
	}

//	@RequestMapping("contract")
//	public String listcontract(ModelMap modelMap) {
//		List<Contract> listS = contractDAO.listContract();
//		modelMap.addAttribute("list_contract", listS);
//		return "static/list-contract";
//	}
	@RequestMapping("contract")
	public String listcontract(ModelMap modelMap, Integer offset, Integer maxResults) {
//		List<Contract> list = contractDAO.listContract(offset, maxResults);
		List<Contract> list = staffService.listContract(offset, maxResults);
		modelMap.addAttribute("contracts", list);
		modelMap.addAttribute("count", staffService.count1());
		modelMap.addAttribute("offset", offset);
		return "static/list-contract";
	}

	@RequestMapping(value = "add-contract", method = RequestMethod.GET)
	public String fromContract(ModelMap model) {
		model.addAttribute("contract", new Contract());
		return "static/add-contract";
	}

	@RequestMapping(value = "add-contract", method = RequestMethod.POST)
	public String saveContract(ModelMap model, @Validated @ModelAttribute("contract") Contract contract,
			BindingResult error) {

		if (contract.getId().trim().length() == 0) {
			error.rejectValue("id", "contract", "Vui l??ng ??i???n m?? h???p ?????ng!");
		} else if (contract.getId().indexOf(" ") > 0) {
			error.rejectValue("id", "contract", "M?? h???p ?????ng kh??ng c?? kho???ng tr???ng !");
		} else if (contractDAO.checkcodeID(contract.getId()) > 0) {
			error.rejectValue("id", "contract", "Xin l???i , M?? h???p ?????ng b??? tr??ng!");
		}
		if (contract.getType().trim().length() == 0) {
			error.rejectValue("type", "contract", "Vui l??ng ??i???n ki???u h???p ?????ng !");
		}
		if (error.hasErrors()) {
			model.addAttribute("message", error.toString());

			return "static/add-contract";
		}
		if (contractDAO.creatContract(contract)) {
			model.addAttribute("Alert", "Th??m h???p ?????ng th??nh c??ng");

		} else {
			model.addAttribute("Alert", "Th??m h???p ?????ng th???t b???i th??nh c??ng");
		}

		

		return "static/add-contract";
	}

	@RequestMapping("delete-contract")
	public String deletecontract(@RequestParam("id") String id, ModelMap modelMap) {
		try {

			if (contractDAO.deleteContract(id)) {
				modelMap.addAttribute("Alert", "X??a h???p ?????ng th??nh c??ng");
			}
		} catch (Exception e) {
			modelMap.addAttribute("Alert", "X??a h???p ?????ng kh??ng th??nh c??ng");
		}
		return "redirect:/admin/contract.htm";
	}

	@RequestMapping(value = "edit-contract", method = RequestMethod.GET)
	public String editcontract(ModelMap modelMap, @RequestParam("id") String id) {
		Contract contract = contractDAO.infoContract(id);
		modelMap.addAttribute("contract", contract);
		return "static/edit-contract";
	}

	@RequestMapping(value = "edit-contract", method = RequestMethod.POST)
	public String editDepart(@ModelAttribute("contract") Contract contract, ModelMap modelMap) {

		if (contractDAO.editContract(contract)) {
			modelMap.addAttribute("Alert", "S???a h???p ?????ng th??nh c??ng");

		} else {
			modelMap.addAttribute("Alert", "S???a h???p ?????ng kh??ng th??nh c??ng");
		}

		return "static/edit-contract";

	}
	@RequestMapping("IT")
	public String overview(ModelMap model,HttpServletRequest request, Integer offset, Integer maxResults) {
		List<Object> overview = staffDAO.staffdepartment("P002");
		model.addAttribute("overview", overview);

		return "static/overview";
	}
	@RequestMapping("administrative")
	public String administrative(ModelMap model,HttpServletRequest request, Integer offset, Integer maxResults) {
		List<Object> overview = staffDAO.staffdepartment("P001");
		model.addAttribute("overview1", overview);

		return "static/overview1";
	}
	@RequestMapping("manager")
	public String manager(ModelMap model,HttpServletRequest request, Integer offset, Integer maxResults) {
		List<Object> overview = staffDAO.staffdepartment("P003");
		model.addAttribute("overview2", overview);

		return "static/overview2";
	}
	@RequestMapping("personnel")
	public String personnel(ModelMap model,HttpServletRequest request, Integer offset, Integer maxResults) {
		List<Object> overview = staffDAO.staffdepartment("P004");
		model.addAttribute("overview3", overview);

		return "static/overview3";
	}
	@RequestMapping("protect")
	public String protect(ModelMap model,HttpServletRequest request, Integer offset, Integer maxResults) {
		List<Object> overview = staffDAO.staffdepartment("P005");
		model.addAttribute("overview4", overview);

		return "static/overview4";
	}
}