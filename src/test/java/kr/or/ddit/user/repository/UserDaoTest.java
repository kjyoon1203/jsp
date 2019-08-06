package kr.or.ddit.user.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import kr.or.ddit.user.model.UserVo;

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
		List<UserVo> userList = userDao.getUserList();
		
		/***Then***/
		assertEquals(5, userList.size());
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
		UserVo userVo = userDao.getUser(userId);

		/***Then***/
		assertEquals("브라운", userVo.getUserName());
		assertEquals("brown1234", userVo.getPass());
	}

}
