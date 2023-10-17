/**
 * Austin Gescheidle
 * CMIS 242
 * This class configures the introduction Tab in our group project.
 */
package conversionApp;

import java.awt.*;
import javax.swing.Timer;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import javax.swing.plaf.*;
import java.util.*;
import java.awt.event.*;

public class Intro extends JPanel {

	private JTextArea introTextArea, explainC2F, explainF2C, explainM2K, explainK2M, explainAbout;
	private String introText, explainC2Ftext, explainF2CFtext, explainM2Ktext, explainK2Mtext, explainAboutText;
	private Timer timer, timerC2F, timerF2C, timerK2M, timerM2K, timerAbout;
	private int i, i2, i3, i4, i5, i6 = 0;

	public Intro() {

		createEvents();
		initComponents();

	}

	private void initComponents() {

		setLayout(null);
		setBackground(Color.BLACK);
		setBorder(new EmptyBorder(5, 5, 5, 5));

		Font textFont = new FontUIResource("Rockwell", Font.PLAIN, 12);
		Color textColor = new Color(51, 255, 51);

		introTextArea = new JTextArea();
		introTextArea.setBounds(5, 60, 560, 45);
		introTextArea.setBackground(Color.BLACK);
		introTextArea.setForeground(textColor);
		introTextArea.setFont(textFont);
		introTextArea.setLineWrap(true);
		introTextArea.setWrapStyleWord(true);
		introTextArea.setEditable(false);
		introTextArea.setDragEnabled(false);
		introText = "Thank you for using Westinghouse's propriatary conversion program. Here you will be able to"
				+ " convert imperial units to metric and vice-versa! All you need to do is click on the tabs above."
				+ " and enter the value you need converted.";
		add(introTextArea);

		explainC2F = new JTextArea();
		explainC2F.setBounds(5, 140, 340, 12);
		explainC2F.setBackground(Color.BLACK);
		explainC2F.setForeground(textColor);
		explainC2F.setFont(textFont);
		explainC2F.setToolTipText("Creator: Robert Mittnight");
		explainC2F.setEditable(false);
		explainC2F.setDragEnabled(false);
		explainC2Ftext = "The \"Celcius to Farenheit\" tab converts Celcius to Farenheit.";
		add(explainC2F);

		explainF2C = new JTextArea();
		explainF2C.setBounds(5, 162, 340, 12);
		explainF2C.setBackground(Color.BLACK);
		explainF2C.setForeground(textColor);
		explainF2C.setFont(textFont);
		explainF2C.setToolTipText("Creator: Erika Sanchez");
		explainF2C.setEditable(false);
		explainF2C.setDragEnabled(false);
		explainF2CFtext = "The \"Farenheit to Celcius\" tab converts Farenheit to Celcius.";
		add(explainF2C);

		explainM2K = new JTextArea();
		explainM2K.setBounds(5, 184, 340, 12);
		explainM2K.setBackground(Color.BLACK);
		explainM2K.setForeground(textColor);
		explainM2K.setFont(textFont);
		explainM2K.setToolTipText("Creator: Christopher Looper");
		explainM2K.setEditable(false);
		explainM2K.setDragEnabled(false);
		explainM2Ktext = "The \"Miles to Kilometers\" tab converts Miles to Kilometers.";
		add(explainM2K);

		explainK2M = new JTextArea();
		explainK2M.setBounds(5, 206, 340, 12);
		explainK2M.setBackground(Color.BLACK);
		explainK2M.setForeground(textColor);
		explainK2M.setFont(textFont);
		explainK2M.setToolTipText("Creator: Jordan Fluit");
		explainK2M.setEditable(false);
		explainK2M.setDragEnabled(false);
		explainK2Mtext = "The \"Kilometers to Miles\" tab converts Kilometers to Miles.";
		add(explainK2M);

		explainAbout = new JTextArea();
		explainAbout.setBounds(5, 228, 400, 12);
		explainAbout.setBackground(Color.BLACK);
		explainAbout.setForeground(textColor);
		explainAbout.setFont(textFont);
		explainAbout.setToolTipText("Creator: Tracy Bullock");
		explainAbout.setEditable(false);
		explainAbout.setDragEnabled(false);
		explainAboutText = "The \"About Us\" tab provides information about the development team.";
		add(explainAbout);

		timer.start();
		timerC2F.setInitialDelay(7000);
		timerC2F.start();
		timerF2C.setInitialDelay(8000);
		timerF2C.start();
		timerM2K.setInitialDelay(10000);
		timerM2K.start();
		timerK2M.setInitialDelay(12000);
		timerK2M.start();
		timerAbout.setInitialDelay(14000);
		timerAbout.start();

	}

	private void createEvents() {

		timer = new Timer(30, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				char character[] = introText.toCharArray();
				int arrayNumber = character.length;

				String s = String.valueOf(character[i]);

				introTextArea.append(s);

				i++;

				if (i == arrayNumber) {
					i = 0;
					timer.stop();
				}
			}
		});

		timerC2F = new Timer(5, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				char character2[] = explainC2Ftext.toCharArray();
				int arrayNumber2 = character2.length;

				String s2 = String.valueOf(character2[i2]);

				explainC2F.append(s2);

				i2++;

				if (i2 == arrayNumber2) {
					i2 = 0;
					timerC2F.stop();
				}
			}
		});

		timerF2C = new Timer(30, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				char character3[] = explainF2CFtext.toCharArray();
				int arrayNumber3 = character3.length;

				String s3 = String.valueOf(character3[i3]);

				explainF2C.append(s3);

				i3++;

				if (i3 == arrayNumber3) {
					i3 = 0;
					timerF2C.stop();
				}
			}
		});

		timerM2K = new Timer(30, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				char character4[] = explainM2Ktext.toCharArray();
				int arrayNumber4 = character4.length;

				String s4 = String.valueOf(character4[i4]);

				explainM2K.append(s4);

				i4++;

				if (i4 == arrayNumber4) {
					i4 = 0;
					timerM2K.stop();
				}
			}
		});

		timerK2M = new Timer(30, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				char character5[] = explainK2Mtext.toCharArray();
				int arrayNumber5 = character5.length;

				String s5 = String.valueOf(character5[i5]);

				explainK2M.append(s5);

				i5++;

				if (i5 == arrayNumber5) {
					i5 = 0;
					timerK2M.stop();
				}
			}
		});

		timerAbout = new Timer(30, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				char character6[] = explainAboutText.toCharArray();
				int arrayNumber6 = character6.length;

				String s6 = String.valueOf(character6[i6]);

				explainAbout.append(s6);

				i6++;

				if (i6 == arrayNumber6) {
					i6 = 0;
					timerAbout.stop();
				}
			}
		});

	}

}