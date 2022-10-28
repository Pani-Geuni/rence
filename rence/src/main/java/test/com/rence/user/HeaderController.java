/**
 * @author 강경석
 * 마이페이지 페이징
 * 회원 탈퇴
 */

package test.com.rence.user;

import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HeaderController {

	private static final Logger logger = LoggerFactory.getLogger(HeaderController.class);

	@Autowired
	UserSerivice service;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	//마이페이지 이동
	@RequestMapping(value = "/go_my_page", method = RequestMethod.GET)
	public String go_my_page(Model model, HttpServletRequest request) {
		logger.info("go_my_page()...");
		
//		String user_no = null;
//		UserVO uvo = new UserVO();
//		
//		Cookie[] cookies = request.getCookies();
//		for(Cookie c : cookies) {
//			if(c.getName().equals("user_no")) {
//				user_no = c.getValue();
//			}
//		  }
//		uvo.setUser_no(user_no);
//		
//		UserMypageVO umvo = service.user_mypage_select(uvo);
//		
//		model.addAttribute("umvo",umvo);

		return ".my_page/my_page";
	}

}// end class
