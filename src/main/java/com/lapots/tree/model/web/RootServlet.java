package com.lapots.tree.model.web;

import com.lapots.tree.model.web.rest.PingHandlerFunction;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ServletHttpHandlerAdapter;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.server.adapter.WebHttpHandlerBuilder;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RouterFunctions.toHttpHandler;

public class RootServlet extends ServletHttpHandlerAdapter {
    public RootServlet(HttpHandler httpHandler) {
        super(httpHandler);
    }

    public RootServlet() {
        this(WebHttpHandlerBuilder
                .webHandler(toHttpHandler(routingFunction()))
                .build()
        );
    }

    private static RouterFunction<?> routingFunction() {
        return route(GET("/ping"), new PingHandlerFunction());
    }

}
