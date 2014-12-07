package algo;
import gui.Payroll.Display1;
import gui.Payroll.payroll_insertion;
import gui.Payroll.payroll_salary2;
import gui.Payroll.payroll_update2;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;
import database.dbclass;
import database.payroll_dbclass;
public class payroll_algo {
	public void Insert(String emp_name, String post, String date_of_joining) {
		String msg;
		float rate_per_day = 0, rate_per_overtime_hour = 0;
		if (post == "Librarian") {
			rate_per_day = 700;
			rate_per_overtime_hour = 70;
		} else if (post == "Assistant_Librarian") {
			rate_per_day = 630;
			rate_per_overtime_hour = 63;
		} else if (post == "Manager") {
			rate_per_day = 640;
			rate_per_overtime_hour = 64;
		} else if (post == "Assistant_Manager") {
			rate_per_day = 550;
			rate_per_overtime_hour = 50;
		} else if (post == "Library_Technician") {
			rate_per_day = 400;
			rate_per_overtime_hour = 35;
		} else if (post == "Intern") {
			rate_per_day = 250;
			rate_per_overtime_hour = 20;
		} else if (post == "Peon") {
			rate_per_day = 300;
			rate_per_overtime_hour = 30;
		}
		if (emp_name.isEmpty()) {
			msg = "Name field is empty";
			Display1 d_obj = new Display1(msg, 0);
			d_obj.setVisible(true);
		} else if (date_of_joining.isEmpty()) {
			msg = "Date of joining field is empty";
			Display1 d_obj = new Display1(msg, 0);
			d_obj.setVisible(true);
		} else {
			msg = "Employee is successfully added";
			Display1 d_obj = new Display1(msg, 1);
			d_obj.setVisible(true);
			payroll_dbclass p_db_obj = new payroll_dbclass();
			p_db_obj.Insert(emp_name, post, date_of_joining, rate_per_day,
					rate_per_overtime_hour);
		}
	}
	public ResultSet update_field(int id) throws SQLException {
		payroll_dbclass obj = new payroll_dbclass();
		ResultSet rs = obj.update_field(id);
		return rs;
	}
	public void Update(int emp_id, String emp_name, String post, int days,
			float hours, float rate_per_day, float rate_per_overtime_hour,
			float salary, String date_of_joining) {
		String msg;
		salary = (days * rate_per_day) + (hours * rate_per_overtime_hour);
		payroll_dbclass obj = new payroll_dbclass();
		obj.Update(emp_id, emp_name, post, days, hours, rate_per_day,
				rate_per_overtime_hour, salary, date_of_joining);
		msg = "Employee data updated successfully"; // //////////////
		Display1 d_obj = new Display1(msg, 1);
		d_obj.setVisible(true);
	}
	public ResultSet Report() throws SQLException {
		payroll_dbclass obj = new payroll_dbclass();
		ResultSet rs = obj.Report();
		return rs;
	}
	public void set_textfields_2(payroll_update2 obj, int id)
			throws SQLException {
		ResultSet rs;
		payroll_algo alg = new payroll_algo();
		rs = alg.update_field(id);
		while (rs.next()) {
			obj.textField.setText(rs.getString("Employee_name"));
			obj.post = rs.getString("Post");
			obj.days = rs.getInt("Days");
			obj.hours = rs.getFloat("Overtime_hours");
			obj.dayrate = rs.getFloat("Rate_per_day");
			obj.hourrate = rs.getFloat("Rate_per_overtime_hour");
			obj.salary = rs.getInt("Salary");
			obj.date = rs.getString("Date_of_Joining");
		}
	}
	public void set_labels(payroll_salary2 obj, int id) throws SQLException {
		String c;
		ResultSet rs;
		payroll_algo alg = new payroll_algo();
		rs = alg.update_field(id);
		while (rs.next()) {
			obj.days = rs.getInt("Days");
			obj.hours = rs.getFloat("Overtime_hours");
			obj.dayrate = rs.getFloat("Rate_per_day");
			obj.hourrate = rs.getFloat("Rate_per_overtime_hour");
			obj.date = rs.getString("Date_of_Joining");
			obj.labelid.setText(Integer.toString(id));
			obj.labelname.setText(rs.getString("Employee_name"));
			obj.labelpost.setText(rs.getString("Post"));
			obj.labeldays.setText(Integer.toString(obj.days));
			obj.labelhours.setText(Float.toString(obj.hours));
			;
			obj.labeldayrate.setText(Float.toString(obj.dayrate));
			obj.labelhourrate.setText(Float.toString(obj.hourrate));
			// salary=(days*dayrate)+(hours*hourrate);
			obj.labelsalary.setText(Float.toString(rs.getFloat("Salary")));
		}
	}
	public void Delete(String s_id, String name) throws SQLException {
		int id;
		boolean flag, flag2;
		String msg;
		if (s_id.isEmpty()) {
			msg = "Employee id field is empty";
			Display1 d_obj = new Display1(msg, 0);
			d_obj.setVisible(true);
		} else if (name.isEmpty()) {
			msg = "Name field is empty";
			Display1 d_obj = new Display1(msg, 0);
			d_obj.setVisible(true);
		} else {
			id = Integer.parseInt(s_id);
			flag = Search(id);
			if (flag == true) {
				flag2 = Search_name(id, name);
				if (flag2 == true) {
					msg = "Employee is successfully deleted";
					Display1 d_obj = new Display1(msg, 1);
					d_obj.setVisible(true);
					payroll_dbclass p_db_obj = new payroll_dbclass();
					p_db_obj.Delete(id, name);
				} else {
					msg = "Employee id and name mismatched";
					Display1 d_obj = new Display1(msg, 0);
					d_obj.setVisible(true);
				}
			} else {
				msg = "Employee id not found ";
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
			id2 = rs.getInt("Employee_id");
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
			id2 = rs.getInt("Employee_id");
			if (id == id2) {
				break;
			} else {
			}
		}
		name2 = rs.getString("Employee_name");
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
