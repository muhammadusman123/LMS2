package database;
import java.sql.ResultSet;
import java.sql.SQLException;
import gui.Purchase.BookPurchaseUpdate;
import gui.Purchase.bookPurchase;
import database.dbclass;
public class bookinventory {
	String a;
	String s;
	bookPurchase framea;
	BookPurchaseUpdate frameab;
	public bookinventory() {
	}
	public ResultSet queryrep() {
		dbclass obj = new dbclass();
		ResultSet rs = obj.select("SELECT * FROM `bookinventory`");
		return rs;
	}
	public ResultSet querryupdatea(String s) throws SQLException {
		dbclass obj = new dbclass();
		ResultSet rs = obj.select("SELECT * FROM `bookinventory` WHERE UPC='"
				+ s + "'");
		return rs;
	}
	public void querryupdateb(String am, int i, int j, int k, int l) {
		this.a = am;
		// frameab = frame;
		s = ("Update `bookinventory` SET `Total`='" + i + "', `Issued`='" + j
				+ "', `Returned`='" + k + "', `Remaining`='" + l
				+ "' where `UPC`='" + am + "'");
		dbclass dbclassobj = new dbclass();
		dbclassobj.insert(s);
	}
	public void querygen(String a, int i, int j, int k, int l) {
		// framea = frame;
		// in/t a = Integer.parseInt(framea.textField_1.getText());
		s = "INSERT INTO `bookinventory`(`UPC`, `Total`, `Issued`, `Returned`, `Remaining`) values ('"
				+ a + "','" + i + "','" + j + "','" + k + "','" + l + "')";
		dbclass dbclassobj = new dbclass();
		dbclassobj.insert(s);
	}
}
