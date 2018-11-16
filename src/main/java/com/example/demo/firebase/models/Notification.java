package com.example.demo.firebase.models;

public class Notification {

	private String name;
	private Integer clicks;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getClicks() {
		return clicks;
	}

	public void setClicks(Integer clicks) {
		this.clicks = clicks;
	}

	public Notification(String name, Integer clicks) {
		super();
		this.name = name;
		this.clicks = clicks;
	}

	public Notification() {
		super();
	}
}
