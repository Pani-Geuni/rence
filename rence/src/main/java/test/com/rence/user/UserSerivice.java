package test.com.rence.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.com.rence.backoffice.BackOfficeVO;

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
		return dao.emailCheckOK(uvo);
	}

	
	public UserVO authCheckOK(UserVO uvo) {
		logger.info("authCheckOK().....");
		return null;
	}

	public UserVO User_loginOK(UserVO uvo) {
		logger.info("User_loginOK().....");
		return dao.User_loginOK(uvo);
	}
	
	public UserVO user_email_select(UserVO uvo) {
		logger.info("user_email_select().....");
		return dao.user_email_select(uvo);
	}
	
	public UserVO user_id_email_select(UserVO uvo) {
		logger.info("user_id_email_select().....");
		return dao.user_id_email_select(uvo);
	}


	public int user_pw_updateOK(UserVO uvo) {
		logger.info("user_pw_updateOK().....");
		return dao.user_pw_updateOK(uvo);
	}

	public int user_img_updateOK(UserVO uvo) {
		logger.info("user_img_updateOK().....");
		return dao.user_img_updateOK(uvo);
	}

	public int user_secedeOK(UserVO uvo) {
		logger.info("user_secedeOK().....");
		return dao.user_secedeOK(uvo);
	}

}// end class
