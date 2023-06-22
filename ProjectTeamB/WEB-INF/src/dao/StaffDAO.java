package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import bean.StaffBean;
import dto.StaffDTO;

public class StaffDAO {
	
	/*---------DBにログインログアウト用----------*/
	
	//ログイン用
	ConstList_Main conParaM = new ConstList_Main();
	String urL = conParaM.getUrl();
	String useR = conParaM.getUser();
	String passWord = conParaM.getPass();
	private Connection con = null;
	
	//ログイン後
	ConstList_RoleUser conParam = new ConstList_RoleUser();
	String url = conParam.getUrl();
	String user = conParam.getUser();
	String password = conParam.getPass();
	private Connection conn = null;

	//Connect DB(ログイン用)
	public void connecT() {
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(urL, useR, passWord);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//Disconnect DB(ログイン用)
	public void disconnecT() {
		try {
			if (con != null)
				con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Connect DB(ログイン後)
	public void connect() {
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//Disconnect DB(ログイン後)
	public void disconnect() {
		try {
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	/*---------------------処理群--------------------*/
	
	//ログイン処理
	public StaffDTO select(String email, String pass) {
		ResultSet rset = null;
		Statement stmt = null;
		StaffDTO stdto = new StaffDTO();

		//SQL statement
		String sql = "SELECT\n"
				+ "name,\n"
				+ "staff_lv\n"
				+ "from Staff_tbl\n"
				+ "where email = ?\n"
				+ "and pass =?\n";

		try {
			//Connect DB
			connecT();

			//自動コミットOFF
			con.setAutoCommit(false);

			//Execute SELECT
			stmt = con.createStatement();

			//Execute SQL
			rset = stmt.executeQuery(sql);
			

			while (rset.next()) {
				StaffBean stbe = new StaffBean();
				stbe.setName(rset.getString("name"));
				stbe.setStaff_lv(rset.getInt("staff_lv"));
				stdto.add(stbe);
			}

			if (stdto.size() == 0) {
				StaffBean stbe = new StaffBean();
				stbe.setName("nouser");
				stbe.setStaff_lv(0);
				stdto.add(stbe);
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				if (rset != null)
					rset.close();
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		//Disconnect DB
		disconnecT();
		return stdto;

	}

	//一般ユーザー：パスワードの変更
	public int ChngPss(String name, String pass) {
		ResultSet rset = null;
		Statement stmt = null;

		//SQL statement
		String sql = "UPDATE\n"
				+ "Staff_tbl\n"
				+ "set pass = '" + pass + "'\n"
				+ "where name = '" + name + "'\n";
		
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

	//一般ユーザー：社員情報の更新画面のグレー文字出力
	public StaffDTO ChngMySlf(String name) {
		ResultSet rset = null;
		Statement stmt = null;
		StaffDTO stdto = new StaffDTO();

		//SQL statement
		String sql = "SELECT\n"
				+ "myself,\n"
				+ "skill_name,\n"
				+ "skill_lv,\n"
				+ "skill_appeal\n"
				+ "from Staff_tbl as main\n"
				+ "join skill_tbl as sk on main.name = sk.name\n"
				+ "join myself_tbl as my on main.name = my.name\n"
				+ "where main.name = '" + name + "';\n";

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
				StaffBean stbe = new StaffBean();
				stbe.setMyself(rset.getString("myself"));
				stbe.setSkill_name(rset.getString("skill_name"));
				stbe.setSkill_lv(rset.getInt("skill_lv"));
				stbe.setSkill_appeal(rset.getString("skill_appeal"));
				stdto.add(stbe);
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

	//管理者ユーザー：社員一覧/削除
	public StaffDTO allStaff() {
		ResultSet rset = null;
		Statement stmt = null;
		StaffDTO stdto = new StaffDTO();

		//SQL statement
		String sql = "select name from Staff_TBL";

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
				StaffBean stbe = new StaffBean();
				stbe.setName(rset.getString("name"));
				stdto.add(stbe);
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
	
	//管理者ユーザー：社員追加
	public int addStaff(String name, String email, String pass, int lv) {
		ResultSet rset = null;
		Statement stmt = null;
		int srt = 0; //1が成功、0が

		Random r = new Random(); 
		int id = r.nextInt(10000);
		//SQL statement
		String sqlstaff = "insert into staff_TBL(id,name,email,pass,staff_lv) values('"+ id +"','" + name + "','" + email+ "','" + pass + "','" + lv + "');";
		String sqlmyself ="insert into myself_TBL(name,myself) values('" + name + "','nocontext');";
		try {
			//Connect DB
			connect();

			//自動コミットOFF
			conn.setAutoCommit(false);

			//Execute SELECT
			stmt = conn.createStatement();

			//Execute SQL
			srt += stmt.executeUpdate(sqlstaff);
			conn.commit();
			
			if(srt == 1) {
			srt += stmt.executeUpdate(sqlmyself);
			conn.commit();
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
		return srt;

	}
	
	//管理者ユーザー：社員削除
	public int deleteStaff(String[] check) {
		ResultSet rset = null;
		Statement stmt = null;
		
		int srt = 0;

		//SQL statement
		String sql = "delete from staff_tbl where ";
		for(int i=0; i<check.length; i++) {
			if(i == 0) {
				sql += "name = '" + check[i] + "'";
			}else if(i >= 0) {
				sql += "or name = '" + check[i] + "'";
			}
			if(i == check.length){
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
		return srt;

	}

}