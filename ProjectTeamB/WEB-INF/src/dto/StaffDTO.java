package dto;

import java.io.Serializable;
import java.util.ArrayList;

import bean.StaffBean;

public class StaffDTO implements Serializable{
	  private ArrayList<StaffBean> list;

	  public StaffDTO(){
	    list = new ArrayList<StaffBean>();
	  }
	  public void add(StaffBean stbe){
	    list.add(stbe);
	  }
	  public StaffBean get(int i){
	    return list.get(i);
	  }
	  public int size(){
	    return list.size();
	  }
	} 