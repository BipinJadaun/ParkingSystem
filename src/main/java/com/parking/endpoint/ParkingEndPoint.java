package com.parking.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.parking.model.Vehicle;
import com.parking.service.ParkingService;

@Component
public class ParkingEndPoint {

	@Autowired
	private ParkingService service;


	public void create(int size) {
		service.createParkingLot(size);
	}

	public void park(Vehicle vehicle) {
		service.parkVehicle(vehicle);
	}


	public void leave(int slotNumber) {
		service.removeVehicle(slotNumber);
	}

	public void status() {
		service.printParkingStatus();
	}

	public void slotNumberForVehicle(String vehicleNumber) {
		service.printSlotNumberForVehicle(vehicleNumber);

	}

	public void slotNumbersForVehicleWithColor(String color){
		service.printSlotNumbersForVehicleWithColor(color);
	}

	public void registrationNumbersForVehicleWithColor(String color){
		service.printRegistrationNumbersForVehicleWithColor(color);
	}

}
