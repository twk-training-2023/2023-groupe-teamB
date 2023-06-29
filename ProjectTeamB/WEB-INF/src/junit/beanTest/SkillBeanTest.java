package junit.beanTest;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

import bean.SkillBean;

public class SkillBeanTest {

	@Test
	public void test1()throws Exception {
		SkillBean bean = new SkillBean();
		String num = "太郎";
		bean.setName(num);
		String ans = bean.getName();
		assertEquals(ans, num);
	}
	@Test
	public void test2()throws Exception {
		SkillBean bean = new SkillBean();
		String num = "Java";
		bean.setSkill_name(num);
		String ans = bean.getSkill_name();
		assertEquals(ans, num);
	}
	@Test
	public void test3()throws Exception {
		SkillBean bean = new SkillBean();
		int num = 1;
		bean.setSkill_lv(num);
		int ans = bean.getSkill_lv();
		assertEquals(ans, num);
	}
	@Test
	public void test4()throws Exception {
		SkillBean bean = new SkillBean();
		String num = "得意です。";
		bean.setSkill_appeal(num);
		String ans = bean.getSkill_appeal();
		assertEquals(ans, num);
	}
	@Test
	public void test5()throws Exception {
		SkillBean bean = new SkillBean();
		int num = 0;
		bean.setStatus(num);
		int ans = bean.getStatus();
		assertEquals(ans, num);
	}
}
