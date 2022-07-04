package View.QuanLy;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import Models.*;
import java.awt.event.*;
import java.util.*;

public class JD_QL_ThucDon_Edit extends JDialog {

	private final JPanel pnMain = new JPanel();
	private JTextField txtTenMon, txtGia;
	private JLabel lblTitle;
	private LoaiThucAn lt = new LoaiThucAn();
	private JComboBox<LoaiThucAn> cbbLoaiMon;
	private JButton okButton, cancelButton;
	private ThucAn ta = new ThucAn();
	private JComboBox<String> cbbDVT;

	public JD_QL_ThucDon_Edit(Frame parent, boolean modal, String name) {
		super(parent, modal);
		this.setTitle(name);
		addcontrol();
		addevents();
		SetW();
		lblTitle.setText(name);

	}

	private void SetW() {
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		this.setBounds(100, 100, 392, 221);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
	}

	private void addevents() {
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoaiThucAn maloai = (LoaiThucAn) cbbLoaiMon.getSelectedItem();
				if (JP_QL_ThucDon.name.equals("Thêm")) {
					ta.setTenTA(txtTenMon.getText());
					ta.setGia(Integer.parseInt(txtGia.getText()));
					ta.setdVT(cbbDVT.getSelectedItem().toString());
					ta.setMaLoai(maloai.getMaLoai());
					ta.setdVT(cbbDVT.getSelectedItem().toString());
					ta.Insert(ta);
				}
				if (JP_QL_ThucDon.name.equals("Sửa")) {
					ta.setMaTA(JP_QL_ThucDon.maTD);
					ta.setTenTA(txtTenMon.getText());
					ta.setGia(Integer.parseInt(txtGia.getText()));
					ta.setdVT(cbbDVT.getSelectedItem().toString());
					ta.setMaLoai(maloai.getMaLoai());
					ta.setdVT(cbbDVT.getSelectedItem().toString());
					ta.Update(ta);
				}

			}
		});
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		txtGia.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();
		        if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
		            e.consume();  // if it's not a number, ignore the event
		        }
		     }
		});
	}

	public void addcontrol() {
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		pnMain.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(pnMain);
		GridBagLayout gbl_pnMain = new GridBagLayout();
		gbl_pnMain.columnWidths = new int[] { 0, 87, 0, 0, 0, 0 };
		gbl_pnMain.rowHeights = new int[] { 22, 0, 0, 0, 0, 0 };
		gbl_pnMain.columnWeights = new double[] { 0.0, 1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_pnMain.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		pnMain.setLayout(gbl_pnMain);
		{
			lblTitle = new JLabel();
			lblTitle.setFont(new Font("Arial", Font.BOLD, 16));
			GridBagConstraints gbc_lblTitle = new GridBagConstraints();
			gbc_lblTitle.gridwidth = 2;
			gbc_lblTitle.insets = new Insets(0, 0, 5, 5);
			gbc_lblTitle.gridx = 1;
			gbc_lblTitle.gridy = 0;
			pnMain.add(lblTitle, gbc_lblTitle);
		}

		{
			JLabel lblNewLabel_1 = new JLabel("Tên món");
			lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 14));
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
			gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_1.gridx = 1;
			gbc_lblNewLabel_1.gridy = 1;
			pnMain.add(lblNewLabel_1, gbc_lblNewLabel_1);
		}
		{
			txtTenMon = new JTextField();
			txtTenMon.setFont(new Font("Arial", Font.PLAIN, 14));
			GridBagConstraints gbc_txtTenMon = new GridBagConstraints();
			gbc_txtTenMon.gridwidth = 2;
			gbc_txtTenMon.insets = new Insets(0, 0, 5, 5);
			gbc_txtTenMon.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtTenMon.gridx = 2;
			gbc_txtTenMon.gridy = 1;
			pnMain.add(txtTenMon, gbc_txtTenMon);
			txtTenMon.setColumns(10);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Loại món");
			lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 14));
			GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
			gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
			gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_2.gridx = 1;
			gbc_lblNewLabel_2.gridy = 2;
			pnMain.add(lblNewLabel_2, gbc_lblNewLabel_2);
		}
		{
			cbbLoaiMon = new JComboBox<>();
			cbbLoaiMon.setFont(new Font("Arial", Font.PLAIN, 14));
			GridBagConstraints gbc_cbbLoaiMon = new GridBagConstraints();
			gbc_cbbLoaiMon.gridwidth = 2;
			gbc_cbbLoaiMon.insets = new Insets(0, 0, 5, 5);
			gbc_cbbLoaiMon.fill = GridBagConstraints.HORIZONTAL;
			gbc_cbbLoaiMon.gridx = 2;
			gbc_cbbLoaiMon.gridy = 2;
			pnMain.add(cbbLoaiMon, gbc_cbbLoaiMon);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("Giá tiền");
			lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 14));
			GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
			gbc_lblNewLabel_4.anchor = GridBagConstraints.WEST;
			gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_4.gridx = 1;
			gbc_lblNewLabel_4.gridy = 3;
			pnMain.add(lblNewLabel_4, gbc_lblNewLabel_4);
		}
		{
			txtGia = new JTextField();
			
			txtGia.setFont(new Font("Arial", Font.PLAIN, 14));
			GridBagConstraints gbc_txtGia = new GridBagConstraints();
			gbc_txtGia.gridwidth = 2;
			gbc_txtGia.insets = new Insets(0, 0, 5, 5);
			gbc_txtGia.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtGia.gridx = 2;
			gbc_txtGia.gridy = 3;
			pnMain.add(txtGia, gbc_txtGia);
			txtGia.setColumns(10);
		}
		{
			JLabel lblNewLabel_5 = new JLabel("Đơn vị tính");
			lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 14));
			GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
			gbc_lblNewLabel_5.anchor = GridBagConstraints.WEST;
			gbc_lblNewLabel_5.fill = GridBagConstraints.VERTICAL;
			gbc_lblNewLabel_5.insets = new Insets(0, 0, 0, 5);
			gbc_lblNewLabel_5.gridx = 1;
			gbc_lblNewLabel_5.gridy = 4;
			pnMain.add(lblNewLabel_5, gbc_lblNewLabel_5);
		}
		{
			JPanel pnButton = new JPanel();
			pnButton.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(pnButton);
			{
				okButton = new JButton("OK");
				okButton.setFont(new Font("Arial", Font.PLAIN, 14));
				okButton.setActionCommand("OK");
				pnButton.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancel");

				cancelButton.setFont(new Font("Arial", Font.PLAIN, 14));
				cancelButton.setActionCommand("Cancel");
				pnButton.add(cancelButton);
			}
		}

		lblTitle.setFont(new Font("Arial", Font.BOLD, 16));
		lt.ShowLoai_InCBB(cbbLoaiMon);
		{
			cbbDVT = new JComboBox<>(new String[] { "Chai", "Lon","Ly"});
			cbbDVT.setEditable(false);
			cbbDVT.setFont(new Font("Arial", Font.PLAIN, 14));

			GridBagConstraints gbc_cbbDVT = new GridBagConstraints();
			gbc_cbbDVT.gridwidth = 2;
			gbc_cbbDVT.insets = new Insets(0, 0, 0, 5);
			gbc_cbbDVT.fill = GridBagConstraints.HORIZONTAL;
			gbc_cbbDVT.gridx = 2;
			gbc_cbbDVT.gridy = 4;
			pnMain.add(cbbDVT, gbc_cbbDVT);
		}
	}

}
