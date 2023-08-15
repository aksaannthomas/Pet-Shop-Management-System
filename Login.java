package pro;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login extends JFrame{

	private JFrame frame;
	private JTextField un;
	private JPasswordField pwd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = this;
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(255, 204, 230));
		frame.setBounds(100, 100, 450, 336);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PinkTail Pet Shop");
		lblNewLabel.setForeground(new Color(255, 0, 128));
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 29));
		lblNewLabel.setBounds(79, 0, 267, 46);
		frame.getContentPane().add(lblNewLabel);
		
		un = new JTextField();
		un.setBounds(118, 98, 86, 20);
		frame.getContentPane().add(un);
		un.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(33, 99, 89, 17);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(33, 145, 69, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		pwd = new JPasswordField();
		pwd.setBounds(118, 143, 86, 20);
		frame.getContentPane().add(pwd);
		pwd.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
				Class.forName("oracle.jdbc.driver.OracleDriver");	
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","aksa","aksa");
				Statement stmt=con.createStatement();

				int item=0;
				String query="select * from admin where aname='"+un.getText()+"' and apass='"+pwd.getText()+"'";
				ResultSet rs=stmt.executeQuery(query);
				if(rs.next())
				{
					
					if(rs.getString(1).equals("admin@gmail.com"))
					{
					item++;	
					setVisible(false);
					JOptionPane.showMessageDialog(null,"Admin Login successfully ");
					new Admin().setVisible(true);
				
					}
					else
					{
					JOptionPane.showMessageDialog(null,"Admin Login Failed");
					}
				}
				if(item==0)
				{
				String query1="select * from users where username='"+un.getText()+"' and password='"+pwd.getText()+"'";
				ResultSet rsuser=stmt.executeQuery(query1);
				if(rsuser.next())
				{
					setVisible(false);
					JOptionPane.showMessageDialog(null,"Login successfully");
					Cart hu=new Cart();
					hu.setVisible(true);
					return;
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Login Failed check username or password");
				}
				}

			}catch (Exception e1 ) {System.out.println(e1);}
			}});
				

		btnNewButton.setBackground(new Color(128, 128, 192));
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnNewButton.setBounds(79, 193, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("If not already a member");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(10, 244, 190, 25);
		frame.getContentPane().add(lblNewLabel_3);
		
		JButton btnNewButton_1 = new JButton("Register");
		btnNewButton_1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				frame.setVisible(false);
				new Register().setVisible(true);								
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnNewButton_1.setBackground(new Color(128, 128, 192));
		btnNewButton_1.setBounds(156, 245, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\My PC\\Downloads\\joe-caione-qO-PIF84Vxg-unsplash (3).jpg"));
		lblNewLabel_5.setBounds(0, 0, 434, 297);
		getContentPane().add(lblNewLabel_5);
		ImageIcon img = new ImageIcon(new ImageIcon("/dog1.jpg").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
	}
}


