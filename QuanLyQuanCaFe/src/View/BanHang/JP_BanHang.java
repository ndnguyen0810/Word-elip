package View.BanHang;

import javax.swing.*;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import net.miginfocom.swing.MigLayout;
import java.awt.BorderLayout;

public class JP_BanHang extends JPanel {

	/**
	 * Create the panel.
	 */
	public JP_BanHang() {
		setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel pnLeft = new JPanel();
		add(pnLeft);
		pnLeft.setLayout(new BoxLayout(pnLeft, BoxLayout.Y_AXIS));
		
		JPanel pnBan = new JPanel();
		pnLeft.add(pnBan);
		
		JPanel pnTT = new JPanel();
		pnLeft.add(pnTT);
		pnTT.setLayout(new BoxLayout(pnTT, BoxLayout.X_AXIS));
		
		JPanel pnBtn = new JPanel();
		pnTT.add(pnBtn);
		pnBtn.setLayout(new GridLayout(3, 1, 0, 0));
		
		JButton btnTrng = new JButton("TRống");
		pnBtn.add(btnTrng);
		
		JButton btnNewButton_1 = new JButton("Đang phục vụ");
		pnBtn.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("đặt trước");
		pnBtn.add(btnNewButton_2);
		
		JPanel pnRight = new JPanel();
		add(pnRight);
		
		JLabel lblNewLabel = new JLabel("New label");
		pnRight.add(lblNewLabel);

	}

}
