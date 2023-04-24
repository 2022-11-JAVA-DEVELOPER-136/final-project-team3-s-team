package com.itwill.steam.ownedGame;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.steam.exception.ExistedLibraryException;
import com.itwill.steam.order.Order;
import com.itwill.steam.orderItem.OrderItem;
import com.itwill.steam.user.User;

@Service
public class OwnedGameServiceImpl implements OwnedGameService {
	
	@Autowired
	private OwnedGameDao ownedGameDao;
	
	//user의 uNo로 해당 유저의 ownedGameList를 찾아서 반환(플레이시간 많은순)
	@Override
	public List<OwnedGame> ownedGameList(User user) {
		return ownedGameDao.ownedGameList(user);
	}
	
	//플레이시간 상위4개 게임리스트
	@Override
	public List<OwnedGame> getTop4OwnedGamesByPlaytime(User user) {
		
		return ownedGameDao.getTop4OwnedGamesByPlaytime(user);
	}
	
	//최근플레이 3개 게임리스트
	@Override
	public List<OwnedGame> getTop4OwnedGamesByLastTime(User user) {
		
		return ownedGameDao.getTop4OwnedGamesByLastTime(user);
	}
	
	//주문이 끝날 때 해당 주문의 주문아이템을 해당 유저의 라이브러리에 입력 (uNo, gNo의 조합이 이미 라이브러리에 존재한다면 Exception)
	@Override
	public int insertOwnedGame(Map<String, Object> map) {
		
		int result = 0;
		Order order = (Order)map.get("order");
		
		/*****트랜잭션 시작*****/
		for(OrderItem orderitem:order.getOrderItemList()) {
			map.put("gNo", orderitem.getGame().getGNo());
			
			//map에 uNo, gNo가 들어있어야 함.
			int exist = ownedGameDao.existOwnedGame(map);
			if(exist==1) throw new ExistedLibraryException("existed in library");
			result = ownedGameDao.insertOwnedGame(map);
		}
		/*****트랜잭션 종료*****/
		
		return result;
	}
	
	//uNo, gNo를 사용해서 OwnedGame 1개 검색
	@Override
	public OwnedGame findOwnedGame(Map<String, Object> map) {
		return ownedGameDao.findOwnedGame(map);
	}
}