/**
 * 
 * @author 최진실
 *
 */
package test.com.rence.backoffice;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import test.com.rence.sendemail.AES256Util;
import test.com.rence.sendemail.AuthVO;

@Repository
public class BackOfficeDAOImpl implements BackOfficeDAO {
	private static final Logger logger = LoggerFactory.getLogger(BackOfficeDAOImpl.class);

	@Autowired
	SqlSession sqlSession;
	
	@Autowired
	AES256Util aes;

	@Override
	public BackOfficeVO backoffice_email_check(BackOfficeVO bvo) {
		logger.info("backoffice_email_check()...");
		logger.info("{}", bvo);

		BackOfficeVO bvo2 = sqlSession.selectOne("SQL_SELECT_BACKOFFICE_EMAIL",bvo);
		
		return bvo2;
	}
	
	@Override
	public BackOfficeVO backoffice_insertOK(BackOfficeVO bvo) {
		logger.info("insert()...");
		logger.info("{}", bvo);

		BackOfficeVO bvo2 = null;
		int flag = sqlSession.insert("SQL_INSERT_BACKOFFICE",bvo);
		if (flag == 1) {
			bvo2 = sqlSession.selectOne("SQL_SELECT_BACKOFFICE_NO",bvo);
		}
		
		return bvo2;
	}

	@Override
	public AuthVO backoffice_auth_insert(AuthVO avo) {
		logger.info("backoffice_auth_insert_DAOImpl()...");
		logger.info("{}", avo);

		AuthVO avo2 = null;
		int result = sqlSession.insert("SQL_INSERT_BACKOFFICE_AUTH",avo);
		if (result == 1) {
			avo2 = sqlSession.selectOne("SQL_SELECT_BACKOFFICE_AUTH",avo);
			logger.info("avo:{}",avo2);
		}

		return avo2;
	}
	
	@Override
	public AuthVO backoffice_auth_select(AuthVO avo) {
		logger.info("backoffice_auth_select()...");
		logger.info("{}", avo);

		AuthVO avo2 = sqlSession.selectOne("SQL_SELECT_BACKOFFICE_AUTH",avo);
		
		return avo2;
	}

	@Override
	public int backoffice_operating_insert(BackOfficeOperationgTimeVO ovo) {
		logger.info("backoffice_operating_insert_DAOImpl()...");
		logger.info("{}", ovo);

		int flag = sqlSession.insert("SQL_INSERT_OPERRATING_TIME",ovo);

		return flag;
	}

	@Override
	public AuthVO backoffice_authok_select(BackOfficeVO bvo) {
		logger.info("backoffice_auth_select()...");
		logger.info("{}", bvo);

		AuthVO avo = sqlSession.selectOne("SQL_SELECT_BACKOFFICE_AUTHOK",bvo);
		
		return avo;
	}

	@Override
	public BackOfficeVO backoffice_login(BackOfficeVO bvo) {
		logger.info("backoffice_login()...");
		logger.info("{}", bvo);

		String originText = bvo.getBackoffice_pw();

		String encText = aes.encryptAES("0123456789abcdefghij0123456789ab", originText, true);
		logger.info("encText (encodeBase64URLSafeString) : " + encText);
		
		bvo.setBackoffice_pw(encText);
		
		BackOfficeVO bvo2 = sqlSession.selectOne("SQL_BACKOFFICE_LOGIN", bvo);	
		
		return bvo2;
	}

	@Override
	public BackOfficeVO backoffice_id_email_select(BackOfficeVO bvo) {
		logger.info("backoffice_auth_select()...");
		logger.info("{}", bvo);

		BackOfficeVO bvo2 = sqlSession.selectOne("SQL_SELECT_BACKOFFICE_ID_EMAIL",bvo);
		
		return bvo2;
	}

	@Override
	public int backoffice_settingOK_pw(BackOfficeVO bvo) {
		logger.info("backoffice_settingOK_pw()...");
		logger.info("{}", bvo);

		String originText = bvo.getBackoffice_pw();

		String encText = aes.encryptAES("0123456789abcdefghij0123456789ab", originText, true);
		logger.info("encText (encodeBase64URLSafeString) : " + encText);
		
		bvo.setBackoffice_pw(encText);
		
		int flag = sqlSession.update("SQL_UPDATE_BACKOFFICE_SETTINGOK_PW",bvo);

		return flag;
	}

	@Override
	public BackOfficeVO backoffice_setting_selectOne(BackOfficeVO bvo) {
		logger.info("backoffice_setting_selectOne()..");
		logger.info("{}", bvo);
		
		BackOfficeVO bvo2 = sqlSession.selectOne("SQL_SELECTONE_BACKOFFICE_SETTING",bvo);
		
		return bvo2;
	}

	@Override
	public BackOfficeVO backoffice_select_pw(BackOfficeVO bvo) {
		logger.info("backoffice_pw_findOK()...");
		logger.info("{}", bvo);

		String originText = bvo.getBackoffice_pw();

		String encText = aes.encryptAES("0123456789abcdefghij0123456789ab", originText, true);
		logger.info("encText (encodeBase64URLSafeString) : " + encText);
		
		bvo.setBackoffice_pw(encText);
		
		BackOfficeVO bvo2 = sqlSession.selectOne("SQL_SELECT_BACKOFFICE_PW",bvo);

		return bvo2;
	}

	@Override
	public int backoffice_setting_delete(BackOfficeVO bvo) {
		logger.info("backoffice_setting_delete()...");
		logger.info("{}", bvo);

		int flag = sqlSession.update("SQL_UPDATE_BACKOFFICE_SETTING_O",bvo);

		return flag;
	}

}
