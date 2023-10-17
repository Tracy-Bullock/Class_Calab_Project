/**
 * Christopher Looper
 * CMIS 242
 * This class configures the Miles to Kilometers Tab in our group project.
 */
package conversionApp;

import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;

public class MiToKm extends JPanel {

	// ------------------------------------
	// global variables for use in class
	// ------------------------------------
	private JButton btnGo, btnClear;
	private JTextField input;
	private JLabel results, repeat, pic, intro, intro2;

	private DecimalFormat twoplaces = new DecimalFormat("0.00");

	ImageIcon MtoKIcon = new ImageIcon(
			Toolkit.getDefaultToolkit().getImage(ConversionMain.class.getResource("/images/milestokilometers2.png")));
	ImageIcon SadfaceIcon = new ImageIcon(
			Toolkit.getDefaultToolkit().getImage(ConversionMain.class.getResource("/images/sadface2.png")));
	ImageIcon ShockedfaceIcon = new ImageIcon(
			Toolkit.getDefaultToolkit().getImage(ConversionMain.class.getResource("/images/shockedface2.png")));

	// -------------------------------------------
	// constructor that controls panel
	// -------------------------------------------
	public MiToKm() {
		initComponents();
		createEvents();
	}

	// ---------------------------------------------
	// method that initializes components of panel
	// ---------------------------------------------
	private void initComponents() {

		setLayout(null);
		setBackground(Color.YELLOW);
		setBorder(new EmptyBorder(5, 5, 5, 5));

		pic = new JLabel("");
		pic.setIcon(MtoKIcon);
		pic.setBounds(220, 175, 125, 125);
		add(pic);

		intro = new JLabel(
				"Hello, My job is to help you to convert Miles to Kilometers! Please enter a non-negative number in");
		intro.setForeground(Color.BLUE);
		intro.setFont(new Font("Times New Roman", Font.BOLD, 13));
		intro.setBounds(5, 0, 565, 18);
		add(intro);

		intro2 = new JLabel("the open space and press GO.");
		intro2.setForeground(Color.BLUE);
		intro2.setFont(new Font("Times New Roman", Font.BOLD, 13));
		intro2.setBounds(5, 18, 565, 18);
		add(intro2);

		btnGo = new JButton("GO");
		btnGo.setBounds(5, 51, 65, 23);
		btnGo.setForeground(Color.WHITE);
		btnGo.setBackground(Color.BLUE);
		btnGo.setToolTipText("Click to convert the input for miles into kilometers.");
		add(btnGo);

		btnClear = new JButton("Clear");
		btnClear.setBounds(500, 320, 65, 23);
		btnClear.setForeground(Color.GREEN);
		btnClear.setBackground(Color.BLACK);
		add(btnClear);

		input = new JTextField();
		input.setBounds(75, 51, 75, 23);
		input.setToolTipText("Please enter a non-negative number of miles to convert to kilometers.");
		add(input); // Add my user input textfield to the panel.

		results = new JLabel();
		results.setBounds(152, 51, 435, 23); // Set the location and size of the label on the panel.
		add(results); // Add the user output label to the panel.

		repeat = new JLabel();
		repeat.setBounds(5, 89, 500, 18);
		add(repeat);

	}

	// ---------------------------------------------
	// method that creates events for panel
	// ---------------------------------------------
	private void createEvents() {

		btnGo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String text = input.getText(); // Gets the user input for the conversion.
					float number = Float.parseFloat(text); // Parses the user input so that it is converted to a float.
					if (number < 1) {
						throw new Exception();
					} // Negative number Exception.
					double answer = number * 1.609; // Runs the input through the equation then creates an output to be
													// used.
					if (number == 1) {
						results.setFont(new Font("Times New Roman", Font.BOLD, 13));
						results.setForeground(Color.BLUE);
						results.setText(
								"--> " + text + " Mile is equal to " + twoplaces.format(answer) + " Kilometers");
						pic.setIcon(MtoKIcon);
					} else {
						results.setFont(new Font("Times New Roman", Font.BOLD, 13));
						results.setForeground(Color.BLUE);
						results.setText(
								"--> " + text + " Miles is equal to " + twoplaces.format(answer) + " Kilometers"); // Uses
																													// the
																													// output
																													// to
																													// give
																													// the
																													// user
																													// an
																													// answer
																													// and
																													// prompt
																													// them
																													// to
																													// go
																													// again.
						pic.setIcon(MtoKIcon);
					}
				} catch (NumberFormatException i) // Catch in case the user input anything other than a number.
				{
					results.setFont(new Font("Times New Roman", Font.BOLD, 13));
					results.setForeground(Color.BLUE);
					results.setText("-->Thats not a number!"); // Output set for user.
					pic.setIcon(ShockedfaceIcon);
				} catch (Exception i) // Negative number exception.
				{
					results.setFont(new Font("Times New Roman", Font.BOLD, 13));
					results.setForeground(Color.BLUE);
					results.setText("--> Distance can't be negative!"); // Output set for user.
					pic.setIcon(SadfaceIcon);
				}
				input.setText("");
				repeat.setFont(new Font("Times New Roman", Font.BOLD, 13));
				repeat.setForeground(Color.BLUE);
				repeat.setText("If you would like to go again please enter a new number and press the GO button.");

			}
		});
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changePanel("MtoK");
			}
		});

		ConversionFrame.tabPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent changeEvent) {
				if (ConversionFrame.tabPane.getSelectedIndex() == 4) {
					changePanel("MtoK");
				}

			}
		});

	}

	private void changePanel(String selection) {

		if (selection.equalsIgnoreCase("MtoK")) {

			pic.setIcon(MtoKIcon);
			results.setText("");
			repeat.setText("");
		}
	}
}
