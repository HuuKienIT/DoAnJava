package DAO;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

public class mySQLHelper {
	private Connection connection;
	final String url="jdbc:mysql://localhost:3306/shopdongho";
	final String user="root";
	final String pass="";
	public void open() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.connection= (Connection) DriverManager.getConnection(url,user,pass);
		}catch (ClassNotFoundException ex) {
             ex.printStackTrace();
     } catch (SQLException ex) {
         ex.printStackTrace();
     }
	}
	public void close() {
		try {
			this.connection.close();
			
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	public ResultSet executeQuery(String sql) {
		ResultSet rs =null;
		try {
			Statement sm = (Statement) this.connection.createStatement();
			rs=(ResultSet) sm.executeQuery(sql);
		}catch(Exception ex) {
		}
		return rs;
	}
	public int executeUpdate(String sql) {
		int n=-1;
		try {
			Statement sm = (Statement) this.connection.createStatement();
			n=sm.executeUpdate(sql);
		} catch (Exception e) {
		}
		return n;
	}
}
