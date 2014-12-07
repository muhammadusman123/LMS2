package gui.issuance;
import gui.Authentication.Display;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Locale;
import javax.swing.UIManager;
import database.alg;
import algo.DatePicker;
import algo.ObservingTextField;
import algo.issuancealgo;
import algo.textvalidation;
import algo.verification;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
public class issuanceupdate2 extends JDialog {
	private final JPanel contentPanel = new JPanel();
	public JTextField textField;
	public ObservingTextField textField_1;
	public ObservingTextField textField_2;
	public String name, bookname;
	public int bookid;
	public issuanceupdate2 frameab;
	public JTextField textField_5;
	public issuanceupdate2(final String id) {
		setResizable(false);
		frameab = this;
		setBounds(100, 100, 450, 337);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(UIManager.getColor("Button.background"));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setTitle("issuance Update2 Form");
		JLabel lblNobooks = new JLabel("Return Date");
		lblNobooks.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNobooks.setBounds(24, 141, 77, 14);
		contentPanel.add(lblNobooks);
		JLabel lblStudentname = new JLabel("UPC");
		lblStudentname.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblStudentname.setBounds(24, 62, 134, 14);
		contentPanel.add(lblStudentname);
		JLabel lblBook = new JLabel("IssueDate");
		lblBook.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblBook.setBounds(24, 107, 106, 14);
		contentPanel.add(lblBook);
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(212, 59, 115, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		alg a = new alg();
		// a.fun55(textField);
		textField_1 = new ObservingTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(212, 104, 115, 20);
		contentPanel.add(textField_1);
		textField_1.setColumns(10);
		// a.fun56(textField_1);
		textField_2 = new ObservingTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(212, 135, 115, 20);
		contentPanel.add(textField_2);
		textField_2.setColumns(10);
		// a.fun57(textField_2);
		textField_5 = new JTextField();
		textField_5.addKeyListener(new KeyAdapter() {
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
		textField_5.setBounds(213, 17, 115, 20);
		contentPanel.add(textField_5);
		textField_5.setColumns(10);
		// a.fun54(textField_5);
		JButton btnissuanceDate = new JButton("issuance Date");
		btnissuanceDate.setBackground(UIManager
				.getColor("Button.disabledShadow"));
		btnissuanceDate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String lang = null;
				issuancealgo obj = new issuancealgo();
				final Locale locale = obj.getLocale(lang);
				DatePicker dp = new DatePicker(textField_1, locale);
				Date selectedDate = dp.parseDate(textField_1.getText());
				dp.setSelectedDate(selectedDate);
				dp.start(textField_1);
			}
		});
		btnissuanceDate.setBounds(342, 103, 30, 20);
		contentPanel.add(btnissuanceDate);
		JLabel lblNewLabel_2 = new JLabel("Student ID");
		lblNewLabel_2.setBounds(24, 16, 106, 14);
		contentPanel.add(lblNewLabel_2);
		JButton button = new JButton("issuance Date");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String lang = null;
				issuancealgo obj = new issuancealgo();
				final Locale locale = obj.getLocale(lang);
				DatePicker dp = new DatePicker(textField_2, locale);
				Date selectedDate = dp.parseDate(textField_2.getText());
				dp.setSelectedDate(selectedDate);
				dp.start(textField_2);
			}
		});
		button.setBackground(Color.WHITE);
		button.setBounds(342, 133, 30, 20);
		contentPanel.add(button);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(UIManager.getColor("Button.background"));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						textvalidation valobj = new textvalidation();
						if (valobj.fun(textField.getText())) {
							Display obj = new Display("UPC not Entered");
							obj.setVisible(true);
						} else if (valobj.fun(textField_1.getText())) {
							Display obj = new Display("Issue Date not Entered");
							obj.setVisible(true);
						} else if (valobj.fun(textField_2.getText())) {
							Display obj = new Display("Return Date not Entered");
							obj.setVisible(true);
						} else if (valobj.fun(textField_5.getText())) {
							Display obj = new Display("ID not Entered");
							obj.setVisible(true);
						} else {
							verification obj = new verification();
							try {
								if (!obj.isstudent(textField_5.getText())) {
									Display obj2 = new Display(
											"Student ID Not Found");
									obj2.setVisible(true);
								} else {
									algo.issuancealgo obj1 = new algo.issuancealgo();
									obj1.querryupdateb(id,
											textField_5.getText(),
											textField.getText(),
											textField_1.getText(),
											textField_2.getText());
									Display disp = new Display(
											"Record has been Successfully Updated");
									disp.setVisible(true);
									dispose();
								}
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				});
				okButton.setBackground(UIManager
						.getColor("Button.disabledShadow"));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setForeground(new Color(255, 0, 0));
				cancelButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setBackground(UIManager
						.getColor("Button.disabledShadow"));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}