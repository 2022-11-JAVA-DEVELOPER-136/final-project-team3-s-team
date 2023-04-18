package com.itwill.steam.user;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.itwill.steam.FinalProjectTeam3STeamApplicationTests;


class UserDaoImplTest extends FinalProjectTeam3STeamApplicationTests{
	@Autowired
	private UserDao userDao;

	
	  @Test void testCreate() { 
		  User user = User.builder().uId("test").build();
	 
	 userDao.createUser(user); }
	 /*
	 * //@Test void testUpdate() { User user = new User(6, "끼야호", "3333", "김찬영",
	 * "네이버", "010-8568-6730", "둘리", "사당동"); userDao.updateUser(user); }
	 */

	//@Test
	void testRemove()  {
		userDao.removeUser(4);
	}

	//@Test
	void testExistedUser(){
		boolean result = userDao.existedUser("sy0");
		System.out.println(result);

	}

	//@Test
	void testidPwMatch() {
		boolean result = userDao.idPwMatch("sy0", "0000");
		System.out.println("아이디체크::" + result);
	}

	//@Test
	void testFindUserById(){
		User user = userDao.findUserById("sy0");
		System.out.println("특정회원::" + user);
	}
	//@Test
	void testFindUserByNo(){
		User user = userDao.findUserByNo(1);
		System.out.println("특정회원::" + user);
	}
	
//	@Test
	void testfindAllUser(){
		List<User> user = userDao.findAllUser();
		System.out.println("특정회원::" + user);
	}

}
