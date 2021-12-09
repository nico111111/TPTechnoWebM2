package com.TechnoWeb.SerieTemp;

public class SerieNotFoundException extends RuntimeException {
    SerieNotFoundException(long id) {
        super("Could not find serie : " + id);
    }
}
