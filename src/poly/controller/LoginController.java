package poly.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import poly.dao.AchievementDAO;
import poly.dao.StaffDAO;
import poly.dao.StatisticalDAO;
import poly.dao.UserDAO;
import poly.entity.Salary;
import poly.entity.User;
@Transactional
@Controller
@RequestMapping("/home/")
public class LoginController {
	@Autowired
	SessionFactory factory;
	
	@Autowired
	@Qualifier("UserDAO")
	
    private UserDAO userdao;
	@Autowired
	@Qualifier("AchievementDAO")
    private AchievementDAO achievementDAO;
	@Autowired
	@Qualifier("StaffDAO")
    private StaffDAO staffdao;
	@RequestMapping(value="login",method=RequestMethod.GET)
	public String showform(ModelMap model,HttpSession session) {
		model.addAttribute("user", new User());
		if(session.getAttribute("usernames")!=null) {
			session.removeAttribute("usernames");
		}
		if(session.getAttribute("usernames1")!=null) {
			session.removeAttribute("usernames1");
		}
		return "login";
	}
	
//	@RequestMapping("static")
//	public String showform1(ModelMap model) {
//		model.addAttribute("user", new User());
//		return "static/admin";
//	}
	
	@RequestMapping(value="login",method=RequestMethod.POST )
	public String login(  ModelMap model , @ModelAttribute("user") User user,HttpSession session,HttpServletRequest request,BindingResult errors) {
		String Username = user.getUsername();
		String Password = user.getPass();
//		if (error.hasErrors()) {
//			model.addAttribute("message", error.toString());
//			model.put("listStaff", staffDAO.listStaff());
//			
//		}
	     
		if(user.getUsername().trim().length() == 0){
			errors.rejectValue("username", "user",  "Vui lòng nhập Username !");
		}
		if(user.getPass().trim().length() == 0){
			errors.rejectValue("pass", "user",  "Vui lòng nhập PassWord!");
			
		}if (errors.hasErrors()) {
			model.addAttribute("message", "Vui lòng sửa lại các lỗi!");
			return "login";
		}
//		if(student.getMark() == null){
//			errors.rejectValue("mark", "student",  "Vui lòng nhập điểm !");
//		}
		
		if (userdao.checkUser(Username, Password)) {
			if(userdao.checkRole(Username, Password)) {
				User users= userdao.infoUser(Username);
				poly.entity.Staff staff = staffdao.infoStaffEmail(Username);
				session.setAttribute("usernames", staff.getName());
				
				session.setAttribute("photo", staff.getPhoto());
				session.setAttribute("id", staff.getId());
				session.setAttribute("role", users.getRole());
		
			
//				poly.entity.Staff staff = staffdao.infoStaffEmail(Username);
//			session.setAttribute("usernames", users.getFullname());
//				session.setAttribute("photo", staff.getPhoto());
				return "redirect:/home/client.htm";
			
			}else {
				User users= userdao.infoUser(Username);
				session.setAttribute("usernames", users.getUsername());				
				session.setAttribute("role", users.getRole());
//				poly.entity.Staff staff = staffdao.infoStaffEmail(Username);
//				session.setAttribute("usernames", staff.getName());
//				session.setAttribute("photo", staff.getPhoto());
				return "redirect:/admin/static.htm";
			}
		}
		else {
			model.addAttribute("message", "Sai tên đăng nhập hoặc mật khẩu !");
			return "login";
			
		}
		
	}
	@RequestMapping("register_success")
	public String showform1(ModelMap model,HttpSession session) {
		
		
		return "successregister";
	}
	@RequestMapping( value ="register",method =RequestMethod.GET)
	public String Register(ModelMap model) {
//		model.addAttribute("user1", new User());
	
		return "register";
	}
	
	
	@RequestMapping( value ="register",method =RequestMethod.POST)
	public String Register1(ModelMap model,HttpServletRequest request, @RequestParam("username") String username,@RequestParam("email") String email,@RequestParam("fullname") String fullname,@RequestParam("noidung") String noidung) {
		
		model.addAttribute("fullname", fullname);
		String to = "tungbeng200000@gmail.com";
		String tieude="Nhân Viên Mới Chờ Xét Duyệt "+fullname;
		String noidung1 = "Tài khoản : "+username + 
				" Họ Tên : "+fullname+
				" Email : "+email+
				" Nội Dung : "+noidung;
		achievementDAO.sentMailPass(to, tieude, noidung1);

	
		
		 return "successregister"; 
	}
	@RequestMapping(value="forgotpass",method=RequestMethod.GET)
	public String Forgot(ModelMap model,HttpServletRequest request) {
		
		
		return "forgotpassword";
	}
	@RequestMapping(value="forgotpass",method=RequestMethod.POST)
	public String Forgotsuccess(HttpServletRequest request,ModelMap model) {
	
		String email = request.getParameter("email");
		model.addAttribute("email",email);
		String user = request.getParameter("username");
		model.addAttribute("username",user);
		User user1 =userdao.infoUser(user);
		String pass= user1.getPass();
		String to = "tunglaph09448@fpt.edu.vn";
		String tieude="Đặt lại mật khẩu";
		String noidung = "Mật khẩu của bạn là  "+pass;
		achievementDAO.sentMailPass(to, tieude, noidung);
	   
	
		return "successpassword";
	}
	
	
	/*
	 * @RequestMapping("resgiter-success") public String Success() { return
	 * "register_success"; }
	 */

}
