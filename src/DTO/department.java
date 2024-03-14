package DTO;

import java.util.Date;
import java.util.Objects;

public class department {
	public int DepartmentID  ;
	public String  Name ;
	public double Budget;
	public Date StartDate;
	public int Administrator  ;
	public int getDepartmentID() {
		return DepartmentID;
	}
	public void setDepartmentID(int departmentID) {
		DepartmentID = departmentID;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public double getBudget() {
		return Budget;
	}
	public void setBudget(double budget) {
		Budget = budget;
	}
	public Date getStartDate() {
		return StartDate;
	}
	public void setStartDate(Date startDate) {
		StartDate = startDate;
	}
	public int getAdministrator() {
		return Administrator;
	}
	public void setAdministrator(int administrator) {
		Administrator = administrator;
	}
	@Override
	public int hashCode() {
		return Objects.hash(Administrator, Budget, DepartmentID, Name, StartDate);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		department other = (department) obj;
		return Administrator == other.Administrator
				&& Double.doubleToLongBits(Budget) == Double.doubleToLongBits(other.Budget)
				&& DepartmentID == other.DepartmentID && Objects.equals(Name, other.Name)
				&& Objects.equals(StartDate, other.StartDate);
	}
	
}
