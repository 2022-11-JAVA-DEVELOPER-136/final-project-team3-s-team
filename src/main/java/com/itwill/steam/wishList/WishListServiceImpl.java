package com.itwill.steam.wishList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.steam.exception.ExistedWishListException;

@Repository
public class WishListServiceImpl implements WishListService {
	
	@Autowired
	private WishListDao wishListDao;
	
	// 상품 추가
	@Override
	public int insertWishList(WishList wishList) {

		int result = 0;

		// 위시리스트에 게임이 있는지 없는지 체크
		Map<String, Object> map = new HashMap<>();
		// uNo, gNo 해당 유저가 게임을 가지고 있는지에 대한 값을 가져옴
		map.put("uNo", wishList.getUser().getUNo());
		map.put("gNo", wishList.getGame().getGNo());
		// 위시리스트에 있는지 확인후 저장
		int exist = wishListDao.existWishList(map);

		if (exist == 1) {
			throw new ExistedWishListException("existed in wishList");
		}

		result = wishListDao.insertWishList(wishList);
		return result;
	}
	
	
	
	//상품 선택
	@Override
	public List<WishList> selectWishList(int uNo) {
		return wishListDao.selectWishList(uNo);
	}
	
	//상품 삭제
	@Override
	public int deleteWishList(int wishNo) {
		return wishListDao.deleteWishList(wishNo);
	}
	
	//상품 전체 삭제
	@Override
	public int deleteAllWishLists(int uNo) {
		return wishListDao.deleteAllWishLists(uNo);
	}

}