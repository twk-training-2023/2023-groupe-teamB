package TestDAO;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import dao.MyselfDAO;

public class MyselfDAOTest {

	@Test
	@DisplayName("自己紹介の変更")
	public void ChngMn() {

		MyselfDAO mys = new MyselfDAO();
		
		//実行結果
		String username = "鈴木恵美";
		String myself = "";
		int ansay= mys.ChngMn(username, myself);
	
		//予測結果
		int say = 1;
		
		//テスト
		assertThat(say, is(ansay));
	}
}