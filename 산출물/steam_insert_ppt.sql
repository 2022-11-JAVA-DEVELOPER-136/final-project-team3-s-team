/*
insert
*/

--userinfo
/*
u_state는 상태를 표시. (0: 로그아웃, 1:로그인)
*/
insert into userinfo(u_no, u_id, u_password, u_name, u_email, u_phone, u_nickname, u_street, u_city, u_statefull, u_zip, u_state, u_img_profile, u_img_background, u_about) 
values(USERINFO_U_NO_SEQ.nextval, 'sy0', '0000', '김세영', 'sy0@gmail.com', '010-0000-0000', 'sy0_닉네임', 'street_0', 'city_0', 'statefull_0', '00000', 1, 'profile.jpg', 'background.jpg', 'sy0의 프로필입니다.');
insert into userinfo(u_no, u_id, u_password, u_name, u_email, u_phone, u_nickname, u_street, u_city, u_statefull, u_zip, u_state, u_img_profile, u_img_background, u_about) 
values(USERINFO_U_NO_SEQ.nextval, 'sy1', '1111', '김세일', 'sy1@gmail.com', '010-1111-1111', 'sy1_닉네임', 'street_1', 'city_1', 'statefull_1', '11111', 1, 'profile.jpg', 'background.jpg', 'sy1의 프로필입니다.');
insert into userinfo(u_no, u_id, u_password, u_name, u_email, u_phone, u_nickname, u_street, u_city, u_statefull, u_zip, u_state, u_img_profile, u_img_background, u_about) 
values(USERINFO_U_NO_SEQ.nextval, 'sy2', '2222', '김세이', 'sy2@gmail.com', '010-2222-2222', 'sy2_닉네임', 'street_2', 'city_2', 'statefull_2', '22222', 1, 'profile.jpg', 'background.jpg', 'sy2의 프로필입니다.');


--friend
/*
u_no는 친구요청을 보내는 user의 u_no
u_fno는 친구요청을 받아서 수락한 user의 u_no
friend테이블에서 u_no와 u_fno의 조합은 유일해야 한다. (UNIQUE)
*/
insert into friend(f_no, u_no, u_fno) values(FRIEND_F_NO_SEQ.nextval, 1, 2);
insert into friend(f_no, u_no, u_fno) values(FRIEND_F_NO_SEQ.nextval, 1, 3);
insert into friend(f_no, u_no, u_fno) values(FRIEND_F_NO_SEQ.nextval, 2, 3);


--card
insert into card(card_seq, card_name, card_number, card_ex_date, card_cvc, u_no) values(CARD_CARD_SEQ_SEQ.nextval, 'sy0_카드_1', '1111-1111-1111-1111', '02/24', 111, 1);
insert into card(card_seq, card_name, card_number, card_ex_date, card_cvc, u_no) values(CARD_CARD_SEQ_SEQ.nextval, 'sy1_카드_1', '1234-1234-1234-1234', '03/26', 123, 2);
insert into card(card_seq, card_name, card_number, card_ex_date, card_cvc, u_no) values(CARD_CARD_SEQ_SEQ.nextval, 'sy2_카드_1', '2222-2222-2222-2222', '05/25', 222, 3);


--category
insert into category(ct_no, ct_name, ct_img) values(CATEGORY_CT_NO_SEQ.nextval, '액션', 'action.jpg');
insert into category(ct_no, ct_name, ct_img) values(CATEGORY_CT_NO_SEQ.nextval, 'RPG', 'rpg.jpg');
insert into category(ct_no, ct_name, ct_img) values(CATEGORY_CT_NO_SEQ.nextval, '전략', 'strategy.jpg');
insert into category(ct_no, ct_name, ct_img) values(CATEGORY_CT_NO_SEQ.nextval, '어드벤쳐', 'adventure.jpg');
insert into category(ct_no, ct_name, ct_img) values(CATEGORY_CT_NO_SEQ.nextval, '스포츠', 'sports.jpg');
insert into category(ct_no, ct_name, ct_img) values(CATEGORY_CT_NO_SEQ.nextval, '인디', 'indie.jpg');


--game
/*
g_grade : 게임의 평점 (해당 게임의 사용자리뷰의 평균평점)
*/
--액션 : 1
--1
insert into game
(g_no, g_name, g_short_desc, g_long_desc, g_grade, g_release_date, g_developer, g_distributor, g_price, g_discount_rate, g_discount_start, g_discount_end,
g_os, g_prosessor, g_memory, g_graphic, g_disk_space, g_min_os, g_min_prosessor, g_min_memory, g_min_graphic, g_min_disk_space, g_sell_count, ct_no)
values
(GAME_G_NO_SEQ.nextval,
'Red Dead Redemption 2',
'올해의 게임 175여 개를 수상하고 250개 이상의 완벽한 평가를 받은 Red Dead Redemption 2는 현대 시대가 시작될 무렵 무법자인 아서 모건과 악명 높은 반 더 린드 갱단이 미국 전역을 따라 도주하는 장대한 서사시입니다. 모두가 함께 즐길 수 있는 생생한 세계인 Red Dead 온라인 역시 포함됩니다.',
'1899년 미국.

아서 모건과 반 더 린드 갱단은 도주 중인 무법자입니다. 정부 요원과 일류 현상금 사냥꾼들에게 추격당하는 그들은 살아남기 위해 강도질과 도둑질, 싸움을 거듭하며 미국의 험난한 심장부를 달려 나갑니다. 심해져 가는 내부 갈등으로 갱이 해체될 위기 속에서, 아서는 자기를 키워 준 갱에 대한 의리와 자신의 이상 중 하나를 선택해야만 합니다.

이제 추가 스토리 모드 콘텐츠와 사진 모드를 완벽히 즐길 수 있는 Red Dead Redemption 2에서 모두가 함께 즐길 수 있는 생생한 세계인 Red Dead 온라인을 무료로 플레이할 수 있습니다. 플레이어는 여러 개의 직업을 맡아 개척지에서 자신만의 독특한 길을 개척해나갈 수 있습니다. 현상금 사냥꾼이 되어 범죄자를 추적할 수 있고, 상인이 되어 사업을 운영할 수 있습니다. 아니면 수집가가 되어 이국적인 보물을 발굴하거나 밀주업자가 되어 비밀스러운 양조장을 운영하는 등 다양한 활동을 할 수 있습니다.

더욱 깊이 몰입할 수 있도록 완전히 새롭게 향상된 그래픽과 기술적인 요소를 갖춘 PC용 Red Dead Redemption 2는 PC의 성능을 최대로 활용하여 이 방대하고 풍부하며 생생한 세계의 구석구석에 생명을 불어넣었습니다. 늘어난 가시거리, 고품질의 글로벌 일루미네이션과 주변 폐색으로 개선된 낮과 밤의 조명, 반사 효과 향상, 어떤 거리에서도 더 깊이 있고 높은 해상도의 그림자, 테셀레이션 나무 텍스처, 향상된 잔디와 모피 텍스처 등이 모든 식물과 동물에 사실감을 불어넣습니다.

PC용 Red Dead Redemption 2는 HDR을 지원하며, 4K 이상의 해상도나 다중 모니터 설정, 와이드 스크린 설정, 고속 주사율 등 하이엔드 디스플레이 설정에서 실행할 수 있는 기능을 제공합니다.',
9,
to_date('2019/12/06'),
'Rockstar Games',
'Rockstar Games',
66000,
67,
to_date('2023/04/25'),
to_date('2023/05/25'),
'Windows 10 - April 2018 Update (v1803)',
'Intel® Core™ i7-4770K / AMD Ryzen 5',
'12 GB RAM',
'Nvidia GeForce GTX 1060 6GB / AMD Radeon RX 480 4GB',
'150 GB',
'Windows 10 - April 2018 Update (v1803)',
'Intel® Core™ i7-4770K / AMD Ryzen 5',
'12 GB RAM',
'Nvidia GeForce GTX 1060 6GB / AMD Radeon RX 480 4GB',
'150 GB',
1788,
1);

--2
insert into game
(g_no, g_name, g_short_desc, g_long_desc, g_grade, g_release_date, g_developer, g_distributor, g_price, g_discount_rate, g_discount_start, g_discount_end,
g_os, g_prosessor, g_memory, g_graphic, g_disk_space, g_min_os, g_min_prosessor, g_min_memory, g_min_graphic, g_min_disk_space, g_sell_count, ct_no)
values
(GAME_G_NO_SEQ.nextval,
'스타워즈 제다이: 서바이버™',
'3인칭 액션 어드벤처 게임 스타워즈 제다이: 서바이버™에서 칼 케스티스의 이야기가 계속 이어집니다.',
'스타워즈 제다이: 서바이버™에서 칼 케스티스의 이야기가 계속 이어집니다. Respawn Entertainment와 Lucasfilm Games가 공동으로 개발한 3인칭 액션 어드벤처 게임에서 은하계를 누벼 보세요. 스토리 기반의 싱글 플레이어 게임은 스타워즈 제다이: 오더의 몰락™의 5년 후 이야기를 다루며, 은하계가 더욱 깊은 어둠 속으로 떨어지는 것을 막기 위해 점차 필사적으로 싸우게 되는 칼의 여정을 따라갑니다. 제국에 의해 은하계의 가장자리로 밀려나게 된 칼은 새롭고도 익숙한 적들을 마주하게 됩니다. 마지막으로 살아남은 제다이 기사 중 한 명인 칼은 은하계의 가장 어두운 시기에 맞서려고 합니다. 하지만 자기 자신, 소중한 동료들, 제다이 오더의 유산을 지키기 위해 그는 어디까지 싸울 수 있을까요?',
9,
to_date('2023/4/28'),
'Respawn',
'Electronic Arts',
77000,
0,
null,
null,
'Windows 10 64-bit',
'4 core / 8 threads | Intel Core i5 11600K | Ryzen 5 5600X',
'16 GB RAM',
'8GB VRAM | RTX2070 | RX 6700 XT',
'155 GB',
'Windows 10 64-bit',
'4 core / 8 threads | Intel Core i7-7700 | Ryzen 5 1400',
'8 GB RAM',
'8GB VRAM | GTX 1070 | Radeon RX 580',
'155 GB',
0,
1);

--3
insert into game
(g_no, g_name, g_short_desc, g_long_desc, g_grade, g_release_date, g_developer, g_distributor, g_price, g_discount_rate, g_discount_start, g_discount_end,
g_os, g_prosessor, g_memory, g_graphic, g_disk_space, g_min_os, g_min_prosessor, g_min_memory, g_min_graphic, g_min_disk_space, g_sell_count, ct_no)
values
(GAME_G_NO_SEQ.nextval,
'Cyberpunk 2077',
'사이버펑크 2077은 권력과 돈, 끝없는 신체 개조에 집착하는 어두운 미래의 위험천만한 메갈로폴리스, 나이트 시티를 배경으로 한 오픈 월드 액션 어드벤처 RPG입니다.',
'사이버펑크 2077은 나이트 시티의 메갈로폴리스에서 펼쳐지는 오픈월드 액션 어드벤처 RPG입니다. 여러분은 사이버펑크 용병이 되어 생존을 위해 목숨을 걸고 싸워야 합니다. 개선 사항이 적용되고 새로운 무료 콘텐츠가 추가된 어두운 미래에서, 임무를 완수하여 평판을 쌓고 업그레이드를 잠금 해제하여 나만의 캐릭터와 플레이 스타일을 만들어 보세요. 여러분이 만들어나가는 관계와 선택에 따라, 여러분을 둘러싼 세계가 변화할 것입니다. 나이트 시티는 전설이 태어나는 곳입니다. 여러분은 어떤 전설을 써 내려가시겠습니까?',
9,
to_date('2020/12/10'),
'CD PROJEKT RED',
'CD PROJEKT RED',
66000,
50,
to_date('2023/04/22'),
to_date('2023/05/22'),
'Windows 10',
'Intel Core i7-4790 or AMD Ryzen 3 3200G',
'12 GB RAM',
'GTX 1060 6GB / GTX 1660 Super or Radeon RX 590',
'70 GB',
'Windows 10',
'Intel Core i5-3570K or AMD FX-8310',
'8 GB RAM',
'NVIDIA GeForce GTX 970 or AMD Radeon RX 470',
'70 GB',
1268,
1);

--4
insert into game
(g_no, g_name, g_short_desc, g_long_desc, g_grade, g_release_date, g_developer, g_distributor, g_price, g_discount_rate, g_discount_start, g_discount_end,
g_os, g_prosessor, g_memory, g_graphic, g_disk_space, g_min_os, g_min_prosessor, g_min_memory, g_min_graphic, g_min_disk_space, g_sell_count, ct_no)
values
(GAME_G_NO_SEQ.nextval,
'콜 오브 듀티®: 모던 워페어 II | 워존 2.0',
'콜 오브 듀티®: 모던 워페어 II 2022는 세계를 무대로 펼쳐지는 전례 없는 규모의 분쟁으로 플레이어를 인도합니다. 또한, 상징적인 태스크 포스 141의 오퍼레이터가 귀환합니다.',
'콜 오브 듀티®의 새로운 시대에 오신 것을 환영합니다.

콜 오브 듀티®: 모던 워페어 II 2022는 세계를 무대로 펼쳐지는 전례 없는 규모의 분쟁으로 플레이어를 인도합니다. 또한, 상징적인 태스크 포스 141의 오퍼레이터가 귀환합니다. 소규모 고위험 침투 전술 작전부터 고도의 기밀 임무까지, 친구와 함께 몰입도가 높은 플레이를 경험할 수 있습니다.

Infinity Ward가 최신 게임 플레이어와 더불어 완전히 새롭게 바뀐 무기 핸들링, 발전한 AI 시스템, 새로운 총기 개조, 그리고 프랜차이즈를 한 단계 더 높은 수준으로 올려놓은 다수의 게임플레이와 그래픽 혁신을 선보입니다.

모던 워페어 II 2022에서는 방대한 규모의 싱글 캠페인, 몰입감 높은 멀티플레이어 전투, 첨단 특수 부대가 펼치는 택티컬 코옵 게임플레이를 즐길 수 있습니다.

또한, 콜 오브 듀티®: 워존 2.0으로 완전히 새로운 배틀 로얄을 만끽할 수 있습니다.',
9,
to_date('2022/10/28'),
'Infinity Ward',
'Activision',
84500,
35,
to_date('2023/04/24'),
to_date('2023/05/24'),
'Windows 10',
'Intel® Core™ i5-6600K / Core™ i7-4770 또는 AMD Ryzen™ 5 1400',
'12 GB RAM',
'NVIDIA® GeForce® GTX 1060 또는 AMD Radeon™ RX 580',
'125 GB',
'Windows 10',
'Intel® Core™ i3-6100 / Core™ i5-2500K 또는 AMD Ryzen™ 3 1200',
'8 GB RAM',
' NVIDIA® GeForce® GTX 960 또는 AMD Radeon™ RX 470',
'125 GB',
977,
1);

--5
insert into game
(g_no, g_name, g_short_desc, g_long_desc, g_grade, g_release_date, g_developer, g_distributor, g_price, g_discount_rate, g_discount_start, g_discount_end,
g_os, g_prosessor, g_memory, g_graphic, g_disk_space, g_min_os, g_min_prosessor, g_min_memory, g_min_graphic, g_min_disk_space, g_sell_count, ct_no)
values
(GAME_G_NO_SEQ.nextval,
'MONSTER HUNTER RISE',
'역동하는 사냥 본능! 사냥에 새로운 바람을 불러일으킬, 종횡무진으로 도약하는 액션. 마음 가는 대로 달릴 수 있는 필드. 미지의 흥분과 놀라움을 선사할 새로운 몬스터들. 이제껏 없었던 사냥 체험이 「MONSTER HUNTER RISE」에서 헌터들을 기다린다!',
'새로운 바람을 불러일으키는 "밧줄벌레" 액션
지시한 방향으로 날아가면서 특수한 "벌레철사"로 헌터를 끌어당기는 밧줄벌레는 사냥을 더욱 진화시키며, 무기마다 다른 특색이 있는 공격과 조합하면 새로운 헌팅 액션이 탄생한다!',
9,
to_date('2022/1/13'),
'CAPCOM Co., Ltd.',
'CAPCOM Co., Ltd.',
76400,
35,
to_date('2023/04/20'),
to_date('2023/05/20'),
'Windows 10',
'Intel® Core™ i5-4460 or AMD FX™-8300',
'8 GB RAM',
'NVIDIA® GeForce® GTX 1060 (VRAM 3GB)',
'36 GB',
'Windows 10',
'Intel® Core™ i3-4130 or Core™ i5-3470 or AMD FX™-6100',
'8 GB RAM',
'NVIDIA® GeForce® GT 1030 (DDR4) or AMD Radeon™ RX 550',
'36 GB',
756,
1);

--6
insert into game
(g_no, g_name, g_short_desc, g_long_desc, g_grade, g_release_date, g_developer, g_distributor, g_price, g_discount_rate, g_discount_start, g_discount_end,
g_os, g_prosessor, g_memory, g_graphic, g_disk_space, g_min_os, g_min_prosessor, g_min_memory, g_min_graphic, g_min_disk_space, g_sell_count, ct_no)
values
(GAME_G_NO_SEQ.nextval,
'Limbus Company',
'림버스 컴퍼니의 관리자가 되어 12명의 수감자를 이끌고, 폐쇄된 로보토미 코퍼레이션 지부로 들어가 황금가지를 탈환하세요.',
'턴제 RPG와 실시간 전투의 결합
매 턴마다 동시 다발적으로 이루어지는 화려한 난투.
전투는 아군과 적이 차례를 기다리지 않고 동시에 진행됩니다.
그 과정에서 아군과 적군의 스킬이 서로 부딪히는 경우가 있으며, 이를 합이라고 합니다.
스킬의 강함과 운에 따라 합의 승패가 결정되며, 합에서 승리하면 상대의 스킬을 취소시킬 수 있습니다.
적절한 스킬을 선택하여 합을 이기세요.',
9,
to_date('2023/2/27'),
'ProjectMoon',
'ProjectMoon',
55000,
20,
to_date('2023/04/20'),
to_date('2023/05/20'),
'Windows 10',
'Intel Core i5',
'8 GB RAM',
'GeForce GT 1030',
'10 GB',
'Windows 10',
'Intel Core i5',
'8 GB RAM',
'GeForce GT 1030',
'10 GB',
876,
1);

--7
insert into game
(g_no, g_name, g_short_desc, g_long_desc, g_grade, g_release_date, g_developer, g_distributor, g_price, g_discount_rate, g_discount_start, g_discount_end,
g_os, g_prosessor, g_memory, g_graphic, g_disk_space, g_min_os, g_min_prosessor, g_min_memory, g_min_graphic, g_min_disk_space, g_sell_count, ct_no)
values
(GAME_G_NO_SEQ.nextval,
'Grand Theft Auto V',
'PC용 Grand Theft Auto V는 각종 수상에 빛나는 로스 산토스와 블레인 카운티의 거대한 세상을 최대 4K 이상의 해상도로 둘러볼 수 있는 기회를 플레이어에게 제공하며, 초당 60프레임으로 게임을 실행할 수도 있습니다.',
'어느 날 문득, 동네 건달과 은퇴한 은행 강도, 미치광이 사이코패스는 자신들이 어두운 범죄 세계와 미국 정부 기관, 엔터테인먼트 회사의 가장 끔찍하고 무시무시한 현실과 복잡하게 얽혀 있다는 걸 깨닫습니다. 아무도 믿을 수 없는, 서로조차 믿을 수 없는 이 무자비한 도시에서 살아남기 위해 그들은 여러 번의 위험한 습격에 몸을 던져야 합니다.

PC용 Grand Theft Auto V는 각종 수상에 빛나는 로스 산토스와 블레인 카운티의 거대한 세상을 최대 4K 이상의 해상도로 둘러볼 수 있는 기회를 플레이어에게 제공하며, 초당 60프레임으로 게임을 실행할 수도 있습니다.

게임에서는 PC 사양에 따라 다양하게 설정할 수 있는 세분화된 옵션을 제공합니다. 텍스처 품질, 셰이더, 테셀레이션, 안티 앨리어싱 등 25개 이상의 개별 설정 옵션을 포함하여, 키보드와 마우스 조작을 자유롭게 지정할 수 있는 다양한 옵션도 지원합니다. 또한, 인구 밀도 슬라이더를 사용해 차량과 보행자의 통행량을 조정할 수 있을 뿐 아니라, 듀얼 모니터와 트리플 모니터 지원, 3D 호환성, 플러그 앤 플레이 컨트롤러 지원 등의 기능도 포함되어 있습니다.

PC용 Grand Theft Auto V에는 Grand Theft Auto 온라인도 포함되어 있으며, 30명의 플레이어와 2명의 관전자를 지원합니다. PC용 Grand Theft Auto 온라인은 습격과 대적 모드를 포함하여 Grand Theft Auto 온라인 서비스가 시작된 이후에 실시된 지금까지의 모든 게임 플레이 업그레이드와 Rockstar 제작 콘텐츠가 포함되어 있습니다.

PC용 Grand Theft Auto V와 Grand Theft Auto 온라인에서는 1인칭 모드도 지원하므로, 플레이어는 로스 산토스와 블레인 카운티의 놀랍도록 세밀한 세상을 완전히 새로운 방식으로 둘러볼 수 있습니다.

PC용 Grand Theft Auto V에서 처음으로 선보이는 Rockstar 편집기는 Grand Theft Auto V와 Grand Theft Auto 온라인에서 쉽고 간편하게 게임 영상을 녹화하고 편집, 공유할 수 있는 강력한 제작 도구입니다. Rockstar 편집기의 디렉터 모드에서는 플레이어가 주요 스토리 캐릭터나 시민, 심지어 동물까지 캐스팅해서 생명을 불어넣고 원하는 장면을 직접 연출할 수 있습니다. 패스트 모션과 슬로우 모션, 다양한 카메라 필터, GTAV 라디오 방송국에서 원하는 음악을 추가하거나 게임의 오리지널 스코어를 삽입하고 역동적으로 강약을 조절할 수 있는 등의 효과를 편집하고 세밀한 카메라 조정도 가능합니다. 완성된 동영상은 Rockstar 편집기에서 곧바로 YouTube와 Rockstar Games Social Club에 업로드해서 쉽게 공유할 수 있습니다.

사운드트랙 아티스트인 The Alchemist와 Oh No가 돌아와서 새로운 라디오 방송국인 The Lab FM을 진행합니다. 이 방송국에서는 게임의 오리지널 사운드트랙에서 영감을 받아 둘이 함께 만든 새로운 독점 음악을 제공합니다. Earl Sweatshirt, Freddie Gibbs, Little Dragon, Killer Mike, Future Islands의 Sam Herring 및 그 외 많은 아티스트가 게스트로 참여합니다. 또한, 플레이어가 직접 만든 사운드트랙으로 진행되는 새로운 라디오 방송국인 셀프 라디오를 선택해서 자신만의 음악을 즐기며 로스 산토스와 블레인 카운티를 돌아다닐 수도 있습니다.',
9,
to_date('2015/4/12'),
'Rockstar North',
'Rockstar Games',
44000,
63,
to_date('2023/04/24'),
to_date('2023/05/24'),
'Windows 8',
'인텔 코어 i5 3470 @ 3.2GHZ (4 CPU) / AMD X8 FX-8350 @ 4GHZ (8 CPU)',
'8 GB RAM',
'NVIDIA GTX 660 2GB / AMD HD7870 2GB',
'72 GB',
'Windows 8',
'인텔 코어 2 쿼드 CPU Q6600 @ 2.40GHz',
'4 GB RAM',
'NVIDIA 9800 GT 1GB / AMD HD 4870 1GB (DX 10, 10.1, 11)',
'72 GB',
5678,
1);

--8
insert into game
(g_no, g_name, g_short_desc, g_long_desc, g_grade, g_release_date, g_developer, g_distributor, g_price, g_discount_rate, g_discount_start, g_discount_end,
g_os, g_prosessor, g_memory, g_graphic, g_disk_space, g_min_os, g_min_prosessor, g_min_memory, g_min_graphic, g_min_disk_space, g_sell_count, ct_no)
values
(GAME_G_NO_SEQ.nextval,
'Apex 레전드™',
'Apex 레전드는 Respawn Entertainment에서 제작한 다양한 수상 경력을 자랑하는 무료 플레이 히어로 슈팅 게임입니다. 게임에 계속해서 추가되는 레전드 캐릭터들의 강력한 능력을 마스터하고 깊이 있는 전술적 분대 플레이, 새롭게 진화하는 게임플레이를 지닌 히어로 슈팅과 배틀 로얄의 혁신을 경험하세요.',
'무료 플레이* 히어로 슈팅 게임 Apex 레전드에서 나만의 캐릭터로 전장을 점령하세요. 강력한 능력을 지닌 레전드 캐릭터들이 힘을 합쳐 프런티어의 변경에서 영예와 부를 차지하기 위한 전투에 뛰어드세요.

계속 추가되는 레전드, 깊이 있는 전술적 분대 플레이, 배틀 로얄 그 이상의 혁신을 경험하세요. 이 모든 것이 어떤 제약도 없는 거친 세계에서 펼쳐집니다. 새롭게 진화한 히어로 슈팅을 플레이하세요.',
9,
to_date('2020/11/5'),
'Respawn Entertainment',
'Electronic Arts',
0,
0,
null,
null,
'Windows 7',
'Ryzen 5 CPU or Equivalent',
'8 GB RAM',
'AMD Radeon™ R9 290, NVIDIA GeForce® GTX 970',
'56 GB',
'Windows 7',
'AMD FX 4350 or Equivalent, Intel Core i3 6300 or Equivalent',
'6 GB RAM',
'AMD Radeon™ HD 7730, NVIDIA GeForce® GT 640',
'56 GB',
8695,
1);

--9
insert into game
(g_no, g_name, g_short_desc, g_long_desc, g_grade, g_release_date, g_developer, g_distributor, g_price, g_discount_rate, g_discount_start, g_discount_end,
g_os, g_prosessor, g_memory, g_graphic, g_disk_space, g_min_os, g_min_prosessor, g_min_memory, g_min_graphic, g_min_disk_space, g_sell_count, ct_no)
values
(GAME_G_NO_SEQ.nextval,
'Hades',
'Bastion, Transistor, Pyre의 제작사에서 선보이는 이 로그라이크 던전 탐색형 게임에서 핵 앤 슬래시로 지하 세계를 탈출하고 죽음의 신에게 도전하세요.',
'Hades는 Supergiant의 호평을 받았던 전작들에서 장점만 가져온 로그라이크 던전 탐색형 게임입니다. Bastion의 빠른 액션과 Transistor의 풍부한 분위기 및 깊이, Pyre의 캐릭터 중심 스토리텔링이 한 작품에 담겼습니다.
지옥을 벗어나기 위한 싸움
여러분은 지하 세계의 불멸의 왕자가 되어 죽은 자들의 신에게서 벗어나기 위해 올림포스의 신화 속 무기들과 힘을 휘두르게 됩니다. 매번 탈출을 시도할 때마다 더 강해지면서 스토리가 진행됩니다.
올림포스의 분노를 발산하세요
올림포스 신들이 여러분의 뒤에 있습니다! 제우스, 아테나, 포세이돈 등 수많은 신을 만나고 신들의 강력한 보물을 선택하여 여러분의 능력을 강화하세요. 게임이 진행될수록 수없이 다양한 캐릭터 육성이 가능해집니다.',
9,
to_date('2020/9/17'),
'Supergiant Games',
'Supergiant Games',
27000,
50,
to_date('2023/4/10'),
to_date('2023/5/10'),
'Windows 7',
'Dual Core 2.4 GHz',
'4 GB RAM',
'1GB VRAM / DirectX 10+ support',
'15 GB',
'Windows 7',
'Dual Core 2.4 GHz',
'4 GB RAM',
'1GB VRAM / DirectX 10+ support',
'15 GB',
3368,
1);

--10
insert into game
(g_no, g_name, g_short_desc, g_long_desc, g_grade, g_release_date, g_developer, g_distributor, g_price, g_discount_rate, g_discount_start, g_discount_end,
g_os, g_prosessor, g_memory, g_graphic, g_disk_space, g_min_os, g_min_prosessor, g_min_memory, g_min_graphic, g_min_disk_space, g_sell_count, ct_no)
values
(GAME_G_NO_SEQ.nextval,
'BIOHAZARD RE:4',
'죽음을 피하고, 쓰러트리는 쾌감. 전례 없는 생물 재해 "라쿤 사건"으로부터 6년― 대통령 직속 요원이 된 레온 S. 케네디에게 주어진, 유괴된 대통령 영애의 구출 임무. "광기"에 지배된 마을에 발을 들이게 된 레온은… 생과 사, 공포와 카타르시스가 교차되는 가혹한 구출극의 막이 지금 열립니다. 직감적인 조작과 최신',
'죽음을 피하고, 쓰러트리는 쾌감.

전례 없는 생물 재해 "라쿤 사건"으로부터 6년―
대통령 직속 요원이 된 레온 S. 케네디에게 주어진, 유괴된 대통령 영애의 구출 임무.
"광기"에 지배된 마을에 발을 들이게 된 레온은…
생과 사, 공포와 카타르시스가 교차되는 가혹한 구출극의 막이 지금 열립니다.

직감적인 조작과 최신 그래픽, 재구성된 스토리와 함께 다시 살아나는 서바이벌 호러.',
9,
to_date('2023/3/24'),
'CAPCOM Co., Ltd.',
'CAPCOM Co., Ltd.',
72700,
0,
null,
null,
'Windows 10',
'AMD Ryzen 3 1200 / Intel Core i5-7500',
'8 GB RAM',
'AMD Radeon RX 560 with 4GB VRAM / NVIDIA GeForce GTX 1050 Ti with 4GB VRAM',
'90 GB',
'Windows 7',
'AMD Ryzen 3 1200 / Intel Core i5-7500',
'8 GB RAM',
'AMD Radeon RX 560 with 4GB VRAM / NVIDIA GeForce GTX 1050 Ti with 4GB VRAM',
'90 GB',
1978,
1);

--RPG : 2
--11
insert into game
(g_no, g_name, g_short_desc, g_long_desc, g_grade, g_release_date, g_developer, g_distributor, g_price, g_discount_rate, g_discount_start, g_discount_end,
g_os, g_prosessor, g_memory, g_graphic, g_disk_space, g_min_os, g_min_prosessor, g_min_memory, g_min_graphic, g_min_disk_space, g_sell_count, ct_no)
values
(GAME_G_NO_SEQ.nextval,
'Sun Haven',
'Build your farm and relationships with townsfolk, or forge ahead on a quest of magic, monsters, and dragons. Level up through a skill tree in 8 person multiplayer, or adventure solo!',
'A train ride to a new life!
You have just arrived in Sun Haven… only to find it’s been struck by dark magic! With only a handful of money and some rusty tools in hand, it’s up to you to build the farm of your dreams. Grow crops, raise livestock, craft items, mine ores, defeat bosses, catch fish, cook recipes, decorate your farm, complete quests, fall in love, and explore what lies beyond the forests of this medieval town. Can you become the hero of Sun Haven and stop the darkness before it’s too late?',
9,
to_date('2023/3/11'),
'Pixel Sprout Studios',
'Pixel Sprout Studios',
26000,
20,
to_date('2023/4/21'),
to_date('2023/5/21'),
'Windows Vistar',
'2 GHz',
'4 GB RAM',
'3GB Video Memory',
'10 GB',
'Windows Vistar',
'2 GHz',
'4 GB RAM',
'3GB Video Memory',
'10 GB',
554,
2);

--12
insert into game
(g_no, g_name, g_short_desc, g_long_desc, g_grade, g_release_date, g_developer, g_distributor, g_price, g_discount_rate, g_discount_start, g_discount_end,
g_os, g_prosessor, g_memory, g_graphic, g_disk_space, g_min_os, g_min_prosessor, g_min_memory, g_min_graphic, g_min_disk_space, g_sell_count, ct_no)
values
(GAME_G_NO_SEQ.nextval,
'호그와트 레거시',
'호그와트 레거시는 몰입형 오픈월드 액션 RPG입니다. 이제 여러분도 꿈에 그리던 마법 세계에 직접 영향을 끼칠 수 있습니다. 마법 세계에서 펼쳐지는 모험의 주인공이 되어보세요.',
'호그와트 레거시는 해리 포터 세계관에서 진행되는 오픈월드 액션 RPG입니다. 마법 동물을 발견하고, 자신의 캐릭터를 꾸미고, 마법약을 조제하고, 주문 시전을 통달하고, 특성을 업그레이드하고, 익숙한 장소들과 새로운 장소들을 넘나드는 모험을 즐기며, 꿈에 그리던 마법사가 되어보세요.',
9,
to_date('2023/2/11'),
'Avalanche Software',
'Warner Bros. Games',
68800,
0,
null,
null,
'Windows 10',
'Intel Core i7-8700 (3.2Ghz) or AMD Ryzen 5 3600 (3.6 Ghz)',
'16 GB RAM',
'NVIDIA GeForce 1080 Ti or AMD Radeon RX 5700 XT or INTEL Arc A770',
'85 GB',
'Windows 10',
'Intel Core i5-6600 (3.3Ghz) or AMD Ryzen 5 1400 (3.2Ghz)',
'16 GB RAM',
'NVIDIA GeForce GTX 960 4GB or AMD Radeon RX 470 4GB',
'85 GB',
4885,
2);

--13
insert into game
(g_no, g_name, g_short_desc, g_long_desc, g_grade, g_release_date, g_developer, g_distributor, g_price, g_discount_rate, g_discount_start, g_discount_end,
g_os, g_prosessor, g_memory, g_graphic, g_disk_space, g_min_os, g_min_prosessor, g_min_memory, g_min_graphic, g_min_disk_space, g_sell_count, ct_no)
values
(GAME_G_NO_SEQ.nextval,
'소울워커',
'어둠이 드리운 세상으로 소울워커와 함께 모험 가득한 여행을 떠나자! 강력한 감정의 에너지를 바탕으로 어둠의 세력으로부터 세상을 구해낼 소울워커 참담한 절망만이 가득한 세계 - 당신은 세상을 구원할 유일한 소울워커입니다.',
'고대 운명의 신- 로스카로부터 선택받은 소울워커들은 구원자로써 세상에 강림한다.
복수, 광기, 슬픔 그리고 열정과 같은 강렬한 감정을 바탕으로 세상을 구하려는 사람들, 소울워커.

지금 바로 “소울워커”가 되어 세상을 구하라!

게임 소개
영혼을 뒤흔드는 감성 액션의 '새로운' 시작!
어느날 갑자기 나타난 세상의 모든 것을 집어삼키는 정체불명의 블랙홀, 공백. 공백으로부터 세상을 지키기 위한 9명의 소울워커가 되어 직접 세상을 구원으로 이끌어주세요.',
9,
to_date('2023/3/17'),
'Lion Games Co., Ltd.',
'Lion Games Co., Ltd.',
0,
0,
null,
null,
'Windows 10',
'Intel I5 760 or above',
'8 GB RAM',
'Geforce GTX 660 / Radeon HD 7870',
'20 GB',
'Windows 7',
'Intel Core2 duo E8300 or above',
'4 GB RAM',
'Geforce GTX 460 / Radeon HD 5850',
'20 GB',
7614,
2);

--14
insert into game
(g_no, g_name, g_short_desc, g_long_desc, g_grade, g_release_date, g_developer, g_distributor, g_price, g_discount_rate, g_discount_start, g_discount_end,
g_os, g_prosessor, g_memory, g_graphic, g_disk_space, g_min_os, g_min_prosessor, g_min_memory, g_min_graphic, g_min_disk_space, g_sell_count, ct_no)
values
(GAME_G_NO_SEQ.nextval,
'옥토패스 트래블러 II',
'2018년 발매 후, 전 세계 출하 및 다운로드 300만 장을 돌파한 「옥토패스 트래블러」의 시리즈 완전 신작 RPG. 도트 그래픽과 3D CG를 융합한 「HD-2D」 그래픽이 한층 더 진화한 모습을 선보인다.',
'이야기의 무대는 땅을 가르는 큰 바다를 사이에 두고
동쪽과 서쪽에 대륙이 위치한 “솔리스티아”라고 불리는 지역.

항로가 개척되어 커다란 배가 바다를 오가고
증기를 사용한 신기술 발명에 꿈이 부푼 시대.

번영한 산업과 문화에 가슴 설레는 이도
전쟁, 역병, 가난으로 눈물 흘리는 이도 존재하는 세계.

그 세계에서 당신은
태어난 곳도 여행하는 목적도
그리고 특기도 각기 다른 8명의 여행자 중 한 명이 되어
자유롭게 여행할 수 있다.

여행을 떠나자. 당신만의 이야기로……',
9,
to_date('2023/2/25'),
'Square Enix',
'Square Enix',
69800,
0,
null,
null,
'Windows 11',
'AMD Ryzen™ 3 1200 / Intel® Core™ i3-6100',
'8 GB RAM',
'AMD Radeon™ RX 460 / NVIDIA® GeForce® GTX 750',
'10 GB',
'Windows 11',
'AMD Ryzen™ 3 1200 / Intel® Core™ i3-6100',
'8 GB RAM',
'AMD Radeon™ RX 460 / NVIDIA® GeForce® GTX 750',
'10 GB',
3356,
2);

--15
insert into game
(g_no, g_name, g_short_desc, g_long_desc, g_grade, g_release_date, g_developer, g_distributor, g_price, g_discount_rate, g_discount_start, g_discount_end,
g_os, g_prosessor, g_memory, g_graphic, g_disk_space, g_min_os, g_min_prosessor, g_min_memory, g_min_graphic, g_min_disk_space, g_sell_count, ct_no)
values
(GAME_G_NO_SEQ.nextval,
'마력 척결관: 리그 오브 레전드 이야기™',
'문라이터 개발사 Digital Sun에서 제작한 마력 척결관은 리그 오브 레전드 세계관을 배경으로 펼쳐지는 액션 RPG 게임입니다. 수년간의 감금 생활을 견딘 끝에 자유를 쟁취한 마법사, 사일러스가 되어 보세요. 구속의 상징이었던 사슬로 마력 척결단의 폭정 아래 신음하는 데마시아를 해방하세요.',
'문라이터 개발사 Digital Sun에서 제작한 마력 척결관: 리그 오브 레전드 이야기™는 리그 오브 레전드 세계관을 배경으로 펼쳐지는 액션 RPG 게임입니다. 데마시아 왕국의 마력 척결단은 공공질서라는 명목 아래 마법을 사용할 줄 아는 시민을 탄압하고 있습니다. 강제로 마력 척결단에 입단시킨 뒤 세뇌하고, 감옥에 감금하고, 음지로 내쫓는 등 횡포를 부리고 있죠.

마력 척결단에 의해 부당한 감옥살이를 했던 사일러스가 되어보세요. 마법을 훔치는 마법사의 힘을 마음껏 발휘할 기회입니다. 한때는 구속의 상징이었던 사슬. 이젠 이 사슬로 고향을 마력 척결단의 손아귀에서 조금씩 해방해야 합니다.

마법을 해방할 순간이 왔습니다.

마법의 지배자
마법은 어디에나 있습니다. 전장이라고 예외는 아니죠. 이글거리는 불꽃부터 치명적인 얼음까지, 다양한 주문을 습득해 나가며 나만의 방식으로 플레이할 수 있습니다. 사슬을 휘두르고, 적의 마법을 역이용하세요. 주먹으로 정면 승부를 펼쳐도 좋습니다. 선택은 여러분의 몫입니다.

혁명의 시작
데마시아에 혁명의 전운이 감돌고 있습니다. 혁명의 선봉에서 시련을 마주할 각오가 되셨습니까? 왕국 전역에서 마법사를 찾아 아군으로 포섭하세요. 성장하는 반군의 힘을 바탕으로 기본 능력을 업그레이드하고, 독특한 능력을 해제하세요.

직접 써 내려가는 전설
마력 척결단이 범죄자 집단처럼 보일지도 모릅니다. 물론 그렇다 해서 마력 척결단 모두 진실을 마주할 준비가 되어 있는 것은 아닙니다. 강대한 적에게 맞서고 잊지 못할 동료와 힘을 합치세요. 새로운 인연과 오랜 인연을 모두 만나볼 수 있습니다. 오직 여러분만이 데마시아의 과거에 얽힌 비밀을 밝혀내고, 미래의 향방을 바꿀 수 있습니다.',
9,
to_date('2023/4/19'),
'Digital Sun',
'Riot Forge',
32000,
0,
null,
null,
'Windows 10',
'Intel Core2 Quad Q6600 / AMD Phenom II X4 965',
'8 GB RAM',
'GeForce GTX 550 Ti 1 GB / Intel Iris Plus / AMD HD 6770',
'4 GB',
'Windows 10',
'Intel Core2 Quad Q6600 / AMD Phenom II X4 965',
'8 GB RAM',
'GeForce GTX 550 Ti 1 GB / Intel Iris Plus / AMD HD 6770',
'4 GB',
2448,
2);

--16
insert into game
(g_no, g_name, g_short_desc, g_long_desc, g_grade, g_release_date, g_developer, g_distributor, g_price, g_discount_rate, g_discount_start, g_discount_end,
g_os, g_prosessor, g_memory, g_graphic, g_disk_space, g_min_os, g_min_prosessor, g_min_memory, g_min_graphic, g_min_disk_space, g_sell_count, ct_no)
values
(GAME_G_NO_SEQ.nextval,
'ELDEN RING',
'본 게임은 본격적인 다크 판타지 세계를 무대로 한 액션 RPG입니다. 드넓은 필드와 던전 탐험을 통해 미지의 것들을 발견해 보세요. 앞길을 막아서는 난관과 그것을 극복했을 때의 달성감, 그리고 등장인물들의 의도가 교착하는 군상극도 즐기실 수 있습니다.',
'자극으로 가득한 드넓은 세계
다채로운 시추에이션을 지닌 탁 트인 필드와 복잡하면서 입체적으로 짜인 거대한 던전이 경계선 없이 이어지는 드넓은 세계. 탐색 끝에는 미지의 것들을 발견했다는 기쁨과 높은 성취감으로 이어지는 압도적인 위협이 플레이어를 기다립니다.

나만의 캐릭터
플레이어 캐릭터는 겉모습의 커스터마이즈뿐만 아니라 지니는 무기와 방어구, 마법을 자유롭게 조합할 수 있습니다. 근력을 높여 강인한 전사가 되거나 마술의 극치에 다다르는 등, 각자의 플레이 스타일에 맞춰 캐릭터를 성장시킬 수 있습니다.

신화에서 태어나는 군상극
단편적으로 이야기되는 중층적인 구조의 이야기. 「틈새의 땅」을 무대로 등장인물들의 다양한 의도가 교착하는 군상극이 전개됩니다.

다른 플레이어와 느슨하게 연결되는 독자적인 온라인 플레이
다른 플레이어와 직접적으로 연결되어 함께 여행하는 멀티플레이에 더해, 다른 플레이어의 존재를 느낄 수 있는 독자적인 비동기 온라인 요소도 지원합니다.',
9,
to_date('2022/2/25'),
'FromSoftware Inc.',
'FromSoftware Inc.',
64800,
0,
null,
null,
'Windows 10',
'INTEL CORE I5-8400 or AMD RYZEN 3 3300X',
'12 GB RAM',
'NVIDIA GEFORCE GTX 1060 3 GB or AMD RADEON RX 580 4 GB',
'60 GB',
'Windows 10',
'INTEL CORE I5-8400 or AMD RYZEN 3 3300X',
'12 GB RAM',
'NVIDIA GEFORCE GTX 1060 3 GB or AMD RADEON RX 580 4 GB',
'60 GB',
9833,
2);

--17
insert into game
(g_no, g_name, g_short_desc, g_long_desc, g_grade, g_release_date, g_developer, g_distributor, g_price, g_discount_rate, g_discount_start, g_discount_end,
g_os, g_prosessor, g_memory, g_graphic, g_disk_space, g_min_os, g_min_prosessor, g_min_memory, g_min_graphic, g_min_disk_space, g_sell_count, ct_no)
values
(GAME_G_NO_SEQ.nextval,
'알비온 온라인',
'알비온 온라인은 높은 자유도를 가진 판타지 MMORPG 게임으로, 플레이어가 직접 경제, 직업, 전투방식을 만들어가고 스릴 넘치는 PvP 전투를 경험할 수 있습니다. 위험과 기회가 가득한 방대한 세계를 탐험해 보세요. 부를 쌓고, 연합군을 결성하며 알비온 세계에 당신의 역사를 기록해 보세요.',
'알비온 온라인은 중세 판타지 세계를 배경으로 하는 높은 플레이 자유도를 가진 MMORPG입니다. 알비온 온라인은 거의 모든 아이템을 플레이어가 직접 제작하며 경제 시장을 플레이어들이 직접 구축해나가는 특이한 세계로, 플레이어가 직접 캐릭터를 위한 방어구와 무기의 조각을 모아 고유의 플레이스타일을 만들 수 있으며, “자신이 입고 있는 장비”가 바로 자신의 직업이 됩니다. 세계를 탐험하고, 다른 여행자들과 스릴 넘치는 전투를 벌이고, 땅을 정복하고, 당신의 집을 건설해보세요.',
9,
to_date('2017/7/17'),
'Sandbox Interactive GmbH',
'Sandbox Interactive GmbH',
0,
0,
null,
null,
'Windows 10',
'SSE2 명령어를 지원하는 인텔/AMD CPU',
'4 GB RAM',
'DirectX10 혹은 그 이상을 지원하는 그래픽카드',
'2 GB',
'Windows 10',
'SSE2 명령어를 지원하는 인텔/AMD CPU',
'4 GB RAM',
'DirectX10 혹은 그 이상을 지원하는 그래픽카드',
'2 GB',
1123,
2);

--18
insert into game
(g_no, g_name, g_short_desc, g_long_desc, g_grade, g_release_date, g_developer, g_distributor, g_price, g_discount_rate, g_discount_start, g_discount_end,
g_os, g_prosessor, g_memory, g_graphic, g_disk_space, g_min_os, g_min_prosessor, g_min_memory, g_min_graphic, g_min_disk_space, g_sell_count, ct_no)
values
(GAME_G_NO_SEQ.nextval,
'Stardew Valley',
'Youve inherited your grandfathers old farm plot in Stardew Valley. Armed with hand-me-down tools and a few coins, you set out to begin your new life. Can you learn to live off the land and turn these overgrown fields into a thriving home?',
'Youve inherited your grandfathers old farm plot in Stardew Valley. Armed with hand-me-down tools and a few coins, you set out to begin your new life. Can you learn to live off the land and turn these overgrown fields into a thriving home? It wont be easy. Ever since Joja Corporation came to town, the old ways of life have all but disappeared. The community center, once the towns most vibrant hub of activity, now lies in shambles. But the valley seems full of opportunity. With a little dedication, you might just be the one to restore Stardew Valley to greatness!',
9,
to_date('2016/2/27'),
'ConcernedApe',
'ConcernedApe',
16000,
0,
null,
null,
'Windows Vistar',
'2 Ghz',
'2 GB RAM',
'256 mb video memory, shader model 3.0+',
'0.5 GB',
'Windows Vistar',
'2 Ghz',
'2 GB RAM',
'256 mb video memory, shader model 3.0+',
'0.5 GB',
3688,
2);

--19
insert into game
(g_no, g_name, g_short_desc, g_long_desc, g_grade, g_release_date, g_developer, g_distributor, g_price, g_discount_rate, g_discount_start, g_discount_end,
g_os, g_prosessor, g_memory, g_graphic, g_disk_space, g_min_os, g_min_prosessor, g_min_memory, g_min_graphic, g_min_disk_space, g_sell_count, ct_no)
values
(GAME_G_NO_SEQ.nextval,
'Assassins Creed Valhalla',
'전설적인 바이킹 습격자로 명성을 위해 싸우십시오. 적들을 습격하고, 정착지를 개척하고, 정치적인 역량을 키워나가야 합니다.',
'에이보르가 되어, 전설적인 바이킹 습격자로 영광을 위해 나아가십시오.

- 색슨족 부대와 요새들을 습격하여 바이킹의 힘을 보여주십시오.
- 강력한 쌍수 무기를 휘두르며 바이킹의 원초적인 전투 스타일을 체험해보십시오.
- 어쌔신 크리드 사상 가장 다양한 적들을 상대하십시오.
- 선택에 따라 다양한 방식으로 캐릭터와 클랜의 정착지를 성장시키십시오.
- 노르웨이의 거친 해안부터 잉글랜드의 아름다운 왕국들까지, 암흑시대의 오픈 월드를 탐험하십시오.

어쌔신 크리드 발할라 플레이어에게 무료로 제공되는 로그라이트 게임 모드, 잊힌 전설도 포함됩니다.',
9,
to_date('2022/12/7'),
'Ubisoft Montreal',
'Ubisoft Montreal',
65000,
67,
to_date('2023/4/17'),
to_date('2023/5/17'),
'Windows 10',
'AMD Ryzen 3 1200 3.1 GHz / Intel Core i5-4460 3.2 GHz',
'8 GB RAM',
'AMD R9 380 /NVIDIA GeForce GTX 960',
'160 GB',
'Windows 10',
'AMD Ryzen 3 1200 3.1 GHz / Intel Core i5-4460 3.2 GHz',
'8 GB RAM',
'AMD R9 380 /NVIDIA GeForce GTX 960',
'160 GB',
6477,
2);

--20
insert into game
(g_no, g_name, g_short_desc, g_long_desc, g_grade, g_release_date, g_developer, g_distributor, g_price, g_discount_rate, g_discount_start, g_discount_end,
g_os, g_prosessor, g_memory, g_graphic, g_disk_space, g_min_os, g_min_prosessor, g_min_memory, g_min_graphic, g_min_disk_space, g_sell_count, ct_no)
values
(GAME_G_NO_SEQ.nextval,
'Project Zomboid',
'Project Zomboid is the ultimate in zombie survival. Alone or in MP: you loot, build, craft, fight, farm and fish in a struggle to survive. A hardcore RPG skillset, a vast map, massively customisable sandbox and a cute tutorial raccoon await the unwary. So how will you die? All it takes is a bite..',
'Project Zomboid is an open-ended zombie-infested sandbox. It asks one simple question – how will you die? 

In the towns of Muldraugh and West Point, survivors must loot houses, build defences and do their utmost to delay their inevitable death day by day. No help is coming – their continued survival relies on their own cunning, luck and ability to evade a relentless horde.',
9,
to_date('2013/11/8'),
'The Indie Stone',
'The Indie Stone',
21500,
0,
null,
null,
'Windows 10',
'Intel 2.77GHz Quad-core',
'8 GB RAM',
'Dedicated graphics card with 2 GB of RAM minimum, OpenGL 2.1 and GLSL 1.2 support (generally 2012 or newer)',
'15 GB',
'Windows 10',
'Intel 2.77GHz Quad-core',
'8 GB RAM',
'Dedicated graphics card with 2 GB of RAM minimum, OpenGL 2.1 and GLSL 1.2 support (generally 2012 or newer)',
'15 GB',
3781,
2);

--전략 : 3
--21
insert into game
(g_no, g_name, g_short_desc, g_long_desc, g_grade, g_release_date, g_developer, g_distributor, g_price, g_discount_rate, g_discount_start, g_discount_end,
g_os, g_prosessor, g_memory, g_graphic, g_disk_space, g_min_os, g_min_prosessor, g_min_memory, g_min_graphic, g_min_disk_space, g_sell_count, ct_no)
values
(GAME_G_NO_SEQ.nextval,
'PUBG: BATTLEGROUNDS',
'PUBG: BATTLEGROUNDS를 무료로 플레이 하세요. 다양한 전장에서 전략적 위치를 선점하고 무기와 장비를 확보해 최후의 1인이 되기 위한 생존의 사투를 펼칩니다.',
'PUBG: BATTLEGROUNDS를 무료로 플레이 하세요. 다양한 전장에서 전략적 위치를 선점하고 무기와 장비를 확보해 최후의 1인이 되기 위한 생존의 사투를 펼칩니다. 친구들과 함께 팀을 만들어 배틀로얄 건플레이 장르의 선구자인 PUBG: BATTLEGROUNDS만이 선사하는 긴장감 넘치는 경험을 위해 도전하세요.',
9,
to_date('2017/12/21'),
'KRAFTON, Inc',
'KRAFTON, Inc',
0,
0,
null,
null,
'Windows 10',
'Intel Core i5-6600K / AMD Ryzen 5 1600',
'16 GB RAM',
'NVIDIA GeForce GTX 1060 3GB / AMD Radeon RX 580 4GB',
'50 GB',
'Windows 10',
' Intel Core i5-4430 / AMD FX-6300',
'8 GB RAM',
'NVIDIA GeForce GTX 960 2GB / AMD Radeon R7 370 2GB',
'40 GB',
18653,
2);





















--language
insert into language(lang_no, lang_name) values(LANGUAGE_LANG_NO_SEQ.nextval, '한국어');
insert into language(lang_no, lang_name) values(LANGUAGE_LANG_NO_SEQ.nextval, '영어');
insert into language(lang_no, lang_name) values(LANGUAGE_LANG_NO_SEQ.nextval, '스페인어');
insert into language(lang_no, lang_name) values(LANGUAGE_LANG_NO_SEQ.nextval, '일본어');
insert into language(lang_no, lang_name) values(LANGUAGE_LANG_NO_SEQ.nextval, '프랑스어');--5
insert into language(lang_no, lang_name) values(LANGUAGE_LANG_NO_SEQ.nextval, '이탈리아어');
insert into language(lang_no, lang_name) values(LANGUAGE_LANG_NO_SEQ.nextval, '독일어');



--game_language
insert into game_language(gl_no, g_no, lang_no) values(GAME_LANGUAGE_GL_NO_SEQ.nextval, 1, 1);
insert into game_language(gl_no, g_no, lang_no) values(GAME_LANGUAGE_GL_NO_SEQ.nextval, 1, 2);
insert into game_language(gl_no, g_no, lang_no) values(GAME_LANGUAGE_GL_NO_SEQ.nextval, 2, 2);
insert into game_language(gl_no, g_no, lang_no) values(GAME_LANGUAGE_GL_NO_SEQ.nextval, 2, 3);
insert into game_language(gl_no, g_no, lang_no) values(GAME_LANGUAGE_GL_NO_SEQ.nextval, 3, 1);
insert into game_language(gl_no, g_no, lang_no) values(GAME_LANGUAGE_GL_NO_SEQ.nextval, 3, 2);
insert into game_language(gl_no, g_no, lang_no) values(GAME_LANGUAGE_GL_NO_SEQ.nextval, 4, 1);
insert into game_language(gl_no, g_no, lang_no) values(GAME_LANGUAGE_GL_NO_SEQ.nextval, 4, 2);
insert into game_language(gl_no, g_no, lang_no) values(GAME_LANGUAGE_GL_NO_SEQ.nextval, 5, 1);
insert into game_language(gl_no, g_no, lang_no) values(GAME_LANGUAGE_GL_NO_SEQ.nextval, 6, 1);
insert into game_language(gl_no, g_no, lang_no) values(GAME_LANGUAGE_GL_NO_SEQ.nextval, 6, 4);
insert into game_language(gl_no, g_no, lang_no) values(GAME_LANGUAGE_GL_NO_SEQ.nextval, 7, 1);
insert into game_language(gl_no, g_no, lang_no) values(GAME_LANGUAGE_GL_NO_SEQ.nextval, 7, 2);
insert into game_language(gl_no, g_no, lang_no) values(GAME_LANGUAGE_GL_NO_SEQ.nextval, 8, 1);
insert into game_language(gl_no, g_no, lang_no) values(GAME_LANGUAGE_GL_NO_SEQ.nextval, 8, 2);
insert into game_language(gl_no, g_no, lang_no) values(GAME_LANGUAGE_GL_NO_SEQ.nextval, 9, 1);
insert into game_language(gl_no, g_no, lang_no) values(GAME_LANGUAGE_GL_NO_SEQ.nextval, 9, 2);
insert into game_language(gl_no, g_no, lang_no) values(GAME_LANGUAGE_GL_NO_SEQ.nextval, 10, 1);
insert into game_language(gl_no, g_no, lang_no) values(GAME_LANGUAGE_GL_NO_SEQ.nextval, 10, 2);
insert into game_language(gl_no, g_no, lang_no) values(GAME_LANGUAGE_GL_NO_SEQ.nextval, 11, 1);
insert into game_language(gl_no, g_no, lang_no) values(GAME_LANGUAGE_GL_NO_SEQ.nextval, 11, 2);
insert into game_language(gl_no, g_no, lang_no) values(GAME_LANGUAGE_GL_NO_SEQ.nextval, 11, 5);
insert into game_language(gl_no, g_no, lang_no) values(GAME_LANGUAGE_GL_NO_SEQ.nextval, 11, 6);
insert into game_language(gl_no, g_no, lang_no) values(GAME_LANGUAGE_GL_NO_SEQ.nextval, 11, 7);
insert into game_language(gl_no, g_no, lang_no) values(GAME_LANGUAGE_GL_NO_SEQ.nextval, 12, 1);
insert into game_language(gl_no, g_no, lang_no) values(GAME_LANGUAGE_GL_NO_SEQ.nextval, 12, 2);
insert into game_language(gl_no, g_no, lang_no) values(GAME_LANGUAGE_GL_NO_SEQ.nextval, 12, 5);
insert into game_language(gl_no, g_no, lang_no) values(GAME_LANGUAGE_GL_NO_SEQ.nextval, 12, 6);
insert into game_language(gl_no, g_no, lang_no) values(GAME_LANGUAGE_GL_NO_SEQ.nextval, 12, 7);
insert into game_language(gl_no, g_no, lang_no) values(GAME_LANGUAGE_GL_NO_SEQ.nextval, 13, 1);
insert into game_language(gl_no, g_no, lang_no) values(GAME_LANGUAGE_GL_NO_SEQ.nextval, 13, 2);
insert into game_language(gl_no, g_no, lang_no) values(GAME_LANGUAGE_GL_NO_SEQ.nextval, 13, 5);
insert into game_language(gl_no, g_no, lang_no) values(GAME_LANGUAGE_GL_NO_SEQ.nextval, 13, 6);
insert into game_language(gl_no, g_no, lang_no) values(GAME_LANGUAGE_GL_NO_SEQ.nextval, 13, 7);
insert into game_language(gl_no, g_no, lang_no) values(GAME_LANGUAGE_GL_NO_SEQ.nextval, 14, 1);
insert into game_language(gl_no, g_no, lang_no) values(GAME_LANGUAGE_GL_NO_SEQ.nextval, 14, 2);
insert into game_language(gl_no, g_no, lang_no) values(GAME_LANGUAGE_GL_NO_SEQ.nextval, 14, 5);
insert into game_language(gl_no, g_no, lang_no) values(GAME_LANGUAGE_GL_NO_SEQ.nextval, 14, 6);
insert into game_language(gl_no, g_no, lang_no) values(GAME_LANGUAGE_GL_NO_SEQ.nextval, 14, 7);
insert into game_language(gl_no, g_no, lang_no) values(GAME_LANGUAGE_GL_NO_SEQ.nextval, 15, 1);
insert into game_language(gl_no, g_no, lang_no) values(GAME_LANGUAGE_GL_NO_SEQ.nextval, 15, 2);
insert into game_language(gl_no, g_no, lang_no) values(GAME_LANGUAGE_GL_NO_SEQ.nextval, 15, 5);
insert into game_language(gl_no, g_no, lang_no) values(GAME_LANGUAGE_GL_NO_SEQ.nextval, 15, 6);
insert into game_language(gl_no, g_no, lang_no) values(GAME_LANGUAGE_GL_NO_SEQ.nextval, 15, 7);
insert into game_language(gl_no, g_no, lang_no) values(GAME_LANGUAGE_GL_NO_SEQ.nextval, 16, 1);
insert into game_language(gl_no, g_no, lang_no) values(GAME_LANGUAGE_GL_NO_SEQ.nextval, 16, 2);
insert into game_language(gl_no, g_no, lang_no) values(GAME_LANGUAGE_GL_NO_SEQ.nextval, 16, 5);
insert into game_language(gl_no, g_no, lang_no) values(GAME_LANGUAGE_GL_NO_SEQ.nextval, 16, 6);
insert into game_language(gl_no, g_no, lang_no) values(GAME_LANGUAGE_GL_NO_SEQ.nextval, 16, 7);
insert into game_language(gl_no, g_no, lang_no) values(GAME_LANGUAGE_GL_NO_SEQ.nextval, 17, 1);
insert into game_language(gl_no, g_no, lang_no) values(GAME_LANGUAGE_GL_NO_SEQ.nextval, 17, 2);
insert into game_language(gl_no, g_no, lang_no) values(GAME_LANGUAGE_GL_NO_SEQ.nextval, 17, 5);
insert into game_language(gl_no, g_no, lang_no) values(GAME_LANGUAGE_GL_NO_SEQ.nextval, 17, 6);
insert into game_language(gl_no, g_no, lang_no) values(GAME_LANGUAGE_GL_NO_SEQ.nextval, 17, 7);
insert into game_language(gl_no, g_no, lang_no) values(GAME_LANGUAGE_GL_NO_SEQ.nextval, 18, 1);
insert into game_language(gl_no, g_no, lang_no) values(GAME_LANGUAGE_GL_NO_SEQ.nextval, 18, 2);
insert into game_language(gl_no, g_no, lang_no) values(GAME_LANGUAGE_GL_NO_SEQ.nextval, 18, 5);
insert into game_language(gl_no, g_no, lang_no) values(GAME_LANGUAGE_GL_NO_SEQ.nextval, 18, 6);
insert into game_language(gl_no, g_no, lang_no) values(GAME_LANGUAGE_GL_NO_SEQ.nextval, 18, 7);
insert into game_language(gl_no, g_no, lang_no) values(GAME_LANGUAGE_GL_NO_SEQ.nextval, 19, 1);
insert into game_language(gl_no, g_no, lang_no) values(GAME_LANGUAGE_GL_NO_SEQ.nextval, 19, 2);
insert into game_language(gl_no, g_no, lang_no) values(GAME_LANGUAGE_GL_NO_SEQ.nextval, 19, 5);
insert into game_language(gl_no, g_no, lang_no) values(GAME_LANGUAGE_GL_NO_SEQ.nextval, 19, 6);
insert into game_language(gl_no, g_no, lang_no) values(GAME_LANGUAGE_GL_NO_SEQ.nextval, 19, 7);
insert into game_language(gl_no, g_no, lang_no) values(GAME_LANGUAGE_GL_NO_SEQ.nextval, 20, 1);
insert into game_language(gl_no, g_no, lang_no) values(GAME_LANGUAGE_GL_NO_SEQ.nextval, 20, 2);
insert into game_language(gl_no, g_no, lang_no) values(GAME_LANGUAGE_GL_NO_SEQ.nextval, 20, 5);
insert into game_language(gl_no, g_no, lang_no) values(GAME_LANGUAGE_GL_NO_SEQ.nextval, 20, 6);
insert into game_language(gl_no, g_no, lang_no) values(GAME_LANGUAGE_GL_NO_SEQ.nextval, 20, 7);




--tag
insert into tag(tag_no, tag_name) values(TAG_TAG_NO_SEQ.nextval, '오픈월드');
insert into tag(tag_no, tag_name) values(TAG_TAG_NO_SEQ.nextval, '풍부한스토리');
insert into tag(tag_no, tag_name) values(TAG_TAG_NO_SEQ.nextval, '어드벤쳐');
insert into tag(tag_no, tag_name) values(TAG_TAG_NO_SEQ.nextval, '웨스턴');
insert into tag(tag_no, tag_name) values(TAG_TAG_NO_SEQ.nextval, '말');--5
insert into tag(tag_no, tag_name) values(TAG_TAG_NO_SEQ.nextval, '액션');
insert into tag(tag_no, tag_name) values(TAG_TAG_NO_SEQ.nextval, '공상과학');
insert into tag(tag_no, tag_name) values(TAG_TAG_NO_SEQ.nextval, '소울라이크');
insert into tag(tag_no, tag_name) values(TAG_TAG_NO_SEQ.nextval, '3인칭');
insert into tag(tag_no, tag_name) values(TAG_TAG_NO_SEQ.nextval, '사이버펑크');--10
insert into tag(tag_no, tag_name) values(TAG_TAG_NO_SEQ.nextval, 'RPG');
insert into tag(tag_no, tag_name) values(TAG_TAG_NO_SEQ.nextval, '1인칭슈팅');
insert into tag(tag_no, tag_name) values(TAG_TAG_NO_SEQ.nextval, '멀티플레이어');
insert into tag(tag_no, tag_name) values(TAG_TAG_NO_SEQ.nextval, '슈팅');
insert into tag(tag_no, tag_name) values(TAG_TAG_NO_SEQ.nextval, '군사');--15
insert into tag(tag_no, tag_name) values(TAG_TAG_NO_SEQ.nextval, '온라인 협동');
insert into tag(tag_no, tag_name) values(TAG_TAG_NO_SEQ.nextval, '사냥');
insert into tag(tag_no, tag_name) values(TAG_TAG_NO_SEQ.nextval, '깊은세계관');
insert into tag(tag_no, tag_name) values(TAG_TAG_NO_SEQ.nextval, '턴제전술');
insert into tag(tag_no, tag_name) values(TAG_TAG_NO_SEQ.nextval, '범죄');--20
insert into tag(tag_no, tag_name) values(TAG_TAG_NO_SEQ.nextval, '무료플레이');
insert into tag(tag_no, tag_name) values(TAG_TAG_NO_SEQ.nextval, '배틀로얄');
insert into tag(tag_no, tag_name) values(TAG_TAG_NO_SEQ.nextval, '로그라이크');
insert into tag(tag_no, tag_name) values(TAG_TAG_NO_SEQ.nextval, '핵앤슬래시');
insert into tag(tag_no, tag_name) values(TAG_TAG_NO_SEQ.nextval, '인디');--25
insert into tag(tag_no, tag_name) values(TAG_TAG_NO_SEQ.nextval, '싱글플레이어');
insert into tag(tag_no, tag_name) values(TAG_TAG_NO_SEQ.nextval, '공포');
insert into tag(tag_no, tag_name) values(TAG_TAG_NO_SEQ.nextval, '생존');
insert into tag(tag_no, tag_name) values(TAG_TAG_NO_SEQ.nextval, '좀비');
insert into tag(tag_no, tag_name) values(TAG_TAG_NO_SEQ.nextval, '시뮬레이션');--30
insert into tag(tag_no, tag_name) values(TAG_TAG_NO_SEQ.nextval, '픽셀그래픽');
insert into tag(tag_no, tag_name) values(TAG_TAG_NO_SEQ.nextval, '마법');
insert into tag(tag_no, tag_name) values(TAG_TAG_NO_SEQ.nextval, '판타지');
insert into tag(tag_no, tag_name) values(TAG_TAG_NO_SEQ.nextval, 'MMORPG');
insert into tag(tag_no, tag_name) values(TAG_TAG_NO_SEQ.nextval, '턴제RPG');--35
insert into tag(tag_no, tag_name) values(TAG_TAG_NO_SEQ.nextval, 'GRPG');
insert into tag(tag_no, tag_name) values(TAG_TAG_NO_SEQ.nextval, '2.5D');
insert into tag(tag_no, tag_name) values(TAG_TAG_NO_SEQ.nextval, '파티기반RPG');
insert into tag(tag_no, tag_name) values(TAG_TAG_NO_SEQ.nextval, '2D');
insert into tag(tag_no, tag_name) values(TAG_TAG_NO_SEQ.nextval, '소울라이크');--40
insert into tag(tag_no, tag_name) values(TAG_TAG_NO_SEQ.nextval, '다크판타지');
insert into tag(tag_no, tag_name) values(TAG_TAG_NO_SEQ.nextval, 'MMO');
insert into tag(tag_no, tag_name) values(TAG_TAG_NO_SEQ.nextval, '농장시뮬레이션');
insert into tag(tag_no, tag_name) values(TAG_TAG_NO_SEQ.nextval, '생활시뮬레이션');
insert into tag(tag_no, tag_name) values(TAG_TAG_NO_SEQ.nextval, '');--45
insert into tag(tag_no, tag_name) values(TAG_TAG_NO_SEQ.nextval, '');
insert into tag(tag_no, tag_name) values(TAG_TAG_NO_SEQ.nextval, '');
insert into tag(tag_no, tag_name) values(TAG_TAG_NO_SEQ.nextval, '');
insert into tag(tag_no, tag_name) values(TAG_TAG_NO_SEQ.nextval, '');
insert into tag(tag_no, tag_name) values(TAG_TAG_NO_SEQ.nextval, '');--50
insert into tag(tag_no, tag_name) values(TAG_TAG_NO_SEQ.nextval, '');
insert into tag(tag_no, tag_name) values(TAG_TAG_NO_SEQ.nextval, '');
insert into tag(tag_no, tag_name) values(TAG_TAG_NO_SEQ.nextval, '');


--game_tag
insert into game_tag(gt_no, tag_no, g_no) values(GAME_TAG_GT_NO_SEQ.nextval, 1, 1);
insert into game_tag(gt_no, tag_no, g_no) values(GAME_TAG_GT_NO_SEQ.nextval, 2, 1);
insert into game_tag(gt_no, tag_no, g_no) values(GAME_TAG_GT_NO_SEQ.nextval, 3, 1);
insert into game_tag(gt_no, tag_no, g_no) values(GAME_TAG_GT_NO_SEQ.nextval, 4, 1);
insert into game_tag(gt_no, tag_no, g_no) values(GAME_TAG_GT_NO_SEQ.nextval, 5, 1);
insert into game_tag(gt_no, tag_no, g_no) values(GAME_TAG_GT_NO_SEQ.nextval, 6, 2);
insert into game_tag(gt_no, tag_no, g_no) values(GAME_TAG_GT_NO_SEQ.nextval, 3, 2);
insert into game_tag(gt_no, tag_no, g_no) values(GAME_TAG_GT_NO_SEQ.nextval, 7, 2);
insert into game_tag(gt_no, tag_no, g_no) values(GAME_TAG_GT_NO_SEQ.nextval, 8, 2);
insert into game_tag(gt_no, tag_no, g_no) values(GAME_TAG_GT_NO_SEQ.nextval, 9, 2);
insert into game_tag(gt_no, tag_no, g_no) values(GAME_TAG_GT_NO_SEQ.nextval, 10, 3);
insert into game_tag(gt_no, tag_no, g_no) values(GAME_TAG_GT_NO_SEQ.nextval, 1, 3);
insert into game_tag(gt_no, tag_no, g_no) values(GAME_TAG_GT_NO_SEQ.nextval, 11, 3);
insert into game_tag(gt_no, tag_no, g_no) values(GAME_TAG_GT_NO_SEQ.nextval, 7, 3);
insert into game_tag(gt_no, tag_no, g_no) values(GAME_TAG_GT_NO_SEQ.nextval, 6, 3);
insert into game_tag(gt_no, tag_no, g_no) values(GAME_TAG_GT_NO_SEQ.nextval, 6, 4);
insert into game_tag(gt_no, tag_no, g_no) values(GAME_TAG_GT_NO_SEQ.nextval, 12, 4);
insert into game_tag(gt_no, tag_no, g_no) values(GAME_TAG_GT_NO_SEQ.nextval, 13, 4);
insert into game_tag(gt_no, tag_no, g_no) values(GAME_TAG_GT_NO_SEQ.nextval, 14, 4);
insert into game_tag(gt_no, tag_no, g_no) values(GAME_TAG_GT_NO_SEQ.nextval, 15, 4);
insert into game_tag(gt_no, tag_no, g_no) values(GAME_TAG_GT_NO_SEQ.nextval, 6, 5);
insert into game_tag(gt_no, tag_no, g_no) values(GAME_TAG_GT_NO_SEQ.nextval, 11, 5);
insert into game_tag(gt_no, tag_no, g_no) values(GAME_TAG_GT_NO_SEQ.nextval, 13, 5);
insert into game_tag(gt_no, tag_no, g_no) values(GAME_TAG_GT_NO_SEQ.nextval, 16, 5);
insert into game_tag(gt_no, tag_no, g_no) values(GAME_TAG_GT_NO_SEQ.nextval, 17, 5);
insert into game_tag(gt_no, tag_no, g_no) values(GAME_TAG_GT_NO_SEQ.nextval, 11, 6);
insert into game_tag(gt_no, tag_no, g_no) values(GAME_TAG_GT_NO_SEQ.nextval, 18, 6);
insert into game_tag(gt_no, tag_no, g_no) values(GAME_TAG_GT_NO_SEQ.nextval, 2, 6);
insert into game_tag(gt_no, tag_no, g_no) values(GAME_TAG_GT_NO_SEQ.nextval, 19, 6);
insert into game_tag(gt_no, tag_no, g_no) values(GAME_TAG_GT_NO_SEQ.nextval, 3, 6);
insert into game_tag(gt_no, tag_no, g_no) values(GAME_TAG_GT_NO_SEQ.nextval, 1, 7);
insert into game_tag(gt_no, tag_no, g_no) values(GAME_TAG_GT_NO_SEQ.nextval, 6, 7);
insert into game_tag(gt_no, tag_no, g_no) values(GAME_TAG_GT_NO_SEQ.nextval, 13, 7);
insert into game_tag(gt_no, tag_no, g_no) values(GAME_TAG_GT_NO_SEQ.nextval, 20, 7);
insert into game_tag(gt_no, tag_no, g_no) values(GAME_TAG_GT_NO_SEQ.nextval, 9, 7);
insert into game_tag(gt_no, tag_no, g_no) values(GAME_TAG_GT_NO_SEQ.nextval, 21, 8);
insert into game_tag(gt_no, tag_no, g_no) values(GAME_TAG_GT_NO_SEQ.nextval, 22, 8);
insert into game_tag(gt_no, tag_no, g_no) values(GAME_TAG_GT_NO_SEQ.nextval, 12, 8);
insert into game_tag(gt_no, tag_no, g_no) values(GAME_TAG_GT_NO_SEQ.nextval, 13, 8);
insert into game_tag(gt_no, tag_no, g_no) values(GAME_TAG_GT_NO_SEQ.nextval, 14, 8);
insert into game_tag(gt_no, tag_no, g_no) values(GAME_TAG_GT_NO_SEQ.nextval, 6, 9);
insert into game_tag(gt_no, tag_no, g_no) values(GAME_TAG_GT_NO_SEQ.nextval, 23, 9);
insert into game_tag(gt_no, tag_no, g_no) values(GAME_TAG_GT_NO_SEQ.nextval, 24, 9);
insert into game_tag(gt_no, tag_no, g_no) values(GAME_TAG_GT_NO_SEQ.nextval, 25, 9);
insert into game_tag(gt_no, tag_no, g_no) values(GAME_TAG_GT_NO_SEQ.nextval, 26, 9);
insert into game_tag(gt_no, tag_no, g_no) values(GAME_TAG_GT_NO_SEQ.nextval, 6, 10);
insert into game_tag(gt_no, tag_no, g_no) values(GAME_TAG_GT_NO_SEQ.nextval, 9, 10);
insert into game_tag(gt_no, tag_no, g_no) values(GAME_TAG_GT_NO_SEQ.nextval, 27, 10);
insert into game_tag(gt_no, tag_no, g_no) values(GAME_TAG_GT_NO_SEQ.nextval, 28, 10);
insert into game_tag(gt_no, tag_no, g_no) values(GAME_TAG_GT_NO_SEQ.nextval, 29, 10);
insert into game_tag(gt_no, tag_no, g_no) values(GAME_TAG_GT_NO_SEQ.nextval, 30, 11);
insert into game_tag(gt_no, tag_no, g_no) values(GAME_TAG_GT_NO_SEQ.nextval, 31, 11);
insert into game_tag(gt_no, tag_no, g_no) values(GAME_TAG_GT_NO_SEQ.nextval, 11, 11);
insert into game_tag(gt_no, tag_no, g_no) values(GAME_TAG_GT_NO_SEQ.nextval, 13, 11);
insert into game_tag(gt_no, tag_no, g_no) values(GAME_TAG_GT_NO_SEQ.nextval, 25, 11);
insert into game_tag(gt_no, tag_no, g_no) values(GAME_TAG_GT_NO_SEQ.nextval, 32, 12);
insert into game_tag(gt_no, tag_no, g_no) values(GAME_TAG_GT_NO_SEQ.nextval, 33, 12);
insert into game_tag(gt_no, tag_no, g_no) values(GAME_TAG_GT_NO_SEQ.nextval, 1, 12);
insert into game_tag(gt_no, tag_no, g_no) values(GAME_TAG_GT_NO_SEQ.nextval, 11, 12);
insert into game_tag(gt_no, tag_no, g_no) values(GAME_TAG_GT_NO_SEQ.nextval, 26, 12);
insert into game_tag(gt_no, tag_no, g_no) values(GAME_TAG_GT_NO_SEQ.nextval, 6, 13);
insert into game_tag(gt_no, tag_no, g_no) values(GAME_TAG_GT_NO_SEQ.nextval, 11, 13);
insert into game_tag(gt_no, tag_no, g_no) values(GAME_TAG_GT_NO_SEQ.nextval, 34, 13);
insert into game_tag(gt_no, tag_no, g_no) values(GAME_TAG_GT_NO_SEQ.nextval, 13, 13);
insert into game_tag(gt_no, tag_no, g_no) values(GAME_TAG_GT_NO_SEQ.nextval, 24, 13);
insert into game_tag(gt_no, tag_no, g_no) values(GAME_TAG_GT_NO_SEQ.nextval, 11, 14);
insert into game_tag(gt_no, tag_no, g_no) values(GAME_TAG_GT_NO_SEQ.nextval, 35, 14);
insert into game_tag(gt_no, tag_no, g_no) values(GAME_TAG_GT_NO_SEQ.nextval, 36, 14);
insert into game_tag(gt_no, tag_no, g_no) values(GAME_TAG_GT_NO_SEQ.nextval, 37, 14);
insert into game_tag(gt_no, tag_no, g_no) values(GAME_TAG_GT_NO_SEQ.nextval, 38, 14);
insert into game_tag(gt_no, tag_no, g_no) values(GAME_TAG_GT_NO_SEQ.nextval, 11, 15);
insert into game_tag(gt_no, tag_no, g_no) values(GAME_TAG_GT_NO_SEQ.nextval, 31, 15);
insert into game_tag(gt_no, tag_no, g_no) values(GAME_TAG_GT_NO_SEQ.nextval, 39, 15);
insert into game_tag(gt_no, tag_no, g_no) values(GAME_TAG_GT_NO_SEQ.nextval, 24, 15);
insert into game_tag(gt_no, tag_no, g_no) values(GAME_TAG_GT_NO_SEQ.nextval, 33, 15);
insert into game_tag(gt_no, tag_no, g_no) values(GAME_TAG_GT_NO_SEQ.nextval, 40, 16);
insert into game_tag(gt_no, tag_no, g_no) values(GAME_TAG_GT_NO_SEQ.nextval, 41, 16);
insert into game_tag(gt_no, tag_no, g_no) values(GAME_TAG_GT_NO_SEQ.nextval, 11, 16);
insert into game_tag(gt_no, tag_no, g_no) values(GAME_TAG_GT_NO_SEQ.nextval, 1, 16);
insert into game_tag(gt_no, tag_no, g_no) values(GAME_TAG_GT_NO_SEQ.nextval, 6, 16);
insert into game_tag(gt_no, tag_no, g_no) values(GAME_TAG_GT_NO_SEQ.nextval, 42, 17);
insert into game_tag(gt_no, tag_no, g_no) values(GAME_TAG_GT_NO_SEQ.nextval, 21, 17);
insert into game_tag(gt_no, tag_no, g_no) values(GAME_TAG_GT_NO_SEQ.nextval, 34, 17);
insert into game_tag(gt_no, tag_no, g_no) values(GAME_TAG_GT_NO_SEQ.nextval, 1, 17);
insert into game_tag(gt_no, tag_no, g_no) values(GAME_TAG_GT_NO_SEQ.nextval, 11, 17);
insert into game_tag(gt_no, tag_no, g_no) values(GAME_TAG_GT_NO_SEQ.nextval, 43, 18);
insert into game_tag(gt_no, tag_no, g_no) values(GAME_TAG_GT_NO_SEQ.nextval, 44, 18);
insert into game_tag(gt_no, tag_no, g_no) values(GAME_TAG_GT_NO_SEQ.nextval, 30, 18);
insert into game_tag(gt_no, tag_no, g_no) values(GAME_TAG_GT_NO_SEQ.nextval, 31, 18);
insert into game_tag(gt_no, tag_no, g_no) values(GAME_TAG_GT_NO_SEQ.nextval, 25, 18);
insert into game_tag(gt_no, tag_no, g_no) values(GAME_TAG_GT_NO_SEQ.nextval, 6, 19);
insert into game_tag(gt_no, tag_no, g_no) values(GAME_TAG_GT_NO_SEQ.nextval, 1, 19);
insert into game_tag(gt_no, tag_no, g_no) values(GAME_TAG_GT_NO_SEQ.nextval, 11, 19);
insert into game_tag(gt_no, tag_no, g_no) values(GAME_TAG_GT_NO_SEQ.nextval, 3, 19);
insert into game_tag(gt_no, tag_no, g_no) values(GAME_TAG_GT_NO_SEQ.nextval, 26, 19);
insert into game_tag(gt_no, tag_no, g_no) values(GAME_TAG_GT_NO_SEQ.nextval, 28, 20);
insert into game_tag(gt_no, tag_no, g_no) values(GAME_TAG_GT_NO_SEQ.nextval, 29, 20);
insert into game_tag(gt_no, tag_no, g_no) values(GAME_TAG_GT_NO_SEQ.nextval, 1, 20);
insert into game_tag(gt_no, tag_no, g_no) values(GAME_TAG_GT_NO_SEQ.nextval, 39, 20);
insert into game_tag(gt_no, tag_no, g_no) values(GAME_TAG_GT_NO_SEQ.nextval, 25, 20);












--resources
--액션
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'action1-1.jpg', 1);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'action1-2.jpg', 1);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'action1-3.jpg', 1);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'action1-4.jpg', 1);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'action2-1.jpg', 2);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'action2-2.jpg', 2);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'action2-3.jpg', 2);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'action2-4.jpg', 2);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'action3-1.jpg', 3);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'action3-2.jpg', 3);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'action3-3.jpg', 3);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'action3-4.jpg', 3);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'action4-1.jpg', 4);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'action4-2.jpg', 4);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'action4-3.jpg', 4);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'action4-4.jpg', 4);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'action5-1.jpg', 5);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'action5-2.jpg', 5);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'action5-3.jpg', 5);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'action5-4.jpg', 5);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'action6-1.jpg', 6);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'action6-2.jpg', 6);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'action6-3.jpg', 6);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'action6-4.jpg', 6);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'action7-1.jpg', 7);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'action7-2.jpg', 7);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'action7-3.jpg', 7);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'action7-4.jpg', 7);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'action8-1.jpg', 8);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'action8-2.jpg', 8);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'action8-3.jpg', 8);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'action8-4.jpg', 8);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'action9-1.jpg', 9);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'action9-2.jpg', 9);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'action9-3.jpg', 9);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'action9-4.jpg', 9);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'action10-1.jpg', 10);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'action10-2.jpg', 10);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'action10-3.jpg', 10);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'action10-4.jpg', 10);
--RPG
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'RPG1-1.jpg', 11);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'RPG1-2.jpg', 11);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'RPG1-3.jpg', 11);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'RPG1-4.jpg', 11);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'RPG2-1.jpg', 12);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'RPG2-2.jpg', 12);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'RPG2-3.jpg', 12);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'RPG2-4.jpg', 12);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'RPG3-1.jpg', 13);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'RPG3-2.jpg', 13);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'RPG3-3.jpg', 13);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'RPG3-4.jpg', 13);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'RPG4-1.jpg', 14);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'RPG4-2.jpg', 14);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'RPG4-3.jpg', 14);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'RPG4-4.jpg', 14);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'RPG5-1.jpg', 15);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'RPG5-2.jpg', 15);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'RPG5-3.jpg', 15);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'RPG5-4.jpg', 15);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'RPG6-1.jpg', 16);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'RPG6-2.jpg', 16);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'RPG6-3.jpg', 16);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'RPG6-4.jpg', 16);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'RPG7-1.jpg', 17);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'RPG7-2.jpg', 17);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'RPG7-3.jpg', 17);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'RPG7-4.jpg', 17);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'RPG8-1.jpg', 18);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'RPG8-2.jpg', 18);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'RPG8-3.jpg', 18);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'RPG8-4.jpg', 18);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'RPG9-1.jpg', 19);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'RPG9-2.jpg', 19);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'RPG9-3.jpg', 19);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'RPG9-4.jpg', 19);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'RPG10-1.jpg', 20);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'RPG10-2.jpg', 20);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'RPG10-3.jpg', 20);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'RPG10-4.jpg', 20);
--전략
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'simul1-1.jpg', 21);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'simul1-2.jpg', 21);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'simul1-3.jpg', 21);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'simul1-4.jpg', 21);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'simul2-1.jpg', 22);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'simul2-2.jpg', 22);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'simul2-3.jpg', 22);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'simul2-4.jpg', 22);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'simul3-1.jpg', 23);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'simul3-2.jpg', 23);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'simul3-3.jpg', 23);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'simul3-4.jpg', 23);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'simul4-1.jpg', 24);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'simul4-2.jpg', 24);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'simul4-3.jpg', 24);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'simul4-4.jpg', 24);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'simul5-1.jpg', 25);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'simul5-2.jpg', 25);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'simul5-3.jpg', 25);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'simul5-4.jpg', 25);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'simul6-1.jpg', 26);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'simul6-2.jpg', 26);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'simul6-3.jpg', 26);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'simul6-4.jpg', 26);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'simul7-1.jpg', 27);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'simul7-2.jpg', 27);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'simul7-3.jpg', 27);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'simul7-4.jpg', 27);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'simul8-1.jpg', 28);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'simul8-2.jpg', 28);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'simul8-3.jpg', 28);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'simul8-4.jpg', 28);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'simul9-1.jpg', 29);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'simul9-2.jpg', 29);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'simul9-3.jpg', 29);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'simul9-4.jpg', 29);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'simul10-1.jpg', 30);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'simul10-2.jpg', 30);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'simul10-3.jpg', 30);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'simul10-4.jpg', 30);
--어드벤쳐
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'adv1-1.jpg', 31);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'adv1-2.jpg', 31);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'adv1-3.jpg', 31);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'adv1-4.jpg', 31);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'adv2-1.jpg', 32);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'adv2-2.jpg', 32);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'adv2-3.jpg', 32);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'adv2-4.jpg', 32);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'adv3-1.jpg', 33);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'adv3-2.jpg', 33);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'adv3-3.jpg', 33);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'adv3-4.jpg', 33);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'adv4-1.jpg', 34);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'adv4-2.jpg', 34);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'adv4-3.jpg', 34);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'adv4-4.jpg', 34);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'adv5-1.jpg', 35);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'adv5-2.jpg', 35);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'adv5-3.jpg', 35);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'adv5-4.jpg', 35);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'adv6-1.jpg', 36);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'adv6-2.jpg', 36);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'adv6-3.jpg', 36);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'adv6-4.jpg', 36);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'adv7-1.jpg', 37);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'adv7-2.jpg', 37);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'adv7-3.jpg', 37);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'adv7-4.jpg', 37);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'adv8-1.jpg', 38);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'adv8-2.jpg', 38);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'adv8-3.jpg', 38);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'adv8-4.jpg', 38);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'adv9-1.jpg', 39);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'adv9-2.jpg', 39);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'adv9-3.jpg', 39);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'adv9-4.jpg', 39);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'adv10-1.jpg', 40);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'adv10-2.jpg', 40);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'adv10-3.jpg', 40);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'adv10-4.jpg', 40);
--스포츠
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'sport1-1.jpg', 41);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'sport1-2.jpg', 41);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'sport1-3.jpg', 41);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'sport1-4.jpg', 41);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'sport2-1.jpg', 42);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'sport2-2.jpg', 42);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'sport2-3.jpg', 42);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'sport2-4.jpg', 42);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'sport3-1.jpg', 43);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'sport3-2.jpg', 43);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'sport3-3.jpg', 43);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'sport3-4.jpg', 43);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'sport4-1.jpg', 44);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'sport4-2.jpg', 44);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'sport4-3.jpg', 44);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'sport4-4.jpg', 44);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'sport5-1.jpg', 45);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'sport5-2.jpg', 45);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'sport5-3.jpg', 45);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'sport5-4.jpg', 45);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'sport6-1.jpg', 46);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'sport6-2.jpg', 46);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'sport6-3.jpg', 46);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'sport6-4.jpg', 46);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'sport7-1.jpg', 47);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'sport7-2.jpg', 47);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'sport7-3.jpg', 47);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'sport7-4.jpg', 47);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'sport8-1.jpg', 48);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'sport8-2.jpg', 48);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'sport8-3.jpg', 48);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'sport8-4.jpg', 48);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'sport9-1.jpg', 49);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'sport9-2.jpg', 49);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'sport9-3.jpg', 49);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'sport9-4.jpg', 49);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'sport10-1.jpg', 50);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'sport10-2.jpg', 50);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'sport10-3.jpg', 50);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'sport10-4.jpg', 50);
--인디
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'indie1-1.jpg', 51);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'indie1-2.jpg', 51);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'indie1-3.jpg', 51);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'indie1-4.jpg', 51);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'indie2-1.jpg', 52);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'indie2-2.jpg', 52);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'indie2-3.jpg', 52);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'indie2-4.jpg', 52);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'indie3-1.jpg', 53);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'indie3-2.jpg', 53);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'indie3-3.jpg', 53);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'indie3-4.jpg', 53);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'indie4-1.jpg', 54);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'indie4-2.jpg', 54);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'indie4-3.jpg', 54);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'indie4-4.jpg', 54);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'indie5-1.jpg', 55);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'indie5-2.jpg', 55);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'indie5-3.jpg', 55);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'indie5-4.jpg', 55);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'indie6-1.jpg', 56);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'indie6-2.jpg', 56);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'indie6-3.jpg', 56);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'indie6-4.jpg', 56);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'indie7-1.jpg', 57);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'indie7-2.jpg', 57);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'indie7-3.jpg', 57);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'indie7-4.jpg', 57);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'indie8-1.jpg', 58);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'indie8-2.jpg', 58);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'indie8-3.jpg', 58);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'indie8-4.jpg', 58);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'indie9-1.jpg', 59);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'indie9-2.jpg', 59);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'indie9-3.jpg', 59);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'indie9-4.jpg', 59);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'indie10-1.jpg', 60);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'indie10-2.jpg', 60);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'indie10-3.jpg', 60);
insert into resources(res_no, res_name, g_no) values(RESOURCES_RES_NO_SEQ.nextval, 'indie10-4.jpg', 60);










--cart
--sy0
insert into cart(c_no, u_no, g_no) values(CART_C_NO_SEQ.nextval, 1, 2);
insert into cart(c_no, u_no, g_no) values(CART_C_NO_SEQ.nextval, 1, 4);
insert into cart(c_no, u_no, g_no) values(CART_C_NO_SEQ.nextval, 1, 6);
--sy1
insert into cart(c_no, u_no, g_no) values(CART_C_NO_SEQ.nextval, 2, 1);
insert into cart(c_no, u_no, g_no) values(CART_C_NO_SEQ.nextval, 2, 3);
insert into cart(c_no, u_no, g_no) values(CART_C_NO_SEQ.nextval, 2, 5);


--wishlist
--sy0
insert into wishlist(wish_no, wish_date, u_no, g_no) values(WISHLIST_WISH_NO_SEQ.nextval, sysdate, 1, 2);
insert into wishlist(wish_no, wish_date, u_no, g_no) values(WISHLIST_WISH_NO_SEQ.nextval, sysdate, 1, 4);
insert into wishlist(wish_no, wish_date, u_no, g_no) values(WISHLIST_WISH_NO_SEQ.nextval, sysdate, 1, 6);
--sy1
insert into wishlist(wish_no, wish_date, u_no, g_no) values(WISHLIST_WISH_NO_SEQ.nextval, sysdate, 2, 1);
insert into wishlist(wish_no, wish_date, u_no, g_no) values(WISHLIST_WISH_NO_SEQ.nextval, sysdate, 2, 3);
insert into wishlist(wish_no, wish_date, u_no, g_no) values(WISHLIST_WISH_NO_SEQ.nextval, sysdate, 2, 5);


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
/*
review_recommend는 평점을 의미. (1~10)
u_no는 작성자를 의미.
*/
insert into review(review_no, review_created_at, review_updated_at, review_comment, review_recommend, review_like, review_dislike, u_no, g_no) values(REVIEW_REVIEW_NO_SEQ.nextval, sysdate, sysdate, '리뷰1', 1, 0, 0, 1, 1);
insert into review(review_no, review_created_at, review_updated_at, review_comment, review_recommend, review_like, review_dislike, u_no, g_no) values(REVIEW_REVIEW_NO_SEQ.nextval, sysdate, sysdate, '리뷰2', 2, 0, 0, 1, 2);
insert into review(review_no, review_created_at, review_updated_at, review_comment, review_recommend, review_like, review_dislike, u_no, g_no) values(REVIEW_REVIEW_NO_SEQ.nextval, sysdate, sysdate, '리뷰3', 3, 0, 0, 1, 3);
insert into review(review_no, review_created_at, review_updated_at, review_comment, review_recommend, review_like, review_dislike, u_no, g_no) values(REVIEW_REVIEW_NO_SEQ.nextval, sysdate, sysdate, '리뷰4', 4, 0, 0, 1, 4);
insert into review(review_no, review_created_at, review_updated_at, review_comment, review_recommend, review_like, review_dislike, u_no, g_no) values(REVIEW_REVIEW_NO_SEQ.nextval, sysdate, sysdate, '리뷰5', 5, 0, 0, 1, 5);
insert into review(review_no, review_created_at, review_updated_at, review_comment, review_recommend, review_like, review_dislike, u_no, g_no) values(REVIEW_REVIEW_NO_SEQ.nextval, sysdate, sysdate, '리뷰6', 6, 0, 0, 1, 6);
insert into review(review_no, review_created_at, review_updated_at, review_comment, review_recommend, review_like, review_dislike, u_no, g_no) values(REVIEW_REVIEW_NO_SEQ.nextval, sysdate, sysdate, '리뷰7', 7, 1, 1, 2, 1);
insert into review(review_no, review_created_at, review_updated_at, review_comment, review_recommend, review_like, review_dislike, u_no, g_no) values(REVIEW_REVIEW_NO_SEQ.nextval, sysdate, sysdate, '리뷰8', 8, 1, 1, 2, 2);
insert into review(review_no, review_created_at, review_updated_at, review_comment, review_recommend, review_like, review_dislike, u_no, g_no) values(REVIEW_REVIEW_NO_SEQ.nextval, sysdate, sysdate, '리뷰9', 9, 1, 1, 2, 3);
insert into review(review_no, review_created_at, review_updated_at, review_comment, review_recommend, review_like, review_dislike, u_no, g_no) values(REVIEW_REVIEW_NO_SEQ.nextval, sysdate, sysdate, '리뷰10', 10, 1, 1, 2, 4);
insert into review(review_no, review_created_at, review_updated_at, review_comment, review_recommend, review_like, review_dislike, u_no, g_no) values(REVIEW_REVIEW_NO_SEQ.nextval, sysdate, sysdate, '리뷰11', 9, 1, 1, 2, 5);
insert into review(review_no, review_created_at, review_updated_at, review_comment, review_recommend, review_like, review_dislike, u_no, g_no) values(REVIEW_REVIEW_NO_SEQ.nextval, sysdate, sysdate, '리뷰12', 8, 1, 1, 2, 6);


--owned_game
--og_playtime은 소유게임별 플레이시간을 의미. 숫자 1은 1시간을 의미. (ex. 10 -> 10시간)
insert into owned_game(og_no, og_playtime, og_lastplay, u_no, g_no) values(OWNED_GAME_OG_NO_SEQ.nextval, 10, sysdate, 1, 1);
insert into owned_game(og_no, og_playtime, og_lastplay, u_no, g_no) values(OWNED_GAME_OG_NO_SEQ.nextval, 10, sysdate, 1, 3);
insert into owned_game(og_no, og_playtime, og_lastplay, u_no, g_no) values(OWNED_GAME_OG_NO_SEQ.nextval, 10, sysdate, 1, 5);
insert into owned_game(og_no, og_playtime, og_lastplay, u_no, g_no) values(OWNED_GAME_OG_NO_SEQ.nextval, 10, sysdate, 2, 2);
insert into owned_game(og_no, og_playtime, og_lastplay, u_no, g_no) values(OWNED_GAME_OG_NO_SEQ.nextval, 10, sysdate, 2, 4);
insert into owned_game(og_no, og_playtime, og_lastplay, u_no, g_no) values(OWNED_GAME_OG_NO_SEQ.nextval, 10, sysdate, 2, 6);


--profile_comment
insert into profile_comment(pc_no, pc_created_at, pc_comment, u_no, u_fno) values(PROFILE_COMMENT_PC_NO_SEQ.nextval, sysdate, '1번유저가 1번유저의 프로필에 쓴 코멘트1', 1, 1);
insert into profile_comment(pc_no, pc_created_at, pc_comment, u_no, u_fno) values(PROFILE_COMMENT_PC_NO_SEQ.nextval, sysdate, '2번유저가 1번유저의 프로필에 쓴 코멘트1', 2, 1);
insert into profile_comment(pc_no, pc_created_at, pc_comment, u_no, u_fno) values(PROFILE_COMMENT_PC_NO_SEQ.nextval, sysdate, '3번유저가 1번유저의 프로필에 쓴 코멘트1', 3, 1);
insert into profile_comment(pc_no, pc_created_at, pc_comment, u_no, u_fno) values(PROFILE_COMMENT_PC_NO_SEQ.nextval, sysdate, '1번유저가 2번유저의 프로필에 쓴 코멘트1', 1, 2);
insert into profile_comment(pc_no, pc_created_at, pc_comment, u_no, u_fno) values(PROFILE_COMMENT_PC_NO_SEQ.nextval, sysdate, '2번유저가 2번유저의 프로필에 쓴 코멘트1', 2, 2);
insert into profile_comment(pc_no, pc_created_at, pc_comment, u_no, u_fno) values(PROFILE_COMMENT_PC_NO_SEQ.nextval, sysdate, '3번유저가 2번유저의 프로필에 쓴 코멘트1', 3, 2);
insert into profile_comment(pc_no, pc_created_at, pc_comment, u_no, u_fno) values(PROFILE_COMMENT_PC_NO_SEQ.nextval, sysdate, '1번유저가 3번유저의 프로필에 쓴 코멘트1', 1, 3);
insert into profile_comment(pc_no, pc_created_at, pc_comment, u_no, u_fno) values(PROFILE_COMMENT_PC_NO_SEQ.nextval, sysdate, '2번유저가 3번유저의 프로필에 쓴 코멘트1', 2, 3);
insert into profile_comment(pc_no, pc_created_at, pc_comment, u_no, u_fno) values(PROFILE_COMMENT_PC_NO_SEQ.nextval, sysdate, '3번유저가 3번유저의 프로필에 쓴 코멘트1', 3, 3);


commit;