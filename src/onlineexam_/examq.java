package onlineexam_;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import project.ConnectionProvider;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JSeparator;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class examq extends JFrame {

	private JPanel contentPane;
	public static JLabel date,que1,qid,qleft,label_2,label_3,label_4,secure,exname,time,min,sec;
	private static JRadioButton opt1,opt2,opt3,opt4;
	public static int count =2,attempt=0,wrong=0,right=0,score=0,dur,mint,sect=0;
	private static ButtonGroup b;
	public static String noq;
	private static JButton btnSubmit;
javax.swing.Timer t;
static String joker=null,joker1=null;  //joker=qset,joker1=examno

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					examq frame = new examq();
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
	public static void answer_check(String qid)
	{
		int i=0;
		String ans=null;
		if(opt1.isSelected())
			i=1;
		else if(opt2.isSelected())
			i=2;
		else if(opt3.isSelected())
			i=3;
		else if(opt4.isSelected())
			i=4;
		try {
			Connection con=ConnectionProvider.getconn();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from question where examno='"+joker+"' and id='"+qid+"'");
			if(rs.first())
			{
				ans=rs.getString(7);
			}
			}
		catch(Exception e) {}
		switch(i)
		{
		case 1:
			if(opt1.getText().equals(ans))
			{
				right++;
				score+=2;
			}
			else
				wrong++;
			break;
		case 2:
			if(opt2.getText().equals(ans))
			{
				right++;
				score+=2;
			}
			else
				wrong++;
			break;
		case 3:
			if(opt3.getText().equals(ans))
			{
				right++;
				score+=2;
			}
			else
				wrong++;
			break;
		case 4:
			if(opt4.getText().equals(ans))
			{
				right++;
				score+=2;
			}
			else
				wrong++;
		}
		attempt=right+wrong;
		label_2.setText(String.valueOf(attempt));
		label_3.setText(String.valueOf(right));
		label_4.setText(String.valueOf(wrong));
		secure.setText(String.valueOf(score));
	}
	public void q1set()
	{System.out.println("q1set");
		try {
			Connection con=ConnectionProvider.getconn();
			Statement st=con.createStatement();
			ResultSet rs5=st.executeQuery("select count(distinct examno) from examschedule");
			if(rs5.first())
			{

				joker1=rs5.getString(1);
			}
			ResultSet rs15=st.executeQuery("select qset from examschedule where examno="+joker1);
			if(rs15.first())
			{

				joker=rs15.getString(1);
			}
			ResultSet rs=st.executeQuery("select * from question where examno='"+joker+"' and id='1'");
			if(rs.first())
			{
				qid.setText(rs.getString(1));
				que1.setText(rs.getString(2));
				opt1.setText(rs.getString(3));
				opt2.setText(rs.getString(4));
				opt3.setText(rs.getString(5));
				opt4.setText(rs.getString(6));
			}
			ResultSet rs1=st.executeQuery("select * from examschedule where examno='"+joker1+"'");
			if(rs1.first())
			{
				dur=Integer.valueOf(rs1.getString(5));
				noq=rs1.getString(7);
				exname.setText(rs1.getString(1));
				qleft.setText(String.valueOf((Integer.parseInt(rs1.getString(7))-1)));
			}
			mint=dur;
		}
		catch(Exception e1) {
			e1.printStackTrace();
			JFrame jf=new JFrame();
			jf.setAlwaysOnTop(true);
			JOptionPane.showMessageDialog(jf, e1);
		}
	
	}

	public examq()
	{
		System.out.println("examq");
		initial();
		time();
		setLocationRelativeTo(this);
		 t=new javax.swing.Timer(1000,new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				sec.setText(String.valueOf(sect));
				min.setText(String.valueOf(mint));
				if(sect==0)
				{
					if(mint==0&&sect==0)
						{t.stop(); answer_check(qid.getText());setVisible(false);new sub().setVisible(true);}
					sect=59;
					mint--;
				}
			sect--;
			}
		});
		t.start();
	}
	public void time()
	{
		try {	
			SimpleDateFormat df=new SimpleDateFormat("dd-MM-yyyy");
				Date date1=new Date();
				date.setText(df.format(date1));
				Thread t=new Thread() {
					public void run()
					{	while(true)
						{
							DateFormat date=new SimpleDateFormat("hh-mm-ss aa");
							time.setText(date.format(new Date()));
							try {
								Thread.sleep(1);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
								}
					}
				};
				t.start();
				}catch(Exception e) {}

	}
	public void initial() {
		setUndecorated(true);
		setAlwaysOnTop(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(60, 40, 1400, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnSubmit = new JButton("SUBMIT");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a=JOptionPane.showConfirmDialog(null,"Do you really want to Submit?","select",JOptionPane.YES_NO_OPTION);
				if(a==0)
				{	t.stop();
					answer_check(qid.getText());
					setVisible(false);
					new sub().setVisible(true);
				}

			}
		});
		btnSubmit.setBackground(new Color(152, 251, 152));
		btnSubmit.setForeground(new Color(46, 139, 87));
		btnSubmit.setFont(new Font("Times New Roman", Font.BOLD, 30));
		btnSubmit.setBounds(1077, 675, 207, 39);
		contentPane.add(btnSubmit);
		
		final JButton bnext = new JButton("NEXT");
		bnext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				answer_check(qid.getText());
				if(Integer.parseInt(qleft.getText())==1)
					bnext.setVisible(false);
					try {
						Connection con=ConnectionProvider.getconn();
						Statement st=con.createStatement();
						ResultSet rs=st.executeQuery("select * from question where examno='"+joker+"' and id='"+(Integer.valueOf(qid.getText())+1)+"'");
						if(rs.first())
						{
							qid.setText(rs.getString(1));
							que1.setText(rs.getString(2));
							opt1.setText(rs.getString(3));
							opt2.setText(rs.getString(4));
							opt3.setText(rs.getString(5));
							opt4.setText(rs.getString(6));
						}
						
					}
					catch(Exception e1) {}
				qleft.setText(String.valueOf((Integer.parseInt(qleft.getText())-1)));
				b.clearSelection();
			}
		});
		bnext.setForeground(new Color(46, 139, 87));
		bnext.setBackground(new Color(152, 251, 152));
		bnext.setFont(new Font("Times New Roman", Font.BOLD, 30));
		bnext.setBounds(679, 675, 207, 39);
		contentPane.add(bnext);
		
		opt4 = new JRadioButton("OPTION 4");
		opt4.setFont(new Font("Times New Roman", Font.BOLD, 26));
		opt4.setBackground(new Color(238, 232, 170));
		opt4.setForeground(new Color(106, 90, 205));
		opt4.setBounds(558, 563, 804, 39);
		contentPane.add(opt4);
		
		opt3 = new JRadioButton("OPTION 3");
		opt3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 26));
		opt3.setForeground(new Color(106, 90, 205));
		opt3.setBackground(new Color(238, 232, 170));
		opt3.setBounds(558, 486, 804, 39);
		contentPane.add(opt3);
		
		opt2 = new JRadioButton("OPTION 2 ");
		opt2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 26));
		opt2.setBackground(new Color(238, 232, 170));
		opt2.setForeground(new Color(106, 90, 205));
		opt2.setBounds(558, 409, 804, 39);
		contentPane.add(opt2);
		
		opt1 = new JRadioButton("OPTION 1");
		opt1.setBackground(new Color(238, 232, 170));
		opt1.setForeground(new Color(106, 90, 205));
		opt1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 26));
		opt1.setBounds(558, 331, 804, 39);
		contentPane.add(opt1);
		
		que1 = new JLabel("QUESTION");
		que1.setForeground(new Color(186, 85, 211));
		que1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 26));
		que1.setBounds(454, 256, 936, 35);
		contentPane.add(que1);
		
		qid = new JLabel("1");
		qid.setFont(new Font("Times New Roman", Font.BOLD, 35));
		qid.setForeground(new Color(244, 164, 96));
		qid.setBounds(622, 205, 46, 26);
		contentPane.add(qid);
		
		JLabel lblQuestionNumber = new JLabel("QUESTION");
		lblQuestionNumber.setForeground(new Color(222, 184, 135));
		lblQuestionNumber.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblQuestionNumber.setBounds(456, 206, 145, 30);
		contentPane.add(lblQuestionNumber);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(95, 158, 160));
		panel_1.setBounds(0, 194, 444, 535);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setBackground(new Color(0, 0, 0));
		lblName.setVerticalAlignment(SwingConstants.BOTTOM);
		lblName.setForeground(new Color(0, 0, 0));
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblName.setBounds(10, 10, 101, 35);
		panel_1.add(lblName);
		
		JLabel lname = new JLabel("TAPAS SAHU");
		lname.setForeground(new Color(255, 255, 255));
		lname.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		lname.setBounds(10, 55, 424, 35);
		panel_1.add(lname);
		lname.setText(studentpage.lname.getText());
		
		JLabel lblUserId = new JLabel("USER ID");
		lblUserId.setBackground(new Color(0, 0, 0));
		lblUserId.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblUserId.setBounds(10, 100, 151, 28);
		panel_1.add(lblUserId);
		
		JLabel lid = new JLabel("tapassahu853@gmail.com");
		lid.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		lid.setForeground(new Color(255, 255, 255));
		lid.setBackground(new Color(255, 255, 255));
		lid.setBounds(10, 127, 424, 40);
		panel_1.add(lid);
		lid.setText(studentpage.lid.getText());
		
		JLabel lblExamNumber = new JLabel("EXAM NUMBER");
		lblExamNumber.setBackground(new Color(0, 0, 0));
		lblExamNumber.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblExamNumber.setBounds(10, 188, 240, 35);
		panel_1.add(lblExamNumber);
		
		JLabel label_1 = new JLabel("1");
		label_1.setForeground(new Color(255, 255, 255));
		label_1.setFont(new Font("Times New Roman", Font.BOLD, 30));
		label_1.setBounds(284, 188, 67, 35);
		panel_1.add(label_1);
		label_1.setText(String.valueOf(studentpage.j));
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 0, 0));
		separator.setForeground(new Color(0, 0, 0));
		separator.setBounds(0, 230, 434, 1);
		panel_1.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(0, 0, 0));
		separator_1.setBackground(new Color(0, 0, 0));
		separator_1.setBounds(0, 177, 434, 1);
		panel_1.add(separator_1);
		
		JLabel lblNewLabel = new JLabel("ATTEMPTED");
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBounds(10, 297, 164, 28);
		panel_1.add(lblNewLabel);
		
		label_2 = new JLabel("0");
		label_2.setForeground(new Color(0, 0, 255));
		label_2.setFont(new Font("Times New Roman", Font.BOLD, 28));
		label_2.setBounds(329, 298, 51, 24);
		panel_1.add(label_2);
		
		JLabel lblResultLiveSummary = new JLabel("RESULT LIVE SUMMARY");
		lblResultLiveSummary.setForeground(new Color(220, 20, 60));
		lblResultLiveSummary.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblResultLiveSummary.setBounds(10, 233, 374, 32);
		panel_1.add(lblResultLiveSummary);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBackground(new Color(0, 0, 0));
		separator_2.setBounds(10, 263, 374, 2);
		panel_1.add(separator_2);
		
		JLabel lblCorrectAttempts = new JLabel("CORRECT ATTEMPTS");
		lblCorrectAttempts.setBackground(new Color(0, 0, 0));
		lblCorrectAttempts.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblCorrectAttempts.setBounds(10, 335, 281, 30);
		panel_1.add(lblCorrectAttempts);
		
		JLabel lblNewLabel_1 = new JLabel("INCORRECT ATTEMPTS");
		lblNewLabel_1.setBackground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_1.setBounds(10, 375, 309, 37);
		panel_1.add(lblNewLabel_1);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBackground(new Color(0, 0, 0));
		separator_3.setForeground(new Color(0, 0, 0));
		separator_3.setOrientation(SwingConstants.VERTICAL);
		separator_3.setBounds(317, 281, 2, 160);
		panel_1.add(separator_3);
		
		label_3 = new JLabel("0");
		label_3.setForeground(new Color(0, 255, 127));
		label_3.setFont(new Font("Times New Roman", Font.BOLD, 28));
		label_3.setBounds(329, 332, 46, 29);
		panel_1.add(label_3);
		
		label_4 = new JLabel("0");
		label_4.setForeground(new Color(255, 0, 0));
		label_4.setFont(new Font("Times New Roman", Font.BOLD, 28));
		label_4.setBounds(329, 375, 46, 29);
		panel_1.add(label_4);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBackground(new Color(0, 0, 0));
		separator_4.setForeground(new Color(0, 0, 0));
		separator_4.setBounds(10, 439, 370, 2);
		panel_1.add(separator_4);
		
		JLabel lblMarksSecured = new JLabel("MARKS SECURED  ");
		lblMarksSecured.setFont(new Font("Times New Roman", Font.BOLD, 28));
		lblMarksSecured.setBounds(10, 451, 295, 27);
		panel_1.add(lblMarksSecured);
		
		secure = new JLabel("0");
		secure.setForeground(new Color(255, 255, 0));
		secure.setFont(new Font("Times New Roman", Font.BOLD, 28));
		secure.setBounds(329, 447, 46, 35);
		panel_1.add(secure);
		
		JLabel lblauthorisedbyts = new JLabel("@Authorisedby_T_S_");
		lblauthorisedbyts.setFont(new Font("Verdana", Font.ITALIC, 17));
		lblauthorisedbyts.setForeground(new Color(0, 0, 0));
		lblauthorisedbyts.setBounds(185, 500, 195, 22);
		panel_1.add(lblauthorisedbyts);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(95, 158, 160));
		panel.setBounds(0, 0, 1400, 168);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon(examq.class.getResource("/onlineexam_/icon2.png")));
		label_5.setBounds(0, 0, 207, 168);
		panel.add(label_5);
		
		JLabel lblallTheBest = new JLabel("#ALL THE BEST");
		lblallTheBest.setToolTipText("");
		lblallTheBest.setFont(new Font("Times New Roman", Font.BOLD, 50));
		lblallTheBest.setBounds(231, 10, 396, 102);
		panel.add(lblallTheBest);
		
		JLabel lblDate = new JLabel("DATE");
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDate.setBounds(1087, 10, 74, 30);
		panel.add(lblDate);
		
		JLabel lblTime = new JLabel("TIME");
		lblTime.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTime.setBounds(1087, 50, 74, 25);
		panel.add(lblTime);
		
		JLabel lblTimeLeftOut = new JLabel("TIME LEFT");
		lblTimeLeftOut.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTimeLeftOut.setBounds(1087, 87, 114, 27);
		panel.add(lblTimeLeftOut);
		
		date = new JLabel("date");
		date.setForeground(new Color(255, 255, 255));
		date.setFont(new Font("Times New Roman", Font.BOLD, 23));
		date.setBounds(1224, 10, 166, 26);
		panel.add(date);
		
		time = new JLabel("time");
		time.setForeground(new Color(255, 255, 255));
		time.setFont(new Font("Times New Roman", Font.BOLD, 23));
		time.setBounds(1222, 49, 157, 26);
		panel.add(time);
		
		min = new JLabel("00");
		min.setForeground(new Color(255, 0, 0));
		min.setFont(new Font("Times New Roman", Font.BOLD, 23));
		min.setBounds(1224, 88, 29, 24);
		panel.add(min);
		
		JLabel label_6 = new JLabel(" :");
		label_6.setFont(new Font("Tahoma", Font.BOLD, 22));
		label_6.setBounds(1250, 85, 14, 24);
		panel.add(label_6);
		
		sec = new JLabel("00");
		sec.setFont(new Font("Times New Roman", Font.BOLD, 22));
		sec.setForeground(new Color(255, 0, 0));
		sec.setBounds(1274, 88, 29, 24);
		panel.add(sec);
		
		JLabel lblQuestionsLeft = new JLabel("QUESTIONS LEFT");
		lblQuestionsLeft.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblQuestionsLeft.setBounds(1024, 124, 177, 34);
		panel.add(lblQuestionsLeft);
		
		qleft = new JLabel("");
		qleft.setForeground(new Color(255, 0, 0));
		qleft.setFont(new Font("Times New Roman", Font.BOLD, 23));
		qleft.setBounds(1224, 122, 46, 30);
		panel.add(qleft);
		
		JLabel lblExam = new JLabel("EXAM  :");
		lblExam.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblExam.setBounds(393, 122, 124, 36);
		panel.add(lblExam);
		
		exname = new JLabel("ename");
		exname.setForeground(new Color(0, 0, 128));
		exname.setFont(new Font("Times New Roman", Font.BOLD, 45));
		exname.setBounds(527, 116, 365, 46);
		panel.add(exname);
		
		JLabel label = new JLabel("");
		label.setVerticalAlignment(SwingConstants.BOTTOM);
		label.setIcon(new ImageIcon(examq.class.getResource("/onlineexam_/img20.jpg")));
		label.setBounds(0, 0, 1492, 961);
		contentPane.add(label);
		b=new ButtonGroup();
		b.add(opt1);
		b.add(opt2);
		b.add(opt3);
		b.add(opt4);
		q1set();
	
		
	}
}
