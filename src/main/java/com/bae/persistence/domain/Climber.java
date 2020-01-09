package com.bae.persistence.domain;

import java.util.List;

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

	@OneToMany(cascade = CascadeType.ALL)
	@Column(name = "Climber_Id")
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((climbingAttempts == null) ? 0 : climbingAttempts.hashCode());
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Climber other = (Climber) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (climbingAttempts == null) {
			if (other.climbingAttempts != null)
				return false;
		} else if (!climbingAttempts.equals(other.climbingAttempts))
			return false;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}



}
