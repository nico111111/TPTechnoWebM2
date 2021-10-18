package com.TechnoWeb.SerieTemp;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import javax.management.ServiceNotFoundException;

import org.apache.coyote.ActionCode;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.codec.HttpMessageEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException;

@RestController
public class SerieTempController {

	private final AtomicLong counter = new AtomicLong();
	private final ArrayList<SerieT> listSerieT = new ArrayList<>();
	private boolean remove;

	@GetMapping("/hello")
	public String greeting(@RequestParam(value = "name", defaultValue = "World") String name, @RequestParam(value = "oui", defaultValue = "truc") String oui) {
		return "hello " + name + " et " + oui;
	}

	@GetMapping("/SerieT")
	ArrayList<SerieT> allSeries() {
		return listSerieT;
	}

	@PostMapping("/SerieT")
	String addSerie(@RequestBody SerieT serie) {
		try {
			listSerieT.add(serie);
			return "Serie ajouter";
		} catch (Exception e) {
			//TODO catch might be useless
			return "probleme d'ajout";
		} 
	}

	@GetMapping("/SerieT/{id}")
	SerieT showSerie(@PathVariable int id)	{
		return findSerieByid(id);
		
	}
/*
	@GetMapping("/SerieT/{id}")
	EntityModel<SerieT> showSerie(@PathVariable int id, @RequestParam String type)	{
		SerieT serie;
		if(type.equals("HTML")) {
			serie = findSerieByid(id);
			return EntityModel.of(serie, //
			linkTo(methodOn(SerieTempController.class).showSerie(id)).withSelfRel(),
			linkTo(methodOn(SerieTempController.class).allSeries()).withRel("SerieT"));
		}else {
			return EntityModel.of(findSerieByid(id));
		}
	}
*/
	@DeleteMapping("/SerieT/{id}")
	void deleteSerie(@PathVariable int id) {
		listSerieT.remove(findSerieByid(id));
	}

	public SerieT findSerieByid(int id) {
		for (SerieT serieT : listSerieT) {
			if (serieT.getId() == id) {
				return serieT;
			}
		}
		throw new SerieNotFoundException(id);
	}

}