package View.Main;

import Models.*;

public class Run {
	public static JF_Main main;
	public static JF_Login lg;
	public static TaiKhoan tk;

	public static void main(String[] args) {
		runLogin();

	}

	public static void runMain() {
		main = new JF_Main();
		main.ShowMain();
		main.setVisible(true);
	}

	public static void runLogin() {
		lg = new JF_Login();
		lg.showW();
		lg.setVisible(true);
	}

}
