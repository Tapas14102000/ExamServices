package onlineexam_;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import project.ConnectionProvider;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
public class sub extends JFrame {

	private JPanel contentPane;
	private JLabel name,id,examname,tot,attempt,cattempts,wattempts,netscore,perc,res;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sub frame = new sub();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void initial() throws Exception
	{String x;
		name.setText(studentpage.lname.getText());
		id.setText(studentpage.lid.getText());
		examname.setText(examq.exname.getText());
		tot.setText(examq.noq);
		attempt.setText(String.valueOf(examq.attempt));
		cattempts.setText(String.valueOf(examq.right));
		wattempts.setText(String.valueOf(examq.wrong));
		netscore.setText(String.valueOf(examq.score));
		perc.setText(String.valueOf((examq.score*100)/(Integer.parseInt(examq.noq)*2)));
		if(Integer.parseInt(perc.getText())>=60)
		{
			res.setForeground(new Color(34, 139, 34));                               
			res.setText("PASS");
		}
		else
		{
			res.setForeground(new Color(225, 0, 0)); 
			res.setText("FAIL");
		}
		try {
			Connection con=ConnectionProvider.getconn();
			PreparedStatement ps=con.prepareStatement("insert into examres values(?,?,?,?,?,?,?,?,?)");
			ps.setString(1, id.getText().toString());
			ps.setString(3, netscore.getText().toString());
			ps.setString(4, perc.getText().toString());
			ps.setString(6, attempt.getText().toString());
			ps.setString(7, cattempts.getText().toString());
			ps.setString(8, wattempts.getText().toString());
			ps.setString(9, res.getText().toString());
			ps.setString(5, examname.getText().toString());
			ps.setString(2, String.valueOf(studentpage.j));
			ps.executeUpdate();
	
		}
		catch(Exception e1) {}
	}
	public sub() {
		setUndecorated(true);
		setAlwaysOnTop(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 100, 627, 620);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBackToLogin = new JButton("EXIT");
		btnBackToLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				System.exit(0);
					}
		});
		btnBackToLogin.setBackground(UIManager.getColor("Button.background"));
		btnBackToLogin.setForeground(new Color(255, 0, 0));
		btnBackToLogin.setFont(new Font("Times New Roman", Font.BOLD, 30));
		btnBackToLogin.setBounds(421, 561, 196, 36);
		contentPane.add(btnBackToLogin);
		
		res = new JLabel("");
		res.setFont(new Font("Times New Roman", Font.BOLD, 25));
		res.setBounds(319, 529, 162, 22);
		contentPane.add(res);
		
		JLabel lblResult_1 = new JLabel("RESULT   --");
		lblResult_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblResult_1.setBounds(154, 521, 142, 38);
		contentPane.add(lblResult_1);
		
		JLabel label_5 = new JLabel("%");
		label_5.setFont(new Font("Times New Roman", Font.BOLD, 30));
		label_5.setBounds(551, 484, 46, 27);
		contentPane.add(label_5);
		
	 perc = new JLabel("00");
		perc.setForeground(new Color(255, 0, 0));
		perc.setFont(new Font("Times New Roman", Font.BOLD, 30));
		perc.setBounds(502, 484, 55, 27);
		contentPane.add(perc);
		
		JLabel lblPerformance = new JLabel("PERFORMANCE");
		lblPerformance.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblPerformance.setBounds(293, 483, 205, 24);
		contentPane.add(lblPerformance);
		
		netscore = new JLabel("00");
		netscore.setForeground(new Color(255, 0, 0));
		netscore.setFont(new Font("Times New Roman", Font.BOLD, 30));
		netscore.setBounds(202, 484, 44, 23);
		contentPane.add(netscore);
		
		JLabel lblTotalScore = new JLabel("TOTAL SCORE");
		lblTotalScore.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblTotalScore.setBounds(10, 480, 196, 31);
		contentPane.add(lblTotalScore);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setForeground(new Color(0, 0, 0));
		separator_6.setBackground(new Color(0, 0, 0));
		separator_6.setBounds(10, 480, 607, 2);
		contentPane.add(separator_6);
		
		wattempts = new JLabel("");
		wattempts.setForeground(new Color(255, 0, 0));
		wattempts.setFont(new Font("Times New Roman", Font.BOLD, 25));
		wattempts.setBounds(423, 444, 134, 25);
		contentPane.add(wattempts);
		
		cattempts = new JLabel("");
		cattempts.setForeground(new Color(34, 139, 34));
		cattempts.setFont(new Font("Times New Roman", Font.BOLD, 25));
		cattempts.setBounds(424, 407, 143, 24);
		contentPane.add(cattempts);
		
		attempt = new JLabel("");
		attempt.setForeground(new Color(0, 0, 128));
		attempt.setFont(new Font("Times New Roman", Font.BOLD, 25));
		attempt.setBounds(421, 374, 136, 22);
		contentPane.add(attempt);
		
		tot = new JLabel("");
		tot.setForeground(new Color(0, 0, 128));
		tot.setFont(new Font("Times New Roman", Font.BOLD, 25));
		tot.setBounds(421, 336, 85, 25);
		contentPane.add(tot);
		
		JLabel lblWrongAttempts = new JLabel("WRONG ATTEMPTS");
		lblWrongAttempts.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblWrongAttempts.setBounds(123, 444, 290, 28);
		contentPane.add(lblWrongAttempts);
		
		JLabel lblCorrectAttempts = new JLabel("CORRECT ATTEMPTS");
		lblCorrectAttempts.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblCorrectAttempts.setBounds(124, 407, 289, 27);
		contentPane.add(lblCorrectAttempts);
		
		JLabel lblAttempted = new JLabel("ATTEMPTED");
		lblAttempted.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblAttempted.setBounds(123, 374, 173, 23);
		contentPane.add(lblAttempted);
		
		JLabel lblTotal = new JLabel("TOTAL");
		lblTotal.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblTotal.setBounds(123, 336, 103, 28);
		contentPane.add(lblTotal);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setForeground(new Color(0, 0, 0));
		separator_5.setBackground(new Color(0, 0, 0));
		separator_5.setBounds(58, 455, 55, 2);
		contentPane.add(separator_5);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setForeground(new Color(0, 0, 0));
		separator_4.setBackground(new Color(0, 0, 0));
		separator_4.setBounds(59, 421, 55, 2);
		contentPane.add(separator_4);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setForeground(new Color(0, 0, 0));
		separator_3.setBackground(new Color(0, 0, 0));
		separator_3.setBounds(58, 384, 55, 2);
		contentPane.add(separator_3);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(new Color(0, 0, 0));
		separator_2.setBackground(new Color(0, 0, 0));
		separator_2.setBounds(58, 351, 55, 2);
		contentPane.add(separator_2);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(0, 0, 0));
		separator_1.setBackground(new Color(0, 0, 0));
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(58, 315, 2, 142);
		contentPane.add(separator_1);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setBackground(new Color(0, 0, 0));
		separator.setBounds(10, 315, 366, 2);
		contentPane.add(separator);
		
		JLabel lblNumberOfQuestions = new JLabel("NUMBER OF QUESTIONS");
		lblNumberOfQuestions.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNumberOfQuestions.setForeground(new Color(0, 0, 0));
		lblNumberOfQuestions.setBounds(10, 289, 384, 28);
		contentPane.add(lblNumberOfQuestions);
		
		examname = new JLabel("");
		examname.setForeground(new Color(0, 0, 128));
		examname.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		examname.setBounds(223, 229, 376, 27);
		contentPane.add(examname);
		
		JLabel lblExamName = new JLabel("EXAM NAME");
		lblExamName.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblExamName.setBounds(10, 229, 205, 28);
		contentPane.add(lblExamName);
		
		id = new JLabel("");
		id.setForeground(new Color(0, 0, 128));
		id.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		id.setBounds(223, 178, 376, 27);
		contentPane.add(id);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblId.setBounds(10, 178, 103, 28);
		contentPane.add(lblId);
		
		name = new JLabel("");
		name.setForeground(new Color(0, 0, 128));
		name.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		name.setBounds(223, 125, 376, 28);
		contentPane.add(name);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblName.setBounds(10, 125, 103, 30);
		contentPane.add(lblName);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 230, 140));
		panel.setBounds(0, 0, 627, 85);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblResult = new JLabel("RESULT");
		lblResult.setFont(new Font("Times New Roman", Font.BOLD, 99));
		lblResult.setForeground(new Color(128, 0, 0));
		lblResult.setBounds(113, 0, 406, 85);
		panel.add(lblResult);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(sub.class.getResource("/onlineexam_/icon16.jpeg")));
		label_1.setBounds(33, 10, 70, 65);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(sub.class.getResource("/onlineexam_/icon16.jpeg")));
		label_2.setBounds(529, 10, 65, 65);
		panel.add(label_2);
		
		JLabel label = new JLabel("");
		label.setVerticalAlignment(SwingConstants.BOTTOM);
		label.setIcon(new ImageIcon(sub.class.getResource("/onlineexam_/img12.jpg")));
		label.setBounds(0, 0, 627, 617);
		contentPane.add(label);
		try {
			initial();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
