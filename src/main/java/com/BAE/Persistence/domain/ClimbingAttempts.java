package com.BAE.Persistence.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class ClimbingAttempts {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ClimbAttemptId;
	private Long climberId;
	private Date Date;
	private int Difficulty;
	private int TimeSpent;
	public Long getClimbAttemptId() {
		return ClimbAttemptId;
	}
	public void setClimbAttemptId(Long climbAttemptId) {
		ClimbAttemptId = climbAttemptId;
	}
	public Long getClimberId() {
		return climberId;
	}
	public void setClimberId(Long climberId) {
		this.climberId = climberId;
	}
	public Date getDate() {
		return Date;
	}
	public void setDate(Date date) {
		Date = date;
	}
	public int getDifficulty() {
		return Difficulty;
	}
	public void setDifficulty(int difficulty) {
		Difficulty = difficulty;
	}
	public int getTimeSpent() {
		return TimeSpent;
	}
	public void setTimeSpent(int timeSpent) {
		TimeSpent = timeSpent;
	}
	@Override
	public String toString() {
		return "ClimbingAttempts [climberId=" + climberId + ", Date=" + Date + ", Difficulty=" + Difficulty
				+ ", TimeSpent=" + TimeSpent + "]";
	}
	
}
