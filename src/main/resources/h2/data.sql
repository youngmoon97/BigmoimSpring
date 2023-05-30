-- 회원
insert into member(memberId, memberPw, memberName, memberTel, memberBirth, memberImg, memberProfile, memberGender,
                   memberAddr, memberJobAddr, memberLikeArea, categoryNum, businessNum, taskNum, themeNum)
values ('moon', '$2a$12$BwmISEeH8nOQs6ZbQoLvGeGsB1SzK5czGpU6dviAlwHDVHTOjlEIe', '조영문', '01026200656', '19970919',
        'img1', 'profile1', 1,
        '부산 해운대구', '부산 해운대구', '부산 해운대구', 1, 2, 3, 4);

insert into member(memberId, memberPw, memberName, memberTel, memberBirth, memberImg, memberProfile, memberGender,
                   memberAddr, memberJobAddr, memberLikeArea, categoryNum, businessNum, taskNum, themeNum)
values ('chae', '$2a$12$BwmISEeH8nOQs6ZbQoLvGeGsB1SzK5czGpU6dviAlwHDVHTOjlEIe', '채기주', '01012344321', '19970919',
        'img1', 'profile1', 1,
        '부산 해운대구', '부산 해운대구', '부산 해운대구', 1, 2, 3, 4);

--역할
insert into role(memberId, role, create_date)
values ('moon', 'USER', now()),
       ('chae', 'ADMIN', now());


-- 모임
INSERT INTO moim
(moimNum, moimName, moimArea, moimHCount, moimNCount, memberId, moimKakao, categoryNum, moimImg, moimProfile, moimDate, themeNum, taskNum, businessNum, classprice, moimOrclass)
VALUES(1, '해운대 주짓수  TEAM HJ', '부산 해운대구', 100, 2, 'moon', NULL, 4, '주짓수11.png', '안녕하세요! 저희는 해운대구 중동에 위치한 주짓수 도장입니다. 남녀노소 모두 함께 운동할 수 있는 분위기와 언제나 친절한 감독님과 코치들 그리고 다수의 유색벨트 분들이 계십니다. 언제나 환영합니다! 화이팅
카카오톡 오픈채팅 : https://open.kakao.com/o/gt3F2Gnc', '2023-05-03', 0, 0, 0, NULL, 2);


-- 직무
insert into task values(1,'기획/전략/경영직');
insert into task (taskName) values('의료/보건직');
insert into task (taskName) values('교사/강사/교육직');
insert into task (taskName) values('프로그래머/개발직');
insert into task (taskName) values('디자이너');
insert into task (taskName) values('마케터/PR');
insert into task (taskName) values('영업/제휴직');
insert into task (taskName) values('비서/수행원');
insert into task (taskName) values('인사/노무직');
insert into task (taskName) values('법률/법무직');
insert into task (taskName) values('재무/회계/세무직');
insert into task (taskName) values('외국어/통역직');
insert into task (taskName) values('상품기획/MD');
insert into task (taskName) values('설계/건축가');
insert into task (taskName) values('구매/자재직');
insert into task (taskName) values('물류/재고직');
insert into task (taskName) values('공정/품질관리');
insert into task (taskName) values('사회복지사');
insert into task (taskName) values('안내/상담직');
insert into task (taskName) values('요리/영양/제빵');
insert into task (taskName) values('예술/방송인');
insert into task (taskName) values('정비/기술직');
insert into task (taskName) values('체육/스포츠직');
insert into task (taskName) values('뷰티/미용직');
insert into task (taskName) values('경호/보안직');
insert into task (taskName) values('서비스직');

-- 테마
insert into theme(themeName) values('대기업');
insert into theme(themeName) values('중소기업/강소기업');
insert into theme(themeName) values('외국계');
insert into theme(themeName) values('공기업/공무원');
insert into theme(themeName) values('사업/창업');
insert into theme(themeName) values('프래랜서');
insert into theme(themeName) values('대학원/연구원');
insert into theme(themeName) values('인턴');
insert into theme(themeName) values('알바');

-- 업무
INSERT INTO business (businessName) VALUES
                                                ('의료/건강/제약'),
                                                ('IT/포털/인터넷'),
                                                ('교육업'),
                                                ('광고/마케팅업계'),
                                                ('디자인업계'),
                                                ('무역/상사'),
                                                ('금융업'),
                                                ('세무/회계'),
                                                ('법률/법무/법조계'),
                                                ('컨설팅');
INSERT INTO business (businessName) VALUES
                                                ('전자/기계/전기'),
                                                ('자동차'),
                                                ('에너지/화학'),
                                                ('조선/중공업'),
                                                ('패션/의류/뷰티'),
                                                ('건축/건설/인테리어'),
                                                ('물류/항공/운수'),
                                                ('백화점/유통/소비재'),
                                                ('문화/예술'),
                                                ('방송/언론/출판');
INSERT INTO business (businessName) VALUES
                                                ('여행/호텔/레저'),
                                                ('부동산/중개업'),
                                                ('식음료/외식업'),
                                                ('서비스업');
-- moimcategory
INSERT INTO category (categoryName) VALUES
                                                    ('게임/오락'),
                                                    ('요리/제빵'),
                                                    ('아웃도어/여행'),
                                                    ('운동/스포츠'),
                                                    ('인문학/책/글'),
                                                    ('업종/직무'),
                                                    ('외국/언어'),
                                                    ('문화/공연/축제'),
                                                    ('음악/악기'),
                                                    ('공예/만들기');
INSERT INTO category (categoryName) VALUES
                                                    ('댄스/무용'),
                                                    ('봉사활동'),
                                                    ('사교/인맥'),
                                                    ('차/오토바이'),
                                                    ('사진/영상'),
                                                    ('야구관람'),
                                                    ('반려동물'),
                                                    ('가족/결혼'),
                                                    ('자유주제');