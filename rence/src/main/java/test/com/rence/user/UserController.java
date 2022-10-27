package test.com.rence.user;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import test.com.rence.backoffice.BackOfficeVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	ServletContext context;

	@Autowired
	UserSerivice service;

	@Autowired
	HttpSession session;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String home() {

		return ".home";
	}

	/**
	 * 로그인 완료
	 */
	@RequestMapping(value = "/user_loginOK", method = RequestMethod.POST)
	public String user_loginOK(UserVO uvo, Model model) {
		logger.info("user_loginOK()...");
		UserVO uvo2 = service.User_loginOK(uvo);
		logger.info("result: {}.", uvo2);

		if (uvo2 != null) {
			session.setAttribute("user_id", uvo2.getUser_id());
			model.addAttribute("vo2", uvo2);
			logger.info("User Login success.....");
			return "redirect:/"; //홈으로
		} else {
			logger.info("User Login failed.....");
			return "redirect:user_login";
		}

	}
	
	
	/**
	 * 로그아웃 완료
	 */
	@RequestMapping(value = "/user_logout", method = RequestMethod.GET)
	public String user_logout( HttpServletRequest request) {
		logger.info("user_logout()...");
		session = request.getSession();
        session.removeAttribute("user_id");
		return "redirect:/"; //홈페이지로 이동
	}
	
	

}// end class
