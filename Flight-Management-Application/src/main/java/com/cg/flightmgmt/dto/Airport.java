package com.cg.flightmgmt.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Airport {
	@Id
	@GeneratedValue
	private int airportid;
	private String airportName;
	private String airportLocation;
	// Parameterized constructor
	public Airport(int airportid, String airportName, String airportLocation) {
		super();
		this.airportid = airportid;
		this.airportName = airportName;
		this.airportLocation = airportLocation;
	}
	
	// default constructor
	public Airport() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	// Getter and setters
	public int getAirportid() {
		return airportid;
	}
	public void setAirportid(int airportid) {
		this.airportid = airportid;
	}
	public String getAirportName() {
		return airportName;
	}
	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}
	public String getAirportLocation() {
		return airportLocation;
	}
	public void setAirportLocation(String airportLocation) {
		this.airportLocation = airportLocation;
	}
	@Override
	public String toString() {
		return "Airport [airportid=" + airportid + ", airportName=" + airportName + ", airportLocation="
				+ airportLocation + "]";
	}
	
	
}
