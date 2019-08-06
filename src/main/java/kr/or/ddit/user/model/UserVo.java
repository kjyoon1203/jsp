package kr.or.ddit.user.model;

public class UserVo {
	private String userNM;	// 사용자 이름
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
		this.userNM = userName;
	}

	public String getUserName() {
		return userNM;
	}

	public void setUserName(String userName) {
		this.userNM = userName;
	}

	@Override
	public String toString() {
		return "UserVo [userName=" + userNM + ", pass=" + pass + ", userId=" + userId + "]";
	}
	
}
