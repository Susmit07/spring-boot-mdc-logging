package com.mdc.logging;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class FrontControllerIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getGreeting_whenInvoked_thenReturnsHelloWorld() {
        // Given
        String url = "/greetings/Sunny";

        // When
        String greetingFromController = restTemplate.getForObject(url, String.class);

        // Then
        assertThat(greetingFromController, is("Hello World, Sunny"));
    }

}
