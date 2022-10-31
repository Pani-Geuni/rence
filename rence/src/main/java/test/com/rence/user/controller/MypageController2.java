/**
 * @author 김예은
 * 
 */


package test.com.rence.user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import test.com.rence.user.model.MyPageReserveListVO;
import test.com.rence.user.model.MyPage_ReviewVO;
import test.com.rence.user.service.MyPageSerivice;

@Controller
public class MypageController2 {

	private static final Logger logger = LoggerFactory.getLogger(MypageController2.class);
	
	@Autowired
	MyPageSerivice service;

	
	/**
	 * 예약 리스트 이동
	 */
	@RequestMapping(value = "/reserve_list", method = RequestMethod.GET)
	public String reserve_list(String time_point, String user_no, Model model) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<MyPageReserveListVO> list = null;
		if(time_point.equals("now")) {
			list = service.select_all_now_reserve_list(user_no);
			map.put("type", "now");
		}
		else if(time_point.equals("before")) {
			list = service.select_all_before_reserve_list(user_no);			
			map.put("type", "before");
		}
		
		if(list == null) map.put("cnt", 0);
		else map.put("cnt", list.size());
		
		map.put("list", list);
		map.put("page", "reserve-list");
		model.addAttribute("res", map);
		
		logger.info("reserve_list : {}", map);
		
		return ".my_page/reserve-list";
	}
	
	/**
	 * 후기 리스트 이동
	 */
	@RequestMapping(value = "/review_list", method = RequestMethod.GET)
	public String review_list(String user_no, Model model) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MyPage_ReviewVO> list = service.select_all_review(user_no);
		
		map.put("page", "review");
		map.put("list", list);
		
		model.addAttribute("res", map);
		logger.info("review_list : {}", map);
		
		return ".my_page/review_list";
	}
	
	/**
	 * 후기 내역 페이지 - 댓글 삭제
	 */
	@RequestMapping(value = "/delete_review", method = RequestMethod.GET)
	public String delete_review(String user_no, String review_no, Model model) {
		int result = service.delete_review(review_no);
		
		return "redirect:/review_list?user_no="+user_no;
	}
	
	/**
	 * 문의 리스트 페이지 이동
	 */
	@RequestMapping(value = "/question_list", method = RequestMethod.GET)
	public String question_list(String user_no) {
		
		return ".my_page/question-list";
	}
	
}
