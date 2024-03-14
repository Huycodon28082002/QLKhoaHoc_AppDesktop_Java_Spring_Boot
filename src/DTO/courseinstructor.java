package DTO;

import java.util.Objects;

public class courseinstructor {
	public int CourseID  ;
	private String Title;
	public int PersonID ;
	private String FirstName;
	private String LastName;
	
	
	public courseinstructor(int courseID, int personID) {
		super();
		CourseID = courseID;
		PersonID = personID;
	}
	
	
	public courseinstructor() {
		super();
	}


	public int getCourseID() {
		return CourseID;
	}


	public void setCourseID(int courseID) {
		CourseID = courseID;
	}


	public String getTitle() {
		return Title;
	}


	public void setTitle(String title) {
		Title = title;
	}


	public int getPersonID() {
		return PersonID;
	}


	public void setPersonID(int personID) {
		PersonID = personID;
	}


	public String getFirstName() {
		return FirstName;
	}


	public void setFirstName(String firstName) {
		FirstName = firstName;
	}


	public String getLastName() {
		return LastName;
	}


	public void setLastName(String lastName) {
		LastName = lastName;
	}


	@Override
	public int hashCode() {
		return Objects.hash(CourseID, FirstName, LastName, PersonID, Title);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		courseinstructor other = (courseinstructor) obj;
		return CourseID == other.CourseID && Objects.equals(FirstName, other.FirstName)
				&& Objects.equals(LastName, other.LastName) && PersonID == other.PersonID
				&& Objects.equals(Title, other.Title);
	}
	

	
}
