/**
 * 
 * @author 최진실
 *
 */
package test.com.rence.master;

import java.util.List;

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
	@ResponseBody
	public JSONObject master_loginOK(MasterVO mvo, HttpServletResponse response) {
		
		JSONObject jsonObject = new JSONObject();
		
		logger.info("master_loginOK()...");
		MasterVO mvo2 = service.master_login(mvo);
		logger.info("result: {}.", mvo2);


		if (mvo2 != null) {
			session.setAttribute("master_no", mvo2.getMaster_no());
			
			Cookie cookie = new Cookie("master_no", mvo2.getMaster_no());
			response.addCookie(cookie);
			
			// 로그인 성공
			jsonObject.put("result", "1");
			logger.info("Master Login succeed...");
		} else {
			// 로그인 실패
			logger.info("Master Login failed...");
			jsonObject.put("result", "0");
		}

		return jsonObject;
	}

	/**
	 * 로그아웃 처리
	 */
	@RequestMapping(value = "/master_logoutOK", method = RequestMethod.GET)
	public String master_logout(HttpServletRequest request, HttpServletResponse response) {
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
	 * 마스터 메인 페이지 (백오피스 가입 신청 리스트)
	 */
	@RequestMapping(value = "/master_main", method = RequestMethod.GET)
	public String master_main(Model model) {
		List<BackOfficeVO> bvos = service.backoffice_applyList_selectAll();
		logger.info("result: {}.", bvos.size());
		
		logger.info("bvos : {}", bvos);

		model.addAttribute("vos", bvos);
		model.addAttribute("cnt", bvos.size());

		return ".master_main/master_main";
	}

	/**
	 * 마스터 가입 승인
	 */
	@RequestMapping(value = "/master_grant", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject master_grant(Model model, BackOfficeVO bvo, EmailVO evo) {
		logger.info("BackOfficeVO:{}", bvo);
		JSONObject jsonObject = new JSONObject();
		logger.info("jsonObject : {}", jsonObject);

		int flag = service.backoffice_grant(bvo);
		if (flag == 1) {
			//evo.setReciver(bvo.getBackoffice_email());
			BackOfficeVO bvo2 = sendEmail.settingPw(bvo, evo);
			if (bvo2 != null) {
				logger.info("successed...");
				logger.info("=============bvo2:{}", bvo2);

				jsonObject.put("result", "1");
			} else { // 이메일 전송 실패
				logger.info("failed...");

				jsonObject.put("result", "0");
			}
		} else { // 백오피스 승인 실패
			logger.info("failed...");

			jsonObject.put("result", "0");
		}

		return jsonObject;
	}

	/**
	 * 마스터 가입 거절
	 */
	@RequestMapping(value = "/master_refuse", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject master_refuse(BackOfficeVO bvo, EmailVO evo) {
		logger.info("BackOfficeVO:{}", bvo);
		JSONObject jsonObject = new JSONObject();

		int flag = service.backoffice_refuse(bvo);
		if (flag == 1) {

			BackOfficeVO bvo2 = sendEmail.result_refuse(bvo, evo);
			logger.info("successed...");
			logger.info("=============bvo2:{}", bvo2);

			jsonObject.put("result", "1");

		} else { // 백오피스 거절 실패
			logger.info("failed...");

			jsonObject.put("result", "0");
		}

		return jsonObject;
	}

	/**
	 * 백오피스 탈퇴 신청 리스트
	 */
	@RequestMapping(value = "/master_backoffice_end", method = RequestMethod.GET)
	public String master_backoffice_end(BackOfficeVO bvo, Model model) {

		List<BackOfficeVO> bvos = service.backoffice_endList_selectAll();
		logger.info("result: {}.", bvos.size());

		model.addAttribute("vos", bvos);
		model.addAttribute("cnt", bvos.size());
		
		return ".master_main/master_backoffice_end";
	}
	
	/**
	 * 마스터 탈퇴 승인
	 */
	@RequestMapping(value = "/master_revoke", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject master_revoke(BackOfficeVO bvo, EmailVO evo) {
		logger.info("BackOfficeVO:{}", bvo);
		JSONObject jsonObject = new JSONObject();

		int flag = service.backoffice_revoke(bvo);
		if (flag == 1) {
			BackOfficeVO bvo2 = sendEmail.backoffice_revoke(bvo, evo);
			if (bvo2 != null) {
				logger.info("successed...");
				logger.info("=============bvo2:{}", bvo2);
				jsonObject.put("result", "1");
			} else { // 이메일 전송 실패
				logger.info("failed...");
				jsonObject.put("result", "0");
			}
		} else { // 백오피스 승인 실패
			logger.info("failed...");
			jsonObject.put("result", "0");
		}

		return jsonObject;
	}
	
	/**
	 * 백오피스 상세 페이지
	 */
	@RequestMapping(value = "/master_backoffice_detail", method = RequestMethod.GET)
	public String master_backoffice_detail(BackOfficeVO bvo, Model model) {
		logger.info("backoffice_setting()...");
		BackOfficeVO bvo2 = service.master_backoffice_detail_selectOne(bvo);
		logger.info("result: {}.", bvo2);
		
		String rt="";
		if (bvo2!=null) {
			model.addAttribute("vo", bvo2);
			rt="backoffice/setting";
		}else { // 굳이 필요없지만 넣어봄,,
			rt="redirect:master_main";
		}

		return rt;
	}
}
