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
import algo.DatePicker;
import algo.ObservingTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.util.Date;
import java.util.Locale;
import javax.swing.UIManager;
import database.alg;
import java.awt.Font;
public class reservationinsertion extends JDialog {
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	public String name, book;
	public int id, bookid;
	public reservation_gui frame;
	private ObservingTextField textField_3;
	/**
	 * Launch the application.
	 */
	/**
	 * Create the dialog.
	 */
	public reservationinsertion() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(UIManager.getColor("Button.background"));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setTitle("Reservation Insert Form");
		JLabel lblStudentname = new JLabel("Student_name");
		lblStudentname.setBackground(Color.GRAY);
		lblStudentname.setBounds(47, 97, 117, 14);
		contentPanel.add(lblStudentname);
		JLabel lblBook = new JLabel("Book-name");
		lblBook.setBackground(Color.GRAY);
		lblBook.setBounds(47, 141, 117, 14);
		contentPanel.add(lblBook);
		JLabel lblBook_1 = new JLabel("Book_id");
		lblBook_1.setBackground(Color.GRAY);
		lblBook_1.setBounds(49, 187, 87, 14);
		contentPanel.add(lblBook_1);
		textField = new JTextField();
		textField.setBounds(196, 94, 125, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		alg a = new alg();
		// a.fun42(textField);
		textField_1 = new JTextField();
		textField_1.setBounds(196, 138, 125, 20);
		contentPanel.add(textField_1);
		textField_1.setColumns(10);
		// a.fun43(textField_1);
		textField_2 = new JTextField();
		textField_2.setBounds(196, 184, 125, 20);
		contentPanel.add(textField_2);
		textField_2.setColumns(10);
		// a.fun44(textField_2);
		JButton btnReservationDate = new JButton("...");
		btnReservationDate.setBackground(UIManager
				.getColor("Button.disabledShadow"));
		btnReservationDate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String lang = null;
				final Locale locale = getLocale(lang);
				DatePicker dp = new DatePicker(textField_3, locale);
				Date selectedDate = dp.parseDate(textField_3.getText());
				dp.setSelectedDate(selectedDate);
				dp.start(textField_3);
			}
			public Locale getLocale(String loc) {
				if (loc != null && loc.length() > 0) {
					return new Locale(loc);
				} else {
					return Locale.US;
				}
			}
		});
		btnReservationDate.setBounds(320, 34, 34, 29);
		contentPanel.add(btnReservationDate);
		textField_3 = new ObservingTextField();
		textField_3.setBounds(196, 38, 125, 20);
		contentPanel.add(textField_3);
		textField_3.setColumns(10);
		JLabel label = new JLabel("Date");
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label.setBounds(47, 49, 46, 14);
		contentPanel.add(label);
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
						name = textField.getText();
						book = textField_1.getText();
						bookid = Integer.parseInt(textField_2.getText());
						// id=Integer.parseInt(textField_3.getText());
						algo.reservationalgo obj = new algo.reservationalgo();
						obj.Insert(name, book, bookid, textField_3.getText());
						Display disp = new Display(
								"Record has been Successfully Inserted");
						disp.setVisible(true);
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
