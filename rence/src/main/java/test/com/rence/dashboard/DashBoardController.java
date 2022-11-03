package test.com.rence.dashboard;

import java.util.ArrayList;
/**
 * 
 * @author 최진실
 *
 */
import java.util.List;

import javax.servlet.ServletContext;

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
import test.com.rence.dashboard.model.CommentSummaryVO;
import test.com.rence.dashboard.model.CommentVO;
import test.com.rence.dashboard.model.ReserveSummaryVO;
import test.com.rence.dashboard.model.ReserveVO;
import test.com.rence.dashboard.model.ReviewVO;
import test.com.rence.dashboard.model.RoomSummaryVO;
import test.com.rence.dashboard.model.RoomVO;
import test.com.rence.dashboard.model.SalesSettlementPreVO;
import test.com.rence.dashboard.model.SalesSettlementSummaryVO;
import test.com.rence.dashboard.model.SalesSettlementVO;
import test.com.rence.dashboard.service.DashBoardService;
import test.com.rence.office.common.OfficeInfoMap;

@Controller
public class DashBoardController {

	private static final Logger logger = LoggerFactory.getLogger(DashBoardController.class);

	@Autowired
	ServletContext context;

	@Autowired
	DashBoardService service;

	/**
	 * 대쉬보드 메인
	 */
	@RequestMapping(value = "/backoffice_main", method = RequestMethod.GET)
	public String dashboard_main(Model model, String backoffice_no) {

		List<ReserveSummaryVO> rvos = service.reserve_summary_selectAll(backoffice_no);
		List<CommentSummaryVO> cvos = service.comment_summary_selectAll(backoffice_no);
		SalesSettlementSummaryVO svo = service.payment_summary_selectOne(backoffice_no);
		RoomSummaryVO rmvo = service.room_summary_selectOne(backoffice_no);

		model.addAttribute("r_vos", rvos);
		model.addAttribute("r_cnt", rvos.size());
		model.addAttribute("c_vos", cvos);
		model.addAttribute("c_cnt", cvos.size());
		model.addAttribute("svo", svo);
		model.addAttribute("rmvo", rmvo);

		return ".dash_board/main";
	}

	/**
	 * 공간 리스트
	 */
	@RequestMapping(value = "/backoffice_room", method = RequestMethod.GET)
	public String dashboard_room_list(Model model, String backoffice_no) {
		List<RoomVO> rmvos = service.dashboard_room_list(backoffice_no);
		model.addAttribute("rm_vos", rmvos);

		return ".dash_board/room";
	}

	/**
	 * 공간 추가/수정 팝업
	 */
	@RequestMapping(value = "/backoffice_insert_room ", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject backoffice_insert_room(String backoffice_no, String room_no) {
		logger.info("backoffice_insertOK_room ()...");
		logger.info("{}", backoffice_no);

		JSONObject jsonObject = new JSONObject();
		OfficeInfoMap info_map = new OfficeInfoMap();

		BackOfficeVO bvo = service.select_one_backoffice_info(backoffice_no);
		List<String> type_list = new ArrayList<String>();

		if (bvo.getBackoffice_type() != null) {
			type_list = info_map.splitType(bvo.getBackoffice_type());
		} else {
			type_list.add("타입 없음");
		}

		if (room_no != null) {
			RoomVO rmvo = service.select_one_room_info(backoffice_no, room_no);
			jsonObject.put("rmvo", rmvo);
		}

		jsonObject.put("room_type", type_list);

		return jsonObject;
	}

	/**
	 * 공간 추가
	 */
	@RequestMapping(value = "/backoffice_insertOK_room ", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject backoffice_insertOK_room(String backoffice_no, RoomVO rvo) {
		logger.info("backoffice_insertOK_room ()...");
		logger.info("{}", backoffice_no);

		JSONObject jsonObject = new JSONObject();

		int result = service.backoffice_insertOK_room(backoffice_no, rvo);

		if (result == 1) {
			logger.info("successed...");
			jsonObject.put("result", "1");
		}

		else {
			logger.info("failed...");
			jsonObject.put("result", "0");
		}

		return jsonObject;
	}

	/**
	 * 공간 수정
	 */
	@RequestMapping(value = "/backoffice_updateOK_room ", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject backoffice_updateOK_room(String backoffice_no, RoomVO rvo) {
		logger.info("backoffice_updateOK_room ()...");
		logger.info("{}", backoffice_no);

		JSONObject jsonObject = new JSONObject();

		int result = service.backoffice_updateOK_room(backoffice_no, rvo);

		if (result == 1) {
			logger.info("successed...");
			jsonObject.put("result", "1");
		}

		else {
			logger.info("failed...");
			jsonObject.put("result", "0");
		}

		return jsonObject;
	}

	/**
	 * 공간 삭제
	 */
	@RequestMapping(value = "/backoffice_deleteOK_room ", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject backoffice_deleteOK_room(String backoffice_no, String room_no) {
		logger.info("backoffice_deleteOK_room ()...");
		logger.info("{}", backoffice_no);

		JSONObject jsonObject = new JSONObject();

		int result = service.backoffice_deleteOK_room(backoffice_no, room_no);

		if (result == 1) {
			logger.info("successed...");
			jsonObject.put("result", "1");
		}

		else {
			logger.info("failed...");
			jsonObject.put("result", "0");
		}

		return jsonObject;
	}

	/**
	 * 문의(리스트)
	 */
	@RequestMapping(value = "/backoffice_qna", method = RequestMethod.GET)
	public String dashboard_qna(Model model, String backoffice_no) {
		logger.info("backoffice_qna ()...");
		logger.info("{}", backoffice_no);
		List<CommentVO> qvos = service.backoffice_qna_q_selectAll(backoffice_no);
		List<CommentVO> avos = service.backoffice_qna_a_selectAll(backoffice_no);
		model.addAttribute("q_vos", qvos);
		model.addAttribute("a_vos", avos);
		model.addAttribute("cnt", qvos.size());
		return ".dash_board/qna_list";
	}

	/**
	 * 답변 작성 팝업
	 */
	@RequestMapping(value = "/backoffice_insert_comment ", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject backoffice_insert_comment(String backoffice_no, String room_no, String comment_no) {
		logger.info("backoffice_insert_comment ()...");
		logger.info("{}", backoffice_no);
		logger.info("{}", room_no);
		
		CommentVO cvo2 = service.backoffice_insert_comment(backoffice_no,room_no,comment_no);
		
		JSONObject jsonObject = new JSONObject();

		jsonObject.put("cvo", cvo2);

		return jsonObject;
	}

	/**
	 * 답변 작성
	 */
	@RequestMapping(value = "/backoffice_insertOK_comment", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject backoffice_insertOK_comment(String backoffice_no, CommentVO cvo, String comment_no) {
		logger.info("backoffice_insertOK_comment ()...");
		logger.info("{}", backoffice_no);

		JSONObject jsonObject = new JSONObject();
		
		cvo.setMother_no(comment_no);

		int result = service.backoffice_insertOK_comment(backoffice_no, cvo);

		if (result == 1) {
			logger.info("successed...");
			jsonObject.put("result", "1");
		}

		else {
			logger.info("failed...");
			jsonObject.put("result", "0");
		}

		return jsonObject;
	}
	
	/**
	 * 답변 삭제
	 */
	@RequestMapping(value = "/backoffice_deleteOK_comment", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject backoffice_deleteOK_comment(String backoffice_no, String comment_no, String mother_no) {
		logger.info("backoffice_deleteOK_comment ()...");
		logger.info("{}", backoffice_no);
		logger.info("{}", comment_no);
		
		JSONObject jsonObject = new JSONObject();
		
		int result = service.backoffice_deleteOK_comment(backoffice_no, comment_no, mother_no);
		
		if (result == 1) {
			logger.info("successed...");
			jsonObject.put("result", "1");
		}
		
		else {
			logger.info("failed...");
			jsonObject.put("result", "0");
		}
		
		return jsonObject;
	}

	/**
	 * 리뷰 (리스트)
	 */
	@RequestMapping(value = "/backoffice_review", method = RequestMethod.GET)
	public String dashboard_review(Model model, String backoffice_no) {
		logger.info("backoffice_review ()...");
		logger.info("{}", backoffice_no);
		List<ReviewVO> rvvos = service.backoffice_review_selectAll(backoffice_no);
		model.addAttribute("rv_vos", rvvos);
		model.addAttribute("cnt", rvvos.size());
		return ".dash_board/review_list";
	}

	/**
	 * 예약 관리(리스트)
	 */
	@RequestMapping(value = "/backoffice_reserve", method = RequestMethod.GET)
	public String dashboard_reserve(Model model, String backoffice_no, String reserve_state) {
		logger.info("backoffice_reserve ()...");
		logger.info("{}", backoffice_no);
		List<ReserveVO> rvos = service.backoffice_reserve_selectAll(backoffice_no, reserve_state);
		model.addAttribute("r_vos", rvos);
		model.addAttribute("cnt", rvos.size());
		return ".dash_board/reserve_list";
	}

	/**
	 * 예약 관리(리스트-검색)
	 */
	@RequestMapping(value = "/backoffice_search_reserve", method = RequestMethod.GET)
	public String dashboard_reserve_search(Model model, String backoffice_no, String searchword) {
		logger.info("backoffice_search_reserve ()...");
		logger.info("{}", backoffice_no);
		List<ReserveVO> rvos = service.backoffice_search_reserve(backoffice_no, searchword);
		model.addAttribute("r_vos", rvos);
		model.addAttribute("cnt", rvos.size());
		return ".dash_board/reserve_list";
	}

	/**
	 * 정산 관리(리스트)
	 */
	@RequestMapping(value = "/backoffice_day_sales", method = RequestMethod.GET)
	public String dashboard_sales_day(Model model, String backoffice_no, String sales_date) {
		logger.info("backoffice_day_sales()...");
		logger.info("{}", backoffice_no);
		SalesSettlementPreVO svo = service.backoffice_sales_selectOne(backoffice_no, sales_date);
		List<SalesSettlementVO> svos = service.backoffice_sales_selectAll(backoffice_no);
		model.addAttribute("svo", svo);
		model.addAttribute("s_vos", svos);
		model.addAttribute("cnt", svos.size());
		return ".dash_board/sales_day";
	}

	@RequestMapping(value = "/backoffice_week_sales", method = RequestMethod.GET)
	public String dashboard_sales_week() {
		return ".dash_board/sales_week";
	}

	@RequestMapping(value = "/backoffice_month_sales", method = RequestMethod.GET)
	public String dashboard_sales_month() {
		return ".dash_board/sales_month";
	}

	/**
	 * 정산 상태 변경
	 */
	@RequestMapping(value = "/backoffice_updateOK_sales", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject backoffice_updateOK_sales(String backoffice_no, String room_no, String payment_no) {
		logger.info("backoffice_updateOK_sales ()...");
		logger.info("{}", backoffice_no);

		JSONObject jsonObject = new JSONObject();

		int result = service.backoffice_updateOK_sales(backoffice_no, room_no, payment_no);

		if (result == 1) {
			logger.info("successed...");
			jsonObject.put("result", "1");
		}

		else {
			logger.info("failed...");
			jsonObject.put("result", "0");
		}

		return jsonObject;
	}

	/**
	 * 환경설정 페이지 출력
	 */
	@RequestMapping(value = "/backoffice_settings", method = RequestMethod.GET)
	public String backoffice_settings(BackOfficeVO bvo, Model model) {
		logger.info("backoffice_settings()...");
		BackOfficeVO bvo2 = service.backoffice_setting_selectOne(bvo);
		logger.info("result: {}.", bvo2);

		model.addAttribute("vo", bvo2);

		return ".dash_board/setting";
	}

	/**
	 * 환경설정에서 비밀번호 수정
	 */
	@RequestMapping(value = "/backoffice_update_pw", method = RequestMethod.GET)
	public String backoffice_update_pw(BackOfficeVO bvo) {
		logger.info("backoffice_update_pw ()...");
		logger.info("{}", bvo);

		// 비밀번호 일치 여부 확인
		BackOfficeVO bvo2 = service.backoffice_select_pw(bvo);

		String rt = "";
		if (bvo2 != null) {
			logger.info("successed...");
			rt = "redirect:backoffice_setting_pw";
		}

		else {
			logger.info("failed...");
			rt = "backoffice/setting";
		}

		return rt;
	}

	/**
	 * 환경설정에서 업체 탈퇴 요청
	 */
	@RequestMapping(value = "/backoffice_setting_delete", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject backoffice_setting_delete(BackOfficeVO bvo) {
		logger.info("backoffice_setting_delete ()...");
		logger.info("{}", bvo);

		JSONObject jsonObject = new JSONObject();

		int result = service.backoffice_setting_delete(bvo);

		if (result == 1) {
			logger.info("successed...");
			jsonObject.put("result", "1");
		}

		else {
			logger.info("failed...");
			jsonObject.put("result", "0"); // 남은 예약이 있을 시
		}

		return jsonObject;
	}

}
