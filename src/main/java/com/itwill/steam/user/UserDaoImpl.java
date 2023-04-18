package com.itwill.steam.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.steam.user.mapper.UserMapper;
@Repository(value ="UserDaoImpl")
public class UserDaoImpl implements UserDao {
	@Autowired
	UserMapper userMapper;
	
	@Override
	public int createUser(User user){
		
		return userMapper.createUser(user);
	}

	@Override
	public int updateUser(User user) {
		
		return userMapper.updateUser(user);
	}

	@Override
	public int removeUser(int uNo){
		
		return userMapper.removeUser(uNo);
	}

	@Override
	public boolean existedUser(String userId) {
		boolean isExist = false;
		int count = userMapper.existedUser(userId);
		if(count == 1) {
			isExist = true;
		}
		return isExist;
	}

	@Override
	public boolean idPwMatch(String userId,String password) {
		Map<String,Object> map = new HashMap();
		map.put("uId", userId);
		map.put("uPassword", password);
		int matchPassword = userMapper.idPwMatch(map);
		//로그인성공
		if(matchPassword == 1){
			return true;
		}
		//로그인실패
		return false;
	}

	@Override
	public User findUserById(String userId) {
		
		return userMapper.findUserById(userId);
	}
	@Override
	public User findUserByNo(int uNo) {
		
		return userMapper.findUserByNo(uNo);
	}
	
	@Override
	public User findUserByNo2(int uNo) {
		
		return userMapper.findUserByNo2(uNo);
	}

	@Override
	public List<User> findAllUser() {
		
		return userMapper.findAllUser();
	}


}
