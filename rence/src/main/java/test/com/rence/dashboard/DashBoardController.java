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

import test.com.rence.dashboard.model.CommentVO;
import test.com.rence.dashboard.model.PaymentVO;
import test.com.rence.dashboard.model.ReserveVO;
import test.com.rence.dashboard.model.RoomVO;
import test.com.rence.dashboard.service.DashBoardService;

@Controller
public class DashBoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(DashBoardController.class);
	
	@Autowired
	ServletContext context;
	
	@Autowired
	DashBoardService service;
	
	
	@RequestMapping(value = "/backoffice_main", method = RequestMethod.GET)
	public String dashboard_main(Model model) {
		
		List<ReserveVO> rvos = service.reserve_summary_selectAll();
		List<CommentVO> cvos = service.comment_summary_selectAll();
		List<PaymentVO> pvos = service.payment_summary_selectAll();
		List<RoomVO> rmvos = service.room_summary_selectAll();		
		
		model.addAttribute("r_vos", rvos);
		model.addAttribute("r_cnt", rvos.size());
		model.addAttribute("c_vos", cvos);
		model.addAttribute("c_cnt", cvos.size());
		model.addAttribute("p_vos", pvos);
		model.addAttribute("p_cnt", pvos.size());
		model.addAttribute("rm_vos", rmvos);
		model.addAttribute("rm_cnt", rmvos.size());
		
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
	
	@RequestMapping(value = "/backoffice_reserve", method = RequestMethod.GET)
	public String dashboard_reserve() {
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
