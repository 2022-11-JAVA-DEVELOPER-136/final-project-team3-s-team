package com.itwill.steam.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.steam.exception.ExistedUserException;
import com.itwill.steam.exception.PasswordMissmatchException;
import com.itwill.steam.exception.UserNotFoundException;
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	//회원가입
	@Override
	public int create(User user) throws Exception,ExistedUserException {
		//1.아이디 중복체크
		if(userDao.existedUser(user.getUId())) {
			throw new ExistedUserException(user.getUId()+"는 이미 존재하는 아이디입니다");
		}
		return userDao.createUser(user);
	}
	//아이디중복체크
	@Override
	public boolean idDuplicateCheck(String userId) throws Exception {
		boolean isExist = userDao.existedUser(userId);
		if(isExist) {
			return true;
		}else {
			return false;
		}
	}
	/*
	 * 회원로그인
	 */
	@Override
	public int login(String userId, String password) throws Exception {
		int result=1;
		
		// 1.아이디 존재여부
		User user = userDao.findUserById(userId);
		if(user==null) {
			//아이디존재안함
			throw new UserNotFoundException(userId+" 는 존재하지않는 아이디입니다");
		}
		
		// 2. 패스워드 체크
		boolean pwChk = userDao.idPwMatch(userId, password);
		if(pwChk == false) {
			throw new PasswordMissmatchException("패스워드가 일치하지않습니다.");
		}
		
		return result;
	}
	//회원아이디로 상세보기
	@Override
	public User findUserById(String userId) throws Exception {
		return userDao.findUserById(userId);
	}
	//회원번호로 상세보기
	@Override
	public User findUserByNo(int userNo) throws Exception {
		return userDao.findUserByNo(userNo);
	}
	//전체회원불러오기
	@Override
	public List<User> userList() throws Exception {
		return userDao.findAllUser();
	}
	//회원수정
	@Override
	public int update(User user) throws Exception {
		return userDao.updateUser(user);
	}
	//회원삭제
	@Override
	public int remove(int userNo) throws Exception {
		return userDao.removeUser(userNo);
	}

}
