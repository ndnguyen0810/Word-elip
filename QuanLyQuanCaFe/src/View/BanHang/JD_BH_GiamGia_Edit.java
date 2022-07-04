package View.BanHang;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class JD_BH_GiamGia_Edit extends JDialog {

	private final JPanel pnMain = new JPanel();
	private JButton btnHuy, btnXacNhan;
	private JLabel lblTitle;
	private JLabel lblNewLabel_1, lblNewLabel_2;

	private JTextField txtTienKhach;
	private JComboBox comboBox;
	private JLabel lblNewLabel;

	public JD_BH_GiamGia_Edit(Frame parent, boolean modal, String name) {
		super(parent, modal);
		addcontrols();
		this.setTitle(name);
		lblTitle.setText(name);
		{
			comboBox = new JComboBox();
			comboBox.setFont(new Font("Arial", Font.PLAIN, 14));
			GridBagConstraints gbc_comboBox = new GridBagConstraints();
			gbc_comboBox.insets = new Insets(0, 0, 0, 5);
			gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBox.gridx = 2;
			gbc_comboBox.gridy = 1;
			pnMain.add(comboBox, gbc_comboBox);
		}
		{
			lblNewLabel = new JLabel("%");
			lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 14));
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
			gbc_lblNewLabel.gridx = 3;
			gbc_lblNewLabel.gridy = 1;
			pnMain.add(lblNewLabel, gbc_lblNewLabel);
		}
		setW();
	}

	public void setW() {
		setBounds(100, 100, 360, 122);
		setLocationRelativeTo(null);
	}

	public void addcontrols() {

		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		pnMain.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(pnMain);
		GridBagLayout gbl_pnMain = new GridBagLayout();
		gbl_pnMain.columnWidths = new int[] { 0, 0, 124, 0, 0, 0 };
		gbl_pnMain.rowHeights = new int[] { 0, 0, 0 };
		gbl_pnMain.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_pnMain.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		pnMain.setLayout(gbl_pnMain);
		{
			lblTitle = new JLabel("New label");
			lblTitle.setFont(new Font("Arial", Font.BOLD, 16));
			GridBagConstraints gbc_lblTitle = new GridBagConstraints();
			gbc_lblTitle.insets = new Insets(0, 0, 5, 5);
			gbc_lblTitle.gridx = 1;
			gbc_lblTitle.gridy = 0;
			pnMain.add(lblTitle, gbc_lblTitle);
		}
		{
			lblNewLabel_1 = new JLabel("- Giảm giá");
			lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 16));
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_1.gridx = 2;
			gbc_lblNewLabel_1.gridy = 0;
			pnMain.add(lblNewLabel_1, gbc_lblNewLabel_1);
		}
		{
			lblNewLabel_2 = new JLabel("Giảm giá");
			lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 14));
			GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
			gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_2.insets = new Insets(0, 0, 0, 5);
			gbc_lblNewLabel_2.gridx = 1;
			gbc_lblNewLabel_2.gridy = 1;
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
