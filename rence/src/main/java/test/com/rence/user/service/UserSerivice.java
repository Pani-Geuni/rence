/**
	 * @author 강경석
	 
*/

package test.com.rence.user.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.com.rence.sendemail.AuthVO;
import test.com.rence.user.model.UserDAO;
import test.com.rence.user.model.UserMileageVO;
import test.com.rence.user.model.UserMypageVO;
import test.com.rence.user.model.UserVO;

@Service
public class UserSerivice {

	private static final Logger logger = LoggerFactory.getLogger(UserSerivice.class);

	@Autowired
	UserDAO dao;

	public UserSerivice() {
		logger.info("UserSerivice()...");
	}
	
	public UserVO user_select_userno() {
		logger.info("user_select_userno().....");
		return dao.user_select_userno();
	}

	public int user_mileage_zero_insert(UserVO uvo) {
		logger.info("user_mileage_zero_insert().....");
		return dao.user_mileage_zero_insert(uvo);
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
	
	public int user_pw_init(UserVO uvo) {
		logger.info("user_pw_init().....");
		return dao.user_pw_init(uvo);
		
	}


	public int check_now_pw(UserVO uvo) {
		logger.info("check_now_pw().....");
		return dao.check_now_pw(uvo);
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
	
	public UserMypageVO user_mypage_select(UserVO uvo) {
		logger.info("user_mypage_select().....");
		return dao.user_mypage_select(uvo);
		
	}

	public AuthVO user_auth_insert(AuthVO avo) {
		logger.info("user_auth_insert().....");
		return dao.user_auth_insert(avo);
	}
	
	public int user_auth_delete(String user_email, String email_code) {
		logger.info("user_auth_delete().....");
		return dao.user_auth_delete(user_email, email_code);
	}

	public AuthVO user_authOK_select(String user_email, String email_code) {
		logger.info("user_authOK_select().....");
		return dao.user_authOK_select(user_email, email_code);
	}


	

	
	public UserMileageVO user_mileage_selectOne(UserVO uvo) {
		logger.info("user_mileage_selectOne().....");
		return dao.user_mileage_selectOne(uvo);
	}

	public List<UserMileageVO> user_mileage_selectAll(UserVO uvo) {
		logger.info("user_mileage_selectAll().....");
		return dao.user_mileage_selectAll(uvo);
	}
	
	public List<UserMileageVO> user_mileage_search_list(UserVO uvo, String searchKey){
		logger.info("user_mileage_selectAll().....");
		return dao.user_mileage_search_list(uvo, searchKey);		
	}

	
	

}// end class
