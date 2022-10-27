package test.com.rence.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HeaderController {

	private static final Logger logger = LoggerFactory.getLogger(HeaderController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	//마이페이지 이동
	@RequestMapping(value = "/go_my_page", method = RequestMethod.GET)
	public String go_my_page() {

		return ".my_page/my_page";
	}
	
	//현재예약리스트 이동
	@RequestMapping(value = "/go_now_reserve", method = RequestMethod.GET)
	public String go_now_reserve() {
		
		return ".my_page/now-reserve-list";
	}
	
	//과거예약리스트 이동
	@RequestMapping(value = "/go_before_reserve", method = RequestMethod.GET)
	public String go_before_reserve() {
		
		return ".my_page/before-reserve-list";
	}
	
	//마일리지 현황 페이지 이동
	@RequestMapping(value = "/go_mileage", method = RequestMethod.GET)
	public String go_mileage() {
		
		return ".my_page/mileage";
	}
	
	//문의 리스트 페이지 이동
	@RequestMapping(value = "/go_question_list", method = RequestMethod.GET)
	public String go_question_list() {
		
		return ".my_page/question-list";
	}

}
