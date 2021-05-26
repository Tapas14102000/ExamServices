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
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import project.ConnectionProvider;

public class allquestion extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					allquestion frame = new allquestion();
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
	public void display()
	{
		try {
			Connection con=ConnectionProvider.getconn();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from question");
			table_1.setModel(DbUtils.resultSetToTableModel(rs));
		}		catch(Exception e) {
			JFrame jf=new JFrame();
			jf.setAlwaysOnTop(true);
			JOptionPane.showMessageDialog(jf, e);
		}

	}
	public allquestion() {
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
		
		JLabel lblExamNo = new JLabel("EXAM NO.");
		lblExamNo.setForeground(Color.WHITE);
		lblExamNo.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblExamNo.setBounds(924, 88, 112, 21);
		contentPane.add(lblExamNo);
		
		JLabel lblAnswer = new JLabel("ANSWER");
		lblAnswer.setForeground(Color.WHITE);
		lblAnswer.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblAnswer.setBounds(803, 86, 100, 24);
		contentPane.add(lblAnswer);
		
		JLabel lblOption_3 = new JLabel("OPTION 4");
		lblOption_3.setForeground(Color.WHITE);
		lblOption_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblOption_3.setBounds(673, 86, 106, 24);
		contentPane.add(lblOption_3);
		
		JLabel lblOption_2 = new JLabel("OPTION 3");
		lblOption_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblOption_2.setForeground(Color.WHITE);
		lblOption_2.setBounds(544, 86, 100, 24);
		contentPane.add(lblOption_2);
		
		JLabel lblOption_1 = new JLabel("OPTION 2");
		lblOption_1.setForeground(Color.WHITE);
		lblOption_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblOption_1.setBounds(411, 85, 106, 26);
		contentPane.add(lblOption_1);
		
		JLabel lblOption = new JLabel("OPTION 1");
		lblOption.setForeground(Color.WHITE);
		lblOption.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblOption.setBounds(286, 86, 106, 24);
		contentPane.add(lblOption);
		
		JLabel lblQuestion = new JLabel("QUESTION");
		lblQuestion.setForeground(Color.WHITE);
		lblQuestion.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblQuestion.setBounds(157, 86, 106, 24);
		contentPane.add(lblQuestion);
		
		JLabel lblId = new JLabel("ID");
		lblId.setForeground(Color.WHITE);
		lblId.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblId.setBounds(49, 86, 32, 24);
		contentPane.add(lblId);
		
		table_1 = new JTable();
		table_1.setFillsViewportHeight(true);
		table_1.setToolTipText("EXAM QUESTIONS....");
		table_1.setForeground(new Color(220, 20, 60));
		table_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		table_1.setBounds(10, 122, 1046, 357);
		contentPane.add(table_1);
		
		button.setIcon(new ImageIcon(allquestion.class.getResource("/onlineexam_/icon20.jpeg")));
		button.setBounds(962, 10, 47, 52);
		contentPane.add(button);
		
		JLabel lblNewLabel = new JLabel("ALL QUESTION");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
		lblNewLabel.setIcon(new ImageIcon(allquestion.class.getResource("/onlineexam_/icon16.jpeg")));
		lblNewLabel.setBounds(10, 0, 485, 76);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 0, 0));
		separator.setBounds(10, 72, 1046, 14);
		contentPane.add(separator);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(allquestion.class.getResource("/onlineexam_/t2.jpg")));
		label_1.setBounds(0, 0, 1066, 535);
		contentPane.add(label_1);
		display();
	}
}
