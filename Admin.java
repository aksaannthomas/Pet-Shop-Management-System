package pro;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.TitledBorder;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

public class Admin extends JFrame {

	protected JFrame frame;
	private JPanel contentPane;
	private JTextField pname;
	private JTextField pcat;
	private JTextField pprice;
	private JTextField pcount;
	protected JComboBox pgen;
	private JTable table;
	private JTable table_1;
	JOptionPane pane;
	private JTextField t1;
	private JTable table_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin frame = new Admin();
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
	public Admin() {
		frame=this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 612, 404);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 36, 578, 318);
		contentPane.add(tabbedPane);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Add Pet", null, panel_3, null);
		panel_3.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("Pet Name");
		lblNewLabel.setForeground(new Color(255, 0, 128));
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 37, 70, 14);
		panel_3.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Pet Category");
		lblNewLabel_1.setForeground(new Color(255, 0, 128));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 62, 90, 17);
		panel_3.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Price");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_2.setForeground(new Color(255, 0, 128));
		lblNewLabel_2.setBounds(10, 115, 70, 14);
		panel_3.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Gender");
		lblNewLabel_3.setForeground(new Color(255, 0, 128));
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(10, 90, 70, 14);
		panel_3.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Count");
		lblNewLabel_4.setForeground(new Color(255, 0, 128));
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(10, 140, 70, 14);
		panel_3.add(lblNewLabel_4);
		
		String s[]= {"Male", "Female"};
		final JComboBox pgen = new JComboBox(s);
	//	pgender.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		pgen.setBounds(98, 87, 70, 22);
		panel_3.add(pgen);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
				Class.forName("oracle.jdbc.driver.OracleDriver");	
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","aksa","aksa");
				Statement stmt=con.createStatement();
				
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
				JOptionPane.showMessageDialog(null,"Inserted sucessfully");

//				
//				frame.setVisible(false);
//				new Login().setVisible(true);
				
			}catch (Exception e1 ) {System.out.println(e1);}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnNewButton.setBounds(50, 186, 102, 23);
		panel_3.add(btnNewButton);
		
		pname = new JTextField();
		pname.setBounds(98, 35, 70, 20);
		panel_3.add(pname);
		pname.setColumns(10);
		
		pcat = new JTextField();
		pcat.setBounds(98, 61, 70, 20);
		panel_3.add(pcat);
		pcat.setColumns(10);
		
		pprice = new JTextField();
		pprice.setBounds(98, 113, 70, 20);
		panel_3.add(pprice);
		pprice.setColumns(10);
		
		pcount = new JTextField();
		pcount.setBounds(98, 138, 70, 20);
		panel_3.add(pcount);
		pcount.setColumns(10);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(189, 11, 374, 268);
		panel_3.add(scrollPane_2);
		
		table_2 = new JTable();
		scrollPane_2.setViewportView(table_2);
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Pid", "Pname", "Pcategory", "Pgender", "Pprice", "Count"
			}
		));
		table_2.getColumnModel().getColumn(0).setPreferredWidth(40);
		table_2.getColumnModel().getColumn(1).setPreferredWidth(52);
		table_2.getColumnModel().getColumn(2).setPreferredWidth(82);
		table_2.getColumnModel().getColumn(3).setPreferredWidth(51);
		table_2.getColumnModel().getColumn(4).setPreferredWidth(52);
		table_2.getColumnModel().getColumn(5).setPreferredWidth(52);
		
		JButton btnNewButton_6 = new JButton("DISPLAY");
		btnNewButton_6.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
				Class.forName("oracle.jdbc.driver.OracleDriver");	
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","aksa","aksa");
				Statement stmt=con.createStatement();				
			
				ResultSet rs=stmt.executeQuery("select * from pets");
				
				while(rs.next()) {
					String id=String.valueOf(rs.getInt("pid"));
					String name=rs.getString("pname");
					String categ=rs.getString("pcategory");
					String gender=rs.getString("pgender");
					String price=rs.getString("pprice");
					String count=rs.getString("count");
					
					String tbData[]= {id,name, categ, gender, price, count};
					DefaultTableModel tblModel=(DefaultTableModel)table_2.getModel();
					tblModel.addRow(tbData);
					
				}
				
			}catch (Exception e1 ) {System.out.println(e1);}
			}
		});
		btnNewButton_6.setBounds(50, 220, 102, 23);
		panel_3.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("CLEAR");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table_2.setModel(new DefaultTableModel(null, new String[] {"id","name","categ","gender","price","count"}));
				
			}
		});
		btnNewButton_7.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnNewButton_7.setBounds(50, 254, 102, 23);
		panel_3.add(btnNewButton_7);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setIcon(new ImageIcon("C:\\Users\\My PC\\OneDrive\\Pictures\\pets\\doggy.jpg"));
		lblNewLabel_7.setBounds(0, 0, 573, 315);
		panel_3.add(lblNewLabel_7);
		
	
		
		JPanel panel = new JPanel();
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 46, 344, 180);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Pid", "Pname", "Pcategory", "Pgender", "PPrice", "Count"
			}
		));
		
		JButton btnNewButton_1 = new JButton("Display");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
				Class.forName("oracle.jdbc.driver.OracleDriver");	
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","aksa","aksa");
				Statement stmt=con.createStatement();				
			
				ResultSet rs=stmt.executeQuery("select * from pets");
				
				while(rs.next()) {
					String id=String.valueOf(rs.getInt("pid"));
					String name=rs.getString("pname");
					String categ=rs.getString("pcategory");
					String gender=rs.getString("pgender");
					String price=rs.getString("pprice");
					String count=rs.getString("count");
					
					String tbData[]= {id,name, categ, gender, price, count};
					DefaultTableModel tblModel=(DefaultTableModel)table.getModel();
					tblModel.addRow(tbData);
					
				}
				
			}catch (Exception e1 ) {System.out.println(e1);}
			}
		});
		btnNewButton_1.setBounds(64, 11, 89, 23);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("Delete");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		btnNewButton_3.setBounds(163, 11, 89, 23);
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Clear");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.setModel(new DefaultTableModel(null, new String[] {"id","name","categ","gender","price","count"}));
			}
		});
		btnNewButton_4.setBounds(262, 11, 89, 23);
		panel.add(btnNewButton_4);
		
		
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Delete Pet", null, panel_2, null);
		panel_2.setLayout(null);
		
		JButton btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel tblModel=(DefaultTableModel)table_1.getModel();
//				if(table_1.getSelectedRowCount()==1) {
					tblModel.removeRow(table_1.getSelectedRow());
					try
					{
					Class.forName("oracle.jdbc.driver.OracleDriver");	
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","aksa","aksa");
					String id=t1.getText();
					PreparedStatement stmt=con.prepareStatement("Delete from pets where pid="+id+"");
					stmt.execute();
					JOptionPane.showMessageDialog(null, "Deleted successfully");
					
				}catch (Exception e1 ) {System.out.println(e1);}
//				}
//				else if(table_1.getSelectedRowCount()==0) {
//					JOptionPane.showMessageDialog(null,"Table empty");
//				}
//				else {
//					JOptionPane.showMessageDialog( null, "Select single row for delete");
//				}
			}
		});
		btnNewButton_2.setBounds(293, 12, 89, 23);
		panel_2.add(btnNewButton_2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(79, 56, 416, 212);
		panel_2.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Pid", "Pname", "Pcategory", "Pgender", "Pprice", "Count"
			}
		));
		
		JLabel lblNewLabel_6 = new JLabel("Enter id to delete:");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setBackground(new Color(240, 240, 240));
		lblNewLabel_6.setBounds(21, 15, 115, 14);
		panel_2.add(lblNewLabel_6);
		
		t1 = new JTextField();
		t1.setBounds(146, 12, 75, 20);
		panel_2.add(t1);
		t1.setColumns(10);
		
		JButton btnNewButton_5 = new JButton("Display");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try
				{
				Class.forName("oracle.jdbc.driver.OracleDriver");	
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","aksa","aksa");
				Statement stmt=con.createStatement();				
			
				ResultSet rs=stmt.executeQuery("select * from pets");
				
				while(rs.next()) {
					String id=String.valueOf(rs.getInt("pid"));
					String name=rs.getString("pname");
					String categ=rs.getString("pcategory");
					String gender=rs.getString("pgender");
					String price=rs.getString("pprice");
					String count=rs.getString("count");
					
					String tbData1[]= {id,name, categ, gender, price, count};
					DefaultTableModel tblModel1=(DefaultTableModel)table_1.getModel();
					tblModel1.addRow(tbData1);
					
				}
				
			}catch (Exception e1 ) {System.out.println(e1);}
			}
		});
		btnNewButton_5.setBounds(403, 12, 89, 23);
		panel_2.add(btnNewButton_5);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\My PC\\OneDrive\\Pictures\\pets\\doggy.jpg"));
		lblNewLabel_5.setBounds(0, 0, 573, 315);
		panel_2.add(lblNewLabel_5);
		
		JLabel lblNewLabel_8 = new JLabel("Admin Panel");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_8.setBounds(206, 11, 112, 24);
		contentPane.add(lblNewLabel_8);
		
		JButton btnNewButton_8 = new JButton("LOGOUT");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);				
				new Login().setVisible(true);
			}
		});
		btnNewButton_8.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnNewButton_8.setBounds(457, 14, 118, 23);
		contentPane.add(btnNewButton_8);
	
		
		
	}
}
