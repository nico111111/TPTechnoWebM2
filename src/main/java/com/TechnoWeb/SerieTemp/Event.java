package com.TechnoWeb.SerieTemp;

import java.util.Date;
import java.util.ArrayList;

//https://spring.io/guides/tutorials/rest/

public class Event {
    private int id;
    private Date date;
    private float value;
    private String comment;
    private ArrayList<String> tags;

    public Event() {}

    public Event(int id, Date date, float value, String comment) {
        this.id = id;
        this.date = date;
        this.value = value;
        this.comment = comment;
        this.tags = new ArrayList<String>();
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setdate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return this.date;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public float getValue() {
        return this.value;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return this.comment;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    public ArrayList<String> getTags() {
        return this.tags;
    }

    @Override
    public String toString() {
        return this.date + " " + this.value;
    }
}