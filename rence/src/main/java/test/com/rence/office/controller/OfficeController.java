package test.com.rence.office.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import test.com.rence.office.model.OfficeCommentsVO;
import test.com.rence.office.model.OfficeInfoVO;
import test.com.rence.office.model.OfficeOperatingTimeVO;
import test.com.rence.office.model.OfficeOperatingTimeVO_date;
import test.com.rence.office.model.OfficeReserveVO;
import test.com.rence.office.model.OfficeReviewVO;
import test.com.rence.office.model.OfficeRoomVO;
import test.com.rence.office.model.PaymentInfoVO;
import test.com.rence.office.service.OfficeService;

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
		
		logger.info("space_introduce()...");
		
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
			vo.setRoom_type(info_map.changeType(vo.getRoom_type()));
		}
		
		// **************
		// backoffice 후기
		// **************
		List<OfficeCommentsVO> cvos = service.select_all_comment(backoffice_no);

		
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
		
		logger.info("space_introduce()...");
		
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
			logger.info("vo name :: {}", vo.getRoom_no());
			vo.setRoom_name(info_map.changeType(vo.getRoom_type()));
		}
				
		logger.info("rvos :: {}", rvos);
		
		// **************
		// backoffice 후기
		// **************
		List<OfficeReviewVO> revos = service.select_all_review(backoffice_no);
		
		logger.info("revos :: {}", revos);
		logger.info("revos :: {}", revos.size());
		
		
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
		
		logger.info("reserve_checkOK rvo :: {}", rvo);
		
		int result = service.check_reserve(rvo);
		
		String reserve_no = service.select_one_last_reserve(rvo.getUser_no());
		logger.info("reserve_no :: {}", reserve_no);
		
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
	public String space_payment(OfficeReserveVO rvo, Model model) {
		
		logger.info("space_payment()...");
		
		logger.info("reserve no :: {}", rvo.getReserve_no());
		String reserve_no = rvo.getReserve_no();
		
		PaymentInfoVO pvo = service.select_one_final_payment_info(reserve_no);
		OfficeInfoMap info_map = new OfficeInfoMap();
		
		pvo.setRoom_type(info_map.changeType(pvo.getRoom_type()));
		List<String> splitImage = info_map.splitImage(pvo.getBackoffice_image());
		String room_first_image = splitImage.get(0);
		pvo.setBackoffice_image(room_first_image);
		
		logger.info("result pvo :: {}", pvo);
		
		model.addAttribute("pvo", pvo);
		
		return ".payment_page";
	}
}
