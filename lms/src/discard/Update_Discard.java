package discard;
import gui.Budget.update_failed_msg;
import gui.Purchase.bookPurchase;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import algo.Discard_algo;
import algo.purchasealgo;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Update_Discard extends JFrame {
	private JPanel contentPane;
	private JTextField t1;
	private JTextField t3;
	private JTextField t2;
	public String ISBN;
	public String IIISBN;
	public String ID;
	public String datee;
	public String reason;
	public String copy;
	public String edit;
	public String name;
	public String book;
	public String price;
	public String date;
	public Update_Discard framea;
	public bookPurchase frame;
	public static String[] ISBNN = new String[100];
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Update_Discard frame = new Update_Discard("");
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
	 * @param ISBN
	 */
	public Update_Discard(String ISBNNI) {
		framea = this;
		this.ISBN = ISBNNI;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 347);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblUpdateDiscard = new JLabel("Update Discard");
		lblUpdateDiscard.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUpdateDiscard.setBounds(136, 21, 183, 14);
		contentPane.add(lblUpdateDiscard);
		JLabel lblBookIsbn = new JLabel("Book ISBN");
		lblBookIsbn.setBounds(54, 82, 70, 14);
		contentPane.add(lblBookIsbn);
		JLabel lblCopyNumber = new JLabel("Copy Number");
		lblCopyNumber.setBounds(58, 120, 114, 14);
		contentPane.add(lblCopyNumber);
		t1 = new JTextField();
		t1.setBounds(152, 79, 86, 20);
		contentPane.add(t1);
		t1.setColumns(10);
		t3 = new JTextField();
		t3.setBounds(152, 117, 86, 20);
		contentPane.add(t3);
		t3.setColumns(10);
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(260, 82, 46, 14);
		contentPane.add(lblDate);
		t2 = new JTextField();
		t2.setBounds(300, 79, 86, 20);
		contentPane.add(t2);
		t2.setColumns(10);
		JButton button = new JButton("...");
		button.setBounds(386, 78, 23, 23);
		contentPane.add(button);
		JButton btnUpdate = new JButton("Update");// ////////////////////////remaining
													// to insert in book table
		btnUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// ISBN = t1.getText();
				int i = 0;
				Discard_algo algosaaobj = new Discard_algo();
				try {
					java.sql.ResultSet a;
					a = algosaaobj.select();
					while (a.next()) {
						ISBNN[i] = a.getString("ID");
						i++;
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				int checkit = 0;
				for (int j = 0; j < i; j++) {
					if (ISBNN[j].equals(ISBN)) {
						System.out.println("id" + ISBN);
						System.out.println("ID" + ISBNN[0]);
						checkit = 1;
						ResultSet rs = null;
						Discard_algo alg = new algo.Discard_algo();
						try {
							rs = alg.querry(ISBN);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						try {
							while (rs.next()) {// frame.ISBN=rs.getString("IISBN");
								IIISBN = rs.getString("IISBN");
								// frame.name=rs.getString("Author_Name");
								name = rs.getString("Author_Name");
								// frame.book=rs.getString("Book_Title");
								book = rs.getString("Book_Title");
								// frame.edit=rs.getString("Edition");
								edit = rs.getString("Edition");
								// frame.price=rs.getString("Price");
								price = rs.getString("Price");
								// frame.date=rs.getString("Purchase_Date");
								date = rs.getString("Purchase_Date");
								System.out.println(IIISBN);
								System.out.println(name);
								// purchasealgo a=new purchasealgo();
								// a.Insert_frame(1, frame);
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						// dispose();
						// budgetupdate2 obj=new budgetupdate2(ISBN);
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
		btnUpdate.setBounds(122, 275, 89, 23);
		contentPane.add(btnUpdate);
		JButton btnCencel = new JButton("Cencel");
		btnCencel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCencel.setBounds(217, 275, 89, 23);
		contentPane.add(btnCencel);
	}
}
