package com.sinensia.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestParam;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
class DemoProjectApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void rootTest(@Autowired TestRestTemplate restTemplate) {
		assertThat(restTemplate.getForObject("/", String.class))
				.isEqualTo("Esta es la página de incio");
	}

	@Test
	void helloTestDefault(@Autowired TestRestTemplate restTemplate) {
		assertThat(restTemplate.getForObject("/hello", String.class))
				.isEqualTo("Hello World!");
	}

	@Test
	void helloTest(@Autowired TestRestTemplate restTemplate) {
		assertThat(restTemplate.getForObject("/hello?name=Raul", String.class))
				.isEqualTo("Hello Raul!");
	}

	@Test
	void canAdd(@Autowired TestRestTemplate restTemplate) {
		assertThat(restTemplate.getForObject("/add?a=1&b=2", String.class))
				.isEqualTo("3");
	}

	@Test
	void canAddZero(@Autowired TestRestTemplate restTemplate) {
		assertThat(restTemplate.getForObject("/add?a=0&b=2", String.class))
				.isEqualTo("2");
	}

	@Test
	void canAddNegative(@Autowired TestRestTemplate restTemplate) {
		assertThat(restTemplate.getForObject("/add?a=1&b=-2", String.class))
				.isEqualTo("-1");
	}

	@Test
	void canAddNullA(@Autowired TestRestTemplate restTemplate) {
		assertThat(restTemplate.getForObject("/add?a&b=2", String.class))
				.isEqualTo("2");
	}

	@Test
	void canAddNullB(@Autowired TestRestTemplate restTemplate) {
		assertThat(restTemplate.getForObject("/add?a=1&b=", String.class))
				.isEqualTo("1");
	}

	@Test
	void helloNames(@Autowired TestRestTemplate restTemplate) {
		String[] arr = {"Raul","Cami"};
		for(String name:arr){
			assertThat(restTemplate.getForObject("/hello?name="+name, String.class))
					.isEqualTo("Hello "+name+"!");
		}
	}

	@Autowired TestRestTemplate restTemplate;
	@ParameterizedTest
	@ValueSource(strings={"Raul","Cami"})
	void helloParamNames(String name) {
			assertThat(restTemplate.getForObject("/hello?name="+name, String.class))
					.isEqualTo("Hello "+name+"!");
	}
}
