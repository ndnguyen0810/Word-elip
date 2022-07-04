package View.BanHang;

import javax.swing.*;
import Models.*;
import View.Main.Run;

import java.awt.*;
import java.text.*;
import java.util.*;

import javax.swing.border.*;

import java.awt.event.*;

public class JP_GoiMon extends JPanel {
	private JPanel pnDSMon, pnTT_ThanhToan, pnThucDon;
	private JLabel lblTenBan, lblStatus, lblgioden, lblThanhTien, lblGiamGia, lblTongTien;
	private JScrollPane jscollTT;
	private JButton btnGoi, btnQuayLai;
	HoaDon hoadon;
	CTHD cthd;
	Ban ban;
	ThucAn ta;
	DsOrder ds;
	String TenBan;
	int MaBan, MaHD, tienmon = 0, tongtien = 0;
	HoaDon hd = new HoaDon();
	public static JP_GoiMon gm;
	ArrayList<DsOrder> order;
	NumberFormat chuyentien = new DecimalFormat("#, ###");
	SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	public JP_GoiMon(int maban, String tenban, String trangthai) {
		addcontrols();
		addevents();
		gm = this;
		MaBan = maban;
		TenBan = tenban;

		pnDSMon.setVisible(false);
		pnTT_ThanhToan.setVisible(false);
		jscollTT.setVisible(false);

		if (hoadon != null) {
			order = ds.GetDsOrder(hoadon.getMaDH());
			fillDsMon(0);
			MaHD = hoadon.getMaDH();
			lblgioden.setText(df.format(hoadon.getThoiGian()));
		}
		lblTenBan.setText(tenban);
		lblStatus.setText(trangthai);

		if (lblStatus.getText().equals("Đang phục vụ")) {
			btnQuayLai.setVisible(false);
			JP_ThucDon thucdon = new JP_ThucDon();
			thucdon.tenban = TenBan;
			thucdon.maban = maban;
			pnThucDon.removeAll();
			pnThucDon.add(thucdon);
			pnThucDon.updateUI();
		}
	}

	public void fillDsMon(int mahd) {
		if (mahd != 0) {	
			order = ds.GetDsOrder(mahd);
			hoadon = hoadon.GetHDbyMaBan(MaBan);
			tienmon = 0;
		}
		mahd = MaHD;
		if (order != null) {
			pnDSMon.setVisible(true);
			pnTT_ThanhToan.setVisible(true);
			jscollTT.setVisible(true);
			btnGoi.setText("Thanh toán");

			JPanel[] pn = new JPanel[order.size()];
			pnDSMon.removeAll();
			pnDSMon.setLayout(new BoxLayout(pnDSMon, BoxLayout.Y_AXIS));
			for (int i = 0; i < order.size(); i++) {
				tienmon += order.get(i).getGia() * order.get(i).getSoLuong();
				pn[i] = new JPanel();
				pn[i].setName(order.get(i).getMaMon());
				pn[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
				pn[i].setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
				pn[i].setBackground(Color.decode("#b3ff99"));
				pn[i].setLayout(new GridLayout());
				pn[i].setPreferredSize(new Dimension(270, 50));
				pn[i].setMaximumSize(new Dimension(270, 50));
				pn[i].setMinimumSize(new Dimension(270, 50));
				pn[i].add(new JLabel(order.get(i).getTenMon(), JLabel.CENTER)).setForeground(Color.decode("#001a66"));
				pn[i].add(new JLabel(String.valueOf(chuyentien.format(order.get(i).getGia())) + " VNĐ", JLabel.CENTER))
						.setForeground(Color.decode("#ff0000"));
				pn[i].add(new JLabel(String.valueOf(order.get(i).getSoLuong()) + " " + order.get(i).getDVT(),
						JLabel.RIGHT)).setForeground(Color.decode("#008000"));
				Icon ic = new ImageIcon("src/Icons/DeleteRed.png");
				JLabel lbl = new JLabel("", ic, JLabel.CENTER);
				lbl.setForeground(Color.decode("#b3ff99"));
				lbl.setName(order.get(i).getMaMon());
				pn[i].add(lbl).addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						int qs;
						ArrayList<ThucAn> td = ta.ShowTable(Integer.parseInt(e.getComponent().getName()));

						qs = JOptionPane.showConfirmDialog(null, "Hủy món: " + td.get(0).getMaTA() + " ?", "Hủy món",
								JOptionPane.YES_NO_OPTION);
						if (qs == JOptionPane.YES_OPTION) {
							int xoa = cthd.DeleteMon(e.getComponent().getName(), MaHD, MaBan);
							if (xoa == 1) {
								fillDsMon(MaHD);
							}
							if (xoa == 2) {
								fillDsMon(MaHD);
								HuyHD();
							}
						}
					}
				});
				pn[i].addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						JD_BH_SoLuong_Edit sl = new JD_BH_SoLuong_Edit(Run.main, true, e.getComponent().getName(),
								"So Luong", TenBan, MaBan);
						sl.setVisible(true);
					}
				});
				pnDSMon.add(pn[i]);
				pnDSMon.updateUI();

			}

			fillThongTin();
		}
	}

	public void fillThongTin() {
		hoadon = hoadon.GetHDbyMaBan(MaBan);
		MaHD = hoadon.getMaDH();
		int ck = cthd.CheckDsMon(MaHD, MaBan);
		btnGoi.setVisible(true);
		if (ck == 0) {
			HuyHD();
			btnGoi.setVisible(false);
		}

		if (hoadon.getGiamgia() > 100) {
			lblGiamGia.setText(chuyentien.format(hoadon.getGiamgia()) + " VNĐ");
			if (tienmon - hoadon.getGiamgia() <= 0) {
				tongtien = 0;
				lblTongTien.setText("0 VNĐ");
			} else {
				tongtien = tienmon - hoadon.getGiamgia();
				lblTongTien.setText(String.valueOf(chuyentien.format(tongtien)) + " VNĐ");
			}
		}
		if (hoadon.getGiamgia() <= 100) {
			tongtien = tienmon - (tienmon * hoadon.getGiamgia() / 100);
			lblTongTien.setText(String.valueOf(chuyentien.format(tongtien)) + " VNĐ");
			lblGiamGia.setText(String.valueOf(hoadon.getGiamgia()) + " %");
		}
		lblThanhTien.setText(String.valueOf(chuyentien.format(tienmon)) + " VNĐ");
	}

	private void HuyHD() {

		JButton btnhuy = new JButton("Hủy bàn");
		btnhuy.setPreferredSize(new Dimension(100, 40));
		btnhuy.setBounds(100, 50, 100, 40);
		pnDSMon.setLayout(null);
		btnGoi.setVisible(false);
		pnTT_ThanhToan.setVisible(false);
		btnhuy.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Ban b = new Ban();
				b.setTrangThai("Trống");
				b.setMaBan(MaBan);
				b.UpdateTrangThaiBan(b);

				JP_BanHang.jp_bh.FillBan();
				JP_GoiMon.gm.removeAll();
				JP_BanHang.jp_bh.fillLb();

				HoaDon hd = new HoaDon();
				hd.setMaDH(MaHD);
				hd.Delete(hd);
			}
		});
		pnDSMon.add(btnhuy);
		pnDSMon.updateUI();
	}

	private void addevents() {
		btnGoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnGoi.getText().equals("Gọi món")) {
//		            pnThucDon.setVisible(true);
					Date date = new Date();
					SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm a");
					SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					lblgioden.setText(df.format(date));
					lblStatus.setText("Đang phục vụ");
					btnQuayLai.setVisible(false);
					btnGoi.setText("Hủy bàn");
//
					JP_ThucDon thucdon = new JP_ThucDon();
					thucdon.maban = MaBan;
					thucdon.tenban = TenBan;
					thucdon.gioden = sf.format(date);

					pnThucDon.removeAll();
					pnThucDon.add(thucdon);
					pnThucDon.revalidate();
				}
			}
		});

	}

	public void addcontrols() {
		setLayout(new GridLayout(0, 2, 0, 0));

		JPanel pnThongTinBan = new JPanel();
		pnThongTinBan.setForeground(Color.RED);
		pnThongTinBan.setBorder(new LineBorder(Color.RED, 2, true));
		add(pnThongTinBan);
		pnThongTinBan.setLayout(new BoxLayout(pnThongTinBan, BoxLayout.Y_AXIS));

		JPanel panel = new JPanel();
		pnThongTinBan.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		JPanel panel_7 = new JPanel();
		panel.add(panel_7);
		panel_7.setLayout(new GridLayout(3, 3, 0, 0));

		JPanel panel_8 = new JPanel();
		panel_7.add(panel_8);

		JPanel panel_9 = new JPanel();
		panel_7.add(panel_9);

		JPanel panel_10 = new JPanel();
		panel_7.add(panel_10);
		panel_10.setLayout(new BoxLayout(panel_10, BoxLayout.X_AXIS));

		lblTenBan = new JLabel("<Bàn XX>");
		lblTenBan.setAlignmentX(Component.RIGHT_ALIGNMENT);
		lblTenBan.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTenBan.setFont(new Font("Arial", Font.BOLD, 15));
		panel_10.add(lblTenBan);

		JLabel lblNewLabel_7 = new JLabel("Giờ đến:");
		lblNewLabel_7.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		panel_7.add(lblNewLabel_7);

		lblgioden = new JLabel("12/12/2022 12:11:20");
		lblgioden.setFont(new Font("Arial", Font.PLAIN, 14));
		lblgioden.setHorizontalAlignment(SwingConstants.CENTER);
		panel_7.add(lblgioden);

		JPanel panel_11 = new JPanel();
		panel_7.add(panel_11);

		JLabel lblNewLabel_9 = new JLabel("Trạng thái");
		lblNewLabel_9.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		panel_7.add(lblNewLabel_9);

		lblStatus = new JLabel("<status>");
		lblStatus.setFont(new Font("Arial", Font.PLAIN, 14));
		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
		panel_7.add(lblStatus);

		JPanel panel_12 = new JPanel();
		panel_7.add(panel_12);

		JPanel panel_1 = new JPanel();
		pnThongTinBan.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));

		jscollTT = new JScrollPane();
		panel_1.add(jscollTT);

		pnDSMon = new JPanel();
		jscollTT.setColumnHeaderView(pnDSMon);
		pnDSMon.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JPanel panel_2 = new JPanel();
		pnThongTinBan.add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		pnTT_ThanhToan = new JPanel();
		panel_2.add(pnTT_ThanhToan);
		pnTT_ThanhToan.setLayout(new BoxLayout(pnTT_ThanhToan, BoxLayout.X_AXIS));

		JPanel panel_4 = new JPanel();
		pnTT_ThanhToan.add(panel_4);
		panel_4.setLayout(new GridLayout(3, 2, 20, 5));

		JLabel lblNewLabel_1 = new JLabel("Tiền món");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_4.add(lblNewLabel_1);

		lblTongTien = new JLabel("100000");
		lblTongTien.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_4.add(lblTongTien);

		JLabel lblNewLabel_3 = new JLabel("Giảm giá");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_4.add(lblNewLabel_3);

		lblGiamGia = new JLabel("10000");
		lblGiamGia.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_4.add(lblGiamGia);

		JLabel lblNewLabel_4 = new JLabel("Thành tiền");
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_4.add(lblNewLabel_4);

		lblThanhTien = new JLabel("9999999");
		lblThanhTien.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_4.add(lblThanhTien);

		JPanel panel_3 = new JPanel();
		pnThongTinBan.add(panel_3);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.X_AXIS));

		JPanel panel_5 = new JPanel();
		panel_3.add(panel_5);
		panel_5.setLayout(new BoxLayout(panel_5, BoxLayout.X_AXIS));

		btnQuayLai = new JButton("Quay lại");
		btnQuayLai.setFont(new Font("Arial", Font.PLAIN, 14));
		panel_5.add(btnQuayLai);

		btnGoi = new JButton("Gọi món");
		btnGoi.setFont(new Font("Arial", Font.PLAIN, 14));
		panel_5.add(btnGoi);

		pnThucDon = new JPanel();
		pnThucDon.setBorder(new EmptyBorder(10, 10, 10, 10));
		add(pnThucDon);
		pnThucDon.setLayout(new BoxLayout(pnThucDon, BoxLayout.X_AXIS));

		JLabel lblNewLabel = new JLabel("New label");
		pnThucDon.add(lblNewLabel);

	}

}
