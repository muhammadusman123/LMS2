package gui.returning;
import gui.Authentication.Display;
import java.util.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import javax.resource.cci.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DateFormatter;
import algo.DateCalculator;
import algo.DatePicker;
import algo.NewLibTest;
import algo.ObservingTextField;
import algo.issuancealgo;
//import task2.myframe;
import algo.returnalgo;
import algo.textvalidation;
import algo.verification;
import javax.swing.UIManager;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import database.alg;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
public class returninsert extends JFrame {
	private JPanel contentPane;
	public JTextField textField_1;
	public JTextField textField_2;
	public static returninsert frame;
	public ObservingTextField textField;
	private JTextField textField_7;
	private JTextField textField_3;
	private Calendar Today;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					returninsert frame = new returninsert();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public returninsert() {
		setResizable(false);
		frame = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Book return Insert Form");
		JLabel lblNewLabel_1 = new JLabel("Issue ID");
		lblNewLabel_1.setBounds(33, 53, 86, 14);
		contentPane.add(lblNewLabel_1);
		JLabel lblNewLabel_2 = new JLabel("Fine Paid");
		lblNewLabel_2.setBounds(33, 90, 105, 14);
		contentPane.add(lblNewLabel_2);
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
		textField_1.setBounds(196, 50, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		alg d = new alg();
		d.fun60(textField_1);
		textField_2 = new JTextField();
		textField_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					getToolkit().beep();
					Display obj = new Display("Input not Integer");
					obj.setVisible(true);
					e.consume();
				}
				if (textField_2.getText().length() == 5) {
					e.consume();
				}
			}
		});
		textField_2.setBounds(196, 87, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		d.fun61(textField_2);
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(345, 70, -24, 34);
		contentPane.add(scrollBar);
		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.setForeground(new Color(255, 0, 0));
		btnNewButton.setBackground(UIManager.getColor("Button.disabledShadow"));
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(309, 209, 115, 29);
		contentPane.add(btnNewButton);
		JButton btnAdd = new JButton("Add");
		btnAdd.setBackground(UIManager.getColor("Button.disabledShadow"));
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				returnalgo algosobj = new returnalgo();
				textvalidation valobj = new textvalidation();
				if (valobj.fun(textField.getText())) {
					Display obj = new Display("Return Date not Entered");
					obj.setVisible(true);
				} else if (valobj.fun(textField_1.getText())) {
					Display obj = new Display("Issue ID not Entered");
					obj.setVisible(true);
				} else if (valobj.fun(textField_2.getText())) {
					Display obj = new Display("Fine Paid not Entered");
					obj.setVisible(true);
				} else if (valobj.fun(textField_7.getText())) {
					Display obj = new Display("UPC not Entered");
					obj.setVisible(true);
				} else {
					verification obj4 = new verification();
					try {
						if (!obj4.ismatch(textField_1.getText(),
								textField_3.getText(), textField_7.getText())) {
							Display obj5 = new Display(
									"Issue ID and Student ID and Book doesnot match");
							obj5.setVisible(true);
						} else {
							if (!(textField_2.getText().equals(""
									+ DateCalculator.fine + ""))) {
								Display obj = new Display(
										"Fine Paid is not Equal to FIne Calculated");
								obj.setVisible(true);
							} else {
								algosobj.querygen(textField.getText(),
										textField_1.getText(),
										textField_2.getText(),
										textField_7.getText(),
										textField_3.getText());
								dispose();
							}
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		btnAdd.setBounds(309, 167, 115, 29);
		contentPane.add(btnAdd);
		textField = new ObservingTextField();
		textField.setEditable(false);
		textField.setBounds(196, 19, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		d.fun59(textField);
		Today = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		textField.setText(sdf.format(Today.getTime()));
		JButton btnreturndate = new JButton("return_Date");
		btnreturndate
				.setBackground(UIManager.getColor("Button.disabledShadow"));
		btnreturndate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String lang = null;
				returnalgo obj = new returnalgo();
				final Locale locale = obj.getLocale(lang);
				DatePicker dp = new DatePicker(textField, locale);
				Date selectedDate = dp.parseDate(textField.getText());
				dp.setSelectedDate(selectedDate);
				dp.start(textField);
			}
		});
		btnreturndate.setBounds(295, 17, 26, 24);
		contentPane.add(btnreturndate);
		JLabel lblDate = new JLabel("Return Date");
		lblDate.setBounds(33, 25, 105, 14);
		contentPane.add(lblDate);
		JLabel lblUpc = new JLabel("UPC");
		lblUpc.setBounds(33, 131, 69, 20);
		contentPane.add(lblUpc);
		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setBounds(175, 125, 146, 26);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		JButton btnBarcode = new JButton("BarCode");
		btnBarcode.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				NewLibTest obj = new NewLibTest();
				String value = obj.getbar();
				textField_7.setText(value);
			}
		});
		btnBarcode.setBounds(179, 199, 115, 29);
		contentPane.add(btnBarcode);
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
		textField_3.setBounds(164, 168, 146, 26);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		JLabel lblStudentid = new JLabel("StudentID");
		lblStudentid.setBounds(33, 171, 69, 20);
		contentPane.add(lblStudentid);
		JButton btnFineCalc = new JButton("Fine Calc");
		btnFineCalc.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				issuancealgo obj = new issuancealgo();
				java.sql.ResultSet rs = null;
				try {
					rs = obj.querryupdatea((textField_1.getText()));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					while (rs.next()) {
						DateTimeFormatter formatter = DateTimeFormat
								.forPattern("MM/dd/yyyy").withLocale(Locale.US);
						LocalDate date = formatter.parseLocalDate(rs
								.getString("returndate"));
						DateCalculator obj1 = new DateCalculator(date
								.getDayOfMonth(), date.getMonthOfYear(), date
								.getYear());
						obj1.calculating(obj1);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnFineCalc.setBounds(23, 209, 115, 29);
		contentPane.add(btnFineCalc);
	}
}