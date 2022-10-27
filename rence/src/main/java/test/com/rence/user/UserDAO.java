package test.com.rence.user;

public interface UserDAO {

	public int user_insertOK(UserVO uvo); // 회원가입완료	

	public UserVO idCheckOK(UserVO uvo); //아이디중복체크

	public UserVO emailCheckOK(UserVO uvo); //이메일중복체크
	
	public UserVO authCheckOK(UserVO uvo); //이메일인증

	public UserVO User_loginOK(UserVO uvo); // 로그인

//	public UserVO user_selectOne(UserVO uvo);// 
//
//	public int user_update(UserVO uvo); //회원정보 수정
//
//	public int user_delete(UserVO uvo); //회원탈퇴
//
//	public String selectOne_name(String no);
//
//	public String selectOne_id(String email); //아이디 찾기
//
//	public String selectOne_pw(String email); //비밀번호 찾기
//

//
//	public UserVO selectOne_mypage(String no); // 마이페이지
	
	
}// end interface
