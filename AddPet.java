package pro;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Window;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class AddPet extends JFrame {

	private JPanel contentPane;
	private JTextField pname;
	private JTextField pcat;
	private JTextField pprice;
	private JTextField pcount;
	protected JFrame frame;
	protected JComboBox pgender;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddPet frame = new AddPet();
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
	public AddPet() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 322);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Pet Name");
		lblNewLabel.setForeground(new Color(255, 0, 128));
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel.setBounds(22, 35, 67, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Pet Category");
		lblNewLabel_1.setForeground(new Color(255, 0, 128));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(22, 74, 78, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Gender");
		lblNewLabel_2.setForeground(new Color(255, 0, 128));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(22, 111, 67, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Price");
		lblNewLabel_3.setForeground(new Color(255, 0, 128));
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(22, 147, 67, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Count");
		lblNewLabel_4.setForeground(new Color(255, 0, 128));
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(22, 180, 67, 14);
		contentPane.add(lblNewLabel_4);
		
		pname = new JTextField();
		pname.setBounds(110, 33, 86, 20);
		contentPane.add(pname);
		pname.setColumns(10);
		
		pcat = new JTextField();
		pcat.setBounds(110, 72, 86, 20);
		contentPane.add(pcat);
		pcat.setColumns(10);
		
		pprice = new JTextField();
		pprice.setBounds(110, 145, 86, 20);
		contentPane.add(pprice);
		pprice.setColumns(10);
		
		pcount = new JTextField();
		pcount.setBounds(110, 178, 86, 20);
		contentPane.add(pcount);
		pcount.setColumns(10);
		
		
		String s[]= {"Male", "Female"};
		final JComboBox pgen = new JComboBox(s);
	//	pgender.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		pgen.setBounds(110, 108, 86, 22);
		contentPane.add(pgen);
		
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
				Class.forName("oracle.jdbc.driver.OracleDriver");	
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","aksa","aksa");
				Statement stmt=con.createStatement();
				//stmt.executeUpdate("Create table pets(pid number primary key, pname varchar2(20), pcategory varchar2(25), pgender varchar2(10),pprice int, count int)");
				//System.out.println("Table created");
				
				PreparedStatement pstmt = con.prepareStatement("insert into pets values(?,?,?,?,?,?)");
				ResultSet rsuid=stmt.executeQuery("select count(pid) from pets");
				rsuid.next();
				int uid=rsuid.getInt(1);
				int newuid=uid+1;
				pstmt.setInt(1, newuid);
				pstmt.setString(2, pname.getText());
				pstmt.setString(3, pcat.getText());
			
				pstmt.setString(4, pgen.getSelectedItem().toString());
				pstmt.setString(5, pprice.getText());
				pstmt.setString(6, pcount.getText());
				pstmt.executeUpdate();
				System.out.println("Insertion successful");
			
			}catch (Exception e1 ) {System.out.println(e1);}
			}
		});
		btnNewButton.setBackground(new Color(128, 128, 192));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.setBounds(63, 231, 89, 23);
		contentPane.add(btnNewButton);
		
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\My PC\\Downloads\\joe-caione-qO-PIF84Vxg-unsplash (3).jpg"));
		lblNewLabel_5.setBounds(0, 0, 434, 283);
		contentPane.add(lblNewLabel_5);
	}
}
