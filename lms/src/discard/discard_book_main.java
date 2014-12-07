package discard;
import gui.Budget.budgetjtable;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
public class discard_book_main extends JFrame {
	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					discard_book_main frame = new discard_book_main();
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
	public discard_book_main() {
		// setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Naveed\\Desktop\\1011.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 394, 335);
		contentPane = new JPanel();
		contentPane.setForeground(UIManager
				.getColor("FormattedTextField.selectionForeground"));
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JButton btnNewButton = new JButton("Discard");
		// btnNewButton.setIcon(new
		// ImageIcon("C:\\Users\\Naveed\\Desktop\\1111.png"));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(UIManager
				.getColor("InternalFrame.inactiveTitleBackground"));
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Insert_Discard frame = new Insert_Discard();
				frame.setVisible(true);
			}
		});
		btnNewButton.setBounds(10, 111, 92, 25);
		contentPane.add(btnNewButton);
		JButton btnNewButton_1 = new JButton("  Update");
		// btnNewButton_1.setIcon(new
		// ImageIcon("C:\\Users\\Naveed\\Desktop\\5555.png"));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setBackground(UIManager.getColor("activeCaption"));
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Update_Discard frame = new Update_Discard("");
				frame.setVisible(true);
				// dispose();
			}
		});
		btnNewButton_1.setBounds(10, 147, 92, 25);
		contentPane.add(btnNewButton_1);
		setTitle("Welcome to Budgeting");
		JButton btnNewButton_2 = new JButton("  Report");
		// btnNewButton_2.setIcon(new
		// ImageIcon("C:\\Users\\Naveed\\Desktop\\4444.png"));
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_2.setForeground(Color.BLACK);
		btnNewButton_2.setBackground(UIManager.getColor("activeCaption"));
		btnNewButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					budgetjtable obj = new budgetjtable();
					// obj.setVisible(true);
					// obj.setVisible(true);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBounds(10, 183, 92, 25);
		contentPane.add(btnNewButton_2);
		JButton btnNewButton_3 = new JButton(" Exit");
		// btnNewButton_3.setIcon(new
		// ImageIcon("C:\\Users\\Naveed\\Desktop\\2222.png"));
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				// MainPage obj=new MainPage();
				// obj.setVisible(true);
			}
		});
		btnNewButton_3.setForeground(new Color(255, 0, 0));
		btnNewButton_3.setBackground(UIManager.getColor("activeCaption"));
		btnNewButton_3.setBounds(10, 220, 92, 25);
		contentPane.add(btnNewButton_3);
		JLabel label = new JLabel("");
		label.setForeground(Color.LIGHT_GRAY);
		label.setBackground(Color.LIGHT_GRAY);
		label.setBounds(253, -61, 157, 262);
		// Image img=new ImageIcon
		// (this.getClass().getResource("/1011.png")).getImage();
		// label.setIcon(new ImageIcon(img));
		contentPane.add(label);
		JLabel lblDiscardingOfBooks = new JLabel("Discarding of Books");
		lblDiscardingOfBooks.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDiscardingOfBooks.setBounds(105, 30, 169, 14);
		contentPane.add(lblDiscardingOfBooks);
	}
}
