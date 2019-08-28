package kr.or.ddit.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FileuploadUtilTest {

	/**
	 * 
	* Method : getFileNameTest
	* 작성자 : PC-08
	* 변경이력 :
	* Method 설명 : content-disposition 헤더 문자열로부터 파일이름 추출 테스트
	 */
	@Test
	public void getFileNameTest() {
		/***Given***/
		String contentDisposition = "form-data; name=\"file\"; filename=\"brown.png\"";

		/***When***/
		String filename = FileuploadUtil.getFilename(contentDisposition);
		
		/***Then***/
		assertEquals("brown.png", filename);
	}
	
	/**
	 * 
	* Method : getFileNameTest
	* 작성자 : PC-08
	* 변경이력 :
	* Method 설명 : content-disposition 헤더 문자열로부터 파일확장자 추출 테스트
	 */
	@Test
	public void getFileExtensionTest() {
		/***Given***/
		String contentDisposition = "form-data; name=\"file\"; filename=\"brown.png\"";
		String contentDisposition2 = "form-data; name=\"file\"; filename=\"brown\"";
		String contentDisposition3 = "form-data; name=\"file\"; filename=\"brown.xx.jpg\"";

		/***When***/
		String fileExtensionName = FileuploadUtil.getFileExtension(contentDisposition);
		String fileExtensionName2 = FileuploadUtil.getFileExtension(contentDisposition2);
		String fileExtensionName3 = FileuploadUtil.getFileExtension(contentDisposition3);
		
		/***Then***/
		assertEquals(".png", fileExtensionName);
		assertEquals("", fileExtensionName2);
		assertEquals(".jpg", fileExtensionName3);
	}

	/**
	 * 
	* Method : getPathTest
	* 작성자 : PC-08
	* 변경이력 :
	* Method 설명 : 파일 업로드 경로 조회하기 테스트
	 */
	@Test
	public void getPathTest() {
		/***Given***/
		

		/***When***/
		String path = FileuploadUtil.getPath();
		
		/***Then***/
		assertEquals("e:\\upload\\2019\\08\\", path);
	}
}
