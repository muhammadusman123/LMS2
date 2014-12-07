package gui.Authentication;
import gui.Purchase.BookPurchaseMain;
import gui.UserReport.st_database_GUI;
import gui.issuance.issuancemain;
import gui.reservation.reservation_gui;
import gui.returning.returnmain;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
public class librarianmainpage extends JFrame {
	private JPanel contentPane;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					librarianmainpage frame = new librarianmainpage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public librarianmainpage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Librarian Main Page");
		JButton btnNewButton = new JButton("Purchase");
		btnNewButton.setBackground(UIManager.getColor("Button.disabledShadow"));
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				BookPurchaseMain obj = new BookPurchaseMain();
				obj.setVisible(true);
			}
		});
		btnNewButton.setBounds(31, 18, 152, 29);
		contentPane.add(btnNewButton);
		JButton btnNewButton_8 = new JButton("User Report");
		btnNewButton_8.setBackground(UIManager
				.getColor("Button.disabledShadow"));
		btnNewButton_8.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				st_database_GUI obj = new st_database_GUI();
				obj.setVisible(true);
			}
		});
		btnNewButton_8.setBounds(31, 66, 152, 29);
		contentPane.add(btnNewButton_8);
		JButton btnNewButton_1 = new JButton("Reservation");
		btnNewButton_1.setBackground(UIManager
				.getColor("Button.disabledShadow"));
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				reservation_gui obj = new reservation_gui();
				obj.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(31, 123, 152, 29);
		contentPane.add(btnNewButton_1);
		JButton btnNewButton_2 = new JButton("Account Options");
		btnNewButton_2.setBackground(UIManager
				.getColor("Button.disabledShadow"));
		btnNewButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				loginmain obj = new loginmain();
				obj.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(31, 168, 152, 29);
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
		btnNewButton_3.setBounds(151, 221, 115, 29);
		contentPane.add(btnNewButton_3);
		JButton btnNewButton_4 = new JButton("Issuance");
		btnNewButton_4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				issuancemain obj = new issuancemain();
				obj.setVisible(true);
			}
		});
		btnNewButton_4.setBounds(243, 18, 152, 29);
		contentPane.add(btnNewButton_4);
		JButton btnNewButton_5 = new JButton("Returning");
		btnNewButton_5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				returnmain obj = new returnmain();
				obj.setVisible(true);
			}
		});
		btnNewButton_5.setBounds(243, 66, 152, 29);
		contentPane.add(btnNewButton_5);
		JButton btnNewButton_6 = new JButton("Fine Calculation");
		btnNewButton_6.setBounds(243, 123, 152, 29);
		contentPane.add(btnNewButton_6);
	}
}