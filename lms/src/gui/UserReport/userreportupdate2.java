package gui.UserReport;
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
import algo.userreportalgo;
import java.awt.Font;
public class userreportupdate2 extends JDialog {
	private final JPanel contentPanel = new JPanel();
	public JTextField textField;
	public JTextField textField_1;
	public JTextField textField_2;
	public String name, book1, book2, fromdate, todate;
	public int count;
	public st_database_GUI frame;
	public ObservingTextField textField_4;
	public ObservingTextField textField_5;
	/**
	 * Launch the application.
	 */
	/**
	 * Create the dialog.
	 */
	public userreportupdate2(final int id) {
		setBounds(100, 100, 450, 267);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(UIManager.getColor("Button.background"));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setTitle("Student Data Updation Window");
		JLabel lblStudentname = new JLabel("Student name");
		lblStudentname.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblStudentname.setBounds(30, 11, 144, 14);
		contentPanel.add(lblStudentname);
		JLabel lblBook = new JLabel("Book 1");
		lblBook.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblBook.setBounds(30, 46, 109, 14);
		contentPanel.add(lblBook);
		JLabel lblBook_1 = new JLabel("Book 2");
		lblBook_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblBook_1.setBounds(30, 86, 109, 14);
		contentPanel.add(lblBook_1);
		textField = new JTextField();
		textField.setBounds(212, 8, 109, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		alg d = new alg();
		d.fun46(textField);
		textField_1 = new JTextField();
		textField_1.setBounds(212, 43, 109, 20);
		contentPanel.add(textField_1);
		textField_1.setColumns(10);
		d.fun47(textField_1);
		textField_2 = new JTextField();
		textField_2.setBounds(212, 78, 109, 20);
		contentPanel.add(textField_2);
		textField_2.setColumns(10);
		d.fun48(textField_2);
		JButton btnFromdate = new JButton("...");
		btnFromdate.setBackground(UIManager.getColor("Button.disabledShadow"));
		btnFromdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String lang = null;
				final Locale locale = getLocale(lang);
				DatePicker dp = new DatePicker(textField_4, locale);
				Date selectedDate = dp.parseDate(textField_4.getText());
				dp.setSelectedDate(selectedDate);
				dp.start(textField_4);
			}
			public Locale getLocale(String loc) {
				if (loc != null && loc.length() > 0) {
					return new Locale(loc);
				} else {
					return Locale.US;
				}
			}
		});
		btnFromdate.setBounds(320, 122, 20, 23);
		contentPanel.add(btnFromdate);
		JButton btnTodate = new JButton("...");
		btnTodate.setBackground(UIManager.getColor("Button.disabledShadow"));
		btnTodate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String lang = null;
				final Locale locale = getLocale(lang);
				DatePicker dp = new DatePicker(textField_5, locale);
				Date selectedDate = dp.parseDate(textField_5.getText());
				dp.setSelectedDate(selectedDate);
				dp.start(textField_5);
			}
			public Locale getLocale(String loc) {
				if (loc != null && loc.length() > 0) {
					return new Locale(loc);
				} else {
					return Locale.US;
				}
			}
		});
		btnTodate.setBounds(320, 156, 20, 23);
		contentPanel.add(btnTodate);
		textField_4 = new ObservingTextField();
		textField_4.setBounds(212, 123, 109, 20);
		contentPanel.add(textField_4);
		textField_4.setColumns(10);
		d.fun49(textField_4);
		textField_5 = new ObservingTextField();
		textField_5.setBounds(212, 156, 109, 20);
		contentPanel.add(textField_5);
		textField_5.setColumns(10);
		d.fun50(textField_5);
		JLabel lblTodate = new JLabel("To Date");
		lblTodate.setForeground(Color.BLACK);
		lblTodate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTodate.setBounds(30, 159, 68, 14);
		contentPanel.add(lblTodate);
		JLabel lblFromdate = new JLabel("From Date");
		lblFromdate.setForeground(Color.BLACK);
		lblFromdate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFromdate.setBounds(30, 125, 80, 14);
		contentPanel.add(lblFromdate);
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
						name = textField.getText();
						book1 = textField_1.getText();
						book2 = textField_2.getText();
						count = 2;
						fromdate = textField_4.getText();
						todate = textField_5.getText();
						userreportalgo obj = new userreportalgo();
						obj.Update(id, name, book1, book2, count, fromdate,
								todate);
						dispose();
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
