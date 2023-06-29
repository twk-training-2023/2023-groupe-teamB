package junit.dtoTest;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

import bean.MySelfBean;
import dto.MyselfDTO;

public class MyselfDTOTest {
	@Test
	public void test1() {
		MyselfDTO dto = new MyselfDTO();
		MySelfBean bean;
		String name = "太郎";
		String myself = "こんにちは";
		String name2 = "二郎";
		String myself2 = "こんばんは";
		
		bean = new MySelfBean();
		bean.setName(name);
		bean.setMySelf(myself);
		dto.add(bean);
		
		bean = new MySelfBean();
		bean.setName(name2);
		bean.setMySelf(myself2);
		dto.add(bean);
		
		MySelfBean sb = dto.get(0);
		assertEquals(myself,sb.getMySelf());
	}
	@Test
	public void test2() {
		MyselfDTO dto = new MyselfDTO();
		MySelfBean bean;
		String name = "太郎";
		String myself = "こんにちは";
		String name2 = "二郎";
		String myself2 = "こんばんは";
		
		bean = new MySelfBean();
		bean.setName(name);
		bean.setMySelf(myself);
		dto.add(bean);
		
		bean = new MySelfBean();
		bean.setName(name2);
		bean.setMySelf(myself2);
		dto.add(bean);
		
		assertEquals(2,dto.size());
	}
}
