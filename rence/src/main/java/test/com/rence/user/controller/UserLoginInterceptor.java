/**
	 * @author 강경석
	 *  로그인이 되지 않았을시 Intercept하여 로그인페이지로 이동할수 있도록 하는 기능의 구현
*/


package test.com.rence.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class UserLoginInterceptor extends HandlerInterceptorAdapter {
	private static final Logger logger = LoggerFactory.getLogger(UserLoginInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 서블릿 패스 요청되고 나서 서블릿 함수 호출전에 동작
		String sPath = request.getServletPath();
		logger.info("preHandle: {}", sPath);

		HttpSession session = request.getSession();
		String user_id = (String) session.getAttribute("user_id");
		logger.info("session user_id: {}", session.getAttribute("user_id"));

		 
		if (sPath.equals("/go_my_page") ||sPath.equals("/selectOne") || sPath.equals("/secedeOK")
			|| sPath.equals("/go_now_reserve") || sPath.equals("/go_before_reserve")
			|| sPath.equals("/go_mileage") || sPath.equals("/mileage_search_list")
			|| sPath.equals("/go_question_list") || sPath.equals("user_pw_updateOK")
			|| sPath.equals("/check_now_pw") || sPath.equals("/user_img_updateOK")
			|| sPath.equals("/reserve_list") || sPath.equals("/review_list")
			|| sPath.equals("/delete_review") || sPath.equals("/question_list")
			|| sPath.equals("/reserve_detail_before") || sPath.equals("/reserve_detail_now")
			|| sPath.equals("/user_logoutOK") || sPath.equals("")
			|| sPath.equals("/reserve_list") || sPath.equals("/reserve_info") || sPath.equals("/reserved_info")

			)
		{
			//로그인이 되지 않으면 홈페이지로 이동
			if (user_id == null) {
				response.sendRedirect("home");
				return false;
			}
		}

		return true;
	}

}//end class