package View.QuanLy;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.*;

import Models.TaiKhoan;
import View.Main.Run;

import java.awt.event.*;
import java.util.*;

public class JP_QL_TaiKhoan extends JPanel {
	private JTable tabTaiKhoan;
	private JButton btnThem, btnXoa, btnSua;
	private JTextField textField;
	public static int matk;
	public static String name;
	private JLabel lblTotal;
	public TaiKhoan tk = new TaiKhoan();

	public JP_QL_TaiKhoan() {
		addcontrols();
		addevents();
		FillTable();
	}

	private void addevents() {
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				name = btnThem.getText();
				JD_QL_TaiKhoan_Edit jd = new JD_QL_TaiKhoan_Edit(Run.main, true, "Thêm tài khoản mới");
				jd.setVisible(true);
				FillTable();
			}
		});

		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				name = btnSua.getText();
				if (matk > 0) {
					JD_QL_TaiKhoan_Edit jd = new JD_QL_TaiKhoan_Edit(Run.main, true, "Sửa tài khoản");
					jd.setVisible(true);
					FillTable();
				} else {
					JOptionPane.showMessageDialog(null, "Bạn chưa chọn");
				}
			}
		});

		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tk.setMaTK(matk);
				tk.Delete(tk);
				FillTable();
			}
		});
		tabTaiKhoan.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ListSelectionModel model = tabTaiKhoan.getSelectionModel();
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
					matk = Integer.parseInt(tabTaiKhoan.getModel().getValueAt(selectedRow, 0).toString());

				}
			}

		});
	}

	public void FillTable() {
		ArrayList<TaiKhoan> arTK = tk.ShowTable(0);
		DefaultTableModel tbmodel = new DefaultTableModel();

		tbmodel.addColumn("Mã tài khoản");
		tbmodel.addColumn("Tên tài khoản");
		tbmodel.addColumn("Trạng thái");
		tbmodel.addColumn("Họ và tên");

		if (arTK != null) {
			int sotk = 0;
			for (TaiKhoan tk : arTK) {
				sotk++;
				tbmodel.addRow(new Object[] { tk.getMaTK(), tk.getUserName(), tk.getPassWord(), tk.getHoten() });
			}
			lblTotal.setText(String.valueOf(sotk) + " tài khoản");
		} else {
			JOptionPane.showMessageDialog(null, "Không có tài khoản nào");
		}
		tabTaiKhoan.setModel(tbmodel);
		for (int i = 0; i < tabTaiKhoan.getColumnCount(); i++) {
			Class<?> col = tabTaiKhoan.getColumnClass(i);
			tabTaiKhoan.setDefaultEditor(col, null);
		}
	}

	private void addcontrols() {
		setLayout(new BorderLayout(0, 0));

		JPanel pnTop = new JPanel();
		add(pnTop, BorderLayout.NORTH);
		pnTop.setLayout(new GridLayout(1, 3, 0, 0));

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EmptyBorder(10, 10, 10, 10));
		pnTop.add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));

		textField = new JTextField();
		panel_2.add(textField);
		textField.setColumns(30);

		JPanel panel_3 = new JPanel();
		pnTop.add(panel_3);

		JPanel pnCenter = new JPanel();
		add(pnCenter, BorderLayout.CENTER);
		pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));

		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(10, 10, 10, 10));
		pnCenter.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);

		tabTaiKhoan = new JTable();
		tabTaiKhoan.setFont(new Font("Arial", Font.PLAIN, 13));
		tabTaiKhoan.setModel(new DefaultTableModel(new Object[][] {}, new String[] {}));

		scrollPane.setViewportView(tabTaiKhoan);

		JPanel panel_1 = new JPanel();
		pnCenter.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));

		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new EmptyBorder(0, 0, 0, 20));
		FlowLayout flowLayout_1 = (FlowLayout) panel_6.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		panel_1.add(panel_6);

		JLabel lblTS = new JLabel("Tổng số tài khoản:");
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
		btnThem.setIcon(new ImageIcon(JP_QL_TaiKhoan.class.getResource("/Image/add.png")));
		pnBTN.add(btnThem);

		btnSua = new JButton("Sửa");
		btnSua.setIcon(new ImageIcon(JP_QL_TaiKhoan.class.getResource("/Image/edit.png")));
		pnBTN.add(btnSua);

		btnXoa = new JButton("Xoá");
		btnXoa.setIcon(new ImageIcon(JP_QL_TaiKhoan.class.getResource("/Image/delete.png")));
		pnBTN.add(btnXoa);

	}

}
