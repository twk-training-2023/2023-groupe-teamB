package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import bean.SkillBean;
import dto.SkillDTO;

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
	public int ChngMn(String name, String skill_name, Integer skill_lv, String skill_appeal) {
		Statement stmt = null;

		//SQL statement
		String sql = "Update\n"
				+ "skill_tbl\n"
				+ "set\n"
				+ "skill_name = '" + skill_name + "',"
				+ "skill_lv = '" + skill_lv + "',"
				+ "skill_appeal = '" + skill_appeal + "',"
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


	//管理者ユーザー：社員スキルレベルの確認？
	public SkillDTO AllSkill() {
		ResultSet rset = null;
		Statement stmt = null;
		SkillDTO skdto = new SkillDTO();

		//SQL statement
		String sql = "select name, skill_name, skill_lv, skill_appeal from Skill_TBL where status ='1';";

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
				SkillBean skbe = new SkillBean();
				skbe.setName(rset.getString("name"));
				skbe.setSkill_name(rset.getString("skill_name"));
				skbe.setSkill_lv(rset.getInt("skill_lv"));
				skbe.setSkill_appeal(rset.getString("skill_appeal"));
				skdto.add(skbe);
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
		return skdto;
	}
	
	//管理者ユーザー：社員申請承認
	public int StatusOK(String[] name) {
		Statement stmt = null;
		int srt = 0;

		//SQL statement
		String sql = "update skill_tbl set status = '2' where ";
		for(int i=0; i<name.length; i++) {
			if(i == 0) {
				sql += "name = '" + name[i] + "'";
			}else if(i >= 0) {
				sql += "or name = '" + name[i] + "'";
			}
			if(i == (name.length)-1){
				sql += ";";	
			}	
		}
		try {
			//Connect DB
			connect();

			//自動コミットOFF
			conn.setAutoCommit(false);

			//Execute SELECT
			stmt = conn.createStatement();

			//Execute SQL
			srt = stmt.executeUpdate(sql);
            conn.commit();
            
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				
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
		return srt;

	}
	
	//管理者ユーザー：社員申請否認
	public int StatusOUT(String[] name) {
		Statement stmt = null;
		int srt = 0;

		//SQL statement
		String sql = "update skill_tbl set status = '0' where ";
		for(int i=0; i<name.length; i++) {
			if(i == 0) {
				sql += "name = '" + name[i] + "'";
			}else if(i > 0) {
				sql += "or name = '" + name[i] + "'";
			}
			if(i == (name.length)-1){
				sql += ";";	
			}	
		}
		try {
			//Connect DB
			connect();

			//自動コミットOFF
			conn.setAutoCommit(false);

			//Execute SELECT
			stmt = conn.createStatement();

			//Execute SQL
			srt = stmt.executeUpdate(sql);
            conn.commit();
            
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
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
		return srt;

	}
}