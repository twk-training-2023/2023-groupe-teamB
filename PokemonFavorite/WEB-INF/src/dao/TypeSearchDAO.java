package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import beans.SearchBean;
import dto.SearchDTO;


public class TypeSearchDAO {
	ConstList_RoleUser conPara = new ConstList_RoleUser();
	String url = conPara.getUrl();
	String user = conPara.getUser();
	String password = conPara.getPass();
	private Connection conn = null;

	//DBの接続
	public void connect() {
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//基本処理(ポケモンのタイプ全出力)
	public SearchDTO select() {
		Statement stmt = null;
		ResultSet rset = null;
		
		//DTOの接続
		SearchDTO sdto = new SearchDTO();

		//SQL文
		String sql = "SELECT\n"
				+ "name\n"
				+ "FROM poke.type_master;\n";

		try {
			//DBの接続
			connect();
			//自動コミットOFF
			conn.setAutoCommit(false);
			//SELECT文の実行
			stmt = conn.createStatement();
			//sqlの実行
			rset = stmt.executeQuery(sql);

			//結果の受け取り
			while (rset.next()) {
				//Beanの接続(毎度)
				SearchBean sbe = new SearchBean();
				//値の受取と返還用の箱に詰める
				sbe.setName(rset.getString("name"));
				sdto.add(sbe);
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
		//DBの切断
		disconnect();
		return sdto;

	}

	// DBを切断
	public void disconnect() {
		try {
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}