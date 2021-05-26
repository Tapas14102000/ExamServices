package onlineexam_;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import project.ConnectionProvider;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class deletequestion extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JButton btnDelete ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					deletequestion frame = new deletequestion();
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
	public deletequestion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setAlwaysOnTop(true);
		setBounds(150, 183, 1066, 535);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				adminhome.open=0;

			}
		});
		
		textField_7 = new JTextField();
		textField_7.setForeground(new Color(220, 20, 60));
		textField_7.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textField_7.setHorizontalAlignment(SwingConstants.CENTER);
		textField_7.setBounds(555, 110, 68, 27);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblExamNumber = new JLabel("SET NUMBER ");
		lblExamNumber.setForeground(new Color(255, 255, 255));
		lblExamNumber.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblExamNumber.setBounds(411, 113, 144, 18);
		contentPane.add(lblExamNumber);
		button.setIcon(new ImageIcon(deletequestion.class.getResource("/onlineexam_/icon20.jpeg")));
		button.setBounds(992, 20, 46, 46);
		contentPane.add(button);
		
		JLabel lblDeleteQuestion = new JLabel("DELETE QUESTION");
		lblDeleteQuestion.setForeground(new Color(255, 255, 255));
		lblDeleteQuestion.setIcon(new ImageIcon(deletequestion.class.getResource("/onlineexam_/icon19.jpeg")));
		lblDeleteQuestion.setFont(new Font("Times New Roman", Font.BOLD, 40));
		lblDeleteQuestion.setBounds(10, 10, 465, 67);
		contentPane.add(lblDeleteQuestion);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(255, 255, 255));
		separator.setBackground(new Color(255, 255, 255));
		separator.setBounds(22, 87, 1034, 15);
		contentPane.add(separator);
		
		JLabel lblQuestionId = new JLabel("QUESTION ID");
		lblQuestionId.setForeground(new Color(255, 255, 255));
		lblQuestionId.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblQuestionId.setBounds(124, 112, 133, 19);
		contentPane.add(lblQuestionId);
		
		JLabel lblQuestion = new JLabel("QUESTION");
		lblQuestion.setForeground(new Color(255, 255, 255));
		lblQuestion.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblQuestion.setBounds(124, 160, 114, 27);
		contentPane.add(lblQuestion);
		
		JLabel lblOption = new JLabel("OPTION 1");
		lblOption.setForeground(new Color(255, 255, 255));
		lblOption.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblOption.setBounds(124, 197, 103, 24);
		contentPane.add(lblOption);
		
		JLabel lblOption_1 = new JLabel("OPTION 2");
		lblOption_1.setForeground(new Color(255, 255, 255));
		lblOption_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblOption_1.setBounds(124, 248, 103, 20);
		contentPane.add(lblOption_1);
		
		JLabel lblOption_2 = new JLabel("OPTION 3");
		lblOption_2.setForeground(new Color(255, 255, 255));
		lblOption_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblOption_2.setBounds(124, 290, 103, 24);
		contentPane.add(lblOption_2);
		
		JLabel lblOption_3 = new JLabel("OPTION 4");
		lblOption_3.setForeground(new Color(255, 255, 255));
		lblOption_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblOption_3.setBounds(124, 337, 103, 24);
		contentPane.add(lblOption_3);
		
		JLabel lblAnswer = new JLabel("ANSWER");
		lblAnswer.setForeground(new Color(255, 255, 255));
		lblAnswer.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblAnswer.setBounds(124, 384, 88, 24);
		contentPane.add(lblAnswer);
		
		textField = new JTextField();
		textField.setForeground(new Color(220, 20, 60));
		textField.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(267, 110, 53, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setForeground(new Color(0, 0, 128));
		textField_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		textField_1.setEditable(false);
		textField_1.setBounds(248, 158, 654, 27);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		textField_2.setForeground(new Color(0, 0, 128));
		textField_2.setEditable(false);
		textField_2.setBounds(248, 201, 654, 27);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setForeground(new Color(0, 0, 128));
		textField_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		textField_3.setEditable(false);
		textField_3.setBounds(248, 247, 654, 27);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setForeground(new Color(0, 0, 128));
		textField_4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		textField_4.setEditable(false);
		textField_4.setBounds(248, 291, 654, 27);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setForeground(new Color(0, 0, 128));
		textField_5.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		textField_5.setEditable(false);
		textField_5.setBounds(248, 338, 654, 27);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setForeground(new Color(0, 0, 128));
		textField_6.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		textField_6.setEditable(false);
		textField_6.setBounds(248, 385, 654, 27);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnNewButton = new JButton("SEARCH");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String id=textField.getText(),eno=textField_7.getText();
				try {
					Connection con=ConnectionProvider.getconn();
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery("select * from question where id='"+id+"'and examno='"+eno+"'");
					if(rs.first())
					{
						btnDelete.setVisible(true); 
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
						JOptionPane.showMessageDialog(jf, "Data not exist<Invalid ID or Set Number>...");
						textField.setText("");
						textField_7.setText("");

					}
				}
				catch(Exception e1)
				{JFrame jf=new JFrame();
				jf.setAlwaysOnTop(true);
				JOptionPane.showMessageDialog(jf, e1);}

			}
		});
		btnNewButton.setIcon(new ImageIcon(deletequestion.class.getResource("/onlineexam_/icon27.jpeg")));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.setBounds(676, 106, 150, 33);
		contentPane.add(btnNewButton);
		
		btnDelete = new JButton("DELETE");
		btnDelete.setVisible(false); 
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String id=textField.getText();
				try {
					Connection con=ConnectionProvider.getconn();
					PreparedStatement ps=con.prepareStatement("delete from question where id=? and examno=?");
					ps.setString(1, id);
					ps.setString(2, textField_7.getText());
					ps.executeUpdate();
					PreparedStatement ps1=con.prepareStatement("update question set id=id-1 where id>? and examno=?");
					ps1.setString(1, id);
					ps1.setString(2, textField_7.getText());	
					ps1.executeUpdate();
						JFrame jf=new JFrame();
						jf.setAlwaysOnTop(true);
						JOptionPane.showMessageDialog(jf, "SUCCESSFULLY DELETED.....");
						setVisible(false);
						new deletequestion().setVisible(true);
					}
				catch(Exception e1)
				{JFrame jf=new JFrame();
				jf.setAlwaysOnTop(true);
				JOptionPane.showMessageDialog(jf, e1);}
			}
		});
		btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnDelete.setBounds(246, 452, 169, 33);
		contentPane.add(btnDelete);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				textField_6.setText("");
				textField_7.setText("");
				
				textField.setEditable(true);
				textField_7.setEditable(true);
				btnDelete.setVisible(false);
			}
		});
		btnClear.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnClear.setBounds(572, 452, 150, 33);
		contentPane.add(btnClear);
		
		JLabel label = new JLabel("");
		label.setVerticalAlignment(SwingConstants.BOTTOM);
		label.setIcon(new ImageIcon(deletequestion.class.getResource("/onlineexam_/t2.jpg")));
		label.setBounds(0, 0, 1081, 535);
		contentPane.add(label);
	}
}
