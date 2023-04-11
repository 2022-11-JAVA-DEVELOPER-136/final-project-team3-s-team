DROP TABLE profile_comment CASCADE CONSTRAINTS;
DROP TABLE news_tag CASCADE CONSTRAINTS;
DROP TABLE news_comment CASCADE CONSTRAINTS;
DROP TABLE game_language CASCADE CONSTRAINTS;
DROP TABLE chat CASCADE CONSTRAINTS;
DROP TABLE friend CASCADE CONSTRAINTS;
DROP TABLE resources CASCADE CONSTRAINTS;
DROP TABLE game_tag CASCADE CONSTRAINTS;
DROP TABLE card CASCADE CONSTRAINTS;
DROP TABLE language CASCADE CONSTRAINTS;
DROP TABLE tag CASCADE CONSTRAINTS;
DROP TABLE workshop CASCADE CONSTRAINTS;
DROP TABLE news CASCADE CONSTRAINTS;
DROP TABLE chat_room CASCADE CONSTRAINTS;
DROP TABLE owned_game CASCADE CONSTRAINTS;
DROP TABLE review CASCADE CONSTRAINTS;
DROP TABLE order_item CASCADE CONSTRAINTS;
DROP TABLE orders CASCADE CONSTRAINTS;
DROP TABLE wishlist CASCADE CONSTRAINTS;
DROP TABLE cart CASCADE CONSTRAINTS;
DROP TABLE game CASCADE CONSTRAINTS;
DROP TABLE category CASCADE CONSTRAINTS;
DROP TABLE userInfo CASCADE CONSTRAINTS;

CREATE TABLE userInfo(
		u_no                          		NUMBER(10)		 NULL ,
		u_id                          		VARCHAR2(50)		 NULL ,
		u_password                    		VARCHAR2(100)		 NULL ,
		u_name                        		VARCHAR2(100)		 NULL ,
		u_email                       		VARCHAR2(100)		 NULL ,
		u_phone                       		VARCHAR2(50)		 NULL ,
		u_nickname                    		VARCHAR2(100)		 NULL ,
		u_street                      		VARCHAR2(1000)		 NULL ,
		u_city                        		VARCHAR2(1000)		 NULL ,
		u_statefull                   		VARCHAR2(1000)		 NULL ,
		u_zip                         		VARCHAR2(100)		 NULL ,
		u_state                       		NUMBER(10)		 NULL ,
		u_img_profile                 		VARCHAR2(100)		 NULL ,
		u_img_background              		VARCHAR2(100)		 NULL ,
		u_about                       		VARCHAR2(1000)		 NULL 
);

DROP SEQUENCE userInfo_u_no_SEQ;

CREATE SEQUENCE userInfo_u_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;




CREATE TABLE category(
		ct_no                         		NUMBER(10)		 NULL ,
		ct_name                       		VARCHAR2(100)		 NULL ,
		ct_img                        		VARCHAR2(100)		 NULL 
);

DROP SEQUENCE category_ct_no_SEQ;

CREATE SEQUENCE category_ct_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;




CREATE TABLE game(
		g_no                          		NUMBER(10)		 NULL ,
		g_name                        		VARCHAR2(1000)		 NULL ,
		g_short_desc                  		VARCHAR2(2000)		 NULL ,
		g_long_desc                   		VARCHAR2(4000)		 NULL ,
		g_grade                       		NUMBER(10)		 NULL ,
		g_release_date                		DATE		 NULL ,
		g_developer                   		VARCHAR2(100)		 NULL ,
		g_distributor                 		VARCHAR2(100)		 NULL ,
		g_price                       		NUMBER(10)		 NULL ,
		g_discount_rate               		NUMBER(10)		 NULL ,
		g_discount_start              		DATE		 NULL ,
		g_discount_end                		DATE		 NULL ,
		g_os                          		VARCHAR2(1000)		 NULL ,
		g_prosessor                   		VARCHAR2(1000)		 NULL ,
		g_memory                      		VARCHAR2(1000)		 NULL ,
		g_graphic                     		VARCHAR2(1000)		 NULL ,
		g_disk_space                  		VARCHAR2(1000)		 NULL ,
		g_min_os                      		VARCHAR2(1000)		 NULL ,
		g_min_prosessor               		VARCHAR2(1000)		 NULL ,
		g_min_memory                  		VARCHAR2(1000)		 NULL ,
		g_min_graphic                 		VARCHAR2(1000)		 NULL ,
		g_min_disk_space              		VARCHAR2(1000)		 NULL ,
		g_sell_count                  		NUMBER(10)		 NULL ,
		ct_no                         		NUMBER(10)		 NULL 
);

DROP SEQUENCE game_g_no_SEQ;

CREATE SEQUENCE game_g_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;




CREATE TABLE cart(
		c_no                          		NUMBER(10)		 NULL ,
		u_no                          		NUMBER(10)		 NULL ,
		g_no                          		NUMBER(10)		 NULL 
);

DROP SEQUENCE cart_c_no_SEQ;

CREATE SEQUENCE cart_c_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;




CREATE TABLE wishlist(
		wish_no                       		NUMBER(10)		 NULL ,
		wish_date                     		DATE		 DEFAULT sysdate		 NULL ,
		u_no                          		NUMBER(10)		 NULL ,
		g_no                          		NUMBER(10)		 NULL 
);

DROP SEQUENCE wishlist_wish_no_SEQ;

CREATE SEQUENCE wishlist_wish_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;




CREATE TABLE orders(
		o_no                          		NUMBER(10)		 NULL ,
		o_date                        		DATE		 NULL ,
		o_total_price                 		NUMBER(10)		 NULL ,
		u_no                          		NUMBER(10)		 NULL 
);

DROP SEQUENCE orders_o_no_SEQ;

CREATE SEQUENCE orders_o_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;




CREATE TABLE order_item(
		oi_no                         		NUMBER(10)		 NULL ,
		o_no                          		NUMBER(10)		 NULL ,
		g_no                          		NUMBER(10)		 NULL 
);

DROP SEQUENCE order_item_oi_no_SEQ;

CREATE SEQUENCE order_item_oi_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;




CREATE TABLE review(
		review_no                     		NUMBER(10)		 NULL ,
		review_created_at             		DATE		 DEFAULT sysdate		 NULL ,
		review_updated_at             		DATE		 NULL ,
		review_comment                		VARCHAR2(2000)		 NULL ,
		review_recommend              		NUMBER(10)		 NULL ,
		review_like                   		NUMBER(10)		 NULL ,
		review_dislike                		NUMBER(10)		 NULL ,
		u_no                          		NUMBER(10)		 NULL ,
		g_no                          		NUMBER(10)		 NULL 
);

DROP SEQUENCE review_review_no_SEQ;

CREATE SEQUENCE review_review_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;




CREATE TABLE owned_game(
		og_no                         		NUMBER(10)		 NULL ,
		og_playtime                   		NUMBER(10)		 NULL ,
		og_lastplay                   		DATE		 NULL ,
		u_no                          		NUMBER(10)		 NULL ,
		g_no                          		NUMBER(10)		 NULL 
);

DROP SEQUENCE owned_game_og_no_SEQ;

CREATE SEQUENCE owned_game_og_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;




CREATE TABLE chat_room(
		cr_no                         		NUMBER(10)		 NULL ,
		cr_name                       		VARCHAR2(100)		 NULL 
);

DROP SEQUENCE chat_room_cr_no_SEQ;

CREATE SEQUENCE chat_room_cr_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;




CREATE TABLE news(
		news_no                       		NUMBER(10)		 NULL ,
		news_title                    		VARCHAR2(300)		 NULL ,
		news_header                   		VARCHAR2(1000)		 NULL ,
		news_content                  		VARCHAR2(4000)		 NULL ,
		news_img                      		VARCHAR2(100)		 NULL ,
		news_created_at               		DATE		 DEFAULT sysdate		 NULL ,
		news_updated_at               		DATE		 DEFAULT sysdate		 NULL ,
		g_no                          		NUMBER(10)		 NULL 
);

DROP SEQUENCE news_news_no_SEQ;

CREATE SEQUENCE news_news_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;




CREATE TABLE workshop(
		w_no                          		NUMBER(10)		 NULL ,
		w_name                        		VARCHAR2(100)		 NULL ,
		w_img                         		VARCHAR2(100)		 NULL ,
		w_desc                        		VARCHAR2(4000)		 NULL ,
		u_no                          		NUMBER(10)		 NULL ,
		g_no                          		NUMBER(10)		 NULL 
);

DROP SEQUENCE workshop_w_no_SEQ;

CREATE SEQUENCE workshop_w_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;




CREATE TABLE tag(
		tag_no                        		NUMBER(10)		 NULL ,
		tag_name                      		VARCHAR2(100)		 NULL 
);

DROP SEQUENCE tag_tag_no_SEQ;

CREATE SEQUENCE tag_tag_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;




CREATE TABLE language(
		lang_no                       		NUMBER(10)		 NULL ,
		lang_name                     		VARCHAR2(100)		 NULL 
);

DROP SEQUENCE language_lang_no_SEQ;

CREATE SEQUENCE language_lang_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;




CREATE TABLE card(
		card_seq                      		NUMBER(10)		 NULL ,
		card_name                     		VARCHAR2(100)		 NULL ,
		card_number                   		VARCHAR2(20)		 NULL ,
		card_ex_date                  		VARCHAR2(10)		 NULL ,
		card_cvc                      		NUMBER(10)		 NULL ,
		u_no                          		NUMBER(10)		 NULL 
);

DROP SEQUENCE card_card_seq_SEQ;

CREATE SEQUENCE card_card_seq_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;




CREATE TABLE game_tag(
		gt_no                         		NUMBER(10)		 NULL ,
		tag_no                        		NUMBER(10)		 NULL ,
		g_no                          		NUMBER(10)		 NULL 
);

DROP SEQUENCE game_tag_gt_no_SEQ;

CREATE SEQUENCE game_tag_gt_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;




CREATE TABLE resources(
		res_no                        		NUMBER(10)		 NULL ,
		res_name                      		VARCHAR2(100)		 NULL ,
		g_no                          		NUMBER(10)		 NULL 
);

DROP SEQUENCE resources_res_no_SEQ;

CREATE SEQUENCE resources_res_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;




CREATE TABLE friend(
		f_no                          		NUMBER(10)		 NULL ,
		u_no                          		NUMBER(10)		 NULL ,
		u_fno                         		NUMBER(10)		 NULL 
);

DROP SEQUENCE friend_f_no_SEQ;

CREATE SEQUENCE friend_f_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;




CREATE TABLE chat(
		chat_no                       		NUMBER(10)		 NULL ,
		chat_content                  		VARCHAR2(4000)		 NULL ,
		chat_created_at               		DATE		 DEFAULT sysdate		 NULL ,
		chat_checked                  		NUMBER(10)		 NULL ,
		u_no                          		NUMBER(10)		 NULL ,
		cr_no                         		NUMBER(10)		 NULL 
);

DROP SEQUENCE chat_chat_no_SEQ;

CREATE SEQUENCE chat_chat_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;




CREATE TABLE game_language(
		gl_no                         		NUMBER(10)		 NULL ,
		g_no                          		NUMBER(10)		 NULL ,
		lang_no                       		NUMBER(10)		 NULL 
);

DROP SEQUENCE game_language_gl_no_SEQ;

CREATE SEQUENCE game_language_gl_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;




CREATE TABLE news_comment(
		nc_no                         		NUMBER(10)		 NULL ,
		nc_created_at                 		DATE		 DEFAULT sysdate		 NULL ,
		nc_comment                    		VARCHAR2(2000)		 NULL ,
		u_no                          		NUMBER(10)		 NULL ,
		news_no                       		NUMBER(10)		 NULL 
);

DROP SEQUENCE news_comment_nc_no_SEQ;

CREATE SEQUENCE news_comment_nc_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;




CREATE TABLE news_tag(
		nt_no                         		NUMBER(10)		 NULL ,
		tag_no                        		NUMBER(10)		 NULL ,
		news_no                       		NUMBER(10)		 NULL 
);

DROP SEQUENCE news_tag_nt_no_SEQ;

CREATE SEQUENCE news_tag_nt_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;




CREATE TABLE profile_comment(
		pc_no                         		NUMBER(10)		 NULL ,
		pc_created_at                 		DATE		 DEFAULT sysdate		 NULL ,
		pc_comment                    		VARCHAR2(2000)		 NULL ,
		u_no                          		NUMBER(10)		 NULL ,
		u_fno                         		NUMBER(10)		 NULL 
);

DROP SEQUENCE profile_comment_pc_no_SEQ;

CREATE SEQUENCE profile_comment_pc_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;





ALTER TABLE userInfo ADD CONSTRAINT IDX_userInfo_PK PRIMARY KEY (u_no);

ALTER TABLE category ADD CONSTRAINT IDX_category_PK PRIMARY KEY (ct_no);

ALTER TABLE game ADD CONSTRAINT IDX_game_PK PRIMARY KEY (g_no);
ALTER TABLE game ADD CONSTRAINT IDX_game_FK0 FOREIGN KEY (ct_no) REFERENCES category (ct_no) on delete cascade;

ALTER TABLE cart ADD CONSTRAINT IDX_cart_PK PRIMARY KEY (c_no);
ALTER TABLE cart ADD CONSTRAINT IDX_cart_FK0 FOREIGN KEY (u_no) REFERENCES userInfo (u_no) on delete cascade;
ALTER TABLE cart ADD CONSTRAINT IDX_cart_FK1 FOREIGN KEY (g_no) REFERENCES game (g_no) on delete cascade;

ALTER TABLE wishlist ADD CONSTRAINT IDX_wishlist_PK PRIMARY KEY (wish_no);
ALTER TABLE wishlist ADD CONSTRAINT IDX_wishlist_FK0 FOREIGN KEY (u_no) REFERENCES userInfo (u_no) on delete cascade;
ALTER TABLE wishlist ADD CONSTRAINT IDX_wishlist_FK1 FOREIGN KEY (g_no) REFERENCES game (g_no) on delete cascade;

ALTER TABLE orders ADD CONSTRAINT IDX_orders_PK PRIMARY KEY (o_no);
ALTER TABLE orders ADD CONSTRAINT IDX_orders_FK0 FOREIGN KEY (u_no) REFERENCES userInfo (u_no) on delete cascade;

ALTER TABLE order_item ADD CONSTRAINT IDX_order_item_PK PRIMARY KEY (oi_no);
ALTER TABLE order_item ADD CONSTRAINT IDX_order_item_FK0 FOREIGN KEY (o_no) REFERENCES orders (o_no) on delete cascade;
ALTER TABLE order_item ADD CONSTRAINT IDX_order_item_FK1 FOREIGN KEY (g_no) REFERENCES game (g_no) on delete cascade;

ALTER TABLE review ADD CONSTRAINT IDX_review_PK PRIMARY KEY (review_no);
ALTER TABLE review ADD CONSTRAINT IDX_review_FK0 FOREIGN KEY (g_no) REFERENCES game (g_no) on delete cascade;
ALTER TABLE review ADD CONSTRAINT IDX_review_FK1 FOREIGN KEY (u_no) REFERENCES userInfo (u_no) on delete cascade;

ALTER TABLE owned_game ADD CONSTRAINT IDX_owned_game_PK PRIMARY KEY (og_no);
ALTER TABLE owned_game ADD CONSTRAINT IDX_owned_game_FK0 FOREIGN KEY (u_no) REFERENCES userInfo (u_no) on delete cascade;
ALTER TABLE owned_game ADD CONSTRAINT IDX_owned_game_FK1 FOREIGN KEY (g_no) REFERENCES game (g_no) on delete cascade;

ALTER TABLE chat_room ADD CONSTRAINT IDX_chat_room_PK PRIMARY KEY (cr_no);

ALTER TABLE news ADD CONSTRAINT IDX_news_PK PRIMARY KEY (news_no);
ALTER TABLE news ADD CONSTRAINT IDX_news_FK0 FOREIGN KEY (g_no) REFERENCES game (g_no) on delete cascade;

ALTER TABLE workshop ADD CONSTRAINT IDX_workshop_PK PRIMARY KEY (w_no);
ALTER TABLE workshop ADD CONSTRAINT IDX_workshop_FK0 FOREIGN KEY (u_no) REFERENCES userInfo (u_no) on delete cascade;
ALTER TABLE workshop ADD CONSTRAINT IDX_workshop_FK1 FOREIGN KEY (g_no) REFERENCES game (g_no) on delete cascade;

ALTER TABLE tag ADD CONSTRAINT IDX_tag_PK PRIMARY KEY (tag_no);

ALTER TABLE language ADD CONSTRAINT IDX_language_PK PRIMARY KEY (lang_no);

ALTER TABLE card ADD CONSTRAINT IDX_card_PK PRIMARY KEY (card_seq);
ALTER TABLE card ADD CONSTRAINT IDX_card_FK0 FOREIGN KEY (u_no) REFERENCES userInfo (u_no) on delete cascade;

ALTER TABLE game_tag ADD CONSTRAINT IDX_game_tag_PK PRIMARY KEY (gt_no);
ALTER TABLE game_tag ADD CONSTRAINT IDX_game_tag_FK0 FOREIGN KEY (tag_no) REFERENCES tag (tag_no) on delete cascade;
ALTER TABLE game_tag ADD CONSTRAINT IDX_game_tag_FK1 FOREIGN KEY (g_no) REFERENCES game (g_no) on delete cascade;

ALTER TABLE resources ADD CONSTRAINT IDX_resources_PK PRIMARY KEY (res_no);
ALTER TABLE resources ADD CONSTRAINT IDX_resources_FK0 FOREIGN KEY (g_no) REFERENCES game (g_no) on delete cascade;

ALTER TABLE friend ADD CONSTRAINT IDX_friend_PK PRIMARY KEY (f_no);
ALTER TABLE friend ADD CONSTRAINT IDX_friend_FK0 FOREIGN KEY (u_fno) REFERENCES userInfo (u_no) on delete cascade;
ALTER TABLE friend ADD CONSTRAINT IDX_friend_FK1 FOREIGN KEY (u_no) REFERENCES userInfo (u_no) on delete cascade;

ALTER TABLE chat ADD CONSTRAINT IDX_chat_PK PRIMARY KEY (chat_no);
ALTER TABLE chat ADD CONSTRAINT IDX_chat_FK0 FOREIGN KEY (u_no) REFERENCES userInfo (u_no) on delete cascade;
ALTER TABLE chat ADD CONSTRAINT IDX_chat_FK1 FOREIGN KEY (cr_no) REFERENCES chat_room (cr_no) on delete cascade;

ALTER TABLE game_language ADD CONSTRAINT IDX_game_language_PK PRIMARY KEY (gl_no);
ALTER TABLE game_language ADD CONSTRAINT IDX_game_language_FK0 FOREIGN KEY (g_no) REFERENCES game (g_no) on delete cascade;
ALTER TABLE game_language ADD CONSTRAINT IDX_game_language_FK1 FOREIGN KEY (lang_no) REFERENCES language (lang_no) on delete cascade;

ALTER TABLE news_comment ADD CONSTRAINT IDX_news_comment_PK PRIMARY KEY (nc_no);
ALTER TABLE news_comment ADD CONSTRAINT IDX_news_comment_FK0 FOREIGN KEY (u_no) REFERENCES userInfo (u_no) on delete cascade;
ALTER TABLE news_comment ADD CONSTRAINT IDX_news_comment_FK1 FOREIGN KEY (news_no) REFERENCES news (news_no) on delete cascade;

ALTER TABLE news_tag ADD CONSTRAINT IDX_news_tag_PK PRIMARY KEY (nt_no);
ALTER TABLE news_tag ADD CONSTRAINT IDX_news_tag_FK0 FOREIGN KEY (tag_no) REFERENCES tag (tag_no) on delete cascade;
ALTER TABLE news_tag ADD CONSTRAINT IDX_news_tag_FK1 FOREIGN KEY (news_no) REFERENCES news (news_no) on delete cascade;

ALTER TABLE profile_comment ADD CONSTRAINT IDX_profile_comment_PK PRIMARY KEY (pc_no);
ALTER TABLE profile_comment ADD CONSTRAINT IDX_profile_comment_FK0 FOREIGN KEY (u_no) REFERENCES userInfo (u_no) on delete cascade;
ALTER TABLE profile_comment ADD CONSTRAINT IDX_profile_comment_FK1 FOREIGN KEY (u_fno) REFERENCES userInfo (u_no) on delete cascade;

