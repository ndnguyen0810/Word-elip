package View.QuanLy;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.*;
import Models.*;
import View.Main.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class JP_QL_Ban extends JPanel {
	private JTable tabBan;
	public static JButton btnThem, btnSua;
	public JButton btnXoa;
	private JTextField textField;
	public static String In_UP = "";
	private JLabel lblTotal;
	public Ban b = new Ban();
	public static int maban;

	public JP_QL_Ban() {
		addcontrols();
		addevents();
		FillTable();

	}

	private void addevents() {
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				In_UP = btnThem.getText().toUpperCase();
				JD_QL_Ban_Edit ban = new JD_QL_Ban_Edit(Run.main, true, "Thêm bàn mới");
				ban.setVisible(true);
				FillTable();
			}
		});

		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(maban>0) {
					In_UP = btnSua.getText().toUpperCase();
					JD_QL_Ban_Edit ban = new JD_QL_Ban_Edit(Run.main, true, "Sửa bàn - Bàn ");
					ban.setVisible(true);
					FillTable();
				}
				else {
					JOptionPane.showInternalMessageDialog(null,"Bạn chưa chọn!");
				}

			}
		});

		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				b.setMaBan(maban);
				b.Delete(b);
				FillTable();
			}
		});

		tabBan.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ListSelectionModel model = tabBan.getSelectionModel();
		model.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (e.getValueIsAdjusting()) {
					return;
				}
				ListSelectionModel lsm = (ListSelectionModel) e.getSource();

				if (lsm.isSelectionEmpty()) {

				} else {
					int selectedRow = lsm.getMinSelectionIndex();
					maban = Integer.parseInt(tabBan.getModel().getValueAt(selectedRow, 0).toString());

				}
			}

		});

	}

	public void FillTable() {
		ArrayList<Ban> arrTable = b.ShowBan(0);
		DefaultTableModel tbmodel = new DefaultTableModel();

		tbmodel.addColumn("Mã Bàn");
		tbmodel.addColumn("Tên bàn");
		tbmodel.addColumn("Trạng thái");

		if (arrTable != null) {
			int soban = 0;
			for (Ban b : arrTable) {
				soban++;
				tbmodel.addRow(new Object[] { b.getMaBan(), b.getTenBan(), b.getTrangThai() });
			}
			lblTotal.setText(String.valueOf(soban) + " bàn");
		} else {
			JOptionPane.showMessageDialog(null, "Không có bàn nào");
		}
		tabBan.setModel(tbmodel);
		for (int i = 0; i < tabBan.getColumnCount(); i++) {
			Class<?> col = tabBan.getColumnClass(i);
			tabBan.setDefaultEditor(col, null);
		}
	}

	@SuppressWarnings("serial")
	private void addcontrols() {
		setLayout(new BorderLayout(0, 0));

		JPanel pnTop = new JPanel();
		add(pnTop, BorderLayout.NORTH);
		pnTop.setLayout(new GridLayout(1, 3, 0, 0));

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EmptyBorder(10, 10, 10, 10));
		pnTop.add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));

		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3);

		JLabel lblNewLabel = new JLabel("Tìm kiếm");
		panel_3.add(lblNewLabel);

		textField = new JTextField();
		panel_3.add(textField);
		textField.setColumns(40);

		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4);

		JPanel pnCenter = new JPanel();
		add(pnCenter, BorderLayout.CENTER);
		pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));

		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(10, 10, 10, 10));
		pnCenter.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);

		tabBan = new JTable();
		tabBan.setFont(new Font("Arial", Font.PLAIN, 13));
		tabBan.setModel(new DefaultTableModel(new Object[][] { { null, null, null }, { null, null, null },
				{ null, null, null }, { null, null, null } }, new String[] { "Mã bàn", "Tên bàn", "Trạng thái" }) {
			boolean[] canEdit = new boolean[] { false, false, false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});

		scrollPane.setViewportView(tabBan);

		JPanel panel_1 = new JPanel();
		pnCenter.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));

		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new EmptyBorder(0, 0, 0, 20));
		FlowLayout flowLayout_1 = (FlowLayout) panel_6.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		panel_1.add(panel_6);

		JLabel lblTS = new JLabel("Tổng số bàn:");
		lblTS.setFont(new Font("Arial", Font.PLAIN, 14));
		panel_6.add(lblTS);

		lblTotal = new JLabel();
		lblTotal.setForeground(Color.RED);
		lblTotal.setFont(new Font("Arial", Font.PLAIN, 14));
		lblTotal.setHorizontalAlignment(SwingConstants.CENTER);
		panel_6.add(lblTotal);

		JPanel pnRight = new JPanel();
		add(pnRight, BorderLayout.EAST);
		pnRight.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JPanel pnBTN = new JPanel();
		pnRight.add(pnBTN);
		pnBTN.setLayout(new GridLayout(3, 1, 5, 5));

		btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon(JP_QL_Ban.class.getResource("/Image/add.png")));
		pnBTN.add(btnThem);

		btnSua = new JButton("Sửa");
		btnSua.setIcon(new ImageIcon(JP_QL_Ban.class.getResource("/Image/edit.png")));
		pnBTN.add(btnSua);

		btnXoa = new JButton("Xoá");
		btnXoa.setIcon(new ImageIcon(JP_QL_Ban.class.getResource("/Image/delete.png")));
		pnBTN.add(btnXoa);

	}

}
