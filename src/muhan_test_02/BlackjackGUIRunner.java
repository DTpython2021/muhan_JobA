package muhan_test_02;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class BlackjackGUIRunner extends JFrame {

	private static final int WIDTH = 1280;
	private static final int HEIGHT = 720;

	public static JButton start;
	public static JButton hit;
	public static JButton stand;
	public static JButton exit;
	private Image screenImage;
	private Graphics screenGraphic;
	private ImageIcon exitButtonImage = new ImageIcon(Main.class.getResource("../image/exitButton.png"));
	private ImageIcon exitEnteredButtonImage = new ImageIcon(Main.class.getResource("../image/exitEnteredButton.png"));
	private JButton exitButton = new JButton(exitButtonImage);
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../image/titleBar.png")));
	private Image Background = new ImageIcon(Main.class.getResource("../image/BackgroundBJ.png")).getImage();
	private int mouseX,mouseY;
	

	public BlackjackGUIRunner() {

		super("≥Î¿±¡§«–øÏ¥‘∞˙ ∏Ì¿Á¡ÿ «–øÏ¥‘¿Ã ∏∏µÁ ∫Ì∑¢¿Ë Java Ver 1.0.9");
		JPanel panel = new JPanel();
		setSize(WIDTH, HEIGHT);
		setLocationRelativeTo(null);
		exitButton.setBounds(1235, 0, 30, 30);
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
				new GamePlay();
				dispose();
			}
		});
		add(exitButton);
		
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
		
	
		

		BlackjackGUI gui = new BlackjackGUI();
		((Component) gui).setFocusable(true);
		start = new JButton("Start");
		hit = new JButton("Hit");
		stand = new JButton("Stand");
		exit = new JButton("exit");

		getContentPane().add(gui);

		panel.add(start);
		panel.add(stand);
		panel.add(hit);
		panel.add(exit);
		start.addActionListener(gui);
		stand.addActionListener(gui);
		hit.addActionListener(gui);
		exit.addActionListener(gui);
		getContentPane().add(panel, BorderLayout.SOUTH);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	
   }
	public static void main(String[] args) {
		  
		BlackjackGUIRunner test = new BlackjackGUIRunner();
	}

	public static JButton gethit() {
		return hit;
	}

	public static JButton getStand() {
		return stand;
	}
	
	public static JButton getExit() {
		return exit;
	}

}

