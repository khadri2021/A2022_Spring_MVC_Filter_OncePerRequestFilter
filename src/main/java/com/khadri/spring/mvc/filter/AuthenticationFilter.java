package com.khadri.spring.mvc.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.filter.OncePerRequestFilter;

public class AuthenticationFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		//JWT Token ?????? 
		System.out.println("Before AuthenticationFilter  ");
		String authToken = request.getHeader("Authorization");
		
		 if (authToken == null || !isValidToken(authToken)) {
	            response.setStatus(HttpStatus.BAD_REQUEST.value());
	            System.out.println("Invalid Token");
	            return;
	        }

		 filterChain.doFilter(request, response);
		 System.out.println("After AuthenticationFilter  ");
	}
	
	private boolean isValidToken(String authToken) {
		// Validate authtoken 
		
		return true;
	}

}
