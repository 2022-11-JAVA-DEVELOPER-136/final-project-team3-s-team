package com.itwill.steam.user;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.itwill.steam.FinalProjectTeam3STeamApplicationTests;

class UserServiceImplTest extends FinalProjectTeam3STeamApplicationTests{
	@Autowired
	private UserService userService;
	
	@Test
	void testCreate() throws Exception {
		User user = User.builder().uNo(0).uId("sy0").build();
		userService.create(user); 
	 }
	 
//	@Test
	void testIdDuplicateCheck() throws Exception {
		boolean isExist = userService.idDuplicateCheck("끼야호이");
		System.out.println("중복체크 : "+isExist);
	}

	/*
	 * //@Test void testLogin() throws Exception { int result =
	 * userService.login("sy1", "1111"); System.out.println("로그인 체크:" +result); }
	 */

//	@Test
	void testFindUserById() throws Exception {
		User user = userService.findUserById("sy0");
		System.out.println("내정보 : "+user);
	}

//	@Test
	void testFindUserByNo() throws Exception {
		User user = userService.findUserByNo2(1);
		System.out.println("내정보 : "+user);
	}


	//@Test
	void testUserList() throws Exception {
		List<User> userList = userService.userList();
		userList.get(0).getWishListList();
		System.out.println("리스트 : "+userList);
	}

//	@Test
	/*
	 * void testUpdate() throws Exception { User user = new User(7, "끼야호이", "0000",
	 * "누구", "네이버", "010-1111-1111", "둘리", "사당동"); userService.update(user); }
	 */

//	@Test
	void testRemove() throws Exception {
		userService.remove(7);
	}

}
