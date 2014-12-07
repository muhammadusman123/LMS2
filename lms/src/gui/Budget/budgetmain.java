package gui.Budget;
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
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
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
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.View;
import javax.swing.text.html.ImageView;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.Toolkit;
import java.awt.SystemColor;
public class budgetmain extends JFrame {
	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					budgetmain frame = new budgetmain();
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
	public budgetmain() {
		// setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Naveed\\Desktop\\1011.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 394, 335);
		contentPane = new JPanel();
		contentPane.setForeground(UIManager
				.getColor("FormattedTextField.selectionForeground"));
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JButton btnNewButton = new JButton("  Insert");
		// btnNewButton.setIcon(new
		// ImageIcon("C:\\Users\\Naveed\\Desktop\\1111.png"));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(UIManager
				.getColor("InternalFrame.inactiveTitleBackground"));
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				budgetinsertion m = new budgetinsertion();
				m.setVisible(true);
			}
		});
		btnNewButton.setBounds(40, 114, 138, 23);
		contentPane.add(btnNewButton);
		JButton btnNewButton_1 = new JButton("  Update");
		// btnNewButton_1.setIcon(new
		// ImageIcon("C:\\Users\\Naveed\\Desktop\\5555.png"));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setBackground(UIManager.getColor("activeCaption"));
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				budgetupdate1 up = new budgetupdate1();
				up.setVisible(true);
				// dispose();
			}
		});
		btnNewButton_1.setBounds(188, 114, 138, 23);
		contentPane.add(btnNewButton_1);
		setTitle("Welcome to Budgeting");
		JButton btnNewButton_2 = new JButton("  Report");
		// btnNewButton_2.setIcon(new
		// ImageIcon("C:\\Users\\Naveed\\Desktop\\4444.png"));
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_2.setForeground(Color.BLACK);
		btnNewButton_2.setBackground(UIManager.getColor("activeCaption"));
		btnNewButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					budgetjtable obj = new budgetjtable();
					// obj.setVisible(true);
					// obj.setVisible(true);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBounds(40, 156, 138, 23);
		contentPane.add(btnNewButton_2);
		JButton btnNewButton_3 = new JButton(" Exit");
		// btnNewButton_3.setIcon(new
		// ImageIcon("C:\\Users\\Naveed\\Desktop\\2222.png"));
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				// MainPage obj=new MainPage();
				// obj.setVisible(true);
			}
		});
		btnNewButton_3.setForeground(new Color(255, 0, 0));
		btnNewButton_3.setBackground(UIManager.getColor("activeCaption"));
		btnNewButton_3.setBounds(188, 156, 138, 23);
		contentPane.add(btnNewButton_3);
		JLabel label = new JLabel("");
		label.setForeground(Color.LIGHT_GRAY);
		label.setBackground(Color.LIGHT_GRAY);
		label.setBounds(253, -61, 157, 262);
		// Image img=new ImageIcon
		// (this.getClass().getResource("/1011.png")).getImage();
		// label.setIcon(new ImageIcon(img));
		contentPane.add(label);
		JButton btnNewButton_4 = new JButton("");
		// btnNewButton_4.setIcon(new
		// ImageIcon("C:\\Users\\Naveed\\Desktop\\g.png"));
		btnNewButton_4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				try {
					String Url = "https://accounts.google.com/ServiceLogin?service=mail&passive=true&rm=false&continue=https://mail.google.com/mail/&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1";
					java.awt.Desktop.getDesktop().browse(
							java.net.URI.create(Url));
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
		btnNewButton_4.setBounds(200, 245, 41, 41);
		contentPane.add(btnNewButton_4);
		JButton button = new JButton("");
		// button.setIcon(new ImageIcon("C:\\Users\\Naveed\\Desktop\\y.png"));
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					String Url = "https://www.yahoo.com/";
					java.awt.Desktop.getDesktop().browse(
							java.net.URI.create(Url));
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
		button.setBounds(157, 245, 41, 41);
		contentPane.add(button);
		JButton button_1 = new JButton("");
		// button_1.setIcon(new ImageIcon("C:\\Users\\Naveed\\Desktop\\h.png"));
		button_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					String Url = "https://login.live.com/login.srf?wa=wsignin1.0&rpsnv=12&ct=1415908512&rver=6.4.6456.0&wp=MBI_SSL_SHARED&wreply=https:%2F%2Fmail.live.com%2Fdefault.aspx%3Frru%3Dinbox&lc=1033&id=64855&mkt=en-us&cbcxt=mai";
					java.awt.Desktop.getDesktop().browse(
							java.net.URI.create(Url));
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
		button_1.setBounds(239, 245, 41, 41);
		contentPane.add(button_1);
		JLabel lblBookPurchaseBudget = new JLabel("Book Purchase Budget");
		lblBookPurchaseBudget.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBookPurchaseBudget.setBounds(88, 28, 184, 25);
		contentPane.add(lblBookPurchaseBudget);
		JButton btnEmail = new JButton("Email");
		btnEmail.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// SendEmail sent=new SendEmail();
				// try {
				// sent.maindata("F128067@nu.edu.pk");
				// System.out.println("mail is sent");
				// } catch (AddressException e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
				// } catch (MessagingException e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
				// }
			}
		});
		btnEmail.setBounds(40, 197, 138, 23);
		contentPane.add(btnEmail);
	}
}
