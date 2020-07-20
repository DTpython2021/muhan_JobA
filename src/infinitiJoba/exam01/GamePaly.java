package infinitiJoba.exam01;


import javax.swing.JFrame;


public class GamePaly extends JFrame{
	public GamePaly() {
		setTitle("GamePlay");
		setSize(Main.SCREEN_WIDTH,Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
