package test.com.rence.user;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class UserDAOimpl implements UserDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(UserDAOimpl.class);
	@Autowired
	SqlSession sqlSession;

	@Override
	public int user_insertOK(UserVO uvo) {
		logger.info("user_insert().....");
		logger.info("{}", uvo);
		
		int flag = sqlSession.insert("SQL_INSERT", uvo);
		
		return flag;
	}

	@Override
	public UserVO idCheckOK(UserVO uvo) {
		logger.info("idCheckOK().....");
		UserVO uvo2 = sqlSession.selectOne("SQL_ID_CHECK",uvo);
		
		return uvo2;
	}

	@Override
	public UserVO emailCheckOK(UserVO uvo) {
		logger.info("emailCheckOK().....");
		UserVO uvo2 = sqlSession.selectOne("SQL_EMAIL_CHECK",uvo);
		
		return uvo2;
	}

	@Override
	public UserVO authCheckOK(UserVO uvo) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
}
