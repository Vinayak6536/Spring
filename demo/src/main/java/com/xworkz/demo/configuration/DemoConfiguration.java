package com.xworkz.demo.configuration;

import com.xworkz.demo.internet.Internet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.xworkz.demo")
public class DemoConfiguration {
    public DemoConfiguration(){
        System.out.println("Config started.....");
    }

//    @Bean
//    public Internet getInternet(){
//        return new Internet();
//   }


}
