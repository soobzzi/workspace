package spring.web.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import spring.service.domain.User;
import spring.service.user.dao.UserDAO;



@Controller
public class User004Controller {

	public User004Controller() {
		System.out.println("==> User004 Controller default Constructor call....");
	}
	
	@RequestMapping("/logon.do")
	public ModelAndView logon() {
		
		System.out.println("\n :: ==> logon() start...");
		
		String message = "[logon()] 아이디,패스워드 3자이상 입력하세요.";
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/user002/logon.jsp");
		modelAndView.addObject("massage",message);
		
		System.out.println("[logon()] end...");
		
		return modelAndView;
	}
	
	@RequestMapping("/home.do")
	public ModelAndView home(HttpSession session) {
		
		System.out.println("\n :: ==> home() start...");
		
		String message = "[home()] WELCOME";
		
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/user002/logon.jsp");
		modelAndView.addObject("massage",message);
		
		System.out.println("[home()] end...");
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/logonAction.do" , method = RequestMethod.GET)
	public ModelAndView logonAction() {
		System.out.println("[logonAction() method = RequestMethod.get start...");
		
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/logon.do");

		
		System.out.println("[logonAction() method = RequestMethod.get end...");
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/logonAction.do" , method = RequestMethod.POST)
	public ModelAndView logonAction(@ModelAttribute("user") User user,
									HttpSession session) {
		System.out.println("[logonAction() method = RequestMethod.POST start...");
		
		String viewName = "/user002/logon.jsp";
		
		UserDAO userDAO = new UserDAO();
		userDAO.getUser(user);
		
		if(user.isActive()) {
			viewName = "/user002/home.jsp";
			session.setAttribute("sessionUser", user);
		}
		
		System.out.println("[action : "+viewName+"]");
		
		String message = null;
		
		if(viewName.equals("/user002/home.jsp")) {
			message = "[logon()] WELCOME";
		}else {
			message = "[logon()] 아이디, 패스워드 3자이상 입력하세요. ";
		}
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(viewName);
		modelAndView.addObject("massage",message);

		
		System.out.println("[logonAction() method = RequestMethod.POST end...");
		
		return modelAndView;
	}
	
	
	
	@RequestMapping("/logout.do")
	public ModelAndView logout(HttpSession session) {
		
		System.out.println("[logout() start ...");
		
		session.removeAttribute("sessionUser");
		
		String	message = "[logout()] 아이디, 패스워드 3자이상 입력하세요. ";
		
		
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/user002/logon.jsp");
		modelAndView.addObject("massage",message);
		
		System.out.println("[logout()] end...");
		
		return modelAndView;
	}
	
	
}
