package database;
import java.sql.ResultSet;
import java.sql.SQLException;
import gui.Purchase.BookPurchaseUpdate;
import gui.Purchase.bookPurchase;
import gui.issuance.issuanceinsert;
import gui.issuance.issuanceupdate1;
import gui.issuance.issuanceupdate2;
import database.dbclass;
public class issuancedb {
	String a;
	String s;
	issuanceinsert framea;
	issuanceupdate2 frameab;
	public issuancedb() {
	}
	public ResultSet queryrep() {
		dbclass obj = new dbclass();
		ResultSet rs = obj.select("SELECT * FROM `issuance`");
		return rs;
	}
	public ResultSet querryupdatea(String s) throws SQLException {
		dbclass obj = new dbclass();
		ResultSet rs = obj.select("SELECT * FROM `issuance` WHERE issuanceid='"
				+ s + "'");
		return rs;
	}
	public void querryupdateb(String am, String a, String b, String c, String d) {
		// frameab = frame;
		this.a = am;
		s = ("Update `issuance` SET `studentid`='" + a + "', `UPC`='" + b
				+ "', `issuedate`='" + c + "', `returndate`='" + d
				+ "' where `issuanceid`='" + am + "'");
		dbclass dbclassobj = new dbclass();
		dbclassobj.insert(s);
	}
	public void querygen(String a, String b, String c, String d) {
		// framea = frame;
		// int a = Integer.parseInt(framea.textField_1.getText());
		s = "INSERT INTO `issuance`(`studentid`, `UPC`, `issuedate`, `returndate`) values ('"
				+ a + "','" + b + "','" + c + "','" + d + "')";
		dbclass dbclassobj = new dbclass();
		dbclassobj.insert(s);
	}
	public void delete(String text) {
		String s = "DELETE FROM `issuance` WHERE issuanceid='" + text + "'";
		dbclass obj = new dbclass();
		obj.insert(s);
		// TODO Auto-generated method stub
	}
}
