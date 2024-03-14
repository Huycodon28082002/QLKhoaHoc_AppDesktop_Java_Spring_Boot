package DTO;

import java.util.Date;
import java.util.Objects;

public class person {
	public int PersonID  ;
	public String Lastname ;
	public String Firstname ;
	public Date HireDate;
	public Date EnrollmentDate;
	public int getPersonID() {
		return PersonID;
	}
	public void setPersonID(int personID) {
		PersonID = personID;
	}
	public String getLastname() {
		return Lastname;
	}
	public void setLastname(String lastname) {
		Lastname = lastname;
	}
	public String getFirstname() {
		return Firstname;
	}
	public void setFirstname(String firstname) {
		Firstname = firstname;
	}
	public Date getHireDate() {
		return HireDate;
	}
	public void setHireDate(Date hireDate) {
		HireDate = hireDate;
	}
	public Date getEnrollmentDate() {
		return EnrollmentDate;
	}
	public void setEnrollmentDate(Date enrollmentDate) {
		EnrollmentDate = enrollmentDate;
	}
	@Override
	public int hashCode() {
		return Objects.hash(EnrollmentDate, Firstname, HireDate, Lastname, PersonID);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		person other = (person) obj;
		return Objects.equals(EnrollmentDate, other.EnrollmentDate) && Objects.equals(Firstname, other.Firstname)
				&& Objects.equals(HireDate, other.HireDate) && Objects.equals(Lastname, other.Lastname)
				&& PersonID == other.PersonID;
	}
	
}
