package com.pnaditya.jersey.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserResponse {
	private Integer id;
	private String username;
	private String place;
	@JsonProperty("user_location")
	private String userLocation;

	public String getUserLocation() {
		return userLocation;
	}

	public void setUserLocation(String userLocation) {
		this.userLocation = userLocation;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	@Override
	public String toString() {
		return "UserResponse [id=" + id + ", username=" + username + ", place=" + place + ", userLocation="
				+ userLocation + "]";
	}

}
