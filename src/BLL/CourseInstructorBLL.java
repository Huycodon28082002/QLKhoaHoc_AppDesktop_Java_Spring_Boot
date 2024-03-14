package BLL;

import java.util.ArrayList;

import DAL.CourseInstructorDAL;
import DTO.courseinstructor;

public class CourseInstructorBLL {
	private CourseInstructorDAL courseInstructorDAL=new CourseInstructorDAL();
	
	public ArrayList<courseinstructor> ListCourseInstructorBLL(){
		return courseInstructorDAL.ListCourseInstructor();
	}
	
	public boolean InsertCourseInstructorBLL(courseinstructor c) {
		return courseInstructorDAL.InsertCourseInstructor(c);
	}
	
	public boolean UpdateCourseInstructorBLL(courseinstructor c) {
		return courseInstructorDAL.UpdateCourseInstructor(c);
	}
	
	public boolean RemoveCourseInstructorBLL(int CourseID) {
		return courseInstructorDAL.RemoveCourseInstructor(CourseID);
	}
	
	public ArrayList<courseinstructor> SearchCourseInstructorBLL(String Title){
		return courseInstructorDAL.SearchCourseInstructor(Title);
	}

}
