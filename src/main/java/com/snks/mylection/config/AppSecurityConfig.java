package com.snks.mylection.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;


@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {
	

    
    @Override
    public void configure(WebSecurity web) throws Exception {
      web
        .ignoring()
           .antMatchers("/resources/**"); // #3
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
        .authorizeRequests()
        .antMatchers("/login","/register").permitAll() // #4
        .antMatchers("/users/**").hasRole("ADMIN") // #6
        .anyRequest().authenticated() // 7
        .and()
    .formLogin()  // #8
        .loginPage("/login"); // #9
        http
        .csrf().disable();
    }
    
    @Bean
    @Autowired
    public DaoAuthenticationProvider authenticationProvider(UserDetailsService userDetailsService) {   	
    	DaoAuthenticationProvider dap =  new DaoAuthenticationProvider();
    	dap.setUserDetailsService(userDetailsService); 
    	return dap;
    }
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth,DaoAuthenticationProvider authenticationProvider) throws Exception {
        auth.authenticationProvider(authenticationProvider);
/*        .inMemoryAuthentication()
          .withUser("user")  // #1
            .password("user")
            .roles("USER")
            .and()
          .withUser("admin") // #2
            .password("admin")
            .roles("ADMIN","USER");*/
    }
    
    
}