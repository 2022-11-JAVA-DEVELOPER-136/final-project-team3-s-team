/*
game
*/
--상품리스트 전체검색
select * 
from game g 
join resources res on g.g_no=res.g_no 
join game_tag gt on g.g_no=gt.g_no 
join tag t on t.tag_no=gt.tag_no;

--상품리스트에서 게임제목으로 검색
select * from game g join resources res on g.g_no=res.g_no join game_tag gt on g.g_no=gt.g_no join tag t on t.tag_no=gt.tag_no where g.g_name like '%전략%';

--상품리스트에서 카테고리, 태그, 언어로 필터링
--카테고리
select * from game g join resources res on g.g_no=res.g_no join game_tag gt on g.g_no=gt.g_no join tag t on t.tag_no=gt.tag_no join category ct on g.ct_no=ct.ct_no join game_language gl on g.g_no=gl.g_no join language l on gl.lang_no=l.lang_no
where ct.ct_name='액션';
--태그
select * from game g join resources res on g.g_no=res.g_no join game_tag gt on g.g_no=gt.g_no join tag t on t.tag_no=gt.tag_no join category ct on g.ct_no=ct.ct_no join game_language gl on g.g_no=gl.g_no join language l on gl.lang_no=l.lang_no
where t.tag_name='RPG';
--언어
select * from game g join resources res on g.g_no=res.g_no join game_tag gt on g.g_no=gt.g_no join tag t on t.tag_no=gt.tag_no join category ct on g.ct_no=ct.ct_no join game_language gl on g.g_no=gl.g_no join language l on gl.lang_no=l.lang_no
where l.lang_name='한국어';

--상품의 판매량 1 증가
update game set g_sell_count=g_sell_count+1 where g_no=1;

--인기있는 게임, 할인중인 게임 모아보기
--인기있는 게임 (판매량 내림차순)
select * from game g join resources res on g.g_no=res.g_no join game_tag gt on g.g_no=gt.g_no join tag t on t.tag_no=gt.tag_no order by g.g_sell_count desc;
--할인중인 게임
select * from game g join resources res on g.g_no=res.g_no join game_tag gt on g.g_no=gt.g_no join tag t on t.tag_no=gt.tag_no where g.g_discount_start <= sysdate and sysdate <= g.g_discount_end;

--상품상세보기
select * from game g 
join category ct on g.ct_no=ct.ct_no 
join resources res on g.g_no=res.g_no 
join game_tag gt on g.g_no=gt.g_no 
join tag t on gt.tag_no=t.tag_no 
join game_language gl on g.g_no=gl.g_no 
join language l on gl.lang_no=l.lang_no 
join news n on g.g_no=n.g_no 
join review rev on g.g_no=rev.g_no
where g.g_no=1;



--상품의 리뷰 보기
select * from game g join review rev on g.g_no=rev.g_no where g.g_no=1;

--해당 계정으로 해당 상품에 리뷰를 작성했는지 여부를 확인
select count(*) from review where u_no=1 and g_no=1;

--상품의 리뷰 작성하기 (소유한 게임에 대해서 계정당 1번만 작성할 수 있다.)
insert into review(review_no, review_created_at, review_updated_at, review_comment, review_recommend, u_no, g_no) values(REVIEW_REVIEW_NO_SEQ.nextval, sysdate, sysdate, '리뷰1', 0, 1, 1);

--상품의 리뷰 삭제하기
delete from review where u_no=1 and g_no=1;



--게임의 태그, 언어를 insert 하는 기능을 넣는다면 필요한 기능.
--게임의 태그 중복 확인 (이름으로)
select count(*) from game g join game_tag gt on g.g_no=gt.g_no join tag t on gt.tag_no=t.tag_no where g.g_no=1 and t.tag_name='액션';

--게임의 언어 중복 확인 (이름으로)
select count(*) from game g join game_language gl on g.g_no=gl.g_no join language l on gl.lang_no=l.lang_no where g.g_no=1 and l.lang_name='한국어';


select ct_name from category;
select tag_name from tag;
select lang_name from language;

--게임 발매일 순 정렬 (최신순)
select * 
		from game g 
		join resources res on g.g_no=res.g_no 
		join game_tag gt on g.g_no=gt.g_no 
		join tag t on t.tag_no=gt.tag_no 
		order by g.g_release_date desc;
        
select * 
		from game g 
		join game_tag gt on g.g_no=gt.g_no 
		join tag t on t.tag_no=gt.tag_no 
        where t.tag_name='인디' or t.tag_name='액션';
        
select * from game g 
join category ct on g.ct_no=ct.ct_no 
join resources res on g.g_no=res.g_no 
join game_tag gt on g.g_no=gt.g_no 
join tag t on gt.tag_no=t.tag_no 
join game_language gl on g.g_no=gl.g_no 
join language l on gl.lang_no=l.lang_no 
join news n on g.g_no=n.g_no 
join review rev on g.g_no=rev.g_no
where ct.ct_no in (1, 2) and t.tag_no in (1, 2) and l.lang_no in (1, 2);