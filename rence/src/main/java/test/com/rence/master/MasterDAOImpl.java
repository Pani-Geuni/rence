/**
 * 
 * @author 최진실
 *
 */
package test.com.rence.master;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import test.com.rence.backoffice.BackOfficeVO;
import test.com.rence.sendemail.AES256Util;

@Repository
public class MasterDAOImpl implements MasterDAO {
	private static final Logger logger = LoggerFactory.getLogger(MasterDAOImpl.class);

	@Autowired
	SqlSession sqlSession;

	@Autowired
	AES256Util aes;

	@Override
	public MasterVO master_login(MasterVO mvo) {

		MasterVO vo2 = sqlSession.selectOne("SQL_MASTER_LOGIN", mvo);

		return vo2;
	}

	@Override
	public List<BackOfficeVO> backoffice_applyList_selectAll() {
		logger.info("backoffice_applyList_selectAll...DAOImpl()...");

		List<BackOfficeVO> vos = sqlSession.selectList("SQL_SELECT_ALL_BACKOFFICE_APPLY");

		return vos;
	}

	@Override
	public int backoffice_grant(BackOfficeVO bvo) {
		logger.info("backoffice_grant...DAOImpl()...");

		int result = sqlSession.update("SQL_UPDATE_BACKOFFICE_STATE_Y", bvo);

		return result;
	}

	@Override
	public int backoffice_refuse(BackOfficeVO bvo) {
		logger.info("backoffice_refuse...DAOImpl()...");

		int result = sqlSession.update("SQL_UPDATE_BACKOFFICE_STATE_N", bvo);

		return result;
	}

	@Override
	public List<BackOfficeVO> backoffice_endList_selectAll() {
		logger.info("backoffice_endList_selectAll...DAOImpl()...");

		List<BackOfficeVO> vos = sqlSession.selectList("SQL_SELECT_ALL_BACKOFFICE_END");

		return vos;
	}

	@Override
	public int backoffice_revoke(BackOfficeVO bvo) {
		logger.info("backoffice_revoke...DAOImpl()...");

		int result = sqlSession.update("SQL_UPDATE_BACKOFFICE_STATE_X", bvo);

		return result;
	}

	@Override
	public BackOfficeVO master_backoffice_detail_selectOne(BackOfficeVO bvo) {
		logger.info("master_backoffice_detail_selectOne()..");
		logger.info("{}", bvo);
		
		BackOfficeVO bvo2 = sqlSession.selectOne("SQL_SELECTONE_BACKOFFICE_DETAIL_M",bvo);
		
//		String[] option = bvo2.getBackoffice_option().split(",");
		
		return bvo2;
	}
}
