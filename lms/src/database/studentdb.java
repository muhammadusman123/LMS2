package database;
import java.sql.ResultSet;
import java.sql.SQLException;
import database.dbclass;
public class studentdb {
	String a;
	String s;
	public studentdb() {
	}
	public ResultSet queryrep() {
		dbclass obj = new dbclass();
		ResultSet rs = obj.select("SELECT * FROM `student`");
		return rs;
	}
	public ResultSet querryupdatea(String s) throws SQLException {
		dbclass obj = new dbclass();
		ResultSet rs = obj.select("SELECT * FROM `student` WHERE studentid='"
				+ s + "'");
		return rs;
	}
	public void querryupdateb(String am, String a, String b, String c,
			String d, String e, String f) {
		this.a = am;
		// frameab = frame;
		s = ("Update `student` SET `name`='" + a + "', `emailaddress`='" + b
				+ "', `dob`='" + c + "', `gender`='" + d + "', `phone`='" + e
				+ "' , `date`='" + f + "' where `studentid`='" + am + "'");
		dbclass dbclassobj = new dbclass();
		dbclassobj.insert(s);
	}
	public void querygen(String a, String b, String c, String d, String e,
			String f) {
		// framea = frame;
		// in/t a = Integer.parseInt(framea.textField_1.getText());
		s = "INSERT INTO `student`(`name`, `emailaddress`, `dob`, `gender`, `phone`,`date`) values ('"
				+ a
				+ "','"
				+ b
				+ "','"
				+ c
				+ "','"
				+ d
				+ "','"
				+ e
				+ "','"
				+ f
				+ "')";
		dbclass dbclassobj = new dbclass();
		dbclassobj.insert(s);
	}
	public void delete(String text) {
		// TODO Auto-generated method stub
		String s = "DELETE FROM `student` WHERE studentid='" + text + "'";
		dbclass obj = new dbclass();
		obj.insert(s);
	}
}
