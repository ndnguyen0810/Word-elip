package View.BanHang;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.*;
import Models.*;
import java.awt.event.*;

public class JD_BH_SoLuong_Edit extends JDialog {

	private final JPanel pnMain = new JPanel();
	private JButton btnHuy, btnXacNhan, btnTru, btnCong;
	private JLabel lblTenBan, lblTenMon, lblNewLabel_1, lblNewLabel_3, lblDVT;
	private JTextField txtGia, txtSoLuong;

	int sl = 0, gia = 0;
	ArrayList<ThucAn> arrThucDon;
	ThucAn ta = new ThucAn();
	public String gioden, TenBan;
	public int maban = JP_GoiMon.gm.MaBan, mamon;
	CTHD mon;

	public JD_BH_SoLuong_Edit(Frame parent, boolean modal, String name, String MaMon, String tenban, int MaBan) {
		super(parent, modal);
		addcontrols();
		addevents();
		this.setTitle(name);
		Fill();
		setW();

	}

	private void addevents() {
		btnHuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.err.println(maban);
				dispose();
			}
		});
		btnCong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sl = Integer.parseInt(txtSoLuong.getText());
				if (sl < 30) {
					sl++;
					txtSoLuong.setText(String.valueOf(sl));
					txtGia.setText(String.valueOf(sl * gia));
				}
			}
		});
		btnTru.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					sl = Integer.parseInt(txtSoLuong.getText());
					if (sl != 1 && sl != 0) {
						sl--;
						txtSoLuong.setText(String.valueOf(sl));
						txtGia.setText(String.valueOf(sl * gia));

					}
				} catch (Exception ex) {
					txtSoLuong.setText("1");
				}
			}
		});

		btnXacNhan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HoaDon hd = new HoaDon();
				if (hd.GetMaHD_ByMa(maban) == 0) {
					hd.setMaBan(JP_GoiMon.gm.MaBan);
					hd.setThoiGian(gioden);
					hd.Insert(hd);
				}

				if (mon != null) {
					CTHD ct = new CTHD();
					ct.setGia(Integer.parseInt(txtGia.getText()));
					ct.setSoLuong(Integer.parseInt(txtSoLuong.getText()));
					int updatect = ct.UpdateChiTiet(ct);
				}
				if (mon == null) {
					CTHD cthd = new CTHD();
					cthd.setGia(Integer.parseInt(txtGia.getText()));
					cthd.setMaHD(hd.GetMaHD_ByMa(maban));
					cthd.setMaTA(maban);
					cthd.setSoLuong(Integer.parseInt(txtSoLuong.getText()));
					cthd.Insert(cthd);
				}

				Ban b = new Ban();
				b.setTrangThai("Đang phục vụ");
				b.setMaBan(maban);
				b.UpdateTrangThaiBan(b);

				JP_BanHang.jp_bh.FillBan();
				JP_BanHang.jp_bh.updateUI();
				JP_GoiMon.gm.fillDsMon(hd.GetMaHD_ByMa(maban));
				JP_GoiMon.gm.updateUI();

				dispose();
			}
		});

	}

	public void setW() {
		setBounds(100, 100, 360, 179);
		setLocationRelativeTo(null);
	}

	private void Fill() {
		arrThucDon = ta.ShowTable(mamon);
		lblTenBan.setText(TenBan);
		txtSoLuong.setText("1");
		gia = arrThucDon.get(0).getGia();
		// lblTenBan.setText("Bàn - " + " ");

		lblTenMon.setText(arrThucDon.get(0).getTenTA());
		lblDVT.setText(arrThucDon.get(0).getdVT());
		txtGia.setText(String.valueOf(arrThucDon.get(0).getGia()));
	}

	public void addcontrols() {

		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		pnMain.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(pnMain);
		GridBagLayout gbl_pnMain = new GridBagLayout();
		gbl_pnMain.columnWidths = new int[] { 0, 0, 73, 0, 0, 0, 0 };
		gbl_pnMain.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_pnMain.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_pnMain.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		pnMain.setLayout(gbl_pnMain);
		{
			lblTenBan = new JLabel("New label");
			lblTenBan.setFont(new Font("Arial", Font.BOLD, 16));
			GridBagConstraints gbc_lblTenBan = new GridBagConstraints();
			gbc_lblTenBan.insets = new Insets(0, 0, 5, 5);
			gbc_lblTenBan.gridx = 1;
			gbc_lblTenBan.gridy = 0;
			pnMain.add(lblTenBan, gbc_lblTenBan);
		}
		{
			lblTenMon = new JLabel("<>");
			lblTenMon.setFont(new Font("Arial", Font.BOLD, 16));
			GridBagConstraints gbc_lblTenMon = new GridBagConstraints();
			gbc_lblTenMon.insets = new Insets(0, 0, 5, 5);
			gbc_lblTenMon.gridx = 2;
			gbc_lblTenMon.gridy = 0;
			pnMain.add(lblTenMon, gbc_lblTenMon);
		}
		{
			lblNewLabel_1 = new JLabel("Số lượng");
			lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 14));
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
			gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_1.gridx = 1;
			gbc_lblNewLabel_1.gridy = 1;
			pnMain.add(lblNewLabel_1, gbc_lblNewLabel_1);
		}
		{
			txtGia = new JTextField();
			txtGia.setEditable(false);
			txtGia.setFont(new Font("Arial", Font.PLAIN, 14));
			GridBagConstraints gbc_txtGia = new GridBagConstraints();
			gbc_txtGia.insets = new Insets(0, 0, 5, 5);
			gbc_txtGia.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtGia.gridx = 2;
			gbc_txtGia.gridy = 2;
			pnMain.add(txtGia, gbc_txtGia);
			txtGia.setColumns(10);
		}
		{
			txtSoLuong = new JTextField();
			txtSoLuong.setEditable(false);
			GridBagConstraints gbc_txtSoLuong = new GridBagConstraints();
			gbc_txtSoLuong.insets = new Insets(0, 0, 5, 5);
			gbc_txtSoLuong.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtSoLuong.gridx = 2;
			gbc_txtSoLuong.gridy = 1;
			pnMain.add(txtSoLuong, gbc_txtSoLuong);
			txtSoLuong.setColumns(5);
		}
		{
			lblDVT = new JLabel("DVT");
			GridBagConstraints gbc_lblDVT = new GridBagConstraints();
			gbc_lblDVT.insets = new Insets(0, 0, 5, 5);
			gbc_lblDVT.gridx = 3;
			gbc_lblDVT.gridy = 1;
			pnMain.add(lblDVT, gbc_lblDVT);
		}
		{
			btnTru = new JButton("");
			btnTru.setIcon(new ImageIcon(JD_BH_SoLuong_Edit.class.getResource("/Image/minus.png")));

			GridBagConstraints gbc_btnTru = new GridBagConstraints();
			gbc_btnTru.insets = new Insets(0, 0, 5, 5);
			gbc_btnTru.gridx = 4;
			gbc_btnTru.gridy = 1;
			pnMain.add(btnTru, gbc_btnTru);
		}
		{
			btnCong = new JButton("");
			btnCong.setIcon(new ImageIcon(JD_BH_SoLuong_Edit.class.getResource("/Image/plus.png")));

			GridBagConstraints gbc_btnCong = new GridBagConstraints();
			gbc_btnCong.insets = new Insets(0, 0, 5, 0);
			gbc_btnCong.gridx = 5;
			gbc_btnCong.gridy = 1;
			pnMain.add(btnCong, gbc_btnCong);
		}
		{
			lblNewLabel_3 = new JLabel("Giá");
			lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 14));
			GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
			gbc_lblNewLabel_3.anchor = GridBagConstraints.WEST;
			gbc_lblNewLabel_3.insets = new Insets(0, 0, 0, 5);
			gbc_lblNewLabel_3.gridx = 1;
			gbc_lblNewLabel_3.gridy = 2;
			pnMain.add(lblNewLabel_3, gbc_lblNewLabel_3);
		}
		{
			JPanel pnButton = new JPanel();
			pnButton.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(pnButton);
			{
				btnXacNhan = new JButton("Xác nhận");

				btnXacNhan.setFont(new Font("Arial", Font.PLAIN, 14));
				btnXacNhan.setActionCommand("OK");
				pnButton.add(btnXacNhan);
				getRootPane().setDefaultButton(btnXacNhan);
			}
			{
				btnHuy = new JButton("Huỷ");
				btnHuy.setFont(new Font("Arial", Font.PLAIN, 14));
				btnHuy.setActionCommand("Cancel");
				pnButton.add(btnHuy);
			}
		}
	}

}
