package com.exam.demo.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
@PropertySource("classpath:Oracle.properties")
@EnableJpaRepositories(
entityManagerFactoryRef = "entityManagerFactory", 
transactionManagerRef = "transactionManager",
basePackages="com.exam.demo.Repository")

public class Configuracion {

@Autowired
private DataSource datasource;
//
@Autowired
private Environment env;

@Primary
@Bean(name = "entityManagerFactory")
public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws Exception {

    LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
    // Configuracion local
//    emf.setDataSource(datasource);
    // Configuracion Server
//    emf.setDataSource(getDataSource());
    emf.setDataSource(this.datasource);
    emf.setPackagesToScan("com.exam.demo.entity");

    HibernateJpaVendorAdapter hibernateJpa = new HibernateJpaVendorAdapter();
    hibernateJpa.setDatabase(Database.ORACLE);
    hibernateJpa.setDatabasePlatform(this.env.getProperty("hibernate.dialect"));
    hibernateJpa.setGenerateDdl(this.env.getProperty("hibernate.generateDdl", Boolean.class));
    hibernateJpa.setShowSql(this.env.getProperty("hibernate.show_sql", Boolean.class));
    emf.setJpaVendorAdapter(hibernateJpa);

    Properties jpaProperties = new Properties();
    jpaProperties.put("hibernate.hbm2ddl.auto", this.env.getProperty("hibernate.hbm2ddl.auto"));
    jpaProperties.put("hibernate.show_sql", this.env.getProperty("hibernate.show_sql"));
    jpaProperties.put("hibernate.format_sql", this.env.getProperty("hibernate.format_sql"));
    jpaProperties.put("hibernate.default_schema", this.env.getProperty("hibernate.default_schema"));
    /* Additional properties */
    emf.setJpaProperties(jpaProperties);

    return emf;
}

@Primary
@Bean(name = "transactionManager")
public JpaTransactionManager transactionManager(final @Qualifier("entityManagerFactory") EntityManagerFactory emf) {
    JpaTransactionManager transactionManager = new JpaTransactionManager();
    transactionManager.setEntityManagerFactory(emf);
    return transactionManager;
}


}
