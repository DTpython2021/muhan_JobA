package muhan_test_02_01;
import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SlotMachine extends Applet implements Runnable, ActionListener {
	public static final int SCREEN_WIDTH = 780;
	public static final int SCREEN_HEIGHT = 1200;
	public static final int ITEM_SIZE = 200;
	Thread clock;
	
	Image off;
	Graphics offG;
	
	Image slot;
	Image machine;
	
	Random r;
	
	int[] loc;
	int[] speed;
	int[] hit;
	int slotNum;
	boolean[] stopSlot;
	boolean[] moveSlot;
	
	Button startButton, stopButton, homeButton;
//	Panel buttonPanel;
	GridLayout grid = new GridLayout(3, 1);
	Panel buttonPanel = new Panel(grid);
	private Thread musicThread;


	public void init() {

		//�޸𸮻��� ����ȭ�� �����
		off = createImage(SCREEN_WIDTH, SCREEN_HEIGHT);
		offG = off.getGraphics();
		offG.setColor(Color.white);
		offG.fillRect(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
		this.setSize(SCREEN_WIDTH,SCREEN_HEIGHT);
		
		// �̹��� �ε�
		MediaTracker tracker = new MediaTracker(this);
		
		slot = Toolkit.getDefaultToolkit().getImage("D:\\abc\\1.game\\Slot\\slotsymbol7777.png");
		tracker.addImage(slot,  0);
		
		machine = Toolkit.getDefaultToolkit().getImage("D:\\abc\\1.game\\Slot\\slotmachine_200721.png"); //������ �̹��� ����� ��!
		tracker.addImage(machine, 0);

//		// ��� ����
//		Runnable slotmusic = new SlotMusic();
//		Thread musicThread = new Thread(slotmusic);
//		musicThread.start();
		
		try {
			tracker.waitForAll();
		} catch (InterruptedException ie) {	}
		
		while ((tracker.statusAll(true) & MediaTracker.COMPLETE) == 0) {}

		//GUI
		setLayout(new BorderLayout());

//		Frame buttonFrame = new Frame();
		buttonPanel = new Panel(grid);
//		buttonFrame.setBounds(600, 300, 200, 600);
//		buttonPanel.setBounds(600,300, 190, 500 );
//		buttonFrame.add(buttonPanel);

//		buttonFrame.add(buttonPanel);
//		buttonFrame.setVisible(true);	
		
		startButton = new Button("��ܶ�!");
//		startButton.setBounds(50, 50, 180, 100 );
		startButton.addActionListener(this);
		buttonPanel.add(startButton);
		
		stopButton = new Button("��  ��!");
//		stopButton.setBounds(50, 200, 180, 100 );
		stopButton.addActionListener(this);
		buttonPanel.add(stopButton);

		homeButton = new Button("������!");
//		homeButton.setBounds(50, 350, 180, 100 );
		homeButton.addActionListener(this);
		buttonPanel.add(homeButton);
		
		add("East", buttonPanel);
		
		loc = new int[3];
		speed = new int[3];
		hit = new int[3];
		stopSlot = new boolean[3];
		moveSlot = new boolean[3];
		
		r = new Random();
		
		for(int i = 0; i < 3; i++) {
			loc[i] = Math.abs(r.nextInt() % 8) * ITEM_SIZE;
			speed[i] = Math.abs(r.nextInt() % 8) * 9 + 9;
			stopSlot[i] = true;
			moveSlot[i] = false;
		}
		slotNum = 0;
	}
	
	public void start() {
		if(clock==null) {
			clock = new Thread(this);
			clock.start(); //�ð����
		}
	}
	
	public void paint(Graphics g) {
		//����ȭ���� ���� ȭ�鿡 ���
		g.drawImage(off,  0,  0,  this);
	}
	
	public void update(Graphics g) {
		paint(g);
	}
	
	public void run() {

		while(true) {
			try {
				clock.sleep(30);
			} catch (InterruptedException ie) {}
		
			offG.setColor(Color.white);
			offG.fillRect(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
			
//			playMusic();

			drawSlot();
			offG.drawImage(machine,  0,  0,  this);
			
			repaint(); // paint() ȣ��
			
		}
	}
	
//	public void playMusic() {
//		// ��� ����	
//		AudioClip sound;
//		try {
//			URL url = new URL("file:///D:/abc/MySources/image/ImageSlot/1_bgm.wav");
//			sound = Applet.newAudioClip(url);
//			sound.play();
//		} catch (Exception ie) {}
//	}
	
	public void drawSlot() {
		for(int i = 0; i < 3; i++) {
			if(moveSlot[i]) {
				if(loc[i] < (ITEM_SIZE  * 9) ) {
					loc[i] += speed[i];
//					System.out.println("moveSlot loc[" + i + "] = " + loc[i]);
				} else {
					loc[i] = 0;
				}
			}
			if(stopSlot[i]) {
				if((loc[i]/ITEM_SIZE) == hit[i]) {
//					System.out.println("stopSlot loc[" + i + "] = " + loc[i]);
					loc[i] = loc[i]/ITEM_SIZE * ITEM_SIZE;
					moveSlot[i] = false;
				}
			}
			
			if(loc[i] < (ITEM_SIZE * 6)) {
				offG.drawImage(slot,  i*ITEM_SIZE,  0 - loc[i], this);
//				System.out.println("if location loc[" + i + "] = " + loc[i]);
			} else {
				offG.drawImage(slot,  i*ITEM_SIZE,  0 - loc[i], this);
				offG.drawImage(slot,  i*ITEM_SIZE,  (ITEM_SIZE * 8) - loc[i],  this);
//				System.out.println("else location loc[" + i + "] = " + loc[i]);
			}
		}
	}
	@SuppressWarnings("null")
	public void actionPerformed(ActionEvent e) {
		Runnable slotmusic ;
		musicThread = null;

		if(e.getSource() == startButton) {
			stopSlot[0] = stopSlot[1] = stopSlot[2] = false;
			moveSlot[0] = moveSlot[1] = moveSlot[2] = true;
			slotNum = 0;
//			// ��� ����
			slotmusic = new SlotMusic();
			musicThread = new Thread(slotmusic);
			musicThread.start();
			
		} else if (e.getSource() == stopButton) {
			hit[slotNum] = Math.abs(r.nextInt() % 8);
			stopSlot[slotNum] = true;
			if(slotNum < 2) {
				slotNum ++;

			} else {
				slotNum = 0;
//				musicThread.interrupt();
			}
		} else if (e.getSource() == homeButton) {
//			stop();
			destroy();
		} 
	}
	
	public void stop() {
		if(( clock != null) && (clock.isAlive())) {
			clock = null; //�ð�����(����)
		}
	}
	
//	public void destroy() {
//		// ���� ��ƾ
//	}
}
		
	