package com.niit.TaskBacend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.niit.TaskBacend.Dao.FileDao;
import com.niit.TaskBacend.Dao.FileDaoimpl;
import com.niit.TaskBacend.Dao.UserDetailsDao;
import com.niit.TaskBacend.Dao.UserDetailsDaoImpl;
import com.niit.TaskBacend.Model.UploadFile;
import com.niit.TaskBacend.Model.UserDetails;


@Configuration
@ComponentScan("com.niit.TaskBacend")
@EnableTransactionManagement
public class ApplicationContextConfig {

	@Autowired
	@Bean(name="dataSources")
	 public DataSource getH2DataSource() {
		 DriverManagerDataSource dataSource=new DriverManagerDataSource();
		 dataSource.setDriverClassName("org.h2.Driver");
	    	dataSource.setUrl("jdbc:h2:tcp://localhost/~/testtask");
	    	dataSource.setUsername("sa");
	    	dataSource.setPassword("");
	    	return dataSource;
	    }
	    
	private Properties getHibernateProperties(){
		Properties properties = new Properties();
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		properties.put("hibernate.format_sql", "true");
		
		return properties;
		}
	 @Autowired
	    @Bean(name = "sessionFactory")
	    public SessionFactory getSessionFactory(DataSource dataSource) {
	    	LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
	    	sessionBuilder.addProperties(getHibernateProperties());
	    	sessionBuilder.addAnnotatedClasses(UserDetails.class);
	    	sessionBuilder.addAnnotatedClasses(UploadFile.class);
			return sessionBuilder.buildSessionFactory();
	    }
	 @Autowired
		@Bean(name = "transactionManager")
		public HibernateTransactionManager getTransactionManager(
				SessionFactory sessionFactory) {
			HibernateTransactionManager transactionManager = new HibernateTransactionManager(
					sessionFactory);

			return transactionManager;
		}
	 
	 
@Autowired(required=true)
@Bean(name="userDetailsDao")
public UserDetailsDao getUserDao(SessionFactory sessionFactory)
{
	return new UserDetailsDaoImpl(sessionFactory);
	
}

@Autowired
@Bean(name = "fileDao")
public FileDao getFileDao(SessionFactory sessionFactory) {
    return new FileDaoimpl(sessionFactory);
}



@Bean(name = "multipartResolver")
public CommonsMultipartResolver getCommonsMultipartResolver() {
	CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
	multipartResolver.setMaxUploadSize(20971520);	
	multipartResolver.setMaxInMemorySize(1048576);	
	return multipartResolver;
}

}

