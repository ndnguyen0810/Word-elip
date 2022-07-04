package View.CaiDat;

import javax.swing.border.*;

import Models.TaiKhoan;
import View.Main.JF_Login;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class JP_DoiMatKhau extends JPanel {
	private JPasswordField txtPassOld, txtPassNew, txtPassReNew;
	private JButton btnXacNhan;
	String passw = JF_Login.pasS, name = JF_Login.name;
	private JTextField txtHoTen;

	public JP_DoiMatKhau() {
		addcontrols();
		addevents();
	}

	private void addevents() {
		btnXacNhan.addActionListener(new ActionListener() {
			TaiKhoan tk = new TaiKhoan();

			public void actionPerformed(ActionEvent e) {
				if (txtHoTen.getText() == "" || txtPassNew.getPassword().toString() == ""
						|| txtPassOld.getPassword().toString() == "" || txtPassReNew.getPassword().toString() == "")
					JOptionPane.showMessageDialog(null, "Không được bỏ trống!");
				else {
					if (txtPassOld.getPassword().toString() == passw)
						if (txtPassNew.getPassword().toString() == txtPassReNew.getPassword().toString()) {
							tk.setHoten(txtHoTen.getText());
							tk.setPassWord(txtPassNew.getPassword().toString());
							tk.DoiMatKhau(tk);
						}

				}
			}
		});

	}

	public void addcontrols() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

		JPanel pnMain = new JPanel();
		pnMain.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.RAISED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Đổi mật khẩu", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
		add(pnMain);
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));

		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(30, 30, 30, 30));
		pnMain.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(4, 2, 20, 5));

		JLabel lblHoTen = new JLabel("Tên tài khoản");
		lblHoTen.setFont(new Font("Arial", Font.PLAIN, 14));
		panel_2.add(lblHoTen);

		txtHoTen = new JTextField();
		panel_2.add(txtHoTen);
		txtHoTen.setColumns(10);

		JLabel lblMK_Cu = new JLabel("Nhập lại mật khẩu cũ");
		lblMK_Cu.setFont(new Font("Arial", Font.PLAIN, 14));
		panel_2.add(lblMK_Cu);

		txtPassOld = new JPasswordField();
		txtPassOld.setFont(new Font("Arial", Font.PLAIN, 14));
		panel_2.add(txtPassOld);

		JLabel lblMK_New = new JLabel("Nhập mật khẩu mới");
		lblMK_New.setFont(new Font("Arial", Font.PLAIN, 14));
		panel_2.add(lblMK_New);

		txtPassNew = new JPasswordField();
		txtPassNew.setFont(new Font("Arial", Font.PLAIN, 14));
		panel_2.add(txtPassNew);

		JLabel lblMK_ReNew = new JLabel("Nhập lại mật khẩu mới");
		lblMK_ReNew.setFont(new Font("Arial", Font.PLAIN, 14));
		panel_2.add(lblMK_ReNew);

		txtPassReNew = new JPasswordField();
		txtPassReNew.setFont(new Font("Arial", Font.PLAIN, 14));
		panel_2.add(txtPassReNew);

		JPanel panel_1 = new JPanel();
		pnMain.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));

		btnXacNhan = new JButton("Xác nhận");
		btnXacNhan.setFont(new Font("Arial", Font.PLAIN, 14));
		panel_1.add(btnXacNhan);

	}

}
