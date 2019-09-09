package kr.or.ddit.user.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.encrypt.kisa.sha256.KISA_SHA256;

public class User implements HttpSessionBindingListener {
	private String userNM;	// 사용자 이름
	private String pass;	// 비밀번호
	private String userId;	// 아이디
	private String alias;	// 별명
	private Date reg_dt;	// 등록일
	private String addr1;	// 주소1
	private String addr2;	// 주소2
	private String zipcode;	// 우편번호
	private String filename;
	private String realfilename;
	private String realfilename2;
	private static final Logger logger = LoggerFactory.getLogger(User.class);
	
	public User() {
	}
	
	public User(String userId, String userNm, String alias, Date reg_dt, String addr1, String addr2,
			String zipcode, String pass, String filename, String realfilename) {
		this.userId = userId;
		this.userNM = userNm;
		this.alias = alias;
		this.reg_dt = reg_dt;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.pass = pass;
		this.zipcode = zipcode;
		this.filename = filename;
		this.realfilename = realfilename;
	}
	
	public String getRealfilename2() {
		return realfilename2;
	}

	public void setRealfilename2(String realfilename2) {
		this.realfilename2 = realfilename2;
	}

	public String getFilename() {
		return filename;
	}
	
	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	public String getRealfilename() {
		return realfilename;
	}
	
	public void setRealfilename(String realfilename) {
		this.realfilename = realfilename;
	}
	
	public String getAddr1() {
		return addr1;
	}
	
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	
	public String getAddr2() {
		return addr2;
	}
	
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	
	public String getZipcode() {
		return zipcode;
	}
	
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
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

	public String getUserNM() {
		return userNM;
	}

	public void setUserNM(String userNM) {
		this.userNM = userNM;
	}

	
	@Override
	public String toString() {
		return "User [userNM=" + userNM + ", pass=" + pass + ", userId=" + userId + ", alias=" + alias + ", reg_dt="
				+ reg_dt + ", addr1=" + addr1 + ", addr2=" + addr2 + ", zipcode=" + zipcode + ", filename=" + filename
				+ ", realfilename=" + realfilename + "]";
	}

	public boolean checkLoginValidate(String userId, String pass) {
		// 암호화 문장끼리 비교 (08/27)   KISA_SHA256.encrypt(pass)
		if(userId.equals(this.userId) && KISA_SHA256.encrypt(pass).equals(this.pass)) {
			return true;
		}
		return false;
	}

	@Override
   public void valueBound(HttpSessionBindingEvent event) {
      logger.debug("value bound");
   }

   @Override
   public void valueUnbound(HttpSessionBindingEvent event) {
      logger.debug("value unbound");
   }
}
