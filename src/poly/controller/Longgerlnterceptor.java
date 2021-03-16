package poly.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.handler.HandlerInterceptorAdapter;

public class Longgerlnterceptor extends org.springframework.web.servlet.handler.HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse reponse, Object handler) throws Exception {
		HttpSession session = request.getSession();
		

		
		if (session.getAttribute("usernames") == null) {

			reponse.sendRedirect(request.getContextPath() + "/home/login.htm");
			return false;
		} else {
			if (!session.getAttribute("usernames").equals("tung@gmail.com")) {
				if (session.getAttribute("role").equals(false)
						&& !session.getAttribute("usernames").equals("tung@gmail.com")) {
					reponse.sendRedirect(request.getContextPath() + "/home/login.htm");
					return false;

				}
			} else {
				if (session.getAttribute("role").equals(true)
						&& session.getAttribute("usernames").equals("tung@gmail.com")) {
					reponse.sendRedirect(request.getContextPath() + "/home/login.htm");
					return false;
				}
			}
		}
//		if(session.getAttribute("usernames") == null &&  session.getAttribute("usernames1") == null) {
//			System.out.println("sssssssss");
//			reponse.sendRedirect(request.getContextPath() + "/home/login.htm");
//			return false;
//		}
//		if (session.getAttribute("usernames") == null&&session.getAttribute("usernames1").equals("tung@gmail.com")) {
//			
//					reponse.sendRedirect(request.getContextPath() + "/home/login.htm");
//					return false;
//				}
//		if(session.getAttribute("usernames") == null &&  (!session.getAttribute("usernames1").equals("tung@gmail.com")) && session.getAttribute("view").equals("client/client.jsp")) {
//			if(session.getAttribute("usernames") == null&&!session.getAttribute("usernames1").equals("tung@gmail.com")) {
//			reponse.sendRedirect(request.getContextPath() + "/home/login.htm");
//			return false;
//		}
//		}
//		if(session.getAttribute("usernames").equals("tung@gmail.com")  &&  session.getAttribute("usernames1")==null && session.getAttribute("view").equals("static/admin.jsp")) {
//			if(session.getAttribute("usernames").equals("tung@gmail.com")  &&session.getAttribute("usernames1")==null) {
//			reponse.sendRedirect(request.getContextPath() + "/home/login.htm");
//			return false;
//		}
//		}

		 
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse reponse, Object handler,
			org.springframework.web.servlet.ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse reponse, Object handler, Exception ex)
			throws Exception {

	}

}
