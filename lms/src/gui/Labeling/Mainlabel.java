package gui.Labeling;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import algo.Algorithim;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
public class Mainlabel extends JFrame {
	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Mainlabel frame = new Mainlabel("Library managment System");
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
	public Mainlabel(String a) {
		super(a);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JButton btnNewButton = new JButton("CS ");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Algorithim a = new Algorithim();
				try {
					// a.totalpurchase(Integer.parseInt(textField.getText()));
					a.total1("CS");
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(47, 11, 112, 23);
		contentPane.add(btnNewButton);
		JButton btnNewButton_1 = new JButton("BBA");
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Algorithim a = new Algorithim();
				try {
					// a.totalpurchase(Integer.parseInt(textField.getText()));
					a.total1("BBA");
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(47, 45, 112, 23);
		contentPane.add(btnNewButton_1);
		JButton btnNewButton_2 = new JButton("EE");
		btnNewButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Algorithim a = new Algorithim();
				try {
					// a.totalpurchase(Integer.parseInt(textField.getText()));
					a.total1("EE");
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBounds(47, 79, 112, 23);
		contentPane.add(btnNewButton_2);
		JButton btnNewButton_3 = new JButton("HR");
		btnNewButton_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Algorithim a = new Algorithim();
				try {
					// a.totalpurchase(Integer.parseInt(textField.getText()));
					a.total1("HR");
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton_3.setBounds(47, 113, 112, 23);
		contentPane.add(btnNewButton_3);
	}
}
