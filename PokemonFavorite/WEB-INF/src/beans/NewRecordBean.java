package beans;

import java.io.Serializable;

public class NewRecordBean implements Serializable {
	private String name;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}