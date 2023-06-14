package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.UserSearchBean;

public class UserSearchDAO {
	ConstList_Main conParam = new ConstList_Main();
    String url = conParam.getUrl();
    String user = conParam.getUser();
    String password = conParam.getPass();
	private Connection conn = null;

	//Connect DB
	public void connect() {
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//Check username and password
	public boolean select(UserSearchBean usbe) {
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		//SQL answer
		boolean flg = false;
		
		//SQL statement
		String sql = "SELECT\n"
				+ "case when b = 1 then 'true' else 'false' end\n"
				+ "FROM( select\n"
				+ "count(username) as b\n"
				+ "from user_tbl\n"
				+ "where username=?\n"
				+ "and password=?\n"
				+ ") as a;";
		
		try {
			//Connect DB
			connect();

			//自動コミットOFF
			conn.setAutoCommit(false);
			
			//Execute SELECT
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, usbe.getUser());
			pstmt.setString(2, usbe.getPass());
			
			//Execute SQL
			rset = pstmt.executeQuery();

			//Received SQL result
			while (rset.next()) {;
				//Get username and password
				flg = rset.getBoolean("case");
			}

		} catch (Exception e) {
			e.printStackTrace();
		
			
		} finally {
			try {
				if (rset != null)
					rset.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		//Disconnect DB
		disconnect();
		return flg;

	}
	
	//Disconnect DB
	public void disconnect() {
	    try {
	      if (conn != null)
	        conn.close();
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	  }
	
}