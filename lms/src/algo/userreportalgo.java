package algo;
import gui.Payroll.Display1;
import gui.UserReport.userreportupdate2;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import database.dbclass;
import database.payroll_dbclass;
import database.userreport_dbclass;
public class userreportalgo {
	public void Insert(String st_name, String book_1, String book_2,
			String from_date, String to_date) {
		String msg;
		if (st_name.isEmpty()) {
			msg = "Student name field is empty.";
			Display1 d_obj = new Display1(msg, 0);
			d_obj.setVisible(true);
		} else if (book_1.isEmpty()) {
			msg = "Book 1 field is empty.";
			Display1 d_obj = new Display1(msg, 0);
			d_obj.setVisible(true);
		} else if (book_2.isEmpty()) {
			msg = "Book 2 field is empty.";
			Display1 d_obj = new Display1(msg, 0);
			d_obj.setVisible(true);
		} else if (from_date.isEmpty()) {
			msg = "From Date field is empty.";
			Display1 d_obj = new Display1(msg, 0);
			d_obj.setVisible(true);
		} else if (to_date.isEmpty()) {
			msg = "To Date field is empty.";
			Display1 d_obj = new Display1(msg, 0);
			d_obj.setVisible(true);
		} else {
			userreport_dbclass obj = new userreport_dbclass();
			obj.Insert(st_name, book_1, book_2, from_date, to_date);
			msg = "Student has been added succesfully.";
			Display1 d_obj = new Display1(msg, 1);
			d_obj.setVisible(true);
		}
	}
	public void Update(int st_id, String st_name, String book_1, String book_2,
			int count, String from_date, String to_date) {
		userreport_dbclass obj = new userreport_dbclass();
		obj.Update(st_id, st_name, book_1, book_2, count, from_date, to_date);
		String msg = "Student data updated successfully"; // //////////////
		Display1 d_obj = new Display1(msg, 1);
		d_obj.setVisible(true);
	}
	public ResultSet Report() throws SQLException {
		userreport_dbclass obj = new userreport_dbclass();
		ResultSet rs = obj.Report();
		return rs;
	}
	public ResultSet update_field(int id) throws SQLException {
		userreport_dbclass obj = new userreport_dbclass();
		ResultSet rs = obj.update_field(id);
		return rs;
	}
	public void set_textfields_1(userreportupdate2 obj, int id)
			throws SQLException // for user report updation
	{
		String c;
		ResultSet rs;
		userreportalgo alg = new userreportalgo();
		rs = alg.update_field(id);
		while (rs.next()) {
			obj.textField.setText(rs.getString("Student_name"));
			obj.textField_1.setText(rs.getString("Book_1"));
			obj.textField_2.setText(rs.getString("Book_2"));
			obj.textField_4.setText(rs.getString("From_Date"));
			obj.textField_5.setText(rs.getString("To_Date"));
		}
	}
	public void Delete(String s_id, String name) throws SQLException {
		int id;
		boolean flag, flag2;
		String msg;
		if (s_id.isEmpty()) {
			msg = "Student id field is empty";
			Display1 d_obj = new Display1(msg, 0);
			d_obj.setVisible(true);
		} else if (name.isEmpty()) {
			msg = "Student name field is empty";
			Display1 d_obj = new Display1(msg, 0);
			d_obj.setVisible(true);
		} else {
			id = Integer.parseInt(s_id);
			flag = Search(id);
			if (flag == true) {
				flag2 = Search_name(id, name);
				if (flag2 == true) {
					msg = "Student has been successfully deleted";
					Display1 d_obj = new Display1(msg, 1);
					d_obj.setVisible(true);
					userreport_dbclass obj = new userreport_dbclass();
					obj.Delete(id, name);
				} else {
					msg = "Student id and name mismatched";
					Display1 d_obj = new Display1(msg, 0);
					d_obj.setVisible(true);
				}
			} else {
				msg = "Student id not found ";
				Display1 d_obj = new Display1(msg, 0);
				d_obj.setVisible(true);
			}
		}
	}
	public Locale getLocale(String loc) {
		if (loc != null && loc.length() > 0) {
			return new Locale(loc);
		} else {
			return Locale.US;
		}
	}
	public boolean Search(int id) throws SQLException {
		int id2;
		boolean flag = false;
		ResultSet rs = Report();
		while (rs.next()) {
			id2 = rs.getInt("Student_id");
			if (id == id2) {
				flag = true;
				break;
			} else {
				flag = false;
			}
		}
		return flag;
	}
	public boolean Search_name(int id, String name) throws SQLException {
		int id2;
		String name2;
		boolean flag = false;
		ResultSet rs = Report();
		while (rs.next()) {
			id2 = rs.getInt("Student_id");
			if (id == id2) {
				break;
			} else {
			}
		}
		name2 = rs.getString("Student_name");
		if (name.matches(name2)) {
			flag = true;
		} else {
			flag = false;
		}
		return flag;
	}
	public boolean[] is_id_field_empty(String s_id, boolean[] flag)
			throws SQLException {
		int id;
		if (s_id.isEmpty()) {
			flag[0] = true;
		} else {
			flag[0] = false;
			id = Integer.parseInt(s_id);
			flag[1] = Search(id);
		}
		return flag;
	}
}
