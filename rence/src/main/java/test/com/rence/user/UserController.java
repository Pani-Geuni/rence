/**
 * @author 강경석
 * 로그인,로그아웃 
 * 회원 탈퇴
 * 아이디, 비밀번호 찾기
 */
package test.com.rence.user;

import javax.servlet.ServletContext;
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
	public JSONObject user_loginOK(UserVO uvo, HttpServletResponse response) {
		logger.info("user_loginOK()...");
		UserVO uvo2 = service.User_loginOK(uvo);
		logger.info("result: {}.", uvo2);
		JSONObject jsonObject = new JSONObject();

		if (uvo2 != null) {
			session.setAttribute("user_no", uvo2.getUser_no());
			Cookie cookie = new Cookie("user_no", uvo2.getUser_no()); // 고유번호 쿠키 저장

			logger.info("User Login success.....");
			jsonObject.put("result", "1"); // 로그인 성공
			response.addCookie(cookie);
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
	public String user_logout(HttpServletRequest request, HttpServletResponse response) {
		logger.info("user_logoutOK()...");
		session = request.getSession();
		session.removeAttribute("user_id");

		Cookie[] cookies = request.getCookies(); // 모든 쿠키의 정보를 cookies에 저장
		if (cookies != null) { // 쿠키가 한개라도 있으면 실행
			for (int i = 0; i < cookies.length; i++) {
				cookies[i].setMaxAge(0); // 유효시간을 0으로 설정
				response.addCookie(cookies[i]); // 응답 헤더에 추가
			}
		}

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
	public JSONObject user_find_pw(UserVO uvo, EmailVO evo) {
		logger.info("user_find_pw ()...");
		logger.info("result{}", uvo); // 넘어오는 값 출력

		UserVO uvo2 = service.user_id_email_select(uvo); // 아이디 이메일 체크

		JSONObject jsonObject = new JSONObject();

		if (uvo2 != null) {
			int result = service.user_pw_init(uvo);

			if (result != 0) {
				uvo2 = authSendEmail.findPw(uvo2, evo); // uvo가 null이 아니면(테이블에 데이터가 존재하면) 메일을 통해 수정링크 제공
				logger.info("user_fine_pw successed...");
				jsonObject.put("result", "1");
			} else {
				logger.info("user_fine_pw failed...");
				jsonObject.put("result", "0");
			}

		}

		return jsonObject;
	}

}// end class
