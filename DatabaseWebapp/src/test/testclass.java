package test;
import java.sql.SQLException;
import java.util.ArrayList;
import p1.DaoImplement;
import p1.DaoInteraface;

public class testclass {
	public static void main(String args[]) throws ClassNotFoundException, SQLException {
		DaoImplement obj1 = new DaoImplement();
		ArrayList <String> list2 = new ArrayList<String>();
		list2 = obj1.validate();
		for (String i : list2) {
			System.out.println(i);
		}
	}

}
