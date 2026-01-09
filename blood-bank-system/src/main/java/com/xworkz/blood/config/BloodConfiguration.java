package com.xworkz.blood.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = "com.xworkz.blood")
public class BloodConfiguration {
    public BloodConfiguration(){
        System.out.println("Executed Blood Config.....");
    }

    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver internalResourceViewResolver=new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix("/");
        internalResourceViewResolver.setSuffix(".jsp");
        return internalResourceViewResolver;
    }

    @Bean
    public DataSource getDataSource(){
        DriverManagerDataSource managerDataSource=new DriverManagerDataSource();
        managerDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        managerDataSource.setUrl("jdbc:mysql://localhost:3306/xworkz");
        managerDataSource.setUsername("root");
        managerDataSource.setPassword("Vina@2002");
        return managerDataSource;
    }

    public Properties getProperties(){
        Properties properties=new Properties();
        properties.getProperty("hibernate.dialect","org.hibernate.dialect.MySQL8Dialect");
        return properties;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean getContainerEntityManagerFactoryBean(){
        LocalContainerEntityManagerFactoryBean managerFactoryBean=new LocalContainerEntityManagerFactoryBean();
        managerFactoryBean.setDataSource(getDataSource());
        managerFactoryBean.setPackagesToScan("com.xworkz.blood.entity");
        managerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

        return managerFactoryBean;
    }
}
