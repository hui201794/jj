package com.jkoss.interceptor.spring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse, Object obj) throws Exception {
		// TODO Auto-generated method stub
	/*	HttpSession session = httpservletrequest.getSession();
		// �õ���¼
		User user = (User) session.getAttribute("user");
		
		
		if (user == null) {
			// ������¼����
			httpservletresponse.sendRedirect("../index.jsp");

			return false;
		}
*/
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse, Object obj, ModelAndView modelandview) throws Exception {
		// TODO Auto-generated method stub
		//
	}

	@Override
	public void afterCompletion(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse, Object obj, Exception exception) throws Exception {
		// TODO Auto-generated method stub

	}

}
