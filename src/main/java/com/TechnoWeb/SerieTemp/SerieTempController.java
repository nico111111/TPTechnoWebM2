package com.TechnoWeb.SerieTemp;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

import javax.management.ServiceNotFoundException;

import org.apache.coyote.ActionCode;
import org.springframework.http.codec.HttpMessageEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException;

@RestController
public class SerieTempController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	private final ArrayList<SerieT> listSerieT = new ArrayList<>();

	@GetMapping("/hello")
	public String greeting(@RequestParam(value = "name", defaultValue = "World") String name, @RequestParam(value = "oui", defaultValue = "truc") String oui) {
		return "hello " + name + " et " + oui;
	}

	@GetMapping("/SerieT")
	ArrayList<SerieT> allSeries() {
		return listSerieT;
	}

	@GetMapping("/SerieT")
	String addSerie(@RequestBody SerieT serie) {
		try {
			listSerieT.add(serie);
			return "Serie ajouter";
		} catch (Exception e) {
			//TODO: handle exception

			return "probleme d'ajout";
		} 
	}

	@GetMapping("/SerieT/{id}")
	SerieT showSerie(@PathVariable int id)	{
		for (SerieT serieT : listSerieT) {
			if (serieT.getId() == id) {
				return serieT;
			}
		}
		throw new SerieNotFoundException(id);
	}

	
}