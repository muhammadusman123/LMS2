package database;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import database.dbclass;

public class userreport_dbclass {

	public void Insert(String st_name,String book_1,String book_2,String from_date,String to_date)
	
	{
		
		
		 String insert_query;
		  insert_query="INSERT INTO `student_database`(`Student_name`,`Book_1`,`Book_2`,`No_books`,`From_Date`,`To_Date`) VALUES('"+st_name+"','"+book_1+"','"+book_2+"','"+2+"','"+from_date+"','"+to_date+"')";
		dbclass obj=new dbclass();
		obj.insert(insert_query);
		
		
	}

	public void Update(int st_id, String st_name, String book_1, String book_2,
			int count,String from_date,String to_date) {
		String d1="22",d2="23";
		String update_query;
		update_query = "UPDATE `student_database` SET `Student_name`= '"
				+ st_name + "' ,`Book_1`='" + book_1 + "',`Book_2`='" + book_2
				+ "',`No_books`='" + count + "',`From_Date`='"+from_date+"',`To_Date`='"+to_date+"' WHERE `Student_id`='" + st_id
				+ "'";
		dbclass obj = new dbclass();
		obj.insert(update_query);
	}

	public ResultSet Report() throws SQLException {
		String report_query = "SELECT * FROM `student_database`";
		dbclass obj = new dbclass();
		ResultSet rs = obj.select(report_query);
		// JTable table = new JTable(buildTableModel(rs));
		// JOptionPane.showMessageDialog(null, new JScrollPane(table));
		return rs;
	}

	public ResultSet update_field(int id) throws SQLException {
		String query = "SELECT * FROM `student_database` WHERE Student_id='"
				+ id + "'";
		dbclass obj = new dbclass();
		ResultSet rs = obj.select(query);
		// JTable table = new JTable(buildTableModel(rs));
		// JOptionPane.showMessageDialog(null, new JScrollPane(table));
		return rs;
	}
	
	 public void Delete (int id, String name)
	   {
		  String query="DELETE FROM `student_database` WHERE Student_id='"+ id +"'";
		  dbclass obj = new dbclass();
		  obj.insert(query);
	   }

}
