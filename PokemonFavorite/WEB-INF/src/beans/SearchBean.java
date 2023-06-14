package beans;

import java.io.Serializable;

public class SearchBean implements Serializable{
	private String name;
	private String type1;
	private String type2;
	
	public void setName(String name){
	    this.name = name;
	  }
	  public void settype1(String type1){
	    this.type1 = type1;
	  }
	  public void settype2(String type2){
	    this.type2 = type2;
	  }
	  public String getName(){
	    return name;
	  }
	  public String gettype1(){
	    return type1;
	  }
	  public String gettype2(){
	    return type2;
	  }
}