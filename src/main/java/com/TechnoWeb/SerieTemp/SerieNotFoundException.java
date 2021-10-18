package com.TechnoWeb.SerieTemp;

public class SerieNotFoundException extends RuntimeException {
    SerieNotFoundException(int id) {
        super("Could not find serie : " + id);
    }
}
