package gui.issuance;
import gui.Authentication.Display;
import gui.reservation.reservation_gui;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import algo.issuancealgo;
import algo.textvalidation;
import algo.verification;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.awt.Color;
import javax.swing.UIManager;
import database.alg;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
public class issuancedelete extends JDialog {
	private final JPanel contentPanel = new JPanel();
	public String id;
	public reservation_gui frame;
	private JTextField textField;
	public issuancedelete() {
		setResizable(false);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(UIManager.getColor("Button.background"));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setTitle("issuance Delete Form");
		JLabel lblStudentid = new JLabel("Insert ID");
		lblStudentid.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblStudentid.setBounds(70, 83, 63, 14);
		contentPanel.add(lblStudentid);
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					getToolkit().beep();
					Display obj = new Display("Input not Integer");
					obj.setVisible(true);
					e.consume();
				}
				if (textField.getText().length() == 5) {
					e.consume();
				}
			}
		});
		textField.setBounds(223, 80, 86, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		alg a = new alg();
		a.fun53(textField);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(UIManager.getColor("Button.background"));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setBackground(UIManager
						.getColor("Button.disabledShadow"));
				okButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						textvalidation valobj = new textvalidation();
						if (valobj.fun(textField.getText())) {
							Display obj = new Display("ID not Entered");
							obj.setVisible(true);
						} else {
							verification obj = new verification();
							try {
								if (!obj.isissueid(textField.getText())) {
									Display obj2 = new Display(
											"Issue ID Not Found");
									obj2.setVisible(true);
								} else {
									id = textField.getText();
									issuancealgo obj2 = new issuancealgo();
									try {
										obj2.delete(textField.getText());
									} catch (SQLException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									dispose();
								}
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setForeground(new Color(255, 0, 0));
				cancelButton.setBackground(UIManager
						.getColor("Button.disabledShadow"));
				cancelButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
