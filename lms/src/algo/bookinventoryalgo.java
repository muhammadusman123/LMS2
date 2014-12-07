package algo;
import java.sql.ResultSet;
import java.sql.SQLException;
import database.dbclass;
import database.bookinventory;
import database.bookinventory;
public class bookinventoryalgo {
	String a;
	String s;
	public bookinventoryalgo() {
	}
	public ResultSet queryrep() {
		bookinventory obj = new bookinventory();
		ResultSet rs = obj.queryrep();
		return rs;
	}
	public ResultSet querryupdatea(String s) throws SQLException {
		bookinventory obj = new bookinventory();
		ResultSet rs = obj.querryupdatea(s);
		return rs;
	}
	public void querryupdateb(String s, int i, int j, int k, int l) {
		bookinventory obj = new bookinventory();
		obj.querryupdateb(s, i, j, k, l);
	}
	public void querygen(String a, int i, int j, int k, int l) {
		bookinventory dbclassobj = new bookinventory();
		dbclassobj.querygen(a, i, j, k, l);
	}
}
