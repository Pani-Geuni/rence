package test.com.rence.user;

import java.util.List;

public interface MyPageDAO {

	public List<MyPageReserveListVO> select_all_now_reserve_list(String user_no);
	public List<MyPageReserveListVO> select_all_before_reserve_list(String user_no);
	public List<ReviewVO> select_all_review(String user_no);
	
	
}// end interface
