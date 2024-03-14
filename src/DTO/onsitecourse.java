package DTO;

import java.sql.Time;
import java.util.Objects;

public class onsitecourse  extends course {
	public String  	Location ;
	public String  Days ;
	public Time Time;
	
	
	public onsitecourse(int courseID, String title, int credits, int departmentID,String location, String days, Time time) {
		super();
		CourseID = courseID;
		Title = title;
		Credits = credits;
		DepartmentID = departmentID;
		Location = location;
		Days = days;
		Time = time;
	}
	
	public onsitecourse() {
		super();
	}

	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	public String getDays() {
		return Days;
	}
	public void setDays(String days) {
		Days = days;
	}
	public Time getTime() {
		return Time;
	}
	public void setTime(Time time) {
		Time = time;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(Days, Location, Time);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		onsitecourse other = (onsitecourse) obj;
		return Objects.equals(Days, other.Days) && Objects.equals(Location, other.Location)
				&& Objects.equals(Time, other.Time);
	}
	
	
}
