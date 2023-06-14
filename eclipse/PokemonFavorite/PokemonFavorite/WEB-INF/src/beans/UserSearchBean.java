package beans;

import java.io.Serializable;

public class UserSearchBean implements Serializable {
	private Boolean check;
	private String user;
	private String pass;

	public void setBoolean(Boolean check) {
		this.check = check;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public Boolean getBoolean() {
		return check;
	}
	public String getUser() {
		return user;
	}

	public String getPass() {
		return pass;
	}

	
}