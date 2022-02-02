package com.TechnoWeb.SerieTemp;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="SERIET")
public class SerieT extends RepresentationModel<SerieT> {

    @Id
    @GeneratedValue
    @Column(name = "Id", nullable = false)
    private Long id;

    @Column(name = "Title", length = 64, nullable = false)
    private String title;

    @Column(name = "Desc", length = 1024, nullable = true)
    private String desc;

    @JsonIgnoreProperties("serieT")
    @OneToMany(mappedBy = "serieT")
    private Set<Event> listEvents;

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

    public Set<Event> getListEvents() {
        return listEvents;
    }

    public void setListEvents(Set<Event> listEvents) {
        this.listEvents = listEvents;
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