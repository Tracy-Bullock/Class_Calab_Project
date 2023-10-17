/**
 * Tracy Bullock
 * CMIS 242
 * This class configures the About Us Tab in our group project.
 */
package conversionApp;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;

//------------------------------
// class for aboutus panel
//------------------------------
public class AboutUs extends JPanel {

	// ------------------------------------
	// gloabl variables for use in class
	// ------------------------------------
	private JPanel geekPanel, geekettePanel;
	private JLabel lblGeek, lblGeekette, lblTracy, lblJordan, lblAustin, lblErika, lblChris, lblRobert;
	private JButton btnGeek, btnGeekette, btnTracy, btnJordan, btnAustin, btnErika, btnChris, btnRobert, btnBack;
	private Font geekFont, geeketteFont;
	private LineBorder geekBorder, geeketteBorder;
	private ImageIcon geekIcon, geeketteIcon, tracyIcon, jordanIcon, austinIcon, erikaIcon, chrisIcon, robertIcon;

	// -------------------------------------------
	// constructor that controls panel
	// -------------------------------------------
	public AboutUs() {

		initComponents();
		createEvents();

	}

	// ---------------------------------------------
	// method that initializes compnents of panel
	// ---------------------------------------------
	private void initComponents() {

		setLayout(null);
		setBackground(Color.CYAN);
		setBorder(new EmptyBorder(5, 5, 5, 5));

		geekPanel = new JPanel();
		geekPanel.setLayout(null);
		geekPanel.setBackground(Color.BLUE);
		geekPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		geekPanel.setBounds(0, 0, 282, 407);
		add(geekPanel);

		geekFont = new Font("Tarzan", Font.PLAIN, 11);
		geeketteFont = new Font("Snowdrift", Font.BOLD, 11);

		geekettePanel = new JPanel();
		geekettePanel.setLayout(null);
		geekettePanel.setBackground(Color.PINK);
		geekettePanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		geekettePanel.setBounds(293, 0, 282, 407);
		add(geekettePanel);

		lblGeek = new JLabel("");
		geekIcon = new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(ConversionMain.class.getResource("/images/geek.png")));
		lblGeek.setIcon(geekIcon);
		lblGeek.setBounds(10, 20, 240, 180);
		geekPanel.add(lblGeek);

		btnGeek = new JButton("GEEKS");
		btnGeek.setBounds(100, 230, 89, 23);
		btnGeek.setToolTipText("Click for information about the geeks.");
		btnGeek.setFont(geekFont);
		btnGeek.setBackground(Color.CYAN);
		btnGeek.setForeground(Color.BLUE);
		geekPanel.add(btnGeek);

		lblGeekette = new JLabel("");
		geeketteIcon = new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(ConversionMain.class.getResource("/images/Geekette.png")));
		lblGeekette.setIcon(geeketteIcon);
		lblGeekette.setBounds(10, 20, 250, 180);
		geekettePanel.add(lblGeekette);

		btnGeekette = new JButton("GEEKETTES");
		btnGeekette.setBounds(90, 230, 110, 23);
		btnGeekette.setToolTipText("Click for information about the geekettes.");
		btnGeekette.setFont(geeketteFont);
		btnGeekette.setBackground(Color.CYAN);
		btnGeekette.setForeground(Color.MAGENTA);
		geekettePanel.add(btnGeekette);

		geekBorder = new LineBorder(Color.BLUE, 3);
		geeketteBorder = new LineBorder(Color.MAGENTA, 3);

		lblTracy = new JLabel("");
		tracyIcon = new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(ConversionMain.class.getResource("/images/Tracy.png")));
		lblTracy.setIcon(tracyIcon);
		lblTracy.setBounds(39, 11, 125, 125);
		lblTracy.setBorder(geekBorder);

		lblJordan = new JLabel("");
		jordanIcon = new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(ConversionMain.class.getResource("/images/Jordan.png")));
		lblJordan.setIcon(jordanIcon);
		lblJordan.setBounds(39, 11, 125, 125);
		lblJordan.setBorder(geeketteBorder);

		lblAustin = new JLabel("");
		austinIcon = new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(ConversionMain.class.getResource("/images/Austin.png")));
		lblAustin.setIcon(austinIcon);
		lblAustin.setBounds(219, 11, 125, 125);
		lblAustin.setBorder(geekBorder);

		lblErika = new JLabel("");
		erikaIcon = new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(ConversionMain.class.getResource("/images/Erika.png")));
		lblErika.setIcon(erikaIcon);
		lblErika.setBounds(219, 11, 125, 125);
		lblErika.setBorder(geeketteBorder);

		lblChris = new JLabel("");
		chrisIcon = new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(ConversionMain.class.getResource("/images/Chris.png")));
		lblChris.setIcon(chrisIcon);
		lblChris.setBounds(406, 11, 125, 125);
		lblChris.setBorder(geekBorder);

		lblRobert = new JLabel("");
		robertIcon = new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(ConversionMain.class.getResource("/images/Robert.png")));
		lblRobert.setIcon(robertIcon);
		lblRobert.setBounds(39, 183, 125, 125);
		lblRobert.setBorder(geekBorder);

		btnTracy = new JButton("Tracy");
		btnTracy.setBounds(56, 141, 89, 23);
		btnTracy.setToolTipText("Click for information about Tracy.");
		btnTracy.setFont(geekFont);
		btnTracy.setForeground(Color.WHITE);
		btnTracy.setBackground(Color.BLUE);

		btnJordan = new JButton("Jordan");
		btnJordan.setBounds(56, 141, 89, 23);
		btnJordan.setToolTipText("Click for information about Jordan.");
		btnJordan.setFont(geeketteFont);
		btnJordan.setForeground(Color.WHITE);
		btnJordan.setBackground(Color.MAGENTA);

		btnAustin = new JButton("Austin");
		btnAustin.setBounds(236, 141, 89, 23);
		btnAustin.setToolTipText("Click for information about Austin.");
		btnAustin.setFont(geekFont);
		btnAustin.setForeground(Color.WHITE);
		btnAustin.setBackground(Color.BLUE);

		btnErika = new JButton("Erika");
		btnErika.setBounds(236, 141, 89, 23);
		btnErika.setToolTipText("Click for information about Erika.");
		btnErika.setFont(geeketteFont);
		btnErika.setForeground(Color.WHITE);
		btnErika.setBackground(Color.MAGENTA);

		btnChris = new JButton("Chris");
		btnChris.setBounds(423, 141, 89, 23);
		btnChris.setToolTipText("Click for information about Chris.");
		btnChris.setFont(geekFont);
		btnChris.setForeground(Color.WHITE);
		btnChris.setBackground(Color.BLUE);

		btnRobert = new JButton("Robert");
		btnRobert.setBounds(56, 313, 89, 23);
		btnRobert.setToolTipText("Click for information about Robert.");
		btnRobert.setFont(geekFont);
		btnRobert.setForeground(Color.WHITE);
		btnRobert.setBackground(Color.BLUE);

		btnBack = new JButton("Back");
		btnBack.setBounds(500, 320, 65, 23);
		btnBack.setToolTipText("Click to return to Geek/Geekete screen.");
		btnBack.setForeground(Color.WHITE);

	}

	// ---------------------------------------------
	// method that creates events for panel
	// ---------------------------------------------
	private void createEvents() {

		btnGeek.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				changePanel("geek");
			}
		});

		btnGeekette.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				changePanel("geekette");
			}
		});

		btnTracy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JOptionPane.showMessageDialog(null,
						"\nHi,\n\nMy name is Tracy Bullock and I live in Lidwigshafen, Germany.\n"
								+ "I am currently a student at UMGC, persuing a Bachelor's degree \nin Computer Networks and Cybersecurity, "
								+ "with a minor in\nComputer Science. I enjoy traveling, developing programs, \nweight lifting, and most of all, spending time with my four children!     \n ",
						"ABOUT TRACY", JOptionPane.PLAIN_MESSAGE, tracyIcon);
			}
		});

		btnJordan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JOptionPane.showMessageDialog(null,
						"\nHi,\n\nMy name is Jordan Fluit, and I live in Grafenwoher, Germany.\n"
								+ "I am currently a student at UMGC, majoring in Cybersecurity,     \n"
								+ "and I love cats, books, and video games!\n ",
						"ABOUT JORDAN", JOptionPane.PLAIN_MESSAGE, jordanIcon);
			}
		});

		btnAustin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JOptionPane.showMessageDialog(null,
						"\nHi,\n\nMy name is Austin Gescheidle, and I am 34 years young.\n"
								+ "I am currently a student at UMGC, majoring in Computer Science,\n"
								+ "a medic in the Air Force, a loving husband, and soon to be father!     \n ",
						"ABOUT AUSTIN", JOptionPane.PLAIN_MESSAGE, austinIcon);
			}
		});

		btnErika.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JOptionPane.showMessageDialog(null,
						"\nHi,\n\nMy name is Erika Andrea Sanchez and I live in Vilseck, Germany.\n"
								+ "I am currently a student at UMGC, majoring in Computer Science,     \n"
								+ "and I love to travel and visit as many churches as I can!\n ",
						"ABOUT ERIKA", JOptionPane.PLAIN_MESSAGE, erikaIcon);
			}
		});

		btnChris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JOptionPane.showMessageDialog(null,
						"\nHi,\n\nMy name is Christopher Looper, and I am from Clemson, South Carolina.\n"
								+ "I am currently a student at UMGC and have been in the Air Force for the last 9 years.     \n"
								+ "The best thing of all, I will be getting married in July!\n ",
						"ABOUT CHRIS", JOptionPane.PLAIN_MESSAGE, chrisIcon);
			}
		});

		btnRobert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JOptionPane.showMessageDialog(null,
						"\nHi,\n\nMy name is Robert Mittnight, and I live in Spangdahlem, Germany.\n"
								+ "I am happily married with a beautiful daughter and am currently a student at UMGC,     \n"
								+ "that loves good coffee and the New York Yankees!\n ",
						"ABOUT ROBERT", JOptionPane.PLAIN_MESSAGE, robertIcon);
			}
		});

		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				changePanel("aboutus");
			}
		});

		ConversionFrame.tabPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent changeEvent) {

				if (ConversionFrame.tabPane.getSelectedIndex() == 5) {

					changePanel("aboutus");

				}

			}
		});

	}

	// ------------------------------------------------------
	// method that changes panel for geek & geekette info
	// ------------------------------------------------------
	public void changePanel(String selection) {

		removeAll();
		repaint();

		if (selection.equalsIgnoreCase("geek")) {

			setBackground(Color.CYAN);
			add(lblTracy);
			add(lblAustin);
			add(lblChris);
			add(lblRobert);
			add(btnTracy);
			add(btnAustin);
			add(btnChris);
			add(btnRobert);
			add(btnBack);
			btnBack.setFont(geekFont);
			btnBack.setBackground(Color.BLUE);

		} else if (selection.equalsIgnoreCase("geekette")) {

			setBackground(Color.PINK);
			add(lblJordan);
			add(lblErika);
			add(btnJordan);
			add(btnErika);
			add(btnBack);
			btnBack.setFont(geeketteFont);
			btnBack.setBackground(Color.MAGENTA);

		} else {

			setBackground(Color.CYAN);
			add(geekPanel);
			add(geekettePanel);
			geekPanel.add(lblGeek);
			geekettePanel.add(lblGeekette);
			geekPanel.add(btnGeek);
			geekettePanel.add(btnGeekette);
		}

	}

}
