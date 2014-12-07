package gui.issuance;
import gui.Authentication.Display;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;
import java.util.Locale;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import algo.DatePicker;
import algo.NewLibTest;
import algo.ObservingTextField;
import algo.issuancealgo;
import algo.issuancealgo;
import algo.textvalidation;
import algo.verification;
import javax.swing.UIManager;
import database.alg;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
public class issuanceinsert extends JFrame {
	private JPanel contentPane;
	public ObservingTextField textField_2;
	public ObservingTextField textField_3;
	public static issuanceinsert frame;
	public JTextField textField;
	private JTextField textField_7;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					issuanceinsert frame = new issuanceinsert();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public issuanceinsert() {
		setResizable(false);
		frame = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Book issuance Insert Form");
		JLabel lblNewLabel_2 = new JLabel("IssueDate");
		lblNewLabel_2.setBounds(33, 90, 105, 14);
		contentPane.add(lblNewLabel_2);
		JLabel lblNewLabel_3 = new JLabel("Return Date");
		lblNewLabel_3.setBounds(33, 135, 86, 14);
		contentPane.add(lblNewLabel_3);
		alg d = new alg();
		textField_2 = new ObservingTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(196, 87, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		d.fun56(textField_2);
		textField_3 = new ObservingTextField();
		textField_3.setEditable(false);
		textField_3.setBounds(196, 132, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		d.fun57(textField_3);
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
				textvalidation valobj = new textvalidation();
				if (valobj.fun(textField.getText())) {
					Display obj = new Display("Student ID not Entered");
					obj.setVisible(true);
				} else if (valobj.fun(textField_2.getText())) {
					Display obj = new Display("Issue Date not Entered");
					obj.setVisible(true);
				} else if (valobj.fun(textField_3.getText())) {
					Display obj = new Display("Return Date not Entered");
					obj.setVisible(true);
				} else if (valobj.fun(textField_7.getText())) {
					Display obj = new Display("UPC not Entered");
					obj.setVisible(true);
				} else {
					try {
						verification var = new verification();
						if (!var.isstudent(textField.getText())) {
							Display obj = new Display(
									"Student ID Doesnot Match");
							obj.setVisible(true);
						} else {
							if (var.isreservedwithanystudent(
									textField_7.getText(), textField.getText())) {
								Display obj = new Display(
										"Sorry Reserved by someone else");
								obj.setVisible(true);
							} else {
								issuancealgo algosobj = new issuancealgo();
								try {
									algosobj.querygen(textField.getText(),
											textField_7.getText(),
											textField_2.getText(),
											textField_3.getText());
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								dispose();
								if (var.isreservedwiththisstudent(
										textField_7.getText(),
										textField.getText())) {
								}
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
		textField.setBounds(196, 19, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		d.fun54(textField);
		JButton btnissuancedate = new JButton("issuance_Date");
		btnissuancedate.setBackground(UIManager
				.getColor("Button.disabledShadow"));
		btnissuancedate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String lang = null;
				issuancealgo obj = new issuancealgo();
				final Locale locale = obj.getLocale(lang);
				DatePicker dp = new DatePicker(textField_2, locale);
				Date selectedDate = dp.parseDate(textField_2.getText());
				dp.setSelectedDate(selectedDate);
				dp.start(textField_2);
			}
		});
		btnissuancedate.setBounds(297, 85, 26, 24);
		contentPane.add(btnissuancedate);
		JLabel lblDate = new JLabel("StudentID");
		lblDate.setBounds(33, 25, 105, 14);
		contentPane.add(lblDate);
		JButton button = new JButton("issuance_Date");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String lang = null;
				issuancealgo obj = new issuancealgo();
				final Locale locale = obj.getLocale(lang);
				DatePicker dp = new DatePicker(textField_3, locale);
				Date selectedDate = dp.parseDate(textField_3.getText());
				dp.setSelectedDate(selectedDate);
				dp.start(textField_3);
			}
		});
		button.setBackground(Color.WHITE);
		button.setBounds(295, 128, 26, 24);
		contentPane.add(button);
		JLabel lblLabel = new JLabel("UPC");
		lblLabel.setBounds(33, 171, 69, 20);
		contentPane.add(lblLabel);
		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setBounds(142, 172, 146, 26);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		JButton btnBarcodereader = new JButton("BarCodeReader");
		btnBarcodereader.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				NewLibTest obj = new NewLibTest();
				String value = obj.getbar();
				textField_7.setText(value);
			}
		});
		btnBarcodereader.setBounds(187, 209, 115, 29);
		contentPane.add(btnBarcodereader);
	}
}