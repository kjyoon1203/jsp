package kr.or.ddit.lprod.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.lprod.model.LprodVO;
import kr.or.ddit.lprod.repository.ILprodDao;
import kr.or.ddit.lprod.repository.LprodDaoImpl;

/**
 * Servlet implementation class LprodPagingListController
 */
@WebServlet("/lprodPagingList")
public class LprodPagingListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(LprodPagingListController.class);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ILprodDao dao = new LprodDaoImpl();
		
		String pageStr = request.getParameter("page");
		String pagesizeStr = request.getParameter("pagesize");
		
		int page = pageStr == null ? 1:Integer.parseInt(pageStr);
		int pagesize = pagesizeStr == null ? 5:Integer.parseInt(pagesizeStr);
		
		Page p = new Page(page, pagesize);
		request.setAttribute("pageVo", p);
		List<LprodVO> lprodList = dao.getLprodPagingList(p);

		int totalCnt = dao.getLprodTotalCnt();
		
		int paginationSize = (int)Math.ceil((double)totalCnt/p.getPagesize());
		
		logger.debug("lprodList size : {}",lprodList.size());
		
		request.setAttribute("lprodList", lprodList);
		request.setAttribute("paginationSize", paginationSize);
		
		request.getRequestDispatcher("/lprod/lprodPagingList.jsp").forward(request, response);
		
	}

}
