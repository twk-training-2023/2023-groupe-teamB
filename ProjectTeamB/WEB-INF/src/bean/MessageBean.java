package bean;

import java.io.Serializable;

public class MessageBean implements Serializable {
	int contact_num;
	String name;
	String message;
	
	public void setContact_num(int contact_num) { this.contact_num = contact_num;}
	public void setName(String name) { this.name = name;}
	public void setMessage(String message) { this.message = message;}
	
	public int getContact_num() { return contact_num;}
	public String getName() { return name;}
	public String getMessage() { return message;}
	
}
