package DTO;

import java.math.BigDecimal;

import java.util.Objects;

public class studentgrade {
	public int EnrollmentID   ;
	public int CourseID  ;
	public int StudentID  ;
	public BigDecimal Grade;
	
	
	public studentgrade() {
		super();
	}
	public studentgrade(int enrollmentID, int courseID, int studentID, BigDecimal grade) {
		super();
		EnrollmentID = enrollmentID;
		CourseID = courseID;
		StudentID = studentID;
		Grade = grade;
	}
	public int getEnrollmentID() {
		return EnrollmentID;
	}
	public void setEnrollmentID(int enrollmentID) {
		EnrollmentID = enrollmentID;
	}
	public int getCourseID() {
		return CourseID;
	}
	public void setCourseID(int courseID) {
		CourseID = courseID;
	}
	public int getStudentID() {
		return StudentID;
	}
	public void setStudentID(int studentID) {
		StudentID = studentID;
	}
	public BigDecimal getGrade() {
		return Grade;
	}
	public void setGrade(BigDecimal grade) {
		Grade = grade;
	}
	@Override
	public int hashCode() {
		return Objects.hash(CourseID, EnrollmentID, Grade, StudentID);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		studentgrade other = (studentgrade) obj;
		return CourseID == other.CourseID && EnrollmentID == other.EnrollmentID && Objects.equals(Grade, other.Grade)
				&& StudentID == other.StudentID;
	}
	
}
