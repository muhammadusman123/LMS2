package gui.Authentication;
import gui.Budget.budgetmain;
import gui.Payroll.Payroll_main;
import gui.Purchase.BookPurchaseMain;
import gui.UserReport.st_database_GUI;
import gui.issuance.issuancemain;
import gui.reservation.reservation_gui;
import gui.returning.returnmain;
import gui.student.studentmain;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import javax.swing.UIManager;
import bookinventory.bookinventory;
public class MainPage extends JFrame {
	private JPanel contentPane;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					MainPage frame = new MainPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public MainPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 589, 423);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Main Page");
		JButton btnNewButton = new JButton("Purchase");
		btnNewButton.setBackground(UIManager.getColor("Button.disabledShadow"));
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				BookPurchaseMain obj = new BookPurchaseMain();
				obj.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(34, 10, 152, 29);
		contentPane.add(btnNewButton);
		JButton btnNewButton_8 = new JButton("User Report");
		btnNewButton_8.setBackground(UIManager
				.getColor("Button.disabledShadow"));
		btnNewButton_8.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				st_database_GUI obj = new st_database_GUI();
				obj.setVisible(true);
				dispose();
			}
		});
		btnNewButton_8.setBounds(34, 49, 152, 29);
		contentPane.add(btnNewButton_8);
		JButton btnNewButton_9 = new JButton("Budget");
		btnNewButton_9.setBackground(UIManager
				.getColor("Button.disabledShadow"));
		btnNewButton_9.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				budgetmain obj = new budgetmain();
				obj.setVisible(true);
				dispose();
			}
		});
		btnNewButton_9.setBounds(34, 95, 152, 29);
		contentPane.add(btnNewButton_9);
		JButton btnNewButton_1 = new JButton("Reservation");
		btnNewButton_1.setBackground(UIManager
				.getColor("Button.disabledShadow"));
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				reservation_gui obj = new reservation_gui();
				obj.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(34, 140, 152, 29);
		contentPane.add(btnNewButton_1);
		JButton btnNewButton_2 = new JButton("Account Options");
		btnNewButton_2.setBackground(UIManager
				.getColor("Button.disabledShadow"));
		btnNewButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				loginmain obj = new loginmain();
				obj.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(34, 185, 152, 29);
		contentPane.add(btnNewButton_2);
		JButton btnNewButton_3 = new JButton("Exit");
		btnNewButton_3.setForeground(new Color(255, 0, 0));
		btnNewButton_3.setBackground(UIManager
				.getColor("Button.disabledShadow"));
		btnNewButton_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_3.setBounds(285, 228, 152, 29);
		contentPane.add(btnNewButton_3);
		JButton btnSlider = new JButton("Slider");
		btnSlider.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				slider obj = new slider();
				obj.setVisible(true);
			}
		});
		btnSlider.setBounds(285, 185, 152, 29);
		contentPane.add(btnSlider);
		JButton btnIssuance = new JButton("Issuance");
		btnIssuance.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				issuancemain obj = new issuancemain();
				obj.setVisible(true);
			}
		});
		btnIssuance.setBounds(285, 10, 152, 29);
		contentPane.add(btnIssuance);
		JButton btnReturn = new JButton("Return");
		btnReturn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				returnmain obj = new returnmain();
				obj.setVisible(true);
			}
		});
		btnReturn.setBounds(285, 49, 152, 29);
		contentPane.add(btnReturn);
		JButton btnFineCalc = new JButton("Fine Calc");
		btnFineCalc.setBounds(285, 94, 152, 29);
		contentPane.add(btnFineCalc);
		JButton btnPayroll = new JButton("PayRoll");
		btnPayroll.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Payroll_main obj = new Payroll_main();
				obj.setVisible(true);
			}
		});
		btnPayroll.setBounds(285, 139, 152, 29);
		contentPane.add(btnPayroll);
		JButton btnBookReport = new JButton("Book Report");
		btnBookReport.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					bookinventory obj = new bookinventory();
					obj.setVisible(true);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnBookReport.setBounds(44, 228, 115, 29);
		contentPane.add(btnBookReport);
		JButton btnStudent = new JButton("Student");
		btnStudent.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				studentmain obj = new studentmain();
				obj.setVisible(true);
			}
		});
		btnStudent.setBounds(54, 273, 115, 29);
		contentPane.add(btnStudent);
	}
}