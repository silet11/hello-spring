package com.sinensia.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@SpringBootApplication
@RestController
public class DemoProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoProjectApplication.class, args);
    }
    @GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name){
		return String.format("Hello %s!", name);

	}
	@GetMapping("/")
	public String paginaincio(){
		return String.format("Esta es la página de incio");

	}

	@GetMapping("/add")
	public String canAdd(@RequestParam(value = "b", defaultValue = "0") int b, @RequestParam(value = "a", defaultValue = "0") int a){
		return String.format("%s", a+b);

	}
}
