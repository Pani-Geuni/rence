/**
 * 
 * @author 최진실
 *
 */
package test.com.rence.backoffice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.com.rence.sendemail.AuthVO;

@Service
public class BackOfficeService {
	private static final Logger logger = LoggerFactory.getLogger(BackOfficeService.class);


	@Autowired
	BackOfficeDAO dao;
	
	public BackOfficeService() {
		logger.info("BackOfficeService()...");
	}
	
	//이메일 중복체크
	public BackOfficeVO backoffice_email_check(BackOfficeVO bvo) {
		logger.info("backoffice_email_check()...");
		return dao.backoffice_email_check(bvo);
	}
	
	//인증 번호 삽입
	public AuthVO backoffice_auth_insert(AuthVO avo) {
		logger.info("backoffice_auth_insert()...");
		return dao.backoffice_auth_insert(avo);
	}

	//인증번호 삽입 후, 결과 검색
//	public AuthVO backoffice_auth_select(AuthVO avo) {
//		logger.info("backoffice_auth_select()...");
//		return dao.backoffice_auth_select(avo);
//	}

	
	//인증 번호 검색
	public AuthVO backoffice_authOK_select(AuthVO avo) {
		logger.info("backoffice_auth_select()...");
		return dao.backoffice_authok_select(avo);
	}
	
	// 백오피스 삽입
	public BackOfficeVO backoffice_insertOK(BackOfficeVO bvo) {
		logger.info("backoffice_insertOK()...");
		return dao.backoffice_insertOK(bvo);
	}

	// 운영시간 삽입
	public int backoffice_operating_insert(BackOfficeOperationgTimeVO_datetype ovo2) {
		logger.info("backoffice_operating_insert()...");
		return dao.backoffice_operating_insert(ovo2);
	}

	//로그인
	public BackOfficeVO backoffice_login(BackOfficeVO bvo) {
		logger.info("backoffice_login()...");
		return dao.backoffice_login(bvo);
	}

	//비밀번호 찾기 전, 이메일 아이디 일치 판단
	public BackOfficeVO backoffice_id_email_select(BackOfficeVO bvo) {
		logger.info("backoffice_id_email_select()...");
		return dao.backoffice_id_email_select(bvo);
	}

	//비밀번호 변경
	public int backoffice_settingOK_pw(BackOfficeVO bvo) {
		logger.info("backoffice_pw_findOK()...");
		return dao.backoffice_settingOK_pw(bvo);
	}

	//환경설정 페이지 출력
	public BackOfficeVO backoffice_setting_selectOne(BackOfficeVO bvo) {
		logger.info("selectOne()...");
		return dao.backoffice_setting_selectOne(bvo);
	}

	//환경설정에서 비밀번호 변경
	public BackOfficeVO backoffice_select_pw(BackOfficeVO bvo) {
		logger.info("backoffice_select_pw()...");
		return dao.backoffice_select_pw(bvo);
	}

	//환경설정에서 업체 삭제 요청
	public int backoffice_setting_delete(BackOfficeVO bvo) {
		logger.info("backoffice_setting_delete()...");
		return dao.backoffice_setting_delete(bvo);
	}

	public int backoffice_auth_delete(AuthVO avo2) {
		logger.info("backoffice_auth_delete()...");
		return dao.backoffice_auth_delete(avo2);
		
	}


}
