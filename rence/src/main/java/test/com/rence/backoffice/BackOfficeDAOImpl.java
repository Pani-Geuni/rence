package test.com.rence.backoffice;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import test.com.rence.sendemail.AuthVO;

@Repository
public class BackOfficeDAOImpl implements BackOfficeDAO {
	private static final Logger logger = LoggerFactory.getLogger(BackOfficeDAOImpl.class);

	@Autowired
	SqlSession sqlSession;

	@Override
	public int backoffice_insertOK(BackOfficeVO vo) {
		logger.info("insert()...");
		logger.info("{}", vo);

		int flag = sqlSession.insert("SQL_INSERT_BACKOFFICE",vo);

		return flag;
	}

	@Override
	public int backoffice_auth_insert(AuthVO vo) {
		logger.info("backoffice_auth_insert_DAOImpl()...");
		logger.info("{}", vo);

		int flag = sqlSession.insert("SQL_INSERT_BACKOFFICE_AUTH",vo);

		return flag;
	}

	@Override
	public int backoffice_operating_insert(BackOfficeOperationgTimeVO ovo) {
		logger.info("backoffice_operating_insert_DAOImpl()...");
		logger.info("{}", ovo);

		int flag = sqlSession.insert("SQL_INSERT_OPERRATING_TIME",ovo);

		return flag;
	}

	@Override
	public AuthVO backoffice_auth_select(BackOfficeVO vo) {
		logger.info("backoffice_auth_select()...");
		logger.info("{}", vo);

		AuthVO vo2 = sqlSession.selectOne("SQL_SELECT_BACKOFFICE_AUTH",vo);
		
		return vo2;
	}

	@Override
	public BackOfficeVO backoffice_login(BackOfficeVO vo) {
		logger.info("backoffice_login()...");
		logger.info("{}", vo);

		BackOfficeVO vo2 = sqlSession.selectOne("SQL_BACKOFFICE_LOGIN", vo);	
		
		return vo2;
	}

	@Override
	public BackOfficeVO backoffice_id_email_select(BackOfficeVO vo) {
		logger.info("backoffice_auth_select()...");
		logger.info("{}", vo);

		BackOfficeVO vo2 = sqlSession.selectOne("SQL_SELECT_BACKOFFICE_ID_EMAIL",vo);
		
		return vo2;
	}
}
