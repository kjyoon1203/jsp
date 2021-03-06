package kr.or.ddit.lprod.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.lprod.model.LprodVO;
import kr.or.ddit.util.MybatisUtil;

public class LprodDaoImpl implements ILprodDao {

	@Override
	public List<LprodVO> getAllList() {
		SqlSession sqlSession = MybatisUtil.getSession();
		List<LprodVO> lprodList = sqlSession.selectList("lprod.getAllList");
		sqlSession.close();
		
		return lprodList;
	}

	@Override
	public List<Map> getProdList(String prod_lgu) {
		SqlSession sqlSession = MybatisUtil.getSession();
		List<Map> prodList = sqlSession.selectList("lprod.getProdList", prod_lgu);
		sqlSession.close();
		
		return prodList;
	}

	@Override
	public List<LprodVO> getLprodPagingList(Page page) {
		SqlSession sqlSession = MybatisUtil.getSession();
		List<LprodVO> lprodList = sqlSession.selectList("lprod.getLprodPagingList", page);
		sqlSession.close();
		
		return lprodList;
	}

	@Override
	public int getLprodTotalCnt() {
		SqlSession sqlSession = MybatisUtil.getSession();
		int totalCnt = sqlSession.selectOne("lprod.getLprodTotalCnt");
		sqlSession.close();
		
		return totalCnt;
	}

}
