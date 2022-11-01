package test.com.rence.user.model;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import test.com.rence.sendemail.AuthVO;

@Repository
public class UserDAOimpl implements UserDAO {

	private static final Logger logger = LoggerFactory.getLogger(UserDAOimpl.class);
	@Autowired
	SqlSession sqlSession;


	// 아이디 중복체크 
	@Override
	public UserVO idCheckOK(UserVO uvo) {
		logger.info("idCheckOK().....");
		logger.info("uvo {}", uvo);
		UserVO uvo2 = sqlSession.selectOne("SQL_ID_CHECK", uvo);
		logger.info("uvo2: {}", uvo2);
		return uvo2;
	}

	// 이메일 중복체크
	@Override
	public UserVO emailCheckOK(UserVO uvo) {
		logger.info("emailCheckOK().....");
		logger.info("{}", uvo);
		UserVO uvo2 = sqlSession.selectOne("SQL_EMAIL_CHECK", uvo);
		logger.info("uvo2: {}", uvo2);
		return uvo2;
	}

	// 회원가입 - 인증시 인증번호 테이블에 저장
	@Override
	public AuthVO user_auth_insert(AuthVO avo) {
		logger.info("user_auth_insert()...");
		logger.info("{}", avo);

		AuthVO avo2 = null;
		int result = sqlSession.insert("SQL_INSERT_USER_AUTH", avo);
		logger.info("result {}", result);
		if (result == 1) {
			avo2 = sqlSession.selectOne("SQL_SELECT_USER_AUTH", avo);
			logger.info("avo:{}", avo2);
		}

		return avo2;
	}
	
	// 회원가입 - 인증번호 확인 완료 시 테이블에서 삭제
	@Override
	public int user_auth_delete(String user_email, String email_code) {
		logger.info("user_auth_delete()...");
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("user_email", user_email);
		map.put("email_code", email_code);
		int result = sqlSession.delete("SQL_AUTH_DELETE", map);
		
		return result;
	}

	@Override
	public AuthVO user_authOK_select(String user_email, String email_code) {
		logger.info("user_authOK_select()...");
		logger.info("{}", email_code);

		Map<String, String> map = new HashMap<String, String>();
		map.put("user_email", user_email);
		map.put("email_code", email_code);

		AuthVO avo2 = sqlSession.selectOne("SQL_SELECT_USER_AUTHOK", map);
		logger.info("avo2(impl): {}", avo2);

		return avo2;
	}
	
	

	// 회원가입완료
	@Override
	public int user_insertOK(UserVO uvo) {
		logger.info("user_insertOK().....");
		logger.info("{}", uvo);

		int flag = sqlSession.insert("SQL_INSERT", uvo);

		return flag;
	}
	

	@Override
	public UserVO user_select_userno() {
		logger.info("user_authOK_select()...");
		UserVO uvo2 = sqlSession.selectOne("SQL_USER_USERNO");
		logger.info("uvo2:--- {}", uvo2);

		return uvo2;
	}
	
	//회원가입 완료시 마일리지테이블에 사용자 마일리지 0 삽입
		@Override
		public int user_mileage_zero_insert(UserVO uvo) {
			logger.info("user_mileage_zero_insert().....");
			logger.info("{}", uvo);

			int flag = sqlSession.insert("SQL_INSERT_MILEAGE_ZERO_INSERT", uvo);

			return flag;
		}

	// 로그인
	@Override
	public UserVO User_loginOK(UserVO uvo) {
		logger.info("User_login().....");
		logger.info("{}", uvo);
		UserVO uvo2 = sqlSession.selectOne("SQL_USER_LOGIN", uvo);

		if(uvo2 != null) {
			// 꼭 N하고 띄어쓰기 3번 있어야 함 -> 버그인지 모르겠지만 sqldeveloper에 저런식으로 저장되어서 어쩔 수 없음
			if (uvo2.getUser_state().trim().equals("N")) {
				uvo2 = null;
			}
		}

		return uvo2;
	}

	// 아이디 찾기를 위한 이메일 체크
	@Override
	public UserVO user_email_select(UserVO uvo) {
		logger.info("user_email_select().....");
		logger.info("{}", uvo);
		UserVO uvo2 = sqlSession.selectOne("SQL_SELECT_EMAIL", uvo);

		return uvo2;
	}

	// 비밀번호 찾기를 위한 아이디 이메일 체크
	@Override
	public UserVO user_id_email_select(UserVO uvo) {
		logger.info("user_id_email_select().....");
		UserVO uvo2 = sqlSession.selectOne("SQL_SELECT_USER_ID_EMAIL", uvo);

		return uvo2;
	}

	// 비밀번호 찾기에서 랜덤난수로 비밀번호 초기화후 SHA256으로 암호화 한뒤 데이터베이스에 업데이트
	@Override
	public int user_pw_init(UserVO uvo) {
		logger.info("user_pw_init().....");
		logger.info("UserVO: {}", uvo);
		
		
		SHA256 sha256 = new SHA256();

		String sha_random_pw = null;
		try {
			sha_random_pw = sha256.encrypt(uvo.getUser_pw()); // 랜덤난수로 초기화비밀번호 생성한뒤 암호화
			logger.info("SHA 256 OK!!", uvo.getUser_pw());
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("sha_random_pw: {}", sha_random_pw);
		logger.info("Before _pw: {}", uvo.getUser_pw());	
		// userVO에 세팅
		uvo.setUser_pw(sha_random_pw);
		logger.info("After _pw: {}", uvo.getUser_pw());

		int flag = sqlSession.update("SQL_USER_UPDATE_PW_INIT", uvo);

		return flag;
	}
	
	// 마이페이지-비밀번호 수정(현재 비밀번호 확인)
	@Override
	public int check_now_pw(UserVO uvo) {
		logger.info("check_now_pw().....");
		
		int result = sqlSession.selectOne("SQL_SELECT_PW", uvo);
		logger.info("result : {}", result);
		
		return result;
	}

	// 마이페이지-비밀번호 수정
	@Override
	public int user_pw_updateOK(UserVO uvo) {
		logger.info("user_pw_updateOK().....");
		logger.info("{}", uvo);

		int flag = sqlSession.update("SQL_USER_UPDATE_PW", uvo);

		return flag;
	}

	// 마이페이지-프로필 수정
	@Override
	public int user_img_updateOK(UserVO uvo) {
		logger.info("user_img_updateOK().....");
		logger.info("{}", uvo);

		int flag = sqlSession.update("SQL_USER_UPDATE_IMG", uvo);
		logger.info("after uvo: {}", uvo);
		return flag;
	}

	// 마이페이지-회원탈퇴
	@Override
	public int user_secedeOK(UserVO uvo) {
		logger.info("user_secedeOK().....");
		logger.info("{}", uvo);

		int flag = sqlSession.update("SQL_USER_SECEDE", uvo);

		return flag;
	}

	// 마이페이지에 정보 뿌려주기
	@Override
	public UserMypageVO user_mypage_select(UserVO uvo) {
		logger.info("user_mypage_select().....");
		logger.info("{}", uvo); // 유저의 정보를 출력
		UserMypageVO umvo = sqlSession.selectOne("SQL_SELECT_USER_MYPAGE", uvo);

		return umvo;
	}

	
	

	//마일리지 상세페이지에 총 마일리지 정보 제공
	@Override
	public UserMileageVO user_mileage_selectOne(UserVO uvo) {
		logger.info("user_mileage_selectOne().....");
		logger.info("{}", uvo); // 유저의 정보를 출력
		
		UserMileageVO umvo = sqlSession.selectOne("SQL_SELECTONE_USER_MILEAGE", uvo);

		return umvo;
	}

	//마일리지 상세페이지에 정보 제공
	@Override
	public List<UserMileageVO> user_mileage_selectAll(UserVO uvo) {
		logger.info("user_mileage_selectAll().....");
		logger.info("{}", uvo); // 유저의 정보를 출력
		
		
		List<UserMileageVO> vos = sqlSession.selectList("SQL_SELECTALL_USER_MILEAGE", uvo);
		logger.info("user_mileage_selectAll().....OK");
		return vos;
	}
	
	//마일리지 적립,사용 조회
	public List<UserMileageVO> user_mileage_search_list(UserVO uvo, String searchKey) {
		logger.info("user_mileage_search_list().....");
		logger.info("{}", searchKey); // 유저의 정보를 출력
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("user_no",uvo.getUser_no());
		map.put("searchKey", searchKey);
		
		List<UserMileageVO> vos = sqlSession.selectList("SQL_USER_MILEAGE_SEARCH_LIST", map);
		logger.info("user_mileage_search_list().....OK");
		return vos;
	}
	
	
	
	

	
	

}// end class
