/**
 * 
 * @author 최진실
 *
 */
package test.com.rence.backoffice;

import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import test.com.rence.sendemail.AES256Util;
import test.com.rence.sendemail.AuthVO;
import test.com.rence.user.model.SHA256;

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

		BackOfficeVO bvo2 = sqlSession.selectOne("SQL_SELECT_BACKOFFICE_EMAIL", bvo);

		return bvo2;
	}

	@Override
	public BackOfficeVO backoffice_insertOK(BackOfficeVO bvo) {
		logger.info("insert()...");
		logger.info("{}", bvo);

		BackOfficeVO bvo2 = null;
		int flag = sqlSession.insert("SQL_INSERT_BACKOFFICE", bvo);
		if (flag == 1) {
			bvo2 = sqlSession.selectOne("SQL_SELECT_BACKOFFICE_NO", bvo);
		}

		return bvo2;
	}

	@Override
	public AuthVO backoffice_auth_insert(AuthVO avo) {
		logger.info("backoffice_auth_insert_DAOImpl()...");
		logger.info("{}", avo);

		AuthVO avo2 = null;
		int result = sqlSession.insert("SQL_INSERT_BACKOFFICE_AUTH", avo);
		if (result == 1) {
			avo2 = sqlSession.selectOne("SQL_SELECT_BACKOFFICE_AUTH", avo);
			logger.info("avo:{}", avo2);
		}

		return avo2;
	}

	@Override
	public int backoffice_operating_insert(BackOfficeOperatingTimeVO_datetype ovo) {
		logger.info("backoffice_operating_insert_DAOImpl()...");
		logger.info("{}", ovo);

		int flag = sqlSession.insert("SQL_INSERT_OPERRATING_TIME", ovo);

		return flag;
	}

	@Override
	public AuthVO backoffice_authok_select(String backoffice_email, String auth_code) {
		logger.info("backoffice_auth_select()...");
		logger.info("{}", backoffice_email);
		logger.info("{}", auth_code);

		Map<String, String> map = new HashMap<String, String>();
		map.put("auth_code", auth_code);
		map.put("backoffice_email", backoffice_email);

		AuthVO avo2 = sqlSession.selectOne("SQL_SELECT_BACKOFFICE_AUTHOK", map);

		return avo2;
	}

	@Override
	public int backoffice_auth_delete(AuthVO avo2) {
		logger.info("backoffice_auth_delete()...");
		logger.info("{}", avo2);

		int flag = sqlSession.delete("SQL_DELETE_BACKOFFICE_AUTH", avo2);

		return flag;
	}

	@Override
	public BackOfficeVO backoffice_login(BackOfficeVO bvo) {
		logger.info("backoffice_login()...");
		logger.info("{}", bvo);

		BackOfficeVO bvo2 = sqlSession.selectOne("SQL_BACKOFFICE_LOGIN", bvo);

		return bvo2;
	}

	@Override
	public BackOfficeVO backoffice_id_email_select(BackOfficeVO bvo) {
		logger.info("backoffice_auth_select()...");
		logger.info("{}", bvo);

		BackOfficeVO bvo2 = sqlSession.selectOne("SQL_SELECT_BACKOFFICE_ID_EMAIL", bvo);

		return bvo2;
	}

	@Override
	public int backoffice_settingOK_pw(BackOfficeVO bvo) {
		logger.info("backoffice_settingOK_pw()...");
		logger.info("{}", bvo);

		// String originText = bvo.getBackoffice_no();

		// backoffice_no decoding
		// String decText = aes.decryptAES("0123456789abcdefghij0123456789ab",
		// originText);

		Decoder decoder = Base64.getDecoder();
		byte[] decodedBytes2 = decoder.decode(bvo.getBackoffice_no());

		bvo.setBackoffice_no(new String(decodedBytes2));

		int flag = sqlSession.update("SQL_UPDATE_BACKOFFICE_SETTINGOK_PW", bvo);

		return flag;
	}

	@Override
	public int backoffice_resetOK_pw(BackOfficeVO bvo2){

		SHA256 sha256 = new SHA256();

		String sha_random_pw = null;
		try {
			sha_random_pw = sha256.encrypt(bvo2.getBackoffice_pw()); 
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		bvo2.setBackoffice_pw(sha_random_pw);

		int flag = sqlSession.update("SQL_UPDATE_BACKOFFICE_SETTINGOK_PW", bvo2);

		return flag;
	}

}
