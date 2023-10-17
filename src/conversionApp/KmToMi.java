/**
 * Jordan Fluit
 * CMIS 242
 * This class configures the Kilometers to Miles Tab in our group project.
 */
package conversionApp;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;

public final class KmToMi extends JPanel {

	// Assigned Varriables
	JButton btnStart, btnClear;
	JTextField input;
	JLabel intro, intro2, intro3, results, repeat, pics;
	// images and gif's used
	ImageIcon KiToMi = new ImageIcon(
			Toolkit.getDefaultToolkit().getImage(ConversionMain.class.getResource("/images/ktmimage.png")));
	ImageIcon noIcon = new ImageIcon(
			Toolkit.getDefaultToolkit().getImage(ConversionMain.class.getResource("/images/nono.gif")));

	// Control panel constructor
	public KmToMi() {
		initComponents();
		createEvents();
	}

	private void initComponents() {

		setLayout(null); // For centering
		setBackground(Color.CYAN); // Background color
		setBorder(new EmptyBorder(10, 10, 10, 10));

		pics = new JLabel("");
		pics.setIcon(KiToMi);
		pics.setBounds(100, 40, 350, 300);
		add(pics);

		// three seperate intro labels with various font sizes for asthetic purpose
		intro = new JLabel("Welcome! ");
		intro.setBounds(30, 10, 565, 50);
		float newSize = 20; // increases the font size of the welcome label
		intro.setFont(intro.getFont().deriveFont(newSize));
		add(intro);
		intro2 = new JLabel("Planning a trip to one of the the only three countries in the world who use miles?? ");
		intro2.setBounds(30, 25, 565, 50);

		add(intro2);

		intro3 = new JLabel("To convert Kilometers to miles enter a distance into the box and select start");
		intro3.setBounds(30, 40, 565, 50);
		add(intro3);

		// button added that runs user input
		btnStart = new JButton("Start");
		btnStart.setBounds(150, 300, 70, 30);
		btnStart.setBackground(Color.MAGENTA);
		btnStart.setToolTipText("Click to convert the input for miles into kilometers.");
		add(btnStart);

		input = new JTextField();
		input.setBounds(75, 300, 75, 23);
		input.setToolTipText("Please enter a non-negative number of miles to convert to kilometers.");
		add(input); // box for user input
		// Clear button
		btnClear = new JButton("Clear"); // clear button added to declutter the panel if user wants to run again
		btnClear.setBounds(250, 300, 65, 23);
		add(btnClear);

		results = new JLabel();
		results.setForeground(Color.ORANGE); // if user inputs a positive digit results will be orange and easier to see
		results.setBounds(50, 70, 435, 23);
		add(results); // displays output

		// allows the program to run again for additional conversions
		repeat = new JLabel();
		repeat.setBounds(5, 89, 500, 18);
		add(repeat);

	}

	private void createEvents() {

		btnStart.addActionListener((ActionEvent e) -> {
			try {
				String text = input.getText(); // recieves user input
				float number = Float.parseFloat(text); // float conversion
				if (number < 1) {
					throw new Exception();
				} // Negative number Exception.
				double answer = number / 1.609; // equation used to calculate miles
				if (number == 1) {
					results.setText("--> " + text + " Kilometers is equal to " + answer + " Miles");
					pics.setIcon(KiToMi);
				} else {
					results.setText("--> " + text + " Kilometers is equal to " + answer + " Miles"); // Uses the output
																										// to give the
																										// user an
																										// answer and
																										// prompt them
																										// to go again.
					pics.setIcon(KiToMi);
				}
			} catch (NumberFormatException i) // if user inputs anything other than a number this catch outputs error
												// message in red text
			{
				results.setText("PLEASE INPUT A NUMBER NOT A LETTER!");
				results.setForeground(Color.RED);
				results.setBounds(50, 70, 435, 23);

				pics.setIcon(noIcon);
				pics.setBounds(50, 80, 550, 220);

			} catch (Exception i) // negative input exception
			{
				results.setText("--> You know distance can't be negative right?");
				results.setForeground(Color.RED); // if negative number is input, output will be red
				results.setBounds(50, 70, 435, 23);
				pics.setIcon(noIcon);
				pics.setBounds(50, 80, 550, 220);
			}
			input.setText("");
			repeat.setText("If you would like to make another conversion, enter a distance and select Start.");
		});
		// allows clear button to funtion properly
		btnClear.addActionListener((ActionEvent e) -> {
			changePanel("KtoM");
		});

		ConversionFrame.tabPane.addChangeListener((ChangeEvent changeEvent) -> {
			if (ConversionFrame.tabPane.getSelectedIndex() == 3) {
				changePanel("KtoM");
			}
		});

	}

	private void changePanel(String selection) {

		if (selection.equalsIgnoreCase("KtoM")) {

			pics.setIcon(KiToMi);
			results.setText("");
			repeat.setText("");
		}
	}
}
