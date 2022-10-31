/**
 * @author 강경석
 * 마이페이지에 관련된 전반적 기술을 처리하는 컨트롤러
 * 마이페이지의 페이징
 * 회원 탈퇴
 * 
 */


package test.com.rence.user.controller;

import java.sql.Date;

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

import test.com.rence.user.model.UserMileageVO;
import test.com.rence.user.model.UserVO;
import test.com.rence.user.service.UserFileuploadService;
import test.com.rence.user.service.UserSerivice;

@Controller
public class MypageController {

	private static final Logger logger = LoggerFactory.getLogger(MypageController.class);
	
	@Autowired
	UserSerivice service;
	
	@Autowired
	UserFileuploadService fileuploadService;
	
	@Autowired
	HttpSession session;
	
	
	/**
	 * 현재예약리스트 이동
	 */
	@RequestMapping(value = "/go_now_reserve", method = RequestMethod.GET)
	public String go_now_reserve() {
		
		return ".my_page/now-reserve-list";
	}
	
	/**
	 * 과거예약리스트 이동
	 */
	@RequestMapping(value = "/go_before_reserve", method = RequestMethod.GET)
	public String go_before_reserve() {
		
		return ".my_page/before-reserve-list";
	}
	
	/**
	 * 마일리지 리스트 페이지 이동
	 */
	@RequestMapping(value = "/go_mileage", method = RequestMethod.GET)
	public String go_mileage(UserVO uvo ,Model model) {
		
		logger.info("user_logoutOK()...");
		logger.info("UserVO: {}", uvo);
		
		//총 마일리지 부분
		UserMileageVO umvo = service.user_mileage_selectOne(uvo);
	
//		UserMileageVO umvo = service.user_mileage_select(uvo);
		
		JSONObject jsonObject = new JSONObject();
		
//		jsonObject.put("",)
		
	
		
		
		//모델에 JSONArray 담아서 주기 
//		JSONArray array =new JSONArray();
//		array.add(jsonObject);	
//		model.addAttribute("res", array);
		
		return ".my_page/mileage";
	}
	
	/**
	 * 문의 리스트 페이지 이동
	 */
	@RequestMapping(value = "/go_question_list", method = RequestMethod.GET)
	public String go_question_list() {
		
		return ".my_page/question-list";
	}
	
	/**
	 * 마이페이지 - 비밀번호 수정
	 */
	@RequestMapping(value = "/user_pw_updateOK", method = RequestMethod.POST)
	@ResponseBody
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
	 * 마이페이지 - 비밀번호 수정 - 현재 비밀번호 확인(본인인증)
	 */
	@RequestMapping(value = "/check_now_pw", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject check_now_pw(UserVO uvo) {
		logger.info("check_now_pw()...");
		logger.info("request: {}", uvo);

		int result = service.check_now_pw(uvo);

		JSONObject jsonObject = new JSONObject();
		if (result == 1) {
			logger.info("right now pw...");
			jsonObject.put("result", "1");
		}
		else {
			logger.info("not now pw...");
			jsonObject.put("result", "0");
		}

		return jsonObject;
	}

	   /**
	    * 마이페이지 -프로필 수정
	    */
	   @RequestMapping(value = "/user_img_updateOK", method = RequestMethod.POST)
	   @ResponseBody
	   public String user_img_updateOK(UserVO uvo) {
	      logger.info("user_img_updateOK()...");
	      logger.info("result: {}", uvo);
//	      logger.info("result: {}", uvo.getUser_image()); 

	      JSONObject jsonObject = new JSONObject();

	      // 사진(파일)업로드
	      uvo = fileuploadService.FileuploadOK(uvo);
	      logger.info("fileresult: {}", uvo);

	      int result = service.user_img_updateOK(uvo);
	      
	      if (result == 1) {
	         logger.info("user_img_update successed...");
	      }else {
	         logger.info("user_img_update failed...");
	         jsonObject.put("result", "0");
	      }

	      return "redirect:/go_my_page";
	   }

	/**
	 * 회원탈퇴
	 */
	@RequestMapping(value = "/secedeOK", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject user_secedeOK(UserVO uvo) {
		logger.info("user_secedeOK()...");
		logger.info("result: {}", uvo);

		JSONObject jsonObject = new JSONObject();

		int result = service.user_secedeOK(uvo);
		logger.info("result: {}", uvo);
		if (result == 1) {
			session.invalidate();
			logger.info("user_secede successed...");
			jsonObject.put("result", "1");
		} else {
			logger.info("user_secede failed...");
			jsonObject.put("result", "0");
		}
		return jsonObject;
	}

}
