package test.com.rence.office.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import test.com.rence.master.MasterController;

@Controller
public class OfficeController {
	private static final Logger logger = LoggerFactory.getLogger(MasterController.class);
	
	
	/*
	 * 오피스(공간) 상세 페이지
	 */
	
	@RequestMapping(value = "/space_introduce", method = RequestMethod.GET)
	public String space_intruduce() {
		
		logger.info("space_introduce()...");

		return ".space";
	}
}
