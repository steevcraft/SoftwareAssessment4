package RoadRegistry;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Date;

public class Person {
	public String personID;
	public String firstName;
	public String lastName;
	public String address;
	public String birthdate;
	public ArrayList<DemeritPoint> demeritPoints;
	public boolean isSuspended;
	
	public Person() {
		this.personID="defaultID";
		this.firstName="firstName";
		this.lastName="lastName";
		this.address="address";
		this.birthdate="yesterday";
		this.demeritPoints=new ArrayList<DemeritPoint>();
		this.isSuspended=false;
	}
	public Person(String personID, String firstName, String lastName, String address, String birthdate, ArrayList<DemeritPoint> demeritPoints, boolean isSuspended) {
		this.personID=personID;
		this.firstName=firstName;
		this.lastName=lastName;
		this.address=address;
		this.birthdate=birthdate;
		this.demeritPoints=demeritPoints;
		this.isSuspended=isSuspended;
	}
	
	public String addPerson() {
		
		return "Success";
	}
	
	public String updatePersonalDetails() {
		
		return "Success";
	}
	
	public String addDemeritPoints() {
		
		return "Success";
	}

}
