package pro;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Cart extends JFrame {

	private JPanel contentPane;
	JFrame frame;
	private JTable table;
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;
	private JTable table_1;
	int n=1,grtot=0;
	private JTextField t4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cart frame = new Cart();
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
	public Cart() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\My PC\\OneDrive\\Pictures\\pets\\doggy resized.jpg"));
		frame=this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 690, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cart & Billing");
		lblNewLabel.setForeground(new Color(255, 0, 128));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel.setBounds(241, 11, 161, 31);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Add to Bill");
		btnNewButton.setBackground(new Color(128, 128, 192));
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
				Class.forName("oracle.jdbc.driver.OracleDriver");	
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","aksa","aksa");
				Statement stmt=con.createStatement();											 
					String oid=String.valueOf(n);					
					String name=t1.getText();
					String price=t2.getText();
					String count=t3.getText();
					String total=String.valueOf(Integer.parseInt(t2.getText())*Integer.parseInt(t3.getText()));
					String tbData[]= {oid,name, price, count,total};
					DefaultTableModel tblModel=(DefaultTableModel)table_1.getModel();
					tblModel.addRow(tbData);
					int tot=Integer.parseInt(total);
					grtot=grtot+tot;
					t4.setText("Rs."+grtot);
					n++;				
				
			}catch (Exception e1 ) {System.out.println(e1);}
			}
		});
		btnNewButton.setBounds(80, 323, 119, 23);
		contentPane.add(btnNewButton);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
			
				DefaultTableModel model=( DefaultTableModel)table.getModel();
				 int row = table.getSelectedRow();
	                String id = model.getValueAt(row, 0).toString();

	                try
	        		{
	        		Class.forName("oracle.jdbc.driver.OracleDriver");	
	        		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","aksa","aksa");
	        		Statement stmt=con.createStatement();				
	        	
	        		ResultSet rs=stmt.executeQuery("select pname,pprice from pets where pid='"+id+"'");
	        		
	        		while(rs.next()) {
	        		
	        			t1.setText(rs.getString("pname"));
	        			t2.setText(rs.getString("pprice"));
	        		
	        		}
	        		
	        	}catch (Exception e1 ) {System.out.println(e1);}
			}
		});
		scrollPane.setBounds(53, 53, 517, 117);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Pid", "Pname", "PCategory", "Pgender", "Pprice", "Count"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(28);
		table.getColumnModel().getColumn(1).setPreferredWidth(95);
		table.getColumnModel().getColumn(2).setPreferredWidth(81);
		table.getColumnModel().getColumn(3).setPreferredWidth(72);
		table.getColumnModel().getColumn(4).setPreferredWidth(62);
		
		JLabel lblNewLabel_1 = new JLabel("Product List");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBackground(new Color(240, 240, 240));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1.setBounds(33, 28, 107, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Product Name");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(25, 234, 104, 17);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Price");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(33, 259, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Count");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(33, 284, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		t1 = new JTextField();
		t1.setBounds(139, 231, 119, 20);
		contentPane.add(t1);
		t1.setColumns(10);
		
		t2 = new JTextField();
		t2.setBounds(139, 256, 119, 20);
		contentPane.add(t2);
		t2.setColumns(10);
		
		t3 = new JTextField();
		t3.setBounds(139, 281, 119, 20);
		contentPane.add(t3);
		t3.setColumns(10);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(307, 181, 357, 159);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Orderid", "Pname", "Price", "Qty", "Amount"
			}
		));
		
		JLabel lblNewLabel_5 = new JLabel("Total:");
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_5.setBounds(317, 351, 98, 14);
		contentPane.add(lblNewLabel_5);
		
		t4 = new JTextField();
		t4.setFont(new Font("Times New Roman", Font.BOLD, 18));
		t4.setBounds(387, 351, 86, 20);
		contentPane.add(t4);
		t4.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Place Order");
		btnNewButton_1.setBackground(new Color(128, 128, 192));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Your order has been placed");
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnNewButton_1.setBounds(512, 349, 132, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Logout");
		btnNewButton_2.setBackground(new Color(128, 128, 192));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new Login().setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton_2.setBounds(575, 11, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\My PC\\OneDrive\\Pictures\\pets\\doggy resized.jpg"));
		lblNewLabel_6.setBounds(0, 0, 674, 378);
		contentPane.add(lblNewLabel_6);
		table_1.getColumnModel().getColumn(0).setPreferredWidth(55);
		table_1.getColumnModel().getColumn(2).setPreferredWidth(48);
		table_1.getColumnModel().getColumn(3).setPreferredWidth(39);
		table_1.getColumnModel().getColumn(4).setPreferredWidth(51);
		
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
}
