package test.com.rence.user;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.com.rence.sendemail.AuthVO;

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
	
	public List<ReviewVO> select_all_review(String user_no){
		List<ReviewVO> list = dao.select_all_review(user_no);
		
		return list;
	}
	

}// end class
