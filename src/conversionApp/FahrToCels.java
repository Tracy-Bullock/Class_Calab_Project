/**
 * Erika Sanchez
 * CMIS 242
 * This class configures the Fahrenheit to Celsius Tab in our group project.
 */
package conversionApp;

import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class FahrToCels extends JPanel {

	JTextField fahrenheitText;
	JTextField celsiusText;
	JButton convertButton;
	DecimalFormat twoplaces = new DecimalFormat("0.00");

	public FahrToCels() {

		JLabel fahrenheitLabel = new JLabel("Enter the Fahrenheit Value to convert:"); // User instruction.
		fahrenheitLabel.setFont(new Font("Arial", Font.BOLD, 15)); // line 15 -font size
		fahrenheitLabel.setBounds(10, 20, 300, 25); // Position and size of the label (X,Y,W,H)
		fahrenheitText = new JTextField(); // field where the user inputs the number to be calculated
		fahrenheitText.setBounds(40, 50, 100, 25); // Position and size of the label (X,Y,W,H)
		JLabel celsiusLabel = new JLabel("       In Celsius is:"); // label for result of the calculation in line 20
		celsiusLabel.setFont(new Font("Arial", Font.BOLD, 15)); // line 18 -font size
		celsiusLabel.setBounds(10, 160, 300, 25); // Position and size of the label (X,Y,W,H)
		celsiusText = new JTextField(0); // field where the result will show after the converstion
		celsiusText.setBounds(40, 190, 100, 25); // Position and size of the label (X,Y,W,H)
		celsiusText.setEditable(false); // Rule to avoid date entry on the Celsius text field.
		convertButton = new JButton("Convert"); // Button to calculate conversion
		JButton clearButton = new JButton("Clear"); // Button to clear the fields
		clearButton.setBounds(40, 220, 100, 25); // Position and size of the label (X,Y,W,H)
		convertButton.setBounds(40, 80, 100, 25); // Position and size of the label (X,Y,W,H)
		JLabel lblTempGif = new JLabel(); // label for the image
		lblTempGif.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(ConversionMain.class.getResource("/images/FatToCel1.gif")))); // Path
																													// or
																													// location
																													// of
																													// the
																													// image.
		lblTempGif.setBounds(320, 50, 110, 265); // Position and size of the label (X,Y,W,H)

		// Commands to add the text and fields to the panel.
		add(fahrenheitLabel);
		add(fahrenheitText);
		add(celsiusLabel);
		add(celsiusText);
		add(convertButton);
		add(clearButton);
		add(lblTempGif);

		setBackground(Color.MAGENTA); // Color selected for the panel.
		setFont(new Font("Arial", Font.BOLD, 25)); // Comand to set the Size and type of font to be used.
		setVisible(true);
		setLayout(null);

		convertButton.addActionListener(new ActionListener() { // Action listener to read the data enter by the user.
			@Override
			public void actionPerformed(ActionEvent fc) {
				try {
					if (fc.getSource() == convertButton) { // Rules for the Conversion formula
						double far = Double.parseDouble(fahrenheitText.getText());
						double cel = ((far - 32) * 5) / 9;
						celsiusText.setText("" + twoplaces.format(cel)); // formating decimal rule.

					}
				} catch (NumberFormatException exception) { // Cath and message for wrong input.
					JOptionPane.showMessageDialog(null, "Please Enter a Number either \nNegative(-) or Positive(+).",
							"Error Message", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		clearButton.addActionListener(new ActionListener() { // Action listener to clear the fields and allowed the use
																// to try again.
			@Override
			public void actionPerformed(ActionEvent fc) {
				fahrenheitText.setText("");
				celsiusText.setText("");
			}
		});

		ConversionFrame.tabPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent changeEvent) {

				if (ConversionFrame.tabPane.getSelectedIndex() == 1) {

					fahrenheitText.setText("");
					celsiusText.setText("");

				}

			}
		});
	}
}