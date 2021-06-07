package com.cg.flightmgmt.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
public class Flight {
	@Id
	@GeneratedValue
	private int flightId;
	@NotEmpty(message = "Carrier Name should not be Empty")
	private String carrierName;
	@NotEmpty(message = "Flight model should not be Empty")
	private String flightModel;
	@Max(value = 200, message = "capacity should be max 200")
	@Min(value=150, message = "capacity should be minimum 150")
	private int seatCapacity;

	// Default Constructor
	public Flight() {
		super();
	}

	// Parameterized Constructor
	public Flight(String carrierName, String flightModel, int seatCapacity) {
		super();
		this.carrierName = carrierName;
		this.flightModel = flightModel;
		this.seatCapacity = seatCapacity;
	}

	// Parameterized Constructor
	public Flight(int flightId, String carrierName, String flightModel, int seatCapacity) {
		super();
		this.flightId = flightId;
		this.carrierName = carrierName;
		this.flightModel = flightModel;
		this.seatCapacity = seatCapacity;
	}

	// Getter and setters
	public String getCarrierName() {
		return carrierName;
	}

	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}

	public String getFlightModel() {
		return flightModel;
	}

	public void setFlightModel(String flightModel) {
		this.flightModel = flightModel;
	}

	public int getSeatCapacity() {
		return seatCapacity;
	}

	public void setSeatCapacity(int seatCapacity) {
		this.seatCapacity = seatCapacity;
	}

	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	@Override
	public String toString() {
		return "Flight [flightId=" + flightId + ", carrierName=" + carrierName + ", flightModel=" + flightModel
				+ ", seatCapacity=" + seatCapacity + "]";
	}

}
