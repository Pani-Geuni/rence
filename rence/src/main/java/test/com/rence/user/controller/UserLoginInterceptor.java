//로그인이 되지 않았을시 Intercept하여 로그인페이지로 이동할수 있도록 하는 기능의 구현

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

		//221027기준 유저의 기본적인 페이지 servlet 기입한 상태임. 
		//추후 예약페이지나 기타페이지를 controller에서 구현후 추가 기입이 필요함 (추후 완료시 주석 제거하기!!!)
		if (sPath.equals("/go_my_page") ||sPath.equals("/selectOne")
			|| sPath.equals("/user_delete.do") || sPath.equals("/user_deleteOK.do")){
			//로그인이 되지 않으면 로그인 페이지로 이동
			if (user_id == null) {
				response.sendRedirect("login.do");
				return false;
			}
		}

		return true;
	}

}//end class