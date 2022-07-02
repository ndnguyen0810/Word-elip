package View.BanHang;

import javax.swing.*;
import java.awt.GridLayout;
import java.awt.BorderLayout;

public class JP_GoiMon extends JPanel {

	/**
	 * Create the panel.
	 */
	public JP_GoiMon() {
		setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel pnThongTinBan = new JPanel();
		add(pnThongTinBan);
		pnThongTinBan.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		pnThongTinBan.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3, BorderLayout.SOUTH);
		panel_3.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		panel_3.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		panel_3.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		panel_3.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		panel_3.add(lblNewLabel_5);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		panel.add(lblNewLabel_1, BorderLayout.SOUTH);
		
		JPanel panel_2 = new JPanel();
		pnThongTinBan.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4, BorderLayout.NORTH);
		
		JButton btnNewButton_1 = new JButton("New button");
		panel_4.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		panel_4.add(btnNewButton_2);
		
		JPanel panel_1 = new JPanel();
		pnThongTinBan.add(panel_1, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("New button");
		panel_1.add(btnNewButton);
		
		JPanel pnThucDon = new JPanel();
		add(pnThucDon);
		pnThucDon.setLayout(new BoxLayout(pnThucDon, BoxLayout.X_AXIS));
		
		JLabel lblNewLabel = new JLabel("New label");
		pnThucDon.add(lblNewLabel);

	}

}
