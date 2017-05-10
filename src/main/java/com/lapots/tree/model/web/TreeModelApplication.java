package com.lapots.tree.model.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TreeModelApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(TreeModelApplication.class, args);
    }

    @Bean
    public ServletRegistrationBean servletRegistrationBean() throws Exception {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new RootServlet(), "/tree-model-app");
        registrationBean.setLoadOnStartup(1);
        registrationBean.setAsyncSupported(true);
        return registrationBean;
    }
}
