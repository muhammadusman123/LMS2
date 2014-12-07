package gui.student;
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
//import task2.myframe;
import algo.studentalgo;
import algo.textvalidation;
import javax.swing.UIManager;
import database.alg;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
public class studentinsert extends JFrame {
	private JPanel contentPane;
	public JTextField textField_1;
	public JTextField textField_2;
	public JTextField textField_3;
	public ObservingTextField textField_5;
	public static studentinsert frame;
	public ObservingTextField textField;
	public JComboBox comboBox;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					studentinsert frame = new studentinsert();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public studentinsert() {
		setResizable(false);
		frame = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 397);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setTitle("Book student Insert Form");
		contentPane.setLayout(null);
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(33, 53, 46, 14);
		contentPane.add(lblNewLabel_1);
		JLabel lblNewLabel_2 = new JLabel("Email");
		lblNewLabel_2.setBounds(33, 90, 105, 14);
		contentPane.add(lblNewLabel_2);
		JLabel lblNewLabel_3 = new JLabel("Phone");
		lblNewLabel_3.setBounds(33, 135, 86, 14);
		contentPane.add(lblNewLabel_3);
		JLabel lblNewLabel_4 = new JLabel("Gender");
		lblNewLabel_4.setBounds(33, 174, 46, 14);
		contentPane.add(lblNewLabel_4);
		JLabel lblPrice = new JLabel("DOB");
		lblPrice.setBounds(33, 216, 46, 14);
		contentPane.add(lblPrice);
		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					getToolkit().beep();
					Display obj = new Display("Integer Input not Valid");
					obj.setVisible(true);
					e.consume();
				}
				if (textField_1.getText().length() == 25) {
					e.consume();
				}
			}
		});
		textField_1.setBounds(196, 50, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		alg d = new alg();
		d.fun31(textField_1);
		textField_2 = new JTextField();
		textField_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (textField_2.getText().length() == 30) {
					e.consume();
				}
			}
		});
		textField_2.setBounds(196, 87, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		d.fun32(textField_2);
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
				if (textField_3.getText().length() == 15) {
					e.consume();
				}
			}
		});
		textField_3.setBounds(196, 132, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		d.fun33(textField_3);
		textField_5 = new ObservingTextField();
		textField_5.setEditable(false);
		textField_5.setBounds(196, 213, 86, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		d.fun35(textField_5);
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(345, 70, -24, 34);
		contentPane.add(scrollBar);
		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.setBounds(309, 209, 115, 29);
		btnNewButton.setForeground(new Color(255, 0, 0));
		btnNewButton.setBackground(UIManager.getColor("Button.disabledShadow"));
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		contentPane.add(btnNewButton);
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(309, 167, 115, 29);
		btnAdd.setBackground(UIManager.getColor("Button.disabledShadow"));
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				studentalgo algosobj = new studentalgo();
				try {
					textvalidation valobj = new textvalidation();
					if (valobj.fun(textField.getText())) {
						Display obj = new Display("Date not Entered");
						obj.setVisible(true);
					} else if (valobj.fun(textField_1.getText())) {
						Display obj = new Display("Name not Entered");
						obj.setVisible(true);
					} else if (valobj.fun(textField_2.getText())) {
						Display obj = new Display("Email Address not Entered");
						obj.setVisible(true);
					} else if (valobj.fun(textField_3.getText())) {
						Display obj = new Display("Phone not Entered");
						obj.setVisible(true);
					} else if (valobj.fun((String) comboBox.getSelectedItem())) {
						Display obj = new Display("Gender not Entered");
						obj.setVisible(true);
					} else if (valobj.fun(textField_5.getText())) {
						Display obj = new Display("Dat of Birth not Entered");
						obj.setVisible(true);
					} else {
						algosobj.querygen(textField_1.getText(),
								textField_2.getText(), textField_5.getText(),
								(String) comboBox.getSelectedItem(),
								textField_3.getText(), textField.getText());
						Display disp = new Display(
								"Record has been Successfully Inserted");
						disp.setVisible(true);
						dispose();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		contentPane.add(btnAdd);
		textField = new ObservingTextField();
		textField.setEditable(false);
		textField.setBounds(196, 19, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		JButton btnstudentdate = new JButton("student_Date");
		btnstudentdate.setBounds(295, 17, 26, 24);
		btnstudentdate.setBackground(UIManager
				.getColor("Button.disabledShadow"));
		btnstudentdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String lang = null;
				studentalgo obj = new studentalgo();
				final Locale locale = obj.getLocale(lang);
				DatePicker dp = new DatePicker(textField, locale);
				Date selectedDate = dp.parseDate(textField.getText());
				dp.setSelectedDate(selectedDate);
				dp.start(textField);
			}
		});
		contentPane.add(btnstudentdate);
		JLabel lblDate = new JLabel("Date of Joining");
		lblDate.setBounds(33, 25, 115, 14);
		contentPane.add(lblDate);
		JButton button = new JButton("...");
		button.addActionListener(new ActionListener() {
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
		button.setBounds(282, 209, 26, 29);
		contentPane.add(button);
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Male",
				"Female" }));
		comboBox.setBounds(190, 168, 65, 26);
		contentPane.add(comboBox);
	}
}