package kr.or.ddit.encrypt.kisa.aria;

import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AriaUtilTest {

	private static final Logger logger = LoggerFactory.getLogger(AriaUtilTest.class);

	/**
	 * 
	* Method : encryptDecryptTest
	* 작성자 : 202-01
	* 변경이력 :
	* Method 설명 : aria 블록 암호화/복호화 테스트
	 * @throws UnsupportedEncodingException 
	 * @throws InvalidKeyException 
	 */
	@Test
	public void encryptDecryptTest() throws InvalidKeyException, UnsupportedEncodingException {
		/***Given***/
		String userId = "browm";

		/***When***/
		String encryptedText = ARIAUtil.ariaEncrypt(userId);
		String decryptedText = ARIAUtil.ariaDecrypt(encryptedText);

		logger.debug("encryptedText : {}", encryptedText);
		logger.debug("decryptedText : {}", decryptedText);

		System.out.println(encryptedText);  // => 8BD6D0715B662698EF2642364FF9425C   //   85F0C43065A727B5F5B38154277756F6
		System.out.println(decryptedText);  // => brown								 //   browm (문자 하나변경에 따른 암호화 변경 상태 확인)

		/***Then***/
		assertEquals(userId, decryptedText);
	}

}