package gui.issuance;
import gui.Authentication.MainPage;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import algo.issuancealgo;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.Timer;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import javax.swing.JSlider;
import database.alg;
import database.dbclass;
import javax.swing.UIManager;
public class issuancemain extends JFrame {
	private JPanel contentPane;
	protected issuancemain frame;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					issuancemain frame = new issuancemain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public issuancemain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setTitle("Book issuance Main Form");
		JButton btnNewButton = new JButton("Insert");
		btnNewButton.setBounds(26, 92, 184, 42);
		btnNewButton.setBackground(UIManager.getColor("Button.disabledShadow"));
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				issuanceinsert obj = new issuanceinsert();
				obj.setVisible(true);
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnNewButton);
		JButton btnNewButton_1 = new JButton("Update");
		btnNewButton_1.setBounds(220, 92, 184, 42);
		btnNewButton_1.setBackground(UIManager
				.getColor("Button.disabledShadow"));
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				issuanceupdate1 obj = new issuanceupdate1();
				obj.setVisible(true);
			}
		});
		contentPane.add(btnNewButton_1);
		JButton btnNewButton_2 = new JButton("Report");
		btnNewButton_2.setBounds(26, 161, 184, 42);
		btnNewButton_2.setBackground(UIManager
				.getColor("Button.disabledShadow"));
		btnNewButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					issuancereport issuancereportobj = new issuancereport();
					issuancereportobj.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		contentPane.add(btnNewButton_2);
		JButton btnCancel = new JButton("Exit");
		btnCancel.setBounds(220, 161, 184, 42);
		btnCancel.setForeground(new Color(255, 0, 0));
		btnCancel.setBackground(UIManager.getColor("Button.disabledShadow"));
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				MainPage obj = new MainPage();
				obj.setVisible(true);
			}
		});
		contentPane.add(btnCancel);
		JLabel label = new JLabel("");
		label.setBounds(0, 303, 428, -59);
		contentPane.add(label);
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				issuancedelete obj = new issuancedelete();
				obj.setVisible(true);
			}
		});
		btnDelete.setBounds(265, 47, 115, 29);
		contentPane.add(btnDelete);
	}
}
