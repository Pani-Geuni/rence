package test.com.rence.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSerivice {

	private static final Logger logger = LoggerFactory.getLogger(UserSerivice.class);

	@Autowired
	UserDAO dao;

	public UserSerivice() {
		logger.info("UserSerivice()...");
	}

	public int user_insertOK(UserVO uvo) {
		logger.info("user_insertOK().....");

		return dao.user_insertOK(uvo);
	}
	
	public UserVO idCheckOK(UserVO uvo) {
		logger.info("idCheckOK().....");
		return dao.idCheckOK(uvo);
	}

	
	public UserVO emailCheckOK(UserVO uvo) {
		logger.info("emailCheckOK().....");
		return null;
	}

	
	public UserVO authCheckOK(UserVO uvo) {
		logger.info("authCheckOK().....");
		return null;
	}

}// end clas
