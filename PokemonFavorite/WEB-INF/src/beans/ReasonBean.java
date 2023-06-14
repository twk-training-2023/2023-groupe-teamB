package beans;

import java.io.Serializable;

public class ReasonBean implements Serializable {
	private String username;
	private String pkmn;
	private String reason;
	private String flg;

	public void setName(String username) {
		this.username = username;
	}

	public void setPKMN(String pkmn) {
		this.pkmn = pkmn;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public void setFlg(String flg) {
		this.flg = flg;
	}

	public String getName() {
		return username;
	}

	public String getPKMN() {
		return pkmn;
	}

	public String getReason() {
		return reason;
	}
	

	public String getFlg() {
		return flg;
	}

}