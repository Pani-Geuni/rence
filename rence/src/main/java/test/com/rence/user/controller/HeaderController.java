/**
 * @author 강경석
 * 마이페이지 페이징
 * 회원 탈퇴
 */

package test.com.rence.user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.text.DecimalFormat;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import test.com.rence.HomeService;
import test.com.rence.ListVO;
import test.com.rence.user.model.UserMypageVO;
import test.com.rence.user.model.UserVO;
import test.com.rence.user.service.UserSerivice;

@Controller
public class HeaderController {

	private static final Logger logger = LoggerFactory.getLogger(HeaderController.class);

	@Autowired
	UserSerivice service;

	@Autowired
	HomeService service2;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	// 마이페이지 이동
	@RequestMapping(value = "/go_my_page", method = RequestMethod.GET)
	public String go_my_page(Model model, HttpServletRequest request) {
		logger.info("go_my_page()...");

		UserVO uvo = new UserVO();

		String user_no = null;
		Cookie[] cookies = request.getCookies();
		for (Cookie c : cookies) {
			if (c.getName().equals("user_no")) {
				user_no = c.getValue();
			}
		}
		uvo.setUser_no(user_no);

		UserMypageVO umvo = service.user_mypage_select(uvo);
		logger.info("umvo: {}", umvo);
		// 마일리지 콤마단위로 변환
		DecimalFormat dc = new DecimalFormat("###,###,###,###,###");
		umvo.setMileage_total(dc.format(Integer.parseInt(umvo.getMileage_total())));

		model.addAttribute("umvo", umvo);

		return ".my_page/my_page";
	}

	// 서치바 검색
	@RequestMapping(value = "/search_list", method = RequestMethod.GET)
	public String search_list(String type, String location, String searchWord, String condition, Model model) {
		logger.info("search_list()...");

		Map<String, Object> map = new HashMap<String, Object>();

		List<ListVO> list = null;
		list = service2.search_list(type, location, searchWord, condition);

		if (list == null)
			map.put("cnt", 0);
		else
			map.put("cnt", list.size());

		map.put("condition", condition);
		map.put("page", "list_page");
		map.put("list", list);
		model.addAttribute("res", map);

		return ".list";
	}

}// end class
