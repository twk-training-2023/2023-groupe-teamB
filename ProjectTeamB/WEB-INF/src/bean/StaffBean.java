package bean;

import java.io.Serializable;

public class StaffBean implements Serializable {
	private String name;
	private String lv;

	public void setName(String name) {
		this.name = name;
	}
	public void setLevel(String lv) {
		this.lv = lv;
	}
	public String getName() {
		return name;
	}
	public String getLevel() {
		return lv;
	}
}