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
			errors.rejectValue("username", "user",  "Vui l??ng nh???p Username !");
		}
		if(user.getPass().trim().length() == 0){
			errors.rejectValue("pass", "user",  "Vui l??ng nh???p PassWord!");
			
		}if (errors.hasErrors()) {
			model.addAttribute("message", "Vui l??ng s???a l???i c??c l???i!");
			return "login";
		}
//		if(student.getMark() == null){
//			errors.rejectValue("mark", "student",  "Vui l??ng nh???p ??i???m !");
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
			model.addAttribute("message", "Sai t??n ????ng nh???p ho???c m???t kh???u !");
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
		String tieude="Nh??n Vi??n M???i Ch??? X??t Duy???t "+fullname;
		String noidung1 = "T??i kho???n : "+username + 
				" H??? T??n : "+fullname+
				" Email : "+email+
				" N???i Dung : "+noidung;
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
		String tieude="?????t l???i m???t kh???u";
		String noidung = "M???t kh???u c???a b???n l??  "+pass;
		achievementDAO.sentMailPass(to, tieude, noidung);
	   
	
		return "successpassword";
	}
	
	
	/*
	 * @RequestMapping("resgiter-success") public String Success() { return
	 * "register_success"; }
	 */

}
