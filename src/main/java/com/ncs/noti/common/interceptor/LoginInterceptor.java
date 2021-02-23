package com.ncs.noti.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	// Controller 보다 먼저 수행됨 --> 로그인 확인
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		try {
//			String viewName = getViewName(request);
//			request.setAttribute("viewName", viewName);
			
			System.out.println("---->INTERCEPTOR ALERT : Log-In");
			HttpSession session = request.getSession();
			Object obj = session.getAttribute("login");

			if (obj == null) {
				response.sendRedirect("user/userLogin.do");
				return false; // 더 이상 컨트롤러 요청으로 이동되지 않도록 함.
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

}
