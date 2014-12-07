package gui.UserReport;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;

import algo.payroll_algo;
import algo.userreportalgo;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class userreport_deletion extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
    public int id;
    public String name;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			userreport_deletion dialog = new userreport_deletion();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public userreport_deletion() {
		setTitle("Student Deletion Window");
		setBounds(100, 100, 450, 187);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblStudentName = new JLabel("Student name");
		lblStudentName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblStudentName.setBounds(42, 71, 92, 14);
		contentPanel.add(lblStudentName);
		
		JLabel lblStudentId = new JLabel("Student id");
		lblStudentId.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblStudentId.setBounds(42, 24, 79, 14);
		contentPanel.add(lblStudentId);
		
		textField = new JTextField();
		textField.setBounds(254, 22, 86, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(254, 69, 140, 20);
		contentPanel.add(textField_1);
		textField_1.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String s_id;
						s_id=textField.getText();
						name=textField_1.getText();
						userreportalgo obj=new userreportalgo();
						try {
							obj.Delete(s_id,name);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
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
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
