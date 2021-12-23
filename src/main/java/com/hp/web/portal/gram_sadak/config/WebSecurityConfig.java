package com.hp.web.portal.gram_sadak.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration public class WebSecurityConfig extends WebMvcConfigurerAdapter {

@Override public void addCorsMappings(CorsRegistry registry) { // TODO Auto-generated method stub
super.addCorsMappings(registry); registry.addMapping("/**").allowedHeaders("*").allowedOrigins("*"); }

}
 
