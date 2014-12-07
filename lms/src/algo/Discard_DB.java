package algo;
import java.sql.ResultSet;
import java.sql.SQLException;
import database.dbclass;
import discard.Insert_Discard;
import discard.Update_Discard;
public class Discard_DB {
	public void Delete_frame(int s, Insert_Discard framea) {
		database.dbclass naveed123 = new database.dbclass();// passing variable
		String ss = "DELETE FROM `book1` WHERE ISBN = '" + framea.ISBN + "'";
		try {
			naveed123.insert(ss);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void Insert_frame(int s, Insert_Discard framea) {
		database.dbclass naveed123 = new database.dbclass();// passing variable
		String ss = "INSERT INTO discard_book(IISBN,Discard_Date,Author_Name,Book_Title,Edition,Price,Purchase_Date,Copy_No,Reason)      VALUES ('"
				+ framea.ISBN
				+ "','"
				+ framea.datee
				+ "','"
				+ framea.name
				+ "','"
				+ framea.datee
				+ "','"
				+ framea.book
				+ "','"
				+ framea.edit
				+ "','"
				+ framea.price
				+ "','"
				+ framea.date
				+ "','" + framea.reason + "')";
		try {
			naveed123.insert(ss);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void update(int s, Update_Discard framea) {
		database.dbclass naveed123 = new database.dbclass();// passing variable
		String ss = "INSERT INTO book1(IISBN,Author_Name,Book_Title,Edition,Price,Purchase_Date)      VALUES ('"
				+ framea.ISBN
				+ "','"
				+ framea.name
				+ "','"
				+ framea.datee
				+ "','"
				+ framea.book
				+ "','"
				+ framea.edit
				+ "','"
				+ framea.price + "','" + framea.date + "')";
		try {
			naveed123.insert(ss);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ResultSet select() throws SQLException {
		dbclass obj = new dbclass();
		ResultSet rs = obj.select("SELECT * FROM `discard_book`");
		return rs;
	}
	public ResultSet selects() {
		database.dbclass naveed123 = new database.dbclass();// passing variable
		String ss = "Select * from discard_book";
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
	public ResultSet querry(String s) throws SQLException {
		dbclass obj = new dbclass();
		System.out.println("query started");
		ResultSet rs = obj.select("SELECT * FROM `discard_book` WHERE ID='" + s
				+ "'");
		System.out.println("helo");
		// System.out.println(rs.getString("Price"));
		System.out.println("querycompleted");
		return rs;
	}
}
