package test.com.rence.backoffice;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class BackOfficeController {

	private static final Logger logger = LoggerFactory.getLogger(BackOfficeController.class);

	@Autowired
	ServletContext context;
	
	@Autowired
	BackOfficeService service;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/backoffice", method = RequestMethod.GET)
	public String home() {

		return ".home";
	}

}
