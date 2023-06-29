package junit.daoTest;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import bean.StaffBean;
import dao.StaffDAO;
import dto.StaffDTO;

public class StaffDAOTest {

	@Test
	@DisplayName("社員削除")
	public void deleteStaffA() {

		StaffDAO stf = new StaffDAO();

		//実行結果
		String[] check = { "前田啓二", "小野崎響著" };
		int ansay = stf.deleteStaff(check);
		//予測結果
		int say = 2;

		//テスト
		assertThat(say, is(ansay));
	}

	@Test
	@DisplayName("社員削除エラー")
	public void deleteStaffB() {

		StaffDAO stf = new StaffDAO();

		//実行結果
		String[] check = { "前田啓二あああああああああああああ", "小野崎響著" };
		int ansay = stf.deleteStaff(check);
		//予測結果
		int say = 0;

		//テスト
		assertThat(say, is(ansay));
	}

	/*---管理者ユーザー---*/
	@Test
	@DisplayName("社員一覧/削除")
	public void allStaff() {

		StaffDAO stf = new StaffDAO();
		StaffBean stbe = new StaffBean();

		//実行結果
		StaffDTO dtore = stf.allStaff();

		//予測結果
		String name = "砂糖";
			StaffBean bere = dtore.get(0);
			stbe.setName(name);
			//テスト
			assertThat(stbe.getName(), is(bere.getName()));
		
	}

	/*--ログイン処理--*/
	@Test
	@DisplayName("ログイン処理")
	public void selectstaff() {

		StaffDAO stf = new StaffDAO();
		StaffBean stbe = new StaffBean();

		//実行結果
		String email = "a";
		String pass = "abc";
		StaffDTO dtore = stf.select(email, pass);
		StaffBean bere = dtore.get(0);

		//予測結果
		stbe.setName("鈴木恵美");
		stbe.setStaff_lv(1);

		//テスト
		assertThat(stbe.getName(), is(bere.getName()));
		assertThat(stbe.getStaff_lv(), is(bere.getStaff_lv()));
	}

	@Test
	@DisplayName("ログイン失敗処理")
	public void selectnostaff() {

		StaffDAO stf = new StaffDAO();
		StaffBean stbe = new StaffBean();

		//実行結果
		String email = "abcde";
		String pass = "abcde";
		StaffDTO dtore = stf.select(email, pass);
		StaffBean bere = dtore.get(0);

		//予測結果
		stbe.setName("nouser");
		stbe.setStaff_lv(0);

		//テスト
		assertThat(stbe.getName(), is(bere.getName()));
		assertThat(stbe.getStaff_lv(), is(bere.getStaff_lv()));
	}

	/*--一般ユーザー--*/
	@Test
	@DisplayName("パスワードの変更")
	public void ChngPss() {
		StaffDAO stf = new StaffDAO();

		//実行結果
		String username = "鈴木恵美";
		String newpass = "abc";
		int ansay = stf.ChngPss(username, newpass);

		//予測結果
		int say = 1;

		//テスト
		assertThat(say, is(ansay));
	}

	@Test
	@DisplayName("社員情報更新")
	public void ChngMySlf() {

		StaffDAO stf = new StaffDAO();
		StaffBean stbe = new StaffBean();

		//実行結果
		String username = "佐藤一郎";
		StaffDTO dtore = stf.ChngMySlf(username);
		StaffBean bere = dtore.get(0);

		//予測結果
		stbe.setMyself("前職は消防士です。よろしくお願いいたします。");
		stbe.setSkill_name("java");
		stbe.setSkill_lv(8);
		stbe.setSkill_appeal("Javaプログラミング能力認定試験1級、Oracle認定Javaプログラマ:ゴールド");

		//テスト
		assertThat(stbe.getMyself(), is(bere.getMyself()));
		assertThat(stbe.getSkill_name(), is(bere.getSkill_name()));
		assertThat(stbe.getSkill_lv(), is(bere.getSkill_lv()));
		assertThat(stbe.getSkill_appeal(), is(bere.getSkill_appeal()));
	}

	@Test
	@DisplayName("社員個人情報A")
	public void selfINFA() {

		StaffDAO stf = new StaffDAO();
		StaffBean stbe = new StaffBean();

		//実行結果
		String username = "四郎";
		StaffDTO dtore = stf.selfINF(username);
		StaffBean bere = dtore.get(0);

		//予測結果
		stbe.setId("9847");
		stbe.setSkill_name("テスト");
		stbe.setSkill_lv(1);
		stbe.setSkill_appeal("テスト");
		stbe.setStatus("承認");
		//テスト
		assertThat(stbe.getId(), is(bere.getId()));
		assertThat(stbe.getSkill_name(), is(bere.getSkill_name()));
		assertThat(stbe.getSkill_lv(), is(bere.getSkill_lv()));
		assertThat(stbe.getSkill_appeal(), is(bere.getSkill_appeal()));
		assertThat(stbe.getStatus(), is(bere.getStatus()));
	}

	@Test
	@DisplayName("社員個人情報B")
	public void selfINFB() {

		StaffDAO stf = new StaffDAO();
		StaffBean stbe = new StaffBean();

		//実行結果
		String username = "佐藤一郎";
		StaffDTO dtore = stf.selfINF(username);
		StaffBean bere = dtore.get(0);

		//予測結果
		stbe.setId("0001");
		stbe.setSkill_name("java");
		stbe.setSkill_lv(8);
		stbe.setSkill_appeal("Javaプログラミング能力認定試験1級、Oracle認定Javaプログラマ:ゴールド");
		stbe.setStatus("申請中");
		//テスト
		assertThat(stbe.getId(), is(bere.getId()));
		assertThat(stbe.getSkill_name(), is(bere.getSkill_name()));
		assertThat(stbe.getSkill_lv(), is(bere.getSkill_lv()));
		assertThat(stbe.getSkill_appeal(), is(bere.getSkill_appeal()));
		assertThat(stbe.getStatus(), is(bere.getStatus()));
	}

	@Test
	@DisplayName("社員個人情報C")
	public void selfINFC() {

		StaffDAO stf = new StaffDAO();
		StaffBean stbe = new StaffBean();

		//実行結果
		String username = "太郎";
		StaffDTO dtore = stf.selfINF(username);
		StaffBean bere = dtore.get(0);

		//予測結果
		stbe.setId("628");
		stbe.setSkill_name("java");
		stbe.setSkill_lv(1);
		stbe.setSkill_appeal("テスト");
		stbe.setStatus("否認");
		//テスト
		assertThat(stbe.getId(), is(bere.getId()));
		assertThat(stbe.getSkill_name(), is(bere.getSkill_name()));
		assertThat(stbe.getSkill_lv(), is(bere.getSkill_lv()));
		assertThat(stbe.getSkill_appeal(), is(bere.getSkill_appeal()));
		assertThat(stbe.getStatus(), is(bere.getStatus()));
	}

	@Test
	@DisplayName("社員追加")
	public void addStaff1() {

		StaffDAO stf = new StaffDAO();

		//実行結果
		String name = "前田啓二";
		String email = "abcabc";
		String pass = "aa";
		int lv = 1;
		int say = stf.addStaff(name, email, pass, lv);

		//予測結果
		int ansay = 3;

		//テスト
		assertThat(say, is(ansay));

	}

	@Test
	@DisplayName("社員追加")
	public void addStaff2() {

		StaffDAO stf = new StaffDAO();

		//実行結果
		String name = "小野崎響著";
		String email = "abcabcabc";
		String pass = "aaaaaaa";
		int lv = 1;
		int say = stf.addStaff(name, email, pass, lv);

		//予測結果
		int ansay = 3;

		//テスト
		assertThat(say, is(ansay));

	}

	@Test
	@DisplayName("社員個人情報")
	public void checkStaff() {

		StaffDAO stf = new StaffDAO();
		StaffBean stbe = new StaffBean();

		//実行結果
		String name = "鈴木恵美";
		StaffDTO dtore = stf.checkStaff(name);
		StaffBean bere = dtore.get(0);

		//予測結果
		stbe.setId("0000");
		stbe.setSkill_name("java");
		stbe.setSkill_lv(9);
		stbe.setSkill_appeal("Javaプログラミング能力認定試験1級、Oracle認定Javaプログラマ:ゴールド");
		stbe.setMyself("");

		//テスト
		assertThat(stbe.getId(), is(bere.getId()));
		assertThat(stbe.getSkill_name(), is(bere.getSkill_name()));
		assertThat(stbe.getSkill_lv(), is(bere.getSkill_lv()));
		assertThat(stbe.getSkill_appeal(), is(bere.getSkill_appeal()));
		assertThat(stbe.getMyself(), is(bere.getMyself()));
	}

	@Test
	@DisplayName("社員権限の取得")
	public void getStlv() {

		StaffDAO stf = new StaffDAO();
		StaffBean stbe = new StaffBean();

		//実行結果
		String name = "鈴木恵美";
		StaffDTO dtore = stf.getStlv(name);
		StaffBean bere = dtore.get(0);

		//予測結果
		stbe.setStaff_lv(1);

		//テスト
		assertThat(stbe.getSkill_lv(), is(bere.getSkill_lv()));
	}

	@Test
	@DisplayName("社員権限更新")
	public void updateStaff() {

		StaffDAO stf = new StaffDAO();
		StaffBean stbe = new StaffBean();

		//実行結果
		String name = "鈴木恵美";
		int lv = 1;
		int ansay = stf.updateStaff(name, lv);

		//予測結果
		int say = 1;
		stbe.setStaff_lv(1);

		//テスト
		assertThat(say, is(ansay));

	}

}