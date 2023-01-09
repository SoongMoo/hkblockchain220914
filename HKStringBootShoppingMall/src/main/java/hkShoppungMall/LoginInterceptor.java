package hkShoppungMall;


import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import hkShoppungMall.domain.AuthInfo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component
public class LoginInterceptor implements HandlerInterceptor{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		 	HttpSession session = (HttpSession) request.getSession();
		 	AuthInfo authInfo = (AuthInfo)session.getAttribute("AuthInfo");
	        
	        if(authInfo  != null) {
	            return true;
	        } else {
	              try { 
	                  response.sendRedirect("/"); 
	              } catch (IOException e) {
	                  e.printStackTrace(); 
	              }
	            return false;
	            
	        }
	}
	
}
