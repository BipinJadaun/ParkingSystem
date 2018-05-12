package com.parking.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import org.springframework.stereotype.Repository;

import com.parking.model.Vehicle;

@Repository
public class ParkingDao {
	
	private int parkingSize;	
	private PriorityQueue<Integer> availableSlots ;	
	private Map<Integer, Vehicle> occupiedSlots;
	
	public void createParkingLot(int size) {
		this.parkingSize = size;
		availableSlots = new PriorityQueue<Integer>(parkingSize);
		occupiedSlots = new HashMap<Integer, Vehicle>(parkingSize);
		initialize();
	}

	private void initialize() {		
		for(int i = 1; i <= parkingSize; i++) {
			availableSlots.add(i);
		}
		System.out.println("Created a parking lot with "+ parkingSize +" slots");
	}

	public void parkVehicle(Vehicle vehicle) {
		int slotNumber = availableSlots.poll();
		vehicle.setAllotedSlot(slotNumber);
		occupiedSlots.put(slotNumber, vehicle);
		System.out.println("Allocated slot number: " + slotNumber);
	}
	
	public boolean isParkingSpaceAvailable() {
		if(availableSlots.isEmpty())
			return false;

		return true;
	}

	public boolean isSlotOccupied(int slotNumber) {
		if(occupiedSlots.containsKey(slotNumber))
			return true;
		
		return false;
	}

	public void removeVehicle(int slotNumber) {
		occupiedSlots.remove(slotNumber);
		availableSlots.add(slotNumber);
		System.out.println("Slot number " +slotNumber+ " is free");
	}

	public List<Vehicle> getVehicleWithColor(String color) {
		List<Vehicle> list = new ArrayList<Vehicle>();
		for(Vehicle vehicle : occupiedSlots.values()) {
			if(vehicle.getVehicleColor().equals(color))
				list.add(vehicle);
		}
		return list;
	}

	public Collection<Vehicle> getParkedVehicles() {	
		return  occupiedSlots.values();
	}

}
