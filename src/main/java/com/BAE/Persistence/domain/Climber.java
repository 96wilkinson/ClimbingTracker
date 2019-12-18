package com.BAE.Persistence.domain;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Climber {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String userName;
	private String firstName;
	private String surName;
	
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "climber_id")
    private List<ClimbingAttempts> climbingAttempts;
	
	public Climber() {
		
	}
	
	public Climber(String userName, String firstName, String surName) {
		super();
		this.userName = userName;
		this.firstName = firstName;
		this.surName = surName;
	}



	public Long getClimberId() {
		return Id;
	}

	public void setClimberId(Long climberId) {
		this.Id = climberId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	@Override
	public String toString() {
		return "Climber [userName=" + userName + ", firstName=" + firstName + ", surName=" + surName + "]";
	}

}
