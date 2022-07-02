package View.QuanLy;

import java.awt.*;
import javax.swing.*;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class JP_QL_NhomMon extends JPanel {

	private JTable tableMon;
	private JTextField txtTim;
	private JButton btnThem, btnXoa, btnSua;
	private JComboBox cbbNhom;

	public JP_QL_NhomMon() {
		addcontrols();
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

		JLabel lblNhom = new JLabel("Nhóm món");
		panel_2.add(lblNhom);

		cbbNhom = new JComboBox();
		panel_2.add(cbbNhom);

		JPanel panel_4 = new JPanel();
		pnTop.add(panel_4);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.X_AXIS));

		JLabel lblTim = new JLabel("Tìm món");
		panel_4.add(lblTim);

		txtTim = new JTextField();
		panel_4.add(txtTim);
		txtTim.setColumns(10);

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

		tableMon = new JTable();
		scrollPane.setViewportView(tableMon);

		JPanel panel_1 = new JPanel();
		pnCenter.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));

		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new EmptyBorder(0, 0, 0, 20));
		FlowLayout flowLayout_1 = (FlowLayout) panel_6.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		panel_1.add(panel_6);

		JLabel lblTS = new JLabel("Tổng số món:");
		panel_6.add(lblTS);

		JLabel lblTotal = new JLabel("total");
		lblTotal.setHorizontalAlignment(SwingConstants.CENTER);
		panel_6.add(lblTotal);

		JPanel pnRight = new JPanel();
		add(pnRight, BorderLayout.EAST);
		pnRight.setLayout(new BorderLayout(0, 0));

		JPanel pnBTN = new JPanel();
		pnRight.add(pnBTN, BorderLayout.NORTH);
		pnBTN.setLayout(new GridLayout(3, 1, 5, 5));

		btnThem = new JButton("Thêm");
		pnBTN.add(btnThem);

		btnSua = new JButton("Sửa");
		pnBTN.add(btnSua);

		btnXoa = new JButton("Xoá");
		pnBTN.add(btnXoa);

	}
}
