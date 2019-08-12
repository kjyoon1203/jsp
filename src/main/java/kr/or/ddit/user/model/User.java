package kr.or.ddit.user.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class User {
	private String userNM;	// 사용자 이름
	private String pass;
	private String userId;
	private String alias;	// 별명
	private Date reg_dt;	// 등록일
	
	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public Date getReg_dt() {
		return reg_dt;
	}

	public void setReg_dt(Date reg_dt) {
		this.reg_dt = reg_dt;
	}
	
	public String getReg_dt_fmt() {
		SimpleDateFormat sdf = new SimpleDateFormat();
		return sdf.format(reg_dt);
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userNM;
	}

	public void setUserName(String userName) {
		this.userNM = userName;
	}

	@Override
	public String toString() {
		return "UserVo [userNM=" + userNM + ", pass=" + pass + ", userId=" + userId + "]";
	}
	
	public boolean checkLoginValidate(String userId, String pass) {
		if(userId.equals(this.userId) && pass.equals(this.pass)) {
			return true;
		}
		return false;
	}
}
