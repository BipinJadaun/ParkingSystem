package com.parking.util;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import com.parking.model.Vehicle;

@Service
public class ParkingUtil {

	public void printRegistrationNumbers(List<Vehicle> list) {
		StringBuilder regNumbers = new StringBuilder();
		for(Vehicle vehicle : list) {
			regNumbers.append(vehicle.getVehicleNumber()).append(", ");
		}
		regNumbers.deleteCharAt(regNumbers.length()-2);

		System.out.println(regNumbers);		
	}

	public void printSlotNumbers(List<Vehicle> list) {
		StringBuilder regNumbers = new StringBuilder();
		for(Vehicle vehicle : list) {
			regNumbers.append(vehicle.getAllotedSlot()).append(", ");
		}
		regNumbers.deleteCharAt(regNumbers.length()-2);

		System.out.println(regNumbers);		
	}

	public void printParkedVehicles(Collection<Vehicle> vehicles) {
		
		System.out.println("Slot Number" +"\t" + "Registration Number" + "\t" + "Colour");
		for(Vehicle vehicle : vehicles) {			
			System.out.println(vehicle.getAllotedSlot() +"\t\t" +vehicle.getVehicleNumber() + "\t\t" + vehicle.getVehicleColor());
		}		
	}

	public void printSlotNumberForVehicle(Collection<Vehicle> vehicles, String vehicleNumber) {
		boolean found  = false;
		for(Vehicle vehicle : vehicles) {
			if(vehicle.getVehicleNumber().equals(vehicleNumber)) {
				System.out.println(vehicle.getAllotedSlot());
				found = true;
				break;
			}				
		}
		if(!found)
			System.out.println("Not found");
	}
}
