package View.Main;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.Window.Type;
import java.awt.Dialog.ModalExclusionType;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JF_Login extends JFrame {
	private JTextField textField, passwordField;
	private JButton btnDangNhap, btnThoat;

	public static void main(String[] args) {
		new JF_Login().showW();
	}

	private void showW() {
		
		this.setTitle("Đăng nhập ứng dụng");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(350, 180);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
	}

	public JF_Login() {
		setResizable(false);
		addcontrols();
		addevents();
		this.setType(Type.UTILITY);
		this.setUndecorated(true);
	}

	private void addevents() {
		btnDangNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new JF_Main().ShowMain();
//				setVisible(false);
//				Run.QLCF();
			}
		});

		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

	}

	private void addcontrols() {
		getContentPane().setFont(new Font("Arial", Font.PLAIN, 15));
		setBounds(100, 100, 359, 220);
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));

		JPanel pnMain = new JPanel();
		getContentPane().add(pnMain);
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.LINE_AXIS));

		JPanel pnConMain = new JPanel();
		pnConMain.setBorder(new EmptyBorder(20, 20, 20, 20));
		pnMain.add(pnConMain);
		pnConMain.setLayout(new BoxLayout(pnConMain, BoxLayout.Y_AXIS));

		JPanel pnTop = new JPanel();
		pnConMain.add(pnTop);
		pnTop.setLayout(new BoxLayout(pnTop, BoxLayout.X_AXIS));

		JLabel lblDangNhap = new JLabel("ĐĂNG NHẬP");
		lblDangNhap.setFont(new Font("Arial", Font.PLAIN, 30));
		pnTop.add(lblDangNhap);

		JPanel pnCenter = new JPanel();
		pnCenter.setBorder(new EmptyBorder(0, 0, 20, 0));
		pnConMain.add(pnCenter);
		pnCenter.setLayout(new GridLayout(2, 2, 2, 2));

		JLabel lblTaikhoan = new JLabel("Tài khoản");
		pnCenter.add(lblTaikhoan);

		textField = new JTextField();
		pnCenter.add(textField);
		textField.setColumns(10);

		JLabel lblmatkhau = new JLabel("Mật khẩu");
		pnCenter.add(lblmatkhau);

		passwordField = new JPasswordField();
		pnCenter.add(passwordField);

		JPanel pnBot = new JPanel();
		pnConMain.add(pnBot);
		pnBot.setLayout(new GridLayout(0, 2, 30, 0));

		btnDangNhap = new JButton("Đăng Nhập");
		pnBot.add(btnDangNhap);

		btnThoat = new JButton("Thoát");
		pnBot.add(btnThoat);

	}

}