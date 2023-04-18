package com.itwill.steam.user;

import java.util.List;

public interface UserService {
	// 회원 가입
	public int create(User user);

	// 아이디 중복체크
	public boolean idDuplicateCheck(String userId);

	// 로그인
	/*
	 * 0: 아이디 존재 안함 1: 패스워드 불일치 2: 로그인 성공
	 */
	public User login(String userId, String password);
	// 회원 정보 아이디로보기 
	public User findUserById(String userId);
	// 회원 정보 회원번호로보기 
	public User findUserByNo(int userNo);
	// 회원 정보 회원번호로보기 
	public User findUserByNo2(int userNo);
	//회원전체불러오기
	public List<User> userList();
	// 회원정보 수정
	public int update(User user);

	// 회원 탈퇴
	public int remove(int userNo);

}
