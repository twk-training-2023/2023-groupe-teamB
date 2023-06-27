package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
		PreparedStatement pstmt = null;
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
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, pass);

			//Execute SQL
			rset = pstmt.executeQuery();

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
				if (pstmt != null)
					pstmt.close();
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
		PreparedStatement pstmt = null;

		//SQL statement
		String sql = "UPDATE\n"
				+ "Staff_tbl\n"
				+ "set pass =?\n"
				+ "where name =?\n";

		//Return result
		int say = 0;

		try {
			//Connect DB
			connect();

			//自動コミットOFF
			conn.setAutoCommit(false);

			//Execute SELECT
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pass);
			pstmt.setString(2, name);

			//Execute SQL
			say = pstmt.executeUpdate();
			if(say==1) {
			conn.commit();
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
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

	//一般ユーザー：社員情報の更新
	public StaffDTO ChngMySlf(String name) {
		ResultSet rset = null;
		PreparedStatement pstmt = null;
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
				+ "where main.name =?;\n";

		try {
			//Connect DB
			connect();

			//自動コミットOFF
			conn.setAutoCommit(false);

			//Execute SELECT
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);

			//Execute SQL
			rset = pstmt.executeQuery();

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
		return stdto;

	}

	//一般ユーザー：社員個人情報
	public StaffDTO selfINF(String name) {
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		StaffDTO sdto = new StaffDTO();

		//SQL statement
		String sql = "select\n"
				+ "id,\n"
				+ "skill_name,\n"
				+ "skill_lv,\n"
				+ "skill_appeal,\n"
				+ "status,\n"
				+ "myself\n"
				+ "from\n"
				+ "staff_tbl as a\n"
				+ "join myself_tbl as b on a.name = b.name\n"
				+ "join skill_tbl as c on a.name = c.name\n"
				+ "where\n"
				+ "a.name =?\n";

		//String sql ="select * from staff_tbl where id;";

		try {
			//Connect DB
			connect();

			//自動コミットOFF
			conn.setAutoCommit(false);

			//Execute SELECT
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);

			//Execute SQL
			rset = pstmt.executeQuery();
			
			while (rset.next()) {
				StaffBean sb = new StaffBean();
				int status = rset.getInt("status");
				sb.setId(rset.getString("id"));
				sb.setSkill_name(rset.getString("skill_name"));
				sb.setSkill_lv(rset.getInt("skill_lv"));
				sb.setSkill_appeal(rset.getString("skill_appeal"));
				if(status==1) {
					sb.setStatus("申請中");
				}else if(status==0) {
					sb.setStatus("否認");
				}else if(status==2) {
					sb.setStatus("承認");
				}
				sb.setMyself(rset.getString("myself"));
				sdto.add(sb);
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
		return sdto;

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
		PreparedStatement pstmta = null;
		PreparedStatement pstmtb = null;
		PreparedStatement pstmtc = null;
		int srt = 0; //1が成功、0が

		Random r = new Random();
		int id = r.nextInt(10000);
		//SQL statement
		String sqlstaff = "insert into staff_TBL(id,name,email,pass,"
							+ "staff_lv) values(?,?,?,?,?);";
		String sqlmyself = "insert into myself_TBL(name,myself) values(?,'nocontext');";
		String sqlskill = "insert into skill_TBL(name,skill_name,"
							+ "skill_lv,skill_appeal) values(?,'nocontext','0','nocontext');";
		try {
			//Connect DB
			connect();

			//自動コミットOFF
			conn.setAutoCommit(false);

			//Execute SELECT
			pstmta = conn.prepareStatement(sqlstaff);
			pstmta.setInt(1,id);
			pstmta.setString(2,name);
			pstmta.setString(3,email);
			pstmta.setString(4,pass);
			pstmta.setInt(5,lv);
			
			pstmtb = conn.prepareStatement(sqlmyself);
			pstmtb.setString(1,name);
			
			pstmtc = conn.prepareStatement(sqlskill);
			pstmtc.setString(1,name);
			
			//Execute SQL
			srt += pstmta.executeUpdate();
			conn.commit();

			if (srt == 1) {
				srt += pstmtb.executeUpdate();
				conn.commit();
			}
			if(srt==2) {
				srt += pstmtc.executeUpdate();
				conn.commit();
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				if (pstmta != null)
					pstmta.close();
				if (pstmtb != null)
					pstmtb.close();
				if (pstmtc != null)
					pstmtc.close();
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
		for (int i = 0; i < check.length; i++) {
			if (i == 0) {
				sql += "name = '" + check[i] + "'";
			} else if (i >=0) {
				sql += "or name = '" + check[i] + "'";
			}
			if (i == (check.length)-1) {
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

	//管理者ユーザー：社員個人情報
	public StaffDTO checkStaff(String name) {
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		StaffDTO sdto = new StaffDTO();

		//SQL statement
		String sql = "select\n"
				+ "id,\n"
				+ "skill_name,\n"
				+ "skill_lv,\n"
				+ "skill_appeal,\n"
				+ "myself\n"
				+ "from\n"
				+ "staff_tbl as a\n"
				+ "join myself_tbl as b on a.name = b.name\n"
				+ "join skill_tbl as c on a.name = c.name\n"
				+ "where\n"
				+ "a.name =?\n";

		//String sql ="select * from staff_tbl where id;";

		try {
			//Connect DB
			connect();

			//自動コミットOFF
			conn.setAutoCommit(false);

			//Execute SELECT
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);

			//Execute SQL
			rset = pstmt.executeQuery();

			while (rset.next()) {
				StaffBean sb = new StaffBean();
				sb.setId(rset.getString("id"));
				sb.setSkill_name(rset.getString("skill_name"));
				sb.setSkill_lv(rset.getInt("skill_lv"));
				sb.setSkill_appeal(rset.getString("skill_appeal"));
				sb.setMyself(rset.getString("myself"));
				sdto.add(sb);
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
		return sdto;

	}

	//管理者ユーザー：社員権限の取得
	public StaffDTO getStlv(String name) {
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		StaffDTO sdto = new StaffDTO();

		//SQL statement
		String sql = "select staff_lv from staff_tbl where name= ?";

		try {
			//Connect DB
			connect();

			//自動コミットOFF
			conn.setAutoCommit(false);

			//Execute SELECT
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);

			//Execute SQL
			rset = pstmt.executeQuery();

			while (rset.next()) {
				StaffBean stbe = new StaffBean();
				stbe.setStaff_lv(rset.getInt("staff_lv"));
				sdto.add(stbe);
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
		return sdto;
	}

	//管理者ユーザー：社員権限更新
	public int updateStaff(String name, int lv) {
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		int srt = 0; //1が成功、0が

		//SQL statement
		String sql = "update staff_tbl set staff_lv = ? where name = ?;";

		try {
			//Connect DB
			connect();

			//自動コミットOFF
			conn.setAutoCommit(false);

			//Execute SELECT
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, lv);
			pstmt.setString(2, name);

			//Execute SQL
			srt = pstmt.executeUpdate();
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
		return srt;

	}

}