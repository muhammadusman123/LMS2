package gui.Budget;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class Main_BUDGET extends JFrame {
	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Main_BUDGET frame = new Main_BUDGET();
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
	public Main_BUDGET() {
		setTitle("Budget");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 346);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblWelcomeToBudget = new JLabel("Welcome to Budget");
		lblWelcomeToBudget.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblWelcomeToBudget.setBounds(145, 24, 211, 23);
		contentPane.add(lblWelcomeToBudget);
		JButton btnSalaries = new JButton("Salaries");
		btnSalaries.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Salary_budget_main frame = new Salary_budget_main();
				frame.setVisible(true);
			}
		});
		btnSalaries.setBounds(45, 137, 139, 23);
		contentPane.add(btnSalaries);
		JButton btnBooks = new JButton("Book Purchase");
		btnBooks.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				budgetmain frame = new budgetmain();
				frame.setVisible(true);
			}
		});
		btnBooks.setBounds(224, 137, 139, 23);
		contentPane.add(btnBooks);
		JButton btnFerniture = new JButton("Ferniture&Equipment");
		btnFerniture.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				FurnutureEquip frame = new FurnutureEquip();
				frame.setVisible(true);
			}
		});
		btnFerniture.setBounds(45, 182, 139, 23);
		contentPane.add(btnFerniture);
		JButton btnBills = new JButton("Bills");
		btnBills.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Bills_main frame = new Bills_main();
				frame.setVisible(true);
			}
		});
		btnBills.setBounds(224, 182, 139, 23);
		contentPane.add(btnBills);
		JLabel lblBudgetCetacories = new JLabel("Budget Catecories");
		lblBudgetCetacories.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBudgetCetacories.setBounds(145, 78, 139, 23);
		contentPane.add(lblBudgetCetacories);
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnExit.setBounds(132, 236, 139, 23);
		contentPane.add(btnExit);
	}
}
