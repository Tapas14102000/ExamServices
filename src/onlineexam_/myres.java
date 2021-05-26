package onlineexam_;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;
import project.ConnectionProvider;

public class myres extends JFrame {

	private JPanel contentPane;
	private JTable table_2;
	public static JButton button;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					myres frame = new myres();
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
			ResultSet rs=st.executeQuery("select examno,ename,attempt,cattempt,wattempt,result,percent,finalres from examres where id='"+studentpage.lid.getText()+"'");
			table_2.setModel(DbUtils.resultSetToTableModel(rs));
		}		catch(Exception e) {
			JFrame jf=new JFrame();
			jf.setAlwaysOnTop(true);
			JOptionPane.showMessageDialog(jf, e);
		}

	}
	public myres() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setAlwaysOnTop(true);
		setBounds(150, 183, 1066, 535);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		
		JLabel lblExamNo = new JLabel("RESULT");
		lblExamNo.setForeground(new Color(255, 255, 255));
		lblExamNo.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblExamNo.setBounds(962, 88, 87, 21);
		contentPane.add(lblExamNo);
		
		JLabel lblAnswer = new JLabel("PERCENTAGE");
		lblAnswer.setForeground(new Color(255, 255, 255));
		lblAnswer.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblAnswer.setBounds(779, 86, 145, 24);
		contentPane.add(lblAnswer);
		
		JLabel lblOption_3 = new JLabel("SCORE");
		lblOption_3.setForeground(new Color(255, 255, 255));
		lblOption_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblOption_3.setBounds(665, 86, 87, 24);
		contentPane.add(lblOption_3);
		
		JLabel lblOption_2 = new JLabel("INCORRECT");
		lblOption_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblOption_2.setForeground(new Color(255, 255, 255));
		lblOption_2.setBounds(518, 86, 122, 24);
		contentPane.add(lblOption_2);
		
		JLabel lblOption_1 = new JLabel("CORRECT");
		lblOption_1.setForeground(new Color(255, 255, 255));
		lblOption_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblOption_1.setBounds(391, 85, 100, 26);
		contentPane.add(lblOption_1);
		
		JLabel lblOption = new JLabel("ATTEMPT");
		lblOption.setForeground(new Color(255, 255, 255));
		lblOption.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblOption.setBounds(275, 86, 100, 24);
		contentPane.add(lblOption);
		
		JLabel lblQuestion = new JLabel("EXAM_NAME");
		lblQuestion.setForeground(new Color(255, 255, 255));
		lblQuestion.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblQuestion.setBounds(127, 86, 138, 24);
		contentPane.add(lblQuestion);
		
		JLabel lblId = new JLabel("EXAM_NO");
		lblId.setForeground(new Color(255, 255, 255));
		lblId.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblId.setBounds(10, 86, 106, 24);
		contentPane.add(lblId);
		
		table_2 = new JTable();
		table_2.setFillsViewportHeight(true);
		table_2.setToolTipText("EXAM QUESTIONS....");
		table_2.setForeground(new Color(220, 20, 60));
		table_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		table_2.setBounds(10, 122, 1046, 357);
		contentPane.add(table_2);
		
		button.setIcon(new ImageIcon(allquestion.class.getResource("/onlineexam_/icon20.jpeg")));
		button.setBounds(962, 10, 47, 52);
		contentPane.add(button);
		
		JLabel lblNewLabel = new JLabel("MY RESULTS");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
		lblNewLabel.setIcon(new ImageIcon(allquestion.class.getResource("/onlineexam_/icon16.jpeg")));
		lblNewLabel.setBounds(10, 0, 485, 76);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(255, 255, 255));
		separator.setBackground(new Color(255, 255, 255));
		separator.setBounds(10, 72, 1046, 2);
		contentPane.add(separator);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(myres.class.getResource("/onlineexam_/t2.jpg")));
		label_1.setBounds(0, 0, 1066, 535);
		contentPane.add(label_1);
		display();
	}

	}


