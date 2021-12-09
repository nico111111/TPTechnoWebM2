package com.TechnoWeb.SerieTemp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="Tag")
public class Tag {
	@Id
    @GeneratedValue
    @Column(name = "Id", nullable = false)
    private Long id;

	@Column(name = "Value", nullable = true)
    private String value;

	public Tag() {}

	public Tag(Long id, String value) {
		this.id = id;
		this.value = value;
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
