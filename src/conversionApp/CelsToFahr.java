/**
 * Robert B. Mittnight III
 * CMIS 242
 * This class configures the Celsius to Fahrenheit Tab in our group project.
 */
package conversionApp;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.text.DecimalFormat;

public class CelsToFahr extends JPanel {
	public CelsToFahr() {
		// Configure and add main panel.
		JPanel main = new JPanel();
		setBackground(new Color(172, 209, 246));
		main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
		add(main);

		// Configure and add panels for components.
		CreatePanel instructionsPanel = new CreatePanel();
		CreatePanel userInputPanel = new CreatePanel();
		CreatePanel conversionResultPanel = new CreatePanel();
		CreatePanel buttonsPanel = new CreatePanel();
		CreatePanel resultPanel = new CreatePanel();
		CreatePanel imagePanel = new CreatePanel();

		// Add the panels.
		main.add(instructionsPanel);
		main.add(userInputPanel);
		main.add(conversionResultPanel);
		main.add(buttonsPanel);
		main.add(resultPanel);
		main.add(imagePanel);

		// Configure components.
		JLabel instructionsLabel = new JLabel("Enter temperature to convert:");
		instructionsLabel.setFont(new Font("Arial", Font.BOLD, 25));
		JTextField userInput = new JTextField("", 15);
		JLabel conversionResultLabel = new JLabel();
		JButton calcBtn = new JButton("Convert");
		JButton clearBtn = new JButton("Clear");
		JLabel snowImage = new JLabel(new ImageIcon(getClass().getResource("/images/snow.png")));
		JLabel sunImage = new JLabel(new ImageIcon(getClass().getResource("/images/sun.png")));

		// Ensures images are not displayed before temperatures are converted.
		snowImage.setVisible(false);
		sunImage.setVisible(false);

		// Add components.
		instructionsPanel.add(instructionsLabel);
		userInputPanel.add(userInput);
		conversionResultPanel.add(conversionResultLabel);
		buttonsPanel.add(calcBtn);
		buttonsPanel.add(clearBtn);
		imagePanel.add(snowImage);
		imagePanel.add(sunImage);

		// Perform input validation and conversion.
		calcBtn.addActionListener(e -> {
			try {
				double temp = convertCtoF(Double.parseDouble(userInput.getText()));
				conversionResultLabel.setText("You entered: " + userInput.getText() + "°C."
						+ "Your temperature in fahrenheit is: " + temp + "°F.");

				// Display images based on temperature.
				if (temp < 33) {
					sunImage.setVisible(false);
					snowImage.setVisible(true);
				} else {
					sunImage.setVisible(true);
					snowImage.setVisible(false);
				}

			} catch (NumberFormatException exception) {
				userInput.setText("");
				JOptionPane.showMessageDialog(null, "Input a number!", "Input Validation Failure",
						JOptionPane.WARNING_MESSAGE);
			}
		});

		// Clears the text input field, result labels, and images.
		clearBtn.addActionListener(e -> {
			userInput.setText("");
			conversionResultLabel.setText("");
			snowImage.setVisible(false);
			sunImage.setVisible(false);
		});

		ConversionFrame.tabPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent changeEvent) {

				if (ConversionFrame.tabPane.getSelectedIndex() == 2) {

					userInput.setText("");
					conversionResultLabel.setText("");
					snowImage.setVisible(false);
					sunImage.setVisible(false);

				}

			}
		});
	}

	private double convertCtoF(double temperature) {
		DecimalFormat f = new DecimalFormat("#.#");
		return Double.parseDouble(f.format(((temperature * 9) / 5) + 32));
	}

	public class CreatePanel extends JPanel {
		public CreatePanel() {
			setBackground(new Color(172, 209, 246));
		}
	}
}
