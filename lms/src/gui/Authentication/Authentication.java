package gui.Authentication;
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
import algo.loginalgo;
import algo.textvalidation;
import database.alg;
import database.dbclass;
import java.awt.Font;
import javax.swing.UIManager;
public class Authentication extends JFrame {
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField textField_1;
	private JLabel lblPassword;
	private JLabel label_1;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				int a = 0;
				try {
					Authentication frame = new Authentication();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Authentication() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 523, 392);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setTitle("Authentication Form");
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(303, 223, 115, 29);
		btnLogin.setBackground(UIManager.getColor("Button.disabledShadow"));
		btnLogin.addActionListener(new ActionListener() {
			@Override
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				textvalidation valobj = new textvalidation();
				if (valobj.fun(textField.getText())) {
					Display obj = new Display("UserName not Entered");
					obj.setVisible(true);
				} else if (valobj.fun(textField_1.getText())) {
					Display obj = new Display("Password not Entered");
					obj.setVisible(true);
				} else {
					loginalgo obj = new loginalgo();
					obj.validation(textField.getText(), textField_1.getText());
				}
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnLogin);
		textField = new JTextField();
		textField.setBounds(371, 108, 115, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		alg d = new alg();
		d.fun(textField);
		textField_1 = new JPasswordField();
		textField_1.setBounds(371, 158, 115, 29);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblUserName.setBounds(269, 97, 159, 50);
		contentPane.add(lblUserName);
		lblPassword = new JLabel("PassWord");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPassword.setBounds(269, 148, 200, 50);
		contentPane.add(lblPassword);
		label_1 = new JLabel("");
		label_1.setBounds(0, 0, 424, 243);
		JLabel label = new JLabel("");
		label.setBackground(new Color(240, 240, 240));
		label.setBounds(0, 0, 605, 347);
	}
}