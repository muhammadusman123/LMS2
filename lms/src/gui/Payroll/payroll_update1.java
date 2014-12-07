package gui.Payroll;
import gui.UserReport.userreportupdate2;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import database.alg;
import algo.payroll_algo;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
public class payroll_update1 extends JDialog {
	private final JPanel contentPanel = new JPanel();
	public Payroll_main frame;
	public int id;
	private JTextField textField;
	/**
	 * Launch the application.
	 */
	/**
	 * Create the dialog.
	 */
	public payroll_update1() {
		setTitle("Employee Verification Window");
		setBounds(100, 100, 366, 134);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		JLabel lblEnterId = new JLabel("Enter id");
		lblEnterId.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEnterId.setBounds(24, 21, 55, 14);
		contentPanel.add(lblEnterId);
		textField = new JTextField();
		textField.setBounds(174, 19, 97, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		alg a = new alg();
		// a.emp_id(textField);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						String msg;
						String s_id = textField.getText();
						boolean[] flag = new boolean[2];
						payroll_algo p_alg_obj = new payroll_algo();
						try {
							flag = p_alg_obj.is_id_field_empty(s_id, flag);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						if (flag[0] == false) {
							if (flag[1] == true) {
								id = Integer.parseInt(s_id);
								payroll_update2 obj = new payroll_update2(id);
								obj.setVisible(true);
								try {
									p_alg_obj.set_textfields_2(obj, id);
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								dispose();
							} else {
								dispose();
								msg = "Employee id not found ";
								Display1 d_obj = new Display1(msg, 0);
								d_obj.setVisible(true);
							}
						} else {
							dispose();
							msg = "Employee id field is empty";
							Display1 d_obj = new Display1(msg, 0);
							d_obj.setVisible(true);
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					@Override
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
