package algo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;
import gui.Authentication.Display;
import gui.Purchase.BookPurchaseUpdate;
import gui.Purchase.bookPurchase;
import gui.returning.returninsert;
import gui.returning.returnupdate2;
import database.dbclass;
import database.issuancedb;
import database.purchasedb;
import database.returndb;
public class returnalgo {
	String a;
	String s;
	returninsert framea;
	returnupdate2 frameab;
	public returnalgo(returninsert frame) {
		framea = frame;
	}
	public Locale getLocale(String loc) {
		if (loc != null && loc.length() > 0) {
			return new Locale(loc);
		} else {
			return Locale.US;
		}
	}
	public returnalgo() {
	}
	public void set(returnupdate2 obj, String id) throws SQLException {
		String c;
		ResultSet rs;
		algo.returnalgo alg = new algo.returnalgo();
		rs = alg.querryupdatea(id);
		while (rs.next()) {
			obj.textField_5.setText(rs.getString("returndate"));
			obj.textField.setText(rs.getString("issueid"));
			obj.textField_1.setText(rs.getString("finepaid"));
			obj.textField_2.setText(rs.getString("UPC"));
			obj.textField_3.setText(rs.getString("studentid"));
		}
	}
	public returnalgo(returnupdate2 frame) {
		frameab = frame;
	}
	public ResultSet queryrep() {
		returndb obj = new returndb();
		ResultSet rs = obj.queryrep();
		return rs;
	}
	public ResultSet querryupdatea(String s) throws SQLException {
		returndb obj = new returndb();
		ResultSet rs = obj.querryupdatea(s);
		return rs;
	}
	public void querryupdateb(String s, String a, String b, String c, String d,
			String e) {
		returndb obj = new returndb();
		obj.querryupdateb(s, a, b, c, d, e);
	}
	public void querygen(String a, String b, String c, String d, String e)
			throws SQLException {
		bookinventoryalgo obj2 = new bookinventoryalgo();
		ResultSet abc = obj2.queryrep();
		int found = 0;
		while (abc.next()) {
			if (abc.getString("UPC").equals(d)) {
				obj2.querryupdateb(d, abc.getInt("Total"),
						abc.getInt("Issued"), abc.getInt("Returned") + 1,
						abc.getInt("Remaining") + 1);
				returndb dbclassobj = new returndb();
				System.out.println("hello Usman");
				dbclassobj.querygen(a, b, c, d, e);
				found = 1;
				Display disp = new Display(
						"Record has been Successfully Inserted");
				disp.setVisible(true);
			}
		}
		if (found == 0) {
			System.out.println("not found");
			Display obj3 = new Display("Book Not Available");
			obj3.setVisible(true);
			found = 1;
		}
	}
	public void delete(String text) throws SQLException {
		// TODO Auto-generated method stub
		returndb obj = new returndb();
		bookinventoryalgo obj2 = new bookinventoryalgo();
		ResultSet usman = obj.querryupdatea(text);
		String checker = "";
		while (usman.next()) {
			checker = usman.getString("UPC");
		}
		ResultSet abc = obj2.queryrep();
		while (abc.next()) {
			if (abc.getString("UPC").equals(checker))
				obj2.querryupdateb(checker, abc.getInt("Total"),
						abc.getInt("Issued"), abc.getInt("Returned") - 1,
						abc.getInt("Remaining") - 1);
		}
		Display disp = new Display("Record has been Successfully Deleted");
		disp.setVisible(true);
		obj.delete(text);
	}
}
