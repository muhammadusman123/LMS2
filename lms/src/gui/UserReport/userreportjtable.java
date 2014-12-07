package gui.UserReport;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;








import algo.purchasealgo;
import algo.userreportalgo;



public class userreportjtable extends JFrame {


	private JPanel contentPane;
	public st_database_GUI frame;
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					userreportjtable frame = new userreportjtable();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public userreportjtable() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 610, 388);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 574, 275);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setEnabled(false);
		scrollPane.setViewportView(table);
		
	
		setTitle("Student Report");
		DefaultTableModel model=new DefaultTableModel(){};
		table.setModel(model);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(469, 303, 115, 29);
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		contentPane.add(btnOk);
		userreportalgo abc=new userreportalgo();
		ResultSet rs=abc.Report();
		model.addColumn("Student_id");
		model.addColumn("Student_name");
		model.addColumn("Book_1");
		model.addColumn("Book_2");
		model.addColumn("No_Books");
		model.addColumn("From_Date");
		model.addColumn("To_Date");
	int counter=-1;

		while(rs.next())
		{
			counter++;
			model.addRow(new Object[7]);
		
			model.setValueAt(rs.getString("Student_id"),counter,0);
			model.setValueAt(rs.getString("Student_name"),counter,1);
			model.setValueAt(rs.getString("Book_1"),counter,2);
			model.setValueAt(rs.getString("Book_2"),counter,3);
			model.setValueAt(rs.getString("No_Books"),counter,4);
			model.setValueAt(rs.getString("From_Date"),counter,5);
			model.setValueAt(rs.getString("To_Date"),counter,6);
		}
	


	}
}
