package test.com.rence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	// 메인페이지
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {

		return ".home";
	}
	
	// 리스트 페이지
	@RequestMapping(value = "/list_page", method = RequestMethod.GET)
	public String list_page(String type, String condition, Model model) {
		logger.info("list_page()...");
		
		return ".list";
	}

}
