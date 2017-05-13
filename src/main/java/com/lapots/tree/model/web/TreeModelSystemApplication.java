package com.lapots.tree.model.web;

import org.apache.catalina.LifecycleException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import javax.servlet.Servlet;
import java.io.IOException;

import static org.springframework.web.reactive.function.BodyInserters.fromObject;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RouterFunctions.toHttpHandler;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@SpringBootApplication
@ComponentScan(basePackages = { "com.lapots.tree.model" })
public class TreeModelSystemApplication {

    public static void main(String[] args) throws LifecycleException, IOException {
        SpringApplication.run(TreeModelSystemApplication.class, args);
    }

    @Bean
    public ServletRegistrationBean rootServletRegistration() {
        ServletRegistrationBean<Servlet> registrationBean = new ServletRegistrationBean<>(new RootServlet(), "/*");
        registrationBean.setEnabled(true);
        registrationBean.setLoadOnStartup(1);
        return registrationBean;
    }

}
