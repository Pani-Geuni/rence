package test.com.rence.office.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.com.rence.office.model.OfficeInfoDAO;
import test.com.rence.office.model.OfficeInfoVO;
import test.com.rence.office.model.OfficeOperatingTimeVO_date;

@Service
public class OfficeService {
	
	private static final Logger logger = LoggerFactory.getLogger(OfficeService.class);
	
	@Autowired
	OfficeInfoDAO dao;
	
	public OfficeService() {
		logger.info("OfficeService()...");
	}
	
	public OfficeInfoVO select_one_office_info(String backoffice_no) {
		logger.info("select_one_office_info()...");
		OfficeInfoVO vo = dao.select_one_office_info(backoffice_no);
		
		return vo; 
	}
	
	public OfficeOperatingTimeVO_date select_one_operating_time(String backoffice_no) {
		logger.info("select_one_operating_time()...");
		
		OfficeOperatingTimeVO_date vo = dao.select_one_operating_time(backoffice_no);
		
		return vo;
	}
	
	
}
