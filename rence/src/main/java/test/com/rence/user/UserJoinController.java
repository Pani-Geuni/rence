/**
	 * @author 강경석
	 *  회원가입 처리 컨트롤러
	 */

package test.com.rence.user;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import test.com.rence.sendemail.AuthVO;
import test.com.rence.sendemail.EmailVO;
import test.com.rence.sendemail.UserSendEmail;




@Controller
public class UserJoinController {
	private static final Logger logger = LoggerFactory.getLogger(UserJoinController.class);

	@Autowired
	UserSerivice service;
	@Autowired
	UserFileuploadService fileuploadService;
	@Autowired
	ServletContext context;
	@Autowired
	UserSendEmail authSendEmail;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, 
				new CustomDateEditor(dateFormat, true));
	}
	

	
	/**
	 * 이메일 인증번호 요청
	 * 이메일 중복 체크
	 */
	@RequestMapping(value = "/user_auth", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject user_auth(AuthVO avo, UserVO uvo, EmailVO evo) {
		logger.info("Welcome user_auth");
		logger.info("{}", uvo);
		
		JSONObject jsonObject = new JSONObject();
		
		//이메일 중복 체크
		UserVO emailCheck = service.emailCheckOK(uvo);
		logger.info("emailCheck: {}", emailCheck);
		logger.info("emailCheck.getUser_state(): {}", emailCheck.getUser_state());
		
		// 탈퇴한 회원의 이메일로 재가입 가능
//		if(emailCheck==null || emailCheck.getUser_state() == "N   ") {s
		if(emailCheck==null || emailCheck.getUser_state().equalsIgnoreCase("N   ")) {
			avo.setUser_email(uvo.getUser_email());
			logger.info("avo :   {}", avo);
			//이메일 전송
			avo = authSendEmail.sendEmail(avo,evo);
			logger.info("메일이 전송되었습니다.C_avo: {}",avo);
			if (avo !=null) {
				//avo2 = auth 테이블에 정보 저장 후, select 해온 결과값
				AuthVO avo2 = service.user_auth_insert(avo);
				logger.info("user_auth successed...");
				logger.info("=============avo2:{}",avo2);
				
				jsonObject.put("authNum", "1");
				
			}else {
				logger.info("user_auth failed...");
				jsonObject.put("authNum", "0");
			}
		}
		//이메일 중복체크시 이메일이 있으면 2
		else {
			logger.info("user_auth failed...(email check NOT OK)");
			jsonObject.put("authNum", "2");
		}
		
		return jsonObject;
	}

	/**
	 * 이메일 인증번호 확인
	 */
	@RequestMapping(value = "/user_authOK", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject user_authOK(String user_email, String email_code) {
		
		logger.info("Welcome user_authOK");
		logger.info("{}", email_code);
		 
		AuthVO avo = service.user_authOK_select(user_email, email_code);
		logger.info("avo: {}", avo);
		JSONObject jsonObject = new JSONObject();

	    if(avo != null){
	    	logger.info("successed...");
    	service.user_auth_delete(user_email, email_code);
	    	jsonObject.put("result", "1");
	    }else{
	    	logger.info("failed...");
	    	jsonObject.put("result", "0");
	    }
		return jsonObject;
	}
	
	

	// 아이디 중복 체크
	@RequestMapping(value = "/user_idCheckOK", method = RequestMethod.POST)
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



	// 회원가입 페이지 요청
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String user_join() {
		logger.info("Welcome! user_join");
		return "user/join"; //회원가입페이지 이동(임시).
	}

	// 회원가압완료
	@RequestMapping(value = "/joinOK", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject user_joinOK(UserVO uvo) {
		logger.info("Welcome! user_joinOK");
		logger.info("result: {}", uvo);

//		// 사진(파일)업로드 회원가입 할때는 사진 업로드 안함
//		uvo = fileuploadService.FileuploadOK(uvo);
//		logger.info("fileresult: {}", uvo);

		
		JSONObject jsonObject = new JSONObject();
		// insert(성공시 1)
		int result = service.user_insertOK(uvo);
		logger.info("result: {}", result);
		
		//회원가입 실패시
		if(result==0) {
			//회원가입실패
			jsonObject.put("result", "0"); 
			
		}
		else {
			UserVO uvo2 = service.user_select_userno();
			logger.info("uvo2: {}", uvo2);
			int result2 = service.user_mileage_zero_insert(uvo2);
			if(result2 == 0) {
				//회원가입은 했지만 마일리지 데이터가 안들어갔으므로 실패
//				jsonObject.put("result", "0");
			}
			logger.info("result2: {}", result2);
			jsonObject.put("result", "1"); 
		}
//		return "redirect:/"; // 회원가입후 로그인을 위한 홈화면 이동
		return jsonObject;
	}

}// end class
