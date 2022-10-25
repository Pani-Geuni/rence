package test.com.rence.backoffice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BackOfficeService {
	private static final Logger logger = LoggerFactory.getLogger(BackOfficeService.class);


	@Autowired
	BackOfficeDAO dao;
	
	public BackOfficeService() {
		logger.info("BackOfficeService()...");
	}
}
