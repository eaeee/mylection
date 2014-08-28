package com.snks.mylection.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {
	
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("user").password("user").roles("USER");
        auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
        auth.inMemoryAuthentication().withUser("superadmin").password("superadmin").roles("SUPERADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
        .csrf().disable()
        .authorizeRequests()
            .anyRequest().authenticated()
            .and()
        .formLogin()
            .loginPage("/login")
            .permitAll();

    }
    
    
    /*
    @Override
    protected void configure(AuthenticationManagerBuilder auth)
    		throws Exception {
    	super.configure(auth);
    	auth.authenticationProvider(authenticationProvider());
    }
    
    @Bean
    @Override
    public UserDetailsService userDetailsServiceBean() throws Exception {
    	 return new UserDetailsServiceImpl();
    }
    
    @Bean 
    public DaoAuthenticationProvider authenticationProvider() { 
    	return new CustomDaoAuthenticationProvider(); 
    }
    */ 
    
}