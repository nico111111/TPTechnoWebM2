package com.TechnoWeb.SerieTemp;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class SerieTempController {

	@Autowired
	private SerieTDAO serieTDAO;
	
	@Autowired
	private EventDAO eventDAO;

	@GetMapping("/SerieT")
	CollectionModel<SerieT> allSeries() {
		Iterable<SerieT> listS = serieTDAO.findAll();

		for (SerieT se : listS) {
			Link selfLink = linkTo(methodOn(SerieTempController.class).findSerieById(se.getId())).withSelfRel();
			se.add(selfLink);
			for(Event ev : se.getListEvents()) {
				selfLink = linkTo(methodOn(SerieTempController.class).findEventById(ev.getId())).withSelfRel();
				ev.add(selfLink);
			}
		}

		return CollectionModel.of(listS);
	}

	@GetMapping("/SerieT/{id}")
	EntityModel<SerieT> findSerieById(@PathVariable long id) {
		try{
			SerieT se = serieTDAO.findById(id);

			Link selfLink = linkTo(methodOn(SerieTempController.class).findSerieById(id)).withSelfRel();
			Link allSerieLink = linkTo(methodOn(SerieTempController.class).allSeries()).withRel("all series");
			se.add(selfLink);
			se.add(allSerieLink);

			for(Event ev : se.getListEvents()) {
				selfLink = linkTo(methodOn(SerieTempController.class).findEventById(ev.getId())).withSelfRel();
				ev.add(selfLink);
			}

			return EntityModel.of(se);
		}catch(Exception e){
			throw new SerieNotFoundException(id);
		}
	}

	@GetMapping("/Event/{id}")
	EntityModel<Event> findEventById(@PathVariable long id) {
		try{
			Event ev = eventDAO.findById(id);

			Link selfLink = linkTo(methodOn(SerieTempController.class).findEventById(id)).withSelfRel();
			ev.add(selfLink);
			
			SerieT ser = ev.getSerieT();
			Link serieLink = linkTo(methodOn(SerieTempController.class).findSerieById(ser.getId())).withSelfRel();
			ser.add(serieLink);

			return EntityModel.of(ev);
		}catch(Exception e){
			throw new SerieNotFoundException(id);
		}
	}
}
