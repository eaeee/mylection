package com.snks.mylection.config;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class HibernateConfig {
 
   @Autowired
   private Environment env;
   
   @Autowired
   private BasicDataSource datasourse;
 
   @Bean
   public LocalSessionFactoryBean sessionFactory() {
      LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
      sessionFactory.setDataSource(datasourse);
      sessionFactory.setPackagesToScan(new String[] { "com.snks.mylection.model" });
      sessionFactory.setHibernateProperties(hibernateProperties());
      return sessionFactory;
   }
 
   @Profile("dev")
   @Bean
   public BasicDataSource restDataSource() {
	  BasicDataSource dataSource = new BasicDataSource();
      dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
      dataSource.setUrl(env.getProperty("jdbc.url"));
      dataSource.setUsername(env.getProperty("jdbc.user"));
      dataSource.setPassword(env.getProperty("jdbc.pass"));
 
      return dataSource;
   }
   
   @Profile("prod")
   @Bean
   public BasicDataSource dataSource() throws URISyntaxException {
       URI dbUri = new URI(System.getenv("DATABASE_URL"));

       String username = dbUri.getUserInfo().split(":")[0];
       String password = dbUri.getUserInfo().split(":")[1];
       String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

       BasicDataSource basicDataSource = new BasicDataSource();
       basicDataSource.setUrl(dbUrl);
       basicDataSource.setUsername(username);
       basicDataSource.setPassword(password);

       return basicDataSource;
   }
 
   @Bean
   public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
      HibernateTransactionManager txManager = new HibernateTransactionManager();
      txManager.setSessionFactory(sessionFactory);
      return txManager;
   }

   Properties hibernateProperties() {
      return new Properties() {
		private static final long serialVersionUID = 1L;

		{
            setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
            setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
            setProperty("hibernate.cache.provider_class", env.getProperty("hibernate.cache.provider_class"));
            setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
            setProperty("hibernate.globally_quoted_identifiers", "true");
            setProperty("current_session_context_class","thread");
         }
      };
   }
}