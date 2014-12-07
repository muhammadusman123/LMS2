package gui.Budget;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Locale;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import algo.DatePicker;
import algo.ObservingTextField;
import algo.budgetalgo;
import javax.swing.UIManager;
import database.alg;
import java.awt.SystemColor;
import java.awt.Toolkit;
public class budgetinsertion extends JFrame {
	private JPanel contentPane;
	private ObservingTextField t2;
	private JTextField t3;
	private JTextField t4;
	private JTextField t5;
	private JTextField t6;
	public String a;
	// t1.setText(t2.getText());0
	// ///for date
	public String s;
	public String CS;
	public String EE;
	public String BBA;
	public String HR;
	private JTable table;
	public String id;
	public String req;
	public String asp;
	public String issue;
	public String type;
	public static String[] ID = new String[100];
	public budgetinsertion framea;
	private JTextField textField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					budgetinsertion frame = new budgetinsertion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */
	public budgetinsertion() {
		// setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Naveed\\Desktop\\1011.png"));
		framea = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 329);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Budget Insert Form");
		JLabel lblNewLabel_2 = new JLabel("Aspected Amount");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setBounds(289, 179, 108, 14);
		contentPane.add(lblNewLabel_2);
		JLabel lblNewLabel_3 = new JLabel("Semester Type");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setForeground(Color.BLACK);
		lblNewLabel_3.setBounds(16, 130, 96, 14);
		contentPane.add(lblNewLabel_3);
		JLabel lblNewLabel_4 = new JLabel("requested amount");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setForeground(Color.BLACK);
		lblNewLabel_4.setBounds(289, 130, 132, 14);
		contentPane.add(lblNewLabel_4);
		JLabel lblNewLabel_5 = new JLabel("Issue_amount");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5.setForeground(Color.BLACK);
		lblNewLabel_5.setBounds(25, 179, 87, 14);
		contentPane.add(lblNewLabel_5);
		t2 = new ObservingTextField();
		t2.setBounds(425, 71, 108, 24);
		contentPane.add(t2);
		t2.setColumns(10);
		alg a = new alg();
		a.fun37(t2);
		t3 = new JTextField();
		t3.setBounds(425, 175, 108, 24);
		contentPane.add(t3);
		t3.setColumns(10);
		a.fun38(t3);
		t4 = new JTextField();
		t4.setBounds(116, 126, 108, 24);
		contentPane.add(t4);
		t4.setColumns(10);
		a.fun39(t4);
		t5 = new JTextField();
		t5.setBounds(425, 126, 108, 24);
		contentPane.add(t5);
		t5.setColumns(10);
		a.fun40(t5);
		t6 = new JTextField();
		t6.setBounds(116, 175, 108, 24);
		contentPane.add(t6);
		t6.setColumns(10);
		a.fun41(t6);
		JButton btnAdd = new JButton("Insert");
		// btnAdd.setIcon(new
		// ImageIcon("C:\\Users\\Naveed\\Desktop\\1111.png"));
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// a=Integer.parseInt(t1.getText());
				// t1.setText(t2.getText());
				// ///for date
				// s=t2.getText();
				// CS=Integer.parseInt(t3.getText());
				// EE=Integer.parseInt(t4.getText());
				// BBA=Integer.parseInt(t5.getText());
				// HR=Integer.parseInt(t6.getText());
				// t1.setText(t2.getText());
				// ///for date
				CS = "25";
				EE = "25";
				BBA = "25";
				HR = "25";
				id = textField.getText();
				req = t5.getText();
				asp = t3.getText();
				issue = t6.getText();
				type = t4.getText();
				s = t2.getText();
				budgetalgo budgetobj = new budgetalgo();
				budgetobj.Insert_frame(1, framea);
				dispose();
				insert_msg i = new insert_msg();
				i.setVisible(true);
				// DB_CLASS d=new DB_CLASS
				// ((String) comboBox.getSelectedItem().toString(),(String)
				// comboBox_1.getSelectedItem().toString(),(String)
				// comboBox_2.getSelectedItem().toString(),(String)
				// comboBox_3.getSelectedItem().toString(),""+3*a/2);//passing
				// variable
			}
		});
		btnAdd.setForeground(Color.BLACK);
		btnAdd.setBackground(UIManager
				.getColor("InternalFrame.activeTitleBackground"));
		btnAdd.setBounds(213, 246, 89, 23);
		contentPane.add(btnAdd);
		JButton btnCencel = new JButton("Cancel");
		btnCencel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCencel.setBackground(UIManager
				.getColor("InternalFrame.activeTitleBackground"));
		btnCencel.setForeground(new Color(255, 0, 0));
		btnCencel.setBounds(331, 246, 89, 23);
		contentPane.add(btnCencel);
		table = new JTable();
		table.setBounds(312, 250, 1, 1);
		contentPane.add(table);
		// Image img=new ImageIcon
		// (this.getClass().getResource("/4.png")).getImage();
		JButton btnNewButton = new JButton("");
		// btnNewButton.setIcon(new
		// ImageIcon("C:\\Users\\Naveed\\Desktop\\6666.png"));
		btnNewButton.setBackground(SystemColor.textHighlight);
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String lang = null;
				final Locale locale = getLocale(lang);
				DatePicker dp = new DatePicker(t2, locale);// t2 txtfild for
															// date//locale
															// format of date of
															// our regin
				Date selectedDate = dp.parseDate(t2.getText());// casting in
																// Date type
				dp.setSelectedDate(selectedDate);// change colour
				dp.start(t2);
			}
			public Locale getLocale(String loc)// function in library
			{
				if (loc != null && loc.length() > 0) {
					return new Locale(loc);
				} else {
					return Locale.US;
				}
			}
		});
		btnNewButton.setBounds(543, 71, 27, 24);
		contentPane.add(btnNewButton);
		JLabel lblIssueDate = new JLabel("Issue Date");
		lblIssueDate.setBounds(304, 71, 73, 24);
		contentPane.add(lblIssueDate);
		JLabel label_1 = new JLabel("");
		label_1.setBounds(256, 0, 46, 55);
		// Image imge=new ImageIcon
		// (this.getClass().getResource("/1013.png")).getImage();
		// label_1.setIcon(new ImageIcon(imge));
		contentPane.add(label_1);
		JButton btnNewButton_1 = new JButton("Get");
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				id = textField.getText();
				int i = 0;
				algo.budgetalgo algosaaobj = new algo.budgetalgo();
				try {
					java.sql.ResultSet a;
					a = algosaaobj.selects();
					while (a.next()) {
						ID[i] = a.getString("ID");
						i++;
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				int checkit = 0;
				for (int j = 0; j < i; j++) {
					if (ID[j].equals(id)) {
						System.out.println("id" + id);
						System.out.println("ID" + ID[0]);
						checkit = 1;
						// dispose();
						ResultSet rs = null;
						algo.budgetalgo alg = new algo.budgetalgo();// ///payroll
																	// se yahan
																	// values
																	// dalwane...........
						try {
							System.out.println("hellllo");
							rs = alg.querryupdatea(id);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						System.out.println("hellllo");
						try {
							while (rs.next()) {
								System.out.println("hellllo");
								// t1.setText(rs.getString("CS"));
								t5.setText(rs.getString("BBA"));// /////requested
																// budget
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							System.out.println("hellllo");
							e1.printStackTrace();
						}
						// budgetupdate2 obj=new budgetupdate2(id);
						// obj.setVisible(true);
						// dispose();
						break;
					}
				}
				// budgetupdate2 obj=new budgetupdate2(id);
				// obj.setVisible(true);
				// dispose();
				if (checkit == 0) {
					update_failed_msg jj = new update_failed_msg();
					jj.setVisible(true);
				}
			}
		});
		btnNewButton_1.setBounds(543, 127, 65, 23);
		contentPane.add(btnNewButton_1);
		JButton btnGet = new JButton("Get");
		btnGet.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				double s;
				// String sss;
				budgetalgo a = new budgetalgo();
				s = a.Exponential_smoothing();
				String sss1 = new Double(s).toString();
				t3.setText(sss1);
			}
		});
		btnGet.setBounds(543, 176, 65, 23);
		contentPane.add(btnGet);
		JLabel lblIdyear = new JLabel("ID(Year)");
		lblIdyear.setBounds(25, 76, 46, 14);
		contentPane.add(lblIdyear);
		textField = new JTextField();
		textField.setBounds(116, 73, 108, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		JLabel lblDefaultput = new JLabel("Default(put 0)");
		lblDefaultput.setBounds(310, 143, 87, 14);
		contentPane.add(lblDefaultput);
		JLabel lblSalaryBudget = new JLabel("Salary Budget");
		lblSalaryBudget.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSalaryBudget.setBounds(237, 0, 412, 36);
		contentPane.add(lblSalaryBudget);
	}
}
