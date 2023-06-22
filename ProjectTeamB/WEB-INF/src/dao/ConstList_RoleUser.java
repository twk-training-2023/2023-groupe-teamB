package dao;

public class ConstList_RoleUser {
	
	private final String url = "jdbc:postgresql://localhost:5432/exam";
	private final String user = "teamb";
	private final String pass = "abc";
		
	public String getUrl() {
		return this.url;
	}
	
	public String getUser() {
		return this.user;
	}
	
	public String getPass() {
		return this.pass;
	}
}
