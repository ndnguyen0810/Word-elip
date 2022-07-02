package View.Main;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
//import Jpane nè
import View.BanHang.*;
import View.CaiDat.*;
import View.QuanLy.*;
import View.ThongKe.*;

import java.awt.event.*;
import java.awt.Window.Type;

public class JF_Main extends JFrame {
	private JButton btnDangXuat, btnTrangChu, btnBanHang, btnThongKe, btnCaiDat, btnQuanLy;
//theo thứ tự 1 -2-3	
	JP_Home home;
	JP_BanHang banhang;
	JP_QuanLy quanly;
	JP_ThongKe thongke;
	JP_CaiDat caidat;
	
//không gồm này
	
	JPanel pnMainChinh;

	public void reloadPanel(int i) {
		pnMainChinh.removeAll();
		switch (i) {
		case 1:
			if (home == null) {
				home = new JP_Home();		
			}
			pnMainChinh.add(home);
			break;
		case 2:
			if (banhang == null) {
				banhang = new JP_BanHang();
			}
			pnMainChinh.add(banhang);
			break;
			
		case 3:
			if (quanly == null) {
				quanly = new JP_QuanLy();
			}
			pnMainChinh.add(quanly);

			break;
		case 4:
			if(thongke==null) {
				thongke = new JP_ThongKe();
			}
			pnMainChinh.add(thongke);
			break;
		case 5:
			if(caidat==null) {
				caidat = new JP_CaiDat();
			}
			pnMainChinh.add(caidat);
			break;
		default:
			break;
		}
		pnMainChinh.updateUI();
	}

	public JF_Main() {
//	                                          
		addcontrols();
		addEvents();
	}

	private void addEvents() {
		btnTrangChu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reloadPanel(1);
			}
		});

		btnBanHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reloadPanel(2);
			}
		});

		btnQuanLy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reloadPanel(3);
			}
		});

		btnThongKe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reloadPanel(4);
			}
		});

		btnCaiDat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reloadPanel(5);
			}
		});

		btnDangXuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

	}

	public void ShowMain() {
		this.setSize(1200, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
//		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
	}

	private void addcontrols() {
		getContentPane().setFont(new Font("Arial", Font.PLAIN, 14));
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));

		JPanel pnMain = new JPanel();
		pnMain.setBorder(new EmptyBorder(20, 20, 20, 20));
		getContentPane().add(pnMain);
		pnMain.setLayout(new BorderLayout(0, 0));

		JPanel pn_Mains = new JPanel();
		pnMain.add(pn_Mains, BorderLayout.NORTH);
		pn_Mains.setLayout(new BoxLayout(pn_Mains, BoxLayout.X_AXIS));

		JPanel pnMenu = new JPanel();
		pnMenu.setBorder(new EmptyBorder(0, 0, 10, 0));
		pn_Mains.add(pnMenu);
		pnMenu.setLayout(new GridLayout(1, 7, 20, 20));

		btnTrangChu = new JButton("Trang chủ");

		btnTrangChu.setFont(new Font("Arial", Font.PLAIN, 14));
		pnMenu.add(btnTrangChu);

		btnBanHang = new JButton("Bán hàng");

		btnBanHang.setFont(new Font("Arial", Font.PLAIN, 14));
		pnMenu.add(btnBanHang);

		btnQuanLy = new JButton("Quản lý");

		btnQuanLy.setFont(new Font("Arial", Font.PLAIN, 14));
		pnMenu.add(btnQuanLy);

		btnThongKe = new JButton("Thống kê");

		btnThongKe.setFont(new Font("Arial", Font.PLAIN, 14));
		pnMenu.add(btnThongKe);

		btnCaiDat = new JButton("Cài đặt");

		btnCaiDat.setFont(new Font("Arial", Font.PLAIN, 14));
		pnMenu.add(btnCaiDat);

		JPanel pnTT = new JPanel();
		pnMenu.add(pnTT);
		pnTT.setLayout(new BoxLayout(pnTT, BoxLayout.Y_AXIS));
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		pnTT.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 14));
		pnTT.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 14));
		pnTT.add(lblNewLabel_2);
		JPanel pnMenuRight = new JPanel();
		pnMenu.add(pnMenuRight);

		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 14));

		btnDangXuat = new JButton("Đăng xuất");
		btnDangXuat.setFont(new Font("Arial", Font.PLAIN, 14));
		pnMenuRight.setLayout(new BoxLayout(pnMenuRight, BoxLayout.PAGE_AXIS));
		pnMenuRight.add(lblNewLabel_3);
		pnMenuRight.add(btnDangXuat);

		JPanel pnChils = new JPanel();
		pnMain.add(pnChils, BorderLayout.CENTER);
		pnChils.setLayout(new BorderLayout(0, 0));

		pnMainChinh = new JPanel();
		pnMainChinh.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		pnChils.add(pnMainChinh, BorderLayout.CENTER);
		pnMainChinh.setLayout(new BoxLayout(pnMainChinh, BoxLayout.Y_AXIS));
		
		JPanel pnHome = new JPanel();
		pnMainChinh.add(pnHome);

	}

	public static void main(String[] args) {
		 new JF_Main().ShowMain();
	}

}
