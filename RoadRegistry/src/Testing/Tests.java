package Testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

import DataStorage.FileManager;
import RoadRegistry.DemeritPoint;
import RoadRegistry.Person;

class Tests {

	@Test
	public static void main(String[] args) {
		ArrayList<DemeritPoint> demeritPoints = new ArrayList<DemeritPoint>();
		demeritPoints.add(new DemeritPoint("Today", 6));
		Person person = new Person("person1", "John", "Smith", "300 Road Street, Melbourne", "9-9-1999", demeritPoints, false);
		
		FileManagerTests();
		
		System.out.println();
		
		try{
			assertEquals("Success", person.addPerson());
			System.out.println("Add Person a Success");
			assertEquals("Fail", person.addPerson());
			System.out.println("Add Person Fail");
		} catch(AssertionError e){
		  String message = e.getMessage();
		  System.out.println(message);
		}
		
	}
	
	public static void FileManagerTests() {
		FileManager file = new FileManager("tests.txt");
		ArrayList<DemeritPoint> demeritPoints = new ArrayList<DemeritPoint>();
		demeritPoints.add(new DemeritPoint("Yesterday", 7));
		Person testPerson = new Person("person2", "John", "Smith", "100 Road Street, Melbourne", "10-10-2001", demeritPoints, false);
		try{
			assertEquals("Success", file.writeNewPerson(testPerson));
			System.out.println("Add Person a Success");

		} catch(AssertionError e){
		  String message = e.getMessage();
		  System.out.println(message);
		}
	}

}
