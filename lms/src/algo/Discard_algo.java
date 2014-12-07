package algo;
import java.sql.ResultSet;
import java.sql.SQLException;
import database.dbclass;
import discard.Insert_Discard;
import discard.Update_Discard;
public class Discard_algo {
	public void Discard_frame(int s, Insert_Discard framea) {
		Discard_DB alg = new Discard_DB();
		alg.Delete_frame(s, framea);
	}
	public void Insert_frame(int s, Insert_Discard framea) {
		Discard_DB budget = new Discard_DB();
		budget.Insert_frame(s, framea);
	}
	public void update(int s, Update_Discard framea) {
		Discard_DB budget = new Discard_DB();
		budget.update(s, framea);
	}
	public ResultSet select() throws SQLException {
		Discard_DB budget = new Discard_DB();
		ResultSet rs = budget.select();
		return rs;
	}
	public ResultSet selects() {
		Discard_DB budget = new Discard_DB();
		ResultSet rs = budget.selects();
		return rs;
	}
	public ResultSet querry(String s) throws SQLException {
		Discard_DB budget = new Discard_DB();
		ResultSet rs = budget.querry(s);
		return rs;
	}
}
