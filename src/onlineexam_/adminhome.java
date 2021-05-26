package onlineexam_;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import project.ConnectionProvider;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class adminhome extends JFrame {

	private JPanel contentPane;
	private JTextField txtTapasSahu;
	private JTextField txtNull_1;
	private JTextField txtNull_2;
	public static adminhome frame;
	public static int open=0;
	private JTextField textField;
    static JTable table;
    private JLabel label_2,label_3;
	private String x1,y1,z1,z2,x2,x,y;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new adminhome();
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
	new tableid(1);
	try {
		Connection con=ConnectionProvider.getconn();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from info where desig !='Employee'");
		if(rs.first())
		{
			txtTapasSahu.setText(rs.getString(2));
			textField.setText(rs.getString(1));
			txtNull_1.setText(rs.getString(3));
			txtNull_2.setText(rs.getString(4));
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
		SimpleDateFormat df=new SimpleDateFormat("dd-MM-yyyy");
			Date date1=new Date();
			y=df.format(date1);
			label_3.setText(y);
			Thread t=new Thread() {
				public void run()
				{	while(true)
					{
						DateFormat date=new SimpleDateFormat("hh-mm-ss aa");
						x=date.format(new Date());
						label_2.setText(x);
							}
				}
			};
			t.start();
			}catch(Exception e) {}
}
	public adminhome() {
		
		setUndecorated(true);
		setAlwaysOnTop(false);
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(adminhome.class.getResource("/onlineexam_/icon3.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnScheduleExams = new JButton("SCHEDULE EXAMS");
		btnScheduleExams.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(open==0)
				{
				new scheduleexam().setVisible(true);
				open=1;
				}
				else
				{
					JFrame jf=new JFrame();
					jf.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(jf, "one process running...");
				}	
			}
		});
		
		JLabel lblExamNo = new JLabel("EXAM NO.");
		lblExamNo.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblExamNo.setBounds(718, 492, 93, 22);
		contentPane.add(lblExamNo);
		
		label_3 = new JLabel("");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 21));
		label_3.setBounds(1107, 186, 158, 23);
		contentPane.add(label_3);
		
		label_2 = new JLabel("");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 21));
		label_2.setBounds(1107, 151, 158, 23);
		contentPane.add(label_2);
		
		JLabel lblDate_1 = new JLabel("DATE");
		lblDate_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblDate_1.setBounds(1031, 184, 65, 26);
		contentPane.add(lblDate_1);
		
		JLabel time = new JLabel("TIME");
		time.setFont(new Font("Times New Roman", Font.BOLD, 22));
		time.setBounds(1031, 148, 75, 26);
		contentPane.add(time);
		
		JLabel lblEndsBy = new JLabel("DURATION(mins)");
		lblEndsBy.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblEndsBy.setBounds(1261, 492, 139, 26);
		contentPane.add(lblEndsBy);
		
		JLabel lblBeginsBy = new JLabel("BEGINS BY");
		lblBeginsBy.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblBeginsBy.setBounds(1149, 492, 102, 26);
		contentPane.add(lblBeginsBy);
		
		JLabel lblDate = new JLabel("DATE");
		lblDate.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblDate.setBounds(1062, 493, 54, 25);
		contentPane.add(lblDate);
		
		JLabel lblNewLabel = new JLabel("EXAM SET");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel.setBounds(948, 493, 87, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblExamName = new JLabel("EXAM NAME");
		lblExamName.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblExamName.setBounds(821, 493, 117, 25);
		contentPane.add(lblExamName);
		
		table = new JTable();
		table.setBackground(new Color(255, 255, 255));
		table.setFont(new Font("Times New Roman", Font.BOLD, 17));
		table.setBounds(715, 528, 685, 246);
		contentPane.add(table);
		btnScheduleExams.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnScheduleExams.setForeground(new Color(0, 0, 255));
		btnScheduleExams.setBounds(1097, 442, 303, 40);
		contentPane.add(btnScheduleExams);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 22));
		textField.setBounds(41, 389, 483, 36);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblUserId = new JLabel("USER ID");
		lblUserId.setForeground(Color.WHITE);
		lblUserId.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblUserId.setBounds(41, 352, 158, 25);
		contentPane.add(lblUserId);
		
		final JButton btnSave = new JButton("SAVE");
		contentPane.add(btnSave);
		btnSave.setVisible(false);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				String username=txtTapasSahu.getText();
				String desig=txtNull_1.getText();
				String university=txtNull_2.getText();
				try {
					Connection con=ConnectionProvider.getconn();
					PreparedStatement ps=con.prepareStatement("update info set username=?,desig=?,university=? where id='"+textField.getText()+"'");
					ps.setString(1, username);
					ps.setString(2, desig);
					ps.setString(3, university);
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
				textField.setEditable(false);
				txtNull_1.setEditable(false);
				txtNull_2.setEditable(false);
				txtTapasSahu.setEditable(false);
				btnSave.setVisible(false);
			}
		});
		btnSave.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 27));
		btnSave.setForeground(new Color(0, 128, 0));
		btnSave.setBounds(91, 747, 108, 40);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(0, 0, 0));
		separator_1.setBackground(new Color(0, 0, 0));
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(569, 197, 10, 645);
		contentPane.add(separator_1);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 0, 0));
		separator.setForeground(new Color(0, 0, 0));
		separator.setBounds(309, 140, 1008, 15);
		contentPane.add(separator);
		
		JLabel lblaccountsecuredtss = new JLabel("@Account_secured_TSS");
		lblaccountsecuredtss.setForeground(Color.RED);
		lblaccountsecuredtss.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblaccountsecuredtss.setBounds(1264, 10, 185, 25);
		contentPane.add(lblaccountsecuredtss);
		
		JLabel lblWelcome = new JLabel("WELCOME");
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setFont(new Font("Times New Roman", Font.BOLD, 99));
		lblWelcome.setBounds(486, 41, 556, 74);
		contentPane.add(lblWelcome);
		
		JButton btnEditProfile = new JButton("EDIT PROFILE");
		btnEditProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(open==0)
				{
				btnSave.setVisible(true);
				txtNull_1.setEditable(true);
				txtNull_2.setEditable(true);
				txtTapasSahu.setEditable(true);
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
		btnEditProfile.setBounds(275, 747, 238, 40);
		contentPane.add(btnEditProfile);
		
		txtNull_2 = new JTextField();
		txtNull_2.setForeground(new Color(0, 0, 0));
		txtNull_2.setEditable(false);
		txtNull_2.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 20));
		txtNull_2.setBounds(41, 592, 483, 40);
		contentPane.add(txtNull_2);
		txtNull_2.setColumns(10);
		
		JLabel lblUniversity = new JLabel("UNIVERSITY");
		lblUniversity.setForeground(Color.WHITE);
		lblUniversity.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblUniversity.setBounds(41, 550, 292, 32);
		contentPane.add(lblUniversity);
		
		txtNull_1 = new JTextField();
		txtNull_1.setForeground(new Color(0, 0, 0));
		txtNull_1.setEditable(false);
		txtNull_1.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 20));
		txtNull_1.setBounds(41, 489, 483, 40);
		contentPane.add(txtNull_1);
		txtNull_1.setColumns(10);
		
		JLabel lblDesignation = new JLabel("DESIGNATION");
		lblDesignation.setForeground(Color.WHITE);
		lblDesignation.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblDesignation.setBounds(41, 447, 292, 32);
		contentPane.add(lblDesignation);
		
		txtTapasSahu = new JTextField();
		txtTapasSahu.setEditable(false);
		txtTapasSahu.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 22));
		txtTapasSahu.setForeground(new Color(0, 0, 0));
		txtTapasSahu.setBounds(41, 302, 483, 40);
		contentPane.add(txtTapasSahu);
		txtTapasSahu.setColumns(10);
		
		JLabel lblUsername = new JLabel("USERNAME");
		lblUsername.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setBounds(41, 265, 185, 33);
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
					new loginpage().frmLibraryManagementSystem.setVisible(true);
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
		btnExit.setBounds(1459, 10, 62, 56);
		contentPane.add(btnExit);
		
		JButton btnResult = new JButton("         RESULT");
		btnResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(open==0)
				{
					new allres().setVisible(true);;
					open=1;
				}
				else
				{
					JFrame jf=new JFrame();
					jf.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(jf, "One Form is already opened...");
				}
					
			}
		});
		btnResult.setIcon(new ImageIcon(adminhome.class.getResource("/onlineexam_/icon16.jpeg")));
		btnResult.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		btnResult.setForeground(new Color(0, 0, 255));
		btnResult.setBounds(1097, 363, 303, 48);
		contentPane.add(btnResult);
		
		JButton btnViewQuestion = new JButton("    VIEW QUESTION");
		btnViewQuestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(open==0)
				{
					new allquestion().setVisible(true);
					open=1;
				}
				else
				{
					JFrame jf=new JFrame();
					jf.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(jf, "One Form is already opened...");
				}
			}
		});
		btnViewQuestion.setIcon(new ImageIcon(adminhome.class.getResource("/onlineexam_/icon15.jpeg")));
		btnViewQuestion.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnViewQuestion.setForeground(new Color(0, 0, 255));
		btnViewQuestion.setBounds(1097, 294, 303, 47);
		contentPane.add(btnViewQuestion);
		
		JButton btnUpdateQuestion = new JButton("UPDATE QUESTION");
		btnUpdateQuestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(open==0)
				{
					updatequestion q=new updatequestion();
					q.setUndecorated(true);
					q.setVisible(true);
					open=1;
				}
				else
				{
					JFrame jf=new JFrame();
					jf.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(jf, "One Form is already opened...");
				}
			}
		});
		btnUpdateQuestion.setForeground(new Color(0, 0, 255));
		btnUpdateQuestion.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnUpdateQuestion.setIcon(new ImageIcon(adminhome.class.getResource("/onlineexam_/icon28.jpeg")));
		btnUpdateQuestion.setBounds(612, 441, 303, 46);
		contentPane.add(btnUpdateQuestion);
		
		JButton btnDeleteQuestion = new JButton("DELETE QUESTION");
		btnDeleteQuestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(open==0)
				{
					new deletequestion().setVisible(true);
					open=1;
				}
				else
				{
					JFrame jf=new JFrame();
					jf.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(jf, "One Form is already opened...");
				}
		
			}
		});
		btnDeleteQuestion.setIcon(new ImageIcon(adminhome.class.getResource("/onlineexam_/icon19.jpeg")));
		btnDeleteQuestion.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnDeleteQuestion.setForeground(new Color(0, 0, 255));
		btnDeleteQuestion.setBounds(612, 363, 303, 48);
		contentPane.add(btnDeleteQuestion);
		
		JButton btnAddNewQuestion = new JButton(" ADD QUESTION");
		btnAddNewQuestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(open==0)
				{
					addquestion q=new addquestion();
					q.setUndecorated(true);
					q.setVisible(true);
					open=1;
				}
				else
				{
					JFrame jf=new JFrame();
					jf.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(jf, "One Form is already opened...");
				}
			}
		});
		btnAddNewQuestion.setIcon(new ImageIcon(adminhome.class.getResource("/onlineexam_/icon14.jpeg")));
		btnAddNewQuestion.setForeground(new Color(0, 0, 255));
		btnAddNewQuestion.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnAddNewQuestion.setBounds(612, 293, 303, 48);
		contentPane.add(btnAddNewQuestion);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(adminhome.class.getResource("/onlineexam_/icon13.png")));
		label_1.setBounds(41, 41, 200, 200);
		contentPane.add(label_1);
		
		JLabel label = new JLabel("");
		label.setVerticalAlignment(SwingConstants.TOP);
		label.setIcon(new ImageIcon(adminhome.class.getResource("/onlineexam_/t4.jpg")));
		label.setBounds(0, 0, 1920, 1080);
		contentPane.add(label);
		initial();
	}
}
