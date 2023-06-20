package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import bean.StaffBean;
import dto.StaffDTO;

public class StaffDAO {
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
	public StaffDTO select(String email,String pass) {
		ResultSet rset = null;
		Statement stmt = null;
		StaffDTO stdto = new StaffDTO();

		//SQL statement
		String sql = "SELECT\n"
				+ "name,\n"
				+ "staff_lv\n"
				+ "from Staff_tbl\n"
				+ "where email = '"+ email + "'\n"
				+ "and pass = '" + pass + "'\n";

		try {
			//Connect DB
			connect();

			//自動コミットOFF
			conn.setAutoCommit(false);

			//Execute SELECT
			stmt = conn.createStatement();
			
			//Execute SQL
			rset = stmt.executeQuery(sql);

			while (rset.next()) {
				StaffBean return_stbe = new StaffBean();
				return_stbe.setName(rset.getString("name"));
				return_stbe.setLevel(rset.getString("staff_lv"));
				stdto.add(return_stbe);
				}
			
			if(stdto.size() == 0 ){
				StaffBean return_stbe = new StaffBean();
				return_stbe.setName("nouser");
				return_stbe.setLevel("0");
				stdto.add(return_stbe);
			}


		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				if (rset != null)
					rset.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		//Disconnect DB
		disconnect();
		return stdto;

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