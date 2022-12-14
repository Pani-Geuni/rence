/**
 * @author 전판근
 */

package test.com.rence.office.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import test.com.rence.common.CustomDateFormatter;
import test.com.rence.master.MasterController;
import test.com.rence.office.common.OfficeInfoMap;
import test.com.rence.office.model.OfficeInfoVO;
import test.com.rence.office.model.OfficeOperatingTimeVO;
import test.com.rence.office.model.OfficeOperatingTimeVO_date;
import test.com.rence.office.model.OfficePaymentVO;
import test.com.rence.office.model.OfficeQuestionVO;
import test.com.rence.office.model.OfficeReserveVO;
import test.com.rence.office.model.OfficeReviewVO;
import test.com.rence.office.model.OfficeRoomVO;
import test.com.rence.office.model.PaymentInfoVO;
import test.com.rence.office.model.QuestionVO2;
import test.com.rence.office.service.OfficeService;
import test.com.rence.user.model.ReviewVO;

@Controller
public class OfficeController {
	private static final Logger logger = LoggerFactory.getLogger(MasterController.class);
	
	
	/*
	 * 오피스(공간) 상세 페이지
	 */
	
	@Autowired
	OfficeService service;
	
	@RequestMapping(value = "/space_introduce", method = RequestMethod.GET)
	public String space_intruduce(BackOfficeVO bvo, String introduce_menu, Model model) {
		
		OfficeInfoMap info_map = new OfficeInfoMap();
		
		String backoffice_no = bvo.getBackoffice_no();
		
		// ******************
		// backoffice 기본 정보
		// ******************
		OfficeInfoVO ovo = service.select_one_office_info(backoffice_no);
		List<String> type_list = new ArrayList<String>();
		List<String> tag_list = new ArrayList<String>();
		List<String> img_list = new ArrayList<String>();
		List<String> option_list = new ArrayList<String>();
		List<String> around_option_list = new ArrayList<String>();
		
		if (ovo.getBackoffice_type() != null) {
			type_list = info_map.splitType(ovo.getBackoffice_type());			
		} else {
			type_list.add("타입 없음");
		}
		
		if (ovo.getBackoffice_tag() != null) {
			tag_list = info_map.splitTag(ovo.getBackoffice_tag());			
		} else {
			tag_list.add("태그 없음");
		}
		
		img_list = info_map.splitImage(ovo.getBackoffice_image());
		
		if (ovo.getBackoffice_option() != null) {
			option_list = info_map.splitOption(ovo.getBackoffice_option());			
		} else {
			option_list.add("옵션 없음");
		}
		
		if (ovo.getBackoffice_around() != null) {
			around_option_list = info_map.splitAroundOption(ovo.getBackoffice_around());			
		} else {
			around_option_list.add("주변 시설 없음");
		}
		
		ovo.setShort_roadname_address(info_map.makeShortAddress(ovo.getRoadname_address()));
		
		// ******************
		// backoffice 운영 시간
		// ******************
		OfficeOperatingTimeVO_date dotvo = service.select_one_operating_time(backoffice_no);
		
		CustomDateFormatter df = new CustomDateFormatter();
		OfficeOperatingTimeVO otvo = df.showStringOfficeOperating(dotvo);
		
		// ************************
		// backoffice 운영 공간(Room)
		// ************************
		List<OfficeRoomVO> rvos = service.select_all_room(backoffice_no);
		
		for (OfficeRoomVO vo : rvos) {
			vo.setRoom_type(info_map.changeType(vo.getRoom_type()));
		}
		
		// **************
		// backoffice 문의
		// **************
		List<OfficeQuestionVO> cvos = service.select_all_comment(backoffice_no);
		
		if (cvos != null) {
			for (OfficeQuestionVO vo : cvos) {
				OfficeQuestionVO vo2 = service.select_one_answer(vo.getComment_no());
				if(vo2 != null) {
					vo.setAnswer_content(vo2.getAnswer_content());
					vo.setAnswer_date(vo2.getAnswer_date());
					vo.setState("Y");
				} else {
					vo.setState("N");
				}
			}
		}
		
		
		// **************
		// backoffice 후기
		// **************
		List<OfficeReviewVO> revos = service.select_all_review(backoffice_no);
				
		
		// backoffice 기본 정보
		model.addAttribute("page", "space_introduce_detail");
		model.addAttribute("ovo", ovo);
		model.addAttribute("type_list", type_list);
		model.addAttribute("tag_list", tag_list);
		model.addAttribute("img_list", img_list);
		model.addAttribute("option_list", option_list);
		model.addAttribute("around_option_list", around_option_list);

		// backoffice 운영 시간
		model.addAttribute("otvo", otvo);
		
		// backoffice 운영 공간
		model.addAttribute("rvos", rvos);
		
		// backoffice 문의
		model.addAttribute("cvos", cvos);
		model.addAttribute("cvos_cnt", cvos.size());
		
		// backoffice 후기
		model.addAttribute("revos", revos);
		model.addAttribute("review_cnt", revos.size());
		
		
		
		return ".space/space_detail_introduce";
	}
	
	
	// **********************
	// space introduce OFFICE
	// **********************
	@RequestMapping(value = "/space_introduce_office", method = RequestMethod.GET)
	public String space_intruduce_office(BackOfficeVO bvo, String introduce_menu, Model model) {
		
		OfficeInfoMap info_map = new OfficeInfoMap();
		
		String backoffice_no = bvo.getBackoffice_no();
		
		// ******************
		// backoffice 기본 정보
		// ******************
		OfficeInfoVO ovo = service.select_one_office_info(backoffice_no);
		List<String> type_list = new ArrayList<String>();
		List<String> tag_list = new ArrayList<String>();
		List<String> img_list = new ArrayList<String>();
		List<String> option_list = new ArrayList<String>();
		List<String> around_option_list = new ArrayList<String>();
		
		if (ovo.getBackoffice_type() != null) {
			type_list = info_map.splitType(ovo.getBackoffice_type());			
		} else {
			type_list.add("타입 없음");
		}
		
		if (ovo.getBackoffice_tag() != null) {
			tag_list = info_map.splitTag(ovo.getBackoffice_tag());			
		} else {
			tag_list.add("옵션 없음");
		}
		
		img_list = info_map.splitImage(ovo.getBackoffice_image());
		
		if (ovo.getBackoffice_option() != null) {
			option_list = info_map.splitOption(ovo.getBackoffice_option());			
		} else {
			option_list.add("옵션 없음");
		}
		
		if (ovo.getBackoffice_around() != null) {
			around_option_list = info_map.splitAroundOption(ovo.getBackoffice_around());			
		} else {
			around_option_list.add("주변 시설 없음");
		}
		
		ovo.setShort_roadname_address(info_map.makeShortAddress(ovo.getRoadname_address()));
		
		// ******************
		// backoffice 운영 시간
		// ******************
		OfficeOperatingTimeVO_date dotvo = service.select_one_operating_time(backoffice_no);
		
		CustomDateFormatter df = new CustomDateFormatter();
		OfficeOperatingTimeVO otvo = df.showStringOfficeOperating(dotvo);
		
		// ************************
		// backoffice 운영 공간(Room)
		// ************************
		List<OfficeRoomVO> rvos = service.select_all_room(backoffice_no);
		
		for (OfficeRoomVO vo : rvos) {
			vo.setRoom_name(info_map.changeType(vo.getRoom_type()));
		}
		
		// **************
		// backoffice 후기
		// **************
		List<OfficeReviewVO> revos = service.select_all_review(backoffice_no);
		
		
		// backoffice 기본 정보
		model.addAttribute("page", "space_introduce_detail_office");
		model.addAttribute("ovo", ovo);
		model.addAttribute("type_list", type_list);
		model.addAttribute("tag_list", tag_list);
		model.addAttribute("img_list", img_list);
		model.addAttribute("option_list", option_list);
		model.addAttribute("around_option_list", around_option_list);

		// backoffice 운영 시간
		model.addAttribute("otvo", otvo);
		
		// backoffice 운영 공간
		model.addAttribute("rvos", rvos);
		
		return ".space/space_detail_introduce_office";
	}
	
	// **********************
	// 공간 예약 체크
	// **********************
	@RequestMapping(value = "/reserve_checkOK", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject reserve_checkOK(OfficeReserveVO rvo) throws ParseException {
		
		JSONObject jsonObject = new JSONObject();
		
		int result = service.check_reserve(rvo);
		
		String reserve_no = service.select_one_last_reserve(rvo.getUser_no());
		
		if (result == 1) {
			jsonObject.put("result", "1");
			jsonObject.put("reserve_no", reserve_no);
		} else {
			jsonObject.put("result", "0");
		}
		
		return jsonObject;
	}
	
	// **********************
	// 공간 결제 페이지
	// **********************
	@RequestMapping(value = "/payment_page", method = RequestMethod.GET)
	public String space_payment(OfficeReserveVO rvo, Model model) throws ParseException {
		
		String reserve_no = rvo.getReserve_no();
		
		PaymentInfoVO pvo = service.select_one_final_payment_info(reserve_no);
		OfficeInfoMap info_map = new OfficeInfoMap();
		
		pvo.setRoom_type(info_map.changeType(pvo.getRoom_type()));
		List<String> splitImage = info_map.splitImage(pvo.getBackoffice_image());
		String room_first_image = splitImage.get(0);
		pvo.setBackoffice_image(room_first_image);
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
		Date sdate = formatter.parse(pvo.getReserve_stime());
		Date edate = formatter.parse(pvo.getReserve_etime());
		
		// 사용자 총 예약 시간
		long diffHour = (edate.getTime() - sdate.getTime()) / 3600000;
		
		// 전체 결제할 금액
		int payment_all = (int) diffHour * pvo.getRoom_price();
		int earned_mileage = (int) (payment_all * 0.05);
		
		
		model.addAttribute("pvo", pvo);
		model.addAttribute("payment_all", payment_all);
		model.addAttribute("earned_mileage", earned_mileage);
		
		
		return ".payment_page";
	}
	
	@RequestMapping(value = "/reserve_paymentOK", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject reserve_paymentOK(OfficePaymentVO pvo, Model model) {
		JSONObject jsonObject = new JSONObject();
		
		PaymentInfoVO pvo2 = service.select_one_final_payment_info(pvo.getReserve_no());
		pvo.setRoom_no(pvo2.getRoom_no());
		pvo.setBackoffice_no(pvo2.getBackoffice_no());
		pvo.setSales_state("F");
		
		
		int result = service.reserve_paymentOK(pvo);
		
		if (result == 1) {
			jsonObject.put("result", "1");			
		} else {
			jsonObject.put("result", "0");
		}
		
		return jsonObject;
	}
	
	@RequestMapping(value = "/insert_review", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject insert_review(ReviewVO vo, Model model) {
		JSONObject jsonObject = new JSONObject();
		
		int result = service.insert_review(vo);
		
		
		if (result == 1) {
			jsonObject.put("result", "1");			
		} else {
			jsonObject.put("result", "0");
		}
		
		return jsonObject;
	}
	
	@RequestMapping(value = "/insert_question", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject insert_question(QuestionVO2 vo, Model model) {
		JSONObject jsonObject = new JSONObject();
		
		int result = service.insert_question(vo);
		
		logger.info("insert_question()..");
		logger.info("********** request :: {}", vo);
		
		if (result == 1) {
			jsonObject.put("result", "1");			
		} else {
			jsonObject.put("result", "0");
		}
		
		return jsonObject;
	}
}
