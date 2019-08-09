package kr.or.ddit.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class CookieUtilTest {

	/**
	 * 
	* Method : getCookieTest
	* 작성자 : PC-08
	* 변경이력 :
	* Method 설명 : 쿠키 가져오기 테스트
	 */
	@Test
	public void getCookieTest() {
		/***Given***/
		String cookieString = "userId=brown; rememberMe=Y; test=testValue";

		/***When***/
		String userIdCookieValue = CookieUtil.getCookie(cookieString, "userId");
		String rememberMeCookieValue = CookieUtil.getCookie(cookieString, "rememberMe");
		String testCookieValue = CookieUtil.getCookie(cookieString, "test");
		String notExistCookieValue = CookieUtil.getCookie(cookieString, "notExistCookie");
		
		/***Then***/
		assertEquals("brown", userIdCookieValue);
		assertEquals("Y", rememberMeCookieValue);
		assertEquals("testValue", testCookieValue);
		assertEquals(null, notExistCookieValue);
	}

}
