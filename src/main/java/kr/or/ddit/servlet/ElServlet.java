package kr.or.ddit.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.Request;


@WebServlet("/elScope")
public class ElServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// el scope 테스트 진행할 화면으로 위임
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/el/elInput.jsp").forward(req, resp);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String req = request.getParameter("req");
		String session = request.getParameter("session");
		String application = request.getParameter("application");
		
		// 세가지 scope에 같은 속성이름으로 다른 값을 저장(brown, cony, sally)
		// ${속성명} -> ${elScope}
		// 속성명만 표현하는 el 표기법에서 어떤 영역에 있는 값이 표현되는지 확인
		
		// brown -> cony -> sally 
		// scope가 작은 영역부터 해당이름의 속성이 있는지 확인
		request.setAttribute("elScope", req);
		request.getSession().setAttribute("elScope", session);
		getServletContext().setAttribute("elScope", application);
		
		request.getRequestDispatcher("/el/elResult.jsp").forward(request, response);
		
	}

}