package com.itwill.steam.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

public class AuthLoginAnnotationInterceptor implements HandlerInterceptor {
	public AuthLoginAnnotationInterceptor() {
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler)
			throws Exception {
		System.out.println("### AuthLoginAnnotationInterceptor.preHandle()메써드");
	
		if (handler instanceof HandlerMethod == false) {
			/*
			 * @ Controller객체에 @RequestMapping이 붙은메쏘드 :  HandlerMethod
			 */
			//return true이면 그대로 컨트롤러로 진행
			return true;
		}
	
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		/***************************
		 3.HandlerMethod객체 로부터 @LoginCheck 어노테이션 객체얻기
		***************************/
		LoginCheck loginCheck = handlerMethod.getMethodAnnotation(LoginCheck.class);
		/***************************
		4. HandlerMethod객체에 @LoginCheck어노테이션 이없는 경우, 
		   즉 인증이 필요 없는 요청
		***************************/
		if (loginCheck == null) {
			
			return true;
		}
		/***************************
		4. HandlerMethod객체에 @LoginCheck어노테이션 이있는 경우, 
		   세션이 있는지 체크
		***************************/
		
		//session 객체를 가져옴
		HttpSession session = request.getSession();
		//login처리를 담당하는 사용자 정보를 담고 있는 객체를 가져옴
		User loginUser = (User)session.getAttribute("loginUser");
		if (loginUser == null) {
			// 로그인이 안되어 있는 상태임으로 로그인 폼으로 다시 돌려보냄(redirect)
			response.sendRedirect("main");
			return false; // 더이상 컨트롤러 요청으로 가지 않도록 false로 반환함
		}
		return true;
	}
}