package junit.beanTest;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

import bean.MySelfBean;

public class MySelfBeanTest {
	@Test
	public void test1()throws Exception {
		MySelfBean bean = new MySelfBean();
		String num = "太郎";
		bean.setName(num);
		String ans = bean.getName();
		assertEquals(ans, num);
	}
	@Test
	public void test2()throws Exception {
		MySelfBean bean = new MySelfBean();
		String num = "私は太郎";
		bean.setMySelf(num);
		String ans = bean.getMySelf();
		assertEquals(ans, num);
	}
}
