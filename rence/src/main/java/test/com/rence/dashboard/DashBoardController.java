package test.com.rence.dashboard;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import test.com.rence.backoffice.BackOfficeController;

@Controller
public class DashBoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BackOfficeController.class);
	
	@Autowired
	ServletContext context;
	
	
	@RequestMapping(value = "/backoffice_home", method = RequestMethod.GET)
	public String dashboard_main() {
		return ".dash_board/home";
	}
	
	@RequestMapping(value = "/backoffice_list", method = RequestMethod.GET)
	public String dashboard_list() {
		return ".dash_board/space_list";
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
}
