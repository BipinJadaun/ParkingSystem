package com.parking.test;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.parking.endpoint.ParkingEndPoint;
import com.parking.model.Vehicle;

public class TestClass {
	
	private static ParkingEndPoint parking;
	private static ApplicationContext context;
	
	@BeforeClass
	public static void setUp() throws Exception{
		context = new ClassPathXmlApplicationContext("/com/parking/config/applicationContext.xml");
		parking = context.getBean("parkingEndPoint", ParkingEndPoint.class);
	}

	@Test
	public void testParkingSystem() {
		
		Vehicle vehicle1 = new Vehicle("KA-01-HH-1234", "white");
		Vehicle vehicle2 = new Vehicle("KA-01-HH-9999", "white");
		Vehicle vehicle3 = new Vehicle("KA-01-BB-0001", "red");
		Vehicle vehicle4 = new Vehicle("KA-01-HH-7777", "black");
		Vehicle vehicle5 = new Vehicle("KA-01-HH-2701", "blue");
		Vehicle vehicle6 = new Vehicle("KA-01-HH-3141", "black");
		Vehicle vehicle7 = new Vehicle("KA-01-P-333", "white");
		Vehicle vehicle8 = new Vehicle("DL-12-AA-9999", "white");
		
		parking.create(6);
		
		parking.park(vehicle1);
		parking.park(vehicle2);
		parking.park(vehicle3);
		parking.park(vehicle4);
		parking.park(vehicle5);
		parking.park(vehicle6);
		
		parking.leave(4);
		parking.leave(2);
		
		parking.status();
		
		parking.park(vehicle7);
		parking.park(vehicle8);
		
		parking.registrationNumbersForVehicleWithColor("white");
		
		parking.slotNumbersForVehicleWithColor("white");
		
		parking.slotNumberForVehicle("KA-01-HH-3141");
		
		parking.slotNumberForVehicle("MH-04-AY-1111");
		
	}
}
