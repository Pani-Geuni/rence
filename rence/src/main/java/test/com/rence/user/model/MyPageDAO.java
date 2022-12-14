/**
	 * @author 강경석
	 *  로그인이 되지 않았을시 Intercept하여 로그인페이지로 이동할수 있도록 하는 기능의 구현
*/


package test.com.rence.user.model;

import java.util.List;

public interface MyPageDAO {

	public List<MyPageReserveListVO> select_all_now_reserve_list(String user_no);
	public List<MyPageReserveListVO> select_all_before_reserve_list(String user_no);
	public List<MyPage_ReviewVO> select_all_review(String user_no);
	
	public List<QuestionVO> select_all_question(String user_no);
	public QuestionVO select_one_answer(String mother_no);
	public ReserveInfoVO select_one_reserve_info(String reserve_no);
	public UserVO select_one_user_info(String user_no);
	
	public int delete_review(String review_no);
	public int delete_comment(String comment_no);
	
	
}// end interface
