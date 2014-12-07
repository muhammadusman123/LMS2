package gui.Budget;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import database.alg;
import algo.ObservingTextField;
import algo.Salary_algo;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Inset_Salary_budget extends JFrame {
	private JPanel contentPane;
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;
	private ObservingTextField t4;
	public String s;
	public String amount;
	public String Spent;
	public String type;
	public static String[] ID = new String[100];
	public static String[] Sem = new String[100];
	private JTable table;
	public Inset_Salary_budget framea;
	private JTextField t6;
	private JTextField t5;
	public String id;
	private JTextField textField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Inset_Salary_budget frame = new Inset_Salary_budget();
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
	public Inset_Salary_budget() {
		framea = this;
		this.id = id;
		setTitle("Salaries Budget ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 497, 436);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblNumberOfEmployees = new JLabel("Total of Salaries");
		lblNumberOfEmployees.setBounds(10, 162, 124, 14);
		contentPane.add(lblNumberOfEmployees);
		t1 = new JTextField();
		t1.setBounds(116, 159, 86, 20);
		contentPane.add(t1);
		t1.setColumns(10);
		JButton btnPress = new JButton("Get");
		btnPress.addActionListener(new ActionListener() {
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
								t1.setText(rs.getString("CS"));
								// t6.setText(rs.getString("BBA"));
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
		btnPress.setBounds(212, 158, 55, 23);
		contentPane.add(btnPress);
		JLabel lblAmount = new JLabel("Issue Salary Budget");
		lblAmount.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAmount.setBounds(116, 11, 412, 36);
		contentPane.add(lblAmount);
		JLabel lblAmount_1 = new JLabel("Issue Amount");
		lblAmount_1.setBounds(10, 267, 86, 14);
		contentPane.add(lblAmount_1);
		t2 = new JTextField();
		t2.setBounds(116, 264, 86, 20);
		contentPane.add(t2);
		t2.setColumns(10);
		// alg a=new alg();
		// a.fun53(t2);
		JLabel lblIssueDate = new JLabel("Issue Date");
		lblIssueDate.setBounds(270, 267, 74, 14);
		contentPane.add(lblIssueDate);
		t3 = new JTextField();
		t3.setBounds(360, 264, 86, 20);
		contentPane.add(t3);
		t3.setColumns(10);
		textField = new JTextField();
		textField.setBounds(116, 108, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		t6 = new JTextField();
		t6.setBounds(116, 209, 86, 20);
		contentPane.add(t6);
		t6.setColumns(10);
		t5 = new JTextField();
		t5.setBounds(360, 108, 86, 20);
		contentPane.add(t5);
		t5.setColumns(10);
		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				s = t3.getText();
				amount = t2.getText();
				type = t5.getText();
				id = textField.getText();
				Salary_algo salaryobj = new Salary_algo();
				salaryobj.Insert_frame(1, framea);
				dispose();
				insert_msg i = new insert_msg();
				i.setVisible(true);
			}
		});
		btnInsert.setBounds(113, 331, 89, 23);
		contentPane.add(btnInsert);
		JButton btnCencel = new JButton("Cencel");
		btnCencel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCencel.setBounds(220, 331, 89, 23);
		contentPane.add(btnCencel);
		JButton btnNewButton = new JButton("..");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(444, 263, 27, 23);
		contentPane.add(btnNewButton);
		JLabel lblRequestedAmount = new JLabel("Requested Amount");
		lblRequestedAmount.setBounds(10, 212, 96, 14);
		contentPane.add(lblRequestedAmount);
		JButton btnGet = new JButton("Get");
		btnGet.addActionListener(new ActionListener() {
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
								t6.setText(rs.getString("BBA"));
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
		btnGet.setBounds(212, 208, 55, 23);
		contentPane.add(btnGet);
		JLabel lblSemesterType = new JLabel("Semester Type");
		lblSemesterType.setBounds(270, 111, 93, 14);
		contentPane.add(lblSemesterType);
		JLabel lblEnterId = new JLabel("Enter Year");
		lblEnterId.setBounds(10, 111, 74, 14);
		contentPane.add(lblEnterId);
	}
}
