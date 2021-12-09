package com.TechnoWeb.SerieTemp;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.hateoas.Link;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

@Entity
@Table(name="SERIET")
public class SerieT {

    @Id
    @GeneratedValue
    @Column(name = "Id", nullable = false)
    private Long id;

    @Column(name = "Title", length = 64, nullable = false)
    private String title;

    @Column(name = "Desc", length = 1024, nullable = true)
    private String desc;

    @JsonInclude()
    @Transient
    private ArrayList<Event> listEvents;

    @Transient
    private Link selfLink;

    public SerieT(){}

    public SerieT(String title, String desc){
        this.title = title;
        this.desc = desc;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
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

    public void setSelfLink(Link l) {
        this.selfLink = l;
    }

    public Link getSelfLink() {
        return this.selfLink;
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
        if(listEvents != null){
            for (Event event : listEvents) {
                returnString = returnString + event.toString();
            }
        }
        return returnString;
    }

}