package com.honsoft.web;

import javax.servlet.Filter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

//import org.h2.server.web.WebServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.honsoft.web.config.AppConfig;
import com.honsoft.web.config.SecurityConfig;
import com.honsoft.web.listener.AppContextAttributeListener;
import com.honsoft.web.listener.AppContextListener;
import com.honsoft.web.listener.MyServletRequestListener;
import com.honsoft.web.listener.MySessionListener;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { SecurityConfig.class };
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
		// TODO Auto-generated method stub
		return super.getServletFilters();
	}

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		// TODO Auto-generated method stub
		super.onStartup(servletContext);
		//ServletRegistration.Dynamic servlet = servletContext.addServlet("h2-console", new WebServlet());
		//servlet.setLoadOnStartup(2);
		//servlet.addMapping("/h2-console/*");
		
		servletContext.addListener(new AppContextAttributeListener());
		servletContext.addListener(new AppContextListener());
		servletContext.addListener(new MyServletRequestListener());
		servletContext.addListener(new MySessionListener());
		
		
	}
	
	
}
