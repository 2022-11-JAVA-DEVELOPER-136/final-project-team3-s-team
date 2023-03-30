/*
insert
*/

--userinfo
insert into userinfo(u_no, u_id, u_password, u_name, u_email, u_phone, u_nickname, u_addr) values(USERINFO_U_NO_SEQ.nextval, 'sy0', '0000', '김세영', 'sy0@gmail.com', '010-0000-0000', 'sy0_닉네임', '서울시 송파구');
insert into userinfo(u_no, u_id, u_password, u_name, u_email, u_phone, u_nickname, u_addr) values(USERINFO_U_NO_SEQ.nextval, 'sy1', '1111', '김세일', 'sy1@gmail.com', '010-1111-1111', 'sy1_닉네임', '서울시 강남구');
insert into userinfo(u_no, u_id, u_password, u_name, u_email, u_phone, u_nickname, u_addr) values(USERINFO_U_NO_SEQ.nextval, 'sy2', '2222', '김세이', 'sy2@gmail.com', '010-2222-2222', 'sy2_닉네임', '서울시 서초구');


--friend
/*
f_state는 상태를 표시. (0: 로그아웃, 1:로그인, 2~: 미정)
u_to는 친구요청을 보내는 user의 u_no
u_from은 친구요청을 받아서 수락한 user의 u_no
friend테이블에서 u_to와 u_from의 조합은 유일해야 한다. (UNIQUE)
*/
insert into friend(f_no, f_state, u_to, u_from) values(FRIEND_F_NO_SEQ.nextval, 0, 1, 2);
insert into friend(f_no, f_state, u_to, u_from) values(FRIEND_F_NO_SEQ.nextval, 0, 1, 3);
insert into friend(f_no, f_state, u_to, u_from) values(FRIEND_F_NO_SEQ.nextval, 0, 2, 3);


--card
insert into card(card_seq, card_name, card_number, card_ex_date, card_cvc, u_no) values(CARD_CARD_SEQ_SEQ.nextval, 'sy0_카드_1', '1111-1111-1111-1111', '02/24', 111, 1);
insert into card(card_seq, card_name, card_number, card_ex_date, card_cvc, u_no) values(CARD_CARD_SEQ_SEQ.nextval, 'sy0_카드_2', '2222-2222-2222-2222', '05/25', 222, 1);
insert into card(card_seq, card_name, card_number, card_ex_date, card_cvc, u_no) values(CARD_CARD_SEQ_SEQ.nextval, 'sy1_카드_1', '1234-1234-1234-1234', '03/26', 123, 2);


--category
insert into category(ct_no, ct_name, ct_img) values(CATEGORY_CT_NO_SEQ.nextval, '액션', '액션.jpg');
insert into category(ct_no, ct_name, ct_img) values(CATEGORY_CT_NO_SEQ.nextval, '롤플레잉', '롤플레잉.jpg');
insert into category(ct_no, ct_name, ct_img) values(CATEGORY_CT_NO_SEQ.nextval, '전략', '전략.jpg');


--game
insert into game(g_no, g_name, g_short_desc, g_long_desc, g_grade, g_release_date, g_developer, g_distributor, g_price, g_discount_rate, g_discount_start, g_discount_end, g_os, g_prosessor, g_memory, g_graphic, g_sell_count, ct_no)
values(GAME_G_NO_SEQ.nextval, '액션게임1', '액션게임1_짧은설명', '액션게임1_긴설명', 9, to_date('2020/05/05'), '개발사1', '배급사1', 50000, 50, to_date('2023/03/01'), to_date('2023/03/31'), 'Windows 10', 'Intel Core i5', '8GB RAM', 'GeForce GTX 1660', 11, 1);
insert into game(g_no, g_name, g_short_desc, g_long_desc, g_grade, g_release_date, g_developer, g_distributor, g_price, g_discount_rate, g_discount_start, g_discount_end, g_os, g_prosessor, g_memory, g_graphic, g_sell_count, ct_no)
values(GAME_G_NO_SEQ.nextval, '액션게임2', '액션게임2_짧은설명', '액션게임2_긴설명', 8, to_date('2021/06/06'), '개발사2', '배급사2', 60000, 50, to_date('2023/03/01'), to_date('2023/03/21'), 'Windows 10', 'Intel Core i5', '8GB RAM', 'GeForce GTX 1660', 33, 1);
insert into game(g_no, g_name, g_short_desc, g_long_desc, g_grade, g_release_date, g_developer, g_distributor, g_price, g_discount_rate, g_discount_start, g_discount_end, g_os, g_prosessor, g_memory, g_graphic, g_sell_count, ct_no)
values(GAME_G_NO_SEQ.nextval, '롤플레잉게임1', '롤플레잉게임1_짧은설명', '롤플레잉게임1_긴설명', 9, to_date('2022/07/07'), '개발사3', '배급사3', 70000, 50, to_date('2023/03/01'), to_date('2023/03/31'), 'Windows 10', 'Intel Core i5', '8GB RAM', 'GeForce GTX 1660', 22, 2);
insert into game(g_no, g_name, g_short_desc, g_long_desc, g_grade, g_release_date, g_developer, g_distributor, g_price, g_discount_rate, g_discount_start, g_discount_end, g_os, g_prosessor, g_memory, g_graphic, g_sell_count, ct_no)
values(GAME_G_NO_SEQ.nextval, '롤플레잉게임2', '롤플레잉게임2_짧은설명', '롤플레잉게임2_긴설명', 8, to_date('2019/02/02'), '개발사4', '배급사4', 30000, 50, to_date('2023/03/01'), to_date('2023/03/21'), 'Windows 10', 'Intel Core i5', '8GB RAM', 'GeForce GTX 1660', 66, 2);
insert into game(g_no, g_name, g_short_desc, g_long_desc, g_grade, g_release_date, g_developer, g_distributor, g_price, g_discount_rate, g_discount_start, g_discount_end, g_os, g_prosessor, g_memory, g_graphic, g_sell_count, ct_no)
values(GAME_G_NO_SEQ.nextval, '전략게임1', '전략게임1_짧은설명', '전략게임1_긴설명', 9, to_date('2020/11/11'), '개발사5', '배급사5', 40000, 50, to_date('2023/03/01'), to_date('2023/03/31'), 'Windows 10', 'Intel Core i5', '8GB RAM', 'GeForce GTX 1660', 44, 3);
insert into game(g_no, g_name, g_short_desc, g_long_desc, g_grade, g_release_date, g_developer, g_distributor, g_price, g_discount_rate, g_discount_start, g_discount_end, g_os, g_prosessor, g_memory, g_graphic, g_sell_count, ct_no)
values(GAME_G_NO_SEQ.nextval, '전략게임2', '전략게임2_짧은설명', '전략게임2_긴설명', 8, to_date('2018/03/03'), '개발사6', '배급사6', 50000, 50, to_date('2023/03/01'), to_date('2023/03/21'), 'Windows 10', 'Intel Core i5', '8GB RAM', 'GeForce GTX 1660', 55, 3);


--language
insert into language(lang_no, lang_name) values(LANGUAGE_LANG_NO_SEQ.nextval, '한국어');
insert into language(lang_no, lang_name) values(LANGUAGE_LANG_NO_SEQ.nextval, '영어');
insert into language(lang_no, lang_name) values(LANGUAGE_LANG_NO_SEQ.nextval, '스페인어');


--game_language
insert into game_language(gl_no, g_no, lang_no) values(GAME_LANGUAGE_GL_NO_SEQ.nextval, 1, 1);
insert into game_language(gl_no, g_no, lang_no) values(GAME_LANGUAGE_GL_NO_SEQ.nextval, 1, 2);
insert into game_language(gl_no, g_no, lang_no) values(GAME_LANGUAGE_GL_NO_SEQ.nextval, 1, 3);
insert into game_language(gl_no, g_no, lang_no) values(GAME_LANGUAGE_GL_NO_SEQ.nextval, 2, 1);
insert into game_language(gl_no, g_no, lang_no) values(GAME_LANGUAGE_GL_NO_SEQ.nextval, 2, 2);
insert into game_language(gl_no, g_no, lang_no) values(GAME_LANGUAGE_GL_NO_SEQ.nextval, 2, 3);
insert into game_language(gl_no, g_no, lang_no) values(GAME_LANGUAGE_GL_NO_SEQ.nextval, 3, 1);
insert into game_language(gl_no, g_no, lang_no) values(GAME_LANGUAGE_GL_NO_SEQ.nextval, 3, 2);
insert into game_language(gl_no, g_no, lang_no) values(GAME_LANGUAGE_GL_NO_SEQ.nextval, 3, 3);
insert into game_language(gl_no, g_no, lang_no) values(GAME_LANGUAGE_GL_NO_SEQ.nextval, 4, 1);
insert into game_language(gl_no, g_no, lang_no) values(GAME_LANGUAGE_GL_NO_SEQ.nextval, 4, 2);
insert into game_language(gl_no, g_no, lang_no) values(GAME_LANGUAGE_GL_NO_SEQ.nextval, 4, 3);
insert into game_language(gl_no, g_no, lang_no) values(GAME_LANGUAGE_GL_NO_SEQ.nextval, 5, 1);
insert into game_language(gl_no, g_no, lang_no) values(GAME_LANGUAGE_GL_NO_SEQ.nextval, 5, 2);
insert into game_language(gl_no, g_no, lang_no) values(GAME_LANGUAGE_GL_NO_SEQ.nextval, 5, 3);
insert into game_language(gl_no, g_no, lang_no) values(GAME_LANGUAGE_GL_NO_SEQ.nextval, 6, 1);
insert into game_language(gl_no, g_no, lang_no) values(GAME_LANGUAGE_GL_NO_SEQ.nextval, 6, 2);
insert into game_language(gl_no, g_no, lang_no) values(GAME_LANGUAGE_GL_NO_SEQ.nextval, 6, 3);


--resources
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'action1.jpg', 1);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'action2.jpg', 2);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'roleplaying1.jpg', 3);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'roleplaying2.jpg', 4);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'strategy1.jpg', 5);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'strategy2.jpg', 6);


--news
insert into news(news_no, news_title, news_content, news_img, g_no) values(NEWS_NEWS_NO_SEQ.nextval, '뉴스1_제목', '뉴스1_내용', 'news1.jpg', 1);
insert into news(news_no, news_title, news_content, news_img, g_no) values(NEWS_NEWS_NO_SEQ.nextval, '뉴스2_제목', '뉴스2_내용', 'news2.jpg', 2);
insert into news(news_no, news_title, news_content, news_img, g_no) values(NEWS_NEWS_NO_SEQ.nextval, '뉴스3_제목', '뉴스3_내용', 'news3.jpg', 3);
insert into news(news_no, news_title, news_content, news_img, g_no) values(NEWS_NEWS_NO_SEQ.nextval, '뉴스4_제목', '뉴스4_내용', 'news4.jpg', 4);
insert into news(news_no, news_title, news_content, news_img, g_no) values(NEWS_NEWS_NO_SEQ.nextval, '뉴스5_제목', '뉴스5_내용', 'news5.jpg', 5);
insert into news(news_no, news_title, news_content, news_img, g_no) values(NEWS_NEWS_NO_SEQ.nextval, '뉴스6_제목', '뉴스6_내용', 'news6.jpg', 6);


--cart
--sy0
insert into cart(c_no, u_no, g_no) values(CART_C_NO_SEQ.nextval, 1, 1);
insert into cart(c_no, u_no, g_no) values(CART_C_NO_SEQ.nextval, 1, 3);
insert into cart(c_no, u_no, g_no) values(CART_C_NO_SEQ.nextval, 1, 5);
--sy1
insert into cart(c_no, u_no, g_no) values(CART_C_NO_SEQ.nextval, 2, 2);
insert into cart(c_no, u_no, g_no) values(CART_C_NO_SEQ.nextval, 2, 4);
insert into cart(c_no, u_no, g_no) values(CART_C_NO_SEQ.nextval, 2, 6);


--wishlist
--sy0
insert into wishlist(wish_no, wish_date, u_no, g_no) values(WISHLIST_WISH_NO_SEQ.nextval, sysdate, 1, 1);
insert into wishlist(wish_no, wish_date, u_no, g_no) values(WISHLIST_WISH_NO_SEQ.nextval, sysdate, 1, 3);
insert into wishlist(wish_no, wish_date, u_no, g_no) values(WISHLIST_WISH_NO_SEQ.nextval, sysdate, 1, 5);
--sy1
insert into wishlist(wish_no, wish_date, u_no, g_no) values(WISHLIST_WISH_NO_SEQ.nextval, sysdate, 2, 2);
insert into wishlist(wish_no, wish_date, u_no, g_no) values(WISHLIST_WISH_NO_SEQ.nextval, sysdate, 2, 4);
insert into wishlist(wish_no, wish_date, u_no, g_no) values(WISHLIST_WISH_NO_SEQ.nextval, sysdate, 2, 6);


--orders, order_item
--sy0
insert into orders(o_no, o_date, o_total_price, u_no) values(ORDERS_O_NO_SEQ.nextval, sysdate, 25000, 1);
insert into order_item(oi_no, o_no, g_no) values(ORDER_ITEM_OI_NO_SEQ.nextval, ORDERS_O_NO_SEQ.currval, 1);

insert into orders(o_no, o_date, o_total_price, u_no) values(ORDERS_O_NO_SEQ.nextval, sysdate, 55000, 1);
insert into order_item(oi_no, o_no, g_no) values(ORDER_ITEM_OI_NO_SEQ.nextval, ORDERS_O_NO_SEQ.currval, 3);
insert into order_item(oi_no, o_no, g_no) values(ORDER_ITEM_OI_NO_SEQ.nextval, ORDERS_O_NO_SEQ.currval, 5);
--sy1
insert into orders(o_no, o_date, o_total_price, u_no) values(ORDERS_O_NO_SEQ.nextval, sysdate, 30000, 2);
insert into order_item(oi_no, o_no, g_no) values(ORDER_ITEM_OI_NO_SEQ.nextval, ORDERS_O_NO_SEQ.currval, 2);

insert into orders(o_no, o_date, o_total_price, u_no) values(ORDERS_O_NO_SEQ.nextval, sysdate, 40000, 2);
insert into order_item(oi_no, o_no, g_no) values(ORDER_ITEM_OI_NO_SEQ.nextval, ORDERS_O_NO_SEQ.currval, 4);
insert into order_item(oi_no, o_no, g_no) values(ORDER_ITEM_OI_NO_SEQ.nextval, ORDERS_O_NO_SEQ.currval, 6);


--review
--review_recommend는 추천/비추천을 의미. (0: 비추천, 1: 추천)
insert into review(review_no, review_created_at, review_updated_at, review_comment, review_recommend, u_no, g_no) values(REVIEW_REVIEW_NO_SEQ.nextval, sysdate, sysdate, '리뷰1', 0, 1, 1);
insert into review(review_no, review_created_at, review_updated_at, review_comment, review_recommend, u_no, g_no) values(REVIEW_REVIEW_NO_SEQ.nextval, sysdate, sysdate, '리뷰2', 0, 1, 2);
insert into review(review_no, review_created_at, review_updated_at, review_comment, review_recommend, u_no, g_no) values(REVIEW_REVIEW_NO_SEQ.nextval, sysdate, sysdate, '리뷰3', 0, 1, 3);
insert into review(review_no, review_created_at, review_updated_at, review_comment, review_recommend, u_no, g_no) values(REVIEW_REVIEW_NO_SEQ.nextval, sysdate, sysdate, '리뷰4', 0, 1, 4);
insert into review(review_no, review_created_at, review_updated_at, review_comment, review_recommend, u_no, g_no) values(REVIEW_REVIEW_NO_SEQ.nextval, sysdate, sysdate, '리뷰5', 0, 1, 5);
insert into review(review_no, review_created_at, review_updated_at, review_comment, review_recommend, u_no, g_no) values(REVIEW_REVIEW_NO_SEQ.nextval, sysdate, sysdate, '리뷰6', 0, 1, 6);
insert into review(review_no, review_created_at, review_updated_at, review_comment, review_recommend, u_no, g_no) values(REVIEW_REVIEW_NO_SEQ.nextval, sysdate, sysdate, '리뷰7', 1, 2, 1);
insert into review(review_no, review_created_at, review_updated_at, review_comment, review_recommend, u_no, g_no) values(REVIEW_REVIEW_NO_SEQ.nextval, sysdate, sysdate, '리뷰8', 1, 2, 2);
insert into review(review_no, review_created_at, review_updated_at, review_comment, review_recommend, u_no, g_no) values(REVIEW_REVIEW_NO_SEQ.nextval, sysdate, sysdate, '리뷰9', 1, 2, 3);
insert into review(review_no, review_created_at, review_updated_at, review_comment, review_recommend, u_no, g_no) values(REVIEW_REVIEW_NO_SEQ.nextval, sysdate, sysdate, '리뷰10', 1, 2, 4);
insert into review(review_no, review_created_at, review_updated_at, review_comment, review_recommend, u_no, g_no) values(REVIEW_REVIEW_NO_SEQ.nextval, sysdate, sysdate, '리뷰11', 1, 2, 5);
insert into review(review_no, review_created_at, review_updated_at, review_comment, review_recommend, u_no, g_no) values(REVIEW_REVIEW_NO_SEQ.nextval, sysdate, sysdate, '리뷰12', 1, 2, 6);


--owned_game
--og_playtime은 소유게임별 플레이시간을 의미. 숫자 1은 1시간을 의미. (ex. 10 -> 10시간)
insert into owned_game(og_no, og_playtime, og_lastplay, u_no, g_no) values(OWNED_GAME_OG_NO_SEQ.nextval, 10, to_date('2023/03/25'), 1, 1);
insert into owned_game(og_no, og_playtime, og_lastplay, u_no, g_no) values(OWNED_GAME_OG_NO_SEQ.nextval, 10, to_date('2023/03/25'), 1, 3);
insert into owned_game(og_no, og_playtime, og_lastplay, u_no, g_no) values(OWNED_GAME_OG_NO_SEQ.nextval, 10, to_date('2023/03/25'), 1, 5);
insert into owned_game(og_no, og_playtime, og_lastplay, u_no, g_no) values(OWNED_GAME_OG_NO_SEQ.nextval, 10, to_date('2023/03/25'), 2, 2);
insert into owned_game(og_no, og_playtime, og_lastplay, u_no, g_no) values(OWNED_GAME_OG_NO_SEQ.nextval, 10, to_date('2023/03/25'), 2, 4);
insert into owned_game(og_no, og_playtime, og_lastplay, u_no, g_no) values(OWNED_GAME_OG_NO_SEQ.nextval, 10, to_date('2023/03/25'), 2, 6);


--workshop
--workshop의 컬럼 u_no는 해당 모드를 구독하는 유저를 의미.
insert into workshop(w_no, w_name, w_img, w_desc, u_no, g_no) values(WORKSHOP_W_NO_SEQ.nextval, '모드1', 'mode1.jpg', '모드1_설명', 1, 1);
insert into workshop(w_no, w_name, w_img, w_desc, u_no, g_no) values(WORKSHOP_W_NO_SEQ.nextval, '모드2', 'mode2.jpg', '모드2_설명', 1, 3);
insert into workshop(w_no, w_name, w_img, w_desc, u_no, g_no) values(WORKSHOP_W_NO_SEQ.nextval, '모드3', 'mode3.jpg', '모드3_설명', 1, 5);
insert into workshop(w_no, w_name, w_img, w_desc, u_no, g_no) values(WORKSHOP_W_NO_SEQ.nextval, '모드4', 'mode4.jpg', '모드4_설명', 2, 2);
insert into workshop(w_no, w_name, w_img, w_desc, u_no, g_no) values(WORKSHOP_W_NO_SEQ.nextval, '모드5', 'mode5.jpg', '모드5_설명', 2, 4);
insert into workshop(w_no, w_name, w_img, w_desc, u_no, g_no) values(WORKSHOP_W_NO_SEQ.nextval, '모드6', 'mode6.jpg', '모드6_설명', 2, 6);


--tag
insert into tag(tag_no, tag_name) values(TAG_TAG_NO_SEQ.nextval, '오픈월드');
insert into tag(tag_no, tag_name) values(TAG_TAG_NO_SEQ.nextval, 'RPG');
insert into tag(tag_no, tag_name) values(TAG_TAG_NO_SEQ.nextval, '어드벤처');
insert into tag(tag_no, tag_name) values(TAG_TAG_NO_SEQ.nextval, '싱글 플레이어');
insert into tag(tag_no, tag_name) values(TAG_TAG_NO_SEQ.nextval, '인디');
insert into tag(tag_no, tag_name) values(TAG_TAG_NO_SEQ.nextval, '액션');
insert into tag(tag_no, tag_name) values(TAG_TAG_NO_SEQ.nextval, '캐주얼');
insert into tag(tag_no, tag_name) values(TAG_TAG_NO_SEQ.nextval, '복고풍');
insert into tag(tag_no, tag_name) values(TAG_TAG_NO_SEQ.nextval, '아케이드');
insert into tag(tag_no, tag_name) values(TAG_TAG_NO_SEQ.nextval, '클래식');
insert into tag(tag_no, tag_name) values(TAG_TAG_NO_SEQ.nextval, '협동');
insert into tag(tag_no, tag_name) values(TAG_TAG_NO_SEQ.nextval, '횡스크롤');
insert into tag(tag_no, tag_name) values(TAG_TAG_NO_SEQ.nextval, '슈팅');
insert into tag(tag_no, tag_name) values(TAG_TAG_NO_SEQ.nextval, '퍼즐');
insert into tag(tag_no, tag_name) values(TAG_TAG_NO_SEQ.nextval, '1인칭');
insert into tag(tag_no, tag_name) values(TAG_TAG_NO_SEQ.nextval, '시뮬레이션');
insert into tag(tag_no, tag_name) values(TAG_TAG_NO_SEQ.nextval, '역사');
insert into tag(tag_no, tag_name) values(TAG_TAG_NO_SEQ.nextval, '음악');
insert into tag(tag_no, tag_name) values(TAG_TAG_NO_SEQ.nextval, '리듬');
insert into tag(tag_no, tag_name) values(TAG_TAG_NO_SEQ.nextval, '고난이도');


--game_tag
insert into game_tag(gt_no, tag_no, g_no) values(TAG_GAME_TG_NO_SEQ.nextval, 5, 1);
insert into game_tag(gt_no, tag_no, g_no) values(TAG_GAME_TG_NO_SEQ.nextval, 6, 1);
insert into game_tag(gt_no, tag_no, g_no) values(TAG_GAME_TG_NO_SEQ.nextval, 6, 2);
insert into game_tag(gt_no, tag_no, g_no) values(TAG_GAME_TG_NO_SEQ.nextval, 7, 2);
insert into game_tag(gt_no, tag_no, g_no) values(TAG_GAME_TG_NO_SEQ.nextval, 1, 3);
insert into game_tag(gt_no, tag_no, g_no) values(TAG_GAME_TG_NO_SEQ.nextval, 2, 3);
insert into game_tag(gt_no, tag_no, g_no) values(TAG_GAME_TG_NO_SEQ.nextval, 2, 4);
insert into game_tag(gt_no, tag_no, g_no) values(TAG_GAME_TG_NO_SEQ.nextval, 3, 4);
insert into game_tag(gt_no, tag_no, g_no) values(TAG_GAME_TG_NO_SEQ.nextval, 4, 5);
insert into game_tag(gt_no, tag_no, g_no) values(TAG_GAME_TG_NO_SEQ.nextval, 16, 5);
insert into game_tag(gt_no, tag_no, g_no) values(TAG_GAME_TG_NO_SEQ.nextval, 4, 6);
insert into game_tag(gt_no, tag_no, g_no) values(TAG_GAME_TG_NO_SEQ.nextval, 17, 6);


--chat_room
insert into chat_room(cr_no, cr_name) values(CHAT_ROOM_CR_NO_SEQ.nextval, '채팅방1');
insert into chat_room(cr_no, cr_name) values(CHAT_ROOM_CR_NO_SEQ.nextval, '채팅방2');


--chat
insert into chat(chat_no, chat_content, chat_created_at, u_no, cr_no) values(CHAT_CHAT_NO_SEQ.nextval, '1번방에서 1번유저가 말한 채팅1', sysdate, 1, 1);
insert into chat(chat_no, chat_content, chat_created_at, u_no, cr_no) values(CHAT_CHAT_NO_SEQ.nextval, '1번방에서 2번유저가 말한 채팅1', sysdate, 2, 1);
insert into chat(chat_no, chat_content, chat_created_at, u_no, cr_no) values(CHAT_CHAT_NO_SEQ.nextval, '1번방에서 3번유저가 말한 채팅1', sysdate, 3, 1);
insert into chat(chat_no, chat_content, chat_created_at, u_no, cr_no) values(CHAT_CHAT_NO_SEQ.nextval, '2번방에서 1번유저가 말한 채팅1', sysdate, 1, 2);
insert into chat(chat_no, chat_content, chat_created_at, u_no, cr_no) values(CHAT_CHAT_NO_SEQ.nextval, '2번방에서 2번유저가 말한 채팅1', sysdate, 2, 2);


commit;