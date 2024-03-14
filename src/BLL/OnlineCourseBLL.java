package BLL;

import java.util.ArrayList;

import DAL.OnlineCourseDAL;
import DTO.onlinecourse;

public class OnlineCourseBLL {
	private OnlineCourseDAL onlineCourseDAL= new OnlineCourseDAL();
	
	public ArrayList<onlinecourse> ListOnlineBLL(){
		return onlineCourseDAL.ListOnline();
	}
	
	public boolean InsertOnlineBLL(onlinecourse onlineCourse) {
		return onlineCourseDAL.InsertOnline(onlineCourse);
	}
	
	public boolean UpdateOnlineBLL(onlinecourse onlineCourse) {
		return onlineCourseDAL.UpdateOnline(onlineCourse);
	}
	
	public boolean RemoveOnlineBLL(int CourseID) {
		return onlineCourseDAL.RemoveOnline(CourseID);
	}
	
	public ArrayList<onlinecourse> SearchOnlineBLL(String Title  ){
		return onlineCourseDAL.SearchOnline(Title);
	}
	
}
