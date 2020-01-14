package com.bae.persistence.domain;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.persistence.ManyToOne;

@Entity
public class ClimbingAttempts {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private int day;
	private int month;
	private int year;
	private int difficulty;
	private int timeSpent;

	@ManyToOne
	private Set<Climber> climbers;


	public ClimbingAttempts(int day, int month, int year, int difficulty, int timeSpent) {
		super();
		this.day = day;
		this.month = month;
		this.year = year;
		this.difficulty = difficulty;
		this.timeSpent = timeSpent;
	}

	public ClimbingAttempts(){

	}



	public Long getId() { return id; }

	public void setId(Long id) { this.id = id; }

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
		return "ClimbingAttempts{" +
				"id=" + id +
				", day=" + day +
				", month=" + month +
				", year=" + year +
				", difficulty=" + difficulty +
				", timeSpent=" + timeSpent +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ClimbingAttempts that = (ClimbingAttempts) o;
		return day == that.day &&
				month == that.month &&
				year == that.year &&
				difficulty == that.difficulty &&
				timeSpent == that.timeSpent &&
				Objects.equals(id, that.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, day, month, year, difficulty, timeSpent);
	}
}
