package View.Main;

import javax.swing.*;
import java.awt.*;

public class JP_Home extends JPanel {

	public JP_Home() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		JPanel panel = new JPanel();
		add(panel);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setPreferredSize(new Dimension(0, 0));
		lblNewLabel.setIcon(new ImageIcon(JP_Home.class.getResource("/Image/homeI.jpg")));
		lblNewLabel.getSize(new Dimension( lblNewLabel.getWidth()*(1/2), lblNewLabel.getHeight()*(1/2)));
				panel.setLayout(new CardLayout(0, 0));
				panel.add(lblNewLabel, "name_178082028372900");

	}

}
