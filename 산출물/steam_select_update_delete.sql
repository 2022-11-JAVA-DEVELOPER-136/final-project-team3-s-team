/*
select, update, delete
*/

--userinfo
update userinfo set u_id='update', u_password='update', u_name='update', u_email='update', u_phone='update', u_nickname='update', u_addr='update' where u_no=1;

delete from userinfo where u_no=1;

select * from userinfo;
select * from userinfo where u_no=1;
select count(*) from userinfo where u_no=1;


--game, category, language, news, resources
select * from game;
select * from game g join category c on g.ct_no=c.ct_no;
select * from game g join category c on g.ct_no=c.ct_no join game_language gl on g.g_no=gl.g_no join language l on gl.lang_no=l.lang_no;
select * from game g join category c on g.ct_no=c.ct_no join game_language gl on g.g_no=gl.g_no join language l on gl.lang_no=l.lang_no join news n on g.g_no=n.g_no join resources r on g.g_no=r.g_no;

select * from game g join category c on g.ct_no=c.ct_no join game_language gl on g.g_no=gl.g_no join language l on gl.lang_no=l.lang_no join news n on g.g_no=n.g_no join resources r on g.g_no=r.g_no where g.g_no=1;
select * from game g join category c on g.ct_no=c.ct_no join game_language gl on g.g_no=gl.g_no join language l on gl.lang_no=l.lang_no join news n on g.g_no=n.g_no join resources r on g.g_no=r.g_no where g.ct_no=1;


--cart
delete from cart where u_no=1;
delete from cart where c_no=1;

select * from cart where u_no=1;
select * from cart where c_no=1;
select * from cart c join game g on c.g_no=g.g_no where c.u_no=1;

select count(*) from cart where u_no=1 and g_no=1;


--orders, order_item

--유저번호로 삭제하기
delete from orders where u_no=1;
--주문번호로 삭제하기
delete from orders where o_no=1;

--유저번호로 검색하기
select * from orders where u_no=1;
--주문번호로 검색하기
select * from orders where o_no=1;
--주문목록에서 품목검색
select * from order_item where o_no=1;

--유저가 주문한 목록 검색/
select * from orders o join order_item oi on o.o_no=oi.o_no join game g on oi.g_no=g.g_no where u_no=1;
--주문번호로 상세보기
select * from orders o join order_item oi on o.o_no=oi.o_no join game g on oi.g_no=g.g_no where u_no=1 and o.o_no=1;
--주문한 게임 상세보기/
select * from orders o join userinfo u on o.u_no=u.u_no join order_item oi on o.o_no=oi.o_no join game g on oi.g_no=g.g_no where u.u_no=1;
--유저가 주문한목록에서?
select * from orders o join userinfo u on o.u_no=u.u_no join order_item oi on o.o_no=oi.o_no join game g on oi.g_no=g.g_no where u.u_no=1 and o.o_no=2;


--review
update review set review_updated_at=sysdate, review_comment='update', review_recommend=1 where review_no=1;

delete from review where review_no=1;

select * from review;
select * from review where review_no=1;
select * from review where u_no=1;
select * from review where g_no=1;