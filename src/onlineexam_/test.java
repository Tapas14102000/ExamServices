package onlineexam_;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import project.ConnectionProvider;

public class test {
	private static String examname,exambegin,duration,qset,examdate,examno,x,y;
	private static int j=0,h=0,key=0;
public test()
{
	System.out.println("hello");
	try
	{
		
		Connection con=ConnectionProvider.getconn();
		Statement st=con.createStatement();
		ResultSet rs5=st.executeQuery("select count(examno) from examschedule");
		if(rs5.first())
		{
			j=Integer.parseInt(rs5.getString(1));
		}
		Statement st1=con.createStatement();
		ResultSet rs3=st1.executeQuery("select * from examschedule where examno='"+String.valueOf(j)+"'");
		if(rs3.first())
		{
			examname=rs3.getString(1);
			examdate=rs3.getString(3);
			exambegin=rs3.getString(4);
			duration=rs3.getString(5);
			qset=rs3.getString(2);
			examno=rs3.getString(6);
		}
		Statement st2=con.createStatement();
			ResultSet rs1=st2.executeQuery("select count(*) from examres where id='"+loginpage.txtEnterYourMail.getText()+"' and examno='"+String.valueOf(j)+"'");
			if(rs1.first())
			{
				h=Integer.parseInt(rs1.getString(1));
			}
			new tableid(2);	
	final SimpleDateFormat df=new SimpleDateFormat("dd-MM-yyyy");
	Date date1=new Date();
	y=df.format(date1);
	studentpage.ldate.setText(y);
	Thread t=new Thread() {
		public void run()
		{	System.out.println("hello1");
			try {
			while(true)
			{
			DateFormat date=new SimpleDateFormat("hh-mm-ss aa");
				x=date.format(new Date());
				studentpage.ltime.setText(x);	
				if(df.parse(y).compareTo(df.parse(examdate))==0&&date.parse(x).compareTo(date.parse(exambegin))>0&&key==0&&h==0&&j!=0)
				{
					System.out.println("hello2");
					studentpage.start.doClick();key=1;
				}	
				Thread.sleep(1);
				}
			}
			 catch (Exception e) {
					e.printStackTrace();
				}
			
			}
		
	};
	t.start();
}
catch(Exception e) {}


}
}