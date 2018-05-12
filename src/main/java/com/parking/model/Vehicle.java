package com.parking.model;

public class Vehicle {
	
	private String vehicleNumber;
	private String vehicleColor;
	private int allotedSlot;
	
	public Vehicle() {
	}
	
	public Vehicle(String vehicleNumber, String vehicleColor) {
		this.vehicleNumber = vehicleNumber;
		this.vehicleColor = vehicleColor;
	}
	
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public String getVehicleColor() {
		return vehicleColor;
	}
	public void setVehicleColor(String vehicleColor) {
		this.vehicleColor = vehicleColor;
	}
	public int getAllotedSlot() {
		return allotedSlot;
	}
	public void setAllotedSlot(int allotedSlot) {
		this.allotedSlot = allotedSlot;
	}
	

}
