package algo;
import gui.Budget.Inset_Salary_budget;
import gui.Budget.Update_Salary_Budget;
import java.sql.ResultSet;
import java.sql.SQLException;
import database.dbclass;
public class Salary_budget {
	public void Insert_frame(int s, Inset_Salary_budget framea) {
		database.dbclass naveed123 = new database.dbclass();// passing variable
		String ss = "INSERT INTO salary_budget(ID,Semester_Type,Issue_Date,Allocated,Spent,Current_Balance,Total_of_Salaries)      VALUES ('"
				+ framea.id
				+ "','"
				+ framea.type
				+ "','"
				+ framea.s
				+ "','"
				+ framea.amount + "','" + 0 + "','" + 0 + "','" + 0 + "')";
		try {
			naveed123.insert(ss);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ResultSet select() throws SQLException {
		dbclass obj = new dbclass();
		ResultSet rs = obj.select("SELECT * FROM `salary_budget`");
		return rs;
	}
	public ResultSet selects() {
		database.dbclass naveed123 = new database.dbclass();// passing variable
		String ss = "Select * from salary_budget";
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
	public void Update(int s, Update_Salary_Budget framea)// //change
	{
		database.dbclass naveed123 = new database.dbclass();// passing variable
		// System.out.println("algo started");
		// String ss =
		// ("UPDATE `salary_budget` SET `Issue_Date`='"+framea.s+"',`Allocated`='"+framea.amount+"' WHERE `ID`='"+framea.id+"'");
		String ss = ("UPDATE `salary_budget` SET `Semester_Type`='" + ""
				+ "',`Issue_Date`='" + framea.s + "',`Allocated`='"
				+ framea.amount + "',`Spent`='" + 0 + "',`Current_Balance`='"
				+ 0 + "',`Total_of_Salaries`='" + 0 + "' WHERE `ID`='"
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
		ResultSet rs = obj.select("SELECT * FROM `salary_budget` WHERE ID='"
				+ s + "'");
		System.out.println("querycompleted");
		return rs;
	}
}
