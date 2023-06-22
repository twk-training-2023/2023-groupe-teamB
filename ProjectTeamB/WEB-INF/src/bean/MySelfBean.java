package bean;

import java.io.Serializable;

public class MySelfBean implements Serializable {
	String name;
	String myself;
	
	public void setName(String name) { this.name = name;}
	public void setMySelf(String myself) { this.myself = myself;}
	
	public String getName() { return name;}
	public String getMySelf() { return myself;}
	
}
