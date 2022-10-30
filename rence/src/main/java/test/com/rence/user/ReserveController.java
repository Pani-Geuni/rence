/**
 * @author 김예은
 */

package test.com.rence.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ReserveController {

	private static final Logger logger = LoggerFactory.getLogger(ReserveController.class);

	@Autowired
	UserSerivice service;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	// 과거 예약 내역 상세 페이지
	@RequestMapping(value = "/reserve_detail_before", method = RequestMethod.GET)
	public String before_reserve_detail(String reservation_no, Model model) {
		logger.info("reserve_detail_before()...");
		
		return ".reserve/reserve_detail_before";
	}
	
	// 현재 예약 내역 상세 페이지
	@RequestMapping(value = "/reserve_detail_now", method = RequestMethod.GET)
	public String now_reserve_detail(String reservation_no, Model model) {
		logger.info("reserve_detail_now()...");
		
		return ".reserve/reserve_detail_now";
	}

}// end class
