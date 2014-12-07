package database;
import java.sql.ResultSet;
import java.sql.SQLException;
import gui.Purchase.BookPurchaseUpdate;
import gui.Purchase.bookPurchase;
import database.dbclass;
public class purchasedb {
	String a;
	String s;
	bookPurchase framea;
	BookPurchaseUpdate frameab;
	public purchasedb() {
	}
	public ResultSet queryrep() {
		dbclass obj = new dbclass();
		ResultSet rs = obj.select("SELECT * FROM `book1`");
		return rs;
	}
	public ResultSet querryupdatea(String s) throws SQLException {
		dbclass obj = new dbclass();
		ResultSet rs = obj.select("SELECT * FROM `book1` WHERE Book_ID='" + s
				+ "'");
		return rs;
	}
	public void querryupdateb(String am, String a, String b, String c,
			String d, String e, String f, String g, String h) {
		this.a = am;
		// frameab = frame;
		s = ("Update `book1` SET `ISBN`='" + a + "', `Author_Name`='" + b
				+ "', `Book_Title`='" + c + "', `Edition`='" + d
				+ "', `Price`='" + e + "' , `Purchase_Date`='" + f
				+ "' , `Category`='" + g + "' , `UPC`='" + h
				+ "' where `book_ID`='" + am + "'");
		dbclass dbclassobj = new dbclass();
		dbclassobj.insert(s);
	}
	public void querygen(String a, String b, String c, String d, String e,
			String f, String g, String h) {
		// framea = frame;
		// in/t a = Integer.parseInt(framea.textField_1.getText());
		s = "INSERT INTO `book1`(`ISBN`, `Author_Name`, `Book_Title`, `Edition`, `Price`,`Purchase_Date`,`Category`,`UPC`) values ('"
				+ b
				+ "','"
				+ c
				+ "','"
				+ d
				+ "','"
				+ e
				+ "','"
				+ f
				+ "','"
				+ a
				+ "','" + g + "','" + h + "')";
		dbclass dbclassobj = new dbclass();
		dbclassobj.insert(s);
	}
	public void delete(String text) {
		// TODO Auto-generated method stub
		String s = "DELETE FROM `book1` WHERE Book_ID='" + text + "'";
		dbclass obj = new dbclass();
		obj.insert(s);
	}
}
