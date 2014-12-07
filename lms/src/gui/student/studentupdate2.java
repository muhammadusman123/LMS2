package gui.student;
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
import algo.studentalgo;
import algo.textvalidation;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
public class studentupdate2 extends JDialog {
	private final JPanel contentPanel = new JPanel();
	public JTextField textField;
	public JTextField textField_1;
	public ObservingTextField textField_2;
	public String name, bookname;
	public int bookid;
	public studentupdate2 frameab;
	public JTextField textField_4;
	public ObservingTextField textField_5;
	public JComboBox comboBox;
	public studentupdate2(final String id) {
		setResizable(false);
		frameab = this;
		setBounds(100, 100, 450, 395);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(UIManager.getColor("Button.background"));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setTitle("student Update2 Form");
		contentPanel.setLayout(null);
		JLabel lblNobooks = new JLabel("DOB");
		lblNobooks.setBounds(24, 141, 77, 14);
		lblNobooks.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPanel.add(lblNobooks);
		JLabel lblStudentname = new JLabel("Name");
		lblStudentname.setBounds(24, 62, 134, 14);
		lblStudentname.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPanel.add(lblStudentname);
		JLabel lblBook = new JLabel("Email");
		lblBook.setBounds(24, 107, 106, 14);
		lblBook.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPanel.add(lblBook);
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					getToolkit().beep();
					Display obj = new Display("Integer Input not Valid");
					obj.setVisible(true);
					e.consume();
				}
				if (textField.getText().length() == 25) {
					e.consume();
				}
			}
		});
		textField.setBounds(212, 59, 115, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		alg a = new alg();
		a.fun31(textField);
		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (textField_1.getText().length() == 30) {
					e.consume();
				}
			}
		});
		textField_1.setBounds(222, 103, 115, 20);
		contentPanel.add(textField_1);
		textField_1.setColumns(10);
		a.fun32(textField_1);
		textField_2 = new ObservingTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(212, 135, 115, 20);
		contentPanel.add(textField_2);
		textField_2.setColumns(10);
		a.fun33(textField_2);
		textField_4 = new JTextField();
		textField_4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					getToolkit().beep();
					Display obj = new Display("Input not Integer");
					obj.setVisible(true);
					e.consume();
				}
				if (textField_4.getText().length() == 15) {
					e.consume();
				}
			}
		});
		textField_4.setBounds(212, 197, 115, 20);
		contentPanel.add(textField_4);
		textField_4.setColumns(10);
		JLabel lblNewLabel = new JLabel("Gender");
		lblNewLabel.setBounds(24, 166, 69, 20);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPanel.add(lblNewLabel);
		JLabel lblNewLabel_1 = new JLabel("Phone");
		lblNewLabel_1.setBounds(24, 197, 69, 20);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPanel.add(lblNewLabel_1);
		textField_5 = new ObservingTextField();
		textField_5.setEditable(false);
		textField_5.setBounds(212, 221, 115, 20);
		contentPanel.add(textField_5);
		textField_5.setColumns(10);
		JButton btnstudentDate = new JButton("student Date");
		btnstudentDate.setBounds(342, 221, 30, 20);
		btnstudentDate.setBackground(UIManager
				.getColor("Button.disabledShadow"));
		btnstudentDate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String lang = null;
				studentalgo obj = new studentalgo();
				final Locale locale = obj.getLocale(lang);
				DatePicker dp = new DatePicker(textField_5, locale);
				Date selectedDate = dp.parseDate(textField_5.getText());
				dp.setSelectedDate(selectedDate);
				dp.start(textField_5);
			}
		});
		contentPanel.add(btnstudentDate);
		JLabel lblNewLabel_2 = new JLabel("Date of Joining");
		lblNewLabel_2.setBounds(15, 224, 106, 14);
		contentPanel.add(lblNewLabel_2);
		JButton button = new JButton("...");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String lang = null;
				studentalgo obj = new studentalgo();
				final Locale locale = obj.getLocale(lang);
				DatePicker dp = new DatePicker(textField_2, locale);
				Date selectedDate = dp.parseDate(textField_2.getText());
				dp.setSelectedDate(selectedDate);
				dp.start(textField_2);
			}
		});
		button.setBounds(329, 131, 33, 29);
		contentPanel.add(button);
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Male\t",
				"Female" }));
		comboBox.setBounds(222, 162, 69, 26);
		contentPanel.add(comboBox);
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
							Display obj = new Display("Name not Entered");
							obj.setVisible(true);
						} else if (valobj.fun(textField_1.getText())) {
							Display obj = new Display(
									"Email Address not Entered");
							obj.setVisible(true);
						} else if (valobj.fun(textField_2.getText())) {
							Display obj = new Display(
									"Date of Birth not Entered");
							obj.setVisible(true);
						} else if (valobj.fun((String) comboBox
								.getSelectedItem())) {
							Display obj = new Display("Gender not Entered");
							obj.setVisible(true);
						} else if (valobj.fun(textField_4.getText())) {
							Display obj = new Display("Phone not Entered");
							obj.setVisible(true);
						} else if (valobj.fun(textField_5.getText())) {
							Display obj = new Display(
									"Date of Joining not Entered");
							obj.setVisible(true);
						} else {
							algo.studentalgo obj = new algo.studentalgo();
							obj.querryupdateb(id, textField.getText(),
									textField_1.getText(),
									textField_2.getText(),
									(String) comboBox.getSelectedItem(),
									textField_4.getText(),
									textField_5.getText());
							Display disp = new Display(
									"Record has been Successfully Updated");
							disp.setVisible(true);
							dispose();
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