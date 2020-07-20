package com.muhan.java;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GamePlay extends JFrame {

	private Image screenImage;
	private Graphics screenGraphic;
	private ImageIcon exitButtonImage = new ImageIcon(Main.class.getResource("../image/exitButton.png"));
	private ImageIcon exitEnteredButtonImage = new ImageIcon(Main.class.getResource("../image/exitEnteredButton.png"));
	private ImageIcon Button1BasicImage = new ImageIcon(Main.class.getResource("../image/Button1.png"));
	private ImageIcon Button2BasicImage = new ImageIcon(Main.class.getResource("../image/Button2.png"));
	private ImageIcon Button3BasicImage = new ImageIcon(Main.class.getResource("../image/Button3.png"));
	private ImageIcon Button4BasicImage = new ImageIcon(Main.class.getResource("../image/Button4.png"));
//	private ImageIcon Button1BasicImage = new ImageIcon(Main.class.getResource("../image/Button1Basic.png"));
//	private ImageIcon Button1EnteredImage = new ImageIcon(Main.class.getResource("../image/Button1Entered.png"));
  	private ImageIcon Button1EnteredImage = new ImageIcon(Main.class.getResource("../image/Button1Entered.png"));
  	private ImageIcon Button2EnteredImage = new ImageIcon(Main.class.getResource("../image/Button2Entered.png"));
  	private ImageIcon Button3EnteredImage = new ImageIcon(Main.class.getResource("../image/Button3Entered.png"));
  	private ImageIcon Button4EnteredImage = new ImageIcon(Main.class.getResource("../image/Button4Entered.png"));
	private ImageIcon quitButtonBasicImage = new ImageIcon(Main.class.getResource("../image/quitButtonBasic.png"));
	private ImageIcon quitButtonEnteredImage = new ImageIcon(Main.class.getResource("../image/quitButtonEntered.png"));
	
	private Image Background = new ImageIcon(Main.class.getResource("../image/Background(title).png")).getImage();
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../image/titleBar.png")));
	private JButton exitButton = new JButton(exitButtonImage);
//	private JButton Button1 = new JButton(Button1BasicImage);
	private JButton Button1 = new JButton(Button1BasicImage);
	private JButton Button2 = new JButton(Button2BasicImage);
	private JButton Button3 = new JButton(Button3BasicImage);
	private JButton Button4 = new JButton(Button4BasicImage);
	private JButton quitButton = new JButton(quitButtonBasicImage);
	private int mouseX,mouseY;

	public GamePlay() {
		setUndecorated(true);
		setTitle("GamePlay");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);
		
		exitButton.setBounds(1245, 0, 30, 30);
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				exitButton.setIcon(exitEnteredButtonImage);
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("correct.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				exitButton.setIcon(exitButtonImage);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("incorrect.mp3", false);
				buttonPressedMusic.start();
				try {
					Thread.sleep(1000);
				}catch(InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0);
			}
		});
		add(exitButton);
		
		Button1.setBounds(40, 200, 300, 250);
		Button1.setBorderPainted(false);
		Button1.setContentAreaFilled(false);
		Button1.setFocusPainted(false);
		Button1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Button1.setIcon(Button1EnteredImage);
				Button1.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("correct.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Button1.setIcon(Button1BasicImage);
				Button1.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("incorrect.mp3", false);
				buttonPressedMusic.start();
				//게임시작이벤트
				Button1.setVisible(false);
				Button2.setVisible(false);
				Button3.setVisible(false);
				Button4.setVisible(false);
				quitButton.setVisible(false);
				Background = new ImageIcon(Main.class.getResource("../image/mainBackground.jpg")).getImage(); 
			}
		});
		add(Button1);
		
		Button2.setBounds(350, 200, 300, 250);
		Button2.setBorderPainted(false);
		Button2.setContentAreaFilled(false);
		Button2.setFocusPainted(false);
		Button2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Button2.setIcon(Button2EnteredImage);
				Button2.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("correct.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Button2.setIcon(Button2BasicImage);
				Button2.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("incorrect.mp3", false);
				buttonPressedMusic.start();
				//게임시작이벤트
				Button1.setVisible(false);
				Button2.setVisible(false);
				Button3.setVisible(false);
				Button4.setVisible(false);
				quitButton.setVisible(false);
				Background = new ImageIcon(Main.class.getResource("../image/mainBackground.jpg")).getImage(); 
			}
		});
		add(Button2);
		
		Button3.setBounds(660, 200, 300, 250);
		Button3.setBorderPainted(false);
		Button3.setContentAreaFilled(false);
		Button3.setFocusPainted(false);
		Button3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Button3.setIcon(Button3EnteredImage);
				Button3.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("correct.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Button3.setIcon(Button3BasicImage);
				Button3.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("incorrect.mp3", false);
				buttonPressedMusic.start();
				//게임시작이벤트
				Button1.setVisible(false);
				Button2.setVisible(false);
				Button3.setVisible(false);
				Button4.setVisible(false);
				quitButton.setVisible(false);
				Background = new ImageIcon(Main.class.getResource("../image/mainBackground.jpg")).getImage(); 
			}
		});
		add(Button3);
		
		Button4.setBounds(970, 200, 300, 250);
		Button4.setBorderPainted(false);
		Button4.setContentAreaFilled(false);
		Button4.setFocusPainted(false);
		Button4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Button4.setIcon(Button4EnteredImage);
				Button4.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("correct.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Button4.setIcon(Button4BasicImage);
				Button4.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("incorrect.mp3", false);
				buttonPressedMusic.start();
				//게임시작이벤트
				Button1.setVisible(false);
				Button2.setVisible(false);
				Button3.setVisible(false);
				Button4.setVisible(false);
				quitButton.setVisible(false);
				Background = new ImageIcon(Main.class.getResource("../image/mainBackground.jpg")).getImage(); 
			}
		});
		add(Button4);
		
/*		quitButton.setBounds(40, 330, 400, 100);
		quitButton.setBorderPainted(false);
		quitButton.setContentAreaFilled(false);
		quitButton.setFocusPainted(false);
		quitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				quitButton.setIcon(quitButtonEnteredImage);
				quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("correct.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				quitButton.setIcon(quitButtonBasicImage);
				quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("incorrect.mp3", false);
				buttonPressedMusic.start();
				try {
					Thread.sleep(1000);
				}catch(InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0);
				
			}
		});
		add(quitButton);
*/
		menuBar.setBounds(0, 0, 1280, 30);
		menuBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {
		    @Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x-mouseX, y-mouseY);
			}
		});
		
		add(menuBar);

		Music introMusic = new Music("HEALING POTION.mp3", true);
		introMusic.start();

	}

	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}

	public void screenDraw(Graphics g) {
		g.drawImage(Background, 0, 0, null);
		paintComponents(g);
		this.repaint();
	}
}