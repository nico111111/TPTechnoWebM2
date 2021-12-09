package com.TechnoWeb.SerieTemp;

import java.util.Date;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;

//https://spring.io/guides/tutorials/rest/
@Entity
@Table(name="EVENT")
public class Event {
    @Id
    @GeneratedValue
    @Column(name = "Id", nullable = false)
    private Long id;

    @Column(name = "IdSerieT", nullable = false)
    private Long idSerieT;

    @Column(name = "Date", nullable = false)
    private Date date;

    @Column(name = "Value", nullable = false)
    private float value;

    @Column(name = "Comment", nullable = true)
    private String comment;

    @JsonInclude()
    @Transient
    private ArrayList<String> tags;

    public Event() {}

    public Event(Date date, float value, String comment) {
        this.date = date;
        this.value = value;
        this.comment = comment;
        this.tags = new ArrayList<String>();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
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

    public Long getIdSerieT() {
        return idSerieT;
    }

    public void setIdSerieT(Long idSerieT) {
        this.idSerieT = idSerieT;
    }

    @Override
    public String toString() {
        return this.date + " " + this.value;
    }
}