package onlineexam_;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import project.ConnectionProvider;

public class addquestion extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5; 
	public static addquestion frame;
	private JTextField textField_6;
	private JLabel lblNewLabel;
	private JButton btnUpload ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new addquestion();
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
	public void buildid()
	{
		try {
			Connection con=ConnectionProvider.getconn();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select count(id) from question where examno='"+textField_6.getText()+"'");
			if(rs.first())
			{
				int id=rs.getInt(1);
				id++;
				String str=String.valueOf(id);
				lblNewLabel.setText(str);
			}
			
			}
		catch(Exception e1) {
			JFrame jf=new JFrame();
			jf.setAlwaysOnTop(true);
			JOptionPane.showMessageDialog(jf, e1);
		}
	}
	public addquestion() {
		setUndecorated(true);
		setAlwaysOnTop(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(addquestion.class.getResource("/onlineexam_/icon13.png")));
		setTitle("ONLINE EXAM PORTAL-ADMIN");
		setBounds(150, 180, 1035, 462);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminhome.open=0;
				setVisible(false);
				
			}
		});
		
		JButton btnNewButton = new JButton("SEARCH");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					textField_6.setEditable(false);
				try {
					Connection con=ConnectionProvider.getconn();
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery("select count(id) from question where examno='"+textField_6.getText()+"'");
					if(rs.first())
					{
						int id=rs.getInt(1);
						if(id==0)
						{
							JFrame jf=new JFrame();
							jf.setAlwaysOnTop(true);
							JOptionPane.showMessageDialog(jf, "Set numbered "+textField_6.getText()+" not created");
						}
						else
							{btnUpload.setVisible(true); buildid();}
					}
					
					}
				catch(Exception e1) {
					JFrame jf=new JFrame();
					jf.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(jf, e1);
				}

				
			}
		});
		
		JButton btnNewExam = new JButton("NEW SET");
		btnNewExam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_6.setEditable(false);
				try {
					Connection con=ConnectionProvider.getconn();
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery("select count(distinct examno)+1 from question");
					if(rs.first())
					{btnUpload.setVisible(true);
						int id=rs.getInt(1);
						String str=String.valueOf(id);
						textField_6.setText(str);
						JFrame jf=new JFrame();
						jf.setAlwaysOnTop(true);
						JOptionPane.showMessageDialog(jf, "New Exam numbered "+id+" created...Must add atleast 1 question to validate this exam...");
						buildid();
					}
					
					}
				catch(Exception e1) {
					JFrame jf=new JFrame();
					jf.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(jf, e1);
				}
				
			}
		});
		btnNewExam.setFont(new Font("Times New Roman", Font.BOLD, 22));
		btnNewExam.setBounds(735, 47, 150, 30);
		contentPane.add(btnNewExam);
		btnNewButton.setForeground(new Color(0, 0, 255));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 22));
		btnNewButton.setBounds(759, 104, 150, 30);
		contentPane.add(btnNewButton);
		
	
		
		JLabel lblExam = new JLabel("SET NUMBER :");
		lblExam.setForeground(new Color(255, 255, 255));
		lblExam.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblExam.setBounds(496, 107, 165, 24);
		contentPane.add(lblExam);
		button.setIcon(new ImageIcon(addquestion.class.getResource("/onlineexam_/icon20.jpeg")));
		button.setBounds(953, 10, 52, 49);
		contentPane.add(button);
		
		JLabel lblAddNewQuestion = new JLabel("ADD NEW QUESTION");
		lblAddNewQuestion.setForeground(new Color(255, 255, 255));
		lblAddNewQuestion.setFont(new Font("Times New Roman", Font.BOLD, 35));
		lblAddNewQuestion.setIcon(new ImageIcon(addquestion.class.getResource("/onlineexam_/icon14.jpeg")));
		lblAddNewQuestion.setBounds(27, 10, 432, 69);
		contentPane.add(lblAddNewQuestion);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(255, 255, 255));
		separator.setBackground(new Color(255, 255, 255));
		separator.setBounds(10, 89, 1007, 6);
		contentPane.add(separator);
		
		JLabel lblQuestionId = new JLabel("QUESTION ID :");
		lblQuestionId.setForeground(new Color(255, 255, 255));
		lblQuestionId.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblQuestionId.setBounds(73, 105, 150, 30);
		contentPane.add(lblQuestionId);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(new Color(220, 20, 60));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel.setBounds(219, 108, 37, 24);
		contentPane.add(lblNewLabel);
		
		textField_6 = new JTextField();
		textField_6.setToolTipText("Enter exam number where u want to add question!");
		textField_6.setHorizontalAlignment(SwingConstants.CENTER);
		textField_6.setFont(new Font("Times New Roman", Font.BOLD, 22));
		textField_6.setForeground(new Color(220, 20, 60));
		textField_6.setBounds(671, 104, 69, 30);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		
		JLabel lblQuestion = new JLabel("QUESTION");
		lblQuestion.setForeground(new Color(255, 255, 255));
		lblQuestion.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblQuestion.setBounds(73, 145, 114, 25);
		contentPane.add(lblQuestion);
		
		JLabel lblOption = new JLabel("OPTION 1");
		lblOption.setForeground(new Color(255, 255, 255));
		lblOption.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblOption.setBounds(73, 180, 114, 25);
		contentPane.add(lblOption);
		
		JLabel lblOption_1 = new JLabel("OPTION 2");
		lblOption_1.setForeground(new Color(255, 255, 255));
		lblOption_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblOption_1.setBounds(73, 215, 114, 24);
		contentPane.add(lblOption_1);
		
		JLabel lblOption_2 = new JLabel("OPTION 3");
		lblOption_2.setForeground(new Color(255, 255, 255));
		lblOption_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblOption_2.setBounds(73, 255, 114, 24);
		contentPane.add(lblOption_2);
		
		JLabel lblOption_3 = new JLabel("OPTION 4");
		lblOption_3.setForeground(new Color(255, 255, 255));
		lblOption_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblOption_3.setBounds(73, 294, 114, 24);
		contentPane.add(lblOption_3);
		
		JLabel lblAnswer = new JLabel("ANSWER");
		lblAnswer.setForeground(new Color(255, 255, 255));
		lblAnswer.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblAnswer.setBounds(73, 328, 114, 24);
		contentPane.add(lblAnswer);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		textField.setForeground(new Color(0, 0, 205));
		textField.setBounds(219, 147, 725, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		textField_1.setForeground(new Color(0, 0, 205));
		textField_1.setBounds(219, 185, 725, 24);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		textField_2.setForeground(new Color(0, 0, 205));
		textField_2.setBounds(219, 219, 725, 24);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		textField_3.setForeground(new Color(0, 0, 205));
		textField_3.setBounds(219, 255, 725, 24);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		textField_4.setForeground(new Color(0, 0, 205));
		textField_4.setBounds(219, 294, 725, 24);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		textField_5.setForeground(new Color(0, 0, 205));
		textField_5.setBounds(219, 328, 725, 24);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		btnUpload = new JButton("UPLOAD");
		btnUpload.setVisible(false);
		btnUpload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id=lblNewLabel.getText();
				String question=textField.getText();
				String opt1=textField_1.getText();
				String opt2=textField_2.getText();
				String opt3=textField_3.getText();
				String opt4=textField_4.getText();
				String answer=textField_5.getText();
				if(question.isEmpty()||opt1.isEmpty()||opt2.isEmpty()||opt3.isEmpty()||opt4.isEmpty()||answer.isEmpty())
					{JFrame jf=new JFrame();
				jf.setAlwaysOnTop(true);
				JOptionPane.showMessageDialog(jf, "Fill the Questions completely..");}
				else
					try {
					Connection con=ConnectionProvider.getconn();
					PreparedStatement ps=con.prepareStatement("insert into question values(?,?,?,?,?,?,?,?)");
					Statement st=con.createStatement();
					ps.setString(1, id);
					ps.setString(2, question);
					ps.setString(3, opt1);
					ps.setString(4, opt2);
					ps.setString(5, opt3);
					ps.setString(6, opt4);
					ps.setString(7, answer);
					ps.setString(8, textField_6.getText());
					ps.executeUpdate();
					JFrame jf=new JFrame();
					jf.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(jf, "Successfully uploaded..");
					setVisible(false);
					addquestion q=new addquestion();
					q.setUndecorated(true);
					q.setVisible(true);
				}
				catch(Exception e1) {
					JFrame jf=new JFrame();
					jf.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(jf, e1);
				}
			}
		});
		btnUpload.setIcon(new ImageIcon(addquestion.class.getResource("/onlineexam_/icon26.jpeg")));
		btnUpload.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnUpload.setBounds(288, 403, 171, 45);
		contentPane.add(btnUpload);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				textField_6.setText("");
				textField_6.setEditable(true);;
				lblNewLabel.setText("");
				
				btnUpload.setVisible(false);
			}
		});
		btnClear.setIcon(new ImageIcon(addquestion.class.getResource("/onlineexam_/icon19.jpeg")));
		btnClear.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnClear.setBounds(547, 403, 204, 45);
		contentPane.add(btnClear);
		
		JLabel label_1 = new JLabel("");
		label_1.setVerticalAlignment(SwingConstants.BOTTOM);
		label_1.setIcon(new ImageIcon(addquestion.class.getResource("/onlineexam_/t2.jpg")));
		label_1.setBounds(0, 0, 1040, 470);
		contentPane.add(label_1);
	
	}
}
