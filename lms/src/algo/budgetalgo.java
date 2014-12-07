package algo;
import gui.Budget.Budget_database;
import gui.Budget.budgetinsertion;
import gui.Budget.budgetupdate2;
import java.sql.ResultSet;
import java.sql.SQLException;
import database.dbclass;
public class budgetalgo {
	public static double y11;
	public static double y12;
	public static double y13;
	// public static void main(String[] args) {
	// Exponential_smoothing();
	// }
	public void Insert_frame(int s, budgetinsertion framea) {
		/*
		 * database.dbclass naveed123=new database.dbclass();//passing variable
		 * String ss =
		 * "INSERT INTO budget(Issue_Date,CS,EE,BBA,HR)      VALUES ('"
		 * +framea.s+
		 * "','"+framea.CS+"','"+framea.EE+"','"+framea.BBA+"','"+framea
		 * .HR+"')"; try { naveed123.insert(ss); } catch (Exception e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
		Budget_database budget = new Budget_database();
		budget.Insert_frame(s, framea);
		// int total2;
		// String total=framea.CS;
		// total2= Integer.parseInt(total);
		// int cs,bba,hr,ee;
		// cs=(total2/50)*100;
		// bba=(total2/30)*100;
		// hr=(total2/10)*100;
		// ee=(total2/10)*100;
	}
	public double exp_algo(int year1, int year2, int year3) {
		int y1 = 100;
		int y2 = 200;
		int y3 = 300;
		double F1 = 100;
		double F2;
		double F3;
		double F = 0;
		double alpha = 0.3;
		F2 = F1 + alpha * (y1 - F1);
		System.out.println(F2);
		return F;
	}
	public ResultSet select() throws SQLException {
		/*
		 * dbclass obj=new dbclass(); ResultSet rs =
		 * obj.select("SELECT * FROM `budget`");
		 * 
		 * 
		 * return rs;
		 */
		Budget_database budget = new Budget_database();
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
		Budget_database budget = new Budget_database();
		ResultSet rs = budget.selects();
		return rs;
	}
	public void Update(int s, budgetupdate2 framea) {
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
		Budget_database budget = new Budget_database();
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
		Budget_database budget = new Budget_database();
		ResultSet rs = budget.querryupdatea(s);
		return rs;
	}
	public static double Exponential_smoothing() {
		String y1;
		String y2;
		String y3;
		ResultSet rs = null;
		Budget_database alg = new Budget_database();
		try {
			System.out.println(rs = alg.get_year1());
			//
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			while (rs.next()) {
				y3 = rs.getString("Issued_Amount");
				System.out.println(y3);
				y13 = Integer.parseInt(y3);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ResultSet rs2 = null;
		Budget_database algo = new Budget_database();
		try {
			System.out.println(rs2 = algo.get_year2());
			//
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			while (rs2.next()) {
				y2 = rs2.getString("Issued_Amount");
				System.out.println(y2);
				y12 = Integer.parseInt(y2);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ResultSet rs3 = null;
		Budget_database algoo = new Budget_database();
		try {
			System.out.println(rs3 = algoo.get_year3());
			//
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			while (rs3.next()) {
				y1 = rs3.getString("Issued_Amount");
				System.out.println(y1);
				y11 = Integer.parseInt(y1);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// try {
		// y1=rs.getString("Issued_Amount");
		// System.out.println(rs.getString("Issued_Amount"));
		// } catch (SQLException e) {
		// TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		System.out.println(y11);
		double F = 0;
		double F1 = y11;
		double F2 = 0;
		double F3;
		double F4;
		double alpha = 0.877;
		F2 = F1 + alpha * (y11 - F1);
		System.out.println(F2);
		F3 = F2 + alpha * (y12 - F2);
		System.out.println(F3);
		F4 = F3 + alpha * (y13 - F3);
		System.out.println(F4);
		return F4;
	}
}