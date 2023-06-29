package junit.dtoTest;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

import bean.MessageBean;
import dto.MessageDTO;

public class MessageDTOTest {
	@Test
	public void test1() {
		MessageDTO dto = new MessageDTO();
		MessageBean bean;
		String name = "太郎";
		String message = "こんにちは";
		String name2 = "二郎";
		String message2 = "こんばんは";
		
		bean = new MessageBean();
		bean.setName(name);
		bean.setMessage(message);
		dto.add(bean);
		
		bean = new MessageBean();
		bean.setName(name2);
		bean.setMessage(message2);
		dto.add(bean);
		
		MessageBean sb = dto.get(0);
		assertEquals(message,sb.getMessage());
	}
	@Test
	public void test2() {
		MessageDTO dto = new MessageDTO();
		MessageBean bean;
		String name = "太郎";
		String message = "こんにちは";
		String name2 = "二郎";
		String message2 = "こんばんは";
		
		bean = new MessageBean();
		bean.setName(name);
		bean.setMessage(message);
		dto.add(bean);
		
		bean = new MessageBean();
		bean.setName(name2);
		bean.setMessage(message2);
		dto.add(bean);
		
		assertEquals(2,dto.size());
	}
}
