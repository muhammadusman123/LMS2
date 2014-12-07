package gui.Purchase;
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
import algo.labelalgo;
//import task2.myframe;
import algo.purchasealgo;
import algo.textvalidation;
import javax.swing.UIManager;
import database.alg;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
public class bookPurchase extends JFrame {
	private JPanel contentPane;
	public JTextField textField_1;
	public JTextField textField_2;
	public JTextField textField_3;
	public JTextField textField_4;
	public JTextField textField_5;
	public static bookPurchase frame;
	public ObservingTextField textField;
	public JTextField textField_7;
	public JComboBox comboBox;
	public static String labelofbook;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					bookPurchase frame = new bookPurchase();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public bookPurchase() {
		setResizable(false);
		frame = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 397);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setTitle("Book Purchase Insert Form");
		contentPane.setLayout(null);
		JLabel lblNewLabel_1 = new JLabel("ISBN");
		lblNewLabel_1.setBounds(33, 53, 46, 14);
		contentPane.add(lblNewLabel_1);
		JLabel lblNewLabel_2 = new JLabel("Author_Name");
		lblNewLabel_2.setBounds(33, 90, 105, 14);
		contentPane.add(lblNewLabel_2);
		JLabel lblNewLabel_3 = new JLabel("Book_Name");
		lblNewLabel_3.setBounds(33, 135, 86, 14);
		contentPane.add(lblNewLabel_3);
		JLabel lblNewLabel_4 = new JLabel("Edition");
		lblNewLabel_4.setBounds(33, 174, 46, 14);
		contentPane.add(lblNewLabel_4);
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(33, 216, 46, 14);
		contentPane.add(lblPrice);
		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				char c = arg0.getKeyChar();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					getToolkit().beep();
					arg0.consume();
					Display obj = new Display("Input not Integer");
					obj.setVisible(true);
				}
				if (textField_1.getText().length() == 10) {
					arg0.consume();
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
			public void keyTyped(KeyEvent arg0) {
				char c = arg0.getKeyChar();
				if (((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					getToolkit().beep();
					arg0.consume();
					Display obj = new Display("Integer Input Not Valid");
					obj.setVisible(true);
				}
				if (textField_2.getText().length() == 25) {
					arg0.consume();
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
				if (((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					getToolkit().beep();
					e.consume();
					Display obj = new Display("Integer Input Not Valid");
					obj.setVisible(true);
				}
				if (textField_3.getText().length() == 25) {
					e.consume();
				}
			}
		});
		textField_3.setBounds(196, 132, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		d.fun33(textField_3);
		textField_4 = new JTextField();
		textField_4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					getToolkit().beep();
					e.consume();
					Display obj = new Display("Input not Integer");
					obj.setVisible(true);
				}
				if (textField_4.getText().length() == 2) {
					e.consume();
				}
			}
		});
		textField_4.setBounds(196, 171, 86, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		d.fun34(textField_4);
		textField_5 = new JTextField();
		textField_5.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					getToolkit().beep();
					e.consume();
					Display obj = new Display("Input not Integer");
					obj.setVisible(true);
				}
				if (textField_5.getText().length() == 5) {
					e.consume();
				}
			}
		});
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
				purchasealgo algosobj = new purchasealgo();
				try {
					textvalidation valobj = new textvalidation();
					if (valobj.fun(textField.getText())) {
						Display obj = new Display("Date not Entered");
						obj.setVisible(true);
					} else if (valobj.fun(textField_1.getText())) {
						Display obj = new Display("ISBN not Entered");
						obj.setVisible(true);
					} else if (valobj.fun(textField_2.getText())) {
						Display obj = new Display("Author Name not Entered");
						obj.setVisible(true);
					} else if (valobj.fun(textField_3.getText())) {
						Display obj = new Display("Book Name not Entered");
						obj.setVisible(true);
					} else if (valobj.fun(textField_4.getText())) {
						Display obj = new Display("Edition not Entered");
						obj.setVisible(true);
					} else if (valobj.fun(textField_5.getText())) {
						Display obj = new Display("Price not Entered");
						obj.setVisible(true);
					} else if (valobj.fun((String) comboBox.getSelectedItem())) {
						Display obj = new Display("Category not Entered");
						obj.setVisible(true);
					} else if (valobj.fun(textField_7.getText())) {
						Display obj = new Display("UPC not Entered");
						obj.setVisible(true);
					} else {
						labelalgo obj = new labelalgo();
						int counter = obj.calculatelabel((String) comboBox
								.getSelectedItem());
						labelofbook = (String) comboBox.getSelectedItem()
								+ counter;
						Display obj2 = new Display(
								"Do you want to Print a Label for this new Book !!!");
						obj2.setVisible(true);
						algosobj.querygen(textField.getText(),
								textField_1.getText(), textField_2.getText(),
								textField_3.getText(), textField_4.getText(),
								textField_5.getText(),
								(String) comboBox.getSelectedItem(),
								textField_7.getText());
						dispose();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// Display disp = new Display(
				// "Record has been Successfully Inserted");
				// disp.setVisible(true);
			}
		});
		contentPane.add(btnAdd);
		textField = new ObservingTextField();
		textField.setEditable(false);
		textField.setBounds(196, 19, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		JButton btnPurchasedate = new JButton("Purchase_Date");
		btnPurchasedate.setBounds(295, 17, 26, 24);
		btnPurchasedate.setBackground(UIManager
				.getColor("Button.disabledShadow"));
		btnPurchasedate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String lang = null;
				purchasealgo obj = new purchasealgo();
				final Locale locale = obj.getLocale(lang);
				DatePicker dp = new DatePicker(textField, locale);
				Date selectedDate = dp.parseDate(textField.getText());
				dp.setSelectedDate(selectedDate);
				dp.start(textField);
			}
		});
		contentPane.add(btnPurchasedate);
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(33, 25, 46, 14);
		contentPane.add(lblDate);
		JLabel lblNewLabel_6 = new JLabel("Category");
		lblNewLabel_6.setBounds(33, 258, 69, 20);
		contentPane.add(lblNewLabel_6);
		JLabel lblNewLabel_5 = new JLabel("UPC");
		lblNewLabel_5.setBounds(33, 294, 69, 20);
		contentPane.add(lblNewLabel_5);
		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setBounds(196, 291, 86, 26);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		JButton btnBarcodeReader = new JButton("BarCode Reader");
		btnBarcodeReader.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				NewLibTest obj = new NewLibTest();
				String value = obj.getbar();
				textField_7.setText(value);
			}
		});
		btnBarcodeReader.setBounds(309, 290, 115, 29);
		contentPane.add(btnBarcodeReader);
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "CS", "BBA",
				"HS", "EE" }));
		comboBox.setBounds(192, 255, 60, 26);
		contentPane.add(comboBox);
	}
}