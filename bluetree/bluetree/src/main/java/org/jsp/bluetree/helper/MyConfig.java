package org.jsp.bluetree.helper;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@ComponentScan({ "org.jsp" })
@Configuration
public class MyConfig {

	@Bean
	public InternalResourceViewResolver myViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	@Bean
	public EntityManagerFactory getEntityManagerfactory() {
		return Persistence.createEntityManagerFactory("dev");
	}
}
