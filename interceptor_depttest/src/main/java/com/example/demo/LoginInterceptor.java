package com.example.demo;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String uri = request.getRequestURI();
		String ipAddresss = request.getRemoteAddr();
		Date now = new Date();
		System.out.println("uri:"+uri);
		System.out.println("ipAddresss:"+ipAddresss);
		System.out.println("now:"+now);
		
		//로그인했는지 파악하기 위해 request 객체를 통해 세션을 가져와 세션에 userID가 있는지 파악
        HttpSession session = request.getSession();
        if ( session.getAttribute("userID") == null){
            response.sendRedirect("/login");
            return false; 
        }
        return super.preHandle(request, response, handler);
	}
}
