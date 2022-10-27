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
	
	//인증 번호 삽입
	public int backoffice_auth_insert(AuthVO vo) {
		logger.info("backoffice_auth_insert()...");
		return dao.backoffice_auth_insert(vo);
	}
	
	//인증 번호 검색
	public AuthVO backoffice_auth_select(BackOfficeVO vo) {
		logger.info("backoffice_auth_select()...");
		return dao.backoffice_auth_select(vo);
	}
	
	// 백오피스 삽입
	public int backoffice_insertOK(BackOfficeVO vo) {
		logger.info("backoffice_insertOK()...");
		return dao.backoffice_insertOK(vo);
	}

	// 운영시간 삽입
	public int backoffice_operating_insert(BackOfficeOperationgTimeVO ovo) {
		logger.info("backoffice_operating_insert()...");
		return dao.backoffice_operating_insert(ovo);
	}

	//로그인
	public BackOfficeVO backoffice_login(BackOfficeVO vo) {
		logger.info("backoffice_login()...");
		return dao.backoffice_login(vo);
	}

	//비밀번호 찾기 전, 이메일 아이디 일치 판단
	public BackOfficeVO backoffice_id_email_select(BackOfficeVO vo) {
		logger.info("backoffice_id_email_select()...");
		return dao.backoffice_id_email_select(vo);
	}

	//비밀번호 변경
	public int backoffice_pw_findOK(BackOfficeVO vo) {
		logger.info("backoffice_pw_findOK()...");
		return dao.backoffice_pw_findOK(vo);
	}

}
