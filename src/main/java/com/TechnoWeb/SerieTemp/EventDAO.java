package com.TechnoWeb.SerieTemp;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventDAO extends CrudRepository<Event, Long>{
    public List<Event> findBySerieT(SerieT serieT);
}
