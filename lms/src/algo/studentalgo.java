package algo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;
import gui.Authentication.Display;
import gui.student.studentupdate1;
import gui.student.studentupdate2;
import database.dbclass;
import database.studentdb;
public class studentalgo {
	String a;
	String s;
	public studentalgo() {
	}
	public Locale getLocale(String loc) {
		if (loc != null && loc.length() > 0) {
			return new Locale(loc);
		} else {
			return Locale.US;
		}
	}
	public void set(studentupdate2 obj, String id) throws SQLException {
		String c;
		System.out.println(id + "this is passed student id");
		ResultSet rs;
		algo.studentalgo alg = new algo.studentalgo();
		rs = alg.querryupdatea(id);
		while (rs.next()) {
			obj.textField.setText(rs.getString("name"));
			obj.textField_1.setText(rs.getString("emailaddress"));
			obj.textField_2.setText(rs.getString("dob"));
			obj.comboBox.setSelectedItem(rs.getString("gender"));
			obj.textField_4.setText(rs.getString("phone"));
			obj.textField_5.setText(rs.getString("date"));
		}
	}
	public ResultSet queryrep() {
		studentdb obj = new studentdb();
		ResultSet rs = obj.queryrep();
		return rs;
	}
	public ResultSet querryupdatea(String s) throws SQLException {
		studentdb obj = new studentdb();
		ResultSet rs = obj.querryupdatea(s);
		return rs;
	}
	public void querryupdateb(String s, String a, String b, String c, String d,
			String e, String f) {
		studentdb obj = new studentdb();
		obj.querryupdateb(s, a, b, c, d, e, f);
	}
	public void querygen(String a, String b, String c, String d, String e,
			String f) throws SQLException {
		studentdb dbclassobj = new studentdb();
		dbclassobj.querygen(a, b, c, d, e, f);
	}
	public void delete(String text) throws SQLException {
		// TODO Auto-generated method stub
		studentdb obj = new studentdb();
		ResultSet usman = obj.querryupdatea(text);
		Display disp = new Display("Record has been Successfully Deleted");
		disp.setVisible(true);
		obj.delete(text);
	}
}
