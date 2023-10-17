/**
 * CMIS 242
 * This class configures a panel to present a logo for our group project.
 */
package conversionApp;

import java.awt.Toolkit;
import javax.swing.*;
import javax.swing.border.*;

public class Logo extends JPanel {

	public Logo() {

		setBorder(new EmptyBorder(5, 5, 5, 5));
		setBounds(0, 30, 600, 338);
		JLabel lblLogo = new JLabel();
		lblLogo.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(ConversionMain.class.getResource("/images/introVid.gif"))));
		add(lblLogo);
	}

}
