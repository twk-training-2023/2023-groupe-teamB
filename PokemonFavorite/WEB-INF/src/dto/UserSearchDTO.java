package dto;

import java.io.Serializable;
import java.util.ArrayList;

import beans.UserSearchBean;

public class UserSearchDTO implements Serializable{
	  private ArrayList<UserSearchBean> list;

	  public UserSearchDTO(){
	    list = new ArrayList<UserSearchBean>();
	  }
	  public void add(UserSearchBean usbe){
	    list.add(usbe);
	  }
	  public UserSearchBean get(int i){
	    return list.get(i);
	  }
	  public int size(){
	    return list.size();
	  }
	} 