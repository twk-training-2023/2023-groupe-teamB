package junit.beanTest;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

import bean.MessageBean;

public class MessageBeanTest {

	@Test
	public void test1()throws Exception {
		MessageBean bean = new MessageBean();
		int num = 5;
		bean.setContact_num(num);
		int ans = bean.getContact_num();
		assertEquals(ans, num);
	}
	@Test
	public void test2()throws Exception {
		MessageBean bean = new MessageBean();
		String num = "太郎";
		bean.setName(num);
		String ans = bean.getName();
		assertEquals(ans, num);
	}
	@Test
	public void test3()throws Exception {
		MessageBean bean = new MessageBean();
		String num = "こんにちは";
		bean.setMessage(num);
		String ans = bean.getMessage();
		assertEquals(ans, num);
	}
}
