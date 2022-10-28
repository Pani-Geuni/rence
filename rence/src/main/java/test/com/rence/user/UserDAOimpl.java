package test.com.rence.user;

import java.util.Random;

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

	// 회원가입완료
	@Override
	public int user_insertOK(UserVO uvo) {
		logger.info("user_insertOK().....");
		logger.info("{}", uvo);

		int flag = sqlSession.insert("SQL_INSERT", uvo);

		return flag;
	}

	// 아이디 중복체크
	@Override
	public UserVO idCheckOK(UserVO uvo) {
		logger.info("idCheckOK().....");
		UserVO uvo2 = sqlSession.selectOne("SQL_ID_CHECK", uvo);

		return uvo2;
	}

	// 이메일 중복체크
	@Override
	public UserVO emailCheckOK(UserVO uvo) {
		logger.info("emailCheckOK().....");
		UserVO uvo2 = sqlSession.selectOne("SQL_EMAIL_CHECK", uvo);

		return uvo2;
	}

	// 이메일 인증
	@Override
	public UserVO authCheckOK(UserVO uvo) {
		// TODO Auto-generated method stub
		return null;
	}

	// 로그인
	@Override
	public UserVO User_loginOK(UserVO uvo) {
		logger.info("User_login().....");
		logger.info("{}", uvo);
		uvo = sqlSession.selectOne("SQL_USER_LOGIN", uvo);

		return uvo;

	}

	// 아이디 찾기를 위한 이메일 체크
	@Override
	public UserVO user_email_select(UserVO uvo) {
		logger.info("user_email_select().....");
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

	// 비밀번호 찾기에서 랜덤난수로 비밀번호 초기화
	@Override
	public int user_pw_init(UserVO uvo) {
		logger.info("user_pw_init().....");
		// 10자리 int형 랜덤난수 생성

		Random random=new Random(); // 랜덤 함수 선언
		int createNum=0; // 1자리 난수
		String ranNum=""; // 1자리 난수 형변환 변수
		int len=10; // 난수 자릿수
		String random_pw=""; // 결과 난수

		for(int i=0;i<len;i++){

		createNum=random.nextInt(9); // 0부터 9까지 올 수 있는 1자리 난수 생성
		ranNum=Integer.toString(createNum); // 1자리 난수를 String으로 형변환
		random_pw+=ranNum; // 생성된 난수(문자열)을 원하는 수(len)만큼 더하며 나열
		}

		// userVO에 세팅
		uvo.setUser_pw(random_pw);;

		int flag=sqlSession.update("SQL_USER_UPDATE_PW_INIT",uvo);

		return flag;
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

	@Override
	public UserMypageVO user_mypage_select(UserVO uvo) {
		logger.info("user_mypage_select().....");
		logger.info("{}", uvo); //유저의 정보를 출력
		UserMypageVO umvo = sqlSession.selectOne("SQL_SELECT_USER_MYPAGE", uvo);

		return umvo;
	}
	
	

}//end class
