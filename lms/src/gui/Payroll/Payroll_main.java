package gui.Payroll;

import gui.Authentication.MainPage;
import gui.UserReport.userreportjtable;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class Payroll_main extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Payroll_main frame = new Payroll_main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Payroll_main() {
		setTitle("Payroll Main Window");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 433, 240);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				payroll_insertion obj=new payroll_insertion();
				obj.setVisible(true);
			}
		});
		btnInsert.setBounds(20, 76, 89, 23);
		contentPane.add(btnInsert);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				payroll_update1 obj=new payroll_update1();
				obj.setVisible(true);
			}
		});
		btnUpdate.setBounds(304, 76, 89, 23);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				payroll_deletion obj = new payroll_deletion();
				obj.setVisible(true);
			}
		});
		btnDelete.setBounds(162, 76, 89, 23);
		contentPane.add(btnDelete);
		
		JButton btnReport = new JButton("Report");
		btnReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					employee_report obj;
					obj = new employee_report();
				
					obj.setVisible(true);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnReport.setBounds(20, 129, 89, 23);
		contentPane.add(btnReport);
		
		JButton btnSalary = new JButton("Salary");
		btnSalary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				payroll_salary1 obj=new payroll_salary1();
				obj.setVisible(true);
			}
		});
		btnSalary.setBounds(162, 129, 89, 23);
		contentPane.add(btnSalary);
		
		JButton btnBack = new JButton("Exit");
		btnBack.setForeground(Color.RED);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MainPage obj=new MainPage();		
				obj.setVisible(true);
			}
		});
		btnBack.setBounds(304, 129, 89, 23);
		contentPane.add(btnBack);
		
		JLabel lblPayrollInc = new JLabel("LMS Payroll");
		lblPayrollInc.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblPayrollInc.setBounds(148, 11, 145, 43);
		contentPane.add(lblPayrollInc);
		
		JLabel label = new JLabel("__________");
		label.setFont(new Font("Tahoma", Font.PLAIN, 24));
		label.setBounds(146, 11, 157, 54);
		contentPane.add(label);
	}
}
