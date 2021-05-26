package onlineexam_;

import java.text.*;
import javax.swing.*;
import project.ConnectionProvider;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class signup extends JFrame  {
	private JPanel contentPane;
	private JTextField name;
	private JTextField userid;
	private JTextField contact;
	private JTextField address;
	private JTextField password;
	private JPasswordField reset;
	private JLabel date,label_2;
	int h=0,m=0,s=0;
	Thread t=null;
	String x,y;
	private JTextField txtUniversity;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					signup frame = new signup();
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
	
	public signup()
	{
		initialize();
		Thread t=new Thread() {
			public void run()
			{
				while(true)
				{
					DateFormat date=new SimpleDateFormat("hh-mm-ss aa");
					x=date.format(new Date());
					label_2.setText(x);
					try {
						Thread.sleep(1);
					}
					catch(Exception e) {}
				}
			}
		};
		t.start();
		SimpleDateFormat df=new SimpleDateFormat("dd-MM-yyyy");
		Date date1=new Date();
		y=df.format(date1);
		date.setText(y);
	}
	
	public void initialize() {
		setUndecorated(true);
		//setAlwaysOnTop(true);
		setBounds(80, 20, 900, 580);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAlreadyRegistered = new JButton("ALREADY REGISTERED ?");
		btnAlreadyRegistered.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			new loginpage().frmLibraryManagementSystem.setVisible(true);
			}
		});
		
		txtUniversity = new JTextField(25);
		txtUniversity.setHorizontalAlignment(SwingConstants.CENTER);
		txtUniversity.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				if(c==KeyEvent.VK_ENTER)
			{address.grabFocus();}
			}
		});
		txtUniversity.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtUniversity .getText().equals("Enter University"))
				{
					txtUniversity .setText("");
					txtUniversity .setForeground(new Color(0,0,255));
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtUniversity .getText().equals(""))
				{
					txtUniversity .setText("Enter University");
					txtUniversity .setForeground(new Color(0,0,255));
				}
			}
		});
		txtUniversity.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtUniversity.setForeground(new Color(0, 0, 255));
		txtUniversity.setText("Enter University");
		txtUniversity.setBounds(142, 269, 630, 25);
		contentPane.add(txtUniversity);
		txtUniversity.setColumns(10);
		
		label_2 = new JLabel("");
		label_2.setForeground(new Color(255, 0, 0));
		label_2.setFont(new Font("Times New Roman", Font.BOLD, 22));
		label_2.setBounds(709, 51, 143, 25);
		contentPane.add(label_2);
		
		JLabel lblTime = new JLabel("TIME   :");
		lblTime.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblTime.setBounds(617, 51, 87, 30);
		contentPane.add(lblTime);
		btnAlreadyRegistered.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnAlreadyRegistered.setForeground(new Color(255, 0, 0));
		btnAlreadyRegistered.setBounds(486, 469, 366, 34);
		contentPane.add(btnAlreadyRegistered);
		
		final JButton btnSignUp = new JButton("SIGN UP");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String uid=userid.getText();
				String uname=name.getText();
				String uaddress=address.getText();
				String ucontact=contact.getText();
				String ureset=reset.getText();
				String pass=password.getText();
				if(uid.equals("Enter Email ID")||uname.equals("Enter Candidate's Name")||uaddress.equals("Enter Address")||ucontact.equals("Enter Contact Number")||pass.equals("Enter Password"))
				{
					ImageIcon icon=new ImageIcon("icon20.jpeg");
					JOptionPane.showMessageDialog(null, "<html><b style=\"color: red; font-size: 10px\"><br>Complete the form</b></html>","show",JOptionPane.INFORMATION_MESSAGE,icon);
				}
				else if(pass.equals(ureset))
					try {
					Connection con=ConnectionProvider.getconn();
					PreparedStatement ps=con.prepareStatement("insert into info(id,username,password,address,contact,sdate,stime,university) values(?,?,?,?,?,?,?,?)");
					ps.setString(1, uid);
					ps.setString(2, uname);
					ps.setString(3, ureset);
					ps.setString(4, uaddress);
					ps.setString(5, ucontact);
					ps.setString(6, y);
					ps.setString(7, x);
					ps.setString(8, txtUniversity.getText());
					ps.executeUpdate();
					JFrame jf=new JFrame();
					jf.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(jf, "Successfully Registered..");
					setVisible(false);
					new loginpage().frmLibraryManagementSystem.setVisible(true);
					}
				catch(Exception e1) {
					JFrame jf=new JFrame();
					jf.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(jf, e1);
				}
				else
					{ImageIcon icon=new ImageIcon("icon20.jpeg");
				JOptionPane.showMessageDialog(null, "<html><b style=\"color: red; font-size: 10px\">Password<br>Mismatch</b></html>","show",JOptionPane.INFORMATION_MESSAGE,icon);
					}
				
			}
		});
		btnSignUp.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnSignUp.setForeground(new Color(0, 0, 255));
		btnSignUp.setBounds(198, 467, 155, 39);
		contentPane.add(btnSignUp);
		
		JLabel lblRegistrationForm = new JLabel("REGISTER");
		lblRegistrationForm.setForeground(new Color(0, 0, 0));
		lblRegistrationForm.setFont(new Font("Times New Roman", Font.BOLD, 40));
		lblRegistrationForm.setBounds(198, 20, 237, 80);
		contentPane.add(lblRegistrationForm);
		
		JLabel lblDate = new JLabel("DATE :");
		lblDate.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblDate.setBounds(617, 79, 87, 30);
		contentPane.add(lblDate);
		
		date = new JLabel("date");
		date.setForeground(new Color(255, 0, 0));
		date.setFont(new Font("Times New Roman", Font.BOLD, 25));
		date.setBounds(709, 81, 133, 26);
		contentPane.add(date);
		
		final JCheckBox chckbxShow = new JCheckBox("Show");
		chckbxShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxShow.isSelected())
					reset.setEchoChar((char)0);
				else
					reset.setEchoChar('*');
			}
		});
		
		chckbxShow.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		chckbxShow.setBounds(805, 408, 67, 21);
		contentPane.add(chckbxShow);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setBackground(new Color(0, 0, 0));
		separator.setBounds(195, 117, 677, 25);
		contentPane.add(separator);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(signup.class.getResource("/onlineexam_/icon2.png")));
		label.setBounds(0, 0, 210, 165);
		contentPane.add(label);
		
		JLabel lblrepass = new JLabel("RE-ENTER PASSWORD");
		lblrepass.setForeground(new Color(255, 255, 255));
		lblrepass.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblrepass.setBounds(335, 371, 237, 25);
		contentPane.add(lblrepass);
		
		name = new JTextField(25);
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
			if(c==KeyEvent.VK_ENTER)
		{userid.grabFocus();}
		else if(!(Character.isAlphabetic(c)||Character.isSpace(c)))
					e.consume();
			}
		});
		name.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(name.getText().equals("Enter Candidates Name"))
				{
					name.setText("");
					name.setForeground(new Color(0,0,255));
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(name.getText().equals(""))
				{
					name.setText("Enter Candidates Name");
					name.setForeground(new Color(0,0,255));
				}
			}
		});
		name.setText("Enter Candidates Name");
		name.setForeground(new Color(0, 0, 255));
		name.setFont(new Font("Times New Roman", Font.BOLD, 18));
		name.setBounds(142, 164, 630, 25);
		contentPane.add(name);
		name.setColumns(10);
		
		userid = new JTextField(25);
		userid.setHorizontalAlignment(SwingConstants.CENTER);
		userid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				if(c==KeyEvent.VK_ENTER)
			{contact.grabFocus();}
			}
		});
		userid.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(userid.getText().equals("Enter Email ID"))
				{
					userid.setText("");
					userid.setForeground(new Color(0,0,255));
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(userid.getText().equals(""))
				{
					userid.setText("Enter Email ID");
					userid.setForeground(new Color(0,0,255));
				}
			}
		});
		userid.setText("Enter Email ID");
		userid.setFont(new Font("Times New Roman", Font.BOLD, 18));
		userid.setForeground(new Color(0, 0, 255));
		userid.setBounds(142, 199, 630, 26);
		contentPane.add(userid);
		userid.setColumns(10);
		
		contact = new JTextField(25);
		contact.setHorizontalAlignment(SwingConstants.CENTER);
		contact.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				if(c==KeyEvent.VK_ENTER)
				{txtUniversity.grabFocus();}
				else if(!Character.isDigit(c))
					e.consume();
			}
		});
		contact.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(contact.getText().equals("Enter Contact Number"))
				{
					contact.setText("");
					contact.setForeground(new Color(0,0,255));
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(contact.getText().equals(""))
				{
					contact.setText("Enter Contact Number");
					contact.setForeground(new Color(0,0,255));
				}
			}
		});
		contact.setText("Enter Contact Number");
		contact.setForeground(new Color(0, 0, 255));
		contact.setFont(new Font("Times New Roman", Font.BOLD, 18));
		contact.setBounds(142, 235, 630, 24);
		contentPane.add(contact);
		contact.setColumns(10);
		
		address = new JTextField(25);
		address.setHorizontalAlignment(SwingConstants.CENTER);
		address.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				if(c==KeyEvent.VK_ENTER)
			{password.grabFocus();}
			}
		});
		address.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(address.getText().equals("Enter Address"))
				{
					address.setText("");
					address.setForeground(new Color(0,0,255));
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(address.getText().equals(""))
				{
					address.setText("Enter Address");
					address.setForeground(new Color(0, 0, 255));
				}
			}
		});
		address.setText("Enter Address");
		address.setForeground(new Color(0, 0, 255));
		address.setFont(new Font("Times New Roman", Font.BOLD, 18));
		address.setBounds(142, 304, 630, 24);
		contentPane.add(address);
		address.setColumns(10);
		
		password = new JTextField(25);
		password.setHorizontalAlignment(SwingConstants.CENTER);
		password.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				if(c==KeyEvent.VK_ENTER)
			{reset.grabFocus();}
			}
		});
		password.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(password.getText().equals("Enter Password"))
				{
					password.setText("");
					password.setForeground(new Color(178,34,34));
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(password.getText().equals(""))
				{
					password.setText("Enter Password");
					password.setForeground(new Color(178, 34, 34));
				}
			}
		});
		password.setText("Enter Password");
		password.setFont(new Font("Times New Roman", Font.BOLD, 18));
		password.setForeground(new Color(178, 34, 34));
		password.setBounds(142, 339, 630, 24);
		contentPane.add(password);
		password.setColumns(10);
		
		reset = new JPasswordField();
		reset.setHorizontalAlignment(SwingConstants.CENTER);
		reset.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				if(c==KeyEvent.VK_ENTER)
			{btnSignUp.doClick();}
			}
		});
		reset.setForeground(new Color(178, 34, 34));
		reset.setFont(new Font("Times New Roman", Font.BOLD, 18));
		reset.setBounds(142, 406, 630, 24);
		contentPane.add(reset);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(signup.class.getResource("/onlineexam_/t4.jpg")));
		label_1.setBounds(0, 0, 900, 580);
		contentPane.add(label_1);


	}

}
