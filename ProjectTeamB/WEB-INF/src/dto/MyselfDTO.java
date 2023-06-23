package dto;

import java.io.Serializable;
import java.util.ArrayList;

public class MyselfDTO implements Serializable {
	private ArrayList<MyselfBean> list;

	public MyselfDTO() {
		list = new ArrayList<MyselfBean>();
	}

	public void add(MyselfBean mybe) {
		list.add(mybe);
	}

	public MyselfBean get(int i) {
		return list.get(i);
	}

	public int size() {
		return list.size();
	}
}
