package dto;

import java.io.Serializable;
import java.util.ArrayList;

import beans.SearchBean;

public class SearchDTO implements Serializable{
	  private ArrayList<SearchBean> list;

	  public SearchDTO(){
	    list = new ArrayList<SearchBean>();
	  }
	  public void add(SearchBean sbe){
	    list.add(sbe);
	  }
	  public SearchBean get(int i){
	    return list.get(i);
	  }
	  public int size(){
	    return list.size();
	  }
	} 