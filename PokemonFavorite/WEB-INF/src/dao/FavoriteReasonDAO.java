package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.ReasonBean;

public class FavoriteReasonDAO {
	ConstList_RoleUser conPara = new ConstList_RoleUser();
	String url = conPara.getUrl();
	String user = conPara.getUser();
	String password = conPara.getPass();
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
	public int select(ReasonBean rbe) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		//SQL statement
		String sql = "INSERT into\n"
				+ "favorite_reason\n"
				+ "values (?,?,?);";

		//Return result
		int say = 0;
		
		try {
			//Connect DB
			connect();

			//自動コミットOFF
			conn.setAutoCommit(false);

			//Execute SELECT
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, rbe.getName());
			pstmt.setString(2, rbe.getPKMN());
			pstmt.setString(3, rbe.getReason());
			
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