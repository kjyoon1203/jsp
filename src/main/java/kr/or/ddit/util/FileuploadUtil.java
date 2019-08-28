package kr.or.ddit.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileuploadUtil {

	/**
	 * 
	* Method : getFileNameTest
	* 작성자 : PC-08
	* 변경이력 :
	* Method 설명 : content-disposition 헤더 문자열로부터 파일이름 추출
	 */
	public static String getFilename(String contentDisposition) {
		//메소드 인자: "form-data; name=\"file\"; filename=\"brown.png\""
		String[] str = contentDisposition.split("; ");
		String filename = "";
		for(String st : str) {
			if(st.startsWith("filename")) {
				String[] value = st.split("=");
				filename = value[1].substring(value[1].indexOf("\"")+1, value[1].lastIndexOf("\""));
				break;
			}
		}
		return filename;
	}

	/**
	 * 
	* Method : getFileNameTest
	* 작성자 : PC-08
	* 변경이력 :
	* Method 설명 : content-disposition 헤더 문자열로부터 파일확장자 추출 테스트
	 */
	public static String getFileExtension(String contentDisposition) {
		//메소드 인자: "form-data; name=\"file\"; filename=\"brown.png\""
		String filename = getFilename(contentDisposition);
		if(filename.lastIndexOf(".")>0)
			return filename.substring(filename.lastIndexOf("."));
		else
			return "";
		
//		String[] str = contentDisposition.split("; ");
//		String fileExtension = "";
//		for(String st : str) {
//			if(st.startsWith("filename")) {
//				String[] value = st.split("=");
//				if(value[1].contains(".")) {
//					fileExtension = value[1].substring(value[1].lastIndexOf(".")+1, value[1].lastIndexOf("\""));					
//				}else {
//					fileExtension = "";
//				}			
//				break;
//			}
//		}
//		
	}

	/**
	 * 
	* Method : getPath
	* 작성자 : PC-08
	* 변경이력 :
	* @return
	* Method 설명 : 파일을 업로드할 경로를 조회한다.
	 */
	public static String getPath() {
		String basicPath = "e:\\upload";
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
		String yyyyMM = sdf.format(new Date());
		
		String yyyy = yyyyMM.substring(0,4);
		String MM = yyyyMM.substring(4);
		
		File yyyyDirectory = new File(basicPath + "\\" + yyyy + "\\" + MM);
		if(!yyyyDirectory.exists())
			yyyyDirectory.mkdirs();
		
		// d:\\upload\\2019\\08\\
		return basicPath + "\\" + yyyy + "\\" + MM + "\\";
	}
}
