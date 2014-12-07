package gui.Budget;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import algo.DatePicker;
import algo.ObservingTextField;
import algo.budgetalgo;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Locale;
import javax.swing.UIManager;
import database.alg;
import java.awt.SystemColor;
import java.awt.Toolkit;
public class budgetupdate2 extends JFrame {
	private JPanel contentPane;
	private ObservingTextField t2;
	private JTextField t3;
	private JTextField t4;
	private JTextField t5;
	private JTextField t6;
	private JTable table;
	public budgetupdate2 framea;
	public String a;
	public String s;
	public String CS;
	public String EE;
	public String BBA;
	public String HR;
	public String req;
	public String asp;
	public String issue;
	public String type;
	public budgetupdate2 frame;
	public String id;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					budgetupdate2 frame = new budgetupdate2("");
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
	public budgetupdate2(String id) {
		// setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Naveed\\Desktop\\1011.png"));
		framea = this;
		frame = this;
		this.id = id;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 588, 361);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setTitle("Budget Update");
		contentPane.setLayout(new BorderLayout(0, 0));
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(SystemColor.menu);
		contentPane.add(panel);
		JLabel lblSpectedAmount = new JLabel("Aspected amount");
		lblSpectedAmount.setForeground(Color.BLACK);
		lblSpectedAmount.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSpectedAmount.setBounds(14, 131, 101, 14);
		panel.add(lblSpectedAmount);
		JLabel lblSemesterType = new JLabel("Semester Type");
		lblSemesterType.setForeground(Color.BLACK);
		lblSemesterType.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSemesterType.setBounds(318, 71, 116, 14);
		panel.add(lblSemesterType);
		JLabel lblIssued = new JLabel("Issued Amount");
		lblIssued.setForeground(Color.BLACK);
		lblIssued.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblIssued.setBounds(14, 186, 101, 14);
		panel.add(lblIssued);
		JLabel lblRequested = new JLabel("Requested Amount");
		lblRequested.setForeground(Color.BLACK);
		lblRequested.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblRequested.setBounds(315, 131, 119, 14);
		panel.add(lblRequested);
		t2 = new ObservingTextField();
		t2.setColumns(10);
		t2.setBounds(125, 67, 108, 24);
		panel.add(t2);
		alg a = new alg();
		a.fun37(t2);
		t3 = new JTextField();
		t3.setColumns(10);
		t3.setBounds(125, 127, 108, 24);
		panel.add(t3);
		a.fun38(t3);
		t4 = new JTextField();
		t4.setColumns(10);
		t4.setBounds(444, 67, 108, 24);
		panel.add(t4);
		a.fun39(t4);
		t5 = new JTextField();
		t5.setColumns(10);
		t5.setBounds(125, 182, 108, 24);
		panel.add(t5);
		a.fun40(t5);
		t6 = new JTextField();
		t6.setColumns(10);
		t6.setBounds(444, 127, 108, 24);
		panel.add(t6);
		a.fun41(t6);
		ResultSet rs = null;
		algo.budgetalgo alg = new algo.budgetalgo();
		try {
			rs = alg.querryupdatea(id);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			while (rs.next()) {
				t2.setText(rs.getString("Issue_Date"));
				t3.setText(rs.getString("Aspected_Amount"));
				t4.setText(rs.getString("Semester_Type"));
				t5.setText(rs.getString("Issued_Amount"));
				t6.setText(rs.getString("Requested_Amount"));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setForeground(new Color(255, 0, 0));
		btnCancel.setBackground(UIManager
				.getColor("InternalFrame.activeTitleBackground"));
		btnCancel.setBounds(289, 262, 101, 23);
		panel.add(btnCancel);
		table = new JTable();
		table.setBounds(312, 250, 1, 1);
		panel.add(table);
		JButton btnUpdate = new JButton("  Update");
		// btnUpdate.setIcon(new
		// ImageIcon("C:\\Users\\Naveed\\Desktop\\5555.png"));
		btnUpdate.addActionListener(new ActionListener() {
			// framea=this;
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// t1.setText(t2.getText());
				// ///for date
				s = t2.getText();
				CS = "0";
				EE = "0";
				BBA = "0";
				HR = "0";
				req = t6.getText();
				asp = t3.getText();
				issue = t5.getText();
				type = t4.getText();
				// System.out.println("gui started");
				algo.budgetalgo budgetobj = new algo.budgetalgo();
				budgetobj.Update(2, framea);
				updated_msg m = new updated_msg();
				m.setVisible(true);
				dispose();
			}
		});
		btnUpdate.setForeground(Color.BLACK);
		btnUpdate.setBackground(UIManager
				.getColor("InternalFrame.activeTitleBackground"));
		btnUpdate.setBounds(165, 262, 101, 23);
		panel.add(btnUpdate);
		// Image img=new ImageIcon
		// (this.getClass().getResource("/4.png")).getImage();
		JButton btnIssueDate = new JButton("");
		// btnIssueDate.setIcon(new
		// ImageIcon("C:\\Users\\Naveed\\Desktop\\6666.png"));
		btnIssueDate.setBackground(SystemColor.textHighlight);
		btnIssueDate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String lang = null;
				final Locale locale = getLocale(lang);
				DatePicker dp = new DatePicker(t2, locale);
				Date selectedDate = dp.parseDate(t2.getText());
				dp.setSelectedDate(selectedDate);
				dp.start(t2);
			}
			public Locale getLocale(String loc) {
				if (loc != null && loc.length() > 0) {
					return new Locale(loc);
				} else {
					return Locale.US;
				}
			}
		});
		btnIssueDate.setBounds(243, 67, 23, 24);
		panel.add(btnIssueDate);
		JLabel lblIssueDate = new JLabel("Issue Date");
		lblIssueDate.setBounds(26, 67, 63, 24);
		panel.add(lblIssueDate);
		JLabel label_1 = new JLabel("");
		label_1.setBounds(220, 0, 46, 49);
		// Image imge=new ImageIcon
		// (this.getClass().getResource("/1013.png")).getImage();
		// label_1.setIcon(new ImageIcon(imge));
		panel.add(label_1);
		JLabel label = new JLabel("Salary Budget");
		label.setFont(new Font("Tahoma", Font.BOLD, 16));
		label.setBounds(205, 0, 412, 36);
		panel.add(label);
	}
}
