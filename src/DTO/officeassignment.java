package DTO;

import java.security.Timestamp;
import java.util.Objects;

public class officeassignment {
	public int InstructorID  ;
	public String  Location ; 
	public Timestamp Timestamp ;
	public int getInstructorID() {
		return InstructorID;
	}
	public void setInstructorID(int instructorID) {
		InstructorID = instructorID;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	public Timestamp getTimestamp() {
		return Timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		Timestamp = timestamp;
	}
	@Override
	public int hashCode() {
		return Objects.hash(InstructorID, Location, Timestamp);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		officeassignment other = (officeassignment) obj;
		return InstructorID == other.InstructorID && Objects.equals(Location, other.Location)
				&& Objects.equals(Timestamp, other.Timestamp);
	}
	
}
