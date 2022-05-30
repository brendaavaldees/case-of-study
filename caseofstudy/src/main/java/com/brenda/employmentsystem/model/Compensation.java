package com.brenda.employmentsystem.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "COMPENSATIONS")
public class Compensation{
	
	@Id
    @Column(name = "compensation_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "type_id")
	private CompensationType type;
	
	@Column(name = "compensation_amount")
	private float amount;
	
	@Column(name = "compensation_descr")
	private String description;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "compensation_date")
	private String date;
	
	@ManyToOne
	@JoinColumn(name = "employee_id")
	private Employee employee;
	

	public Compensation() {
		super();
	}

	public Compensation(Employee employee) {
		super();
		this.employee = employee;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public CompensationType getType() {
		return type;
	}

	public void setType(CompensationType type) {
		this.type = type;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
}
