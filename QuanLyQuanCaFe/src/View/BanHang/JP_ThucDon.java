package View.BanHang;

import javax.swing.*;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

public class JP_ThucDon extends JPanel {

	/**
	 * Create the panel.
	 */
	public JP_ThucDon() {
		setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel pn_Mon = new JPanel();
		add(pn_Mon);
		
		JPanel panel = new JPanel();
		pn_Mon.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel pnChonMon = new JPanel();
		add(pnChonMon);
		pnChonMon.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		pnChonMon.add(panel_1, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Chọn món");
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		pnChonMon.add(panel_2, BorderLayout.CENTER);
		
		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		pnChonMon.add(panel_3, BorderLayout.SOUTH);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		panel_3.add(lblNewLabel_1);

	}

}
