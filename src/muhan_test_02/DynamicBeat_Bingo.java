package muhan_test_02;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DynamicBeat_Bingo extends JFrame {

	private Image screenImage;
	private Graphics screenGraphic;
	private ImageIcon bingoImage = new ImageIcon(Main.class.getResource("../image/bingo150.png"));
	private ImageIcon winbingoImage = new ImageIcon(Main.class.getResource("../image/win_bingo.png"));
//	private ImageIcon bingoImage = new ImageIcon(Main.class.getResource("../image/bingo1.png"));
	private ImageIcon b1Image = new ImageIcon(Main.class.getResource("../image/g1.png"));
	private ImageIcon b2Image = new ImageIcon(Main.class.getResource("../image/g2.png"));
	private ImageIcon b3Image = new ImageIcon(Main.class.getResource("../image/g3.png"));
	private ImageIcon b4Image = new ImageIcon(Main.class.getResource("../image/g4.png"));
	private ImageIcon b5Image = new ImageIcon(Main.class.getResource("../image/g5.png"));
	private ImageIcon b6Image = new ImageIcon(Main.class.getResource("../image/g6.png"));
	private ImageIcon b7Image = new ImageIcon(Main.class.getResource("../image/g7.png"));
	private ImageIcon b8Image = new ImageIcon(Main.class.getResource("../image/g8.png"));
	private ImageIcon b9Image = new ImageIcon(Main.class.getResource("../image/g9.png"));
	
	private ImageIcon n1Image = new ImageIcon(Main.class.getResource("../image/n1.png"));
	private ImageIcon n2Image = new ImageIcon(Main.class.getResource("../image/n2.png"));
	private ImageIcon n3Image = new ImageIcon(Main.class.getResource("../image/n3.png"));
	private ImageIcon n4Image = new ImageIcon(Main.class.getResource("../image/n4.png"));
	private ImageIcon n5Image = new ImageIcon(Main.class.getResource("../image/n5.png"));
	private ImageIcon n6Image = new ImageIcon(Main.class.getResource("../image/n6.png"));
	private ImageIcon n7Image = new ImageIcon(Main.class.getResource("../image/n7.png"));
	private ImageIcon n8Image = new ImageIcon(Main.class.getResource("../image/n8.png"));
	private ImageIcon n9Image = new ImageIcon(Main.class.getResource("../image/n9.png"));
		
	private ImageIcon exitButtonImage = new ImageIcon(Main.class.getResource("../image/exitButton.png"));
	private ImageIcon exitEnteredButtonImage = new ImageIcon(Main.class.getResource("../image/exitEnteredButton.png"));
	private ImageIcon quitButtonBasicImage = new ImageIcon(Main.class.getResource("../image/quitButtonBasic.png"));
	private ImageIcon quitButtonEnteredImage = new ImageIcon(Main.class.getResource("../image/quitButtonEntered.png"));
	private Image Background = new ImageIcon(Main.class.getResource("../image/bingobackground.png")).getImage();
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../image/titleBar.png")));
	private JButton exitButton = new JButton(exitButtonImage);

	private JButton[] Button = new JButton[9];        //  선택할  숫자버튼용
	private JButton[][] button = new JButton[3][3];   //  선택될  3 X 3 화면용
	
	private JButton winBingo = new JButton(winbingoImage);   // 빙고가 성립될때 띄울 화면
	private JButton winBingo2 = new JButton(winbingoImage);   // 빙고가 성립될때 띄울 화면
	
	private JButton quitButton = new JButton(quitButtonBasicImage);
	private int mouseX,mouseY;
	private boolean isMainScreen = false;
	
	int winCnt = 2;      // 빙고의 띄울 숫자 정의

	int[] one = new int[9];       //  1차원 배열  -- 랜덤하게 섞어서 넣을 배열
	int[][] two = new int[3][3];  //  섞은 일차원배열을 넣을  2차원 배열 자리수 준비  
								  //  => 향후 *를 넣어서 빙고여부를 확인할것임

	public DynamicBeat_Bingo() {
		
		setUndecorated(true);
		setTitle("DynamicBeat");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);
		
		// 빙고 세레머니화면
		
		winBingo.setBounds(810, 250, 400, 400); 
		winBingo.setBorderPainted(false);
		winBingo.setContentAreaFilled(false);
		winBingo.setFocusPainted(false);
		winBingo.setIcon(winbingoImage);
		add(winBingo);                           // 빙고 세레머니화면 추가
		winBingo.setVisible(false);              // 빙고 세레머니화면 초기에 언비지블

		winBingo2.setBounds(10, 250, 400, 400); 
		winBingo2.setBorderPainted(false);
		winBingo2.setContentAreaFilled(false);
		winBingo2.setFocusPainted(false);
		winBingo2.setIcon(winbingoImage);
		add(winBingo2);                           // 빙고 세레머니화면 추가
		winBingo2.setVisible(false);              // 빙고 세레머니화면 초기에 언비지블

		// 선택버튼 세팅
		for(int i = 0 ; i <  Button.length; i++) 
		{
			Button[i] = new JButton(Integer.toString(i+1));
			Button[i].setBounds(280+i*75, 600, 60, 65);
			
			Button[i].setContentAreaFilled(false);
			Button[i].setFocusPainted(false);
				
		}
		
		Button[0].setIcon(n1Image);
		Button[1].setIcon(n2Image);
		Button[2].setIcon(n3Image);
		Button[3].setIcon(n4Image);
		Button[4].setIcon(n5Image);
		Button[5].setIcon(n6Image);
		Button[6].setIcon(n7Image);
		Button[7].setIcon(n8Image);
		Button[8].setIcon(n9Image);
		
		// 삭제버튼 세팅 및 동작
		
		exitButton.setBounds(1245, 0, 30, 30);
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				exitButton.setIcon(exitEnteredButtonImage);
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				exitButton.setIcon(exitButtonImage);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					Thread.sleep(1000);
				}catch(InterruptedException ex) {
					ex.printStackTrace();
				}
//				System.exit(0);
				new GamePlay();
				dispose();
			}
		});
		add(exitButton);

		
////		 9요소 일차원 배열을 만든다
//		  일차원 배열에 일렬번호를 채운다
		for(int i = 0; i < one.length ;i++)
		{
			one[i] = 1+i;
		}
//		  일차원 배열을 9회섞는다
		for(int i = 0 ; i < one.length ; i++)
		{
			int num1 = (int)(Math.random()*one.length);
			int num2 = (int)(Math.random()*one.length);

			int temp = one[num1];
			one[num1] = one[num2];
			one[num2]= temp;
		}
		
//		  일차원 배열을 이차원에 순서대로 넣는다
		
		System.out.println("\n 이차원 배열로 변환값");
				
		for(int i = 0 ; i<two.length ; i++)
		{
			for(int j = 0 ; j<two[1].length; j++)
			{
				two[i][j] = one[i*3+j];
				System.out.print(two[i][j]+"\t");
			}
			System.out.println();
		}
		
//////////////////////////////////////////////////
		
		// 빙고판  -- 선택된 버튼 디스플레이 
		for(int i = 0 ; i < two.length ; i++) {
			for(int j = 0 ; j < two[1].length; j++) {
				button[i][j] = new JButton(Integer.toString(two[i][j]));
				button[i][j].setBounds(400+140*j, 150+140*i, 140,140);
				
				button[i][j].setIcon(bingoImage);
			
//				button[i][j].setStyle("-fx-font-size :30;");
				button[i][j].setBorderPainted(true);
				button[i][j].setContentAreaFilled(false);
				button[i][j].setFocusPainted(false);
//				System.out.print(3*i+j+1);
				add(button[i][j]);
			}	
		}	

		
		Button[0].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Button[0].setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Button[0].setVisible(false);
			//	System.out.println(button1.getText() );
				for(int i =0  ; i < one.length ; i++ )
				{
					
					if(button[0][0].getText().equals("1"))
					{
						System.out.println("1번일치1");
						one[0] = '*';
						button[0][0].setIcon(b1Image);
					}
					if(button[0][1].getText().equals("1"))
					{
						System.out.println("2번일치1");
						one[1] = '*';
						button[0][1].setIcon(b1Image);
					}
					if(button[0][2].getText().equals("1"))
					
					{
						System.out.println("3번일치1");
						one[2] = '*';
						button[0][2].setIcon(b1Image);
					}
					if(button[1][0].getText().equals("1"))
					{
						System.out.println("4번일치1");
						one[3] = '*';
						button[1][0].setIcon(b1Image);
					}
					if(button[1][1].getText().equals("1"))
					{
						System.out.println("5번일치1");
						one[4] = '*';
						button[1][1].setIcon(b1Image);
					}
					if(button[1][2].getText().equals("1"))
					{
						System.out.println("6번일치1");
						one[5] = '*';
						button[1][2].setIcon(b1Image);
					}
					if(button[2][0].getText().equals("1"))
					{
						System.out.println("7번일치1");
						one[6] = '*';
						button[2][0].setIcon(b1Image);
					}
					if(button[2][1].getText().equals("1"))
					{
						System.out.println("8번일치");
						one[7] = '*';
						button[2][1].setIcon(b1Image);
					}
					if(button[2][2].getText().equals("1"))
					{
						System.out.println("9번일치1");
						one[8] = '*';
						button[2][2].setIcon(b1Image);
					}
				}
				for( int i = 0 ; i<one.length ; i++)
				{

					System.out.print("하이"+ one[i]+"\t");
				}
				System.out.println();
				int count =0;
				for(int i = 0 ; i < one.length ; i++)
				{
					System.out.println("check");
					if( one[0] == 42 && one[1] ==42 && one[2] ==42 )   //1
					{
						count++;
						
					}
					if( one[0] == 42 && one[3] ==42 && one[6] ==42 )  //2
					{
						count++;
						
					}
					if( one[0] == 42 && one[4] ==42 && one[8] ==42 )  //3
					{
						count++;
						
					}
					if( one[1] == 42 && one[4] ==42 && one[7] ==42 )  //4
					{
						count++;
						
					}
					if( one[2] == 42 && one[5] ==42 && one[8] ==42 )  //5
					{
						count++;
						
					}
					if( one[2] == 42 && one[4] ==42 && one[6] ==42 )  //6
					{
						count++;
						
					}
					if( one[3] == 42 && one[4] ==42 && one[5] ==42 )  //7
					{
						count++;
						
					}
					if( one[6] == 42 && one[7] ==42 && one[8] ==42 )   //8
					{
						count++;
						
					}
					System.out.println("빙고"+ count);
					
					if (count >= winCnt )
					{
						System.out.println("축하합니다. ");
						winBingo.setVisible(true);
						winBingo2.setVisible(true);
						return;
					}
					break;
				}
			}
		});
		add(Button[0]);
		
		Button[1].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Button[1].setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Button[1].setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Button[1].setVisible(false);
				for(int i =0  ; i < one.length ; i++ )
				{
					if(button[0][0].getText().equals("2"))
					{
						System.out.println("1번일치2");
						one[0] = '*';
						button[0][0].setIcon(b2Image);
					}
					if(button[0][1].getText().equals("2"))
					{
						System.out.println("2번일치2");
						one[1] = '*';
						button[0][1].setIcon(b2Image);
					}
					if(button[0][2].getText().equals("2"))
					{
						System.out.println("3번일치2");
						one[2] = '*';
						button[0][2].setIcon(b2Image);
					}
					if(button[1][0].getText().equals("2"))
					{
						System.out.println("4번일치2");
						one[3] = '*';
						button[1][0].setIcon(b2Image);
					}
					if(button[1][1].getText().equals("2"))
					{
						System.out.println("5번일치2");
						one[4] = '*';
						button[1][1].setIcon(b2Image);
					}
					if(button[1][2].getText().equals("2"))
					{
						System.out.println("6번일치2");
						one[5] = '*';
						button[1][2].setIcon(b2Image);
					}
					if(button[2][0].getText().equals("2"))
					{
						System.out.println("7번일치2");
						one[6] = '*';
						button[2][0].setIcon(b2Image);
					}
					if(button[2][1].getText().equals("2"))
					{
						System.out.println("8번일치2");
						one[7] = '*';
						button[2][1].setIcon(b2Image);
					}
					if(button[2][2].getText().equals("2"))
					{
						System.out.println("9번일치2");
						one[8] = '*';
						button[2][2].setIcon(b2Image);
					}
				}
				for(int i= 0 ; i<one.length ; i++)
				{
					System.out.print("하이"+ one[i]+"\t");
				}
				System.out.println();

				int count =0;
				for(int i = 0 ; i < one.length ; i++)
				{
					System.out.println("check");
					if( one[0] == 42 && one[1] ==42 && one[2] ==42 )   //1
					{
						count++;
						
					}
					if( one[0] == 42 && one[3] ==42 && one[6] ==42 )  //2
					{
						count++;
						
					}
					if( one[0] == 42 && one[4] ==42 && one[8] ==42 )  //3
					{
						count++;
						
					}
					if( one[1] == 42 && one[4] ==42 && one[7] ==42 )  //4
					{
						count++;
						
					}
					if( one[2] == 42 && one[5] ==42 && one[8] ==42 )  //5
					{
						count++;
						
					}
					if( one[2] == 42 && one[4] ==42 && one[6] ==42 )  //6
					{
						count++;
						
					}
					if( one[3] == 42 && one[4] ==42 && one[5] ==42 )  //7
					{
						count++;
						
					}
					if( one[6] == 42 && one[7] ==42 && one[8] ==42 )   //8
					{
						count++;
						
					}
					System.out.println("빙고"+ count);
					
					if (count >= winCnt )
					{
						System.out.println("축하합니다. ");
						winBingo.setVisible(true);
						winBingo2.setVisible(true);
						
						return;
					}
					
					break;
				}
			}
		});
		add(Button[1]);
		
		Button[2].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Button[2].setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Button[2].setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Button[2].setVisible(false);
				for(int i =0  ; i < one.length ; i++ )
				{
					if(button[0][0].getText().equals("3"))
					{
						System.out.println("1번일치3");
						one[0] = '*';
						button[0][0].setIcon(b3Image);
					}
					if(button[0][1].getText().equals("3"))
					{
						System.out.println("2번일치3");
						one[1] = '*';
						button[0][1].setIcon(b3Image);
					}
					if(button[0][2].getText().equals("3"))
					{
						System.out.println("3번일치3");
						one[2] = '*';
						button[0][2].setIcon(b3Image);
					}
					if(button[1][0].getText().equals("3"))
					{
						System.out.println("4번일치3");
						one[3] = '*';
						button[1][0].setIcon(b3Image);
					}
					if(button[1][1].getText().equals("3"))
					{
						System.out.println("5번일치3");
						one[4] = '*';
						button[1][1].setIcon(b3Image);
					}
					if(button[1][2].getText().equals("3"))
					{
						System.out.println("6번일치3");
						one[5] = '*';
						button[1][2].setIcon(b3Image);
					}
					if(button[2][0].getText().equals("3"))
					{
						System.out.println("7번일치3");
						one[6] = '*';
						button[2][0].setIcon(b3Image);
					}
					if(button[2][1].getText().equals("3"))
					{
						System.out.println("8번일치3");
						one[7] = '*';
						button[2][1].setIcon(b3Image);
					}
					if(button[2][2].getText().equals("3"))
					{
						System.out.println("9번일치3");
						one[8] = '*';
						button[2][2].setIcon(b3Image);
					}
				}
				for(int i= 0 ; i<one.length ; i++)
				{
					System.out.print("하이"+ one[i]+"\t");
				}
				System.out.println();
				int count =0;
				for(int i = 0 ; i < one.length ; i++)
				{
					System.out.println("check");
					if( one[0] == 42 && one[1] ==42 && one[2] ==42 )   //1
					{
						count++;
						
					}
					if( one[0] == 42 && one[3] ==42 && one[6] ==42 )  //2
					{
						count++;
						
					}
					if( one[0] == 42 && one[4] ==42 && one[8] ==42 )  //3
					{
						count++;
						
					}
					if( one[1] == 42 && one[4] ==42 && one[7] ==42 )  //4
					{
						count++;
						
					}
					if( one[2] == 42 && one[5] ==42 && one[8] ==42 )  //5
					{
						count++;
						
					}
					if( one[2] == 42 && one[4] ==42 && one[6] ==42 )  //6
					{
						count++;
						
					}
					if( one[3] == 42 && one[4] ==42 && one[5] ==42 )  //7
					{
						count++;
						
					}
					if( one[6] == 42 && one[7] ==42 && one[8] ==42 )   //8
					{
						count++;
						
					}
					System.out.println("빙고"+ count);
					
					if (count >= winCnt )
					{
						System.out.println("축하합니다. ");
						winBingo.setVisible(true);
						winBingo2.setVisible(true);
								
						return;
					}
					
					break;
				}
			}
		});
		add(Button[2]);
		
		Button[3].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Button[3].setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Button[3].setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Button[3].setVisible(false);
				for(int i =0  ; i < one.length ; i++ )
				{
					if(button[0][0].getText().equals("4"))
					{
						System.out.println("1번일치4");
						one[0] = '*';
						button[0][0].setIcon(b4Image);
					}
					if(button[0][1].getText().equals("4"))
					{
						System.out.println("2번일치4");
						one[1] = '*';
						button[0][1].setIcon(b4Image);
					}
					if(button[0][2].getText().equals("4"))
					{
						System.out.println("3번일치4");
						one[2] = '*';
						button[0][2].setIcon(b4Image);
					}
					if(button[1][0].getText().equals("4"))
					{
						System.out.println("4번일치4");
						one[3] = '*';
						button[1][0].setIcon(b4Image);
					}
					if(button[1][1].getText().equals("4"))
					{
						System.out.println("5번일치4");
						one[4] = '*';
						button[1][1].setIcon(b4Image);
					}
					if(button[1][2].getText().equals("4"))
					{
						System.out.println("6번일치4");
						one[5] = '*';
						button[1][2].setIcon(b4Image);
					}
					if(button[2][0].getText().equals("4"))
					{
						System.out.println("7번일치4");
						one[6] = '*';
						button[2][0].setIcon(b4Image);
					}
					if(button[2][1].getText().equals("4"))
					{
						System.out.println("8번일치4");
						one[7] = '*';
						button[2][1].setIcon(b4Image);
					}
					if(button[2][2].getText().equals("4"))
					{
						System.out.println("9번일치4");
						one[8] = '*';
						button[2][2].setIcon(b4Image);
					}
				}

				for(int i= 0 ; i<one.length ; i++)
				{
					System.out.print("하이"+ one[i]+"\t");
				}
				System.out.println();
				int count =0;
				for(int i = 0 ; i < one.length ; i++)
				{
					System.out.println("check");
					if( one[0] == 42 && one[1] ==42 && one[2] ==42 )   //1
					{
						count++;
						
					}
					if( one[0] == 42 && one[3] ==42 && one[6] ==42 )  //2
					{
						count++;
						
					}
					if( one[0] == 42 && one[4] ==42 && one[8] ==42 )  //3
					{
						count++;
						
					}
					if( one[1] == 42 && one[4] ==42 && one[7] ==42 )  //4
					{
						count++;
						
					}
					if( one[2] == 42 && one[5] ==42 && one[8] ==42 )  //5
					{
						count++;
						
					}
					if( one[2] == 42 && one[4] ==42 && one[6] ==42 )  //6
					{
						count++;
						
					}
					if( one[3] == 42 && one[4] ==42 && one[5] ==42 )  //7
					{
						count++;
						
					}
					if( one[6] == 42 && one[7] ==42 && one[8] ==42 )   //8
					{
						count++;
						
					}
					System.out.println("빙고"+ count);
					
					if (count >= winCnt )
					{
						System.out.println("축하합니다. ");
						winBingo.setVisible(true);
						winBingo2.setVisible(true);
						
						return;
					}
					
					break;
				}
			}
		});
		add(Button[3]);
		
		Button[4].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Button[4].setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Button[4].setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Button[4].setVisible(false);
				for(int i =0  ; i < one.length ; i++ )
				{
					if(button[0][0].getText().equals("5"))
					{
						System.out.println("1번일치5");
						one[0] = '*';
						button[0][0].setIcon(b5Image);
					}
					if(button[0][1].getText().equals("5"))
					{
						System.out.println("2번일치5");
						one[1] = '*';
						button[0][1].setIcon(b5Image);
					}
					if(button[0][2].getText().equals("5"))
					{
						System.out.println("3번일치5");
						one[2] = '*';
						button[0][2].setIcon(b5Image);
					}
					if(button[1][0].getText().equals("5"))
					{
						System.out.println("4번일치5");
						one[3] = '*';
						button[1][0].setIcon(b5Image);
					}
					if(button[1][1].getText().equals("5"))
					{
						System.out.println("5번일치5");
						one[4] = '*';
						button[1][1].setIcon(b5Image);
					}
					if(button[1][2].getText().equals("5"))
					{
						System.out.println("6번일치5");
						one[5] = '*';
						button[1][2].setIcon(b5Image);
					}
					if(button[2][0].getText().equals("5"))
					{
						System.out.println("7번일치5");
						one[6] = '*';
						button[2][0].setIcon(b5Image);
					}
					if(button[2][1].getText().equals("5"))
					{
						System.out.println("8번일치5");
						one[7] = '*';
						button[2][1].setIcon(b5Image);
					}
					if(button[2][2].getText().equals("5"))
					{
						System.out.println("9번일치5");
						one[8] = '*';
						button[2][2].setIcon(b5Image);
					}
				}
				for(int i= 0 ; i<one.length ; i++)
				{
					System.out.print("하이"+ one[i]+"\t");
				}
				System.out.println();
				int count =0;
				for(int i = 0 ; i < one.length ; i++)
				{
					System.out.println("check");
					if( one[0] == 42 && one[1] ==42 && one[2] ==42 )   //1
					{
						count++;
						
					}
					if( one[0] == 42 && one[3] ==42 && one[6] ==42 )  //2
					{
						count++;
						
					}
					if( one[0] == 42 && one[4] ==42 && one[8] ==42 )  //3
					{
						count++;
						
					}
					if( one[1] == 42 && one[4] ==42 && one[7] ==42 )  //4
					{
						count++;
						
					}
					if( one[2] == 42 && one[5] ==42 && one[8] ==42 )  //5
					{
						count++;
						
					}
					if( one[2] == 42 && one[4] ==42 && one[6] ==42 )  //6
					{
						count++;
						
					}
					if( one[3] == 42 && one[4] ==42 && one[5] ==42 )  //7
					{
						count++;
						
					}
					if( one[6] == 42 && one[7] ==42 && one[8] ==42 )   //8
					{
						count++;
						
					}
					System.out.println("빙고"+ count);
					
					if (count >= winCnt )
					{
						System.out.println("축하합니다. ");
						winBingo.setVisible(true);
						winBingo2.setVisible(true);
						
						return;
					}
					
					break;
				}
			}
		});
		add(Button[4]);

		Button[5].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Button[5].setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Button[5].setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Button[5].setVisible(false);
				for(int i =0  ; i < one.length ; i++ )
				{
					if(button[0][0].getText().equals("6"))
					{
						System.out.println("1번일치6");
						one[0] = '*';
						button[0][0].setIcon(b6Image);
					}
					if(button[0][1].getText().equals("6"))
					{
						System.out.println("2번일치6");
						one[1] = '*';
						button[0][1].setIcon(b6Image);
					}
					if(button[0][2].getText().equals("6"))
					{
						System.out.println("3번일치6");
						one[2] = '*';
						button[0][2].setIcon(b6Image);
					}
					if(button[1][0].getText().equals("6"))
					{
						System.out.println("4번일치6");
						one[3] = '*';
						button[1][0].setIcon(b6Image);
					}
					if(button[1][1].getText().equals("6"))
					{
						System.out.println("5번일치6");
						one[4] = '*';
						button[1][1].setIcon(b6Image);
					}
					if(button[1][2].getText().equals("6"))
					{
						System.out.println("6번일치6");
						one[5] = '*';
						button[1][2].setIcon(b6Image);
					}
					if(button[2][0].getText().equals("6"))
					{
						System.out.println("7번일치6");
						one[6] = '*';
						button[2][0].setIcon(b6Image);
					}
					if(button[2][1].getText().equals("6"))
					{
						System.out.println("8번일치6");
						one[7] = '*';
						button[2][1].setIcon(b6Image);
					}
					if(button[2][2].getText().equals("6"))
					{
						System.out.println("9번일치6");
						one[8] = '*';
						button[2][2].setIcon(b6Image);
					}
				}
				for(int i= 0 ; i<one.length ; i++)
				{
					System.out.print("하이"+ one[i]+"\t");
				}
				System.out.println();
				int count =0;
				for(int i = 0 ; i < one.length ; i++)
				{
					System.out.println("check");
					if( one[0] == 42 && one[1] ==42 && one[2] ==42 )   //1
					{
						count++;
						
					}
					if( one[0] == 42 && one[3] ==42 && one[6] ==42 )  //2
					{
						count++;
						
					}
					if( one[0] == 42 && one[4] ==42 && one[8] ==42 )  //3
					{
						count++;
						
					}
					if( one[1] == 42 && one[4] ==42 && one[7] ==42 )  //4
					{
						count++;
						
					}
					if( one[2] == 42 && one[5] ==42 && one[8] ==42 )  //5
					{
						count++;
						
					}
					if( one[2] == 42 && one[4] ==42 && one[6] ==42 )  //6
					{
						count++;
						
					}
					if( one[3] == 42 && one[4] ==42 && one[5] ==42 )  //7
					{
						count++;
						
					}
					if( one[6] == 42 && one[7] ==42 && one[8] ==42 )   //8
					{
						count++;
						
					}
					System.out.println("빙고"+ count);
					
					if (count >= winCnt )
					{
						System.out.println("축하합니다. ");
						winBingo.setVisible(true);
						winBingo2.setVisible(true);
						
						return;
					}
					
					break;
				}
			}
		});
		add(Button[5]);

		Button[6].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Button[6].setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Button[6].setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Button[6].setVisible(false);
				for(int i =0  ; i < one.length ; i++ )
				{
					if(button[0][0].getText().equals("7"))
					{
						System.out.println("1번일치7");
						one[0] = '*';
						button[0][0].setIcon(b7Image);
					}
					if(button[0][1].getText().equals("7"))
					{
						System.out.println("2번일치7");
						one[1] = '*';
						button[0][1].setIcon(b7Image);
					}
					if(button[0][2].getText().equals("7"))
					{
						System.out.println("3번일치7");
						one[2] = '*';
						button[0][2].setIcon(b7Image);
					}
					if(button[1][0].getText().equals("7"))
					{
						System.out.println("4번일치7");
						one[3] = '*';
						button[1][0].setIcon(b7Image);
					}
					if(button[1][1].getText().equals("7"))
					{
						System.out.println("5번일치7");
						one[4] = '*';
						button[1][1].setIcon(b7Image);
					}
					if(button[1][2].getText().equals("7"))
					{
						System.out.println("6번일치7");
						one[5] = '*';
						button[1][2].setIcon(b7Image);
					}
					if(button[2][0].getText().equals("7"))
					{
						System.out.println("7번일치7");
						one[6] = '*';
						button[2][0].setIcon(b7Image);
					}
					if(button[2][1].getText().equals("7"))
					{
						System.out.println("8번일치7");
						one[7] = '*';
						button[2][1].setIcon(b7Image);
					}
					if(button[2][2].getText().equals("7"))
					{
						System.out.println("9번일치7");
						one[8] = '*';
						button[2][2].setIcon(b7Image);
					}
					System.out.println("\n 이555차원 배열로 변환값");
					
					for( i = 0 ; i<one.length ; i++)
					{
						System.out.print("하이"+ one[i]+"\t");
					}
					System.out.println();
				}
				for(int i= 0 ; i<one.length ; i++)
				{

					System.out.print("하이"+ one[i]+"\t");
				}
				System.out.println();
				int count =0;
				for(int i = 0 ; i < one.length ; i++)
				{
					System.out.println("check");
					if( one[0] == 42 && one[1] ==42 && one[2] ==42 )   //1
					{
						count++;
						
					}
					if( one[0] == 42 && one[3] ==42 && one[6] ==42 )  //2
					{
						count++;
						
					}
					if( one[0] == 42 && one[4] ==42 && one[8] ==42 )  //3
					{
						count++;
						
					}
					if( one[1] == 42 && one[4] ==42 && one[7] ==42 )  //4
					{
						count++;
						
					}
					if( one[2] == 42 && one[5] ==42 && one[8] ==42 )  //5
					{
						count++;
						
					}
					if( one[2] == 42 && one[4] ==42 && one[6] ==42 )  //6
					{
						count++;
						
					}
					if( one[3] == 42 && one[4] ==42 && one[5] ==42 )  //7
					{
						count++;
						
					}
					if( one[6] == 42 && one[7] ==42 && one[8] ==42 )   //8
					{
						count++;
						
					}
					System.out.println("빙고"+ count);
					
					if (count >= winCnt )
					{
						System.out.println("축하합니다. ");
						winBingo.setVisible(true);
						winBingo2.setVisible(true);
						
						return;
					}
					
					break;
				}
			}
		});
		add(Button[6]);

		Button[7].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Button[7].setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Button[7].setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Button[7].setVisible(false);
				for(int i =0  ; i < one.length ; i++ )
				{
					if(button[0][0].getText().equals("8"))
					{
						System.out.println("1번일치8");
						one[0] = '*';
						button[0][0].setIcon(b8Image);
					}
					if(button[0][1].getText().equals("8"))
					{
						System.out.println("2번일치8");
						one[1] = '*';
						button[0][1].setIcon(b8Image);
					}
					if(button[0][2].getText().equals("8"))
					{
						System.out.println("3번일치8");
						one[2] = '*';
						button[0][2].setIcon(b8Image);
					}
					if(button[1][0].getText().equals("8"))
					{
						System.out.println("4번일치8");
						one[3] = '*';
						button[1][0].setIcon(b8Image);
					}
					if(button[1][1].getText().equals("8"))
					{
						System.out.println("5번일치8");
						one[4] = '*';
						button[1][1].setIcon(b8Image);
					}
					if(button[1][2].getText().equals("8"))
					{
						System.out.println("6번일치8");
						one[5] = '*';
						button[1][2].setIcon(b8Image);
					}
					if(button[2][0].getText().equals("8"))
					{
						System.out.println("7번일치8");
						one[6] = '*';
						button[2][0].setIcon(b8Image);
					}
					if(button[2][1].getText().equals("8"))
					{
						System.out.println("8번일치8");
						one[7] = '*';
						button[2][1].setIcon(b8Image);
					}
					if(button[2][2].getText().equals("8"))
					{
						System.out.println("9번일치8");
						one[8] = '*';
						button[2][2].setIcon(b8Image);
					}
				}
				for(int i= 0 ; i<one.length ; i++)
				{

					System.out.print("하이"+ one[i]+"\t");
				}
				System.out.println();
				int count =0;
				for(int i = 0 ; i < one.length ; i++)
				{
					System.out.println("check");
					if( one[0] == 42 && one[1] ==42 && one[2] ==42 )   //1
					{
						count++;
						
					}
					if( one[0] == 42 && one[3] ==42 && one[6] ==42 )  //2
					{
						count++;
						
					}
					if( one[0] == 42 && one[4] ==42 && one[8] ==42 )  //3
					{
						count++;
						
					}
					if( one[1] == 42 && one[4] ==42 && one[7] ==42 )  //4
					{
						count++;
						
					}
					if( one[2] == 42 && one[5] ==42 && one[8] ==42 )  //5
					{
						count++;
						
					}
					if( one[2] == 42 && one[4] ==42 && one[6] ==42 )  //6
					{
						count++;
						
					}
					if( one[3] == 42 && one[4] ==42 && one[5] ==42 )  //7
					{
						count++;
						
					}
					if( one[6] == 42 && one[7] ==42 && one[8] ==42 )   //8
					{
						count++;
						
					}
					System.out.println("빙고"+ count);
					
					if (count >= winCnt )
					{
						System.out.println("축하합니다. ");
						winBingo.setVisible(true);
						winBingo2.setVisible(true);
						
						return;
					}
					
					break;
				}
			}
		});
		add(Button[7]);

		Button[8].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Button[8].setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Button[8].setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Button[8].setVisible(false);
				for(int i =0  ; i < one.length ; i++ )
				{
					if(button[0][0].getText().equals("9"))
					{
						System.out.println("1번일치9");
						one[0] = '*';
						button[0][0].setIcon(b9Image);
					}
					if(button[0][1].getText().equals("9"))
					{
						System.out.println("2번일치9");
						one[1] = '*';
						button[0][1].setIcon(b9Image);
					}
					if(button[0][2].getText().equals("9"))
					{
						System.out.println("3번일치9");
						one[2] = '*';
						button[0][2].setIcon(b9Image);
					}
					if(button[1][0].getText().equals("9"))
					{
						System.out.println("4번일치9");
						one[3] = '*';
						button[1][0].setIcon(b9Image);
					}
					if(button[1][1].getText().equals("9"))
					{
						System.out.println("5번일치9");
						one[4] = '*';
						button[1][1].setIcon(b9Image);
					}
					if(button[1][2].getText().equals("9"))
					{
						System.out.println("6번일치9");
						one[5] = '*';
						button[1][2].setIcon(b9Image);
					}
					if(button[2][0].getText().equals("9"))
					{
						System.out.println("7번일치9");
						one[6] = '*';
						button[2][0].setIcon(b9Image);
					}
					if(button[2][1].getText().equals("9"))
					{
						System.out.println("8번일치9");
						one[7] = '*';
						button[2][1].setIcon(b9Image);
					}
					if(button[2][2].getText().equals("9"))
					{
						System.out.println("9번일치9");
						one[8] = '*';
						button[2][2].setIcon(b9Image);
					}
				}
				for(int i= 0 ; i<one.length ; i++)
				{
					System.out.print("하이"+ one[i]+"\t");
				}
				System.out.println();
				int count =0;
				for(int i = 0 ; i < one.length ; i++)
				{
					System.out.println("check");
					if( one[0] == 42 && one[1] ==42 && one[2] ==42 )   //1
					{
						count++;
						
					}
					if( one[0] == 42 && one[3] ==42 && one[6] ==42 )  //2
					{
						count++;
						
					}
					if( one[0] == 42 && one[4] ==42 && one[8] ==42 )  //3
					{
						count++;
						
					}
					if( one[1] == 42 && one[4] ==42 && one[7] ==42 )  //4
					{
						count++;
						
					}
					if( one[2] == 42 && one[5] ==42 && one[8] ==42 )  //5
					{
						count++;
						
					}
					if( one[2] == 42 && one[4] ==42 && one[6] ==42 )  //6
					{
						count++;
						
					}
					if( one[3] == 42 && one[4] ==42 && one[5] ==42 )  //7
					{
						count++;
						
					}
					if( one[6] == 42 && one[7] ==42 && one[8] ==42 )   //8
					{
						count++;
						
					}
					System.out.println("빙고"+ count);
					
					if (count >= winCnt )
					{
						System.out.println("축하합니다. ");
						winBingo.setVisible(true);
						winBingo2.setVisible(true);
						
						return;
					}
					
					break;
				}
			}
		});
		add(Button[8]);
		
		for(int i= 0 ; i<one.length ; i++)
		{

				System.out.print("하이  밖에서"
						+ ""+ one[i]+"\t");
		}
		System.out.println();
//		int count =0;
//		for(int i = 0 ; i < one.length ; i++)
//		{
//				System.out.println("check");
//				if( one[0] == 42 && one[1] ==42 && one[2] ==42 )   //1
//				{
//					count++;
//					
//				}
//				if( one[0] == 42 && one[3] ==42 && one[6] ==42 )  //2
//				{
//					count++;
//					
//				}
//				if( one[0] == 42 && one[4] ==42 && one[8] ==42 )  //3
//				{
//					count++;
//					
//				}
//				if( one[1] == 42 && one[4] ==42 && one[7] ==42 )  //4
//				{
//					count++;
//					
//				}
//				if( one[2] == 42 && one[5] ==42 && one[8] ==42 )  //5
//				{
//					count++;
//					
//				}
//				if( one[2] == 42 && one[4] ==42 && one[6] ==42 )  //6
//				{
//					count++;
//					
//				}
//				if( one[3] == 42 && one[4] ==42 && one[5] ==42 )  //7
//				{
//					count++;
//					
//				}
//				if( one[6] == 42 && one[7] ==42 && one[8] ==42 )   //8
//				{
//					count++;
//					
//				}
//				System.out.println("빙고"+ count);
//				
//				if (count == winCnt )
//				{
//					System.out.println("축하합니다. ");
//					winBingo.setVisible(true);
//					
//					return;
//				}
//				
//				break;
//		}
		
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

//		Music introMusic = new Music("HEALING POTION.mp3", true);
//		introMusic.start();
		System.out.println("\n 이555차원 배열로 변환값");
		
		for(int i = 0 ; i<one.length ; i++)
		{

				System.out.print(one[i]+"\t");
		}
		System.out.println();
		
	}
	
	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}

	public void screenDraw(Graphics g) {
		g.drawImage(Background, 0, 0, null);
		if(isMainScreen) {
//			g.drawImage(selectedImage,340,100,null);
		}
		paintComponents(g);
		this.repaint();
	}
}