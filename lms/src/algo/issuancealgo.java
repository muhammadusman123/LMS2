package algo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;
import gui.Authentication.Display;
import gui.issuance.issuanceinsert;
import gui.issuance.issuanceupdate2;
import database.dbclass;
import database.issuancedb;
import database.returndb;
public class issuancealgo {
	String a;
	String s;
	issuanceinsert framea;
	issuanceupdate2 frameab;
	public issuancealgo() {
	}
	public Locale getLocale(String loc) {
		if (loc != null && loc.length() > 0) {
			return new Locale(loc);
		} else {
			return Locale.US;
		}
	}
	public void set(issuanceupdate2 obj, String id) throws SQLException {
		String c;
		System.out.println(id + "this is passed issuance id");
		ResultSet rs;
		algo.issuancealgo alg = new algo.issuancealgo();
		rs = alg.querryupdatea(id);
		while (rs.next()) {
			obj.textField_5.setText(rs.getString("studentid"));
			obj.textField.setText(rs.getString("UPC"));
			obj.textField_1.setText(rs.getString("issuedate"));
			obj.textField_2.setText(rs.getString("returndate"));
		}
	}
	public ResultSet queryrep() {
		issuancedb obj = new issuancedb();
		ResultSet rs = obj.queryrep();
		return rs;
	}
	public ResultSet querryupdatea(String s) throws SQLException {
		issuancedb obj = new issuancedb();
		ResultSet rs = obj.querryupdatea(s);
		return rs;
	}
	public void querryupdateb(String s, String a, String b, String c, String d) {
		issuancedb obj = new issuancedb();
		obj.querryupdateb(s, a, b, c, d);
	}
	public void querygen(String a, String b, String c, String d)
			throws SQLException {
		bookinventoryalgo obj2 = new bookinventoryalgo();
		ResultSet abc = obj2.queryrep();
		int found = 0;
		while (abc.next()) {
			if (abc.getString("UPC").equals(b) && abc.getInt("Remaining") > 0) {
				obj2.querryupdateb(b, abc.getInt("Total"),
						abc.getInt("Issued") + 1, abc.getInt("Returned"),
						abc.getInt("Remaining") - 1);
				issuancedb dbclassobj = new issuancedb();
				dbclassobj.querygen(a, b, c, d);
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
		issuancedb obj = new issuancedb();
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
						abc.getInt("Issued") - 1, abc.getInt("Returned"),
						abc.getInt("Remaining") + 1);
		}
		obj.delete(text);
		Display disp = new Display("Record has been Successfully Deleted");
		disp.setVisible(true);
	}
}
