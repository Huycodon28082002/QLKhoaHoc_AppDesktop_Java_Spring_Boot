package DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import DTO.onsitecourse;

public class OnsiteCourseDAL {
	
	public ArrayList<onsitecourse> ListOnsite(){
		ArrayList<onsitecourse> onc=new ArrayList<>();
		String sql="select * from course as c,onsitecourse as o where c.CourseID=o.CourseID";
		try {
			PreparedStatement ps = DataBaseAccess.Connect().prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while( rs.next()) {
				onsitecourse oc=new onsitecourse();
				oc.setCourseID(rs.getInt("CourseID"));
				oc.setTitle(rs.getString("Title"));
				oc.setCredits(rs.getInt("Credits"));
				oc.setDepartmentID(rs.getInt("DepartmentID"));
				oc.setLocation(rs.getString("Location"));
				oc.setDays(rs.getString("Days"));
				oc.setTime(rs.getTime("Time"));
				
				onc.add(oc);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
		}
		return onc;
		
	}
	
	public boolean InsertOnsite(onsitecourse o) {
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
		String sqlOnsitecourse="insert into onsitecourse values(?,?,?,?)";
		try {
			PreparedStatement ps = DataBaseAccess.Connect().prepareStatement(sqlOnsitecourse);
			ps.setInt(1,o.getCourseID());
			ps.setString(2,o.getLocation());
			ps.setString(3, o.getDays());
			ps.setTime(4, o.getTime());
			return ps.executeUpdate()>0;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean UpdateOnsite(onsitecourse o) {
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
		String sqlOnsitecourse= "UPDATE onsitecourse SET  Location=? , Days=?  , Time=? WHERE CourseID=?";
		try {
			PreparedStatement ps = DataBaseAccess.Connect().prepareStatement(sqlOnsitecourse);
			ps.setString(1,o.getLocation());
			ps.setString(2, o.getDays());
			ps.setTime(3, o.getTime());
			ps.setInt(4, o.getCourseID());
			return ps.executeUpdate()>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean RemoveOnsite(int CourseID) {
		String sqlCourse="delete from course where CourseID = ? ";
		String sqlOnsitecourse="delete from onsitecourse where CourseID = ? ";
		
		try {
			PreparedStatement ps = DataBaseAccess.Connect().prepareStatement(sqlCourse);
			ps.setInt(1, CourseID);
			
			PreparedStatement ps1 = DataBaseAccess.Connect().prepareStatement(sqlOnsitecourse);
			ps1.setInt(1, CourseID);
			return ps1.executeUpdate()>0 && ps.executeUpdate()>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}
	
	public ArrayList<onsitecourse> SearchOnsite(String Title ){
		ArrayList<onsitecourse> onc=new ArrayList<>();
		String sql="select * from onsitecourse,course  where onsitecourse.CourseID=course.CourseID and course.Title like '%"+Title+"%'";
		try {
			PreparedStatement ps = DataBaseAccess.Connect().prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while( rs.next()) {
				onsitecourse oc=new onsitecourse();
				oc.setCourseID(rs.getInt("CourseID"));
				oc.setTitle(rs.getString("Title"));
				oc.setCredits(rs.getInt("Credits"));
				oc.setDepartmentID(rs.getInt("DepartmentID"));
				oc.setLocation(rs.getString("Location"));
				oc.setDays(rs.getString("Days"));
				oc.setTime(rs.getTime("Time"));
				
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
