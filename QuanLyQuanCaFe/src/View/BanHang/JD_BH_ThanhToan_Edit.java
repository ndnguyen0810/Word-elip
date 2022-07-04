package View.BanHang;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class JD_BH_ThanhToan_Edit extends JDialog {

	private final JPanel pnMain = new JPanel();
	private JButton btnHuy, btnXacNhan;
	private JLabel lblTitle, lblTien;
	private JLabel lblNewLabel_1, lblNewLabel_2, lblNewLabel_3, lblNewLabel_4;

	private JTextField txtTienKhach;
	private JTextField txtTienKhachDua;

	public JD_BH_ThanhToan_Edit(Frame parent, boolean modal, String name) {
		super(parent, modal);
		addcontrols();
		this.setTitle(name);
		lblTitle.setText(name);
		setW();
	}

	public void setW() {
		setBounds(100, 100, 360, 179);
		setLocationRelativeTo(null);
	}

	public void addcontrols() {

		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		pnMain.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(pnMain);
		GridBagLayout gbl_pnMain = new GridBagLayout();
		gbl_pnMain.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gbl_pnMain.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_pnMain.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_pnMain.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		pnMain.setLayout(gbl_pnMain);
		{
			lblTitle = new JLabel("New label");
			lblTitle.setFont(new Font("Arial", Font.PLAIN, 16));
			GridBagConstraints gbc_lblTitle = new GridBagConstraints();
			gbc_lblTitle.gridwidth = 2;
			gbc_lblTitle.insets = new Insets(0, 0, 5, 5);
			gbc_lblTitle.gridx = 1;
			gbc_lblTitle.gridy = 0;
			pnMain.add(lblTitle, gbc_lblTitle);
		}
		{
			lblNewLabel_1 = new JLabel("Số tiền cần trả");
			lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 14));
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
			gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_1.gridx = 1;
			gbc_lblNewLabel_1.gridy = 1;
			pnMain.add(lblNewLabel_1, gbc_lblNewLabel_1);
		}
		{
			lblTien = new JLabel("New label");
			lblTien.setFont(new Font("Arial", Font.PLAIN, 14));
			GridBagConstraints gbc_lblTien = new GridBagConstraints();
			gbc_lblTien.anchor = GridBagConstraints.EAST;
			gbc_lblTien.insets = new Insets(0, 0, 5, 5);
			gbc_lblTien.gridx = 2;
			gbc_lblTien.gridy = 1;
			pnMain.add(lblTien, gbc_lblTien);
		}
		{
			lblNewLabel_2 = new JLabel("Số tiền khách đưa");
			lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 14));
			GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
			gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_2.gridx = 1;
			gbc_lblNewLabel_2.gridy = 2;
			pnMain.add(lblNewLabel_2, gbc_lblNewLabel_2);
		}
		{

			txtTienKhach.setFont(new Font("Arial", Font.PLAIN, 14));
			GridBagConstraints gbc_txtTienKhach = new GridBagConstraints();
			gbc_txtTienKhach.insets = new Insets(0, 0, 5, 5);
			gbc_txtTienKhach.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtTienKhach.gridx = 2;
			gbc_txtTienKhach.gridy = 2;
			pnMain.add(txtTienKhach, gbc_txtTienKhach);
			txtTienKhach.setColumns(10);
		}
		{
			txtTienKhachDua = new JTextField();
			GridBagConstraints gbc_txtTienKhachDua = new GridBagConstraints();
			gbc_txtTienKhachDua.insets = new Insets(0, 0, 5, 5);
			gbc_txtTienKhachDua.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtTienKhachDua.gridx = 2;
			gbc_txtTienKhachDua.gridy = 2;
			pnMain.add(txtTienKhachDua, gbc_txtTienKhachDua);
			txtTienKhachDua.setColumns(10);
		}
		{
			lblNewLabel_3 = new JLabel("Tiền thừa");
			lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 14));
			GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
			gbc_lblNewLabel_3.anchor = GridBagConstraints.WEST;
			gbc_lblNewLabel_3.insets = new Insets(0, 0, 0, 5);
			gbc_lblNewLabel_3.gridx = 1;
			gbc_lblNewLabel_3.gridy = 3;
			pnMain.add(lblNewLabel_3, gbc_lblNewLabel_3);
		}
		{
			lblNewLabel_4 = new JLabel("........");
			lblNewLabel_4.setForeground(Color.RED);
			lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 16));
			GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
			gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_4.insets = new Insets(0, 0, 0, 5);
			gbc_lblNewLabel_4.gridx = 2;
			gbc_lblNewLabel_4.gridy = 3;
			pnMain.add(lblNewLabel_4, gbc_lblNewLabel_4);
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
