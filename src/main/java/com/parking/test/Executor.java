package com.parking.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.parking.endpoint.ParkingEndPoint;
import com.parking.model.Command;
import com.parking.model.Vehicle;

public class Executor {

	private static ApplicationContext context;
	private static ParkingEndPoint parking;
	private static String path = "F:/MyWorkSpace/ParkigSystem/";

	public static void main(String[] args) {

		context = new ClassPathXmlApplicationContext("/com/parking/config/applicationContext.xml");
		parking = context.getBean("parkingEndPoint", ParkingEndPoint.class);
		
		if(args[0].contains(".txt"))
			executeCommandsFromFile(args[0]);
		else
			executeCommand(args);
	}

	private static void executeCommandsFromFile(String fileName) {		
		String filePath = path + fileName;
		String line = null;
		
		try {
			FileReader fileReader = new FileReader(filePath);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			while((line = bufferedReader.readLine()) != null) {
				executeCommand(line.split(" "));
			}			
			bufferedReader.close();			
		} 
		catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void executeCommand(String[] arr) {		
	
		String command = arr[0];

		if(Command.CREATE_PARKING_LOT.toString().equalsIgnoreCase(command)) {
			parking.create(Integer.parseInt(arr[1]));
		}
		else if(Command.PARK.toString().equalsIgnoreCase(command)) {
			Vehicle vehicle = new Vehicle(arr[1], arr[2]);
			parking.park(vehicle);
		}
		else if(Command.LEAVE.toString().equalsIgnoreCase(command)) {
			parking.leave(Integer.parseInt(arr[1]));
		}
		else if(Command.STATUS.toString().equalsIgnoreCase(command)) {
			parking.status();
		}
		else if(Command.REGISTRATION_NUMBERS_FOR_CARS_WITH_COLOUR.toString().equalsIgnoreCase(command)) {
			parking.registrationNumbersForVehicleWithColor(arr[1]);
		}
		else if(Command.SLOT_NUMBERS_FOR_CARS_WITH_COLOUR.toString().equalsIgnoreCase(command)) {
			parking.slotNumbersForVehicleWithColor(arr[1]);
		}
		else if(Command.SLOT_NUMBER_FOR_REGISTRATION_NUMBER.toString().equalsIgnoreCase(command)) {
			parking.slotNumberForVehicle(arr[1]);
		}
		else {
			System.out.println("Wrong command !");
		}
	}
}
