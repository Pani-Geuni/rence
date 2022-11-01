package test.com.rence.user.model;

import java.util.List;

public interface MyPageDAO {

	public List<MyPageReserveListVO> select_all_now_reserve_list(String user_no);
	public List<MyPageReserveListVO> select_all_before_reserve_list(String user_no);
	public List<MyPage_ReviewVO> select_all_review(String user_no);
	
	public List<QuestionVO> select_all_question(String user_no);
	public QuestionVO select_one_answer(String mother_no);
	
	public int delete_review(String review_no);
	
	
}// end interface
