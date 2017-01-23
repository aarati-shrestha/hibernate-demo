package com.hibernate.test.config;

import java.io.IOException;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
@EnableJpaRepositories(basePackages = "com.hibernate.test.repository",entityManagerFactoryRef="localContainerEntityManagerFactoryBean")
public class MySqlConfig {

	private @Value("${dbURL.hibernate}") String url;
	private @Value("${dbDriver.mysql}") String dbDriver;
	private @Value("${dbDatabasePlatform.mysql}") String dbDatabasePlatform;
	private @Value("${dbUser.mysql}") String user;
	private @Value("${dbPassword.mysql}") String password;	

	
    @Bean
    public DataSource dataSource() {
    	BasicDataSource ds = new BasicDataSource();
    	ds.setDriverClassName(dbDriver);
    	ds.setUrl(url);
    	ds.setUsername(user);
    	ds.setPassword(password);
    	ds.setInitialSize(5);
    	ds.setMaxActive(10);
    	return ds;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
    	
    	HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
    	adapter.setShowSql(true);
    	adapter.setGenerateDdl(true);
    	adapter.setDatabase(Database.MYSQL);
    	
    	return adapter;
    }
    
    @Bean
    public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean(
    		DataSource dataSource, JpaVendorAdapter jpaVendorAdapter) {
    	
    	LocalContainerEntityManagerFactoryBean emfb = new LocalContainerEntityManagerFactoryBean();
    	emfb.setDataSource(dataSource);
    	emfb.setJpaVendorAdapter(jpaVendorAdapter);
    	//where the entities reside
    	emfb.setPackagesToScan("com.hibernate.test.domain");
    	
    	return emfb;
    }
    
    @Bean(name="transactionManager")
    public JpaTransactionManager txName(EntityManagerFactory localContainerEntityManagerFactoryBean) throws IOException{
    	JpaTransactionManager txName= new JpaTransactionManager();
        txName.setEntityManagerFactory(localContainerEntityManagerFactoryBean);
        return txName;
   }
}
