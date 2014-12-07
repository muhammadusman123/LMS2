package gui.UserReport;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import algo.DatePicker;
import algo.ObservingTextField;
import algo.userreportalgo;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.util.Date;
import java.util.Locale;
import javax.swing.UIManager;
import java.awt.Font;
public class userreportinsertion extends JDialog {
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	public String name, book1, book2, fromdate, todate;
	public int id;
	public st_database_GUI frame;
	private ObservingTextField textField_4;
	private ObservingTextField textField_5;
	/**
	 * Launch the application.
	 */
	/**
	 * Create the dialog.
	 */
	public userreportinsertion() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(UIManager.getColor("Button.background"));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setTitle("Student Addition Window");
		JLabel lblStudentname = new JLabel("Student name");
		lblStudentname.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblStudentname.setBackground(Color.GRAY);
		lblStudentname.setBounds(20, 29, 125, 14);
		contentPanel.add(lblStudentname);
		JLabel lblBook = new JLabel("Book 1");
		lblBook.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblBook.setBackground(Color.GRAY);
		lblBook.setBounds(20, 64, 111, 14);
		contentPanel.add(lblBook);
		JLabel lblBook_1 = new JLabel("Book 2");
		lblBook_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblBook_1.setBackground(Color.GRAY);
		lblBook_1.setBounds(20, 101, 97, 14);
		contentPanel.add(lblBook_1);
		textField = new JTextField();
		textField.setBounds(196, 26, 125, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		// alg d = new alg();
		// d.fun46(textField);
		textField_1 = new JTextField();
		textField_1.setBounds(196, 62, 125, 20);
		contentPanel.add(textField_1);
		textField_1.setColumns(10);
		// d.fun47(textField_1);
		textField_2 = new JTextField();
		textField_2.setBounds(196, 98, 125, 20);
		contentPanel.add(textField_2);
		textField_2.setColumns(10);
		// d.fun48(textField_2);
		JButton btnFromdate = new JButton("From_Date");
		btnFromdate.setBackground(UIManager.getColor("Button.disabledShadow"));
		btnFromdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String lang = null;
				userreportalgo obj = new userreportalgo();
				final Locale locale = obj.getLocale(lang);
				DatePicker dp = new DatePicker(textField_4, locale);
				Date selectedDate = dp.parseDate(textField_4.getText());
				dp.setSelectedDate(selectedDate);
				dp.start(textField_4);
			}
		});
		btnFromdate.setBounds(321, 135, 27, 23);
		contentPanel.add(btnFromdate);
		JButton btnTodate = new JButton("To_Date");
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
		btnTodate.setBounds(321, 182, 27, 23);
		contentPanel.add(btnTodate);
		textField_4 = new ObservingTextField();
		textField_4.setBounds(196, 136, 125, 20);
		contentPanel.add(textField_4);
		textField_4.setColumns(10);
		// d.fun49(textField_4);
		textField_5 = new ObservingTextField();
		textField_5.setBounds(196, 183, 125, 20);
		contentPanel.add(textField_5);
		textField_5.setColumns(10);
		// d.fun50(textField_5);
		JLabel lblFromdate = new JLabel("To Date");
		lblFromdate.setForeground(Color.BLACK);
		lblFromdate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFromdate.setBounds(20, 185, 94, 14);
		contentPanel.add(lblFromdate);
		JLabel lblFromdate_1 = new JLabel("From Date");
		lblFromdate_1.setForeground(Color.BLACK);
		lblFromdate_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFromdate_1.setBounds(20, 138, 71, 14);
		contentPanel.add(lblFromdate_1);
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
						name = textField.getText();
						book1 = textField_1.getText();
						book2 = textField_2.getText();
						fromdate = textField_4.getText();
						todate = textField_5.getText();
						// id=Integer.parseInt(textField_3.getText());
						userreportalgo obj = new userreportalgo();
						obj.Insert(name, book1, book2, fromdate, todate);
						dispose();
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
