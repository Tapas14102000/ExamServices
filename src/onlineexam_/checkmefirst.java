package onlineexam_;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import project.ConnectionProvider;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.border.CompoundBorder;

public class checkmefirst extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField mail;
	private JTextField contact;
	private JTextField address;
	private JTextField university;
	private JTextField password;
	private JPasswordField reset;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					checkmefirst frame = new checkmefirst();
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
	public checkmefirst() {
		setUndecorated(true);
		setAlwaysOnTop(false);
		setBounds(80, 20, 900, 580);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(255, 255, 255));
		separator_1.setBackground(new Color(255, 255, 255));
		separator_1.setBounds(244, 134, 457, 4);
		contentPane.add(separator_1);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(255, 255, 255));
		separator.setForeground(new Color(255, 255, 255));
		separator.setBounds(210, 122, 449, 2);
		contentPane.add(separator);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(checkmefirst.class.getResource("/onlineexam_/icon13.png")));
		label.setBounds(0, 0, 200, 188);
		contentPane.add(label);
		
		JLabel lblHelloAdmin = new JLabel("HELLO ADMIN!");
		lblHelloAdmin.setForeground(new Color(255, 255, 255));
		lblHelloAdmin.setFont(new Font("Times New Roman", Font.BOLD, 50));
		lblHelloAdmin.setBounds(210, 48, 408, 90);
		contentPane.add(lblHelloAdmin);
		
		JLabel lblTime = new JLabel("TIME");
		lblTime.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblTime.setBounds(628, 0, 73, 30);
		contentPane.add(lblTime);
		
		final JLabel time = new JLabel("");
		time.setForeground(new Color(220, 20, 60));
		time.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		time.setBounds(717, 0, 162, 26);
		contentPane.add(time);
		
		JLabel lblDate = new JLabel("DATE");
		lblDate.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblDate.setBounds(628, 40, 73, 28);
		contentPane.add(lblDate);
		
		JLabel dates = new JLabel("");
		dates.setForeground(new Color(220, 20, 60));
		dates.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		dates.setBounds(717, 36, 162, 29);
		contentPane.add(dates);
		
		JPanel panel = new JPanel();
		panel.setBorder(new CompoundBorder());
		panel.setForeground(Color.WHITE);
		panel.setBackground(new Color(222, 184, 135));
		panel.setBounds(10, 194, 880, 376);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblYourNameSir = new JLabel("NAME");
		lblYourNameSir.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblYourNameSir.setBounds(10, 10, 211, 23);
		panel.add(lblYourNameSir);
		
		JLabel lblYourEmailId = new JLabel("EMAIL-ID");
		lblYourEmailId.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblYourEmailId.setBounds(10, 43, 181, 23);
		panel.add(lblYourEmailId);
		
		JLabel lblYourContact = new JLabel("CONTACT");
		lblYourContact.setVerticalAlignment(SwingConstants.BOTTOM);
		lblYourContact.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblYourContact.setBounds(10, 76, 156, 28);
		panel.add(lblYourContact);
		
		JLabel lblYourAddress = new JLabel("ADDRESS");
		lblYourAddress.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblYourAddress.setBounds(10, 123, 156, 23);
		panel.add(lblYourAddress);
		
		JLabel lblPassword = new JLabel("PASSWORD ");
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblPassword.setBounds(10, 210, 164, 23);
		panel.add(lblPassword);
		
		JLabel lblReenterPassword = new JLabel("RE-ENTER PASSWORD");
		lblReenterPassword.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblReenterPassword.setBounds(10, 243, 249, 24);
		panel.add(lblReenterPassword);
		
		JLabel lblUniversity = new JLabel("UNIVERSITY");
		lblUniversity.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblUniversity.setBounds(10, 166, 181, 23);
		panel.add(lblUniversity);
		
		name = new JTextField();
		name.setForeground(new Color(153, 50, 204));
		name.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		name.setBounds(262, 10, 582, 23);
		panel.add(name);
		name.setColumns(10);
		
		mail = new JTextField();
		mail.setForeground(new Color(153, 50, 204));
		mail.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		mail.setBounds(262, 43, 582, 24);
		panel.add(mail);
		mail.setColumns(10);
		
		contact = new JTextField();
		contact.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		contact.setForeground(new Color(153, 50, 204));
		contact.setBounds(262, 81, 582, 23);
		panel.add(contact);
		contact.setColumns(10);
		
		address = new JTextField();
		address.setForeground(new Color(153, 50, 204));
		address.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		address.setBounds(262, 123, 582, 23);
		panel.add(address);
		address.setColumns(10);
		
		university = new JTextField();
		university.setForeground(new Color(153, 50, 204));
		university.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		university.setBounds(262, 166, 582, 23);
		panel.add(university);
		university.setColumns(10);
		
		password = new JTextField();
		password.setForeground(new Color(153, 50, 204));
		password.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		password.setBounds(262, 210, 392, 23);
		panel.add(password);
		password.setColumns(10);
		
		reset = new JPasswordField();
		reset.setForeground(new Color(220, 20, 60));
		reset.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		reset.setBounds(262, 243, 392, 24);
		panel.add(reset);
		
		final JCheckBox chckbxShow = new JCheckBox("SHOW");
		chckbxShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxShow.isSelected())
					reset.setEchoChar((char)0);
				else
					reset.setEchoChar('*');
			}
		});
		chckbxShow.setFont(new Font("Times New Roman", Font.BOLD, 17));
		chckbxShow.setBounds(689, 246, 95, 21);
		panel.add(chckbxShow);
		
		JButton btnReadyToEnjoy = new JButton("Get Started!");
		btnReadyToEnjoy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String uid=mail.getText();
				String uname=name.getText();
				String uaddress=address.getText();
				String ucontact=contact.getText();
				String ureset=reset.getText();
				String pass=password.getText();
				if(uid.equals("")||uname.equals("")||uaddress.equals("")||ucontact.equals("")||pass.equals(""))
				{
					ImageIcon icon=new ImageIcon("icon20.jpeg");
					JOptionPane.showMessageDialog(null, "<html><b style=\"color: red; font-size: 10px\"><br>Complete the form</b></html>","show",JOptionPane.INFORMATION_MESSAGE,icon);
				}
				else if(pass.equals(ureset))
					try {
					Connection con=ConnectionProvider.getconn();
					PreparedStatement ps=con.prepareStatement("insert into info(id,username,password,address,contact,university,desig) values(?,?,?,?,?,?,'DEVELOPER')");
					ps.setString(1, uid);
					ps.setString(2, uname);
					ps.setString(3, ureset);
					ps.setString(4, uaddress);
					ps.setString(5, ucontact);
					ps.setString(6, university.getText());
					ps.executeUpdate();
					JFrame jf=new JFrame();
					jf.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(jf, "WELCOME "+uname+" ,here u begin a chapter with us...");
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
		btnReadyToEnjoy.setBackground(new Color(128, 128, 128));
		btnReadyToEnjoy.setForeground(new Color(0, 0, 0));
		btnReadyToEnjoy.setFont(new Font("Times New Roman", Font.BOLD, 30));
		btnReadyToEnjoy.setBounds(278, 307, 308, 34);
		panel.add(btnReadyToEnjoy);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(checkmefirst.class.getResource("/onlineexam_/t4.jpg")));
		label_2.setBounds(0, 0, 900, 580);
		contentPane.add(label_2);
		Thread t=new Thread() {
			public void run()
			{
				while(true)
				{
					DateFormat date=new SimpleDateFormat("hh-mm-ss aa");
					time.setText(date.format(new Date()));
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
		dates.setText(df.format(date1));
		
	}
}
