package discard;
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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import algo.Discard_algo;
public class Insert_Discard extends JFrame {
	private JPanel contentPane;
	private JTextField t1;
	private JTextField t3;
	private JTextField t2;
	public String ISBN;
	public String ID;
	public String datee;
	public String reason;
	public String copy;
	public String edit;
	public String name;
	public String book;
	public String price;
	public String date;
	public static String[] ISBNN = new String[100];
	public Insert_Discard framea;
	private JTextField t5;
	private JTextField t6;
	private JTextField t7;
	private JTextField t8;
	private JTextField t9;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Insert_Discard frame = new Insert_Discard();
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
	public Insert_Discard() {
		framea = this;
		this.ID = ID;
		this.ISBN = ISBN;
		this.datee = datee;
		this.reason = reason;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 508, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblDiscardBook = new JLabel("Discard Book");
		lblDiscardBook.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDiscardBook.setBounds(150, 24, 122, 14);
		contentPane.add(lblDiscardBook);
		JLabel lblBookIsbn = new JLabel("Book ISBN");
		lblBookIsbn.setBounds(24, 83, 73, 29);
		contentPane.add(lblBookIsbn);
		t1 = new JTextField();
		t1.setBounds(107, 87, 86, 20);
		contentPane.add(t1);
		t1.setColumns(10);
		JLabel lblCopy = new JLabel("Copy Number");
		lblCopy.setBounds(24, 142, 73, 14);
		contentPane.add(lblCopy);
		t3 = new JTextField();
		t3.setBounds(107, 139, 86, 20);
		contentPane.add(t3);
		t3.setColumns(10);
		JLabel lblReasonOfDuscarding = new JLabel("Reason of Duscarding");
		lblReasonOfDuscarding.setBounds(216, 129, 111, 41);
		contentPane.add(lblReasonOfDuscarding);
		JLabel lblDiscardDate = new JLabel("Discard Date");
		lblDiscardDate.setBounds(246, 90, 68, 14);
		contentPane.add(lblDiscardDate);
		t2 = new JTextField();
		t2.setBounds(346, 87, 92, 20);
		contentPane.add(t2);
		t2.setColumns(10);
		final JComboBox t4 = new JComboBox();
		t4.setModel(new DefaultComboBoxModel(new String[] { "bad condition",
				"lost book by student" }));
		t4.setToolTipText("");
		t4.setBounds(346, 139, 114, 20);
		contentPane.add(t4);
		JButton btnNewButton = new JButton("..");
		btnNewButton.setBounds(436, 86, 24, 23);
		contentPane.add(btnNewButton);
		JButton btnDiscard = new JButton("Discard");
		btnDiscard.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				datee = t2.getText();
				ISBN = t1.getText();
				reason = (String) t4.getSelectedItem();
				copy = t3.getText();
				edit = t7.getText();
				name = t5.getText();
				book = t6.getText();
				price = t8.getText();
				date = t9.getText();
				System.out.println(datee);
				System.out.println(ISBN);
				System.out.println(copy);
				System.out.println(reason);
				Discard_algo budgetobj = new Discard_algo();
				budgetobj.Insert_frame(1, framea);
				Discard_algo budget = new Discard_algo();
				budget.Discard_frame(1, framea);
			}
		});
		btnDiscard.setBounds(138, 318, 89, 23);
		contentPane.add(btnDiscard);
		JButton btnCencel = new JButton("Cencel");
		btnCencel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCencel.setBounds(238, 318, 89, 23);
		contentPane.add(btnCencel);
		t5 = new JTextField();
		t5.setBounds(107, 187, 86, 20);
		contentPane.add(t5);
		t5.setColumns(10);
		JLabel lblAuthorname = new JLabel("Author_Name");
		lblAuthorname.setBounds(10, 190, 87, 14);
		contentPane.add(lblAuthorname);
		JLabel lblBooktitle = new JLabel("Book_Title");
		lblBooktitle.setBounds(246, 193, 68, 14);
		contentPane.add(lblBooktitle);
		t6 = new JTextField();
		t6.setBounds(346, 187, 86, 20);
		contentPane.add(t6);
		t6.setColumns(10);
		JLabel lblEdition = new JLabel("Edition");
		lblEdition.setBounds(24, 235, 46, 14);
		contentPane.add(lblEdition);
		t7 = new JTextField();
		t7.setBounds(107, 232, 86, 20);
		contentPane.add(t7);
		t7.setColumns(10);
		t8 = new JTextField();
		t8.setBounds(346, 232, 86, 20);
		contentPane.add(t8);
		t8.setColumns(10);
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(259, 235, 46, 14);
		contentPane.add(lblPrice);
		t9 = new JTextField();
		t9.setBounds(107, 273, 86, 20);
		contentPane.add(t9);
		t9.setColumns(10);
		JLabel lblPurchasedate = new JLabel("Purchase_Date");
		lblPurchasedate.setBounds(10, 276, 87, 14);
		contentPane.add(lblPurchasedate);
	}
}
