package dto;

import java.io.Serializable;
import java.util.ArrayList;

import bean.SkillBean;

public class SkillDTO implements Serializable {
	private ArrayList<SkillBean> list;

	public SkillDTO() {
		list = new ArrayList<SkillBean>();
	}

	public void add(SkillBean skbe) {
		list.add(skbe);
	}

	public SkillBean get(int i) {
		return list.get(i);
	}

	public int size() {
		return list.size();
	}
}
