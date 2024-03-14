package DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.studentgrade;


public class StudentGradeDAL {
	
	public ArrayList<studentgrade> ListStudentGrade(){
		ArrayList<studentgrade> sdg=new ArrayList<>();
		String sql="select * from studentgrade ";
		try {
			PreparedStatement ps = DataBaseAccess.Connect().prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while( rs.next()) {
				studentgrade sg=new studentgrade();
				sg.setEnrollmentID(rs.getInt("EnrollmentID"));
				sg.setCourseID(rs.getInt("CourseID"));
				sg.setStudentID(rs.getInt("StudentID"));
				sg.setGrade(rs.getBigDecimal("Grade"));
				sdg.add(sg);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
		}
		return sdg;
		
	}
	
	
	public boolean InsertStudentGrade(studentgrade s) {
		String sql="insert into studentgrade values(?,?,?,?)";
		
		try {
			PreparedStatement ps = DataBaseAccess.Connect().prepareStatement(sql);
			ps.setInt(1, s.getEnrollmentID());
			ps.setInt(2, s.getCourseID());
			ps.setInt(3, s.getStudentID());
			ps.setBigDecimal(4, s.getGrade());
			
			return ps.executeUpdate()>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	
	public boolean UpdateStudentGrade(studentgrade s) {
		String sql="update studentgrade set CourseID=?,StudentID=?,Grade=? where EnrollmentID=?";
		
		try {
			PreparedStatement ps = DataBaseAccess.Connect().prepareStatement(sql);
			
			ps.setInt(4, s.getEnrollmentID());
			ps.setInt(1, s.getCourseID());
			ps.setInt(2, s.getStudentID());
			ps.setBigDecimal(3, s.getGrade());
			
			return ps.executeUpdate()>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
		}

	public boolean RemoveStudentGrade(int EnrollmentID) {
		String sql="delete from studentgrade where EnrollmentID = ? ";
		
		try {
			PreparedStatement ps = DataBaseAccess.Connect().prepareStatement(sql);
			ps.setInt(1, EnrollmentID);
			return ps.executeUpdate()>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	
	public ArrayList<studentgrade> SearchStudentGrade(int EnrollmentID ){
		ArrayList<studentgrade> sdg=new ArrayList<>();
		String sql="select * from studentgrade where EnrollmentID like '%"+EnrollmentID+"%'";
		try {
			PreparedStatement ps = DataBaseAccess.Connect().prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while( rs.next()) {
				studentgrade sg=new studentgrade();
				sg.setEnrollmentID(rs.getInt("EnrollmentID"));
				sg.setCourseID(rs.getInt("CourseID"));
				sg.setStudentID(rs.getInt("StudentID"));
				sg.setGrade(rs.getBigDecimal("Grade"));
				sdg.add(sg);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
		}
		return sdg;
	}
}
