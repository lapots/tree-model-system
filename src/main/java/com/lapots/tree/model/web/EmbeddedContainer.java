package com.lapots.tree.model.web;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.ipc.netty.http.server.HttpServer;

import static org.springframework.web.reactive.function.BodyInserters.fromObject;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

public class EmbeddedContainer {

    // does not work as far as I remember
    public static void startTomcat() throws LifecycleException {
        Tomcat server = new Tomcat();
        server.setHostname("localhost");
        server.setPort(8080);
        Context rootContext = server.addContext("", System.getProperty("java.io.tmpdir"));
        Tomcat.addServlet(rootContext, "servlet",
                new RootServlet(RouterFunctions.toHttpHandler(routingFunction())));
        rootContext.addServletMapping("/tree-model-web/", "servlet");
        server.start();
    }

    public static void startReactorNetty() {
        ReactorHttpHandlerAdapter adapter =
                new ReactorHttpHandlerAdapter(RouterFunctions.toHttpHandler(routingFunction()));

        HttpServer server = HttpServer.create("localhost", 8080);
        server.newHandler(adapter).block();
    }

    private static RouterFunction<ServerResponse> routingFunction() {
        return route(GET("/ping"), serverRequest -> ok().body(fromObject("true")));
    }
}
