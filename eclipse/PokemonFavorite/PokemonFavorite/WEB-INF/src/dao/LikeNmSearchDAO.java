package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import beans.SearchBean;
import dto.SearchDTO;

public class LikeNmSearchDAO {
	ConstList_RoleUser conPara = new ConstList_RoleUser();
    String url = conPara.getUrl();
    String user = conPara.getUser();
    String password = conPara.getPass();
	private Connection conn = null;

	public void connect() {
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public SearchDTO select(String typename,String firstname) {
		Statement stmt = null;
		ResultSet rset = null;
		SearchDTO sdto = new SearchDTO();
		
		String sql = "SELECT\n"
				+ "pb.name\n"
				+ "FROM poke.pokemon_base as pb\n"
				+ "WHERE(pb.type1 = '" + typename +"'\n"
				+ "or pb.type2 = '" + typename + "')\n"
				+ "and pb.name like \'"+ firstname + "%\'\n"
				+ "order by name\n"
				+ ";\n";
		
		try {
			connect();
			//自動コミットOFF
			conn.setAutoCommit(false);
			//SELECT文の実行
			stmt = conn.createStatement();
			//sqlの実行
			rset = stmt.executeQuery(sql);

			//SELECT結果の受け取り
			while (rset.next()) {
				SearchBean sbe = new SearchBean();
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
		disconnect();
		return sdto;

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
	
}