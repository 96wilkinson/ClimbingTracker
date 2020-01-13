package com.bae.persistence.domain;

import java.util.List;
import java.util.Objects;

import javax.persistence.*;

@Entity
public class Climber {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="username")
	private String username;

	@Column(name="firstname")
	private String firstname;

	@Column(name="surname")
	private String surname;

	@OneToMany(mappedBy = "climber")
	private List<ClimbingAttempts> climbingAttempts;

	public Climber(String username, String firstname, String surname) {
		super();
		this.username = username;
		this.firstname = firstname;
		this.surname = surname;
	}

	public Climber() {

	}

	public Long getId() {return id;}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}


	@Override
	public String toString() {
		return "Climber{" +
				"id=" + id +
				", username='" + username + '\'' +
				", firstname='" + firstname + '\'' +
				", surname='" + surname + '\'' +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Climber climber = (Climber) o;
		return Objects.equals(id, climber.id) &&
				Objects.equals(username, climber.username) &&
				Objects.equals(firstname, climber.firstname) &&
				Objects.equals(surname, climber.surname) &&
				Objects.equals(climbingAttempts, climber.climbingAttempts);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, username, firstname, surname, climbingAttempts);
	}
}
