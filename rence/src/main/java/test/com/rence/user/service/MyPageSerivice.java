package test.com.rence.user.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.com.rence.user.model.MyPageDAO;
import test.com.rence.user.model.MyPageReserveListVO;
import test.com.rence.user.model.MyPage_ReviewVO;
import test.com.rence.user.model.QuestionVO;

@Service
public class MyPageSerivice {

	private static final Logger logger = LoggerFactory.getLogger(MyPageSerivice.class);

	@Autowired
	MyPageDAO dao;

	public MyPageSerivice() {
		logger.info("MyPageSerivice()...");
	}

	public List<MyPageReserveListVO> select_all_now_reserve_list(String user_no){
		List<MyPageReserveListVO> list = dao.select_all_now_reserve_list(user_no);
		
		return list;
	}
	
	public List<MyPageReserveListVO> select_all_before_reserve_list(String user_no){
		List<MyPageReserveListVO> list = dao.select_all_before_reserve_list(user_no);
		
		return list;
	}
	
	public List<MyPage_ReviewVO> select_all_review(String user_no){
		List<MyPage_ReviewVO> list = dao.select_all_review(user_no);
		
		return list;
	}
	
	public int delete_review(String review_no){
		int result = dao.delete_review(review_no);
		
		return result;
	}
	
	public List<QuestionVO> select_all_question(String user_no){
		List<QuestionVO> list = dao.select_all_question(user_no);
		
		return list;
	}
	
	public QuestionVO select_one_answer(String mother_no){
		QuestionVO vo = dao.select_one_answer(mother_no);
		
		return vo;
	}
	

}// end class
