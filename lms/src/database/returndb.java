package database;
import java.sql.ResultSet;
import java.sql.SQLException;
import gui.Purchase.BookPurchaseUpdate;
import gui.Purchase.bookPurchase;
import gui.returning.returninsert;
import gui.returning.returnupdate2;
import database.dbclass;
public class returndb {
	String a;
	String s;
	returninsert framea;
	returnupdate2 frameab;
	public returndb() {
	}
	public ResultSet queryrep() {
		dbclass obj = new dbclass();
		ResultSet rs = obj.select("SELECT * FROM `returning`");
		return rs;
	}
	public ResultSet querryupdatea(String s) throws SQLException {
		dbclass obj = new dbclass();
		System.out.println("query started");
		ResultSet rs = obj.select("SELECT * FROM `returning` WHERE returnid='"
				+ s + "'");
		return rs;
	}
	public void querryupdateb(String am, String a, String b, String c,
			String d, String e) {
		this.a = am;
		// frameab = frame;
		s = ("Update `returning` SET `returndate`='" + a + "', `issueid`='" + b
				+ "', `finepaid`='" + c + "',`UPC` ='" + d + "',`studentid` ='"
				+ e + "' where `returnid`='" + am + "'");
		dbclass dbclassobj = new dbclass();
		dbclassobj.insert(s);
	}
	public void querygen(String a, String b, String c, String d, String e) {
		// int a = Integer.parseInt(framea.textField_1.getText());
		s = "INSERT INTO `returning`(`returndate`, `issueid`, `finepaid`,`UPC`,`studentid`) values ('"
				+ a + "','" + b + "','" + c + "','" + d + "','" + e + "')";
		dbclass dbclassobj = new dbclass();
		dbclassobj.insert(s);
	}
	public void delete(String text) {
		String s = "DELETE FROM `returning` WHERE returnid='" + text + "'";
		dbclass obj = new dbclass();
		obj.insert(s); // TODO Auto-generated method stub
	}
}
