package test.com.rence.dashboard;

/**
 * 
 * @author 최진실
 *
 */
import java.util.List;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import test.com.rence.dashboard.model.CommentSummaryVO;
import test.com.rence.dashboard.model.CommentVO;
import test.com.rence.dashboard.model.PaymentVO;
import test.com.rence.dashboard.model.ReserveSummaryVO;
import test.com.rence.dashboard.model.ReserveVO;
import test.com.rence.dashboard.model.RoomSummaryVO;
import test.com.rence.dashboard.model.RoomVO;
import test.com.rence.dashboard.model.SalesSettlementSummaryVO;
import test.com.rence.dashboard.service.DashBoardService;

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
	
	@RequestMapping(value = "/backoffice_room", method = RequestMethod.GET)
	public String dashboard_list() {
		return ".dash_board/room";
	}
	
	@RequestMapping(value = "/backoffice_qna", method = RequestMethod.GET)
	public String dashboard_qna() {
		return ".dash_board/qna_list";
	}
	
	@RequestMapping(value = "/backoffice_review", method = RequestMethod.GET)
	public String dashboard_review() {
		return ".dash_board/review_list";
	}
	
	/**
	 * 예약 관리(리스트)
	 */
	@RequestMapping(value = "/backoffice_reserve", method = RequestMethod.GET)
	public String dashboard_reserve(Model model, String backoffice_no, String reserve_state) {
		List<ReserveVO> rvos = service.backoffice_reserve_selectAll(backoffice_no,reserve_state);
		model.addAttribute("r_vos", rvos);
		model.addAttribute("cnt", rvos.size());
		return ".dash_board/reserve_list";
	}
	
	/**
	 * 예약 관리(리스트-검색)
	 */
	@RequestMapping(value = "/backoffice_search_reserve", method = RequestMethod.GET)
	public String dashboard_reserve_search(Model model, String backoffice_no, String searchword) {
		List<ReserveVO> rvos = service.backoffice_search_reserve(backoffice_no,searchword);
		model.addAttribute("r_vos", rvos);
		model.addAttribute("cnt", rvos.size());
		return ".dash_board/reserve_list";
	}
	
	@RequestMapping(value = "/backoffice_day_sales", method = RequestMethod.GET)
	public String dashboard_sales_day() {
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
	
	@RequestMapping(value = "/backoffice_settings", method = RequestMethod.GET)
	public String dashboard_settings() {
		return ".dash_board/setting";
	}
	
}
