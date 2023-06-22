package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SkillDAO {
	
	/*---------DBにログインログアウト用----------*/
	//LoginDB setup
	ConstList_RoleUser conParam = new ConstList_RoleUser();
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

	//Disconnect DB
	public void disconnect() {
		try {
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	/*---------------------処理群--------------------*/
	
	//一般ユーザー：スキルレベル等の更新
	public int ChngMn(String name,String skill_name,Integer skill_lv,String skill_appeal) {
		ResultSet rset = null;
		Statement stmt = null;

		//SQL statement
		String sql = "Update\n"
				+ "skill_tbl\n"
				+ "set\n"
				+ "skill_name = '"+ skill_name +"',"
				+ "skill_lv = '"+ skill_lv +"',"
				+ "skill_appeal = '"+ skill_appeal +"',"
				+ "status = '1'\n"
				+ "where name = '" + name + "';";
		
		//Return result
		int say = 0;

		try {
			//Connect DB
			connect();

			//自動コミットOFF
			conn.setAutoCommit(false);

			//Execute SELECT
			stmt = conn.createStatement();

			
			//Execute SQL
			say = stmt.executeUpdate(sql);
			conn.commit();

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
		return say;

	}
}