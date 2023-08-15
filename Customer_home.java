package pro;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Customer_home extends JFrame {

	private JPanel contentPane;
	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customer_home frame = new Customer_home();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Customer_home() {
		frame=this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 517, 371);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 501, 500);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(6, 0, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(128, 128, 192));
		panel_5.setBounds(0, 0, 501, 83);
		panel_2.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 0, 123, 83);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\My PC\\Downloads\\kabo-p6yH8VmGqxo-unsplash (1).jpg"));
		panel_5.add(lblNewLabel);
		
		JLabel petname = new JLabel("Persian Cat");
		petname.setFont(new Font("Times New Roman", Font.BOLD, 18));
		petname.setBounds(133, 11, 103, 14);
		panel_5.add(petname);
		
		JLabel petprice = new JLabel("Price:25000");
		petprice.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		petprice.setBounds(133, 47, 103, 14);
		panel_5.add(petprice);
		
		JLabel petgender = new JLabel("Male");
		petgender.setFont(new Font("Times New Roman", Font.BOLD, 18));
		petgender.setBounds(303, 11, 46, 14);
		panel_5.add(petgender);
		
		JButton cb1 = new JButton("Add to Cart");
		cb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null," Persian Cat added successfully");
			}
		});
		cb1.setBounds(364, 45, 110, 23);
		panel_5.add(cb1);
		
		JLabel petcount = new JLabel("Count:1");
		petcount.setFont(new Font("Times New Roman", Font.BOLD, 17));
		petcount.setBounds(259, 47, 89, 14);
		panel_5.add(petcount);
		
		JButton btnNewButton = new JButton("LOGOUT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new Login().setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnNewButton.setBounds(395, 2, 96, 23);
		panel_5.add(btnNewButton);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(146, 146, 201));
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\My PC\\Downloads\\victor-grabarczyk-N04FIfHhv_k-unsplash (1).jpg"));
		lblNewLabel_5.setBounds(0, 0, 123, 83);
		panel_3.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("American FoxBound");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel_6.setBounds(133, 11, 164, 14);
		panel_3.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Price:50000");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel_7.setBounds(133, 44, 99, 14);
		panel_3.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Count:1");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_8.setBounds(257, 46, 60, 14);
		panel_3.add(lblNewLabel_8);
		
		JButton cb2 = new JButton("Add to Cart");
		cb2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null," American FoxBound added successfully");
			}
		});
		cb2.setBounds(367, 42, 105, 23);
		panel_3.add(cb2);
		
		JLabel lblNewLabel_14 = new JLabel("Male");
		lblNewLabel_14.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel_14.setBounds(298, 13, 54, 14);
		panel_3.add(lblNewLabel_14);
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(183, 183, 255));
		panel_6.setBounds(0, 0, 501, 83);
		panel_4.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblNewLabel_9 = new JLabel("New label");
		lblNewLabel_9.setIcon(new ImageIcon("C:\\Users\\My PC\\Downloads\\helena-lopes-lIeqGEdvex0-unsplash (1).jpg"));
		lblNewLabel_9.setBounds(0, 0, 124, 83);
		panel_6.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Arabian Horse");
		lblNewLabel_10.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel_10.setBounds(134, 11, 132, 14);
		panel_6.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Price:60000");
		lblNewLabel_11.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_11.setBounds(140, 58, 97, 14);
		panel_6.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("Count:1");
		lblNewLabel_12.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel_12.setBounds(256, 57, 68, 14);
		panel_6.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("Female");
		lblNewLabel_13.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel_13.setBounds(256, 13, 68, 14);
		panel_6.add(lblNewLabel_13);
		
		JButton cb3 = new JButton("Add to Cart");
		cb3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null," Arabian Horse added successfully");
			}
		});
		cb3.setBounds(364, 49, 106, 23);
		panel_6.add(cb3);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(147, 147, 255));
		panel_7.setBounds(0, 0, 501, 83);
		panel_1.add(panel_7);
		panel_7.setLayout(null);
		
		JLabel lblNewLabel_15 = new JLabel("New label");
		lblNewLabel_15.setIcon(new ImageIcon("C:\\Users\\My PC\\Downloads\\dmitry-chernyshov-vzVWYIr6F8U-unsplash (1).jpg"));
		lblNewLabel_15.setBounds(0, 0, 123, 83);
		panel_7.add(lblNewLabel_15);
		
		JLabel lblNewLabel_16 = new JLabel("Parrot");
		lblNewLabel_16.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel_16.setBounds(133, 21, 80, 14);
		panel_7.add(lblNewLabel_16);
		
		JLabel lblNewLabel_17 = new JLabel("Price:40000");
		lblNewLabel_17.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel_17.setBounds(133, 58, 97, 14);
		panel_7.add(lblNewLabel_17);
		
		JLabel lblNewLabel_18 = new JLabel("Male");
		lblNewLabel_18.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel_18.setBounds(261, 23, 46, 14);
		panel_7.add(lblNewLabel_18);
		
		JLabel lblNewLabel_19 = new JLabel("Count:1");
		lblNewLabel_19.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel_19.setBounds(261, 60, 68, 14);
		panel_7.add(lblNewLabel_19);
		
		JButton cb4 = new JButton("Add to Cart");
		cb4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null," Parrot added successfully");
			}
		});
		cb4.setBounds(366, 49, 106, 23);
		panel_7.add(cb4);
	}
}
