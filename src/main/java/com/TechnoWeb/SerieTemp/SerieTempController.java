package com.TechnoWeb.SerieTemp;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SerieTempController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/hello")
	public String greeting(@RequestParam(value = "name", defaultValue = "World") String name, @RequestParam(value = "oui", defaultValue = "truc") String oui) {
		return "hello " + name + " et " + oui;
	}
}