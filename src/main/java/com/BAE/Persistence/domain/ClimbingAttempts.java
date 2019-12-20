package com.bae.Persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ClimbingAttempts {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private int day;
	private int month;
	private int year;
	private int difficulty;
	private int timeSpent;

	public ClimbingAttempts() {

	}

	public ClimbingAttempts(int day, int month, int year, int difficulty, int timeSpent) {
		super();
		this.day = day;
		this.month = month;
		this.year = year;
		this.difficulty = difficulty;
		this.timeSpent = timeSpent;
	}

	public Long getClimbAttemptId() {
		return Id;
	}

	public void setClimbAttemptId(Long climbAttemptId) {
		this.Id = climbAttemptId;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}

	public int getTimeSpent() {
		return timeSpent;
	}

	public void setTimeSpent(int timeSpent) {
		this.timeSpent = timeSpent;
	}

	@Override
	public String toString() {
		return "ClimbingAttempts [day=" + day + ", month=" + month + ", year=" + year + ", difficulty=" + difficulty
				+ ", timeSpent=" + timeSpent + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
		result = prime * result + day;
		result = prime * result + difficulty;
		result = prime * result + month;
		result = prime * result + timeSpent;
		result = prime * result + year;
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
		ClimbingAttempts other = (ClimbingAttempts) obj;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		if (day != other.day)
			return false;
		if (difficulty != other.difficulty)
			return false;
		if (month != other.month)
			return false;
		if (timeSpent != other.timeSpent)
			return false;
		if (year != other.year)
			return false;
		return true;
	}

}
