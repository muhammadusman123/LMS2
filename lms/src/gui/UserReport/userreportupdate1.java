package gui.UserReport;
import gui.Payroll.Display1;
import gui.Payroll.payroll_update2;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import algo.payroll_algo;
import algo.userreportalgo;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.awt.Color;
import javax.swing.UIManager;
import database.alg;
public class userreportupdate1 extends JDialog {
	private final JPanel contentPanel = new JPanel();
	public int id;
	/**
	 * Launch the application.
	 */
	public st_database_GUI frame;
	private JTextField textField;
	/**
	 * Create the dialog.
	 */
	public userreportupdate1() {
		setBounds(100, 100, 437, 182);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(UIManager.getColor("Button.background"));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setTitle("Student Verification Window");
		JLabel lblStudentid = new JLabel("Student id");
		lblStudentid.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblStudentid.setBounds(63, 48, 86, 14);
		contentPanel.add(lblStudentid);
		textField = new JTextField();
		textField.setBounds(220, 46, 97, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		alg a = new alg();
		a.fun51(textField);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(UIManager.getColor("Button.background"));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setBackground(UIManager
						.getColor("Button.disabledShadow"));
				okButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						String msg;
						String s_id = textField.getText();
						boolean[] flag = new boolean[2];
						userreportalgo u_alg_obj = new userreportalgo();
						try {
							flag = u_alg_obj.is_id_field_empty(s_id, flag);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						if (flag[0] == false) {
							if (flag[1] == true) {
								id = Integer.parseInt(s_id);
								userreportupdate2 obj = new userreportupdate2(
										id);
								obj.setVisible(true);
								try {
									u_alg_obj.set_textfields_1(obj, id);
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								dispose();
							} else {
								dispose();
								msg = "Student id not found ";
								Display1 d_obj = new Display1(msg, 0);
								d_obj.setVisible(true);
							}
						} else {
							dispose();
							msg = "Student id field is empty";
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
				cancelButton.setForeground(new Color(255, 0, 0));
				cancelButton.setBackground(UIManager
						.getColor("Button.disabledShadow"));
				cancelButton.addActionListener(new ActionListener() {
					@Override
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
