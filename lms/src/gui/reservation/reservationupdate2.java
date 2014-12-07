package gui.reservation;

import gui.Authentication.Display;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;







import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Locale;
import javax.swing.UIManager;
import database.alg;
import algo.DatePicker;
import algo.ObservingTextField;
import java.awt.Font;

public class reservationupdate2 extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	public String name,bookname;
	public int bookid;
	public reservation_gui frame;
	private ObservingTextField textField_2;
	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 */
	public reservationupdate2(final int id) {

		setBounds(100, 100, 450, 360);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(UIManager.getColor("Button.background"));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setTitle("Reservation Update2 Form");
		JLabel lblNobooks = new JLabel("Book_id");
		lblNobooks.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNobooks.setBounds(29, 202, 86, 14);
		contentPanel.add(lblNobooks);

		JLabel lblStudentname = new JLabel("Student_name");
		lblStudentname.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblStudentname.setBounds(29, 99, 147, 14);
		contentPanel.add(lblStudentname);

		JLabel lblBook = new JLabel("Book_name");
		lblBook.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblBook.setBounds(29, 153, 100, 14);
		contentPanel.add(lblBook);

		textField = new JTextField();
		textField.setBounds(212, 96, 109, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		alg a=new alg();
		a.fun42(textField);

		textField_1 = new JTextField();
		textField_1.setBounds(212, 150, 109, 20);
		contentPanel.add(textField_1);
		textField_1.setColumns(10);
		a.fun43(textField_1);
		
		textField_3 = new JTextField();
		textField_3.setBounds(212, 200, 109, 20);
		contentPanel.add(textField_3);
		textField_3.setColumns(10);
		a.fun44(textField_3);
		
		textField_2 = new ObservingTextField();
		textField_2.setBounds(212, 27, 109, 20);
		contentPanel.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnReservationDate = new JButton("...");
		btnReservationDate.setBackground(UIManager.getColor("Button.disabledShadow"));
		btnReservationDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		

				String lang=null;
				final Locale locale = getLocale(lang);
				DatePicker dp=new DatePicker(textField_2,locale);
				Date selectedDate=dp.parseDate(textField_2.getText());
				dp.setSelectedDate(selectedDate);
				dp.start(textField_2);
				
			}
			public Locale getLocale(String loc)
			{
				if(loc!=null && loc.length()>0)
				{
					return new Locale(loc);
				
				}
				else
				{
					return Locale.US;
				}
			
				
				
			}
		});
		btnReservationDate.setBounds(320, 27, 28, 29);
		contentPanel.add(btnReservationDate);
		
		JLabel label = new JLabel("Date");
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label.setBounds(34, 33, 46, 14);
		contentPanel.add(label);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(UIManager.getColor("Button.background"));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {

						name=textField.getText();
						bookname=textField_1.getText();

						bookid=Integer.parseInt(textField_3.getText());
						algo.reservationalgo obj = new algo.reservationalgo();
						obj.Update(id,name,bookname,bookid,textField_2.getText());

Display disp=new Display("Record has been Successfully Updated");
disp.setVisible(true);
						dispose();


					}
				});
				okButton.setBackground(UIManager.getColor("Button.disabledShadow"));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setForeground(new Color(255, 0, 0));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {

						dispose();
					}
				});
				cancelButton.setBackground(UIManager.getColor("Button.disabledShadow"));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public void set(int id) throws SQLException
	{
		String c;
		ResultSet rs;
		algo.reservationalgo alg=new algo.reservationalgo();
		rs=alg.update_field(id);
		while(rs.next())
		{
			textField.setText(rs.getString("Student_name"));
			textField_1.setText(rs.getString("Book_name"));
			c=Integer.toString(rs.getInt("Book_id"));
			textField_3.setText(c);
			textField_2.setText(rs.getString("Reservation_Date"));
			
		}
	}

}
