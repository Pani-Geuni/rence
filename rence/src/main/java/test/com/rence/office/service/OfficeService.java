package test.com.rence.office.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.com.rence.office.model.OfficeInfoDAO;
import test.com.rence.office.model.OfficeInfoVO;

@Service
public class OfficeService {
	
	private static final Logger logger = LoggerFactory.getLogger(OfficeService.class);
	
	@Autowired
	OfficeInfoDAO dao;
	
	public OfficeService() {
		logger.info("OfficeService()...");
	}
	
	public OfficeInfoVO select_one_office_info(String backoffice_no) {
		OfficeInfoVO vo = dao.select_one_office_info(backoffice_no);
		
		return vo; 
	}
}
