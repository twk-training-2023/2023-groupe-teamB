package dto;

import java.io.Serializable;
import java.util.ArrayList;

import beans.NewRecordBean;

public class NewRecordDTO implements Serializable{
	  private ArrayList<NewRecordBean> list;

	  public NewRecordDTO(){
	    list = new ArrayList<NewRecordBean>();
	  }
	  public void add(NewRecordBean nrbe){
	    list.add(nrbe);
	  }
	  public NewRecordBean get(int i){
	    return list.get(i);
	  }
	  public int size(){
	    return list.size();
	  }
	} 