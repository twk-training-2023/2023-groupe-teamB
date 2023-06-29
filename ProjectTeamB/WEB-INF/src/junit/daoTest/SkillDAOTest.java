package junit.daoTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import bean.SkillBean;
import dao.SkillDAO;
import dto.SkillDTO;

class SkillDAOTest {
	@Test
	@DisplayName("スキルの更新")
	void test() {
	 SkillDAO skdao = new SkillDAO();
		String name = "太郎";
	    String skill_name = "java";
	    int skill_lv = 1;
	    String skill_appeal = "テスト";
	    int result = skdao.ChngMn(name, skill_name, skill_lv, skill_appeal);
	    System.out.println(result);
	    assertEquals(1,result); 
	
	}
	
	@Test
	@DisplayName("スキル情報の表示")
	void test2() {
		
	 SkillDAO skdao = new SkillDAO();
	    SkillDTO skdto = skdao.AllSkill();
	   SkillBean skbe = skdto.get(0);
	   assertEquals("佐藤一郎", skbe.getName());
	}
	
	@Test
	@DisplayName("社員申請承認")
	void test3() {
	   SkillDAO skdao = new SkillDAO();
	   //予想
	   String[] name = {"太郎","二郎","三郎"};
	   //実行結果
	   int result = skdao.StatusOK(name);
	   
	   System.out.println(result);
	   assertEquals(3,result);
	}
	
	@Test
	@DisplayName("社員申請承認")
	void test4() {
	   SkillDAO skdao = new SkillDAO();
	   //予想
	   String[] name = {"太郎","二郎","三郎"};
	   //実行結果
	   int result = skdao.StatusOUT(name);
	   
	   System.out.println(result);
	   assertEquals(3,result);
	}
}
