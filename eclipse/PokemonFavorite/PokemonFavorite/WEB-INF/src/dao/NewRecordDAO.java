package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.UserSearchBean;

public class NewRecordDAO {
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
	public int select(UserSearchBean usbe) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		//SQL statement
		String sql = "INSERT into\n"
				+ "user_tbl\n"
				+ "values (?,?);";

		//Return result
		int say = 0;
		
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
			say = pstmt.executeUpdate();
			conn.commit();
			
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
		return say;
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