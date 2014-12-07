package gui.Budget;
import java.sql.ResultSet;
import java.sql.SQLException;
import database.dbclass;
public class Budget_database {
	public void Insert_frame(int s, budgetinsertion framea) {
		database.dbclass naveed123 = new database.dbclass();// passing variable
		String ss = "INSERT INTO budget(ID,Issue_Date,Aspected_Amount,Requested_Amount,Issued_Amount,Semester_Type,CS,EE,BBA,HR)      VALUES ('"
				+ framea.id
				+ "','"
				+ framea.s
				+ "','"
				+ framea.asp
				+ "','"
				+ framea.req
				+ "','"
				+ framea.issue
				+ "','"
				+ framea.type
				+ "','"
				+ framea.CS
				+ "','"
				+ framea.EE
				+ "','"
				+ framea.BBA
				+ "','" + framea.HR + "')";
		// String ss = "DELETE FROM `budget` WHERE ID = 2";
		try {
			naveed123.insert(ss);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ResultSet select() throws SQLException {
		dbclass obj = new dbclass();
		ResultSet rs = obj.select("SELECT * FROM `budget`");
		return rs;
	}
	public ResultSet selects() {
		database.dbclass naveed123 = new database.dbclass();// passing variable
		String ss = "Select * from budget";
		ResultSet rs = null;
		try {
			rs = naveed123.select(ss);
			return rs;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	public void Update(int s, budgetupdate2 framea) {
		database.dbclass naveed123 = new database.dbclass();// passing variable
		// System.out.println("algo started");
		String ss = ("UPDATE `budget` SET `Issue_Date`='" + framea.s
				+ "',`Aspected_Amount`='" + framea.asp
				+ "',`Requested_Amount`='" + framea.req + "',`Issued_Amount`='"
				+ framea.issue + "',`Semester_Type`='" + framea.type
				+ "',`CS`='" + framea.CS + "',`EE`='" + framea.EE + "',`BBA`='"
				+ framea.BBA + "',`HR`='" + framea.HR + "' WHERE `ID`='"
				+ framea.id + "'");
		// System.out.println(framea.a);
		try {
			naveed123.insert(ss);
			// System.out.println("algo ended");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ResultSet querryupdatea(String s) throws SQLException {
		dbclass obj = new dbclass();
		System.out.println("query started");
		ResultSet rs = obj
				.select("SELECT * FROM `budget` WHERE ID='" + s + "'");
		System.out.println("querycompleted");
		return rs;
	}
	public ResultSet get_year1() throws SQLException {
		dbclass obj = new dbclass();
		System.out.println("query started");
		ResultSet rs = obj
				.select("SELECT Issued_Amount FROM `budget` WHERE ID=(SELECT MAX(ID) From `budget`)");
		System.out.println("querycompleted");
		return rs;
	}
	public ResultSet get_year2() throws SQLException {
		dbclass obj = new dbclass();
		System.out.println("query started");
		ResultSet rs = obj
				.select("SELECT Issued_Amount FROM `budget` WHERE ID=(SELECT (MAX(ID)-1) From `budget`)");
		System.out.println("querycompleted");
		return rs;
	}
	public ResultSet get_year3() throws SQLException {
		dbclass obj = new dbclass();
		System.out.println("query started");
		ResultSet rs = obj
				.select("SELECT Issued_Amount FROM `budget` WHERE ID=(SELECT (MAX(ID)-2) From `budget`)");
		System.out.println("querycompleted");
		return rs;
	}
}
