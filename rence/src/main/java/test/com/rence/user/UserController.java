package test.com.rence.user;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
	@ResponseBody
	public JSONObject user_loginOK(UserVO uvo, Model model) {
		logger.info("user_loginOK()...");
		UserVO uvo2 = service.User_loginOK(uvo);
		logger.info("result: {}.", uvo2);
		JSONObject jsonObject = new JSONObject();
		
		
		if (uvo2 != null) {
			session.setAttribute("user_id", uvo2.getUser_id());
			model.addAttribute("vo2", uvo2);
			
			logger.info("User Login success.....");
			jsonObject.put("result", "1"); //로그인 성공
		} else {
			logger.info("User Login failed.....");
			jsonObject.put("result", "0"); //로그인 실패
			
		}
		
		return jsonObject;
	}
	
	
	/**
	 * 로그아웃 완료
	 */
	@RequestMapping(value = "/user_logoutOK", method = RequestMethod.GET)
	public String user_logout( HttpServletRequest request) {
		logger.info("user_logoutOK()...");
		session = request.getSession();
        session.removeAttribute("user_id");
		return "redirect:/"; //홈페이지로 이동
	}
	
	/**
	 * 비밀번호 수정페이지 요청
	 */
	@RequestMapping(value = "/user_pw_upddate", method = RequestMethod.GET)
	public String user_pw_upddate() {
		logger.info("user_pw_upddate()...");
		return ".my_page/user_pw_update"; //유저 비밀번호 수정페이지 이동(임시로 지정)
	}
	
	
	/**
	 * 비밀번호 수정페이지완료
	 */
	@RequestMapping(value = "/user_pw_upddateOK", method = RequestMethod.POST)
	public String user_pw_upddateOK() {
		logger.info("user_pw_upddateOK()...");
		
		return "redirect:/go_my_page"; // 비밀번호 수정이 성공 마이페이지로 이동
	}
	
	
	

}// end class
