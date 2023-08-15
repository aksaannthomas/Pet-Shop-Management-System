package pro;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Register extends JFrame{

	private JFrame frame;
	private JTextField name;
	private JTextField username;
	private JTextField textField_2;
	private JTextField textField_3;
	private JPasswordField password;
	private JPasswordField confirm_pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register window = new Register();
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
	public Register() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = this;
		frame.getContentPane().setBackground(new Color(255, 198, 226));
		frame.setBounds(100, 100, 450, 333);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel.setBounds(23, 69, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("E-mail");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(23, 94, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Address");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(23, 119, 58, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Phone No");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(23, 144, 92, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Password");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(23, 169, 58, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Registration Form");
		lblNewLabel_5.setForeground(new Color(255, 0, 128));
		lblNewLabel_5.setFont(new Font("Trebuchet MS", Font.BOLD, 29));
		lblNewLabel_5.setBounds(99, 11, 250, 37);
		frame.getContentPane().add(lblNewLabel_5);
		
		name = new JTextField();
		name.setBounds(99, 67, 117, 20);
		frame.getContentPane().add(name);
		name.setColumns(10);
		
		username = new JTextField();
		username.setBounds(99, 92, 117, 20);
		frame.getContentPane().add(username);
		username.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(99, 117, 117, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(99, 142, 117, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Confirm Password");
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(0, 194, 137, 18);
		frame.getContentPane().add(lblNewLabel_6);
		
		JButton btnNewButton = new JButton("Sign Up");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
				Class.forName("oracle.jdbc.driver.OracleDriver");	
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","aksa","aksa");
				Statement stmt=con.createStatement();
				//stmt.executeUpdate("Create table users(userid number primary key, name varchar2(20), username varchar2(25), password varchar2(20))");
				//System.out.println("Table created");
				
				PreparedStatement pstmt = con.prepareStatement("insert into users values(?,?,?,?)");
				ResultSet rsuid=stmt.executeQuery("select count(userid) from users");
				rsuid.next();
				int uid=rsuid.getInt(1);
				int newuid=uid+1;
				pstmt.setInt(1, newuid);
				pstmt.setString(2, name.getText());
				pstmt.setString(3, username.getText());
				pstmt.setString(4, password.getText());
				
				if(password.getText().equals(confirm_pass.getText())) {
					pstmt.executeUpdate();
					System.out.println("Insertion successful");
					frame.setVisible(false);
					new Login().setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Password and confirm password not matched");
				}
							
				
			}catch (Exception e1 ) {System.out.println(e1);}
			}});
			
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnNewButton.setBackground(new Color(128, 128, 192));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBounds(46, 233, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		password = new JPasswordField();
		password.setBounds(99, 167, 117, 20);
		frame.getContentPane().add(password);
		
		confirm_pass = new JPasswordField();
		confirm_pass.setBounds(112, 194, 104, 20);
		frame.getContentPane().add(confirm_pass);
		
		JLabel lblNewLabel_7 = new JLabel("If already a member,");
		lblNewLabel_7.setForeground(new Color(255, 255, 255));
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_7.setBounds(10, 269, 125, 14);
		getContentPane().add(lblNewLabel_7);
		
		JButton btnNewButton_1 = new JButton("Login");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new Login().setVisible(true);
			}
		});
		btnNewButton_1.setBackground(new Color(128, 128, 192));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnNewButton_1.setBounds(148, 265, 78, 23);
		getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setIcon(new ImageIcon("C:\\Users\\My PC\\Downloads\\joe-caione-qO-PIF84Vxg-unsplash (3).jpg"));
		lblNewLabel_8.setBounds(0, 0, 434, 294);
		getContentPane().add(lblNewLabel_8);
	}

//	public void setVisible(boolean b) {
//		// TODO Auto-generated method stub
//		
//	}
}
