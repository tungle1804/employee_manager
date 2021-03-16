package poly.controller;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.entity.User;
@Transactional
@Controller
@RequestMapping("/")
public class IndexController {
	@RequestMapping("tunganhle")
	public String showform(ModelMap model,HttpSession session) {

		return "index";
	}
	
}
