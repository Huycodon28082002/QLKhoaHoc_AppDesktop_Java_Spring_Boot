package BLL;

import java.util.ArrayList;

import DAL.StudentGradeDAL;
import DTO.studentgrade;

public class StudentGradeBLL {
	
	public StudentGradeDAL studentGradeDAL=new StudentGradeDAL();
	
	public ArrayList<studentgrade> ListStudentGradeBLL(){
		return studentGradeDAL.ListStudentGrade();
	}
	
	public boolean InsertStudentGradeBLL(studentgrade s) {
		return studentGradeDAL.InsertStudentGrade(s);
	}
	
	public boolean UpdateStudentGradeBLL(studentgrade s) {
		return studentGradeDAL.UpdateStudentGrade(s);
	}
	
	public boolean RemoveStudentGradeBLL(int EnrollmentID) {
		return studentGradeDAL.RemoveStudentGrade(EnrollmentID);
	}
	
	public ArrayList<studentgrade> SearchStudentGradeBLL(int EnrollmentID ){
		return studentGradeDAL.SearchStudentGrade(EnrollmentID);
	}
}
