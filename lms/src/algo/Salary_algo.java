package algo;
import gui.Budget.Inset_Salary_budget;
import gui.Budget.Update_Salary_Budget;
import java.sql.ResultSet;
import java.sql.SQLException;
import database.dbclass;
public class Salary_algo {
	public void Insert_frame(int s, Inset_Salary_budget framea) {
		/*
		 * database.dbclass naveed123=new database.dbclass();//passing variable
		 * String ss =
		 * "INSERT INTO budget(Issue_Date,CS,EE,BBA,HR)      VALUES ('"
		 * +framea.s+
		 * "','"+framea.CS+"','"+framea.EE+"','"+framea.BBA+"','"+framea
		 * .HR+"')"; try { naveed123.insert(ss); } catch (Exception e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
		Salary_budget budget = new Salary_budget();
		budget.Insert_frame(s, framea);
	}
	public ResultSet select() throws SQLException {
		/*
		 * dbclass obj=new dbclass(); ResultSet rs =
		 * obj.select("SELECT * FROM `budget`");
		 * 
		 * 
		 * return rs;
		 */
		Salary_budget budget = new Salary_budget();
		ResultSet rs = budget.select();
		return rs;
	}
	public ResultSet selects() {
		/*
		 * database.dbclass naveed123=new database.dbclass();//passing variable
		 * String ss = "Select * from budget"; ResultSet rs=null;
		 * 
		 * try { rs=naveed123.select(ss); return rs; } catch (Exception e) { //
		 * TODO Auto-generated catch block e.printStackTrace(); }
		 */
		Salary_budget budget = new Salary_budget();
		ResultSet rs = budget.selects();
		return rs;
	}
	public void Update(int s, Update_Salary_Budget framea)// /////change
	{
		/*
		 * database.dbclass naveed123=new database.dbclass();//passing variable
		 * //System.out.println("algo started"); String ss =
		 * ("UPDATE `budget` SET `Issue_Date`='"
		 * +framea.s+"',`CS`='"+framea.CS+"',`EE`='"
		 * +framea.EE+"',`BBA`='"+framea
		 * .BBA+"',`HR`='"+framea.HR+"' WHERE `ID`='"+framea.id+"'");
		 * //System.out.println(framea.a);
		 * 
		 * 
		 * 
		 * 
		 * try { naveed123.insert(ss); // System.out.println("algo ended"); }
		 * catch (Exception e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
		Salary_budget budget = new Salary_budget();
		budget.Update(s, framea);
	}
	public ResultSet querryupdatea(String s) throws SQLException {
		/*
		 * dbclass obj=new dbclass(); System.out.println("query started");
		 * ResultSet rs = obj.select("SELECT * FROM `budget` WHERE ID='"+s+"'");
		 * 
		 * 
		 * System.out.println("querycompleted");
		 */
		Salary_budget budget = new Salary_budget();
		ResultSet rs = budget.querryupdatea(s);
		return rs;
	}
}
