package com.lapots.tree.model.web;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = TreeModelApplication.class)
@ExtendWith(SpringExtension.class)
public class TreeModelApplicationTest {
    private static final String PING_URL = "http://localhost:8080/tree-model-app/ping";

    private RestTemplate restTemplate = new RestTemplate();

    @Test
    public void routerReturnsTrueOnPing() {
        String response = restTemplate.getForObject(PING_URL, String.class);
        assertEquals("false", response, "Ping response should be the same as expected.");
    }
}

