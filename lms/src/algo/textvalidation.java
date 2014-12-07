package algo;
import gui.Authentication.Display;
public class textvalidation {
	public boolean fun(String s) {
		if (s.equals("")) {
			System.out.println("USman is  null");
			return true;
		} else {
			System.out.println("USman is not null");
			return false;
		}
	}
	public void intorstring(String s) {
		try {
			Integer.parseInt(s);
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			// e1.printStackTrace();
			Display obj = new Display("Value not Integer");
			obj.setVisible(true);
		}
	}
}
