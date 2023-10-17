package conversionApp;

/* 
 * Group: Tracy
 * CLASS: CMIS 242 (2215)
 * DATE: June 29, 2021
 * 
 * This program is made to convert temperature from either Fahrenheit to Celsius
 * or Celsius to Fahrenheit and distance from either miles to Kilometers or
 * kilometers to miles.
 * 
 */
import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.*;

public class ConversionMain {

	public static void main(String[] args) {

		// ------------------------------
		// Customize DialogPanes
		// ------------------------------
		JDialog.setDefaultLookAndFeelDecorated(true);
		UIManager UI = new UIManager();
		UI.put("OptionPane.messageFont", new FontUIResource("Arial", Font.BOLD, 12));
		UI.put("OptionPane.background", new ColorUIResource(144, 146, 151));
		UI.put("OptionPane.messageForeground", new ColorUIResource(252, 252, 252));
		UI.put("Panel.background", new ColorUIResource(112, 112, 114));

		ConversionFrame frame = new ConversionFrame();

	}

}
