package View.BanHang;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;
import javax.swing.border.*;
import Models.*;
import View.Main.Run;
import javax.swing.GroupLayout.Alignment;

public class JP_ThucDon extends JPanel {
	private JPanel pnDSLoai, pnChonMon;
	private JLabel lblChonNhom;

	private LoaiThucAn lt = new LoaiThucAn();
	private ThucAn ta = new ThucAn();
	NumberFormat chuyentien = new DecimalFormat("#, ###");
	
	public static JP_ThucDon td;
	int maban, mata;
	public static String gioden, tenban;
	private JScrollPane scrollPane;

	public JP_ThucDon() {
		addcontrols();
		FillLoai();
		

	}

	private void addcontrols() {
		setBorder(new LineBorder(Color.GREEN, 3, true));
		setLayout(new GridLayout(0, 2, 0, 0));

		JPanel pnLeft = new JPanel();
		add(pnLeft);
		pnLeft.setLayout(new BoxLayout(pnLeft, BoxLayout.X_AXIS));

		pnDSLoai = new JPanel();
		pnDSLoai.setBorder(new EmptyBorder(0, 10, 0, 0));
		pnLeft.add(pnDSLoai);
		pnDSLoai.setLayout(new BorderLayout(0, 0));

		JPanel pnRight = new JPanel();
		add(pnRight);
		pnRight.setLayout(new BorderLayout(0, 0));

		JPanel pnTitle = new JPanel();
		pnTitle.setBackground(Color.MAGENTA);
		pnRight.add(pnTitle, BorderLayout.NORTH);

		lblChonNhom = new JLabel("Chọn món - ");
		lblChonNhom.setFont(new Font("Arial", Font.BOLD, 14));
		pnTitle.add(lblChonNhom);

		pnChonMon = new JPanel();
		pnChonMon.setBorder(new EmptyBorder(10, 10, 10, 10));
		pnRight.add(pnChonMon, BorderLayout.CENTER);
		pnChonMon.setLayout(new BoxLayout(pnChonMon, BoxLayout.Y_AXIS));
		// pnChonMon.setLayout(new BoxLayout(pnChonMon, BoxLayout.Y_AXIS));

		// scrollPane = new JScrollPane();
		// pnChonMon.add(scrollPane);
	}

	public void FillLoai() {
		ArrayList<LoaiThucAn> arrLoai = lt.ShowTable("0");
		if (arrLoai != null) {
			JButton btn;
			pnDSLoai.setLayout(new BoxLayout(pnDSLoai, BoxLayout.PAGE_AXIS));
			pnDSLoai.removeAll();
			pnChonMon.setLayout(new BoxLayout(pnChonMon, BoxLayout.Y_AXIS));
//			pnChonMon.setLayout(new FlowLayout(FlowLayout.CENTER));
			for (LoaiThucAn lt : arrLoai) {
				btn = new JButton(lt.getTenLoai());
				// btn.setName(lt.getMaLoai());

				btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
				btn.setMaximumSize(new Dimension(100, 40));
				btn.setForeground(Color.decode("#331a00"));
				btn.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
				btn.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						lblChonNhom.setText("Nhóm " + lt.getTenLoai());
						ArrayList<ThucAn> arrTA = ta.ShowTable(lt.getMaLoai());
						pnChonMon.removeAll();
						pnChonMon.updateUI();
						if (arrTA != null) {
							JPanel[] pn = new JPanel[arrTA.size()];

							for (int i = 0; i < arrTA.size(); i++) {
								pn[i] = new JPanel(new FlowLayout());
								pnChonMon.add(pn[i]);
								pn[i].setSize(new Dimension(50, 40));
								// pn[i].setName(arrTA.get(i).getMaTA());
								pn[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
								pn[i].setBackground(Color.decode("#dfff80"));
								pn[i].setBorder(BorderFactory.createLineBorder(Color.decode("#a3a375"), 2));
								pn[i].setPreferredSize(new Dimension(170, 60));
								pn[i].add(new JLabel(arrTA.get(i).getTenTA()))
										.setFont(new java.awt.Font("Tahoma", 1, 12));
								pn[i].add(new JLabel(String.valueOf(chuyentien.format(arrTA.get(i).getGia())) + " VNĐ/ "
										+ arrTA.get(i).getdVT())).setForeground(Color.decode("#ff0000"));
								pn[i].addMouseListener(new MouseAdapter() {
									@Override
									public void mousePressed(MouseEvent e) {
										JD_BH_SoLuong_Edit sl = new JD_BH_SoLuong_Edit(Run.main, true, "Thêm món",
												e.getComponent().getName(), tenban, maban);
										sl.gioden = gioden;
										sl.setVisible(true);
									}
								});
								pnChonMon.add(pn[i]);
								pnChonMon.updateUI();
							}
						}
					}
				});
				pnDSLoai.add(btn);
				pnDSLoai.updateUI();
			}

		}

	}

}
