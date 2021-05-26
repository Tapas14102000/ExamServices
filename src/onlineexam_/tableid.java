package onlineexam_;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import net.proteanit.sql.DbUtils;
import project.ConnectionProvider;

public class tableid {
	public tableid(int k)
	{
		try {
			Connection con=ConnectionProvider.getconn();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select examno,examname,examdate,exambegin,duration from examschedule");
			if(k==2)
				studentpage.table.setModel(DbUtils.resultSetToTableModel(rs));
			else
				adminhome.table.setModel(DbUtils.resultSetToTableModel(rs));
			
			}
		catch(Exception e) {
			
		}
	}

}
