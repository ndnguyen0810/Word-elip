package View.QuanLy;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

import Models.LoaiThucAn;

import java.awt.event.*;

public class JD_QL_NhomMon_Edit extends JDialog {

	private final JPanel pnMain = new JPanel();
	private JTextField txtTenLoai;
	JButton btnHuy, btnXacNhan;
	private JLabel lblTitle;
	LoaiThucAn l = new LoaiThucAn();

	public JD_QL_NhomMon_Edit(Frame parent, boolean modal, String name) {
		super(parent, modal);
		addcontrols();
		addevents();

		lblTitle.setText(name);
		this.setTitle(name);

	}

	private void addevents() {
		btnXacNhan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JP_QL_LoaiMon.name.equals("Thêm")) {
					if (txtTenLoai.getText() != "") {
						l.setTenLoai(txtTenLoai.getText());
						l.Insert(l);
					} else {
						JOptionPane.showMessageDialog(null, "Không được bỏ rỗng!");
					}
				}
				if (JP_QL_LoaiMon.name.equals("Sửa")) {
					if (txtTenLoai.getText() != "") {
						l.setTenLoai(txtTenLoai.getText());
						l.setMaLoai(JP_QL_LoaiMon.maloai);
						l.Update(l);
					} else {
						JOptionPane.showMessageDialog(null, "Không được bỏ rỗng!");
					}
				}
			}
		});
		btnHuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

	}

	public void addcontrols() {
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 300, 140);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

		pnMain.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(pnMain);
		GridBagLayout gbl_pnMain = new GridBagLayout();
		gbl_pnMain.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gbl_pnMain.rowHeights = new int[] { 34, 0, 0 };
		gbl_pnMain.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_pnMain.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		pnMain.setLayout(gbl_pnMain);
		{
			lblTitle = new JLabel();
			lblTitle.setFont(new Font("Arial", Font.BOLD, 16));
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.gridwidth = 4;
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = 1;
			gbc_lblNewLabel.gridy = 0;
			pnMain.add(lblTitle, gbc_lblNewLabel);
		}
		{
			JLabel lblTenLoai = new JLabel("Tên loại");
			lblTenLoai.setFont(new Font("Arial", Font.PLAIN, 14));
			GridBagConstraints gbc_lblTenLoai = new GridBagConstraints();
			gbc_lblTenLoai.insets = new Insets(0, 0, 0, 5);
			gbc_lblTenLoai.gridx = 1;
			gbc_lblTenLoai.gridy = 1;
			pnMain.add(lblTenLoai, gbc_lblTenLoai);
		}
		{
			txtTenLoai = new JTextField();
			txtTenLoai.setFont(new Font("Arial", Font.PLAIN, 14));
			GridBagConstraints gbc_txtTenLoai = new GridBagConstraints();
			gbc_txtTenLoai.gridwidth = 3;
			gbc_txtTenLoai.insets = new Insets(0, 0, 0, 5);
			gbc_txtTenLoai.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtTenLoai.gridx = 2;
			gbc_txtTenLoai.gridy = 1;
			pnMain.add(txtTenLoai, gbc_txtTenLoai);
			txtTenLoai.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				btnXacNhan = new JButton("Xác nhận");
				btnXacNhan.setFont(new Font("Arial", Font.PLAIN, 14));
				btnXacNhan.setActionCommand("OK");
				buttonPane.add(btnXacNhan);
				getRootPane().setDefaultButton(btnXacNhan);
			}
			{
				btnHuy = new JButton("Huỷ bỏ");
				btnHuy.setFont(new Font("Arial", Font.PLAIN, 14));
				btnHuy.setActionCommand("Cancel");
				buttonPane.add(btnHuy);
			}
		}
	}

}
