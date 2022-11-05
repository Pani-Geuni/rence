/**
 * 
 * @author 최진실, 전판근
 *
 */
package test.com.rence.backoffice;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import test.com.rence.sendemail.AuthVO;
import test.com.rence.sendemail.BackOfficeSendEmail;
import test.com.rence.sendemail.EmailVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class BackOfficeController {

	private static final Logger logger = LoggerFactory.getLogger(BackOfficeController.class);

	@Autowired
	ServletContext context;

	@Autowired
	BackOfficeService service;

	@Autowired
	BackOfficeSendEmail authSendEmail;

	@Autowired
	OperatingTime operatingTime;

	@Autowired
	HttpSession session;

	@Autowired
	BackOfficeFileService fileService;

//	@Autowired
//	HttpServletResponse response;

	/**
	 * 백오피스 랜딩
	 */
	@RequestMapping(value = "/backoffice_landing", method = RequestMethod.GET)
	public String backoffice_landing() {

		return ".landing/landing";
	}

	/**
	 * 백오피스 신청 폼 출력
	 */
	@RequestMapping(value = "/backoffice_insert", method = RequestMethod.GET)
	public String backoffice_insert() {

		return ".landing/insert";
	}

	/**
	 * 백오피스 신청 처리
	 * 
	 * @throws ParseException
	 */
	@RequestMapping(value = "/backoffice_insertOK", method = RequestMethod.POST)
	public String backoffice_insertOK(BackOfficeVO vo, BackOfficeOperatingTimeVO ovo) throws ParseException {

		BackOfficeOperatingTimeVO_datetype ovo2 = new BackOfficeOperatingTimeVO_datetype();

		logger.info("vo::::::::::::::::::::::::::{}", vo);

		// 공간 이미지, 호스트 이미지
		vo = fileService.backoffice_image_upload(vo);
		logger.info("filupload room:{}", vo);
		vo = fileService.host_image_upload(vo);
		logger.info("filupload host:{}", vo);

		// 운영시간
		ovo2 = operatingTime.operatingTime(ovo, ovo2);

		// 백오피스 insert
		BackOfficeVO bvo2 = service.backoffice_insertOK(vo);
		logger.info("vo::::::::::::::::::::::::::{}", vo);

		// 운영시간 insert
		ovo2.setBackoffice_no(bvo2.getBackoffice_no());
		int result = service.backoffice_operating_insert(ovo2);
		logger.info("ovo::::::::::::::::::::::::::{}", ovo2);

		String rt = "redirect:backoffice_landing";
		if (result == 0) {
			return "redirect:backoffice_insert";
		}

		return rt;
	}

	/**
	 * 이메일 인증번호 요청
	 */
	@RequestMapping(value = "/backoffice_auth", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject backoffice_auth(AuthVO avo, BackOfficeVO bvo, EmailVO evo) {
		logger.info("Welcome sendMailOK.do");
		logger.info("{}", bvo);

		JSONObject jsonObject = new JSONObject();

		// 이메일 중복 체크
		BackOfficeVO emailCheck = service.backoffice_email_check(bvo);
		if (emailCheck == null || emailCheck.getBackoffice_state().equals("X")
				|| emailCheck.getBackoffice_state().equals("N")) {

			avo.setUser_email(bvo.getBackoffice_email());

			// 이메일 전송
			avo = authSendEmail.sendEmail(avo, evo);
			if (avo != null) {

				// avo2 = auth 테이블에 정보 저장 후, select 해온 결과값
				AuthVO avo2 = service.backoffice_auth_insert(avo);
				logger.info("successed...");
				logger.info("=============avo2:{}", avo2);

				jsonObject.put("result", "1");
				jsonObject.put("auth_code", avo2.getAuth_code());
				jsonObject.put("backoffice_email", avo2.getUser_email());
				jsonObject.put("auth_no", avo2.getAuth_no());

			} else { // 전송 실패
				logger.info("failed...");
				jsonObject.put("result", "0");
			}
		} else { // 중복체크 실패
			logger.info("failed...");
			jsonObject.put("result", "0");
		}

		return jsonObject;
	}

	/**
	 * 이메일 인증번호 확인
	 */
	@RequestMapping(value = "/backoffice_authOK", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject backoffice_authOK(AuthVO avo, String backoffice_email, String auth_code) {

		AuthVO avo2 = service.backoffice_authOK_select(backoffice_email, auth_code);

		JSONObject jsonObject = new JSONObject();

		if (avo2 != null) {
			logger.info("successed...");
			jsonObject.put("result", "1");
			service.backoffice_auth_delete(avo2);

		} else {
			logger.info("failed...");
			jsonObject.put("result", "0");
		}
		return jsonObject;
	}

	/**
	 * 로그인 처리
	 */
	@RequestMapping(value = "/backoffice_loginOK", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject backoffice_loginOK(BackOfficeVO bvo, HttpServletResponse response) {
		logger.info("backoffice_loginOK()...");
		BackOfficeVO bvo2 = service.backoffice_login(bvo);
		logger.info("result: {}.", bvo2);

		JSONObject jsonObject = new JSONObject();

		if (bvo2 != null) {
			session.setAttribute("backoffice_id", bvo2.getBackoffice_id());
			Cookie cookie_no = new Cookie("backoffice_no", bvo2.getBackoffice_no());
			Cookie cookie_profile = new Cookie("host_image", bvo2.getHost_image());
			jsonObject.put("result", "1");
			logger.info("successed...");
			response.addCookie(cookie_no);
			response.addCookie(cookie_profile);
		} else {
			logger.info("failed...");
			jsonObject.put("result", "0");
		}

		return jsonObject;

	}

	/**
	 * 로그아웃 처리
	 */
	@RequestMapping(value = "/backoffice_logout", method = RequestMethod.GET)
	public String backoffice_logout(HttpServletRequest request, HttpServletResponse response) {
		logger.info("backoffice_logout()...");

//		session.removeAttribute("backoffice_id");

		session.invalidate();
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {

			for (int i = 0; i < cookies.length; i++) {

				cookies[i].setMaxAge(0);

				response.addCookie(cookies[i]);

			}

		}

		return "redirect:backoffice_landing"; // 백오피스 랜딩으로 이동
	}

	/**
	 * 비밀번호 초기화(찾기), 이메일로 임시 비밀번호 전송
	 */
	@RequestMapping(value = "/backoffice_reset_pw", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject backoffice_reset_pw(BackOfficeVO bvo, EmailVO evo) {
		logger.info("backoffice_reset_pw ()...");
		logger.info("{}", bvo);

		JSONObject jsonObject = new JSONObject();

		BackOfficeVO bvo2 = service.backoffice_id_email_select(bvo);

		logger.info("bvo2 :: {}", bvo2);

		if (bvo2 != null) {
			bvo2 = authSendEmail.findPw(bvo2, evo);

			if (bvo2 != null) {
				service.backoffice_settingOK_pw(bvo2);
				jsonObject.put("result", "1");

			} else {
				logger.info("update failed...");
				jsonObject.put("result", "0");
			}
		} else {
			logger.info("send failed...");
			jsonObject.put("result", "0");
		}

		return jsonObject;
	}

	/**
	 * 비밀번호 초기화 페이지
	 */
	@RequestMapping(value = "/backoffice_setting_pw", method = RequestMethod.GET)
	public String backoffice_setting_pw(Model model, BackOfficeVO bvo) {
		model.addAttribute("vo", bvo.getBackoffice_no());
		return ".landing/setting_pw";
	}

	/**
	 * 비밀번호 초기화 완료
	 */
	@RequestMapping(value = "/backoffice_settingOK_pw", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject backoffice_settingOK_pw(BackOfficeVO bvo, HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("backoffice_settingOK_pw ()...");
		logger.info("{}", bvo);

		session = request.getSession();

		int result = service.backoffice_settingOK_pw(bvo);

		JSONObject jsonObject = new JSONObject();

		if (result == 1) {
			if (session.getAttribute("backoffice_id") != null) {
				// HOST 로그인 session이 존재할 때
				// Host 환경설정 > 비밀번호 수정
				logger.info("succeed...");
				jsonObject.put("result", "1");
			} else {
				// 가입 신청이 완료되어
				// 신청자의 메일에서 링크 페이지를 열고 수정 했을 때
				logger.info("succeed...");
				jsonObject.put("result", "1");

			}
		} else if (result == 0) {
			logger.info("fail...");
			jsonObject.put("result", "0");
		}

		return jsonObject;
	}

}
