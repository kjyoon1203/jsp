package kr.or.ddit.user.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import kr.or.ddit.user.model.User;

// JUnit에서는 해당 메소드에 커서를 놓고 Ctrl + F11을 누르면 해당 메소드만 실행됨
public class UserDaoTest {

	/**
	 * 
	* Method : getUserListTest
	* 작성자 : PC-08
	* 변경이력 :
	* Method 설명 : getUserList 테스트
	 */
	@Test
	public void getUserListTest() {
		/***Given***/
		IUserDao userDao = new UserDao();

		/***When***/
		List<User> userList = userDao.getUserList();
		
		/***Then***/
		assertEquals(105, userList.size());
	}
	
	/**
	 * 
	* Method : getUserTest
	* 작성자 : PC-08
	* 변경이력 :
	* Method 설명 : 사용자 정보 조회 테스트
	 */
	@Test
	public void getUserTest() {
		/***Given***/
		String userId = "brown";
		IUserDao userDao = new UserDao();

		/***When***/
		User userVo = userDao.getUser(userId);

		/***Then***/
		assertEquals("브라운", userVo.getUserName());
		assertEquals("brown1234", userVo.getPass());
	}
	
	/**
	 * 
	* Method : getUserListHalf
	* 작성자 : PC-08
	* 변경이력 :
	* Method 설명 : getUserListHalf 테스트
	 */
	@Test
	public void getUserListOnlyHalfTest() {
		/***Given***/
		IUserDao userDao = new UserDao();

		/***When***/
		List<User> userListHalf = userDao.getUserListOnlyHalf();
		
		/***Then***/
		assertEquals(50, userListHalf.size());
	}

}
