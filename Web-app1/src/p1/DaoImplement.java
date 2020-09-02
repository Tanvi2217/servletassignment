package p1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoImplement{
	private int code;
	DaoUtil obj = new DaoUtil();
	Connection con; // holds connection in between java & database
	PreparedStatement ps; // executes SQL queries
	public DaoImplement()  {
		try {
			con = obj.getdbconnect();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<String> validate() throws SQLException  {
		// TODO Auto-generated method stub
		String uname = null;
		String pswd = null;
		ArrayList<String> list1 = new ArrayList<String>();
		String selectquery = "select name,pwd from usercourse";
		ps = con.prepareStatement(selectquery);
		
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			uname = rs.getString("name");
			 pswd = rs.getString("pwd");
			list1.add(uname);
			list1.add(pswd);
			//System.out.println(list1);
			
		
		}
		return list1;
		
		}
	
	public ArrayList<String> courseselect(String nm) throws SQLException{
		String query = "select instructorcode from usercourse where name = ?";
		ps = con.prepareStatement(query);
		ps.setString(1,nm);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			code = rs.getInt("instructorcode");
		}
		ArrayList<String> list2 = new ArrayList<String>();
		String selectquery = "select * from instructorcourseinfo where instructorcode = ?";
		ps = con.prepareStatement(selectquery);
		ps.setInt(3, code);
		while(rs.next()) {
			String cname = rs.getString("COURSENAME");
			
			list2.add(cname);
			
		}
		return list2;
		
	}
}
