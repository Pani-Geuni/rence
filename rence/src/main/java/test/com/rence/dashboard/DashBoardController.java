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
}
