package junit.beanTest;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

import bean.StaffBean;

public class StaffBeanTest {
	@Test
	public void test1()throws Exception {
		StaffBean bean = new StaffBean();
		String num = "１";
		bean.setId(num);
		String ans = bean.getId();
		assertEquals(ans, num);
	}
	@Test
	public void test2()throws Exception {
		StaffBean bean = new StaffBean();
		String num = "太郎";
		bean.setName(num);
		String ans = bean.getName();
		assertEquals(ans, num);
	}
	@Test
	public void test3()throws Exception {
		StaffBean bean = new StaffBean();
		String num = "test@gmail.com";
		bean.setEmail(num);
		String ans = bean.getEmail();
		assertEquals(ans, num);
	}
	@Test
	public void test4()throws Exception {
		StaffBean bean = new StaffBean();
		String num = "@test1111";
		bean.setPass(num);
		String ans = bean.getPass();
		assertEquals(ans, num);
	}
	@Test
	public void test5()throws Exception {
		StaffBean bean = new StaffBean();
		int num = 5;
		bean.setStaff_lv(num);
		int ans = bean.getStaff_lv();
		assertEquals(ans, num);
	}
	@Test
	public void test6()throws Exception {
		StaffBean bean = new StaffBean();
		String num = "Java";
		bean.setSkill_name(num);
		String ans = bean.getSkill_name();
		assertEquals(ans, num);
	}
	@Test
	public void test7()throws Exception {
		StaffBean bean = new StaffBean();
		int num = 5;
		bean.setSkill_lv(num);
		int ans = bean.getSkill_lv();
		assertEquals(ans, num);
	}
	@Test
	public void test8()throws Exception {
		StaffBean bean = new StaffBean();
		String num = "勉強しました";
		bean.setSkill_appeal(num);
		String ans = bean.getSkill_appeal();
		assertEquals(ans, num);
	}
	@Test
	public void test9()throws Exception {
		StaffBean bean = new StaffBean();
		String num = "私は太郎";
		bean.setMyself(num);
		String ans = bean.getMyself();
		assertEquals(ans, num);
	}
	@Test
	public void test10()throws Exception {
		StaffBean bean = new StaffBean();
		String num = "承認";
		bean.setStatus(num);
		String ans = bean.getStatus();
		assertEquals(ans, num);
	}
}
