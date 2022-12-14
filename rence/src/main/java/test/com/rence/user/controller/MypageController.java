/**
 * @author 강경석
 * 마이페이지에 관련된 전반적 기술을 처리하는 컨트롤러
 * 마이페이지의 페이징
 * 회원 탈퇴
 * 
 */

package test.com.rence.user.controller;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	public String go_mileage(UserVO uvo ,Model model, HttpServletRequest request) {
		logger.info("go_mileage()...");
		logger.info("UserVO(사용자 고유번호): {}", uvo);
		
		//총 마일리지 부분
		UserMileageVO umvo = service.user_mileage_selectOne(uvo);
		logger.info("umvo: {}", umvo);

//		마일리지 콤마단위로 변환
		DecimalFormat dc = new DecimalFormat("###,###,###,###,###");
	
		String mileage_total = dc.format(umvo.getMileage_total());
		logger.info("mileage_total: "+ mileage_total);
		
		
		List<UserMileageVO> vos = service.user_mileage_selectAll(uvo);
		logger.info("vos: {}"+ vos);
		
		
		for (int i = 0; i < vos.size(); i++) {
			vos.get(i).setMileage(dc.format(Integer.parseInt(vos.get(i).getMileage())));
		}
		logger.info("Type change vos: {}"+ vos);

		Map<String, List<UserMileageVO>> map2 = new HashMap<String, List<UserMileageVO>>();

		map2.put("list", vos);
		model.addAttribute("res", map2);
		model.addAttribute("mileage_total", mileage_total);
		model.addAttribute("searchKey", "all");
		
		return ".my_page/mileage";
	}
	
	
	@RequestMapping(value = "/mileage_search_list", method = RequestMethod.GET)
	public String go_mileage_search_list(UserVO uvo ,Model model, HttpServletRequest request, String searchKey ) {
		
		logger.info("mileage_search_list()...");
		
		logger.info("검색 키워드: "+searchKey);
		logger.info("UserVO(사용자 고유번호): {}", uvo);
		
		//총 마일리지 부분
		UserMileageVO umvo = service.user_mileage_selectOne(uvo);
		logger.info("umvo: {}", umvo);

//		마일리지 콤마단위로 변환
		DecimalFormat dc = new DecimalFormat("###,###,###,###,###");
	
		String mileage_total = dc.format(umvo.getMileage_total());
		logger.info("mileage_total: "+ mileage_total);
		
		List<UserMileageVO> vos = service.user_mileage_search_list(uvo,searchKey);
		logger.info("vos: {}"+ vos);
		
		
		for (int i = 0; i < vos.size(); i++) {
			vos.get(i).setMileage(dc.format(Integer.parseInt(vos.get(i).getMileage())));
		}
		logger.info("Type change vos: {}"+ vos);
	

		
		Map<String, List<UserMileageVO>> map2 = new HashMap<String, List<UserMileageVO>>();

		map2.put("list", vos);
		model.addAttribute("res", map2);
		model.addAttribute("mileage_total", mileage_total);
		model.addAttribute("searchKey", searchKey);
		
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
		} else {
			logger.info("not now pw...");
			jsonObject.put("result", "0");
		}

		return jsonObject;
	}

	/**
	 * 마이페이지 -프로필 수정
	 */
	@RequestMapping(value = "/user_img_updateOK", method = RequestMethod.POST)
	public String user_img_updateOK(UserVO uvo, HttpServletRequest request, HttpServletResponse response ) {
		logger.info("user_img_updateOK()...");
		logger.info("result: {}", uvo);
		
		//uvo.setUser_no("U1004");
		String user_no = null;
		Cookie[] cookies = request.getCookies();
		for (Cookie c : cookies) {
			if (c.getName().equals("user_no")) {
				user_no = c.getValue();
			}
		}
		uvo.setUser_no(user_no);
		logger.info("==result==: {}", uvo);

		// 사진(파일)업로드
		uvo = fileuploadService.FileuploadOK(uvo);
		logger.info("fileresult: {}", uvo);
		
		Cookie cookie2 = new Cookie("user_image", uvo.getUser_image()); // 고유번호 쿠키 저장
		response.addCookie(cookie2);

		int result = service.user_img_updateOK(uvo);

		return "redirect:/go_my_page";
	}

	/**
	 * 회원탈퇴
	 */
	@RequestMapping(value = "/secedeOK", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject user_secedeOK(UserVO uvo, HttpServletRequest request, HttpServletResponse response) {
		logger.info("user_secedeOK()...");
		logger.info("result: {}", uvo);

		JSONObject jsonObject = new JSONObject();

		int result = service.user_secedeOK(uvo);
		logger.info("result: {}", uvo);
		if (result == 1) {
			session.invalidate();
			logger.info("user_secede successed...");
			jsonObject.put("result", "1");
			
			Cookie[] cookies = request.getCookies(); // 모든 쿠키의 정보를 cookies에 저장
			if (cookies != null) { // 쿠키가 한개라도 있으면 실행
				for (int i = 0; i < cookies.length; i++) {
					cookies[i].setMaxAge(0); // 유효시간을 0으로 설정
					response.addCookie(cookies[i]); // 응답 헤더에 추가
				}
			}
			
			
		} else {
			logger.info("user_secede failed...");
			jsonObject.put("result", "0");
		}
		return jsonObject;
	}

}
