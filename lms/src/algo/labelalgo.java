package algo;
import java.sql.SQLException;
import javax.resource.cci.ResultSet;
import database.purchasedb;
public class labelalgo {
	public int calculatelabel(String s) throws SQLException {
		purchasedb obj = new purchasedb();
		java.sql.ResultSet rs = obj.queryrep();
		int counter = 0;
		while (rs.next()) {
			if (rs.getString("Category").equals(s)) {
				counter++;
			}
		}
		return counter + 1;
	}
	public void printlabel(String s) {
		DirectPrint obj = new DirectPrint();
		obj.printing(s);
		// TODO Auto-generated method stub
	}
}
