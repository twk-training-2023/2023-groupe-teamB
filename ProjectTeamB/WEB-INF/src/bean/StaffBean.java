package bean;

import java.io.Serializable;

public class StaffBean implements Serializable {
	private String id;
	private String name;
	private String email;
	private String pass;
	private Integer staff_lv;
	private String skill_name;
	private Integer skill_lv;
	private String skill_appeal;
	private String myself;
	
	public void setId(String id) { this.id = id;}
	public void setName(String name) { this.name = name;}
	public void setEmail(String email) { this.email = email;}
	public void setPass(String pass) { this.pass = pass;}
	public void setStaff_lv(Integer staff_lv) { this.staff_lv = staff_lv;}
	public void setSkill_name(String skill_name) { this.skill_name = skill_name;}
	public void setSkill_lv(Integer skill_lv) { this.skill_lv = skill_lv;}
	public void setSkill_appeal(String skill_appeal) { this.skill_appeal = skill_appeal;}
	public void setMyself(String myself) { this.myself = myself;}
	
	
	public String getId() { return id;}
	public String getName() { return name;}
	public String getEmail() { return email;}
	public String getPass() { return pass;}
	public Integer getStaff_lv() { return staff_lv;}
	public String getSkill_name() { return skill_name;}
	public Integer getSkill_lv() { return skill_lv;}
	public String getSkill_appeal() { return skill_appeal;}
	public String getMyself() { return myself;}
	
}