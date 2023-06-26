package dto;

import java.io.Serializable;
import java.util.ArrayList;

import bean.MessageBean;

public class MessageDTO implements Serializable{
	  private ArrayList<MessageBean> list;

	  public MessageDTO(){
	    list = new ArrayList<MessageBean>();
	  }
	  public void add(MessageBean mebe){
	    list.add(mebe);
	  }
	  public MessageBean get(int i){
	    return list.get(i);
	  }
	  public int size(){
	    return list.size();
	  }
} 
