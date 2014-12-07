package gui.UserReport;
import gui.Authentication.MainPage;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import java.awt.image.BufferedImage;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import javax.swing.JSlider;
import database.dbclass;
import javax.swing.JCheckBox;
import javax.swing.UIManager;
import java.awt.Font;
public class st_database_GUI extends JFrame {
	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					st_database_GUI frame = new st_database_GUI();
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
	public st_database_GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 441, 300);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Student Database Main Window");
		JButton btnStudentReportGeneration = new JButton("Report");
		btnStudentReportGeneration.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnStudentReportGeneration.setBackground(UIManager
				.getColor("Button.disabledShadow"));
		btnStudentReportGeneration.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					userreportjtable obj;
					obj = new userreportjtable();
					obj.setVisible(true);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnStudentReportGeneration.setBounds(61, 148, 94, 25);
		contentPane.add(btnStudentReportGeneration);
		JButton btnInsert = new JButton("Insert");
		btnInsert.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnInsert.setBackground(UIManager.getColor("Button.disabledShadow"));
		btnInsert.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				userreportinsertion in = new userreportinsertion();
				in.setVisible(true);
			}
		});
		btnInsert.setBounds(61, 98, 94, 25);
		contentPane.add(btnInsert);
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				userreportupdate1 up = new userreportupdate1();
				up.setVisible(true);
			}
		});
		btnUpdate.setBackground(UIManager.getColor("Button.disabledShadow"));
		btnUpdate.setBounds(252, 98, 94, 25);
		contentPane.add(btnUpdate);
		JButton btnExit = new JButton("Exit");
		btnExit.setForeground(new Color(255, 0, 0));
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				MainPage obj = new MainPage();
				obj.setVisible(true);
			}
		});
		btnExit.setBackground(UIManager.getColor("Button.disabledShadow"));
		btnExit.setBounds(164, 200, 94, 25);
		contentPane.add(btnExit);
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				userreport_deletion obj = new userreport_deletion();
				obj.setVisible(true);
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnDelete.setBounds(252, 148, 89, 25);
		contentPane.add(btnDelete);
		JLabel lblLmsStudentDatabase = new JLabel("LMS Student Database");
		lblLmsStudentDatabase.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblLmsStudentDatabase.setBounds(90, 11, 269, 34);
		contentPane.add(lblLmsStudentDatabase);
		JLabel label = new JLabel("___________________");
		label.setFont(new Font("Tahoma", Font.PLAIN, 24));
		label.setBounds(85, 15, 299, 27);
		contentPane.add(label);
	}
}
