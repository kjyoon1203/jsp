package kr.or.ddit.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet(urlPatterns = "/contextPathInit", loadOnStartup = 1)
public class ContextPathInitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory.getLogger(ContextPathInitServlet.class);

	@Override
	public void init(ServletConfig config) throws ServletException {
		logger.debug("ContextPathInitServlet init()");
		
		ServletContext application = config.getServletContext();
		
		String cp = application.getContextPath();
		
		application.setAttribute("cp", cp);
	}

}
