package com.example.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class AdminInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		//request를 통하여 세션변수를 받아옴
		
		String role = (String)session.getAttribute("role");
		//세션에 저장된 role을 읽어옴
        
		if(role!=null && role.equals("admin")) {	//순서 중요. null인지 먼저 물어야 함
		//세션변수 role이 null이 아니고 admin이라면
			 return super.preHandle(request, response, handler);
			 //요청 서비스로 이동
		}else {			//role이 null이거나 admin이 아니면
			response.sendRedirect("/login");
			//로그인 하는 곳이로 이동
            return false;
		}
	}
}
