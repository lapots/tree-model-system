package com.lapots.tree.model.web;

import org.apache.catalina.LifecycleException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import javax.servlet.Servlet;
import java.io.IOException;

@SpringBootApplication
@ComponentScan(basePackages = { "com.lapots.tree.model" })
public class TreeModelSystemApplication {

    public static void main(String[] args) throws LifecycleException, IOException {
        SpringApplication.run(TreeModelSystemApplication.class, args);
    }
/*
    TODO: resolve issue with empty responses for /tree-model-app/ping from {@link RootServlet}
    @Bean
    public ServletRegistrationBean rootServletRegistration() {
        ServletRegistrationBean<Servlet> registrationBean = new ServletRegistrationBean<>(new RootServlet(), "/*");
        registrationBean.setEnabled(true);
        registrationBean.setLoadOnStartup(1);
        return registrationBean;
    }
*/
}
