package kr.or.ddit.user.model;

public class UserVo {
	private String userName;	// 사용자 이름
	private String pass;
	private String userId;

	public UserVo() {
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

	public UserVo(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "UserVo [userName=" + userName + ", pass=" + pass + ", userId=" + userId + "]";
	}
	
}
