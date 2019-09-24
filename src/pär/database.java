package pär;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class database {
	
	
	
	private Connection con;
	Object[] fields;
	
	public database(String host,String user,String password,String dataBase) {
		try {
			
			Class.forName("org.gjt.mm.mysql.Driver").newInstance();
			con=DriverManager.getConnection("jdbc:mysql://"+host+"/"+dataBase,user,password);
			
		}
		catch (Exception e) {
			//JOptionPane.showMessageDialog(null, e);
			System.out.println(e);
		}
	}
	
	
	public Object[][] getData(String SQL) {
		
		Object[][] data=null;
		
		try {
			Statement statment=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs=statment.executeQuery("select * from "+SQL);
			ResultSetMetaData md=rs.getMetaData();
			fields=new Object[md.getColumnCount()];
			
			for(int i=0;i<fields.length;i++) {
				fields[i]=md.getColumnName(i+1);
				//System.out.println(fields[i]);
			}
			
			int antalRader=0;
			while(rs.next()) {
				antalRader++;
			}
			
			data=new Object[antalRader][md.getColumnCount()];
			rs.beforeFirst();
			int rad=0;
			while(rs.next()) {
				for(int i=0;i<md.getColumnCount();i++) {
					data[rad][i]=rs.getString(i+1);
				}
				rad++;
			}
			
			
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		return data;
	}
public Object[][] getDataFull(String SQL) {
		
		Object[][] data=null;
		
		try {
			Statement statment=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs=statment.executeQuery(SQL);
			ResultSetMetaData md=rs.getMetaData();
			fields=new Object[md.getColumnCount()];
			
			for(int i=0;i<fields.length;i++) {
				fields[i]=md.getColumnName(i+1);
				//System.out.println(fields[i]);
			}
			
			int antalRader=0;
			while(rs.next()) {
				antalRader++;
			}
			
			data=new Object[antalRader][md.getColumnCount()];
			rs.beforeFirst();
			int rad=0;
			while(rs.next()) {
				for(int i=0;i<md.getColumnCount();i++) {
					data[rad][i]=rs.getString(i+1);
				}
				rad++;
			}
			
			
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		return data;
	}
	
	
	public Object[] getFields() {
		return fields;
	}
	
	public void execute(String SQL) {
		try {
			Statement statment=con.createStatement();
			statment.execute(SQL);
			
		}
		catch (Exception e) {
			System.out.println("error!!!!!    "+e);
			//JOptionPane.showMessageDialog(null, e);
		}
	}
	
	
	
	public void remove(String location, int id) {
		//DELETE FROM table_name WHERE condition;
		String SQL="DELETE FROM "+location+" WHERE id="+"'"+id+"'"+"";
		
		execute(SQL);
	}
	

}
