package View.CaiDat;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JP_CaiDat extends JPanel {
	private JButton btnThongTin, btnDoiMatKhau;
	private JPanel pnAdd;

	public JP_CaiDat() {
		addcontrolls();
		addevents();
		JP_DoiMatKhau j= new JP_DoiMatKhau();
		
		pnAdd.removeAll();
		pnAdd.add(j);
		pnAdd.updateUI();
	}

	private void addcontrolls() {
		setBorder(new EmptyBorder(20, 20, 20, 20));
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

		JPanel pnMain = new JPanel();
		add(pnMain);
		pnMain.setLayout(new BorderLayout(0, 0));

		JPanel pnLeft = new JPanel();
		pnMain.add(pnLeft, BorderLayout.WEST);
		pnLeft.setLayout(new BorderLayout(0, 0));

		JPanel pnButton = new JPanel();
		pnLeft.add(pnButton, BorderLayout.NORTH);
		pnButton.setLayout(new GridLayout(2, 1, 0, 5));

		btnDoiMatKhau = new JButton("Đổi mật khẩu");
		pnButton.add(btnDoiMatKhau);

		btnThongTin = new JButton("Thông tin");
		pnButton.add(btnThongTin);

		pnAdd = new JPanel();
		pnMain.add(pnAdd, BorderLayout.CENTER);

	}

	private void addevents() {
		btnDoiMatKhau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JP_DoiMatKhau jdoimk = new JP_DoiMatKhau();
				pnAdd.removeAll();
				pnAdd.add(jdoimk);
				pnAdd.updateUI();
			}
		});

		btnThongTin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JP_ThongTin jTT = new JP_ThongTin();
				pnAdd.removeAll();
				pnAdd.add(jTT);
				pnAdd.updateUI();
			}
		});

	}

}
