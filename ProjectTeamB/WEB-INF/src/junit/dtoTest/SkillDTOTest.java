package junit.dtoTest;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

import bean.SkillBean;
import dto.SkillDTO;

public class SkillDTOTest {
	@Test
	public void test1() {
		SkillDTO dto = new SkillDTO();
		SkillBean bean;
		String name = "太郎";
		String skill = "Java";
		String name2 = "二郎";
		String skill2 = "Python";
		
		bean = new SkillBean();
		bean.setName(name);
		bean.setSkill_name(skill);
		dto.add(bean);
		
		bean = new SkillBean();
		bean.setName(name2);
		bean.setSkill_name(skill2);
		dto.add(bean);
		
		SkillBean sb = dto.get(0);
		assertEquals(skill,sb.getSkill_name());
	}
	@Test
	public void test2() {
		SkillDTO dto = new SkillDTO();
		SkillBean bean;
		String name = "太郎";
		String skill = "Java";
		String name2 = "二郎";
		String skill2 = "Python";
		
		bean = new SkillBean();
		bean.setName(name);
		bean.setSkill_name(skill);
		dto.add(bean);
		
		bean = new SkillBean();
		bean.setName(name2);
		bean.setSkill_name(skill2);
		dto.add(bean);
		
		assertEquals(2,dto.size());
	}
}
