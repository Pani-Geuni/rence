/**
 * 
 * @author 최진실
 *
 */
package test.com.rence.master;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import test.com.rence.backoffice.BackOfficeVO;
import test.com.rence.sendemail.EmailVO;
import test.com.rence.sendemail.MasterSendEmail;

@Controller
public class MasterController {
	private static final Logger logger = LoggerFactory.getLogger(MasterController.class);

	@Autowired
	MasterService service;
	
	@Autowired
	MasterSendEmail sendEmail;
	
	@Autowired
	HttpSession session;
	
	/**
	 * 마스터 로그인 페이지
	 */
	@RequestMapping(value = "/master_login", method = RequestMethod.GET)
	public String master_login() {
		
		return "master/login";
	}
	
	/**
	 * 로그인 처리
	 */
	@RequestMapping(value = "/master_loginOK", method = RequestMethod.POST)
	public String master_loginOK(MasterVO mvo, HttpServletResponse response) {
		logger.info("master_loginOK()...");
		MasterVO mvo2 = service.master_login(mvo);
		logger.info("result: {}.",mvo2);
		
		if (mvo2 != null) {
			session.setAttribute("master_no", mvo2.getMaster_no());
			Cookie cookie_1 = new Cookie("master_no", mvo2.getMaster_no());
			session.setAttribute("master_id", mvo2.getMaster_id());
			Cookie cookie_2 = new Cookie("master_id", mvo2.getMaster_id());
			session.setAttribute("master_pw", mvo2.getMaster_pw());
			Cookie cookie_3 = new Cookie("master_pw", mvo2.getMaster_pw());
	    	logger.info("successed...");
	    	response.addCookie(cookie_1);
			response.addCookie(cookie_2);
			response.addCookie(cookie_3);
		} else {
			logger.info("failed...");
		}
		
		return "master/main";
		
	}
	
	/**
	 * 로그아웃 처리
	 */
	@RequestMapping(value = "/master_logoutOK", method = RequestMethod.GET)
	public String master_logout( HttpServletRequest request, HttpServletResponse response) {
		logger.info("master_logout()...");
		session = request.getSession();
        session.removeAttribute("master_id");
        
        Cookie[] cookies = request.getCookies(); 
		if (cookies != null) { 

			for (int i = 0; i < cookies.length; i++) {

				cookies[i].setMaxAge(0); 

				response.addCookie(cookies[i]); 
			}
		}
		
		return "master/login"; 
	}
	
	/**
	 * 비밀번호 초기화(찾기), 이메일로 전송
	 */
//	@RequestMapping(value = "/backoffice_reset_pw", method = RequestMethod.GET)
//	@ResponseBody
//	public JSONObject backoffice_reset_pw(BackOfficeVO bvo, EmailVO evo) {
//		logger.info("backoffice_reset_pw ()...");
//		logger.info("{}", bvo);
//		
//		JSONObject jsonObject = new JSONObject();
//		
//		BackOfficeVO bvo2 = service.backoffice_id_email_select(bvo);
//		
//		if(bvo2!=null) {
//			bvo2 = authSendEmail.findPw(bvo2,evo);
//			
//			if (bvo2 !=null) {
//				logger.info("successed...");
//				jsonObject.put("result", "1");
//				
//			}else {
//				logger.info("failed...");
//				jsonObject.put("result", "0");
//			}
//		}
//		
//		return jsonObject;
//	}
//	
	
	/**
	 * 마스터 메인 페이지
	 */
	@RequestMapping(value = "/master_main", method = RequestMethod.GET)
	public String master_main() {
		
		return ".master_main/master_main";
	}
}
