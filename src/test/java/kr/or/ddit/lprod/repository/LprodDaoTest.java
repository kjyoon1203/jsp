package kr.or.ddit.lprod.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.lprod.model.LprodVO;

public class LprodDaoTest {

	/**
	 * 
	* Method : getAllListTest
	* 작성자 : PC-08
	* 변경이력 :
	* Method 설명 : getAllList 테스트
	 */
	@Test
	public void getAllListTest() {
		/***Given***/
		ILprodDao lprodDao = new LprodDaoImpl();

		/***When***/
		List<LprodVO> lprodList = lprodDao.getAllList();

		/***Then***/
		assertEquals(10, lprodList.size());
	}
	
	/**
	 * 
	* Method : getProdListTest
	* 작성자 : PC-08
	* 변경이력 :
	* Method 설명 : getProdList 테스트
	 */
	@Test
	public void getProdListTest() {
		/***Given***/
		String prod_lgu = "P101";
		ILprodDao lprodDao = new LprodDaoImpl();

		/***When***/
		List<Map> prodList = lprodDao.getProdList(prod_lgu);

		/***Then***/
		assertEquals(6, prodList.size());
	}
	
	@Test
	public void getLprodPagingListTest() {
		/***Given***/
		Page page = new Page();
		page.setPage(1);
		page.setPagesize(5);
		ILprodDao dao = new LprodDaoImpl();
		
		/***When***/
		List<LprodVO> list = dao.getLprodPagingList(page);

		/***Then***/
		assertEquals(5, list.size());
	}

	@Test
	public void getLprodTotalCntTest() {
		/***Given***/
		ILprodDao dao = new LprodDaoImpl();

		/***When***/
		int totalCnt = dao.getLprodTotalCnt();

		/***Then***/
		assertEquals(10, totalCnt);
	}
}
