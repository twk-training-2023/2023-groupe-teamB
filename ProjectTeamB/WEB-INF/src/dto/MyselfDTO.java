package dto;

import java.io.Serializable;
import java.util.ArrayList;

import bean.MySelfBean;

public class MyselfDTO implements Serializable {
	private ArrayList<MySelfBean> list;

	public MyselfDTO() {
		list = new ArrayList<MySelfBean>();
	}

	public void add(MySelfBean mybe) {
		list.add(mybe);
	}

	public MySelfBean get(int i) {
		return list.get(i);
	}

	public int size() {
		return list.size();
	}
}
