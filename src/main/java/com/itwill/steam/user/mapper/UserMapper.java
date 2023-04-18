package com.itwill.steam.user.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.itwill.steam.user.User;

@Mapper
public interface UserMapper {
	
	public int createUser(User user);
	public int updateUser(User user);
	public int removeUser(int uNo);
	public int existedUser(String userId);
	public int idPwMatch(Map<String,Object> map);
	public User findUserById(String userId);
	public User findUserByNo(int uNo);
	public User findUserByNo2(int uNo);
	public List<User> findAllUser();
	
}
