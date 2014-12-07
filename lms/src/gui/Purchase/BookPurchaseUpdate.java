package gui.Purchase;
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
import algo.purchasealgo;
import algo.textvalidation;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
public class BookPurchaseUpdate extends JDialog {
	private final JPanel contentPanel = new JPanel();
	public JTextField textField;
	public JTextField textField_1;
	public JTextField textField_2;
	public String name, bookname;
	public int bookid;
	public BookPurchaseUpdate frameab;
	public JTextField textField_3;
	public JTextField textField_4;
	public ObservingTextField textField_5;
	public JTextField textField_7;
	public JComboBox comboBox;
	public BookPurchaseUpdate(final String id) {
		setResizable(false);
		frameab = this;
		setBounds(100, 100, 450, 395);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(UIManager.getColor("Button.background"));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setTitle("Purchase Update2 Form");
		contentPanel.setLayout(null);
		JLabel lblNobooks = new JLabel("BookName");
		lblNobooks.setBounds(24, 141, 77, 14);
		lblNobooks.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPanel.add(lblNobooks);
		JLabel lblStudentname = new JLabel("ISBN");
		lblStudentname.setBounds(24, 62, 134, 14);
		lblStudentname.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPanel.add(lblStudentname);
		JLabel lblBook = new JLabel("AuthorName");
		lblBook.setBounds(24, 107, 106, 14);
		lblBook.setFont(new Font("Tahoma", Font.PLAIN, 12));
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
				if (textField.getText().length() == 10) {
					e.consume();
				}
			}
		});
		textField.setBounds(212, 59, 115, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		alg a = new alg();
		// a.fun31(textField);
		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					getToolkit().beep();
					Display obj = new Display("Integer Input Not Valid");
					obj.setVisible(true);
					e.consume();
				}
				if (textField_1.getText().length() == 25) {
					e.consume();
				}
			}
		});
		textField_1.setBounds(212, 104, 115, 20);
		contentPanel.add(textField_1);
		textField_1.setColumns(10);
		// a.fun32(textField_1);
		textField_2 = new JTextField();
		textField_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					getToolkit().beep();
					Display obj = new Display("Integer Input Not Valid");
					obj.setVisible(true);
					e.consume();
				}
				if (textField_2.getText().length() == 25) {
					e.consume();
				}
			}
		});
		textField_2.setBounds(212, 135, 115, 20);
		contentPanel.add(textField_2);
		textField_2.setColumns(10);
		// a.fun33(textField_2);
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
		textField_3.setBounds(212, 166, 115, 20);
		contentPanel.add(textField_3);
		textField_3.setColumns(10);
		// a.fun34(textField_3);
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
				if (textField_4.getText().length() == 2) {
					e.consume();
				}
			}
		});
		textField_4.setBounds(212, 197, 115, 20);
		contentPanel.add(textField_4);
		textField_4.setColumns(10);
		JLabel lblNewLabel = new JLabel("Price");
		lblNewLabel.setBounds(24, 166, 69, 20);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPanel.add(lblNewLabel);
		JLabel lblNewLabel_1 = new JLabel("Edition");
		lblNewLabel_1.setBounds(24, 197, 69, 20);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPanel.add(lblNewLabel_1);
		textField_5 = new ObservingTextField();
		textField_5.setEditable(false);
		textField_5.setBounds(213, 17, 115, 20);
		contentPanel.add(textField_5);
		textField_5.setColumns(10);
		JButton btnPurchaseDate = new JButton("Purchase Date");
		btnPurchaseDate.setBounds(332, 17, 30, 20);
		btnPurchaseDate.setBackground(UIManager
				.getColor("Button.disabledShadow"));
		btnPurchaseDate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String lang = null;
				purchasealgo obj = new purchasealgo();
				final Locale locale = obj.getLocale(lang);
				DatePicker dp = new DatePicker(textField_5, locale);
				Date selectedDate = dp.parseDate(textField_5.getText());
				dp.setSelectedDate(selectedDate);
				dp.start(textField_5);
			}
		});
		contentPanel.add(btnPurchaseDate);
		JLabel lblNewLabel_2 = new JLabel("Date");
		lblNewLabel_2.setBounds(24, 16, 106, 14);
		contentPanel.add(lblNewLabel_2);
		JLabel lblCategory = new JLabel("Category");
		lblCategory.setBounds(24, 233, 69, 20);
		contentPanel.add(lblCategory);
		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setBounds(216, 258, 111, 26);
		contentPanel.add(textField_7);
		textField_7.setColumns(10);
		JLabel lblUpc = new JLabel("UPC");
		lblUpc.setBounds(24, 269, 69, 20);
		contentPanel.add(lblUpc);
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "CS", "BBA",
				"HS", "EE" }));
		comboBox.setBounds(212, 233, 66, 26);
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
							Display obj = new Display("ISBN not Entered");
							obj.setVisible(true);
						} else if (valobj.fun(textField_1.getText())) {
							Display obj = new Display("Author Name not Entered");
							obj.setVisible(true);
						} else if (valobj.fun(textField_2.getText())) {
							Display obj = new Display("Book Name not Entered");
							obj.setVisible(true);
						} else if (valobj.fun(textField_3.getText())) {
							Display obj = new Display("Price not Entered");
							obj.setVisible(true);
						} else if (valobj.fun(textField_4.getText())) {
							Display obj = new Display("Edition not Entered");
							obj.setVisible(true);
						} else if (valobj.fun(textField_5.getText())) {
							Display obj = new Display("Date not Entered");
							obj.setVisible(true);
						} else if (valobj.fun((String) comboBox
								.getSelectedItem())) {
							Display obj = new Display("Category not Entered");
							obj.setVisible(true);
						} else if (valobj.fun(textField_7.getText())) {
							Display obj = new Display("UPC not Entered");
							obj.setVisible(true);
						} else {
							algo.purchasealgo obj = new algo.purchasealgo();
							obj.querryupdateb(id, textField.getText(),
									textField_1.getText(),
									textField_2.getText(),
									textField_3.getText(),
									textField_4.getText(),
									textField_5.getText(),
									(String) comboBox.getSelectedItem(),
									textField_7.getText());
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