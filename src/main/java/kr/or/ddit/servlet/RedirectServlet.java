package kr.or.ddit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * web.xml <servlet></servlet>, <servlet-mapping></servlet-mapping>설정을 
 * @WebServlet을 통해 대체
 */
@WebServlet("/redirectServlet")
public class RedirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// localhost: 8081/redirectServlet get => doGet 호출
	// 웹브라우저 주소줄에 url을 입력하고 엔터를 입력하면 get 방식의 요청
	
	// redirectForm.jsp에게 응답 생성을 위임
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// print writer 객체를 이용하여 html 코드를 직접 작성하는 것이 아니라 화면을 생성하는 jsp에게 요청을 위임
		
		// dispatch 방식으로 위임
		// context path를 적어주지 않는다.
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/redirectForm.jsp");
		rd.forward(request, response);
		
		// 1. http://localhost:8081/redirectServlet
		
		// 2. was(tomcat)이 /redirectServlet url을 처리 해줄수 있는 servlet을 찾는다
		// 	mapping 
		// 	1. web.xml
		// 	2. @WebServlet
		
		// 3. 찾은 servlet의 service 메소드를 호출 
		
		// 4. service 메소드에서는 요청 객체의 메소드에 따라 (request.getMethod) doXXX(request, response) 메소드를 호출
		// **위 예제의 경우 웹브라우저 주소줄에 url을 입력했기 때문에 GET요청이 되고 doGet 메소드가 호출된다
		
		// 5. 서블릿이 직접 응답을 생성하는 것이 아니라 화면 생성을 담당하는 jsp파일에게 요청 위임
		
		/*
		 java 웹 개발
		 요청 처리 model1, model2
		 
		  medol1: 요청을 jsp가 받는 경우
		  		- 초기 개발시 속도 빠름
		  		- 유지보수시 문제(코드 중복, 재사용 힘듦)
		  
		  model2: 요청을 servlet이 받는 경우
		  		(servlet -> jsp 위임)
		 */
	}

	// localhost: 8081/redirectServlet post => doPost 호출
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// login 화면으로 리다이렉트
		
		// 메소드 인자로 웹브라우저 주소줄에 입력할 url을 작성
		// context path가 root가 아니면 context path를 같이 적어줘야 한다.
		response.sendRedirect(request.getContextPath() +"/jsp/login.jsp");
		
	}

}
