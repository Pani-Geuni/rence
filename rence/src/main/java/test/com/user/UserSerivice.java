package test.com.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.com.rence.backoffice.BackOfficeDAO;

@Service
public class UserSerivice {

	
	private static final Logger logger = LoggerFactory.getLogger(UserSerivice.class);


	@Autowired
	BackOfficeDAO dao;
	
	public UserSerivice() {
		logger.info("UserSerivice()...");
	}
}
