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
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class scheduleexam extends JFrame {

	private JPanel contentPane;
	private JTextField texamno;
	private JTextField texamdate;
	private JTextField texambegin;
	private JTextField texamend;
	private JTextField texamname;
	private JLabel eno;
	private JTextField nq;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					scheduleexam frame = new scheduleexam();
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
	
	public scheduleexam() {
		setUndecorated(true);setAlwaysOnTop(true);
		setBounds(60, 150, 625, 620);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSchedule = new JButton("SCHEDULE");
		btnSchedule.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				int id1=0,id2=0;
				try {
					Connection con=ConnectionProvider.getconn();
					Statement st2=con.createStatement();
					ResultSet rs2=st2.executeQuery("select count(*) from question where examno='"+texamno.getText()+"'");
					if(rs2.first())
					{id2=rs2.getInt(1);}
					Statement st1=con.createStatement();
					ResultSet rs=st1.executeQuery("select count(distinct examno) from question");
					if(rs.first())
					{id1=rs.getInt(1);}
					if(Integer.parseInt(texamno.getText())>id1)
					{
						JFrame jf=new JFrame();
						jf.setAlwaysOnTop(true);
						JOptionPane.showMessageDialog(jf, "Question set not created!");
					}
					else if(Integer.parseInt(nq.getText())>id2)
					{
						JFrame jf=new JFrame();
						jf.setAlwaysOnTop(true);
						JOptionPane.showMessageDialog(jf, "You need to add more "+(Integer.parseInt(nq.getText())-id2)+" questions to create this exam..!");
					}
					else
					{
					PreparedStatement ps=con.prepareStatement("insert into examschedule values(?,?,?,?,?,?,?)");
					ps.setString(1, texamname.getText());
					ps.setString(2, texamno.getText());
					ps.setString(3, texamdate.getText());
					ps.setString(4, texambegin.getText());
					ps.setString(5, texamend.getText());
					ps.setString(6, eno.getText());
					ps.setString(7, nq.getText());
					ps.executeUpdate();
					JFrame jf=new JFrame();
					jf.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(jf, "Successfully Scheduled..");
					adminhome.open=0;
					new tableid(1);
					}
					
				}
				catch(Exception e1) {
					JFrame jf=new JFrame();
					jf.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(jf, e1);
				}
				adminhome.open=0;
				setVisible(false);
			}
		});
		
		JButton buttoncross = new JButton("");
		buttoncross.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminhome.open=0;
				setVisible(false);
				
			}
		});
		
		
		nq = new JTextField();
		nq.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 22));
		nq.setBounds(408, 257, 96, 29);
		contentPane.add(nq);
		nq.setColumns(10);
		
		JLabel lblNumberOfQuestions = new JLabel("NUMBER OF QUESTIONS");
		lblNumberOfQuestions.setForeground(new Color(255, 255, 255));
		lblNumberOfQuestions.setFont(new Font("Times New Roman", Font.BOLD, 28));
		lblNumberOfQuestions.setBounds(36, 260, 368, 26);
		contentPane.add(lblNumberOfQuestions);
		
		JLabel lblNewLabel = new JLabel("*Previous exams automatically deactivated if not examined.!");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setBounds(242, 567, 383, 29);
		contentPane.add(lblNewLabel);
		
		eno = new JLabel("");
		eno.setForeground(new Color(255, 0, 0));
		eno.setFont(new Font("Times New Roman", Font.BOLD, 30));
		eno.setBounds(315, 116, 89, 26);
		contentPane.add(eno);
		try {
			Connection con=ConnectionProvider.getconn();
			Statement st1=con.createStatement();
			ResultSet rs=st1.executeQuery("select count(examno)+1 from examschedule");
			if(rs.first())
			{eno.setText(rs.getString(1));}
			eno.setVisible(true);
			}
			catch(Exception e) {}
		
		JLabel lblExamNumbered = new JLabel("EXAM NUMBERED");
		lblExamNumbered.setForeground(new Color(255, 255, 255));
		lblExamNumbered.setFont(new Font("Times New Roman", Font.BOLD, 28));
		lblExamNumbered.setBounds(36, 116, 265, 29);
		contentPane.add(lblExamNumbered);
		buttoncross.setIcon(new ImageIcon(scheduleexam.class.getResource("/onlineexam_/icon20.jpeg")));
		buttoncross.setBounds(569, 10, 46, 47);
		contentPane.add(buttoncross);
		btnSchedule.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		btnSchedule.setForeground(new Color(128, 0, 0));
		btnSchedule.setBounds(378, 510, 237, 47);
		contentPane.add(btnSchedule);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBackground(new Color(255, 255, 255));
		separator_3.setForeground(new Color(255, 255, 255));
		separator_3.setBounds(36, 97, 558, 9);
		contentPane.add(separator_3);
		
		JLabel lblSchedule = new JLabel("SCHEDULE");
		lblSchedule.setForeground(new Color(255, 255, 255));
		lblSchedule.setFont(new Font("Times New Roman", Font.BOLD, 40));
		lblSchedule.setBounds(259, 39, 245, 47);
		contentPane.add(lblSchedule);
		
		JLabel lblExamination = new JLabel("EXAMINATION");
		lblExamination.setForeground(new Color(255, 255, 255));
		lblExamination.setFont(new Font("Times New Roman", Font.BOLD, 40));
		lblExamination.setBounds(10, 0, 310, 47);
		contentPane.add(lblExamination);
		
		texamname = new JTextField();
		texamname.setHorizontalAlignment(SwingConstants.CENTER);
		texamname.setForeground(new Color(0, 0, 255));
		texamname.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 22));
		texamname.setBounds(279, 165, 293, 29);
		contentPane.add(texamname);
		texamname.setColumns(10);
		
		JLabel lblExamName = new JLabel("EXAM NAME");
		lblExamName.setForeground(new Color(255, 255, 255));
		lblExamName.setFont(new Font("Times New Roman", Font.BOLD, 28));
		lblExamName.setBounds(36, 165, 201, 28);
		contentPane.add(lblExamName);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBackground(new Color(255, 255, 255));
		separator_2.setForeground(new Color(255, 255, 255));
		separator_2.setBounds(56, 448, 38, 2);
		contentPane.add(separator_2);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(new Color(255, 255, 255));
		separator_1.setForeground(new Color(255, 255, 255));
		separator_1.setBounds(56, 406, 38, 2);
		contentPane.add(separator_1);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(255, 255, 255));
		separator.setBackground(new Color(255, 255, 255));
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(56, 369, 12, 81);
		contentPane.add(separator);
		
		texamend = new JTextField();
		texamend.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(texamend.getText().equals("IN MINUTES"))
				{
					texamend.setText("");
					texamend.setForeground(new Color(0,0,255));
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(texamend.getText().equals(""))
				{
					texamend.setText("IN MINUTES");
					texamend.setForeground(new Color(0,0,255));				}
		
			}
		});
		texamend.setText("IN MINUTES");
		texamend.setHorizontalAlignment(SwingConstants.CENTER);
		texamend.setForeground(new Color(0, 0, 0));
		texamend.setFont(new Font("Verdana", Font.BOLD, 22));
		texamend.setBounds(278, 433, 185, 29);
		contentPane.add(texamend);
		texamend.setColumns(10);
		
		texambegin = new JTextField();
		texambegin.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(texambegin.getText().equals("hh-mm-ss  AM/PM"))
				{
					texambegin.setText("");
					texambegin.setForeground(new Color(0,0,255));
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(texambegin.getText().equals(""))
				{
					texambegin.setText("hh-mm-ss  AM/PM");
					texambegin.setForeground(new Color(0,0,255));
				}
			}
		});
		texambegin.setText("hh-mm-ss  AM/PM");
		texambegin.setHorizontalAlignment(SwingConstants.CENTER);
		texambegin.setFont(new Font("Verdana", Font.BOLD, 22));
		texambegin.setForeground(new Color(0, 0, 0));
		texambegin.setBounds(278, 390, 282, 31);
		contentPane.add(texambegin);
		texambegin.setColumns(10);
		
		JLabel lblEndsAt = new JLabel("DURATION");
		lblEndsAt.setForeground(new Color(255, 255, 255));
		lblEndsAt.setFont(new Font("Times New Roman", Font.BOLD, 28));
		lblEndsAt.setBounds(97, 433, 176, 28);
		contentPane.add(lblEndsAt);
		
		JLabel lblBeginsAt = new JLabel("BEGINS AT");
		lblBeginsAt.setForeground(new Color(255, 255, 255));
		lblBeginsAt.setFont(new Font("Times New Roman", Font.BOLD, 28));
		lblBeginsAt.setBounds(97, 390, 159, 33);
		contentPane.add(lblBeginsAt);
		
		JLabel lblExamTime = new JLabel("EXAM TIME");
		lblExamTime.setForeground(new Color(255, 255, 255));
		lblExamTime.setFont(new Font("Times New Roman", Font.BOLD, 28));
		lblExamTime.setBounds(36, 339, 190, 31);
		contentPane.add(lblExamTime);
		
		texamdate = new JTextField();
		texamdate.setHorizontalAlignment(SwingConstants.CENTER);
		texamdate.setForeground(new Color(0, 0, 205));
		texamdate.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 22));
		texamdate.setBounds(279, 296, 293, 31);
		contentPane.add(texamdate);
		texamdate.setColumns(10);
		
		JLabel lblExamDate = new JLabel("EXAM DATE");
		lblExamDate.setForeground(new Color(255, 255, 255));
		lblExamDate.setFont(new Font("Times New Roman", Font.BOLD, 28));
		lblExamDate.setBounds(36, 296, 237, 33);
		contentPane.add(lblExamDate);
		
		texamno = new JTextField();
		texamno.setHorizontalAlignment(SwingConstants.CENTER);
		texamno.setForeground(new Color(0, 0, 205));
		texamno.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 22));
		texamno.setBounds(278, 210, 126, 33);
		contentPane.add(texamno);
		texamno.setColumns(10);
		
		JLabel lblExamNumber = new JLabel("QUESTION SET");
		lblExamNumber.setForeground(new Color(255, 255, 255));
		lblExamNumber.setFont(new Font("Times New Roman", Font.BOLD, 28));
		lblExamNumber.setBounds(36, 213, 237, 28);
		contentPane.add(lblExamNumber);
		
		JLabel label = new JLabel("");
		label.setVerticalAlignment(SwingConstants.BOTTOM);
		label.setForeground(new Color(255, 255, 255));
		label.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 20));
		label.setIcon(new ImageIcon(scheduleexam.class.getResource("/onlineexam_/t2.jpg")));
		label.setBounds(0, 0, 626, 620);
		contentPane.add(label);
	}
}
