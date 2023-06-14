package dto;

import java.io.Serializable;
import java.util.ArrayList;

import beans.ReasonBean;

public class ReasonDTO implements Serializable{
	  private ArrayList<ReasonBean> list;

	  public ReasonDTO(){
	    list = new ArrayList<ReasonBean>();
	  }
	  public void add(ReasonBean rbe){
	    list.add(rbe);
	  }
	  public ReasonBean get(int i){
	    return list.get(i);
	  }
	  public int size(){
	    return list.size();
	  }
	} 