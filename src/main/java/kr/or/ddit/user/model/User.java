package kr.or.ddit.user.model;

public class User {
	private String userNM;	// 사용자 이름
	private String pass;
	private String userId;

	public User() {
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

	public User(String userName) {
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
	
	public boolean checkLoginValidate(String userId, String pass) {
		if(userId.equals(this.userId) && pass.equals(this.pass)) {
			return true;
		}
		return false;
	}
}
