package View.Main;


public class Run {
	public static JF_Main main;
	public static JF_Login lg;

	public static void main(String[] args) {
		lg();

	}
	public static void QLCF(){
		main = new JF_Main();
        main.setVisible(true);       
    }  
    public static void lg(){
        lg = new JF_Login();
        lg.setVisible(true);       
    }

}
