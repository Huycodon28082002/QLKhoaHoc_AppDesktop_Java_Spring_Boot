package DTO;

import java.util.Objects;

public class onlinecourse extends course{
	public String  url ;
	
	public onlinecourse() {
		super();
	}

	public onlinecourse(int courseID, String title, int credits, int departmentID,String url ) {
		super();
		CourseID = courseID;
		Title = title;
		Credits = credits;
		DepartmentID = departmentID;
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(url);
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
		onlinecourse other = (onlinecourse) obj;
		return Objects.equals(url, other.url);
	}
	
	
}