package junit.dtoTest;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

import bean.StaffBean;
import dto.StaffDTO;

public class StaffDTOTest {
	@Test
	public void test1()throws Exception {
		StaffDTO dto = new StaffDTO();
		StaffBean bean;
		String name = "太郎";
		String mail = "test@gmail.com";
		String name2 = "二郎";
		String mail2 = "test2@gmail.com";
		
		bean = new StaffBean();
		bean.setName(name);
		bean.setEmail(mail);
		dto.add(bean);
		
		bean = new StaffBean();
		bean.setName(name2);
		bean.setEmail(mail2);
		dto.add(bean);
		
		StaffBean sb = dto.get(0);
		assertEquals(name,sb.getName());
	}
	@Test
	public void test2()throws Exception {
		StaffDTO dto = new StaffDTO();
		StaffBean bean;
		String name = "太郎";
		String mail = "test@gmail.com";
		String name2 = "二郎";
		String mail2 = "test2@gmail.com";
		
		bean = new StaffBean();
		bean.setName(name);
		bean.setEmail(mail);
		dto.add(bean);
		
		bean = new StaffBean();
		bean.setName(name2);
		bean.setEmail(mail2);
		dto.add(bean);
		
		assertEquals(2,dto.size());
	}
}
