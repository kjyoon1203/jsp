package kr.or.ddit.user.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.user.model.User;

public interface IUserService {
	public List<User> getUserList();
	
	public User getUser(String userId);

	public List<User> getUserListOnlyHalf();

	public Map<String, Object> getUserPagingList(Page page);
	
}
