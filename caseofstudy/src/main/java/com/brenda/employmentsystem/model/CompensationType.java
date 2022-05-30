package com.brenda.employmentsystem.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "COMPENSATION_TYPES")
public class CompensationType {
	
	@Id
    @Column(name = "type_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "type_name")
	private String name;
	
	@OneToMany(mappedBy = "type")
	private Collection<Compensation> compensation;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<Compensation> getCompensation() {
		return compensation;
	}

	public void setCompensation(Collection<Compensation> compensation) {
		this.compensation = compensation;
	}

	@Override
	public String toString() {
		return name;
	}
	
}
