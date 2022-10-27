package test.com.rence.user;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import test.com.rence.backoffice.BackOfficeVO;

@Repository
public class UserDAOimpl implements UserDAO {

	private static final Logger logger = LoggerFactory.getLogger(UserDAOimpl.class);
	@Autowired
	SqlSession sqlSession;

	@Override
	public int user_insertOK(UserVO uvo) {
		logger.info("user_insertOK().....");
		logger.info("{}", uvo);

		int flag = sqlSession.insert("SQL_INSERT", uvo);

		return flag;
	}

	@Override
	public UserVO idCheckOK(UserVO uvo) {
		logger.info("idCheckOK().....");
		UserVO uvo2 = sqlSession.selectOne("SQL_ID_CHECK", uvo);

		return uvo2;
	}

	@Override
	public UserVO emailCheckOK(UserVO uvo) {
		logger.info("emailCheckOK().....");
		UserVO uvo2 = sqlSession.selectOne("SQL_EMAIL_CHECK", uvo);

		return uvo2;
	}

	@Override
	public UserVO authCheckOK(UserVO uvo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserVO User_loginOK(UserVO uvo) {
		logger.info("User_login().....");
		UserVO uvo2 = sqlSession.selectOne("SQL_USER_LOGIN", uvo);

		return uvo2;

	}

	@Override
	public int user_pw_updateOK(UserVO uvo) {
		logger.info("user_pw_updateOK().....");
		logger.info("{}", uvo);

		int flag = sqlSession.insert("SQL_INSERT", uvo);

		return flag;
		
	}

	@Override
	public UserVO user_email_select(UserVO uvo) {
		logger.info("user_email_select().....");
		UserVO uvo2 = sqlSession.selectOne("SQL_SELECT_EMAIL",uvo);

		return uvo2;
	}

	@Override
	public int user_id_findOK(UserVO uvo) {
		logger.info("user_id_findOK()...");
		logger.info("{}", uvo);

		int flag = sqlSession.update("SQL_UPDATE_USER_ID_FINDOK",uvo);

		return flag;
	}
	
	

}
