package dao;

public class ConstList_Main {
	
	private final String url = "jdbc:postgresql://localhost:5432/devdb";
	private final String user = "postgres";
	private final String pass = "Kanikam7";
		
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
