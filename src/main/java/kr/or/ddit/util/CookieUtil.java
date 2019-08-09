package kr.or.ddit.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CookieUtil {

	/**
	 * 
	* Method : getCookie
	* 작성자 : PC-08
	* 변경이력 :
	* @param cookieString
	* @param string
	* @return
	* Method 설명 : 쿠키 문자열로부터 특정 쿠키의 값을 변환한다
	 */
	public static String getCookie(String cookieString, String cookieId) {
		String[] temp = cookieString.split("; ");
		for(int i=0; i<temp.length; i++) {
			String[] nameValue= temp[i].split("=");
			if(nameValue[0].equals(cookieId)) {
				return nameValue[1];
			}
		}				
		return null;
	}

}
