/**
 * 
 * @author 최진실
 *
 */
package test.com.rence.master;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MasterLogin extends HandlerInterceptorAdapter {
	private static final Logger logger = LoggerFactory.getLogger(MasterLogin.class);

	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String sPath = request.getServletPath();
		logger.info("preHandle",sPath);
		
		HttpSession session = request.getSession();
		String master_id = (String) session.getAttribute("master_id");
		logger.info("session master_id: {}", master_id);
		
		if(sPath.equals("/master_main") || sPath.equals("/master_grant")|| sPath.equals("/master_refuse")|| sPath.equals("/master_backoffice_detail")|| sPath.equals("/master_backoffice_end")|| sPath.equals("/master_revoke")) {
			if(master_id==null) {
				response.sendRedirect("master_login");
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
