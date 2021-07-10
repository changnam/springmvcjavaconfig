package com.honsoft.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.honsoft.web.listener.ApplicationContextAwareBean;
import com.honsoft.web.listener.ServletContextAwareBean;
import com.honsoft.web.listener.SpringContextRefreshedListener;

@Configuration
public class AppConfig extends WebMvcConfigurerAdapter {
	@Bean
	public ServletContextAwareBean servletContextAwareBean() {
		return new ServletContextAwareBean();
	}
	@Bean
	public ApplicationContextAwareBean applicationContextAwareBean() {
		return new ApplicationContextAwareBean();
	}
	@Bean
	public SpringContextRefreshedListener springContextRefreshedListener() {
		return new SpringContextRefreshedListener();
	}
	
}
