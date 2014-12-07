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
import algo.ObservingTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Update_Salary_Budget extends JFrame {
	private JPanel contentPane;
	private JTextField t1;
	private JTextField t2;
	private ObservingTextField t3;
	public String s;
	public String amount;
	public String id;
	private JTable table;
	public Update_Salary_Budget framea;
	public Update_Salary_Budget frame;
	private JTextField t6;
	public static String[] ID = new String[100];
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Update_Salary_Budget frame = new Update_Salary_Budget("");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 * 
	 * @param id
	 */
	public Update_Salary_Budget(final String id) {
		framea = this;
		frame = this;
		this.id = id;
		setTitle("Salaries Budget ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 515, 408);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblNumberOfEmployees = new JLabel("Total of Salaries");
		lblNumberOfEmployees.setBounds(10, 108, 124, 14);
		contentPane.add(lblNumberOfEmployees);
		t1 = new JTextField();
		t1.setBounds(132, 105, 86, 20);
		contentPane.add(t1);
		t1.setColumns(10);
		JButton btnPress = new JButton("Get");
		btnPress.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// id=textField.getText();
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
		btnPress.setBounds(228, 104, 59, 23);
		contentPane.add(btnPress);
		JLabel lblAmount = new JLabel("Update Salary Budget");
		lblAmount.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAmount.setBounds(81, 0, 412, 36);
		contentPane.add(lblAmount);
		JLabel lblIssueDate = new JLabel("Issue Date");
		lblIssueDate.setBounds(309, 210, 74, 14);
		contentPane.add(lblIssueDate);
		t3 = new ObservingTextField();
		t3.setBounds(382, 207, 86, 20);
		contentPane.add(t3);
		t3.setColumns(10);
		t2 = new JTextField();
		t2.setBounds(132, 207, 86, 20);
		contentPane.add(t2);
		t2.setColumns(10);
		ResultSet rs = null;
		algo.Salary_algo alg = new algo.Salary_algo();
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
				t2.setText(rs.getString("Allocated"));
				t3.setText(rs.getString("Issue_Date"));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			System.out.println("hellllo");
			e1.printStackTrace();
		}
		JButton btnInsert = new JButton("Update");
		btnInsert.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				s = t3.getText();
				amount = t2.getText();
				// System.out.println("gui started");
				algo.Salary_algo budgetobj = new algo.Salary_algo();
				budgetobj.Update(1, framea);
				updated_msg m = new updated_msg();
				m.setVisible(true);
				dispose();
			}
		});
		btnInsert.setBounds(132, 291, 89, 23);
		contentPane.add(btnInsert);
		JButton btnCencel = new JButton("Cencel");
		btnCencel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCencel.setBounds(231, 291, 89, 23);
		contentPane.add(btnCencel);
		JButton btnNewButton = new JButton("..");
		btnNewButton.setBounds(466, 206, 27, 23);
		contentPane.add(btnNewButton);
		JLabel lblAmount_2 = new JLabel("Amount");
		lblAmount_2.setBounds(35, 210, 46, 14);
		contentPane.add(lblAmount_2);
		t6 = new JTextField();
		t6.setBounds(132, 147, 86, 20);
		contentPane.add(t6);
		t6.setColumns(10);
		JLabel lblRequested = new JLabel("Requested");
		lblRequested.setBounds(25, 150, 86, 14);
		contentPane.add(lblRequested);
		JButton btnGet = new JButton("Get");
		btnGet.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
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
		btnGet.setBounds(228, 146, 59, 23);
		contentPane.add(btnGet);
	}
}
