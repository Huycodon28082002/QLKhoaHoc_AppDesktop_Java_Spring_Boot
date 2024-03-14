package DTO;

import java.util.Objects;

public class course {
	public int CourseID  ;
	public String  Title ;
	public int Credits  ;
	public int DepartmentID ;
	
	
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
	public int getCredits() {
		return Credits;
	}
	public void setCredits(int credits) {
		Credits = credits;
	}
	public int getDepartmentID() {
		return DepartmentID;
	}
	public void setDepartmentID(int departmentID) {
		DepartmentID = departmentID;
	}
	@Override
	public int hashCode() {
		return Objects.hash(CourseID, Credits, DepartmentID, Title);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		course other = (course) obj;
		return CourseID == other.CourseID && Credits == other.Credits && DepartmentID == other.DepartmentID
				&& Objects.equals(Title, other.Title);
	}
	
}
