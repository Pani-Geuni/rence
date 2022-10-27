package test.com.rence.user;

public interface UserDAO {

	public int user_insertOK(UserVO uvo); // ȸ������

	public UserVO idCheckOK(UserVO uvo); //ȸ������ - ���̵� üũ

	public UserVO emailCheckOK(UserVO uvo); //ȸ������ -�̸��� üũ
	
	public UserVO authCheckOK(UserVO uvo); //ȸ������ -������ȣ üũ

//	public UserVO user_selectOne(UserVO uvo);// 
//
//	public int user_update(UserVO uvo); //ȸ������ ������Ʈ(����)
//
//	public int user_delete(UserVO uvo); //ȸ��Ż��
//
//	public String selectOne_name(String no);
//
//	public String selectOne_id(String email); //���̵� ã��
//
//	public String selectOne_pw(String email); //��й�ȣ ã��
//
//	public UserVO login(UserVO uvo); // �α���
//
//	public UserVO selectOne_mypage(String no); // ����������
	
	
}// end interface
