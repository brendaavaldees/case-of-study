package com.brenda.employmentsystem.model;

import java.sql.Date;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.NonNull;


@Entity
@Table(name = "EMPLOYEES")
public class Employee {

    @Id
    @Column(name = "employee_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//@NonNull(message= "This field cannot be empty")
    @NonNull
    @Column(name = "employee_fn")
	private String firstName;
	
    @Column(name = "employee_mn")
	private String middleName;
	
	//@NotEmpty(message= "This field cannot be empty")
    @NonNull
    @Column(name = "employee_ln")
	private String lastName;
	
	//@NotNull(message= "Due must be set")
    @NonNull
    @Column(name = "employee_birth")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	private String birthday;
	
	//@NotEmpty(message= "This field cannot be empty")
    @NonNull
    @Column(name = "employee_position")
	private String position;
    
    @OneToMany(mappedBy = "employee")
    private Collection<Compensation> compensation;

    public Employee(Long id, String firstName, String middleName, String lastName, String birthday, String position) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.position = position;
    }

    public Employee() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

	public Collection<Compensation> getCompensation() {
		return compensation;
	}

	public void setCompensation(Collection<Compensation> compensation) {
		this.compensation = compensation;
	}

}
