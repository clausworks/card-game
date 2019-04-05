/*
 * Name: Nicholas Brunet
 * Class: CIS 111 (Antelope Valley College)
 * Professor: Alec Winetrobe
 * 
 * Project: Lab 5b
 * Due: 3/15/19
 * 
 * Description: This program imitates the "War" card game. The user picks his
 * side (Apple or Microsoft) and the number of rounds he wishes to play. Then,
 * he deals that number of rounds. Each round, his card is compared with the
 * computer's card, and the winner receives one point. If there is a tie, the
 * winners each receive a point. If, at the end of the chosen number of rounds
 * the user and computer are still tied, they enter overtime, and continue
 * playing until the tie is broken.
 */


import java.awt.EventQueue;

import javax.swing.text.MaskFormatter;

import javax.swing.JFrame;
import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JPanel;

import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.text.NumberFormat;

import javax.swing.JFormattedTextField;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JSpinner;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class MainWindow {
	int totalRounds = 5;
	private int player = 0;

	// declare components
	private JFrame frame;

	private JPanel introPanel;
	private JPanel gamePanel;
	private JPanel endPanel;

	private JButton playButton;
	private JButton quitButton;
	private JButton dealButton;
	private JLabel userCardImage;
	private JLabel compCardImage;
	private JLabel userWinImage;
	private JLabel compWinImage;
	private JLabel userLabel;
	private JLabel compLabel;
	private JLabel lblRound;
	private JLabel roundCounterLabel;
	private JLabel overtimeIndicator;
	private JLabel userScoreLabel;
	private JLabel compScoreLabel;
	private JLabel lblNewLabel;
	private JLabel resultText;
	private JLabel finalScore;
	private JLabel lblSeeCreditstxtFor;
	private JLabel player1Image;
	private JLabel player2Image;
	private JButton player1SelectButton;
	private JButton player2SelectButton;
	private JLabel lblPickAPlayer;
	private JLabel lblApple;
	private JLabel lblMicrosoft;
	private JLabel lblEnterNumberOf;
	private JFormattedTextField numRoundsField;
	private JLabel userWinsLabel;
	private JLabel compWinsLabel;
	private JSeparator separator;
	private JSeparator separator_1;
	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */

	public MainWindow() {
		initialize();
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// declare variables

		frame = new JFrame();
		frame.setMinimumSize(new Dimension(460, 460));
		frame.setBounds(100, 100, 460, 460);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));

		introPanel = new JPanel();
		frame.getContentPane().add(introPanel, "name_736909117960");
		GridBagLayout gbl_introPanel = new GridBagLayout();
		gbl_introPanel.columnWidths = new int[]{0, 0, 0};
		gbl_introPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_introPanel.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_introPanel.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		introPanel.setLayout(gbl_introPanel);

		playButton = new JButton("Play");
		playButton.setEnabled(false);
		playButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				totalRounds = (Integer)numRoundsField.getValue();
				totalRounds = ((Number)(numRoundsField.getValue())).intValue();
				roundCounterLabel.setText("0/" + totalRounds);

				CardLayout c = (CardLayout)(frame.getContentPane().getLayout());
				c.next(frame.getContentPane());
			}
		});
		
		NumberFormat format = NumberFormat.getIntegerInstance();
		format.setMaximumIntegerDigits(2);
		numRoundsField = new JFormattedTextField(format);
		numRoundsField.setText("5");
		try {
			numRoundsField.commitEdit();
		} catch (Exception e1) {
			System.out.println("ERROR: error setting text field");
		}
		numRoundsField.setColumns(10);
		GridBagConstraints gbc_numRoundsField = new GridBagConstraints();
		gbc_numRoundsField.anchor = GridBagConstraints.WEST;
		gbc_numRoundsField.insets = new Insets(0, 0, 5, 0);
		gbc_numRoundsField.gridx = 1;
		gbc_numRoundsField.gridy = 4;
		introPanel.add(numRoundsField, gbc_numRoundsField);
		GridBagConstraints gbc_playButton = new GridBagConstraints();
		gbc_playButton.gridwidth = 2;
		gbc_playButton.gridx = 0;
		gbc_playButton.gridy = 6;
		introPanel.add(playButton, gbc_playButton);

		lblPickAPlayer = new JLabel("Pick your side:");
		GridBagConstraints gbc_lblPickAPlayer = new GridBagConstraints();
		gbc_lblPickAPlayer.gridwidth = 2;
		gbc_lblPickAPlayer.insets = new Insets(0, 0, 5, 0);
		gbc_lblPickAPlayer.gridx = 0;
		gbc_lblPickAPlayer.gridy = 0;
		introPanel.add(lblPickAPlayer, gbc_lblPickAPlayer);

		lblApple = new JLabel("Apple");
		lblApple.setToolTipText("What's an Intel chip doing in a Mac? A whole lot more than it's ever done in a PC.");
		GridBagConstraints gbc_lblApple = new GridBagConstraints();
		gbc_lblApple.insets = new Insets(0, 0, 5, 5);
		gbc_lblApple.gridx = 0;
		gbc_lblApple.gridy = 1;
		introPanel.add(lblApple, gbc_lblApple);

		lblMicrosoft = new JLabel("Microsoft");
		lblMicrosoft.setToolTipText("Intel Inside.");
		GridBagConstraints gbc_lblMicrosoft = new GridBagConstraints();
		gbc_lblMicrosoft.insets = new Insets(0, 0, 5, 0);
		gbc_lblMicrosoft.gridx = 1;
		gbc_lblMicrosoft.gridy = 1;
		introPanel.add(lblMicrosoft, gbc_lblMicrosoft);

		player1Image = new JLabel("");
		player1Image.setToolTipText("It just works.");
		player1Image.setIcon(new ImageIcon(MainWindow.class.getResource("/img/player1-bw.png")));
		GridBagConstraints gbc_player1Image = new GridBagConstraints();
		gbc_player1Image.insets = new Insets(0, 0, 5, 5);
		gbc_player1Image.gridx = 0;
		gbc_player1Image.gridy = 2;
		introPanel.add(player1Image, gbc_player1Image);

		player2Image = new JLabel("");
		player2Image.setToolTipText("Hey, it could be worse.");
		player2Image.setIcon(new ImageIcon(MainWindow.class.getResource("/img/player2-bw.png")));
		GridBagConstraints gbc_player2Image = new GridBagConstraints();
		gbc_player2Image.insets = new Insets(0, 0, 5, 0);
		gbc_player2Image.gridx = 1;
		gbc_player2Image.gridy = 2;
		introPanel.add(player2Image, gbc_player2Image);

		player1SelectButton = new JButton("Select");
		player1SelectButton.setToolTipText("");
		player1SelectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				player = 1;
				playButton.setEnabled(true);
				player1SelectButton.setEnabled(false);
				player2SelectButton.setEnabled(true);
				player1Image.setIcon(new ImageIcon(MainWindow.class.getResource("/img/player1-color.png")));
				player2Image.setIcon(new ImageIcon(MainWindow.class.getResource("/img/player2-bw.png")));

			}
		});
		GridBagConstraints gbc_player1SelectButton = new GridBagConstraints();
		gbc_player1SelectButton.insets = new Insets(0, 0, 5, 5);
		gbc_player1SelectButton.gridx = 0;
		gbc_player1SelectButton.gridy = 3;
		introPanel.add(player1SelectButton, gbc_player1SelectButton);

		player2SelectButton = new JButton("Select");
		player2SelectButton.setToolTipText("Really?");
		player2SelectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				player = 2;
				playButton.setEnabled(true);
				player1SelectButton.setEnabled(true);
				player2SelectButton.setEnabled(false);
				player1Image.setIcon(new ImageIcon(MainWindow.class.getResource("/img/player1-bw.png")));
				player2Image.setIcon(new ImageIcon(MainWindow.class.getResource("/img/player2-color.png")));

			}
		});
		GridBagConstraints gbc_player2SelectButton = new GridBagConstraints();
		gbc_player2SelectButton.insets = new Insets(0, 0, 5, 0);
		gbc_player2SelectButton.gridx = 1;
		gbc_player2SelectButton.gridy = 3;
		introPanel.add(player2SelectButton, gbc_player2SelectButton);

		lblEnterNumberOf = new JLabel("Enter number of rounds:");
		GridBagConstraints gbc_lblEnterNumberOf = new GridBagConstraints();
		gbc_lblEnterNumberOf.insets = new Insets(0, 0, 5, 5);
		gbc_lblEnterNumberOf.anchor = GridBagConstraints.EAST;
		gbc_lblEnterNumberOf.gridx = 0;
		gbc_lblEnterNumberOf.gridy = 4;
		introPanel.add(lblEnterNumberOf, gbc_lblEnterNumberOf);
		

		gamePanel = new JPanel();
		gamePanel.setName("GAME_PANEL");
		frame.getContentPane().add(gamePanel, "name_759953111271");
		GridBagLayout gbl_gamePanel = new GridBagLayout();
		gbl_gamePanel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_gamePanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_gamePanel.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_gamePanel.rowWeights = new double[]{1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gamePanel.setLayout(gbl_gamePanel);
		
		userWinsLabel = new JLabel("YOU");
//		userWinsLabel.setForeground(userWinsLabel.getBackground());
		userWinsLabel.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		GridBagConstraints gbc_userWinsLabel = new GridBagConstraints();
		gbc_userWinsLabel.anchor = GridBagConstraints.SOUTH;
		gbc_userWinsLabel.insets = new Insets(0, 0, 5, 5);
		gbc_userWinsLabel.gridx = 0;
		gbc_userWinsLabel.gridy = 0;
		gamePanel.add(userWinsLabel, gbc_userWinsLabel);
		
		compWinsLabel = new JLabel("COMPUTER");
//		compWinsLabel.setForeground(compWinsLabel.getBackground());
		compWinsLabel.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		GridBagConstraints gbc_compWinsLabel = new GridBagConstraints();
		gbc_compWinsLabel.anchor = GridBagConstraints.SOUTH;
		gbc_compWinsLabel.insets = new Insets(0, 0, 5, 0);
		gbc_compWinsLabel.gridx = 2;
		gbc_compWinsLabel.gridy = 0;
		gamePanel.add(compWinsLabel, gbc_compWinsLabel);

		userCardImage = new JLabel("");
		userCardImage.setIcon(new ImageIcon(MainWindow.class.getResource("/img/card-default.png")));
		GridBagConstraints gbc_userCardImage = new GridBagConstraints();
		gbc_userCardImage.insets = new Insets(0, 0, 5, 5);
		gbc_userCardImage.gridx = 0;
		gbc_userCardImage.gridy = 1;
		gamePanel.add(userCardImage, gbc_userCardImage);
		
		separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.fill = GridBagConstraints.VERTICAL;
		gbc_separator.gridheight = 2;
		gbc_separator.insets = new Insets(0, 0, 5, 5);
		gbc_separator.gridx = 1;
		gbc_separator.gridy = 0;
		gamePanel.add(separator, gbc_separator);

		compCardImage = new JLabel("");
		compCardImage.setIcon(new ImageIcon(MainWindow.class.getResource("/img/card-default.png")));
		GridBagConstraints gbc_compCardImage = new GridBagConstraints();
		gbc_compCardImage.insets = new Insets(0, 0, 5, 0);
		gbc_compCardImage.gridx = 2;
		gbc_compCardImage.gridy = 1;
		gamePanel.add(compCardImage, gbc_compCardImage);

		userWinImage = new JLabel("");
		userWinImage.setIcon(new ImageIcon(MainWindow.class.getResource("/img/win-default.png")));
		GridBagConstraints gbc_userWinImage = new GridBagConstraints();
		gbc_userWinImage.insets = new Insets(0, 0, 5, 5);
		gbc_userWinImage.gridx = 0;
		gbc_userWinImage.gridy = 2;
		gamePanel.add(userWinImage, gbc_userWinImage);

		dealButton = new JButton("Deal");
		dealButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// random number generator
				Random compGenerator = new Random();
				Random userGenerator = new Random();

				// generate next card numbers
				int compCard = compGenerator.nextInt(12) + 2;
				int userCard = userGenerator.nextInt(12) + 2; // 2-14: 2 3 4 5 6 7 8 9 10 J Q K A

				// get old user scores from label
				int userScore = Integer.parseInt(userScoreLabel.getText());
				int compScore = Integer.parseInt(compScoreLabel.getText());

				// get round number
				int round; // get first character of round label (e.g. "3/5" --> 3)
				String roundString = roundCounterLabel.getText();
				String roundStringNumber = "";

				// declare filenames
				String userImageFilename;
				String compImageFilename;

				// set filenames for card images
				// user chose Apple
				if (player == 1) {
					userImageFilename = "/img/Apple-" + userCard + ".png";
					compImageFilename = "/img/Micro-" + compCard + ".png"; // TODO update for Microsoft
				}
				// user chose Microsoft
				else {
					userImageFilename = "/img/Micro-" + userCard + ".png"; // TODO update for Microsoft
					compImageFilename = "/img/Apple-" + compCard + ".png";
				}
				
				// reset labels to black
				userWinsLabel.setForeground(new Color(0, 0, 0));
				compWinsLabel.setForeground(new Color(0, 0, 0));


				// update images
				userCardImage.setIcon(new ImageIcon(MainWindow.class.getResource(userImageFilename)));
				compCardImage.setIcon(new ImageIcon(MainWindow.class.getResource(compImageFilename)));
				
				// determine current round from string (e.g. "3/5" or "15/18", or "4" for overtime)
				for (int i = 0; i < roundString.length(); ++i) {
					char c = roundString.charAt(i);
					if (Character.isDigit(c)) {
						roundStringNumber += c;
					}
					else {
						break;
					}
				}
				round = Integer.parseInt(roundStringNumber);

				// update round
				++round;

				// update round label with new value
				roundCounterLabel.setText(round + "/" + totalRounds);

				// user wins round
				if (userCard > compCard) {
					++userScore;
					userScoreLabel.setText( Integer.toString(userScore) );
					userWinImage.setIcon(new ImageIcon(MainWindow.class.getResource("/img/win.png")));
					compWinImage.setIcon(new ImageIcon(MainWindow.class.getResource("/img/lose.png")));
						
					compWinsLabel.setForeground(new Color(197, 44, 45));
					dealButton.setEnabled(false);
					
					// flash "YOU WIN" label
					new Thread(new Runnable() {
						@Override
						public void run() {
							
							try {
								for (int i = 0; i < 6; ++i) {
									// invisible
									if (userWinsLabel.getBackground() == userWinsLabel.getForeground()) {
										userWinsLabel.setForeground(new Color(45, 197, 61));
									}
									// visible
									else {
										userWinsLabel.setForeground(userWinsLabel.getBackground());
									}
									frame.repaint();
									
									// wait a while after displayed the last time
									if (i < 4) {
										Thread.sleep(200);
									}
									else if (i == 5) {
//										Thread.sleep(1000);
//										userWinsLabel.setForeground(new Color(0, 0, 0));
									}
								}
							} catch (InterruptedException e1) {
								e1.printStackTrace();
							}
							
						}
					}).start();
					
					dealButton.setEnabled(true);
				}
				// computer wins round
				else if (userCard < compCard) {
					++compScore;
					compScoreLabel.setText( Integer.toString(compScore) );
					compWinImage.setIcon(new ImageIcon(MainWindow.class.getResource("/img/win.png")));
					userWinImage.setIcon(new ImageIcon(MainWindow.class.getResource("/img/lose.png")));
					userWinsLabel.setForeground(new Color(197, 44, 45));

					dealButton.setEnabled(false);
					
					// flash "COMPUTER WINS" label
					new Thread(new Runnable() {
						@Override
						public void run() {
							
							try {
								for (int i = 0; i < 6; ++i) {
									// invisible
									if (compWinsLabel.getBackground() == compWinsLabel.getForeground()) {
										compWinsLabel.setForeground(new Color(45, 197, 61));
									}
									// visible
									else {
										compWinsLabel.setForeground(compWinsLabel.getBackground());
									}
									frame.repaint();
									
									// wait a while after displayed the last time
									if (i < 4) {
										Thread.sleep(200);
									}
									else if (i == 5) {
//										Thread.sleep(1000);
//										compWinsLabel.setForeground(new Color(0, 0, 0));
									}
								}
							} catch (InterruptedException e1) {
								e1.printStackTrace();
							}
							
							
						}
					}).start();
					
					dealButton.setEnabled(true);
				} 
				
				// tie - everyone gets a point
				else {
					++userScore;
					userWinImage.setIcon(new ImageIcon(MainWindow.class.getResource("/img/tie.png")));
					userScoreLabel.setText( Integer.toString(userScore) );

					++compScore;
					compScoreLabel.setText( Integer.toString(compScore) );
					compWinImage.setIcon(new ImageIcon(MainWindow.class.getResource("/img/tie.png")));

				}




				// determine whether to enter overtime
				System.out.println("Round " + round + "/" + totalRounds);
				if (round >= totalRounds) {

					// enter overtime
					//					userScore = compScore;
					if (userScore == compScore) {

						// first round of overtime
						if (round == totalRounds) {
							dealButton.setText("Enter Overtime");
						} else {
							dealButton.setText("Deal");
							System.out.println("Overtime");
							overtimeIndicator.setText("OVERTIME");
							overtimeIndicator.setForeground(new Color(252, 119, 34));
							overtimeIndicator.setFont(new Font("Lucida Grande", Font.BOLD, 25));
						}

					}

					// somebody won
					else {
						dealButton.setEnabled(false);

						// wait one second so user can see the results
						// need to use a different thread so interface still updates
						new Thread(new Runnable() {
							@Override
							public void run() {

								try {
									Thread.sleep(1000);
								} catch (InterruptedException e1) {
									e1.printStackTrace();
								}

								// move to game over panel
								CardLayout c = (CardLayout)(frame.getContentPane().getLayout());
								c.next(frame.getContentPane());
							}
						}).start();


						// set text for end game pane
						if (userScore > compScore) {
							resultText.setText("YOU WON");
						} else {
							resultText.setText("YOU LOST");
						}

						finalScore.setText("Final Score: " + userScore + "-" + compScore);
					}

				}

			}
		});
		GridBagConstraints gbc_dealButton = new GridBagConstraints();
		gbc_dealButton.insets = new Insets(0, 0, 5, 5);
		gbc_dealButton.gridx = 1;
		gbc_dealButton.gridy = 2;
		gamePanel.add(dealButton, gbc_dealButton);

		compWinImage = new JLabel("");
		compWinImage.setIcon(new ImageIcon(MainWindow.class.getResource("/img/win-default.png")));
		GridBagConstraints gbc_compWinImage = new GridBagConstraints();
		gbc_compWinImage.insets = new Insets(0, 0, 5, 0);
		gbc_compWinImage.gridx = 2;
		gbc_compWinImage.gridy = 2;
		gamePanel.add(compWinImage, gbc_compWinImage);
		
		separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		GridBagConstraints gbc_separator_1 = new GridBagConstraints();
		gbc_separator_1.fill = GridBagConstraints.VERTICAL;
		gbc_separator_1.insets = new Insets(0, 0, 5, 5);
		gbc_separator_1.gridx = 1;
		gbc_separator_1.gridy = 3;
		gamePanel.add(separator_1, gbc_separator_1);

		userLabel = new JLabel("YOU");
		GridBagConstraints gbc_userLabel = new GridBagConstraints();
		gbc_userLabel.insets = new Insets(0, 0, 5, 5);
		gbc_userLabel.gridx = 0;
		gbc_userLabel.gridy = 4;
		gamePanel.add(userLabel, gbc_userLabel);

		lblRound = new JLabel("Round:");
		GridBagConstraints gbc_lblRound = new GridBagConstraints();
		gbc_lblRound.insets = new Insets(0, 0, 5, 5);
		gbc_lblRound.gridx = 1;
		gbc_lblRound.gridy = 4;
		gamePanel.add(lblRound, gbc_lblRound);

		compLabel = new JLabel("COMPUTER");
		GridBagConstraints gbc_compLabel = new GridBagConstraints();
		gbc_compLabel.insets = new Insets(0, 0, 5, 0);
		gbc_compLabel.gridx = 2;
		gbc_compLabel.gridy = 4;
		gamePanel.add(compLabel, gbc_compLabel);

		userScoreLabel = new JLabel("0");
		userScoreLabel.setFont(new Font("Lucida Grande", Font.BOLD, 40));
		GridBagConstraints gbc_userScoreLabel = new GridBagConstraints();
		gbc_userScoreLabel.insets = new Insets(0, 0, 5, 5);
		gbc_userScoreLabel.gridx = 0;
		gbc_userScoreLabel.gridy = 5;
		gamePanel.add(userScoreLabel, gbc_userScoreLabel);

		roundCounterLabel = new JLabel("0/5");
		roundCounterLabel.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		GridBagConstraints gbc_roundCounterLabel = new GridBagConstraints();
		gbc_roundCounterLabel.insets = new Insets(0, 0, 5, 5);
		gbc_roundCounterLabel.gridx = 1;
		gbc_roundCounterLabel.gridy = 5;
		gamePanel.add(roundCounterLabel, gbc_roundCounterLabel);

		compScoreLabel = new JLabel("0");
		compScoreLabel.setFont(new Font("Lucida Grande", Font.BOLD, 40));
		GridBagConstraints gbc_compScoreLabel = new GridBagConstraints();
		gbc_compScoreLabel.insets = new Insets(0, 0, 5, 0);
		gbc_compScoreLabel.gridx = 2;
		gbc_compScoreLabel.gridy = 5;
		gamePanel.add(compScoreLabel, gbc_compScoreLabel);

		overtimeIndicator = new JLabel("Normal Period");
		GridBagConstraints gbc_overtimeIndicator = new GridBagConstraints();
		gbc_overtimeIndicator.insets = new Insets(0, 0, 0, 5);
		gbc_overtimeIndicator.gridx = 1;
		gbc_overtimeIndicator.gridy = 6;
		gamePanel.add(overtimeIndicator, gbc_overtimeIndicator);

		endPanel = new JPanel();
		frame.getContentPane().add(endPanel, "name_781493243447");
		GridBagLayout gbl_endPanel = new GridBagLayout();
		gbl_endPanel.columnWidths = new int[]{0, 0};
		gbl_endPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_endPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_endPanel.rowWeights = new double[]{1.0, 1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		endPanel.setLayout(gbl_endPanel);

		quitButton = new JButton("Quit");
		quitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		lblNewLabel = new JLabel("GAME OVER");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.SOUTH;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		endPanel.add(lblNewLabel, gbc_lblNewLabel);

		resultText = new JLabel("RESULT");
		resultText.setFont(new Font("Lucida Grande", Font.BOLD, 70));
		GridBagConstraints gbc_resultText = new GridBagConstraints();
		gbc_resultText.insets = new Insets(0, 0, 5, 0);
		gbc_resultText.gridx = 0;
		gbc_resultText.gridy = 1;
		endPanel.add(resultText, gbc_resultText);

		finalScore = new JLabel("Final Score: 0-0");
		finalScore.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		GridBagConstraints gbc_finalScore = new GridBagConstraints();
		gbc_finalScore.anchor = GridBagConstraints.NORTH;
		gbc_finalScore.insets = new Insets(0, 0, 5, 0);
		gbc_finalScore.gridx = 0;
		gbc_finalScore.gridy = 2;
		endPanel.add(finalScore, gbc_finalScore);
		GridBagConstraints gbc_quitButton = new GridBagConstraints();
		gbc_quitButton.insets = new Insets(0, 0, 5, 0);
		gbc_quitButton.gridx = 0;
		gbc_quitButton.gridy = 3;
		endPanel.add(quitButton, gbc_quitButton);

		lblSeeCreditstxtFor = new JLabel("See CREDITS.TXT in the project folder for image credits.");
		GridBagConstraints gbc_lblSeeCreditstxtFor = new GridBagConstraints();
		gbc_lblSeeCreditstxtFor.gridx = 0;
		gbc_lblSeeCreditstxtFor.gridy = 4;
		endPanel.add(lblSeeCreditstxtFor, gbc_lblSeeCreditstxtFor);
	}

	
	// from https://docs.oracle.com/javase/tutorial/uiswing/components/formattedtextfield.html
	protected MaskFormatter createFormatter(String s) {
	    MaskFormatter formatter = null;
	    try {
	        formatter = new MaskFormatter(s);
	    } catch (java.text.ParseException exc) {
	        System.err.println("formatter is bad: " + exc.getMessage());
	        System.exit(-1);
	    }
	    return formatter;
	}
}


