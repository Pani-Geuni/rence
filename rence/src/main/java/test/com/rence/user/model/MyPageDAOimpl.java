package test.com.rence.user.model;

import java.text.DecimalFormat;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MyPageDAOimpl implements MyPageDAO {

	private static final Logger logger = LoggerFactory.getLogger(MyPageDAOimpl.class);
	
	@Autowired
	SqlSession sqlSession;

	@Override
	public List<MyPageReserveListVO> select_all_now_reserve_list(String user_no) {
		List<MyPageReserveListVO> list = sqlSession.selectList("SQL_SELECT_ALL_NOW_RESERVE", user_no);
		
		if(list != null) {
			for(MyPageReserveListVO vo : list) {
				DecimalFormat dc = new DecimalFormat("###,###,###,###");	
				String ch = dc.format(Integer.parseInt(vo.getPayment_total()));
				vo.setPayment_total(ch);
				
				String road_name = vo.getRoadname_address().split(" ")[0] + " " + vo.getRoadname_address().split(" ")[1];
				vo.setRoadname_address(road_name);
			}
		}
		
		return list;
	}
	
	@Override
	public List<MyPageReserveListVO> select_all_before_reserve_list(String user_no) {
		List<MyPageReserveListVO> list = sqlSession.selectList("SQL_SELECT_ALL_BEFORE_RESERVE", user_no);
		
		if(list != null) {
			for(MyPageReserveListVO vo : list) {
				DecimalFormat dc = new DecimalFormat("###,###,###,###");	
				String ch = dc.format(Integer.parseInt(vo.getPayment_total()));
				vo.setPayment_total(ch);
				
				String road_name = vo.getRoadname_address().split(" ")[0] + " " + vo.getRoadname_address().split(" ")[1];
				vo.setRoadname_address(road_name);
			}
		}
		
		
		return list;
	}
	
	@Override
	public List<MyPage_ReviewVO> select_all_review(String user_no) {
		List<MyPage_ReviewVO> list = sqlSession.selectList("SQL_SELECT_ALL_REVIEW", user_no);		
		
		return list;
	}
	
	@Override
	public List<QuestionVO> select_all_question(String user_no) {
		List<QuestionVO> list = sqlSession.selectList("SQL_SELECT_ALL_QUESTION", user_no);		
		
		return list;
	}
	
	@Override
	public QuestionVO select_one_answer(String mother_no){
		QuestionVO vo = sqlSession.selectOne("SQL_SELECT_ONE_ANSWER", mother_no);		
		
		return vo;
	}
	
	@Override
	public int delete_review(String review_no) {
		int result = sqlSession.delete("SQL_DELETE_REVIEW", review_no);
		
		return result;
	}
	
	@Override
	public int delete_comment(String comment_no) {
		int result = sqlSession.delete("SQL_DELETE_COMMENT", comment_no);
		
		return result;
	}
	
	@Override
	public ReserveInfoVO select_one_reserve_info(String reserve_no){
		ReserveInfoVO vo = sqlSession.selectOne("SQL_SELECT_ONE_RESERVE_INFO", reserve_no);		
		
		if(vo != null) {
			if(vo.getRoom_type().equals("office")) vo.setRoom_type("오피스");
			if(vo.getRoom_type().equals("desk")) vo.setRoom_type("desk");
			if(vo.getRoom_type().equals("meeting_room")) vo.setRoom_type("회의룸");
			
			DecimalFormat dc = new DecimalFormat("###,###,###,###");	
			String pt = dc.format(Integer.parseInt(vo.getPayment_total()));
			vo.setPayment_total(pt);
			
			String ap = dc.format(Integer.parseInt(vo.getActual_payment()));
			vo.setActual_payment(ap);
			
			String mc = dc.format(Integer.parseInt(vo.getMileage_change()));
			vo.setMileage_change(mc);
			
			String rp = dc.format(Integer.parseInt(vo.getRoom_price()));
			vo.setRoom_price(rp);
		}
		
		return vo;
	}
	
	@Override
	public UserVO select_one_user_info(String user_no){
		UserVO vo = sqlSession.selectOne("SQL_SELECT_ONE_USER_INFO", user_no);		
		
		return vo;
	}
	

}// end class
