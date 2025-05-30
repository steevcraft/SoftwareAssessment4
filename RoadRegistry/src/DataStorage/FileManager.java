package DataStorage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

import RoadRegistry.DemeritPoint;
import RoadRegistry.Person;

public class FileManager {
	
	String filename;
	public FileManager() {
		
	}
	
	public FileManager(String filename) {
		this.filename = filename;
	}
	
	public void setFileName(String filename) {
		this.filename = filename;
	}
	
	public Person readPersonByPersonId(String personID) {
		
		Person person = new Person();
		
		
		try {
		      Scanner myReader = new Scanner(new FileReader(filename));
		      while (myReader.hasNextLine()) {
		    	  String[] values = myReader.nextLine().split(",");
		    	  String[] readPoints = myReader.nextLine().split(",");
		    	  if(values[0].equals(personID)) {
		    		  ArrayList<DemeritPoint> points = new ArrayList<DemeritPoint>();
		   
		    		  for(int i=0;i<readPoints.length/2;i++) {
		    			  points.add(new DemeritPoint(readPoints[i*2],Integer.parseInt(readPoints[i*2+1])));
		    		  }
		    		  boolean isSus = (values[5].equals("true"));
		    		  person = new Person(personID, values[1], values[2], values[3], values[4], points, isSus);
		    	  }
		    	  
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		
		return person;
	}
	
	/*
	private String personID;
	private String firstName;
	private String lastName;
	private String address;
	private String birthdate;
	private HashMap<Date, Integer> demeritPoints;
	private boolean isSuspended;
	*/
	public String writeNewPerson(Person person) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true));
			writer.write(person.personID+",");
			writer.write(person.firstName+",");
			writer.write(person.lastName+",");
			writer.write(person.address+",");
			writer.write(person.birthdate+",");
			if(person.isSuspended) {
				writer.write("true,");
			}else {
				writer.write("false,");
			}
			writer.newLine();;
			for(DemeritPoint point : person.demeritPoints) {
				writer.write(point.date + "," + Integer.toString(point.points)+",");
			}
			writer.newLine();
			
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Failed";
		}
		return "Success";
	}
	
	public boolean personExists(String personID) {
		try {
		      Scanner myReader = new Scanner(new FileReader(filename));
		      while (myReader.hasNextLine()) {
		    	  String[] values = myReader.nextLine().split(",");
		    	  String[] readPoints = myReader.nextLine().split(",");
		    	  if(values[0].equals(personID)) {
		    		  return true;
		    	  }
		    	  
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		return false;
	}
	
	private String writePerson(Person person) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true));
			writer.write(person.personID+",");
			writer.write(person.firstName+",");
			writer.write(person.lastName+",");
			writer.write(person.address+",");
			writer.write(person.birthdate+",");
			if(person.isSuspended) {
				writer.write("true,");
			}else {
				writer.write("false,");
			}
			writer.newLine();;
			for(DemeritPoint point : person.demeritPoints) {
				writer.write(point.date + "," + Integer.toString(point.points)+",");
			}
			writer.newLine();
			
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Failed";
		}
		return "Success";
	}
	
	public String updatePerson(Person person) {
		ArrayList<Person> people = new ArrayList<Person>();
		try {
		      Scanner myReader = new Scanner(new FileReader(filename));
		      
		      while (myReader.hasNextLine()) {
		    	  String[] values = myReader.nextLine().split(",");
		    	  String[] readPoints = myReader.nextLine().split(",");
		    	  
		    		  ArrayList<DemeritPoint> points = new ArrayList<DemeritPoint>();
		   
		    		  for(int i=0;i<readPoints.length/2;i++) {
		    			  points.add(new DemeritPoint(readPoints[i*2],Integer.parseInt(readPoints[i*2+1])));
		    		  }
		    		  boolean isSus = (values[5].equals("true"));
		    	 Person readPerson = new Person(values[0], values[1], values[2], values[3], values[4], points, isSus);
		    	  
		    	  people.add(readPerson);
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		      return "Read File Fail";
		    }
		File deleteOld = new File(filename);
		deleteOld.delete();
		for(Person p : people) {
			if(p.personID.equals(person.personID)) {
				writePerson(person);
				continue;
			}
			writePerson(p);
		}
		return "Success";
	}
	
	public String addDemeritPoint(String personID, DemeritPoint point) {
		ArrayList<Person> people = new ArrayList<Person>();
		try {
		      Scanner myReader = new Scanner(new FileReader(filename));
		      
		      while (myReader.hasNextLine()) {
		    	  String[] values = myReader.nextLine().split(",");
		    	  String[] readPoints = myReader.nextLine().split(",");
		    	  
		    		  ArrayList<DemeritPoint> rpoints = new ArrayList<DemeritPoint>();
		   
		    		  for(int i=0;i<readPoints.length/2;i++) {
		    			  rpoints.add(new DemeritPoint(readPoints[i*2],Integer.parseInt(readPoints[i*2+1])));
		    		  }
		    		  boolean isSus = (values[5].equals("true"));
		    	 Person readPerson = new Person(values[0], values[1], values[2], values[3], values[4], rpoints, isSus);
		    	  
		    	  people.add(readPerson);
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		      return "Read File Fail";
		    }
		File deleteOld = new File(filename);
		deleteOld.delete();
		for(Person p : people) {
			if(p.personID.equals(personID)) {
				p.demeritPoints.add((point));
			}
			writePerson(p);
		}
		return "Success";
	}
	
	
}
