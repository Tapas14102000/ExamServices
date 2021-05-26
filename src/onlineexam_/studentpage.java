package onlineexam_;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import project.ConnectionProvider;
import javax.swing.JTable;

public class studentpage extends JFrame {
	
	private JPanel contentPane;
	public  static JTextField lname;
	private JTextField lcontact;
	private JTextField luniversity;
	public static int open=0;
	public static JTextField lid;
	private JTextField laddress;
	static JLabel ltime;
	static JLabel ldate;
	static JTable table;
	String x1,y;
	
	public static JButton start;
	public static int k=0,key=0,j=0,h=0;
	
	public static studentpage frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					studentpage frame = new studentpage();
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
	
	

	public void initial()

	{
		
		try {
			Connection con=ConnectionProvider.getconn();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from info where id='"+loginpage.id+"'");
			if(rs.first())
			{
				lname.setText(rs.getString(2));
				lid.setText(rs.getString(1));
				lcontact.setText(rs.getString(7));
				luniversity.setText(rs.getString(4));
				laddress.setText(rs.getString(6));
			}
			else
			{
				JFrame jf=new JFrame();
				jf.setAlwaysOnTop(true);
				JOptionPane.showMessageDialog(jf, "DATA DOESN'T EXIST...");
			}
		}
		catch(Exception e1)
		{JFrame jf=new JFrame();
		jf.setAlwaysOnTop(true);
		JOptionPane.showMessageDialog(jf, e1);}
		try {
			Thread.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("hello3");
		new test();//details
	}
	

	public studentpage() 
	{
		setUndecorated(true);
		setAlwaysOnTop(false);
		try {	
			SimpleDateFormat df=new SimpleDateFormat("dd-MM-yyyy");
				Date date1=new Date();
				y=df.format(date1);
				ldate.setText(y);
				Thread t=new Thread() {
					public void run()
					{	while(true)
						{
							DateFormat date=new SimpleDateFormat("hh-mm-ss aa");
							x1=date.format(new Date());
							ltime.setText(x1);
								}
					}
				};
				t.start();
				}catch(Exception e) {}

		setIconImage(Toolkit.getDefaultToolkit().getImage(adminhome.class.getResource("/onlineexam_/icon3.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
				
				ldate = new JLabel("");
				ldate.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 20));
				ldate.setBounds(1145, 186, 161, 19);
				contentPane.add(ldate);
		
		ltime = new JLabel("");
		ltime.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 20));
		ltime.setForeground(new Color(0, 0, 255));
		ltime.setBounds(1148, 150, 158, 22);
		contentPane.add(ltime);
		JLabel lblEndsBy = new JLabel("ENDS BY");
		lblEndsBy.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblEndsBy.setBounds(1279, 253, 100, 19);
		contentPane.add(lblEndsBy);
		JLabel lblStartsAt = new JLabel("STARTS BY");
		lblStartsAt.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblStartsAt.setBounds(1102, 253, 122, 19);
		contentPane.add(lblStartsAt);
		JLabel lblExamDate = new JLabel("EXAM DATE");
		lblExamDate.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblExamDate.setBounds(869, 253, 122, 19);
		contentPane.add(lblExamDate);
		JLabel lblExamName = new JLabel("EXAM NAME");
		lblExamName.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblExamName.setBounds(626, 253, 122, 19);
		contentPane.add(lblExamName);
		table = new JTable();
		table.setBackground(new Color(255, 255, 255));
		table.setForeground(new Color(255, 0, 0));
		table.setFont(new Font("Times New Roman", Font.BOLD, 15));
		table.setBounds(608, 282, 835, 314);
		contentPane.add(table);
		
		JLabel lblDate = new JLabel("DATE");
		lblDate.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblDate.setForeground(new Color(178, 34, 34));
		lblDate.setBounds(1068, 186, 70, 21);
		contentPane.add(lblDate);
		
		JLabel lblTime = new JLabel("TIME");
		lblTime.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblTime.setForeground(new Color(139, 0, 0));
		lblTime.setBounds(1069, 150, 69, 26);
		contentPane.add(lblTime);
		
		laddress = new JTextField();
		laddress.setBackground(new Color(255, 255, 255));
		laddress.setForeground(new Color(0, 0, 0));
		laddress.setEditable(false);
		laddress.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 20));
		laddress.setBounds(36, 620, 483, 32);
		contentPane.add(laddress);
		laddress.setColumns(10);
		
		JLabel lblAddress = new JLabel("ADDRESS");
		lblAddress.setForeground(new Color(255, 255, 255));
		lblAddress.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblAddress.setBounds(36, 578, 238, 32);
		contentPane.add(lblAddress);
		
		lid = new JTextField();
		lid.setEditable(false);
		lid.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 22));
		lid.setBounds(36, 340, 483, 32);
		contentPane.add(lid);
		lid.setColumns(10);
		
		JLabel lblUserId = new JLabel("USER ID");
		lblUserId.setForeground(new Color(255, 255, 255));
		lblUserId.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblUserId.setBounds(36, 305, 158, 25);
		contentPane.add(lblUserId);
		
		final JButton btnSave = new JButton("SAVE");
		contentPane.add(btnSave);
		btnSave.setVisible(false);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				String id=lid.getText();
				String username=lname.getText();
				String desig=lcontact.getText();
				String university=luniversity.getText();
				try {
					Connection con=ConnectionProvider.getconn();
					PreparedStatement ps=con.prepareStatement("update info set username=?,contact=?,university=?,address=? where id='"+id+"'");
					ps.setString(1, username);
					ps.setString(2, desig);
					ps.setString(3, university);
					ps.setString(4, laddress.getText());
					ps.executeUpdate();
					JFrame jf=new JFrame();
					jf.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(jf, "Successfully updated..");
				}
				catch(Exception e1) {
					JFrame jf=new JFrame();
					jf.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(jf, e1);
				}
				lid.setEditable(false);
				lcontact.setEditable(false);
				luniversity.setEditable(false);
				lname.setEditable(false);
				laddress.setEditable(false);
				btnSave.setVisible(false);
			}
		});
		btnSave.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 27));
		btnSave.setForeground(new Color(0, 128, 0));
		btnSave.setBounds(85, 703, 108, 40);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(0, 0, 0));
		separator_1.setBackground(new Color(0, 0, 0));
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(583, 196, 2, 605);
		contentPane.add(separator_1);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 0, 0));
		separator.setForeground(new Color(0, 0, 0));
		separator.setBounds(281, 140, 1028, 2);
		contentPane.add(separator);
		
		JLabel lblaccountsecuredtss = new JLabel("@Account_secured_TSS");
		lblaccountsecuredtss.setForeground(new Color(255, 0, 0));
		lblaccountsecuredtss.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblaccountsecuredtss.setBounds(1200, 10, 228, 25);
		contentPane.add(lblaccountsecuredtss);
		
		JLabel lblWelcome = new JLabel("WELCOME");
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setFont(new Font("Times New Roman", Font.BOLD, 99));
		lblWelcome.setBounds(471, 48, 556, 74);
		contentPane.add(lblWelcome);
		
		JButton btnEditProfile = new JButton("EDIT PROFILE");
		btnEditProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(open==0)
				{
				btnSave.setVisible(true);
				lcontact.setEditable(true);
				luniversity.setEditable(true);
				lname.setEditable(true);
				laddress.setEditable(true);
				}
				else
				{
					JFrame jf=new JFrame();
					jf.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(jf, "One Form is already opened...");
				}
			}
		});
		btnEditProfile.setForeground(new Color(0, 128, 0));
		btnEditProfile.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 27));
		btnEditProfile.setBounds(281, 703, 238, 40);
		contentPane.add(btnEditProfile);
		
		luniversity = new JTextField();
		luniversity.setForeground(new Color(0, 0, 0));
		luniversity.setEditable(false);
		luniversity.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 20));
		luniversity.setBounds(36, 526, 483, 32);
		contentPane.add(luniversity);
		luniversity.setColumns(10);
		
		JLabel lblUniversity = new JLabel("UNIVERSITY");
		lblUniversity.setForeground(new Color(255, 255, 255));
		lblUniversity.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblUniversity.setBounds(36, 484, 292, 32);
		contentPane.add(lblUniversity);
		
		lcontact = new JTextField();
		lcontact.setForeground(new Color(0, 0, 0));
		lcontact.setEditable(false);
		lcontact.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 20));
		lcontact.setBounds(36, 436, 483, 32);
		contentPane.add(lcontact);
		lcontact.setColumns(10);
		
		JLabel lblDesignation = new JLabel("CONTACT NUMBER");
		lblDesignation.setForeground(new Color(255, 255, 255));
		lblDesignation.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblDesignation.setBounds(36, 394, 292, 32);
		contentPane.add(lblDesignation);
		
		lname = new JTextField();
		lname.setEditable(false);
		lname.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 22));
		lname.setForeground(new Color(0, 0, 0));
		lname.setBounds(36, 263, 483, 32);
		contentPane.add(lname);
		lname.setColumns(10);
		
		JLabel lblUsername = new JLabel("USERNAME");
		lblUsername.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblUsername.setForeground(new Color(255, 255, 255));
		lblUsername.setBounds(36, 225, 185, 33);
		contentPane.add(lblUsername);
		
		JButton btnExit = new JButton("");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{	if(open==0)
			{
				int a=JOptionPane.showConfirmDialog(null,"Do you really want to logout?","select",JOptionPane.YES_NO_OPTION);
				if(a==0)
				{	
					setVisible(false);
					new loginpage();
					loginpage.frmLibraryManagementSystem.setVisible(true);
				}
			}
			else
			{
				JFrame jf=new JFrame();
				jf.setAlwaysOnTop(true);
				JOptionPane.showMessageDialog(jf, "One Form is already opened...");
			}
				
			}
		});
		btnExit.setIcon(new ImageIcon(adminhome.class.getResource("/onlineexam_/icon23.jpeg")));
		btnExit.setFont(new Font("Sitka Subheading", Font.BOLD | Font.ITALIC, 40));
		btnExit.setForeground(new Color(255, 0, 0));
		btnExit.setBounds(1462, 10, 62, 56);
		contentPane.add(btnExit);
		
		JButton myResult = new JButton(" MY RESULTS");
		myResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new myres().setVisible(true);
			}
		});
		myResult.setIcon(new ImageIcon(adminhome.class.getResource("/onlineexam_/icon16.jpeg")));
		myResult.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		myResult.setForeground(new Color(0, 0, 255));
		myResult.setBounds(921, 702, 303, 48);
		contentPane.add(myResult);
		
		start = new JButton("START EXAM");
		start.setVisible(false);
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{String temp=null;int c=0;
				try {
					Connection con=ConnectionProvider.getconn();
					Statement st1=con.createStatement();
					ResultSet rs5=st1.executeQuery("select count(examno) from examschedule");
					if(rs5.first())
					{
						j=Integer.parseInt(rs5.getString(1));
					}
					Statement st0=con.createStatement();
					ResultSet rs0=st0.executeQuery("select count(*) from examres where id='"+lname.getText()+"' and examno='"+j+"'");
					if(rs0.first())
					{
						c=Integer.valueOf(rs0.getString(1));
					}
					if(c==0) {
					ResultSet r=st1.executeQuery("select * from examschedule where examno='"+j+"'");
					if(r.first())
					{
						temp=r.getString(1);
					}
					PreparedStatement ps=con.prepareStatement("insert into examres values(?,?,'0','0',?,'0','0','0','PASS')");
					Statement st=con.createStatement();
					ps.setString(1, loginpage.id);
					ps.setString(2, String.valueOf(j));
					ps.setString(3, temp);
					ps.executeUpdate();
					setVisible(false);
					System.out.println("hello4");
					new examq().setVisible(true);//calling to exam
					}
				}
				catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		start.setIcon(new ImageIcon(adminhome.class.getResource("/onlineexam_/icon15.jpeg")));
		start.setFont(new Font("Times New Roman", Font.BOLD, 20));
		start.setForeground(new Color(0, 0, 255));
		start.setBounds(864, 714, 303, 47);
		//contentPane.add(start);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(studentpage.class.getResource("/onlineexam_/icon2.png")));
		label_1.setBounds(36, 37, 185, 168);
		contentPane.add(label_1);
		
		JLabel label = new JLabel("");
		label.setVerticalAlignment(SwingConstants.TOP);
		label.setIcon(new ImageIcon(studentpage.class.getResource("/onlineexam_/t5.jpg")));
		label.setBounds(0, 0, 1599, 1036);
		contentPane.add(label);
		initial();
		new tableid(2);
		
}
}

