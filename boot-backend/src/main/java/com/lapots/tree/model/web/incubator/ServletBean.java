package com.lapots.tree.model.web.incubator;

import org.springframework.boot.web.servlet.ServletRegistrationBean;

import javax.servlet.Servlet;

public class ServletBean {

    // @Bean TODO: resolve issue with mapping
    public ServletRegistrationBean rootServletRegistration() {
        ServletRegistrationBean<Servlet> registrationBean = new ServletRegistrationBean<>(new RootServlet(), "/*");
        registrationBean.setEnabled(true);
        registrationBean.setLoadOnStartup(1);
        return registrationBean;
    }

}
