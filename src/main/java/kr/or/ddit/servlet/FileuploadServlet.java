package kr.or.ddit.servlet;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.util.FileuploadUtil;
/*
 * maxRequstSize : 요청 최대 크기
 * maxFileSize : 파일당 최대 크기
 * 
 * 파일 최대 크기 : 5메가, 요청당 최대 5개 파일(25메가)
 * 1024(byte) * 1024 = 1메가
 */

@WebServlet("/fileupload")
@MultipartConfig(maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class FileuploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(FileuploadServlet.class);
	
	// view 요청처리
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/jsp/fileupload.jsp").forward(req, resp);
	}
	
	// form submit 처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String userId = request.getParameter("userId");
		String file = request.getParameter("file");
		
		Part part = request.getPart("file");
		part.getName();			// 업로드 파라미터명 (input의 name 속성)
		part.getContentType();	//
		part.getSize();			// 파일 사이즈
		part.getHeader("Content-Disposition");
		
		logger.debug("userId: {}", userId);
		logger.debug("file: {}", file);
		
		logger.debug("part.getName(): {}", part.getName());
		logger.debug("part.getContentType(): {}", part.getContentType());
		logger.debug("part.getSize(): {}", part.getSize());
		logger.debug("Header Content-Disposition: {}", part.getHeader("Content-Disposition"));
		
		// 어떤 파일을 업로드 해도 파일명이 brownupload.png로 고정 -> 실제 업로드한 파일명으로 수정 form-data; name="file"; filename="brown.png"
		// part.write("E:\\upload\\" + FileuploadUtil.getFilename(part.getHeader("Content-Disposition")));
		// E:\\upload\\ 폴더 하나에 모든 파일을 저장하고 있던 것을
		// 파일업로드 날짜의 년월 폴더를 체크하여 월단위로 파일을 관리
		// path: d:\\upload\\2019\\08
		
		String path = FileuploadUtil.getPath();
		part.write(path +UUID.randomUUID().toString() + 
					FileuploadUtil.getFileExtension(part.getHeader("Content-Disposition")));
		
		// 최초 view로 이동
		doGet(request, response);
	}

}
