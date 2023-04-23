package com.itwill.steam.user;

import java.util.List;

import com.itwill.steam.card.Card;
import com.itwill.steam.cart.Cart;
import com.itwill.steam.chat.Chat;
import com.itwill.steam.friend.Friend;
import com.itwill.steam.profileComment.ProfileComment;
import com.itwill.steam.resources.Resources;
import com.itwill.steam.review.Review;
import com.itwill.steam.wishList.WishList;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class User {
/*
이름               널?       유형             
---------------- -------- -------------- 
U_NO             NOT NULL NUMBER(10)     
U_ID                      VARCHAR2(50)   
U_PASSWORD                VARCHAR2(100)  
U_NAME                    VARCHAR2(100)  
U_EMAIL                   VARCHAR2(100)  
U_PHONE                   VARCHAR2(50)   
U_NICKNAME                VARCHAR2(100)  
U_STREET                  VARCHAR2(1000) 
U_CITY                    VARCHAR2(1000) 
U_STATEFULL               VARCHAR2(1000) 
U_ZIP                     VARCHAR2(100)  
U_STATE                   NUMBER(10)     
U_IMG_PROFILE             VARCHAR2(100)  
U_IMG_BACKGROUND          VARCHAR2(100)  
U_ABOUT                   VARCHAR2(1000) 

 */
	private int uNo;
	private String uId;
	private String uPassword;
	private String uName;
	private String uEmail;
	private String uPhone;
	private String uNickname;
	private String uStreet;
	private String uCity;
	private String uStatefull;
	private String uZip;
	private int uState;
	private String uImgProfile;
	private String uImgBackground;
	private String uAbout;
	
	private List<Review> reviewList;
	private List<Friend> friendList;
	private List<Cart> cartList;
	private List<WishList> WishListList;
	private List<ProfileComment> ProfileCommentList;
	
	
	
	
	
	
	
	
	
	
	
}
