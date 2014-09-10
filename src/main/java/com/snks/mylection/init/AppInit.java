package com.snks.mylection.init;

import javax.servlet.Filter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.snks.mylection.config.AppSecurityConfig;
import com.snks.mylection.config.WebConfig;

public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{
        		WebConfig.class,AppSecurityConfig.class
        };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {

        return new Class<?>[]{
        };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
    
    @Override
    protected Filter[] getServletFilters() {

      CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
      characterEncodingFilter.setEncoding("UTF-8");
      return new Filter[] { characterEncodingFilter};
    }
  
    
    @Override
    public void onStartup(ServletContext servletContext)
    		throws ServletException {
    	servletContext.setInitParameter("defaultHtmlEscape", "true");
	   String activeProfile = System.getProperty("spring.profiles.active");
	    if (activeProfile == null) {
	      activeProfile = "prod";
	    }
    	servletContext.setInitParameter("spring.profiles.active", activeProfile);
    	super.onStartup(servletContext);
    }
   
}