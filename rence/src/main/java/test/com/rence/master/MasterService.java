/**
 * 
 * @author 최진실
 *
 */
package test.com.rence.master;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.com.rence.backoffice.BackOfficeVO;

@Service
public class MasterService {
	private static final Logger logger = LoggerFactory.getLogger(MasterService.class);

	@Autowired
	MasterDAO dao;

	public MasterVO master_login(MasterVO mvo) {
		logger.info("master_login()...");
		logger.info("mvo:{}",mvo);
		return dao.master_login(mvo);
	}

	public List<BackOfficeVO> backoffice_applyList_selectAll() {
		logger.info("backoffice_applyList_selectAll()...");
		return dao.backoffice_applyList_selectAll();
	}

	public int backoffice_grant(BackOfficeVO bvo) {
		logger.info("backoffice_grant()...");
		return dao.backoffice_grant(bvo);
	}

	public int backoffice_refuse(BackOfficeVO bvo) {
		logger.info("backoffice_refuse()...");
		return dao.backoffice_refuse(bvo);
	}

	public List<BackOfficeVO> backoffice_endList_selectAll() {
		logger.info("backoffice_endList_selectAll()...");
		return dao.backoffice_endList_selectAll();
	}

	public int backoffice_revoke(BackOfficeVO bvo) {
		logger.info("backoffice_revoke()...");
		return dao.backoffice_revoke(bvo);
	}

	public BackOfficeVO master_backoffice_detail_selectOne(BackOfficeVO bvo) {
		logger.info("master_backoffice_detail_selectOne()...");
		return dao.master_backoffice_detail_selectOne(bvo);
	}
}
