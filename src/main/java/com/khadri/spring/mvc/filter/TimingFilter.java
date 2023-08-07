package com.khadri.spring.mvc.filter;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

public class TimingFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		 System.out.println("start time count ");
		 
		 LocalDateTime startTime = LocalDateTime.now();
		 
		 filterChain.doFilter(request, response);
		 
		 LocalDateTime endDateTime = LocalDateTime.now();
		 
		 int total = endDateTime.getNano() - startTime.getNano();
		 
		 System.out.println("Total Time taken : "+total);
	}
	
	 
}
