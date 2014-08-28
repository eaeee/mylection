package com.snks.mylection.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.snks.mylection.dao.LectionDAO;
import com.snks.mylection.dao.LectionDAOImpl;
import com.snks.mylection.dao.UserDAO;
import com.snks.mylection.dao.UserDAOImpl;

@Configuration
@EnableWebMvc
@ComponentScan({"com.snks.mylection.config", 
				"com.snks.mylection.controllers",
				"com.snks.mylection.dao",
				"com.snks.mylection.service"
			   })
//@Import({ AppSecurityConfig.class })
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

    @Bean
    public InternalResourceViewResolver setupViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);
        return resolver;
    }
    
    @Bean
    public UserDAO setupDAO() {
		return new UserDAOImpl();
    	
    }
    
    @Bean
    public LectionDAO setupLectionDAO() {
    	return new LectionDAOImpl();
    }
    
    //для свойств
	@Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
       return new PropertySourcesPlaceholderConfigurer();
    }

}