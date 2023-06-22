package bean;

import java.io.Serializable;

public class SkillBean implements Serializable {
	String name;
	String skill_name;
	Integer skill_lv;
	String skill_appeal;
	Integer status;
	
	public void setName(String name) { this.name = name;}
	public void setSkill_name(String skill_name) { this.skill_name = skill_name;}
	public void setSkill_lv(Integer skill_lv) { this.skill_lv = skill_lv;}
	public void setSkill_appeal(String skill_appeal) { this.skill_appeal = skill_appeal;}
	public void setStatus(Integer status) { this.status = status;}
	
	public String getName() { return name;}
	public String getSkill_name() { return skill_name;}
	public Integer getSkill_lv() { return skill_lv;}
	public String getSkill_appeal() { return skill_appeal;}
	public Integer getStatus() { return status;}
	
}
