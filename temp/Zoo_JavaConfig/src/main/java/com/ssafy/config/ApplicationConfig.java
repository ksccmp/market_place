package com.ssafy.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.ssafy.zoo.Tiger;

@Configuration
@ComponentScan(basePackageClasses=Tiger.class)
@EnableAspectJAutoProxy 
public class ApplicationConfig {

}
