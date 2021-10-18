package com.TechnoWeb.SerieTemp;

import java.util.ArrayList;

public class SerieT {
    private int id;
    private String title;
    private String desc;
    private ArrayList<Event> listEvents;

    public SerieT(){}

    public SerieT(int id, String title, String desc){
        this.id = id;
        this.title = title;
        this.desc = desc;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setListeEvents(ArrayList<Event> listEvents) {
        this.listEvents = listEvents;
    }

    public ArrayList<Event> getListEvents() {
        return this.listEvents;
    }

    @Override
    public String toString() {
        String returnString = title + " : ";
        for (Event event : listEvents) {
            returnString = returnString + event.toString();
        }
        
        return returnString;
    }

}