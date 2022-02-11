package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SpringConfig implements WebMvcConfigurer {
//인터셉터를 등록하기 위해 WebMvcConfigurer클래스를 확장
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {		//addInterceptors 메소드를 오버라이딩하여
		
		// TODO Auto-generated method stub
		//WebMvcConfigurer.super.addInterceptors(registry);
		registry.addInterceptor(new LoginInterceptor())				//매개변수 registry인터셉터를 등록
        .addPathPatterns("/insertDept.do","/member/**");			//insertDept.do와 member에 모든 요청일때 인터셉터가 동작하도록 설정
	
		registry.addInterceptor(new AdminInterceptor())				//AdminInterceptor를 등록
		.addPathPatterns("/admin/**");								//admin네임스페이스에 모든 요청일 때 동작 하도록 설정
		
		registry.addInterceptor(new DeptLogInterceptor())
		.addPathPatterns("/**")
		.excludePathPatterns("/login");
	}
}
