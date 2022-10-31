/**
 * @author 강경석
 * 사용자 마일리지 상세페이지 컨트롤러
 * go_mileage 서블렛을 타고 들어오면 나오는 마일리지 상세페이지에서의 정보를 처리하는 컨트롤러
 * total 
 */


package test.com.rence.user.controller;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import test.com.rence.user.model.UserVO;
import test.com.rence.user.service.UserSerivice;

@Controller
public class UserMileageController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserMileageController.class);
	
	@Autowired
	UserSerivice service;
	
	/**
	 * 마일리지 상세
	 */
	@RequestMapping(value = "/user_mileage", method = RequestMethod.GET)
	public JSONObject go_mileage(UserVO uvo ,Model model) {
		logger.info("user_logoutOK()...");
		logger.info("");
		
		JSONObject jsonObject = new JSONObject();
		
		
		return jsonObject;
	}
	
	
	
	
}//end class
