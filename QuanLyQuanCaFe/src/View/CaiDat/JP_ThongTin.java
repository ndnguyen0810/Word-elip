package View.CaiDat;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import java.awt.GridLayout;

public class JP_ThongTin extends JPanel {

	/**
	 * Create the panel.
	 */
	public JP_ThongTin() {
		FlowLayout flowLayout = (FlowLayout) getLayout();
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		JLabel lblNewLabel = new JLabel();

		panel.add(lblNewLabel);

	}

}
