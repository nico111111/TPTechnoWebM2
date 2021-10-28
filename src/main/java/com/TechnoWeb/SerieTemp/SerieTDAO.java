package com.TechnoWeb.SerieTemp;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SerieTDAO extends CrudRepository<SerieT, Long> {

    public List<SerieT> findByTitle(String title);


}
