package gui.Authentication;
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
import javax.swing.UIManager;
import algo.loginalgo;
import java.awt.Font;
public class loginmain extends JFrame {
	private JPanel contentPane;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					loginmain frame = new loginmain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public loginmain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Login Main Form");
		JButton btnInsert = new JButton("Insert");
		btnInsert.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnInsert.setBackground(UIManager.getColor("Button.disabledShadow"));
		btnInsert.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				logininsertion m = new logininsertion();
				m.setVisible(true);
			}
		});
		btnInsert.setBounds(10, 48, 195, 50);
		contentPane.add(btnInsert);
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnUpdate.setBackground(UIManager.getColor("Button.disabledShadow"));
		btnUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (loginalgo.logintype.equals("librarian")) {
					studentloginupdate obj = new studentloginupdate();
					obj.setVisible(true);
				} else {
					loginupdate1 obj1 = new loginupdate1();
					obj1.setVisible(true);
				}
			}
		});
		btnUpdate.setBounds(226, 48, 187, 50);
		contentPane.add(btnUpdate);
		JButton btnReport = new JButton("Report");
		btnReport.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnReport.setBackground(UIManager.getColor("Button.disabledShadow"));
		btnReport.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					loginjtable obj = new loginjtable();
					obj.setVisible(true);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		btnReport.setBounds(10, 145, 195, 50);
		contentPane.add(btnReport);
		JButton btnNewButton = new JButton("Exit");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setForeground(new Color(255, 0, 0));
		btnNewButton.setBackground(UIManager.getColor("Button.disabledShadow"));
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainPage obj = new MainPage();
				dispose();
			}
		});
		btnNewButton.setBounds(226, 145, 187, 50);
		contentPane.add(btnNewButton);
	}
}
