package com.parking.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parking.dao.ParkingDao;
import com.parking.model.Vehicle;
import com.parking.util.ParkingUtil;

@Service
public class ParkingService {

	@Autowired
	private ParkingDao dao;
	@Autowired
	private ParkingUtil util;
	

	public void createParkingLot(int size) {
		dao.createParkingLot(size);
	}

	public void parkVehicle(Vehicle vehicle) {
		if(dao.isParkingSpaceAvailable()) {
			dao.parkVehicle(vehicle);
		}			
		else {
			System.out.println("Sorry, parking lot is full");
		}
	}

	public void removeVehicle(int slotNumber) {
		if(dao.isSlotOccupied(slotNumber)){
			dao.removeVehicle(slotNumber);
		}else {
			System.out.println("Slot is already free");
		}
	}

	public void printSlotNumberForVehicle(String vehicleNumber) {
		
		Collection<Vehicle> vehicles = dao.getParkedVehicles();
		util.printSlotNumberForVehicle(vehicles, vehicleNumber);
	}

	public void printParkingStatus() {
		Collection<Vehicle> vehicles = dao.getParkedVehicles();
		util.printParkedVehicles(vehicles);
	}

	public void printSlotNumbersForVehicleWithColor(String color) {
		List<Vehicle> vehicles = dao.getVehicleWithColor(color);
		util.printSlotNumbers(vehicles);
	}

	public void printRegistrationNumbersForVehicleWithColor(String color) {
		
		List<Vehicle> vehicles = dao.getVehicleWithColor(color);
		util.printRegistrationNumbers(vehicles);
	}
}
