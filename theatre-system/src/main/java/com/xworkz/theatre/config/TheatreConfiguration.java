package com.xworkz.theatre.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan("com.xworkz.theatre")
@EnableWebMvc
public class TheatreConfiguration implements WebMvcConfigurer {
    public TheatreConfiguration() {
        System.out.println("Running Theatre Configuration");
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/",".jsp");
    }

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/xworkz");
        dataSource.setUsername("root");
        dataSource.setPassword("Vina@2002");

        return dataSource;
    }

    public Properties getProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        properties.setProperty("hibernate.hbm2ddl.auto", "update");
        return properties;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean getManagerFactoryBea() {
        LocalContainerEntityManagerFactoryBean managerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        managerFactoryBean.setDataSource(getDataSource());
        managerFactoryBean.setPackagesToScan("com.xworkz.theatre.entity");
        managerFactoryBean.setJpaProperties(getProperties());
        managerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

        return managerFactoryBean;
    }
}
