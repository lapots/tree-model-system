package com.lapots.tree.model.web;

import org.apache.catalina.LifecycleException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.io.IOException;

@SpringBootApplication
@ComponentScan(basePackages = { "com.lapots.tree.model" })
@EntityScan("com.lapots.tree.model.domain")
@EnableTransactionManagement
@EnableNeo4jRepositories(basePackages = { "com.lapots.tree.model.repository" })
public class TreeModelSystemApplication {

    public static void main(String[] args) throws LifecycleException, IOException {
        SpringApplication.run(TreeModelSystemApplication.class, args);
    }
}
