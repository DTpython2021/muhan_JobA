package muhan_teamA;
import java.awt.EventQueue;


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Toolkit;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

//import ImagePanel;

import javax.swing.JPasswordField;
import javax.swing.JScrollPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JSpinner;

public class App {
	private final String ID = "q";
	private final String PWD = "q";
	private JFrame frame;
	private JTextField idField;
	private JPasswordField pwdField;
	private JTable table;

	int a, b, c, d, e, f, h;
	int sum;
	int abc;
	private JTextField tff;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App window = new App();
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
	public App() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("  Plan A ");

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ImagePanel loginPanel = new ImagePanel(new ImageIcon("D:\\menu1\\LogIn_Panel1.png").getImage());
		frame.getContentPane().add(loginPanel);

		frame.setSize(loginPanel.getDim());
		frame.setPreferredSize(loginPanel.getDim());
		idField = new JTextField();
		idField.setFont(new Font("AdobeFan Heiti Std", Font.PLAIN, 25));
		idField.setBounds(761, 456, 154, 33);
		loginPanel.add(idField);
		idField.setColumns(10);
		idField.setBorder(null);

		pwdField = new JPasswordField();
		pwdField.setFont(new Font("AdobeFan Heiti Std", Font.PLAIN, 25));
		pwdField.setBounds(771, 511, 144, 33);
		pwdField.setBorder(null);
		loginPanel.add(pwdField);

		JButton btnLogin = new JButton("");
		btnLogin.setIcon(new ImageIcon("D:\\menu1\\PressLogIn_btn.png"));
		btnLogin.setPressedIcon(new ImageIcon("D:\\menu1\\LogIn_btn.png"));
		btnLogin.setBorder(null);
		btnLogin.setBounds(686, 585, 229, 33);
		loginPanel.add(btnLogin);
		
		
		String columnName[] = { " ", " ", " " };

		Object rowData[][] = {};

		DefaultTableModel model = new DefaultTableModel(rowData, columnName);

		

		ImagePanel menuPanel = new ImagePanel(new ImageIcon("D:\\menu1\\back1.png").getImage());
		frame.getContentPane().add(menuPanel);

		ImagePanel menu1Panel = new ImagePanel(new ImageIcon("D:\\menu1\\menu11111.png").getImage());
		menu1Panel.setBounds(0, 122, 1023, 780);
		menuPanel.add(menu1Panel);

		JSpinner spinner1 = new JSpinner();
		spinner1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		spinner1.setBounds(391, 126, 97, 45);
		menu1Panel.add(spinner1);

		JSpinner spinner2 = new JSpinner();
		spinner2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		spinner2.setBounds(863, 126, 99, 45);
		menu1Panel.add(spinner2);

		JSpinner spinner3 = new JSpinner();
		spinner3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		spinner3.setBounds(391, 367, 97, 45);
		menu1Panel.add(spinner3);

		JSpinner spinner4 = new JSpinner();
		spinner4.setFont(new Font("Tahoma", Font.PLAIN, 30));
		spinner4.setBounds(863, 367, 99, 45);
		menu1Panel.add(spinner4);

		JSpinner spinner5 = new JSpinner();
		spinner5.setFont(new Font("Tahoma", Font.PLAIN, 30));
		spinner5.setBounds(391, 606, 97, 45);
		menu1Panel.add(spinner5);

		JSpinner spinner6 = new JSpinner();
		spinner6.setFont(new Font("Tahoma", Font.PLAIN, 30));
		spinner6.setBounds(864, 606, 98, 45);
		menu1Panel.add(spinner6);
		JButton btnM1_1 = new JButton("");
		btnM1_1.setIcon(new ImageIcon("D:\\menu1\\board.png"));
		btnM1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a = (int) spinner1.getValue();
				abc = a * 3500;
				Object[] temp = { "ÇÜ¹ö°Å", a, abc };
				SpinnerModel mod = new SpinnerNumberModel(0, 0, 10, 1);
				spinner1.setModel(mod);
				model.addRow(temp);

			}
		});
		btnM1_1.setBounds(346, 174, 142, 45);
		menu1Panel.add(btnM1_1);

		JButton btnM1_2 = new JButton("");
		btnM1_2.setIcon(new ImageIcon("D:\\menu1\\board.png"));
		btnM1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				b = (int) spinner2.getValue();
				abc = b * 4000;
				Object[] temp = { "¿ë°¨ÇÑ ±è¹ä", b, abc };
				SpinnerModel mod = new SpinnerNumberModel(0, 0, 10, 1);
				spinner2.setModel(mod);
				model.addRow(temp);
			}
		});
		btnM1_2.setBounds(819, 174, 142, 45);
		menu1Panel.add(btnM1_2);

		JButton btnM1_3 = new JButton("");
		btnM1_3.setIcon(new ImageIcon("D:\\menu1\\board.png"));
		btnM1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c = (int) spinner3.getValue();
				abc = c * 6000;
				Object[] temp = { "È­´öÇÇÀÚ", c, abc };
				SpinnerModel mod = new SpinnerNumberModel(0, 0, 10, 1);
				spinner3.setModel(mod);
				model.addRow(temp);
			}
		});
		btnM1_3.setBounds(346, 413, 142, 45);
		menu1Panel.add(btnM1_3);

		JButton btnM1_4 = new JButton("");
		btnM1_4.setIcon(new ImageIcon("D:\\menu1\\board.png"));
		btnM1_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				d = (int) spinner4.getValue();
				abc = d * 5000;
				Object[] temp = { "»÷µåÀ§Ä¡", d, abc };
				SpinnerModel mod = new SpinnerNumberModel(0, 0, 10, 1);
				spinner4.setModel(mod);
				model.addRow(temp);
			}
		});
		btnM1_4.setBounds(819, 413, 142, 45);
		menu1Panel.add(btnM1_4);

		JButton btnM1_5 = new JButton("");
		btnM1_5.setIcon(new ImageIcon("D:\\menu1\\board.png"));
		btnM1_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				h = (int) spinner5.getValue();
				abc = h * 2900;
				Object[] temp = { "¹Ð¶±ººÀÌ", h, abc };
				SpinnerModel mod = new SpinnerNumberModel(0, 0, 10, 1);
				spinner5.setModel(mod);
				model.addRow(temp);
			}
		});
		btnM1_5.setBounds(347, 651, 142, 45);
		menu1Panel.add(btnM1_5);

		JButton btnM1_6 = new JButton("");
		btnM1_6.setIcon(new ImageIcon("D:\\menu1\\board.png"));
		btnM1_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f = (int) spinner6.getValue();
				abc = f * 1900;
				Object[] temp = { "Â¥ÆÄ±¸¸®", f, abc };
				SpinnerModel mod = new SpinnerNumberModel(0, 0, 10, 1);
				spinner6.setModel(mod);
				model.addRow(temp);
			}
		});
		btnM1_6.setBounds(820, 651, 142, 45);
		menu1Panel.add(btnM1_6);

		menu1Panel.setVisible(false);

		ImagePanel menu2Panel = new ImagePanel(new ImageIcon("D:/menu1/menu22222.png").getImage());
		menu2Panel.setBounds(0, 122, 1023, 780);
		menuPanel.add(menu2Panel);

		JSpinner spinner7 = new JSpinner();

		spinner7.setFont(new Font("Tahoma", Font.PLAIN, 30));
		spinner7.setBounds(397, 132, 96, 45);
		menu2Panel.add(spinner7);

		JSpinner spinner8 = new JSpinner();

		spinner8.setFont(new Font("Tahoma", Font.PLAIN, 30));
		spinner8.setBounds(865, 132, 96, 45);
		menu2Panel.add(spinner8);

		JSpinner spinner9 = new JSpinner();
		spinner9.setFont(new Font("Tahoma", Font.PLAIN, 30));
		spinner9.setBounds(397, 368, 96, 45);
		menu2Panel.add(spinner9);

		JSpinner spinner10 = new JSpinner();
		spinner10.setFont(new Font("Tahoma", Font.PLAIN, 30));
		spinner10.setBounds(865, 368, 96, 45);
		menu2Panel.add(spinner10);

		JSpinner spinner11 = new JSpinner();
		spinner11.setFont(new Font("Tahoma", Font.PLAIN, 30));
		spinner11.setBounds(397, 608, 96, 45);
		menu2Panel.add(spinner11);

		JSpinner spinner12 = new JSpinner();
		spinner12.setFont(new Font("Tahoma", Font.PLAIN, 30));
		spinner12.setBounds(865, 608, 96, 45);
		menu2Panel.add(spinner12);

		JButton btnM2_1 = new JButton("");
		btnM2_1.setIcon(new ImageIcon("D:\\menu1\\board.png"));
		btnM2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a = (int) spinner7.getValue();
				abc = a * 10000;
				Object[] temp = { "ºñºö¹ä", 1, abc };
				SpinnerModel mod = new SpinnerNumberModel(0, 0, 10, 1);
				spinner7.setModel(mod);
				model.addRow(temp);
			}
		});
		btnM2_1.setBounds(351, 177, 142, 45);
		menu2Panel.add(btnM2_1);

		JButton btnM2_2 = new JButton("");
		btnM2_2.setIcon(new ImageIcon("D:\\menu1\\board.png"));
		btnM2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				b = (int) spinner8.getValue();
				abc = b * 9000;
				Object[] temp = { "ººÀ½¹ä", b, abc };
				SpinnerModel mod = new SpinnerNumberModel(0, 0, 10, 1);
				spinner8.setModel(mod);
				model.addRow(temp);
			}
		});
		btnM2_2.setBounds(819, 177, 142, 45);
		menu2Panel.add(btnM2_2);

		JButton btnM2_3 = new JButton("");
		btnM2_3.setIcon(new ImageIcon("D:\\menu1\\board.png"));
		btnM2_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c = (int) spinner9.getValue();
				abc = c * 6000;
				Object[] temp = { "½ºÆÄ°ÔÆ¼", c, abc };
				SpinnerModel mod = new SpinnerNumberModel(0, 0, 10, 1);
				spinner9.setModel(mod);
				model.addRow(temp);
			}
		});
		btnM2_3.setBounds(351, 413, 142, 45);
		menu2Panel.add(btnM2_3);

		JButton btnM2_4 = new JButton("");
		btnM2_4.setIcon(new ImageIcon("D:\\menu1\\board.png"));
		btnM2_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				d = (int) spinner10.getValue();
				abc = d * 4000;
				Object[] temp = { "¼Ò°í±â ´þ¹ä", d, abc };
				SpinnerModel mod = new SpinnerNumberModel(0, 0, 10, 1);
				spinner10.setModel(mod);
				model.addRow(temp);
			}
		});
		btnM2_4.setBounds(819, 413, 142, 45);
		menu2Panel.add(btnM2_4);

		JButton btnM2_5 = new JButton("");
		btnM2_5.setIcon(new ImageIcon("D:\\menu1\\board.png"));
		btnM2_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				h = (int) spinner11.getValue();
				abc = h * 6000;
				Object[] temp = { "¼øµÎºÎ", h, abc };
				SpinnerModel mod = new SpinnerNumberModel(0, 0, 10, 1);
				spinner11.setModel(mod);
				model.addRow(temp);
			}
		});
		btnM2_5.setBounds(351, 653, 142, 45);
		menu2Panel.add(btnM2_5);

		JButton btnM2_6 = new JButton("");
		btnM2_6.setIcon(new ImageIcon("D:\\menu1\\board.png"));
		btnM2_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f = (int) spinner12.getValue();
				abc = f * 4000;
				Object[] temp = { "½Å¶ó¸é", f, abc };
				SpinnerModel mod = new SpinnerNumberModel(0, 0, 10, 1);
				spinner12.setModel(mod);
				model.addRow(temp);

			}
		});
		btnM2_6.setBounds(819, 653, 142, 45);
		menu2Panel.add(btnM2_6);

		menu2Panel.setVisible(false);
		ImagePanel menu3Panel = new ImagePanel(new ImageIcon("D:\\menu1\\menu44444.png").getImage());
		menu3Panel.setBounds(0, 122, 1023, 780);
		menuPanel.add(menu3Panel);

		JSpinner spinner13 = new JSpinner();
		spinner13.setFont(new Font("Tahoma", Font.PLAIN, 30));
		spinner13.setBounds(390, 129, 102, 45);
		menu3Panel.add(spinner13);

		JSpinner spinner14 = new JSpinner();
		spinner14.setFont(new Font("Tahoma", Font.PLAIN, 30));
		spinner14.setBounds(862, 129, 99, 45);
		menu3Panel.add(spinner14);

		JSpinner spinner15 = new JSpinner();
		spinner15.setFont(new Font("Tahoma", Font.PLAIN, 30));
		spinner15.setBounds(390, 367, 102, 45);
		menu3Panel.add(spinner15);

		JSpinner spinner16 = new JSpinner();
		spinner16.setFont(new Font("Tahoma", Font.PLAIN, 30));
		spinner16.setBounds(862, 367, 99, 45);
		menu3Panel.add(spinner16);

		JSpinner spinner17 = new JSpinner();
		spinner17.setFont(new Font("Tahoma", Font.PLAIN, 30));
		spinner17.setBounds(390, 604, 102, 45);
		menu3Panel.add(spinner17);

		JSpinner spinner18 = new JSpinner();
		spinner18.setFont(new Font("Tahoma", Font.PLAIN, 30));
		spinner18.setBounds(862, 604, 99, 45);
		menu3Panel.add(spinner18);

		JButton btnM3_1 = new JButton("");
		btnM3_1.setIcon(new ImageIcon("D:\\menu1\\board.png"));
		btnM3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a = (int) spinner13.getValue();
				abc = a * 1700;
				Object[] temp = { "¸¶Ä«·Õ", a, abc };
				SpinnerModel mod = new SpinnerNumberModel(0, 0, 10, 1);
				spinner13.setModel(mod);
				model.addRow(temp);
			}
		});
		btnM3_1.setBounds(350, 173, 142, 45);
		menu3Panel.add(btnM3_1);

		JButton btnM3_2 = new JButton("");
		btnM3_2.setIcon(new ImageIcon("D:\\menu1\\board.png"));
		btnM3_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				b = (int) spinner14.getValue();
				abc = b * 5900;
				Object[] temp = { "»ø·¯µå", b, abc };
				SpinnerModel mod = new SpinnerNumberModel(0, 0, 10, 1);
				spinner14.setModel(mod);
				model.addRow(temp);
			}
		});
		btnM3_2.setBounds(819, 173, 142, 45);
		menu3Panel.add(btnM3_2);

		JButton btnM3_3 = new JButton("");
		btnM3_3.setIcon(new ImageIcon("D:\\menu1\\board.png"));
		btnM3_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c = (int) spinner15.getValue();
				abc = c * 1500;
				Object[] temp = { "»õ¿ì±ø", c, abc };
				SpinnerModel mod = new SpinnerNumberModel(0, 0, 10, 1);
				spinner15.setModel(mod);
				model.addRow(temp);
			}
		});
		btnM3_3.setBounds(350, 411, 142, 45);
		menu3Panel.add(btnM3_3);

		JButton btnM3_4 = new JButton("");
		btnM3_4.setIcon(new ImageIcon("D:\\menu1\\board.png"));
		btnM3_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				d = (int) spinner16.getValue();
				abc = d * 2000;
				Object[] temp = { "Çã´Ï¹öÅÍÄ¨", d, abc };
				SpinnerModel mod = new SpinnerNumberModel(0, 0, 10, 1);
				spinner16.setModel(mod);
				model.addRow(temp);
			}
		});
		btnM3_4.setBounds(819, 411, 142, 45);
		menu3Panel.add(btnM3_4);

		JButton btnM3_5 = new JButton("");
		btnM3_5.setIcon(new ImageIcon("D:\\menu1\\board.png"));
		btnM3_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				h = (int) spinner17.getValue();
				abc = h * 3000;
				Object[] temp = { "ÆËÄÜ", h, abc };
				SpinnerModel mod = new SpinnerNumberModel(0, 0, 10, 1);
				spinner17.setModel(mod);
				model.addRow(temp);
			}
		});
		btnM3_5.setBounds(350, 649, 142, 45);
		menu3Panel.add(btnM3_5);

		JButton btnM3_6 = new JButton("");
		btnM3_6.setIcon(new ImageIcon("D:\\menu1\\board.png"));
		btnM3_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f = (int) spinner18.getValue();
				abc = f * 2000;
				Object[] temp = { "¸ÓÇÉ", f, abc };
				SpinnerModel mod = new SpinnerNumberModel(0, 0, 10, 1);
				spinner18.setModel(mod);
				model.addRow(temp);
			}
		});
		btnM3_6.setBounds(819, 649, 142, 45);
		menu3Panel.add(btnM3_6);

		menu3Panel.setVisible(false);

		ImagePanel menu4Panel = new ImagePanel(new ImageIcon("D:/menu1/menu55555.png").getImage());
		menu4Panel.setBounds(0, 122, 1023, 780);
		menuPanel.add(menu4Panel);
		JSpinner spinner19 = new JSpinner();
		spinner19.setFont(new Font("Tahoma", Font.PLAIN, 30));
		spinner19.setBounds(396, 124, 98, 45);
		menu4Panel.add(spinner19);

		JSpinner spinner20 = new JSpinner();
		spinner20.setFont(new Font("Tahoma", Font.PLAIN, 30));
		spinner20.setBounds(865, 124, 96, 45);
		menu4Panel.add(spinner20);

		JSpinner spinner21 = new JSpinner();
		spinner21.setFont(new Font("Tahoma", Font.PLAIN, 30));
		spinner21.setBounds(396, 364, 98, 45);
		menu4Panel.add(spinner21);

		JSpinner spinner22 = new JSpinner();
		spinner22.setFont(new Font("Tahoma", Font.PLAIN, 30));
		spinner22.setBounds(865, 364, 96, 45);
		menu4Panel.add(spinner22);

		JSpinner spinner23 = new JSpinner();
		spinner23.setFont(new Font("Tahoma", Font.PLAIN, 30));
		spinner23.setBounds(396, 603, 98, 45);
		menu4Panel.add(spinner23);

		JSpinner spinner24 = new JSpinner();
		spinner24.setFont(new Font("Tahoma", Font.PLAIN, 30));
		spinner24.setBounds(865, 603, 96, 45);
		menu4Panel.add(spinner24);

		JButton btnM4_1 = new JButton("");
		btnM4_1.setIcon(new ImageIcon("D:\\menu1\\board.png"));
		btnM4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a = (int) spinner19.getValue();
				abc = a * 900;
				Object[] temp = { "ºñ¶ô½ÄÇý", a, abc };
				SpinnerModel mod = new SpinnerNumberModel(0, 0, 10, 1);
				spinner19.setModel(mod);
				model.addRow(temp);
			}
		});
		btnM4_1.setBounds(352, 170, 142, 45);
		menu4Panel.add(btnM4_1);

		JButton btnM4_2 = new JButton("");
		btnM4_2.setIcon(new ImageIcon("D:\\menu1\\board.png"));
		btnM4_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				b = (int) spinner20.getValue();
				abc = b * 760;
				Object[] temp = { "ÄÜÆ®¶óº£ÀÌ½º", b, abc };
				SpinnerModel mod = new SpinnerNumberModel(0, 0, 10, 1);
				spinner20.setModel(mod);
				model.addRow(temp);
			}
		});
		btnM4_2.setBounds(819, 170, 142, 45);
		menu4Panel.add(btnM4_2);

		JButton btnM4_3 = new JButton("");
		btnM4_3.setIcon(new ImageIcon("D:\\menu1\\board.png"));
		btnM4_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c = (int) spinner21.getValue();
				abc = c * 1260;
				Object[] temp = { "¿¡½ºÇÁ·¹¼Ò", c, abc };
				SpinnerModel mod = new SpinnerNumberModel(0, 0, 10, 1);
				spinner21.setModel(mod);
				model.addRow(temp);
			}
		});
		btnM4_3.setBounds(352, 409, 142, 45);
		menu4Panel.add(btnM4_3);

		JButton btnM4_4 = new JButton("");
		btnM4_4.setIcon(new ImageIcon("D:\\menu1\\board.png"));
		btnM4_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				d = (int) spinner22.getValue();
				abc = d * 300;
				Object[] temp = { "¼ÖÀÇ ´«", d, abc };
				SpinnerModel mod = new SpinnerNumberModel(0, 0, 10, 1);
				spinner22.setModel(mod);
				model.addRow(temp);
			}
		});
		btnM4_4.setBounds(819, 409, 142, 45);
		menu4Panel.add(btnM4_4);

		JButton btnM4_5 = new JButton("");
		btnM4_5.setIcon(new ImageIcon("D:\\menu1\\board.png"));
		btnM4_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				h = (int) spinner23.getValue();
				abc = h * 350;
				Object[] temp = { "¸ÆÄÝ", h, abc };
				SpinnerModel mod = new SpinnerNumberModel(0, 0, 10, 1);
				spinner23.setModel(mod);
				model.addRow(temp);
			}
		});

		btnM4_5.setBounds(352, 648, 142, 45);
		menu4Panel.add(btnM4_5);

		JButton btnM4_6 = new JButton("");
		btnM4_6.setIcon(new ImageIcon("D:\\menu1\\board.png"));
		btnM4_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f = (int) spinner24.getValue();
				abc = f * 270;
				Object[] temp = { "¸¶½Å´Ù", f, abc };
				SpinnerModel mod = new SpinnerNumberModel(0, 0, 10, 1);
				spinner24.setModel(mod);
				model.addRow(temp);
			}
		});

		btnM4_6.setBounds(819, 648, 142, 45);
		menu4Panel.add(btnM4_6);
		menuPanel.setVisible(false);
		
		
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ID.equals(idField.getText()) && PWD.equals("q")) {
					loginPanel.setVisible(false);
					menu2Panel.setVisible(false);
					menu3Panel.setVisible(false);
					menu4Panel.setVisible(false);
					menuPanel.setVisible(true);

				} else {
					JOptionPane.showMessageDialog(null, "You Failed to log in");
				}
			}

		});

		JButton btnMenu1 = new JButton("");
		btnMenu1.setBackground(Color.WHITE);
		btnMenu1.setBorder(null);
		btnMenu1.setIcon(new ImageIcon("D:\\menu1\\0222_menu_btn.png"));
		btnMenu1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu2Panel.setVisible(false);
				menu3Panel.setVisible(false);
				menu4Panel.setVisible(false);
				menu1Panel.setVisible(true);

			}
		});

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\menu1\\014Sol.png"));
		lblNewLabel_1.setBounds(774, 264, 131, 74);
		menu4Panel.add(lblNewLabel_1);
		btnMenu1.setBounds(59, 53, 192, 37);
		menuPanel.add(btnMenu1);

		JButton btnMenu2 = new JButton("");
		btnMenu2.setBackground(Color.WHITE);
		btnMenu2.setBorder(null);
		btnMenu2.setIcon(new ImageIcon("D:\\menu1\\011111_menu_btn.png"));
		btnMenu2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu1Panel.setVisible(false);
				menu3Panel.setVisible(false);
				menu4Panel.setVisible(false);
				menu2Panel.setVisible(true);
			}
		});
		btnMenu2.setBounds(301, 51, 204, 41);
		menuPanel.add(btnMenu2);

		JButton btnMenu3 = new JButton("");
		btnMenu3.setBackground(Color.WHITE);
		btnMenu3.setBorder(null);
		btnMenu3.setIcon(new ImageIcon("D:\\menu1\\0333_menu_btn.png"));
		btnMenu3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu1Panel.setVisible(false);
				menu2Panel.setVisible(false);
				menu4Panel.setVisible(false);
				menu3Panel.setVisible(true);
			}
		});
		btnMenu3.setBounds(544, 53, 211, 37);
		menuPanel.add(btnMenu3);

		JButton btnMenu4 = new JButton("");
		btnMenu4.setBackground(Color.WHITE);
		btnMenu4.setBorder(null);
		btnMenu4.setIcon(new ImageIcon("D:\\menu1\\04_menu_btn.png"));
		btnMenu4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu1Panel.setVisible(false);
				menu2Panel.setVisible(false);
				menu3Panel.setVisible(false);
				menu4Panel.setVisible(true);

			}
		});
		btnMenu4.setBounds(808, 49, 185, 47);
		menuPanel.add(btnMenu4);

		frame.getContentPane().add(menuPanel);

		ImagePanel panelCount = new ImagePanel(new ImageIcon("D:\\menu1\\pay11.png").getImage());
		menuPanel.add(panelCount);
		// JPanel panelCount = new JPanel();

		panelCount.setBounds(1044, 213, 548, 689);

		frame.getContentPane().add(menuPanel);
		panelCount.setLayout(null);
		panelCount.setLayout(null);

		JTable jTable = new JTable(model);
		jTable.setFont(new Font("AdobeFan Heiti Std", Font.PLAIN, 24));
		jTable.setRowHeight(50);

		jTable.setPreferredScrollableViewportSize(new Dimension(542, 399));
		JScrollPane jScrollPane = new JScrollPane(jTable);
		jScrollPane.setBounds(38, 79, 474, 372);
		panelCount.setLayout(null);

		table = new JTable();

		panelCount.add(table);

		table.setBounds(12, 528, 538, -538);

		panelCount.add(table);
		panelCount.add(jScrollPane);
		panelCount.setOpaque(false);

		JLabel label_1 = new JLabel("");
		label_1.setBounds(352, 34, 160, 44);
		panelCount.add(label_1);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setIcon(new ImageIcon("D:\\menu1\\item_btn.png"));

		JLabel label = new JLabel("");
		label.setBounds(193, 34, 160, 44);
		panelCount.add(label);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon("D:\\menu1\\cont_btn.png"));

		JLabel lbl = new JLabel("");
		lbl.setBounds(38, 34, 160, 44);
		panelCount.add(lbl);
		lbl.setHorizontalAlignment(SwingConstants.CENTER);
		lbl.setIcon(new ImageIcon("D:\\menu1\\price_btn.png"));

		JButton btnCoupon_1 = new JButton("");
		btnCoupon_1.setIcon(new ImageIcon("D:\\menu1\\co_btn.png"));
		btnCoupon_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton btnCoupon = (JButton) e.getSource();
				jTable.setValueAt(0, jTable.getSelectedRow(), 2);

			}
		});

		btnCoupon_1.setBounds(12, 569, 105, 58);
		panelCount.add(btnCoupon_1);

		JButton btnSelcancel_1 = new JButton("");
		btnSelcancel_1.setIcon(new ImageIcon("D:\\menu1\\sc_btn.png"));
		btnSelcancel_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JButton btnSelcancel = (JButton) e.getSource();
				DefaultTableModel m = (DefaultTableModel) jTable.getModel();

				m.removeRow(jTable.getSelectedRow());

			}
		});
		btnSelcancel_1.setBounds(140, 569, 113, 58);
		panelCount.add(btnSelcancel_1);

		JButton btnTotalCancel_1 = new JButton("");
		btnTotalCancel_1.setIcon(new ImageIcon("D:\\menu1\\can_btn.png"));
		btnTotalCancel_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton btnTotalCancel = (JButton) e.getSource();
				DefaultTableModel m = (DefaultTableModel) jTable.getModel();

				m.setRowCount(0);
				tff.setText(String.valueOf(""));
			}
		});
		btnTotalCancel_1.setBounds(280, 569, 105, 58);
		panelCount.add(btnTotalCancel_1);

		JButton btnPay = new JButton("");
		btnPay.setIcon(new ImageIcon("D:\\menu1\\pay_btn.png"));
		btnPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int rowCont = jTable.getRowCount();
				int sum = 0;
				for (int i = 0; i < rowCont; i++) {
					sum += (int) jTable.getValueAt(i, 2);

				}
				String str = String.format("%,d", sum);
				tff.setText(str + "  ¿ø");
				tff.setFont(new Font("AdobeFan Heiti Std", Font.BOLD, 30));

			}
		});
		btnPay.setBounds(409, 569, 105, 58);
		panelCount.add(btnPay);

		JLabel lblSum = new JLabel("\uC9C0\uBD88 \uAE08\uC561  :");
		lblSum.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSum.setFont(new Font("AdobeFan Heiti Std", Font.PLAIN, 30));
		lblSum.setBounds(48, 457, 174, 58);
		panelCount.add(lblSum);

		tff = new JTextField();
		tff.setFont(new Font("AdobeFan Heiti Std", Font.PLAIN, 30));
		tff.setHorizontalAlignment(SwingConstants.CENTER);
		tff.setBounds(237, 457, 275, 58);
		panelCount.add(tff);
		tff.setColumns(10);
		tff.setBorder(null);
		menuPanel.setVisible(false);

		

		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setJMenuBar(menuBar());
		frame.pack();

	}

	public JMenuBar menuBar() {
		JMenuBar bar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenu aboutMenu = new JMenu("About");
		bar.add(fileMenu);
		bar.add(aboutMenu);
		JMenuItem openFile = new JMenuItem("Open");
		JMenuItem exit = new JMenuItem("Exit");
		fileMenu.add(openFile);
		fileMenu.addSeparator();
		fileMenu.add(exit);

		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}

		});

		return bar;
	}
}