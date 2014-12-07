package gui.returning;
import gui.Authentication.Display;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.AbstractButton;
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
import algo.returnalgo;
import algo.textvalidation;
import algo.verification;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
public class returnupdate2 extends JDialog {
	private final JPanel contentPanel = new JPanel();
	public JTextField textField;
	public JTextField textField_1;
	public String name, bookname;
	public int bookid;
	public returnupdate2 frameab;
	public ObservingTextField textField_5;
	public JTextField textField_2;
	public JTextField textField_3;
	public returnupdate2(final String id) {
		frameab = this;
		setBounds(100, 100, 450, 337);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(UIManager.getColor("Button.background"));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setTitle("Return Update2 Form");
		JLabel lblStudentname = new JLabel("Issue ID");
		lblStudentname.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblStudentname.setBounds(24, 62, 134, 14);
		contentPanel.add(lblStudentname);
		JLabel lblBook = new JLabel("Fine Paid");
		lblBook.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblBook.setBounds(24, 107, 106, 14);
		contentPanel.add(lblBook);
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
		textField.setBounds(212, 59, 115, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		alg a = new alg();
		a.fun60(textField);
		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					getToolkit().beep();
					Display obj = new Display("Input not Integer");
					obj.setVisible(true);
					e.consume();
				}
				if (textField_1.getText().length() == 5) {
					e.consume();
				}
			}
		});
		textField_1.setBounds(212, 104, 115, 20);
		contentPanel.add(textField_1);
		textField_1.setColumns(10);
		a.fun61(textField_1);
		textField_5 = new ObservingTextField();
		textField_5.setEditable(false);
		textField_5.setBounds(213, 17, 115, 20);
		contentPanel.add(textField_5);
		textField_5.setColumns(10);
		a.fun59(textField_5);
		JButton btnReturnDate = new JButton("Return Date");
		btnReturnDate
				.setBackground(UIManager.getColor("Button.disabledShadow"));
		btnReturnDate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String lang = null;
				returnalgo obj = new returnalgo();
				final Locale locale = obj.getLocale(lang);
				DatePicker dp = new DatePicker(textField_5, locale);
				Date selectedDate = dp.parseDate(textField_5.getText());
				dp.setSelectedDate(selectedDate);
				dp.start(textField_5);
			}
		});
		btnReturnDate.setBounds(332, 17, 30, 20);
		contentPanel.add(btnReturnDate);
		JLabel lblNewLabel_2 = new JLabel("Return Date");
		lblNewLabel_2.setBounds(24, 16, 106, 14);
		contentPanel.add(lblNewLabel_2);
		JLabel lblUpc = new JLabel("UPC");
		lblUpc.setBounds(24, 137, 69, 20);
		contentPanel.add(lblUpc);
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(212, 140, 146, 26);
		contentPanel.add(textField_2);
		textField_2.setColumns(10);
		textField_3 = new JTextField();
		textField_3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					getToolkit().beep();
					Display obj = new Display("Input not Integer");
					obj.setVisible(true);
					e.consume();
				}
				if (textField_3.getText().length() == 5) {
					e.consume();
				}
			}
		});
		textField_3.setBounds(216, 185, 146, 26);
		contentPanel.add(textField_3);
		textField_3.setColumns(10);
		JLabel lblStudentId = new JLabel("Student ID");
		lblStudentId.setBounds(24, 188, 106, 20);
		contentPanel.add(lblStudentId);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(UIManager.getColor("Button.background"));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					private AbstractButton textField_7;
					@Override
					public void actionPerformed(ActionEvent arg0) {
						textvalidation valobj = new textvalidation();
						if (valobj.fun(textField_5.getText())) {
							Display obj = new Display("Return Date not Entered");
							obj.setVisible(true);
						} else if (valobj.fun(textField.getText())) {
							Display obj = new Display("Issue ID not Entered");
							obj.setVisible(true);
						} else if (valobj.fun(textField_1.getText())) {
							Display obj = new Display("Fine Paid not Entered");
							obj.setVisible(true);
						} else if (valobj.fun(textField_2.getText())) {
							Display obj = new Display("UPC not Entered");
							obj.setVisible(true);
						} else {
							try {
								verification obj4 = new verification();
								if (!obj4.ismatch(textField.getText(),
										textField_3.getText(),
										textField_2.getText())) {
									Display obj5 = new Display(
											"Issue ID and Student ID and Book doesnot match");
									obj5.setVisible(true);
								} else {
									algo.returnalgo obj = new algo.returnalgo();
									obj.querryupdateb(id,
											textField_5.getText(),
											textField.getText(),
											textField_1.getText(),
											textField_2.getText(),
											textField_3.getText());
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