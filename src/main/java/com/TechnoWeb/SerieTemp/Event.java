package com.TechnoWeb.SerieTemp;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import org.springframework.hateoas.RepresentationModel;

//https://spring.io/guides/tutorials/rest/
@Entity
@Table(name="EVENT")
public class Event extends RepresentationModel<Event> {
    @Id
    @GeneratedValue
    @Column(name = "Id", nullable = false)
    private Long id;

    @Column(name = "Date", nullable = false)
    private Date date;

    @Column(name = "Value", nullable = false)
    private float value;

    @Column(name = "Comment", nullable = true)
    private String comment;

    @ManyToMany(mappedBy = "event")
    private Set<Tag> tags;

    @JsonIgnoreProperties("listEvents")
    @ManyToOne
    @JoinColumn(name = "IdSerieT")
    private SerieT serieT;

	public Event() {}

    public Event(Date date, float value, String comment) {
        this.date = date;
        this.value = value;
        this.comment = comment;
        this.tags = new HashSet<Tag>();
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

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public Set<Tag> getTags() {
        return this.tags;
    }

    public SerieT getSerieT() {
		return serieT;
	}

	public void setSerieT(SerieT serieT) {
		this.serieT = serieT;
	}

    @Override
    public String toString() {
        return this.date + " " + this.value;
    }
}