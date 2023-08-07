package com.khadri.spring.mvc.disp.initializer;

import javax.servlet.Filter;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.khadri.spring.mvc.config.AppConfig;
import com.khadri.spring.mvc.filter.AFilter;
import com.khadri.spring.mvc.filter.AuthenticationFilter;
import com.khadri.spring.mvc.filter.TimingFilter;

public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { AppConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	@Override
	protected Filter[] getServletFilters() {
		return new Filter[] { new TimingFilter(),new AFilter(),new AuthenticationFilter() };
	}

}
