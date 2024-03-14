package DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import DTO.onlinecourse;

public class OnlineCourseDAL {
	
	public ArrayList<onlinecourse> ListOnline(){
		ArrayList<onlinecourse> onc=new ArrayList<>();
		String sql="select * from course as c,onlinecourse as o where c.CourseID=o.CourseID";
		try {
			PreparedStatement ps = DataBaseAccess.Connect().prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while( rs.next()) {
				onlinecourse oc=new onlinecourse();
				oc.setCourseID(rs.getInt("CourseID"));
				oc.setTitle(rs.getString("Title"));
				oc.setCredits(rs.getInt("Credits"));
				oc.setDepartmentID(rs.getInt("DepartmentID"));
				oc.setUrl(rs.getString("url"));
				
				onc.add(oc);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
		}
		return onc;
		
	}
	
	public boolean InsertOnline(onlinecourse o) {
		String sqlCourse="insert into course values(?,?,?,?)";
		try {
			PreparedStatement ps = DataBaseAccess.Connect().prepareStatement(sqlCourse);
			ps.setInt(1,o.getCourseID());
			ps.setString(2, o.getTitle());
			ps.setInt(3,o.getCredits());
			ps.setInt(4, o.getDepartmentID());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sqlOnlinecourse="insert into onlinecourse values(?,?)";
		try {
			PreparedStatement ps = DataBaseAccess.Connect().prepareStatement(sqlOnlinecourse);
			ps.setInt(1,o.getCourseID());
			ps.setString(2, o.getUrl());
			return ps.executeUpdate()>0;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean UpdateOnline(onlinecourse o) {
		String sqlCourse= "UPDATE course SET Title=?, Credits=? , DepartmentID=? WHERE CourseID=?";
		try {
			PreparedStatement ps = DataBaseAccess.Connect().prepareStatement(sqlCourse);
			ps.setInt(4, o.getCourseID());
			ps.setString(1, o.getTitle());
			ps.setInt(2, o.getCredits());
			ps.setInt(3,  o.getDepartmentID());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sqlOnlinecourse= "UPDATE onlinecourse SET  url=? WHERE CourseID=?";
		try {
			PreparedStatement ps = DataBaseAccess.Connect().prepareStatement(sqlOnlinecourse);
			ps.setInt(2, o.getCourseID());
			ps.setString(1, o.getUrl());
			
			return ps.executeUpdate()>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean RemoveOnline(int CourseID) {
		String sqlCourse="delete from course where CourseID = ? ";
		String sqlOnlinecourse="delete from onlinecourse where CourseID = ? ";
		
		try {
			PreparedStatement ps = DataBaseAccess.Connect().prepareStatement(sqlCourse);
			ps.setInt(1, CourseID);
			
			PreparedStatement ps1 = DataBaseAccess.Connect().prepareStatement(sqlOnlinecourse);
			ps1.setInt(1, CourseID);
			return ps1.executeUpdate()>0 && ps.executeUpdate()>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public ArrayList<onlinecourse> SearchOnline(String Title){
		ArrayList<onlinecourse> onc=new ArrayList<>();
		String sql="select * from onlinecourse,course  where onlinecourse.CourseID=course.CourseID and course.Title like '%"+Title+"%'";
		try {
			PreparedStatement ps = DataBaseAccess.Connect().prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while( rs.next()) {
				onlinecourse oc=new onlinecourse();
				oc.setCourseID(rs.getInt("CourseID"));
				oc.setTitle(rs.getString("Title").trim());
				oc.setCredits(rs.getInt("Credits"));
				oc.setDepartmentID(rs.getInt("DepartmentID"));
				oc.setUrl(rs.getString("url"));
				
				onc.add(oc);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
		}
		return onc;
	}
	
	
	
}
