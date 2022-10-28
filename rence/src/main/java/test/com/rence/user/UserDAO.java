package test.com.rence.user;

import test.com.rence.sendemail.AuthVO;

public interface UserDAO {

	public int user_insertOK(UserVO uvo); // 회원가입완료	

	public UserVO idCheckOK(UserVO uvo); //아이디중복체크

	public UserVO emailCheckOK(UserVO uvo); //이메일중복체크
	
	public UserVO User_loginOK(UserVO uvo); // 로그인
	
	public UserVO user_email_select(UserVO uvo); // 아이디 찾기에서 이메일 확인

	public UserVO user_id_email_select(UserVO uvo); //비밀번호 찾기에서 아이디,이메일 확인
	
	int user_pw_init(UserVO uvo); //비밀번호 찾기 - 난수를 통해 비밀번호 초기화

	public int user_pw_updateOK(UserVO uvo); //회원정보(마이페이지)-비밀번호 수정
	
	public int user_img_updateOK(UserVO uvo); ////회원정보(마이페이지)- 프로필 수정

	public int user_secedeOK(UserVO uvo); //회원탈퇴 
	
	public UserMypageVO user_mypage_select(UserVO uvo); // 마이페이지에 정보를 넘겨주는 기능

	public AuthVO user_auth_insert(AuthVO avo); //이메일 인증 인증번호 저장

	public AuthVO user_authOK_select(String email_code); //이메일 인증 인증번호 비교

	
	
	
//	public UserVO user_selectOne(UserVO uvo);// 
	
//	public int user_delete(UserVO uvo); //회원탈퇴
//
//	public String selectOne_name(String no);
//



//
//	public UserVO selectOne_mypage(String no); // 마이페이지
	
	
}// end interface
