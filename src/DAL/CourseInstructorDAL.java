package DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.courseinstructor;



public class CourseInstructorDAL {
	public ArrayList<courseinstructor> ListCourseInstructor(){
		ArrayList<courseinstructor> ci=new ArrayList<>();
		String sql="select * from courseinstructor,course,person "
				+ "where courseinstructor.CourseID=course.CourseID and person.PersonID=courseinstructor.PersonID ";
		try {
			PreparedStatement ps = DataBaseAccess.Connect().prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while( rs.next()) {
				courseinstructor c=new courseinstructor();
				c.setCourseID(rs.getInt("courseinstructor.CourseID"));
				c.setTitle(rs.getString("course.Title"));
				c.setPersonID(rs.getInt("courseinstructor.PersonID"));
				c.setFirstName(rs.getString("person.Firstname"));
				c.setLastName(rs.getString("person.Lastname"));
				ci.add(c);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
		}
		return ci;
		
	}
	
	public boolean InsertCourseInstructor(courseinstructor c) {
		String sql="insert into courseinstructor values(?,?)";
		
		try {
			PreparedStatement ps = DataBaseAccess.Connect().prepareStatement(sql);
			ps.setInt(1,c.getCourseID());
			ps.setInt(2,c.getPersonID());
			
			return ps.executeUpdate()>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	
	public boolean UpdateCourseInstructor(courseinstructor c) {
		String sql="update courseinstructor set PersonID=? where CourseID=?";
		
		try {
			PreparedStatement ps = DataBaseAccess.Connect().prepareStatement(sql);
			ps.setInt(2,c.getCourseID());
			ps.setInt(1,c.getPersonID());
			
			return ps.executeUpdate()>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
		
	}
	
	public boolean RemoveCourseInstructor(int CourseID) {
		String sql="delete from courseinstructor where CourseID = ? ";
		
		try {
			PreparedStatement ps = DataBaseAccess.Connect().prepareStatement(sql);
			ps.setInt(1, CourseID);
			return ps.executeUpdate()>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	
	public ArrayList<courseinstructor> SearchCourseInstructor(String Title){
		ArrayList<courseinstructor> ci=new ArrayList<>();
		String sql="select * from courseinstructor,course,person "
				+ "where courseinstructor.CourseID=course.CourseID and person.PersonID=courseinstructor.PersonID and Title like '%"+Title+"%' ";
		try {
			PreparedStatement ps = DataBaseAccess.Connect().prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while( rs.next()) {
				courseinstructor c=new courseinstructor();
				c.setCourseID(rs.getInt("courseinstructor.CourseID"));
				c.setTitle(rs.getString("course.Title"));
				c.setPersonID(rs.getInt("courseinstructor.PersonID"));
				c.setFirstName(rs.getString("person.Firstname"));
				c.setLastName(rs.getString("person.Lastname"));
				
				ci.add(c);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
		}
		return ci;
		
	}
	
}
