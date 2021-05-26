package onlineexam_;

import project.ConnectionProvider;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class loginpage {

	public static JFrame frmLibraryManagementSystem;
	public static JTextField txtEnterYourMail;
	private JPasswordField passwordField;
	private JButton btnLogin;
	/**
	 * Launch the application.
	 */
	public static String id;
	static Connection con;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					int k=0;
					loginpage window = new loginpage();
					con=ConnectionProvider.getconn();
					Statement st=con.createStatement();//createStatement is a static method of DriverManager class
					ResultSet rs=st.executeQuery("select count(*) from info where desig='DEVELOPER'"); //checks, Is their any owner of this application or not ?
					if(rs.first()) //It moves the cursor to the 1st row in the table
					{
						k=Integer.parseInt(rs.getString(1)); //if there is atleast a record in the table then k sets to 1
					}
					if(k==1)
					loginpage.frmLibraryManagementSystem.setVisible(true);  //open the LoginPage
					else
						new checkmefirst().setVisible(true); //create an owner before the application is used
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	
	public loginpage() {
		initialize();
		frmLibraryManagementSystem.setUndecorated(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frmLibraryManagementSystem = new JFrame();
		frmLibraryManagementSystem.getContentPane().setBackground(new Color(240, 240, 240)); //sets the background color of the contentpane 
		frmLibraryManagementSystem.setResizable(false); //makes the window not resizable 
		frmLibraryManagementSystem.setTitle("ONLINE EXAMINATION PORTAL"); //sets the title of the window
		frmLibraryManagementSystem.setIconImage(Toolkit.getDefaultToolkit().getImage(loginpage.class.getResource("/onlineexam_/img9.jpg"))); //set the background image/wallpaper
		frmLibraryManagementSystem.setBounds(0, 0, 1650, 1200);
		frmLibraryManagementSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLibraryManagementSystem.getContentPane().setLayout(null);
		
		JButton btnBack = new JButton("");
		btnBack.addActionListener(new ActionListener() { //
			public void actionPerformed(ActionEvent e) {
				int a=JOptionPane.showConfirmDialog(null,"Do you really want to exit application?","select",JOptionPane.YES_NO_OPTION); //a confirmation dialogue box
				if(a==0)
				{
					System.exit(0);
				}
			}
		});
		
		JButton btnSignUp = new JButton("SIGN UP");
		btnSignUp.setForeground(new Color(0, 0, 0));
		btnSignUp.setBackground(new Color(192, 192, 192));
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmLibraryManagementSystem.setVisible(false);
				new signup().setVisible(true);
			}
		});
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(0, 0, 0));
		separator_1.setBackground(new Color(0, 0, 0));
		separator_1.setBounds(881, 713, 268, 2);
		frmLibraryManagementSystem.getContentPane().add(separator_1);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setBackground(new Color(0, 0, 0));
		separator.setBounds(381, 713, 268, 2);
		frmLibraryManagementSystem.getContentPane().add(separator);
		
		JLabel lblNotRegistered = new JLabel("Not Registered ?");
		lblNotRegistered.setForeground(new Color(255, 0, 0));
		lblNotRegistered.setBackground(new Color(0, 0, 0));
		lblNotRegistered.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		lblNotRegistered.setBounds(659, 687, 210, 44);
		frmLibraryManagementSystem.getContentPane().add(lblNotRegistered);
		
		JLabel label_1 = new JLabel("");
		label_1.setForeground(new Color(0, 0, 255));
		label_1.setIcon(new ImageIcon(loginpage.class.getResource("/onlineexam_/t10.png")));
		label_1.setBounds(680, 325, 133, 122);
		frmLibraryManagementSystem.getContentPane().add(label_1);
		btnSignUp.setFont(new Font("Times New Roman", Font.BOLD, 22));
		btnSignUp.setBounds(680, 741, 133, 34);
		frmLibraryManagementSystem.getContentPane().add(btnSignUp);
		btnBack.setIcon(new ImageIcon(loginpage.class.getResource("/onlineexam_/icon20.jpeg")));
		btnBack.setForeground(Color.RED);
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 40));
		btnBack.setBounds(1471, 10, 43, 41);
		frmLibraryManagementSystem.getContentPane().add(btnBack);
		
		passwordField = new JPasswordField();
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setEchoChar('*');
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				if(c==KeyEvent.VK_ENTER)
			{btnLogin.doClick();}
			}
		});
		passwordField.setBackground(new Color(255, 255, 255));
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passwordField.setToolTipText("Enter Your Password");
		passwordField.setForeground(new Color(0, 0, 255));
		passwordField.setBounds(548, 554, 380, 26);
		frmLibraryManagementSystem.getContentPane().add(passwordField);
		
		txtEnterYourMail = new JTextField(1000);
		txtEnterYourMail.setHorizontalAlignment(SwingConstants.CENTER);
		txtEnterYourMail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				if(c==KeyEvent.VK_ENTER)
			{passwordField.grabFocus();}
			}
		});
		txtEnterYourMail.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtEnterYourMail.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
			if(txtEnterYourMail.getText().equals("Enter Your Mail ID"))
			{
				txtEnterYourMail.setText("");
				txtEnterYourMail.setForeground(new Color(0,0,255));
			}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtEnterYourMail.getText().equals(""))
				{
					txtEnterYourMail.setText("Enter Your Mail ID");
					txtEnterYourMail.setForeground(new Color(0, 0, 205));				
					}
			}
		});
		txtEnterYourMail.setText("Enter Your Mail ID");
		txtEnterYourMail.setForeground(new Color(0, 0, 205));
		txtEnterYourMail.setBounds(548, 477, 380, 30);
		frmLibraryManagementSystem.getContentPane().add(txtEnterYourMail);
		txtEnterYourMail.setColumns(10);
		
		final JCheckBox rdbtnShow = new JCheckBox("show");
		rdbtnShow.setForeground(new Color(0, 0, 0));
		rdbtnShow.setBackground(new Color(230, 230, 250));
		rdbtnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(rdbtnShow.isSelected())
				passwordField.setEchoChar((char)0);
			else
				passwordField.setEchoChar('*');
			}
		});
		rdbtnShow.setFont(new Font("Times New Roman", Font.BOLD, 15));
		rdbtnShow.setBounds(980, 557, 59, 21);
		frmLibraryManagementSystem.getContentPane().add(rdbtnShow);
		
		 btnLogin = new JButton("LOGIN");
		 btnLogin.setForeground(new Color(0, 0, 0));
		 btnLogin.setBackground(new Color(192, 192, 192));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id=txtEnterYourMail.getText();String x,z;
				try {
					con=ConnectionProvider.getconn();
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery("select * from info where id='"+id+"'");
					if(rs.first())
					{
						x=rs.getString(5);
						z=rs.getString(3);
						if(passwordField.getText().equals(x))
						{
							frmLibraryManagementSystem.setVisible(false);
							if(!z.equals("Employee"))
								new adminhome().setVisible(true);
							else
								new studentpage().setVisible(true); 
						}
						else
						{
							ImageIcon icon=new ImageIcon("icon20.jpeg");
							JOptionPane.showMessageDialog(null, "<html><b style=\"color: red; font-size: 10px\">Incoreect <br>Password</b></html>","show",JOptionPane.INFORMATION_MESSAGE,icon);
						}
			
					}
					else
					{
						JFrame jf=new JFrame();
						jf.setAlwaysOnTop(true);
						JOptionPane.showMessageDialog(jf, "Invalid ID...");
						
					}
				}
				catch(Exception e1)
				{JFrame jf=new JFrame();
				jf.setAlwaysOnTop(true);
				JOptionPane.showMessageDialog(jf, e1);
}

			}
		});
		btnLogin.setFont(new Font("Times New Roman", Font.BOLD, 22));
		btnLogin.setBounds(686, 634, 116, 36);
		frmLibraryManagementSystem.getContentPane().add(btnLogin);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setBackground(new Color(255, 255, 255));
		lblPassword.setForeground(new Color(0, 0, 0));
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblPassword.setBounds(694, 517, 175, 24);
		frmLibraryManagementSystem.getContentPane().add(lblPassword);
		
		JLabel label = new JLabel("");
		label.setVerticalAlignment(SwingConstants.TOP);
		label.setIcon(new ImageIcon(loginpage.class.getResource("/onlineexam_/t4.jpg")));
		label.setBounds(0, 0, 1650, 998);
		frmLibraryManagementSystem.getContentPane().add(label);
	}
}
