/**
 * CMIS 242
 * This class configures the JFrame to hold all components in our group project.
 */
package conversionApp;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

//------------------------------
// class for JFrame
//------------------------------
public class ConversionFrame extends JFrame {

	public static JTabbedPane tabPane;
	private JButton btnMusic, btnExit;
	private Boolean musicOn = true;
	private Font programFont;
	private Clip musicClip;
	private Logo logo;
	private Timer logoTimer;

	// -------------------------------------------
	// constructor that controls frame
	// -------------------------------------------
	public ConversionFrame() {

		initComponents();
		createEvents();
		playMusic();

	}

	// ---------------------------------------------
	// method that initializes compnents of frame
	// ---------------------------------------------
	private void initComponents() {

		setTitle("WestingHouse Conversion Program");
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(ConversionMain.class.getResource("/images/westinghouse.png")));
		setSize(591, 475);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		setResizable(false);

		programFont = new Font("Copperplate Gothic Bold", Font.PLAIN, 11);

		logo = new Logo();
		add(logo);

		addTabPane();

		JPanel optionPanel = new JPanel();
		optionPanel.setLayout(null);
		optionPanel.setBackground(Color.RED);
		optionPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		optionPanel.setBounds(5, 407, 569, 24);
		add(optionPanel);

		JLabel lblMusic = new JLabel("Music:");
		lblMusic.setBounds(50, 2, 59, 20);
		lblMusic.setForeground(Color.BLUE);
		lblMusic.setFont(programFont);
		optionPanel.add(lblMusic);

		btnMusic = new JButton("On/Off");
		btnMusic.setBounds(98, 2, 89, 20);
		btnMusic.setToolTipText("Click to turn music on or off.");
		btnMusic.setFont(programFont);
		optionPanel.add(btnMusic);

		JLabel lblExit = new JLabel("Close program:");
		lblExit.setBounds(330, 2, 100, 20);
		lblExit.setForeground(Color.BLUE);
		lblExit.setFont(programFont);
		optionPanel.add(lblExit);

		btnExit = new JButton("Exit");
		btnExit.setBounds(440, 2, 89, 20);
		btnExit.setToolTipText("Click to exit program.");
		btnExit.setFont(programFont);
		optionPanel.add(btnExit);

		setVisible(true);

	}

	// -------------------------------------------
	// method to control events
	// -------------------------------------------
	private void createEvents() {

		// -------------------------------------------
		// when close is selected prompt user
		// -------------------------------------------
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {

				exitProgram();
			}
		});

		btnMusic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (musicOn == true) {

					musicOn = false;
					musicClip.stop();
				} else if (musicOn == false) {

					musicOn = true;
					playMusic();
				}

			}
		});

		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				exitProgram();

			}
		});

	}

	private void playMusic() {

		AudioInputStream audioStream;

		try {
			audioStream = AudioSystem
					.getAudioInputStream(getClass().getResourceAsStream("/audio/Islabonita - An Jone.wav"));

			try {
				musicClip = AudioSystem.getClip();

				try {
					musicClip.open(audioStream);

				} catch (IOException e) {
					
					e.printStackTrace();
				}
				musicClip.start();
				musicClip.loop(musicClip.LOOP_CONTINUOUSLY);

			} catch (LineUnavailableException e) {
				
				e.printStackTrace();
			}

		} catch (UnsupportedAudioFileException e1) {
			
			e1.printStackTrace();

		} catch (IOException e1) {
			
			e1.printStackTrace();
		}
	}

	public void addTabPane() {

		logoTimer = new Timer(4500, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				remove(logo);
				repaint();
				// -----------------------------------
				// tabpane to hold panels in tabs
				// -----------------------------------
				tabPane = new JTabbedPane(JTabbedPane.TOP);
				tabPane.setBounds(0, 0, 580, 400);
				tabPane.setFont(programFont);
				tabPane.setBackground(new Color(204, 102, 0));
				tabPane.addTab("INTRODUCTION", new Intro());
				tabPane.addTab("FAHRENHEIT TO CELSIUS", new FahrToCels());
				tabPane.addTab("CELSIUS TO FAHRENHEIT", new CelsToFahr());
				tabPane.addTab("KILOMETERS TO MILES", new KmToMi());
				tabPane.addTab("MILES TO KILOMETERS", new MiToKm());
				tabPane.addTab("ABOUT US", new AboutUs());
				add(tabPane);

			}
		});

		logoTimer.setRepeats(false);
		logoTimer.start();
	}

	public void exitProgram() {

		int close = JOptionPane.showConfirmDialog(null, "\n  Would you like to close this application?        ",
				"Warning", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
		
		if (close == JOptionPane.YES_OPTION) {
			setVisible(false);
			JOptionPane.showMessageDialog(null, "", "GROUP TRACY ENTERTAINMENT", JOptionPane.PLAIN_MESSAGE,
					new ImageIcon(Toolkit.getDefaultToolkit()
							.getImage(ConversionMain.class.getResource("/images/outroVid.gif"))));
			System.exit(0);

		}
	}

}
