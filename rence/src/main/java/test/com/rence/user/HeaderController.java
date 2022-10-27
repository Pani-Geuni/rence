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
	@RequestMapping(value = "/go_my_page", method = RequestMethod.GET)
	public String go_my_page() {
		

		return ".my_page/my_page";
	}
	
}
