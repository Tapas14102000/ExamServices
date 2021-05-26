package onlineexam_;

import java.awt.EventQueue;
import java.sql.*;
import project.ConnectionProvider;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class updatequestion extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JButton btnUpdate ;
	/**
	 * Launch the application.
	 */
	public static updatequestion frame;
	private JTextField textField_7;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new updatequestion();
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
	public updatequestion() {
		setUndecorated(true);
		setAlwaysOnTop(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(updatequestion.class.getResource("/onlineexam_/icon13.png")));
		setBounds(150, 183, 1052, 490);
		isAlwaysOnTop();
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
				textField_7.setText("");
				btnUpdate.setVisible(false);
				textField.setEditable(true);
				textField_7.setEditable(true);
				
			}
		});
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				adminhome.open=0;
			}
		});
		
		textField_7 = new JTextField();
		textField_7.setForeground(new Color(220, 20, 60));
		textField_7.setHorizontalAlignment(SwingConstants.CENTER);
		textField_7.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textField_7.setBounds(500, 106, 72, 26);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblExamNo = new JLabel("EXAM NO.");
		lblExamNo.setForeground(new Color(255, 255, 255));
		lblExamNo.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblExamNo.setBounds(372, 105, 118, 24);
		contentPane.add(lblExamNo);
		button.setIcon(new ImageIcon(updatequestion.class.getResource("/onlineexam_/icon20.jpeg")));
		button.setBounds(948, 10, 51, 53);
		contentPane.add(button);
		btnClear.setIcon(new ImageIcon(updatequestion.class.getResource("/onlineexam_/icon24.jpeg")));
		btnClear.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnClear.setBounds(545, 405, 205, 53);
		contentPane.add(btnClear);
		
		JLabel lblUpdateQuestion = new JLabel("UPDATE QUESTION");
		lblUpdateQuestion.setForeground(new Color(255, 255, 255));
		lblUpdateQuestion.setIcon(new ImageIcon(updatequestion.class.getResource("/onlineexam_/icon28.jpeg")));
		lblUpdateQuestion.setFont(new Font("Times New Roman", Font.BOLD, 40));
		lblUpdateQuestion.setBounds(10, 10, 459, 53);
		contentPane.add(lblUpdateQuestion);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(255, 255, 255));
		separator.setBackground(new Color(255, 255, 255));
		separator.setBounds(20, 72, 1022, 13);
		contentPane.add(separator);
		
		JLabel lblQuestionId = new JLabel("QUESTION ID");
		lblQuestionId.setForeground(new Color(255, 255, 255));
		lblQuestionId.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblQuestionId.setBounds(87, 106, 165, 26);
		contentPane.add(lblQuestionId);
		
		JLabel lblQuestion = new JLabel("QUESTION");
		lblQuestion.setForeground(new Color(255, 255, 255));
		lblQuestion.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblQuestion.setBounds(87, 172, 106, 24);
		contentPane.add(lblQuestion);
		
		JLabel lblOption = new JLabel("OPTION 1");
		lblOption.setForeground(new Color(255, 255, 255));
		lblOption.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblOption.setBounds(87, 206, 102, 21);
		contentPane.add(lblOption);
		
		JLabel lblOption_1 = new JLabel("OPTION 2");
		lblOption_1.setForeground(new Color(255, 255, 255));
		lblOption_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblOption_1.setBounds(87, 237, 102, 24);
		contentPane.add(lblOption_1);
		
		JLabel lblOption_2 = new JLabel("OPTION 3");
		lblOption_2.setForeground(new Color(255, 255, 255));
		lblOption_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblOption_2.setBounds(87, 271, 94, 21);
		contentPane.add(lblOption_2);
		
		JLabel lblOption_3 = new JLabel("OPTION 4");
		lblOption_3.setForeground(new Color(255, 255, 255));
		lblOption_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblOption_3.setBounds(87, 307, 94, 21);
		contentPane.add(lblOption_3);
		
		JLabel lblAnswer = new JLabel("ANSWER");
		lblAnswer.setForeground(new Color(255, 255, 255));
		lblAnswer.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblAnswer.setBounds(87, 341, 94, 21);
		contentPane.add(lblAnswer);
		
		textField = new JTextField();
		textField.setForeground(new Color(220, 20, 60));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Times New Roman", Font.BOLD, 22));
		textField.setBounds(262, 106, 64, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setForeground(new Color(0, 0, 128));
		textField_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		textField_1.setBounds(207, 175, 654, 24);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setForeground(new Color(0, 0, 128));
		textField_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		textField_2.setBounds(207, 204, 654, 24);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setForeground(new Color(0, 0, 128));
		textField_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		textField_3.setBounds(207, 238, 654, 24);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setForeground(new Color(0, 0, 128));
		textField_4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		textField_4.setBounds(207, 272, 654, 24);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setForeground(new Color(0, 0, 128));
		textField_5.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		textField_5.setBounds(207, 306, 654, 24);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setForeground(new Color(0, 0, 128));
		textField_6.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		textField_6.setBounds(207, 340, 654, 24);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnNewButton = new JButton("SEARCH");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id=textField.getText();
				try {
					Connection con=ConnectionProvider.getconn();
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery("select * from question where id='"+id+"' and examno='"+textField_7.getText()+"'");
					if(rs.first())
					{	btnUpdate.setVisible(true);
						textField_1.setText(rs.getString(2));
						textField_2.setText(rs.getString(3));
						textField_3.setText(rs.getString(4));
						textField_4.setText(rs.getString(5));
						textField_5.setText(rs.getString(6));
						textField_6.setText(rs.getString(7));
						textField.setEditable(false);
						textField_7.setEditable(false);
						
					}
					else
					{
						JFrame jf=new JFrame();
						jf.setAlwaysOnTop(true);
						JOptionPane.showMessageDialog(jf, "DATA DOESN'T EXIST<Invald ID or Exam no.>...");
					}
				}
				catch(Exception e1)
				{JFrame jf=new JFrame();
				jf.setAlwaysOnTop(true);
				JOptionPane.showMessageDialog(jf, e1);}
			}
		});
		btnNewButton.setIcon(new ImageIcon(updatequestion.class.getResource("/onlineexam_/icon27.jpeg")));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 22));
		btnNewButton.setBounds(681, 99, 165, 33);
		contentPane.add(btnNewButton);
		
		btnUpdate = new JButton("UPDATE");
		btnUpdate.setVisible(false);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id=textField.getText();
				String question=textField_1.getText();
				String opt1=textField_2.getText();
				String opt2=textField_3.getText();
				String opt3=textField_4.getText();
				String opt4=textField_5.getText();
				String answer=textField_6.getText();
				try {
					Connection con=ConnectionProvider.getconn();
					PreparedStatement ps=con.prepareStatement("update question set name=?,opt1=?,opt2=?,opt3=?,opt4=?,answer=? where id=? and examno=?");
					ps.setString(7, id);
					ps.setString(1, question);
					ps.setString(2, opt1);
					ps.setString(3, opt2);
					ps.setString(4, opt3);
					ps.setString(5, opt4);
					ps.setString(6, answer);
					ps.setString(8, textField_7.getText());
					ps.executeUpdate();
					JFrame jf=new JFrame();
					jf.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(jf, "Successfully updated..");
					setVisible(false);
					new updatequestion().setVisible(true);
				}
				catch(Exception e1) {
					JFrame jf=new JFrame();
					jf.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(jf, e1);
				}
			}
		});
		btnUpdate.setIcon(new ImageIcon(updatequestion.class.getResource("/onlineexam_/icon26.jpeg")));
		btnUpdate.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnUpdate.setBounds(207, 405, 196, 53);
		contentPane.add(btnUpdate);
		
		JLabel label = new JLabel("");
		label.setVerticalAlignment(SwingConstants.BOTTOM);
		label.setIcon(new ImageIcon(updatequestion.class.getResource("/onlineexam_/t2.jpg")));
		label.setBounds(0, 0, 1066, 498);
		contentPane.add(label);
	}
}
