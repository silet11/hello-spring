package com.sinensia.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Generated;
import java.math.BigDecimal;

import static java.math.RoundingMode.HALF_DOWN;


@SpringBootApplication
@RestController
public class DemoProjectApplication {

	@Generated(value = "org.springframework.boot")
	public static void main(String[] args) {
		SpringApplication.run(DemoProjectApplication.class, args);
	}

	@GetMapping("/hello")

	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);

	}

	@GetMapping("/")
	public String paginaincio() {
		return String.format("Esta es la página de incio");

	}

	@GetMapping("/add")
	public Object add(
			@RequestParam(value = "a", defaultValue = "0") Float a,
			@RequestParam(value = "b", defaultValue = "0") Float b
	) {
		Float sum = a + b;
		Float decimals = sum - sum.intValue();
		if (decimals != 0) {
			return sum;
		}
		return Integer.valueOf(sum.intValue());
	}

	@GetMapping("/multiply")
	public Object multiply(
			@RequestParam(value = "a", defaultValue = "0") Float a,
			@RequestParam(value = "b", defaultValue = "0") Float b
	) {
		Float product = a * b;
		Float decimals = product - product.intValue();
		if (decimals != 0) {
			return product;
		}
		return Integer.valueOf(product.intValue());
	}

	@GetMapping("/substract")
	public Object substract(
			@RequestParam(value = "a", defaultValue = "0") Float a,
			@RequestParam(value = "b", defaultValue = "0") Float b
	) {
		Float sub = a - b;
		Float decimals = sub - sub.intValue();
		if (decimals != 0) {
			return sub;
		}
		return Integer.valueOf(sub.intValue());
	}

	@GetMapping("/divide")
	public Object divide(
			@RequestParam(value = "a", defaultValue = "0") Float a,
			@RequestParam(value = "b", defaultValue = "0") Float b
	) {
		Float division = a / b;
		Float decimals = division - division.intValue();
		if (decimals != 0) {
			return division;
		}
		return Integer.valueOf(division.intValue());
	}

	/*@GetMapping("/divide")
	public BigDecimal divide(
			@RequestParam(value = "a", defaultValue = "0") BigDecimal a,
			@RequestParam(value = "b", defaultValue = "0") BigDecimal b
	) throws Exception {
		if (b.equals(BigDecimal.ZERO)) {
			throw new Exception("Division By zero");
		}
		return a.divide(b, 2, HALF_DOWN);
	}*/
}


