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
			error.rejectValue("username", "user", "Vui lòng nhập Tên tài khoản !");
		} else if (user.getUsername().indexOf(" ") > 0) {
			error.rejectValue("username", "user", "Tên tài khoản không có khoảng trắng !");
		} else if (userdao.checkname(user.getUsername()) > 0) {
			error.rejectValue("username", "user", "Tên tài khoản đã tồn tại !");
		} else if (staffDAO.checkEmail(user.getUsername()) <= 0) {
			error.rejectValue("username", "user", "Tên đăng nhập phải trùng với email !");
		}
		if (user.getFullname().trim().length() == 0) {
			error.rejectValue("fullname", "user", "Vui lòng điền họ tên!");
		}if(user.getFullname().length()>50) {
			error.rejectValue("fullname", "user", "Vuợt quá ký tự cho phép");
		}
		if (user.getPass().trim().length() == 0) {
			error.rejectValue("pass", "user", "Vui lòng điền mật khẩu!");
		}
		if(user.getPass().length()>50) {
			error.rejectValue("pass", "user", "Vuợt quá ký tự cho phép");
		}

		if (error.hasErrors()) {
			model.addAttribute("message", error.toString());
			return "static/add-user";
		}
		try {

			if (userdao.creatUser(user)) {
				model.addAttribute("Alert", "Thêm tài khoản thành công");

			}

		} catch (Exception e) {
			model.addAttribute("Alert", "Thêm tài khoản không thành công");
		}
		return "static/add-user";
	}

	@RequestMapping("delete-user")
	public String getdeleteuser(@RequestParam("username") String username,HttpSession sessions, ModelMap model) {
		String id = (String) sessions.getAttribute("usernames");
		
		try {
			if(id.equals(username)) {
				model.addAttribute("Alert", "Xin lỗi , không thể xóa user ");
				return "error";
			}
			if (userdao.deleteUser(username)) {
				model.addAttribute("Alert", "Xóa nhân viên thành công");
			}
		} catch (Exception e) {
			model.addAttribute("Alert", "Xóa nhân viên không thành công");
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
			model.addAttribute("Alert", "Sửa phòng ban thành công");

		} else {
			model.addAttribute("Alert", "Phòng ban đã tồn tại");
		}
		return "redirect:/admin/static.htm";
	}

	@RequestMapping(value = "edit-user", method = RequestMethod.POST)
	public String getedituser1(HttpServletRequest request, ModelMap model, @ModelAttribute("user") User user, BindingResult error) {
		if (user.getFullname().trim().length() == 0) {
			error.rejectValue("fullname", "user", "Vui lòng điền họ tên!");
		}
		if (user.getPass().trim().length() == 0) {
			error.rejectValue("pass", "user", "Vui lòng điền mật khẩu!");
		}

		if (error.hasErrors()) {
			model.addAttribute("message", error.toString());
			return "static/edit-user";
		}
		
		if (userdao.editUser(user)) {
			model.addAttribute("Alert", "Sửa tài khoản thành công");

		} else {
			model.addAttribute("Alert", "Sửa tài khoản không thành côngi");
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
			error.rejectValue("id", "depart", "Vui lòng điền mã phòng ban !");
		} else if (depart.getId().indexOf(" ") > 0) {
			error.rejectValue("id", "depart", "Mã phòng ban không có khoảng trống !");
		} else if (departDAO.checkCodeId(depart.getId()) > 0) {
			error.rejectValue("id", "depart", "Xin lỗi , Mã phòng ban bị trùng!");
		}
		if (depart.getName().trim().length() == 0) {
			error.rejectValue("name", "depart", "Vui lòng điền tên phòng ban !");
		}
		if (error.hasErrors()) {
			model.addAttribute("message", "Vui long dien day du cac thong tin !");
			return "static/add-department";
		}
		try {
			if (departDAO.creatDepartment(depart)) {
			
				model.addAttribute("Alert",  "Thêm phòng ban thành công");

			}

		} catch (Exception e) {
			model.addAttribute("Alert", "Thêm phòng ban không thành công");
		}

//		return "redirect:/admin/department.htm";
		return "static/add-department";
	}

	@RequestMapping("delete-department")
	public String getdeletedepartment(@RequestParam("id") String id, ModelMap modelMap) {
		try {
			if (departDAO.deleteDepartment(id)) {
				modelMap.addAttribute("Alert", "Xóa phòng ban thành công");
			} else {
				
				modelMap.addAttribute("Alert", "Xin lỗi , không thể xóa phòng ban ");
				return "error";
			}

		} catch (Exception e) {
			modelMap.addAttribute("Alert", "Xóa phòng ban không thành công");
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
			error.rejectValue("name", "depart", "Vui lòng điền tên phòng ban !");
		}
		if (error.hasErrors()) {
			model.addAttribute("message", "Vui lòng điền đầy đủ các thông tin !");
			return "static/edit-department";
		}
		
		if (departDAO.editDepartment(depart)) {
			model.addAttribute("Alert", "Sửa phòng ban thành công");

		} else {
			model.addAttribute("Alert", "Phòng ban đã tồn tại");
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
			model.addAttribute("message", "Vui lòng chọn file !");
		} else {
			String path = context.getRealPath("/upload/" + staff.getId()) + photo.getOriginalFilename();

			staff.setPhoto(staff.getId() + photo.getOriginalFilename());
			photo.transferTo(new File(path));
		}
		if (staff.getId().trim().length() == 0) {
			error.rejectValue("id", "staff", "Vui lòng nhập mã nhân viên !");
		} else if (staff.getId().indexOf(" ") > 0) {
			error.rejectValue("id", "staff", "Mã nhân viên không có khoảng trắng !");
		} else if (staffDAO.checkCodeId(staff.getId()) > 0) {
			error.rejectValue("id", "staff", "Mã nhân viên đã tồn tại !");
		}
		if (staff.getName().trim().length() == 0) {
			error.rejectValue("name", "staff", "Vui lòng nhập tên nhân viên !");
		}

		if (staff.getEmail().trim().length() == 0) {
			error.rejectValue("email", "staff", "Vui lòng điền email !");
		} else if (staff.getEmail().indexOf(" ") > 0) {
			error.rejectValue("email", "staff", "Email không có khoảng trắng !");
		} else if (!staff.getEmail().endsWith("@gmail.com")) {
			error.rejectValue("email", "staff", "Email pphải có đuôi là '@gmail.com' !");
		} else if (staffDAO.checkEmail(staff.getEmail()) > 0) {
			error.rejectValue("email", "staff", "Email đã tồn tại !");
		}

		if (staff.getPhone().trim().length() == 0) {
			error.rejectValue("phone", "staff", "Vui lòng điền SĐT !");
		}
//		if (staff.getBirthday().toString().length()==0) {
//			error.rejectValue("birthday", "staff", "Vui lòng điền ngáy sinh !");
//		}
		if (staff.getNotes().trim().length() == 0) {
			error.rejectValue("notes", "staff", "Vui lòng điền ghi chú !");
		}

		if (error.hasErrors()) {
			model.addAttribute("message", error.toString());

			return "static/add-staff";
		}
		if (staffDAO.creatStaff(staff)) {
			model.addAttribute("Alert", "Thêm nhân viên thành công");

		} else {
			model.addAttribute("Alert", "Thêm nhân viên không thành công");
		}

		;
		return "static/add-staff";

	}

	@RequestMapping("delete-staff")
	public String getdeletestaff(@RequestParam("id") String id, ModelMap modelmap) {
		try {
			if (staffDAO.deleteStaff(id)) {
				modelmap.addAttribute("Alert", "Xóa nhân viên thành công");
			} else {
				modelmap.addAttribute("Alert", "Xin lỗi , không thể xóa nhân viên ");
				return "error";
			}
		} catch (Exception e) {
			modelmap.addAttribute("Alert", "Xóa nhân viên không thành công");
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
			error.rejectValue("name", "staff", "Vui lòng nhập tên nhân viên !");
		}

		if (staff.getEmail().trim().length() == 0) {
			error.rejectValue("email", "staff", "Vui lòng điền email !");
		} else if (staff.getEmail().indexOf(" ") > 0) {
			error.rejectValue("email", "staff", "Email không có khoảng trắng !");
		} else if (!staff.getEmail().endsWith("@gmail.com")) {
			error.rejectValue("email", "staff", "Email pphải có đuôi là '@gmail.com' !");
		} 

		if (staff.getPhone().trim().length() == 0) {
			error.rejectValue("phone", "staff", "Vui lòng điền SĐT !");
		}
//		if (staff.getBirthday().toString().length()==0) {
//			error.rejectValue("birthday", "staff", "Vui lòng điền ngáy sinh !");
//		}
		if (staff.getNotes().trim().length() == 0) {
			error.rejectValue("notes", "staff", "Vui lòng điền ghi chú !");
		}

		if (error.hasErrors()) {
			model.addAttribute("message", "Vui lòng điền đầy đủ thông tin");

			return "static/edit-staff";
		}
		staffDAO.editStaff(staff);
		model.addAttribute("message", "Thêm mới thành công !");

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
////			model.addAttribute("loi", "Không được để trống mật khẩu");
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
			error.rejectValue("reason", "record", "Vui lòng nhập lý do !");
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
				model.addAttribute("Alert", "Thêm đánh giá thành công");

			}

		} catch (Exception e) {
			model.addAttribute("Alert", "Thêm đánh giá không thành công");
		}
		return "static/add-achievement";
	}

	@RequestMapping("delete-achievement")
	public String getdeleteuser(ModelMap modelMap, @RequestParam("id") String id) {
		try {

			if (achievementDAO.deleteAchievement(id)) {
				modelMap.addAttribute("Alert", "Xóa đánh giá thành công");
			}
		} catch (Exception e) {
			modelMap.addAttribute("Alert", "Xóa đánh giá không thành công");
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
			model.addAttribute("Alert", "Sửa đánh giá thành công");

		} else {
			model.addAttribute("Alert", "Sửa đánh giá không thành công");
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
				modelmap.addAttribute("Alert", "Xóa lương thành công");
			} else {
				modelmap.addAttribute("Alert", "Xin lỗi , không thể xóa lương ");
				return "error";
			}
		} catch (Exception e) {
			modelmap.addAttribute("Alert", "Xóa lương không thành công");
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
			error.rejectValue("id", "salary", "Vui lòng điền mã lương !");
		}
//else if (salary.getId().indexOf(" ") > 0) {
//			error.rejectValue("id", "salary", "Mã lương không có khoảng trống !");
//		}

		else if (salarydao.checkidsalary(salary.getId()) > 0) {
			error.rejectValue("id", "salary", "Xin lỗi , Mã lương bị trùng!");
		}
//		if ( salary.getBasicsalary() ) {
//			error.rejectValue("basicsalary", "salary", "Vui lòng điền lương cơ bản !");
//		}
//		if (salary.getAllowance() <0) {
//			error.rejectValue("allowance", "salary", "Vui lòng điền lương phụ cấp !");
//		}
//		if (salary.getSalary_factor() <0) {
//			error.rejectValue("salary_factor", "salary", "Vui lòng điền hệ số lương !");
//		}
		if (error.hasErrors()) {
			model.addAttribute("message", "Vui long dien day du cac thong tin !");
			return "static/add-salary";
		}
		try {
			if (salarydao.creatSalary(salary)) {
				model.addAttribute("Alert", "Thêm lương thành công");

			}

		} catch (Exception e) {
			model.addAttribute("Alert", "Thêm lương không thành công");
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
			model.addAttribute("Alert", "Sửa lương thành công");

		} else {
			model.addAttribute("Alert", "Phòng ban đã tồn tại");
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
				model.addAttribute("Alert", "Xóa quan hệ thành công");
			}
		} catch (Exception e) {
			model.addAttribute("Alert", "Xóa quan hệ không thành công");
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
			error.rejectValue("id", "dependent", "Vui lòng điền mã quan hệ!");
		} else if (dependent.getId().indexOf(" ") > 0) {
			error.rejectValue("id", "dependent", "Mã quan hệ không có khoảng trống !");
		} else if (dependentdao.checkcodeID(dependent.getId()) > 0) {
			error.rejectValue("id", "dependent", "Xin lỗi , Mã phòng ban bị trùng!");
		}
		if (dependent.getName().trim().length() == 0) {
			error.rejectValue("name", "dependent", "Vui lòng điền tên người thân !");
		}
		if (dependent.getRelationship().trim().length() == 0) {
			error.rejectValue("relationship", "dependent", "Vui lòng điền quan hệ với người thân !");
		}
		if (error.hasErrors()) {
			model.addAttribute("message", error.toString());

			return "static/add-dependent";
		}
		try {
			if (dependentdao.creatDependent(dependent)) {
				model.addAttribute("Alert", "Thêm quan hệ thành công");

			}

		} catch (Exception e) {
			model.addAttribute("Alert", "Thêm quan hệ không thành công");
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
			model.addAttribute("Alert", "Sửa quan hệ thành công");

		} else {
			model.addAttribute("Alert", "Sửa quan hệ không thành công");
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
			error.rejectValue("id", "contract", "Vui lòng điền mã hợp đồng!");
		} else if (contract.getId().indexOf(" ") > 0) {
			error.rejectValue("id", "contract", "Mã hợp đồng không có khoảng trống !");
		} else if (contractDAO.checkcodeID(contract.getId()) > 0) {
			error.rejectValue("id", "contract", "Xin lỗi , Mã hợp đồng bị trùng!");
		}
		if (contract.getType().trim().length() == 0) {
			error.rejectValue("type", "contract", "Vui lòng điền kiểu hợp đồng !");
		}
		if (error.hasErrors()) {
			model.addAttribute("message", error.toString());

			return "static/add-contract";
		}
		if (contractDAO.creatContract(contract)) {
			model.addAttribute("Alert", "Thêm hợp đồng thành công");

		} else {
			model.addAttribute("Alert", "Thêm hợp đồng thất bại thành công");
		}

		

		return "static/add-contract";
	}

	@RequestMapping("delete-contract")
	public String deletecontract(@RequestParam("id") String id, ModelMap modelMap) {
		try {

			if (contractDAO.deleteContract(id)) {
				modelMap.addAttribute("Alert", "Xóa hợp đồng thành công");
			}
		} catch (Exception e) {
			modelMap.addAttribute("Alert", "Xóa hợp đồng không thành công");
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
			modelMap.addAttribute("Alert", "Sửa hợp đồng thành công");

		} else {
			modelMap.addAttribute("Alert", "Sửa hợp đồng không thành công");
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