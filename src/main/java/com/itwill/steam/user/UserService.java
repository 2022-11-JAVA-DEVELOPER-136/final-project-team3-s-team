package com.itwill.steam.user;

import java.util.List;

public interface UserService {
	// 회원 가입
	public int create(User user) throws Exception;

	// 아이디 중복체크
	public boolean idDuplicateCheck(String userId) throws Exception;

	// 로그인
	/*
	 * 0: 아이디 존재 안함 1: 패스워드 불일치 2: 로그인 성공
	 */
	public int login(String userId, String password) throws Exception;
	// 회원 정보 아이디로보기 
	public User findUserById(String userId) throws Exception;
	// 회원 정보 회원번호로보기 
	public User findUserByNo(int userNo) throws Exception;
	//회원전체불러오기
	public List<User> userList()throws Exception;
	// 회원정보 수정
	public int update(User user) throws Exception;

	// 회원 탈퇴
	public int remove(int userNo) throws Exception;

}
