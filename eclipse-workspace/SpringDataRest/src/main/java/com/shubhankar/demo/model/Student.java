package com.shubhankar.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Student
{
	@Id
	@GeneratedValue
	private int sid;
	private String name;
	private String training;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTraining() {
		return training;
	}
	public void setTraining(String training) {
		this.training = training;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", name=" + name + ", training=" + training + "]";
	}
	
	

}
