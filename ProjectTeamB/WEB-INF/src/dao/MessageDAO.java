package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import bean.MessageBean;
import dto.MessageDTO;

public class MessageDAO {
	private static String RDB_DRIVE = "org.postgresql.Driver";
	private static String URL = "jdbc:postgresql://localhost:5432/exam";
	private static String USER = "teamb";
	private static String PASS = "abc";
	private Connection con = null;

	public void connect() {
		try {
			// ①DBに接続
			Class.forName(RDB_DRIVE);
			con = DriverManager.getConnection(URL, USER, PASS);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void disconnect() {
		try {
			// ⑤DBを切断
			if (con != null)
				con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public MessageDTO insertMessage(String name,String message) {
		Statement stmt = null;
		ResultSet rs = null;
		MessageDTO sdto = new MessageDTO();		//コンストラクタが呼び出される
		String sql = "INSERT INTO message_tbl VALUES ('"+ name +"', '"+ message +"');";
		try {
			connect();
			// ②ステートメントを生成
			stmt = con.createStatement();
			// ③SQLを実行
			stmt.executeUpdate(sql);
			// ④検索結果の処理
			//なし
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		disconnect();
		return sdto;
	}
	public MessageDTO selectMessage() {
		Statement stmt = null;
		ResultSet rs = null;
		MessageDTO sdto = new MessageDTO();		//コンストラクタが呼び出される
		String sql = "SELECT * FROM message_tbl;";
		try {
			connect();
			// ②ステートメントを生成
			stmt = con.createStatement();
			// ③SQLを実行
			rs = stmt.executeQuery(sql);
			// ④検索結果の処理
			while (rs.next()) {
				MessageBean sb = new MessageBean();
				sb.setName(rs.getString("name"));
				sb.setMessage(rs.getString("message"));
				sdto.add(sb);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		disconnect();
		return sdto;
	}
}