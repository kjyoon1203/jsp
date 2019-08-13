package kr.or.ddit.lprod.repository;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

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

}
