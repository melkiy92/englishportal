package com.englishportal.core.controllers;

import com.englishportal.core.CoreApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CoreApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {
    public static final String LOCAL_HOST = "http://localhost:";

    @LocalServerPort
    private int port;
    private TestRestTemplate template = new TestRestTemplate();

    @Test
    public void testGetUserById() throws Exception{
        String expected = "{id:1,email:abc@mail.ru,roles:[{id:1,name:USER}],name:Anna}";
        ResponseEntity<String> response = template.getForEntity(createURL("/users/1"), String.class);
        JSONAssert.assertEquals(expected, response.getBody(), false);
    }

    private String createURL(String uri) {
        return LOCAL_HOST + port + uri;
    }
}
