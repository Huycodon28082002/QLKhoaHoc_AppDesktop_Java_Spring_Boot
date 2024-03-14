package BLL;

import java.util.ArrayList;


import DAL.OnsiteCourseDAL;

import DTO.onsitecourse;

public class OnsiteCourseBLL {
	private OnsiteCourseDAL onsiteCourseDAL =new OnsiteCourseDAL();
	
	public ArrayList<onsitecourse> ListOnsiteBLL(){
		return onsiteCourseDAL.ListOnsite();
	}
	
	public boolean InsertsiteneBLL(onsitecourse onsiteCourse) {
		return onsiteCourseDAL.InsertOnsite(onsiteCourse);
	}
	
	public boolean UpdateOnsiteBLL(onsitecourse onsiteCourse) {
		return onsiteCourseDAL.UpdateOnsite(onsiteCourse);
	}
	
	public boolean RemoveOnsiteBLL(int CourseID) {
		return onsiteCourseDAL.RemoveOnsite(CourseID);
	}
	
	public ArrayList<onsitecourse> SearchOnsiteBLL(String Title ){
		return onsiteCourseDAL.SearchOnsite(Title);
	}
	
}
