package algo;
import gui.Authentication.Display;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
public class DateCalculator implements DateFunctions {
	private Calendar Today, DateToCheck;
	public static int fine = 0;
	public DateCalculator(int date, int month, int year) {
		super();
		Today = Calendar.getInstance();
		DateToCheck = Calendar.getInstance();
		month--;
		DateToCheck.set(year, month, date);
	}
	@Override
	public long getDate() {
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		long diffInMillis = Today.getTimeInMillis()
				- DateToCheck.getTimeInMillis();
		return diffInMillis / (24 * 60 * 60 * 1000);
	}
	public boolean isLeap() {
		if (Today.get(Today.YEAR) % 4 == 0)
			return true;
		return false;
	}
	@Override
	public long getMonth() {
		long months = 0;
		long m1 = Today.get(Today.MONTH);
		long m2 = DateToCheck.get(DateToCheck.MONTH);
		m1 += (Today.get(Today.YEAR) * 12);
		m2 += (DateToCheck.get(DateToCheck.YEAR) * 12);
		months = m2 - m1;
		return months;
	}
	public void calculating(DateCalculator d) {
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		int date = (int) d.getDate();
		Display obj = new Display("");
		obj.setVisible(true);
		if (date <= 0) {
			Display obj1 = new Display("Fine is 0");
			obj1.setVisible(true);
		} else {
			fine = (int) ((d.getDate() * 10) + 10);
			Display obj1 = new Display("fine for late return "
					+ ((d.getDate() * 10) + 10));
			obj1.setVisible(true);
		}
	}
}
