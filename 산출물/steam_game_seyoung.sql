/*
game
*/
--상품리스트 보여주기
select * from game g join resources res on g.g_no=res.g_no join tag_game tg on g.g_no=tg.g_no join tag t on t.tag_no=tg.tag_no;

--상품리스트에서 게임제목으로 검색
select * from game g join resources res on g.g_no=res.g_no join tag_game tg on g.g_no=tg.g_no join tag t on t.tag_no=tg.tag_no where g.g_name like '%전략%';

--상품리스트에서 카테고리, 태그, 언어로 필터링
--카테고리
select * from game g join resources res on g.g_no=res.g_no join tag_game tg on g.g_no=tg.g_no join tag t on t.tag_no=tg.tag_no join category ct on g.ct_no=ct.ct_no join language l on g.g_no=l.g_no
where ct.ct_name='액션';
--태그
select * from game g join resources res on g.g_no=res.g_no join tag_game tg on g.g_no=tg.g_no join tag t on t.tag_no=tg.tag_no join category ct on g.ct_no=ct.ct_no join language l on g.g_no=l.g_no
where t.tag_name='RPG';
--언어
select * from game g join resources res on g.g_no=res.g_no join tag_game tg on g.g_no=tg.g_no join tag t on t.tag_no=tg.tag_no join category ct on g.ct_no=ct.ct_no join language l on g.g_no=l.g_no
where l.lang_name='한국어';

--상품의 판매량 1 증가
update game set g_sell_count=g_sell_count+1 where g_no=1;

--인기있는 게임, 할인중인 게임 모아보기
--인기있는 게임 (판매량 내림차순)
select * from game g join resources res on g.g_no=res.g_no join tag_game tg on g.g_no=tg.g_no join tag t on t.tag_no=tg.tag_no order by g.g_sell_count desc;
--할인중인 게임
--할인 테이블 미정

--상품상세보기
select * from game g 
join category ct on g.ct_no=ct.ct_no 
join resources res on g.g_no=res.g_no 
join tag_game tg on g.g_no=tg.g_no 
join tag t on tg.tag_no=t.tag_no 
join language l on g.g_no=l.g_no 
join news n on g.g_no=n.g_no 
join review rev on g.g_no=rev.g_no
where g.g_no=1;

--상품의 리뷰 보기
select * from game g join review rev on g.g_no=rev.g_no where g.g_no=1;

--해당 계정으로 해당 상품에 리뷰를 작성했는지 여부를 확인
select count(*) from review where u_no=1 and g_no=1;

--상품의 리뷰 작성하기 (소유한 게임에 대해서 계정당 1번만 작성할 수 있다.)
insert into review(review_no, review_date, review_comment, review_recommend, u_no, g_no) values(REVIEW_REVIEW_NO_SEQ.nextval, sysdate, '리뷰1', 0, 1, 1);

--상품의 리뷰 삭제하기
delete from review where u_no=1 and g_no=1;