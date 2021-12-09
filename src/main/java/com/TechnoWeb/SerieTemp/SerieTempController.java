package com.TechnoWeb.SerieTemp;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import javax.management.ServiceNotFoundException;

import org.apache.coyote.ActionCode;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.http.codec.HttpMessageEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.hateoas.server.reactive.WebFluxLinkBuilder;

@RestController
public class SerieTempController {

	@Autowired
	private SerieTDAO serieTDAO;

	@Autowired
	private EventDAO eventDAO;

	@GetMapping("/")
	public String greeting(@RequestParam(value = "name", defaultValue = "World") String name, @RequestParam(value = "oui", defaultValue = "truc") String oui) {
		return "hello " + name + " et " + oui;
	}

	@GetMapping("/SerieT")
	CollectionModel<SerieT> allSeries() {
		Iterable<SerieT> listS = serieTDAO.findAll();
		for (SerieT se : listS) {
			Link selfLink = linkTo(methodOn(SerieTempController.class).findSerieById(se.getId())).withSelfRel();
			se.setSelfLink(selfLink);
		}
		return CollectionModel.of(listS);
	}


/*
	@GetMapping("/SerieT/{titre}")
	Iterable<SerieT> showSerie(@PathVariable String titre) {
		return serieTDAO.findByTitle(titre);
	}
*/
	@GetMapping("/SerieT/{id}")
	EntityModel<SerieT> findSerieById(@PathVariable long id) {
		try{
			SerieT test = serieTDAO.findById(id);
			test.setListeEvents(eventDAO.findByIdSerieT(test.getId()));
			return EntityModel.of(test,linkTo(methodOn(SerieTempController.class).findSerieById(id)).withSelfRel(),linkTo(methodOn(SerieTempController.class).allSeries()).withRel("toute les series"));
		}catch(Exception e){
			throw new SerieNotFoundException(id);
		}
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
	// @PostMapping("/SerieT")
	// String addSerie(@RequestBody SerieT serie) {
	// 	try {
	// 		listSerieT.add(serie);
	// 		return "Serie ajouter";
	// 	} catch (Exception e) {
	// 		//TODO catch might be useless
	// 		return "probleme d'ajout";
	// 	} 
	// }
*/
	// @DeleteMapping("/SerieT/{id}")
	// void deleteSerie(@PathVariable int id) {
	// 	listSerieT.remove(findSerieByid(id));
	// }

	// public SerieT findSerieByid(int id) {
	// 	for (SerieT serieT : listSerieT) {
	// 		if (serieT.getId() == id) {
	// 			return serieT;
	// 		}
	// 	}
	// 	throw new SerieNotFoundException(id);
	// }

}