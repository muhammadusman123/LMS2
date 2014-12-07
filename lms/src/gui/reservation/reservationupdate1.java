package gui.reservation;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.awt.Color;
import javax.swing.UIManager;
import database.alg;

public class reservationupdate1 extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public int id;

	/**
	 * Launch the application.
	 */
	public reservation_gui frame;
	private JTextField textField;
	/**
	 * Create the dialog.
	 */
	public reservationupdate1() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(UIManager.getColor("Button.background"));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setTitle("Reservation Update1 Form");
		JLabel lblStudentid = new JLabel("Student_id");
		lblStudentid.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblStudentid.setBounds(51, 83, 86, 14);
		contentPanel.add(lblStudentid);

		textField = new JTextField();
		textField.setBounds(219, 80, 86, 20);
		contentPanel.add(textField);
		alg a=new alg();
		a.fun45(textField);
		
		textField.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(UIManager.getColor("Button.background"));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setBackground(UIManager.getColor("Button.disabledShadow"));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {

						id=Integer.parseInt(textField.getText());
						reservationupdate2 obj=new reservationupdate2(id);
						obj.setVisible(true);
						try {
							obj.set(id);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						dispose();

					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setForeground(new Color(255, 0, 0));
				cancelButton.setBackground(UIManager.getColor("Button.disabledShadow"));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
