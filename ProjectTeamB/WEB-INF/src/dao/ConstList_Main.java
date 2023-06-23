package dao;

public class ConstList_Main {
	
	private final String url = "jdbc:postgresql://localhost:5432/exam";
	private final String user = "login";
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
