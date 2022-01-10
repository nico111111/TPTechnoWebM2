package com.TechnoWeb.SerieTemp;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Tag")
public class Tag {
	@Id
    @GeneratedValue
    @Column(name = "Id", nullable = false)
    private Long id;

	@Column(name = "Value", nullable = true)
    private String value;

	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "EVENT_TAG", joinColumns = {
		@JoinColumn(name = "idTag")}, inverseJoinColumns = @JoinColumn(name = "idEvent"))
	private Set<Event> event;
	

	public Tag() {}

	public Tag(Long id, String value) {
		this.id = id;
		this.value = value;
	}

	public Set<Event> getEvent() {
		return event;
	}

	public void setEvent(Set<Event> event) {
		this.event = event;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
