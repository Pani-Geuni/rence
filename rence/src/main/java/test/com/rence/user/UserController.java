/**
 * @author 강경석
 * 로그인,로그아웃 마이페이지에 관련된 전반적 기술을 처리하는 컨트롤러
 * 회원 탈퇴
 */
package test.com.rence.user;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import test.com.rence.sendemail.EmailVO;
import test.com.rence.sendemail.UserSendEmail;

@Controller
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	ServletContext context;

	@Autowired
	UserSerivice service;

	@Autowired
	HttpSession session;

	@Autowired
	UserSendEmail authSendEmail;
	
	@Autowired
	UserFileuploadService fileuploadService;

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
	public JSONObject user_loginOK(UserVO uvo) {
		logger.info("user_loginOK()...");
		UserVO uvo2 = service.User_loginOK(uvo);
		logger.info("result: {}.", uvo2);
		JSONObject jsonObject = new JSONObject();

		if (uvo2 != null) {
			session.setAttribute("user_id", uvo2.getUser_id());

			logger.info("User Login success.....");
			jsonObject.put("result", "1"); // 로그인 성공
		} else {
			logger.info("User Login failed.....");
			jsonObject.put("result", "0"); // 로그인 실패

		}

		return jsonObject;
	}

	/**
	 * 로그아웃 완료
	 */
	@RequestMapping(value = "/user_logoutOK", method = RequestMethod.GET)
	public String user_logout(HttpServletRequest request) {
		logger.info("user_logoutOK()...");
		session = request.getSession();
		session.removeAttribute("user_id");
		return "redirect:/"; // 홈페이지로 이동
	}

	/**
	 * 아이디 찾기
	 */
	@RequestMapping(value = "/find_id", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject user_find_id(UserVO vo, EmailVO evo) {
		logger.info("user_find_id ()...");
		logger.info("result: {}", vo);

		JSONObject jsonObject = new JSONObject();

		UserVO uvo2 = service.user_email_select(vo);

		if (uvo2 != null) {
			uvo2 = authSendEmail.findId(uvo2, evo); // 유저의 메일로 아이디 전송

			if (uvo2 != null) {
				logger.info("user_fine_id successed...");
				jsonObject.put("result", "1");

			} else {
				logger.info("user_fine_id failed...");
				jsonObject.put("result", "0");
			}
		}

		return jsonObject;
	}

	/**
	 * 비밀번호 찾기
	 */
	@RequestMapping(value = "/find_pw ", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject user_findd_pw(UserVO uvo, EmailVO evo) {
		logger.info("user_find_pw ()...");
		logger.info("result{}", uvo); // 넘어오는 값 출력

		UserVO uvo2 = service.user_id_email_select(uvo); // 아이디 이메일 체크

		JSONObject jsonObject = new JSONObject();
		if (uvo2 != null) {
			uvo2 = authSendEmail.findPw(uvo2, evo); // uvo가 null이 아니면(테이블에 데이터가 존재하면) 메일을 통해 수정링크 제공

			if (uvo2 != null) {
				logger.info("user_fine_pw successed...");
				jsonObject.put("result", "1");

			} else {
				logger.info("user_fine_pw failed...");
				jsonObject.put("result", "0");
			}
		}

		return jsonObject;
	}


	/**
	 * 마이페이지 - 비밀번호 수정
	 */
	@RequestMapping(value = "/user_pw_upddateOK", method = RequestMethod.POST)
	public JSONObject user_pw_upddateOK(UserVO uvo) {
		logger.info("user_pw_upddateOK()...");
		logger.info("result: {}", uvo);

		int result = service.user_pw_updateOK(uvo);

		JSONObject jsonObject = new JSONObject();
		if (result == 1) {
			logger.info("user_pw_upddate successed...");
			jsonObject.put("result", "1");
		}

		else {
			logger.info("user_pw_upddate failed...");
			jsonObject.put("result", "0");
		}

		return jsonObject;
	}

	/**
	 * 마이페이지 -프로필 수정
	 */
	@RequestMapping(value = "/user_img_updateOK", method = RequestMethod.GET)
	public JSONObject user_img_updateOK(UserVO uvo) {
		logger.info("user_img_updateOK()...");
		logger.info("result: {}", uvo);
//		logger.info("result: {}", uvo.getUser_image()); 

		JSONObject jsonObject = new JSONObject();

		// 사진(파일)업로드
		uvo = fileuploadService.FileuploadOK(uvo);
		logger.info("fileresult: {}", uvo);

		
		
		int result = service.user_img_updateOK(uvo);
		logger.info("result: {}", uvo);
		if (result == 1) {
			logger.info("user_img_update successed...");
			jsonObject.put("result", "1");
		}

		else {
			logger.info("user_img_update failed...");
			jsonObject.put("result", "0");
		}
		return jsonObject;
	}
	
	
	/**
	 * 회원탈퇴
	 */
	
	@RequestMapping(value = "/secedeOK", method = RequestMethod.GET)
	public JSONObject user_secedeOK (UserVO uvo) {
		logger.info("user_secedeOK()...");
		logger.info("result: {}", uvo);

		JSONObject jsonObject = new JSONObject();
			
		int result = service.user_secedeOK(uvo);
		logger.info("result: {}", uvo);
		if (result == 1) {
			logger.info("user_secede successed...");
			jsonObject.put("result", "1");
		}
		else {
			logger.info("user_secede failed...");
			jsonObject.put("result", "0");
		}
		return jsonObject;
	}

	
}// end class
