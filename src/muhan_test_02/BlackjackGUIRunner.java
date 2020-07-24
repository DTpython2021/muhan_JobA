package muhan_test_02;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.applet.Applet;
import java.awt.*;

public class BlackjackGUIRunner extends JFrame {

	private static final int WIDTH = 1280;
	private static final int HEIGHT = 720;
	public static JButton start;
	public static JButton hit;
	public static JButton stand;
	public static JButton exit;
	

	public BlackjackGUIRunner() {

		super("≥Î¿±¡§«–øÏ¥‘∞˙ ∏Ì¿Á¡ÿ «–øÏ¥‘¿Ã ∏∏µÁ ∫Ì∑¢¿Ë Java Ver 1.0.9");
		JPanel panel = new JPanel();
		setSize(WIDTH, HEIGHT);
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

