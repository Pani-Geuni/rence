/**
	 *  회원가입 처리 컨트롤러
	 */

package test.com.rence.user;

import javax.servlet.ServletContext;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserSignupController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserSerivice service;
	@Autowired
	UserFileuploadService fileuploadService;
	@Autowired
	ServletContext context;

	// 아이디 중복 체크
	@RequestMapping(value = "/user_idCheckOK", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject user_idCheckOK(UserVO uvo) {
		logger.info("Welcome! user_idCheckOK");
		logger.info("result: {}", uvo);

		UserVO uvo2 = service.idCheckOK(uvo);

		JSONObject jsonObject = new JSONObject();

		// uvo가 null이 아니면 아이디 존재
		if (uvo2 != null) {
			jsonObject.put("result", "0"); // 아이디 존재("NOT OK")
		} else {
			jsonObject.put("result", "1"); // 아이디 사용가능("OK")
		}

		return jsonObject;
	}

	// 이메일 중복 체크
	@RequestMapping(value = "/user_emailCheckOK", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject user_emailCheckOK(UserVO uvo) {
		logger.info("Welcome! user_emailCheckOK");
		logger.info("result: {}", uvo);

		UserVO uvo2 = service.emailCheckOK(uvo);

		JSONObject jsonObject = new JSONObject();

		// uvo가 null이 아니면 이메일 존재
		if (uvo2 != null) {
			jsonObject.put("result", "0"); // 이메일 존재("NOT OK")
		} else {
			jsonObject.put("result", "1"); // 이메일 사용가능("OK")
		}

		return jsonObject;
	}

	// 회원가입 페이지 요청
	@RequestMapping(value = "/user_insert", method = RequestMethod.GET)
	public String user_insert() {
		logger.info("Welcome! user_insert");
		return "user/signup"; //회원가입페이지 이동(임시).
	}

	// 회원가압완료
	@RequestMapping(value = "/user_insertOK", method = RequestMethod.POST)
	public String insertOK(UserVO uvo) {
		logger.info("Welcome! user_insertOK");
		logger.info("result: {}", uvo);

		// 사진(파일)업로드
		uvo = fileuploadService.FileuploadOK(uvo);
		logger.info("fileresult: {}", uvo);

		// insert(성공시 1)
		int result = service.user_insertOK(uvo);
		logger.info("result: {}", result);
		
		
		

		return "redirect:/"; // 회원가입후 로그인을 위한 홈화면 이동

	}

}// end class
