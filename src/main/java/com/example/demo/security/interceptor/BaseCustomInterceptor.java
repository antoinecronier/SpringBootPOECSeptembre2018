package com.example.demo.security.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class BaseCustomInterceptor 
  extends HandlerInterceptorAdapter {
 
    @Override
    public boolean preHandle(
      HttpServletRequest request, 
      HttpServletResponse response, 
      Object handler) {
    	String referer = request.getHeader("Referer");
    	System.out.println(referer);
    	String requestURI = request.getRequestURI();
    	System.out.println(requestURI);
    	Object requestURL = request.getRequestURL();
    	System.out.println(requestURL);
    	String pathInfo = request.getPathInfo();
    	System.out.println(pathInfo);
        return true;
    }
 
    @Override
    public void afterCompletion(
      HttpServletRequest request, 
      HttpServletResponse response, 
      Object handler, 
      Exception ex) {
    	String referer = request.getHeader("Referer");
    	System.out.println(referer);
    	String requestURI = request.getRequestURI();
    	System.out.println(requestURI);
    	Object requestURL = request.getRequestURL();
    	System.out.println(requestURL);
    	String pathInfo = request.getPathInfo();
    	System.out.println(pathInfo);
    }
}
