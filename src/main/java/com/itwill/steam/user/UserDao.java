package com.itwill.steam.user;

import java.util.List;

public interface UserDao {

	//새로운회원생성
	public int createUser(User user);
	
	//회원정보수정
	public int updateUser(User user);
	
	//회원삭제
	public int removeUser(int uNo);
	
	//회원아이디 중복확인
	public boolean existedUser(String userId);
	
	//아이디와비밀번호 일치여부
	public boolean idPwMatch(String userId,String password);
	
	//특정회원정보 아이디로 가져오기
	public User findUserById(String userId);
	
	//특정회원정보 번호로 가져오기
	public User findUserByNo(int uNo);
	
	//특정회원정보 번호로 가져오기
	public User findUserByNo2(int uNo);
	
	
	//모든회원 정보가져오기
	public List<User> findAllUser();
}
