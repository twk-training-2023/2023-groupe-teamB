package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import bean.MessageBean;
import dto.MessageDTO;

public class MessageDAO {
	ConstList_RoleUser conParam = new ConstList_RoleUser();
	String url = conParam.getUrl();
	String user = conParam.getUser();
	String password = conParam.getPass();
	private Connection conn = null;

	public void connect() {
		try {
			// ①DBに接続
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void disconnect() {
		try {
			// ⑤DBを切断
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//一般ユーザー：社員の愚痴を投げる
	public int insertMessage(String name,String message) {
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "INSERT INTO message_tbl VALUES ('"+ name +"', '"+ message +"');";
		
		//Return result
		int say = 0;
		
		try {
			connect();
			//自動コミットOFF
			conn.setAutoCommit(false);
			
			// ②ステートメントを生成
			stmt = conn.createStatement();
			
			// ③SQLを実行
			say = stmt.executeUpdate(sql);
			conn.commit();

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
		return say;
	}
	
	//管理者ユーザー：社員の愚痴を表示
	public MessageDTO selectMessage() {
		Statement stmt = null;
		ResultSet rs = null;
		MessageDTO sdto = new MessageDTO();		//コンストラクタが呼び出される
		String sql = "SELECT * FROM message_tbl;";
		try {
			connect();
			// ②ステートメントを生成
			stmt = conn.createStatement();
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