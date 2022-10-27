package test.com.rence.backoffice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class BackOfficeLogin extends HandlerInterceptorAdapter {
	private static final Logger logger = LoggerFactory.getLogger(BackOfficeLogin.class);

	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String sPath = request.getServletPath();
		logger.info("preHandle",sPath);
		
		HttpSession session = request.getSession();
		String backoffice_id = (String) session.getAttribute("backoffice_id");
		logger.info("session backoffice_id: {}", backoffice_id);
		
		if(sPath.equals("/backoffice_main") || sPath.equals("/backoffice_insert_room") || sPath.equals("/backoffice_insertOK_room ") ||sPath.equals("/backoffice_room") ||sPath.equals("/backoffice_update_room") || sPath.equals("/backoffice_updateOK_room ") || sPath.equals("/backoffice_deleteOK_room") || sPath.equals("/backoffice_qna") ||
				sPath.equals("/backoffice_insert_comment") || sPath.equals("/backoffice_insertOK_comment") || sPath.equals("/backoffice_update_comment") || sPath.equals("/backoffice_updateOK_comment") || sPath.equals("/backoffice_deleteOK_comment") || sPath.equals("/backoffice_review") || sPath.equals("/backoffice_reserve") || sPath.equals("/backoffice_daysales") || 
				sPath.equals("/backoffice_weeksales") || sPath.equals("/backoffice_month_sales") || sPath.equals("/backoffice_updateOK_sales") || sPath.equals("/backoffice_setting") || sPath.equals("/backoffice_setting_pw") || sPath.equals("/backoffice_setting_delete")) {
			if(backoffice_id==null) {
				response.sendRedirect("backoffice_login");
				return false;
			}
		}
			return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		String sPath = request.getServletPath();
		logger.info("postHandle",sPath);
	}
}
