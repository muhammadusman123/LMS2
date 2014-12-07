package algo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;
import gui.Authentication.Display;
import gui.Purchase.BookPurchaseUpdate;
import gui.Purchase.bookPurchase;
import database.dbclass;
import database.purchasedb;
import database.purchasedb;
public class purchasealgo {
	String a;
	String s;
	bookPurchase framea;
	BookPurchaseUpdate frameab;
	public purchasealgo() {
	}
	public Locale getLocale(String loc) {
		if (loc != null && loc.length() > 0) {
			return new Locale(loc);
		} else {
			return Locale.US;
		}
	}
	public void set(BookPurchaseUpdate obj, String id) throws SQLException {
		String c;
		System.out.println(id + "this is passed purchase id");
		ResultSet rs;
		algo.purchasealgo alg = new algo.purchasealgo();
		rs = alg.querryupdatea(id);
		while (rs.next()) {
			obj.textField.setText(rs.getString("ISBN"));
			obj.textField_1.setText(rs.getString("Author_Name"));
			obj.textField_2.setText(rs.getString("Book_Title"));
			obj.textField_4.setText(rs.getString("Edition"));
			obj.textField_3.setText(rs.getString("Price"));
			obj.textField_5.setText(rs.getString("Purchase_Date"));
			obj.comboBox.setSelectedItem(rs.getString("Category"));
			obj.textField_7.setText(rs.getString("UPC"));
		}
	}
	public ResultSet queryrep() {
		purchasedb obj = new purchasedb();
		ResultSet rs = obj.queryrep();
		return rs;
	}
	public ResultSet querryupdatea(String s) throws SQLException {
		purchasedb obj = new purchasedb();
		ResultSet rs = obj.querryupdatea(s);
		return rs;
	}
	public void querryupdateb(String s, String a, String b, String c, String d,
			String e, String f, String g, String h) {
		purchasedb obj = new purchasedb();
		obj.querryupdateb(s, a, b, c, d, e, f, g, h);
	}
	public void querygen(String a, String b, String c, String d, String e,
			String f, String g, String h) throws SQLException {
		purchasedb dbclassobj = new purchasedb();
		dbclassobj.querygen(a, b, c, d, e, f, g, h);
		bookinventoryalgo obj2 = new bookinventoryalgo();
		ResultSet abc = obj2.queryrep();
		int found = 0;
		while (abc.next()) {
			if (abc.getString("UPC").equals(h)) {
				obj2.querryupdateb(h, abc.getInt("Total") + 1,
						abc.getInt("Issued"), abc.getInt("Returned"),
						abc.getInt("Remaining") + 1);
				found = 1;
				Display disp = new Display(
						"Record has been Successfully Inserted");
				disp.setVisible(true);
			}
		}
		if (found == 0) {
			System.out.println("not found");
			obj2.querygen(h, 1, 0, 0, 1);
			found = 1;
		}
	}
	public void delete(String text) throws SQLException {
		// TODO Auto-generated method stub
		purchasedb obj = new purchasedb();
		bookinventoryalgo obj2 = new bookinventoryalgo();
		ResultSet usman = obj.querryupdatea(text);
		String checker = "";
		while (usman.next()) {
			checker = usman.getString("UPC");
		}
		ResultSet abc = obj2.queryrep();
		while (abc.next()) {
			if (abc.getString("UPC").equals(checker))
				obj2.querryupdateb(checker, abc.getInt("Total") - 1,
						abc.getInt("Issued"), abc.getInt("Returned"),
						abc.getInt("Remaining") - 1);
		}
		Display disp = new Display("Record has been Successfully Deleted");
		disp.setVisible(true);
		obj.delete(text);
	}
}
