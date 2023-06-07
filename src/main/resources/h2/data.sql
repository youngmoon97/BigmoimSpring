-- 회원
insert into member(memberId, memberPw, memberName, memberTel, memberBirth, memberImg, memberProfile, memberGender,
                   memberAddr, memberJobAddr, memberLikeArea, categoryNum, businessNum, taskNum, themeNum)
values ('moon', '$2a$12$BwmISEeH8nOQs6ZbQoLvGeGsB1SzK5czGpU6dviAlwHDVHTOjlEIe', '조영문', '01026200656', '19970919',
        'https://moimfile.s3.ap-northeast-2.amazonaws.com/bakgu1.jpg', 'profile1', 1,
        '부산 해운대구', '부산 해운대구', '부산 해운대구', 1, 2, 3, 4);

insert into member(memberId, memberPw, memberName, memberTel, memberBirth, memberImg, memberProfile, memberGender,
                   memberAddr, memberJobAddr, memberLikeArea, categoryNum, businessNum, taskNum, themeNum)
values ('chae', '$2a$12$BwmISEeH8nOQs6ZbQoLvGeGsB1SzK5czGpU6dviAlwHDVHTOjlEIe', '채기주', '01012344321', '19980511',
        'https://moimfile.s3.ap-northeast-2.amazonaws.com/jjang.jpg', 'profile1', 1,
        '부산 해운대구', '부산 해운대구', '부산 해운대구', 1, 2, 3, 4);

insert into member(memberId, memberPw, memberName, memberTel, memberBirth, memberImg, memberProfile, memberGender,
                   memberAddr, memberJobAddr, memberLikeArea, categoryNum, businessNum, taskNum, themeNum)
values ('lee', '$2a$12$BwmISEeH8nOQs6ZbQoLvGeGsB1SzK5czGpU6dviAlwHDVHTOjlEIe', '이상목', '01052481328', '19970322',
        'https://moimfile.s3.ap-northeast-2.amazonaws.com/bg_111.jpg', 'profile1', 1,
        '부산 해운대구', '부산 해운대구', '부산 해운대구', 1, 2, 3, 4);

insert into member(memberId, memberPw, memberName, memberTel, memberBirth, memberImg, memberProfile, memberGender,
                   memberAddr, memberJobAddr, memberLikeArea, categoryNum, businessNum, taskNum, themeNum)
values ('seo', '$2a$12$BwmISEeH8nOQs6ZbQoLvGeGsB1SzK5czGpU6dviAlwHDVHTOjlEIe', '서지우', '01043218252', '19980505',
        'https://moimfile.s3.ap-northeast-2.amazonaws.com/cute.png', 'profile1', 2,
        '부산 해운대구', '부산 해운대구', '부산 해운대구', 1, 2, 3, 4);

insert into member(memberId, memberPw, memberName, memberTel, memberBirth, memberImg, memberProfile, memberGender,
                   memberAddr, memberJobAddr, memberLikeArea, categoryNum, businessNum, taskNum, themeNum)
values ('ha', '$2a$12$BwmISEeH8nOQs6ZbQoLvGeGsB1SzK5czGpU6dviAlwHDVHTOjlEIe', '하서영', '01093314616', '20000317',
        'https://moimfile.s3.ap-northeast-2.amazonaws.com/drone-lencois-maranhenses-VpjWLQ98Brw-unsplash.jpg', 'profile1', 2,
        '부산 해운대구', '부산 해운대구', '부산 해운대구', 1, 2, 3, 4);

--역할-유저
insert into role(memberId, role, moimNum, createDate)
values ('moon', 'USER', null, now()),
       ('ha', 'USER', null, now()),
       ('lee', 'USER', null, now()),
       ('seo', 'USER', null, now()),
       ('chae', 'USER', null, now());

-- 역할-admin
insert into role(memberId, role, moimNum, createDate)
values ('aaa', 'ADMIN', null, now());

-- 역할 리더
insert into role(memberId, role, moimNum, createDate)
values ('moon', 'LEADER', 1, now()),
       ('ha', 'LEADER', 2, now()),
       ('lee', 'LEADER', 3, now()),
       ('seo', 'LEADER', 4, now()),
       ('chae', 'LEADER', 5, now());
-- 역할 가입멤버
insert into role(memberId, role, moimNum, createDate)
values ('lee', 'member', 1, now()),
       ('seo', 'member', 1, now()),
       ('chae', 'member', 1, now());

-- 모임
INSERT INTO moim
(moimNum, moimName, moimArea, moimHCount, moimNCount, memberId, moimKakao, categoryNum, moimImg, moimProfile, moimDate,
 themeNum, taskNum, businessNum, classprice, moimOrclass)
VALUES (1, '해운대 주짓수  TEAM HJ', '부산 해운대구', 100, 2, 'moon', NULL, 4, 'https://bigmoim.s3.ap-northeast-2.amazonaws.com/image/%EC%A3%BC%EC%A7%93%EC%88%9811.png', '안녕하세요! 저희는 해운대구 중동에 위치한 주짓수 도장입니다. 남녀노소 모두 함께 운동할 수 있는 분위기와 언제나 친절한 감독님과 코치들 그리고 다수의 유색벨트 분들이 계십니다. 언제나 환영합니다! 화이팅
카카오톡 오픈채팅 : https://open.kakao.com/o/gt3F2Gnc', now(), 0, 0, 2, NULL, 1);

INSERT INTO moim
(moimNum, moimName, moimArea, moimHCount, moimNCount, memberId, moimKakao, categoryNum, moimImg, moimProfile, moimDate,
 themeNum, taskNum, businessNum, classprice, moimOrclass)
VALUES (2, '해운대 독서 모임', '부산 중구', 100, 2, 'ha', NULL, 5, 'https://bigmoim.s3.ap-northeast-2.amazonaws.com/image/moimsampleImg4.png', '반갑습니다! 저희와 함께 독서 토론도 하면서 친목해봐요!
오픈채팅 : https://open.kakao.com/o/gt3F2Gnc', now(), 0, 0, 2, NULL, 2);

INSERT INTO moim
(moimNum, moimName, moimArea, moimHCount, moimNCount, memberId, moimKakao, categoryNum, moimImg, moimProfile, moimDate,
 themeNum, taskNum, businessNum, classprice, moimOrclass)
VALUES (3, '해운대 스프링 스터디 모임', '부산 남구', 10, 2, 'lee', NULL, 6, 'https://bigmoim.s3.ap-northeast-2.amazonaws.com/image/1280px-Spring_Framework_Logo_2018.svg.png', '얼른 취업해야죠! 스프링 공부하면서 면접 연습도 해봅시다!
여기는 오픈채팅방 주소입니다! https://open.kakao.com/o/gt3F2Gnc', now(), 0, 0, 2, NULL, 2);

INSERT INTO moim
(moimNum, moimName, moimArea, moimHCount, moimNCount, memberId, moimKakao, categoryNum, moimImg, moimProfile, moimDate,
 themeNum, taskNum, businessNum, classprice, moimOrclass)
VALUES (4, '해운대 반려견 사랑 모임', '부산 진구', 30, 2, 'seo', NULL, 8, 'https://bigmoim.s3.ap-northeast-2.amazonaws.com/image/fome.jpg', '반려견을 사랑하는 사람들의 모임입니다! 편하게 문의해주세요!
문의는 오픈채팅방로 부탁드립니다! https://open.kakao.com/o/gt3F2Gnc', now(), 0, 0, 2, NULL, 2);

INSERT INTO moim
(moimNum, moimName, moimArea, moimHCount, moimNCount, memberId, moimKakao, categoryNum, moimImg, moimProfile, moimDate,
 themeNum, taskNum, businessNum, classprice, moimOrclass)
VALUES (5, '해운대 개발자 취업하러가자!', '부산 해운대구', 20, 2, 'chae', NULL, 6, 'https://bigmoim.s3.ap-northeast-2.amazonaws.com/image/moimsampleImg7.png', '개발자로 취업하기 위한 여정을 함께 해보지 않으시겠습니까?
오픈 채팅방으로 와주세요! https://open.kakao.com/o/gt3F2Gnc', now(), 0, 0, 2, NULL, 1);
-- 추가 --

INSERT INTO moim
(moimNum, moimName, moimArea, moimHCount, moimNCount, memberId, moimKakao, categoryNum, moimImg, moimProfile, moimDate,
 themeNum, taskNum, businessNum, classprice, moimOrclass)
VALUES (6, '리그오브레전드 1대1 수업', '부산 남구', 20, 6, 'chae', NULL, 6, 'https://bigmoim.s3.ap-northeast-2.amazonaws.com/image/teeme.jpg', '안녕하세요! 저희는 전문적으로 리그오브레전드 게임을 가르쳐드리는 팀입니다! 같이 게임도 하고 랭크도 올려보아요~
오픈 채팅방으로 와주세요! https://open.kakao.com/o/gt3F2Gnc', now(), 0, 0, 2, NULL, 1);

INSERT INTO moim
(moimNum, moimName, moimArea, moimHCount, moimNCount, memberId, moimKakao, categoryNum, moimImg, moimProfile, moimDate,
 themeNum, taskNum, businessNum, classprice, moimOrclass)
VALUES (7, '강아지 산책 모임', '부산 중구', 20, 2, 'chae', NULL, 6, 'https://bigmoim.s3.ap-northeast-2.amazonaws.com/image/fome1.jpg', '다같이 우리 함께 반려견과 산책해요
오픈 채팅방으로 와주세요! https://open.kakao.com/o/gt3F2Gnc', now(), 0, 0, 2, NULL, 1);

INSERT INTO moim
(moimNum, moimName, moimArea, moimHCount, moimNCount, memberId, moimKakao, categoryNum, moimImg, moimProfile, moimDate,
 themeNum, taskNum, businessNum, classprice, moimOrclass)
VALUES (8, '같이 디제잉 합시다!', '부산 가야', 20, 2, 'chae', NULL, 6, 'https://bigmoim.s3.ap-northeast-2.amazonaws.com/image/study.jpg', '같이 디제잉 하실래요? 초보여도 ok!
오픈 채팅방으로 와주세요! https://open.kakao.com/o/gt3F2Gnc', now(), 0, 0, 2, NULL, 1);

INSERT INTO moim
(moimNum, moimName, moimArea, moimHCount, moimNCount, memberId, moimKakao, categoryNum, moimImg, moimProfile, moimDate,
 themeNum, taskNum, businessNum, classprice, moimOrclass)
VALUES (9, '짱사모!', '부산 해운대구', 20, 2, 'chae', NULL, 6, 'https://bigmoim.s3.ap-northeast-2.amazonaws.com/image/jjang3.jpg', '개발자로 취업하기 위한 여정을 함께 해보지 않으시겠습니까?
오픈 채팅방으로 와주세요! https://open.kakao.com/o/gt3F2Gnc', now(), 0, 0, 2, NULL, 1);

INSERT INTO moim
(moimNum, moimName, moimArea, moimHCount, moimNCount, memberId, moimKakao, categoryNum, moimImg, moimProfile, moimDate,
 themeNum, taskNum, businessNum, classprice, moimOrclass)
VALUES (10, '22_부산인자위_자바기반IoT융합서비스개발자 모임', '부산 해운대구', 20, 2, 'chae', NULL, 6, 'https://bigmoim.s3.ap-northeast-2.amazonaws.com/image/flower2.jpg', '막강한 강사진!, 체계적인 관리! 상승하는 코딩실력! 모두가 함께하는 화합! 자바기반 Iot 개발자 모집합니다. 인원이 작으니 어서 신청하세요!
오픈 채팅방으로 와주세요! https://open.kakao.com/o/gt3F2Gnc', now(), 0, 0, 2, NULL, 1);

INSERT INTO moim
(moimNum, moimName, moimArea, moimHCount, moimNCount, memberId, moimKakao, categoryNum, moimImg, moimProfile, moimDate,
 themeNum, taskNum, businessNum, classprice, moimOrclass)
VALUES (11, '고양이좋아!!', '부산 남구', 20, 2, 'chae', NULL, 6, 'https://bigmoim.s3.ap-northeast-2.amazonaws.com/image/rhdiddl1.jpg', '고양이조아
오픈 채팅방으로 와주세요! https://open.kakao.com/o/gt3F2Gnc', now(), 0, 0, 2, NULL, 1);

INSERT INTO moim
(moimNum, moimName, moimArea, moimHCount, moimNCount, memberId, moimKakao, categoryNum, moimImg, moimProfile, moimDate,
 themeNum, taskNum, businessNum, classprice, moimOrclass)
VALUES (12, '도자기 만들긔', '부산 북구', 20, 2, 'chae', NULL, 6, 'https://bigmoim.s3.ap-northeast-2.amazonaws.com/image/moimsampleImg81.png', '주말마다 자신의 그릇을 만들어요
오픈 채팅방으로 와주세요! https://open.kakao.com/o/gt3F2Gnc', now(), 0, 0, 2, NULL, 1);

INSERT INTO moim
(moimNum, moimName, moimArea, moimHCount, moimNCount, memberId, moimKakao, categoryNum, moimImg, moimProfile, moimDate,
 themeNum, taskNum, businessNum, classprice, moimOrclass)
VALUES (13, '부산 해운대 친목 모임', '부산 진구', 20, 2, 'chae', NULL, 6, 'https://bigmoim.s3.ap-northeast-2.amazonaws.com/image/beer.jpg', '부산 해운대 친목 모임입니다. 친목하면서 친구 먹어요!
오픈 채팅방으로 와주세요! https://open.kakao.com/o/gt3F2Gnc', now(), 0, 0, 2, NULL, 1);

INSERT INTO moim
(moimNum, moimName, moimArea, moimHCount, moimNCount, memberId, moimKakao, categoryNum, moimImg, moimProfile, moimDate,
 themeNum, taskNum, businessNum, classprice, moimOrclass)
VALUES (14, '해운대 Guitar Club', '부산 해운대구', 20, 2, 'chae', NULL, 6, 'https://bigmoim.s3.ap-northeast-2.amazonaws.com/image/guitar.jpg', '안녕하세요! 같이 기타도 배우고 버스킹도 해보아요! 초보도 언제든지 환영입니다!
오픈 채팅방으로 와주세요! https://open.kakao.com/o/gt3F2Gnc', now(), 0, 0, 2, NULL, 1);


-- 모임일정
insert into moimschedule (msNum, msTime, msArea, moimNum, msHCount, memberId, msTitle, msContent, msDate)
values (1, '13:33', '부산 해운대구', 1, 10, 'moon', '해운대 주짓수 1회차 정기모임', '주짓수 훈련 및 뒤풀이 식사 진행합니다!', now()),
       (2, '15:55', '서울 강남구', 1, 20, 'moon', '해운대 주짓수 서울 경기 관람', '서울에서 진행하는 주짓수 경기 관람', now()),
       (3, '20:00', '부산 연제구', 5, 20, 'chae', '해운대 개발자 취업 설명회 1회차', '부산 취업센터에서 강사님 모시고 취업특강 진행합니다.', '2023-06-10'),
       (4, '21:00', '부산 연제구', 5, 20, 'chae', '해운대 개발자 취업 설명회 2회차', '부산 취업센터에서 강사님 모시고 취업특강 진행합니다.', '2023-06-11'),
       (5, '20:00', '부산 해운대구', 6, 20, 'chae', '리그오브레전드 내전', '같이 즐겁게 내전해요~ 실력이 좋지 않아도 괜찮습니다!! 팀/포지션은 협의해서 결정합니다', '2023-06-08'),
       (6, '20:00', '부산 해운대구', 7, 10, 'chae', '해운대 공원 강아지 산책회', '인원 산정을 위해 빠른 참가신청 부탁드립니다.', '2023-06-10'),
       (7, '20:30', '부산 사상구', 8, 5, 'chae', '부산 디제잉 페스티벌 연습 모임', '사상역 인근 연습실 대여해서 진행합니다! 페스티벌 미참석자 분들도 참여 가능', '2023-06-11'),
       (8, '20:30', '부산 사상구', 8, 10, 'chae', '부산 디제잉 페스티벌 참여인원 조사', '부산 디제잉 페스티벌 참여하시는 분들은 참여신청 부탁드립니다!!', '2023-06-20'),
       (9, '21:00', '부산 사하구', 10, 20, 'chae', '훈련 수료 기념 회식', '장소:미진축산 회비:1만원 자율참석', '2023-06-15'),
       (10, '10:00', '부산 중구', 11, 20, 'chae', '고양이카페 방문', '중구에 새로생긴 인기있는 고양이카페 방문 고고!!', '2023-07-01'),
       (11, '10:00', '부산 동구', 12, 10, 'chae', '도자기 만들기 기초반', '동구 도자기 교실에서 진행합니다~ 기초반입니다.', '2023-07-11'),
       (12, '11:00', '부산 동구', 12, 20, 'chae', '도자기 만들기 심화반', '동구 도자기 교실에서 진행합니다~ 10회이상 경험이 있는 심화반입니다.', '2023-07-10'),
       (13, '12:20', '부산 해운대구', 13, 30, 'chae', '해운대 인근 회식', '해운대 인근에서 소고기 회식합니다. 참가비:2만원 정원:30명 상세장소:별도안내', '2023-07-05'),
       (14, '20:10', '부산 동구', 14, 20, 'chae', '기타 강습', '전문 강사님 두분(클래식/통기타), 시니어분들(모든 종류 기타) 모시고 주니어분들 강습 진행합니다~ 두곡이상 치는게 목표!!', '2023-06-10'),
       (15, '20:00', '부산 동구', 14, 20, 'chae', '클래식 기타 연주회', '23년도 10회차 클래식 기타 연주회 장소:동구 기타좋아 라이브카페 참가비:5천원(음료 무료제공)', '2023-06-10');
-- 일정신청
insert into schedulejoin (sjNum, msNum, memberId, moimNum)
values (1, 1, 'moon', 1),
       (2, 1, 'lee', 1),
       (3, 2, 'seo', 1);


-- 직무
insert into task
values (1, '기획/전략/경영직');
insert into task (taskName)
values ('의료/보건직');
insert into task (taskName)
values ('교사/강사/교육직');
insert into task (taskName)
values ('프로그래머/개발직');
insert into task (taskName)
values ('디자이너');
insert into task (taskName)
values ('마케터/PR');
insert into task (taskName)
values ('영업/제휴직');
insert into task (taskName)
values ('비서/수행원');
insert into task (taskName)
values ('인사/노무직');
insert into task (taskName)
values ('법률/법무직');
insert into task (taskName)
values ('재무/회계/세무직');
insert into task (taskName)
values ('외국어/통역직');
insert into task (taskName)
values ('상품기획/MD');
insert into task (taskName)
values ('설계/건축가');
insert into task (taskName)
values ('구매/자재직');
insert into task (taskName)
values ('물류/재고직');
insert into task (taskName)
values ('공정/품질관리');
insert into task (taskName)
values ('사회복지사');
insert into task (taskName)
values ('안내/상담직');
insert into task (taskName)
values ('요리/영양/제빵');
insert into task (taskName)
values ('예술/방송인');
insert into task (taskName)
values ('정비/기술직');
insert into task (taskName)
values ('체육/스포츠직');
insert into task (taskName)
values ('뷰티/미용직');
insert into task (taskName)
values ('경호/보안직');
insert into task (taskName)
values ('서비스직');

-- 테마
insert into theme(themeName)
values ('대기업');
insert into theme(themeName)
values ('중소기업/강소기업');
insert into theme(themeName)
values ('외국계');
insert into theme(themeName)
values ('공기업/공무원');
insert into theme(themeName)
values ('사업/창업');
insert into theme(themeName)
values ('프래랜서');
insert into theme(themeName)
values ('대학원/연구원');
insert into theme(themeName)
values ('인턴');
insert into theme(themeName)
values ('알바');

-- 업무
INSERT INTO business (businessName)
VALUES ('의료/건강/제약'),
       ('IT/포털/인터넷'),
       ('교육업'),
       ('광고/마케팅업계'),
       ('디자인업계'),
       ('무역/상사'),
       ('금융업'),
       ('세무/회계'),
       ('법률/법무/법조계'),
       ('컨설팅');
INSERT INTO business (businessName)
VALUES ('전자/기계/전기'),
       ('자동차'),
       ('에너지/화학'),
       ('조선/중공업'),
       ('패션/의류/뷰티'),
       ('건축/건설/인테리어'),
       ('물류/항공/운수'),
       ('백화점/유통/소비재'),
       ('문화/예술'),
       ('방송/언론/출판');
INSERT INTO business (businessName)
VALUES ('여행/호텔/레저'),
       ('부동산/중개업'),
       ('식음료/외식업'),
       ('서비스업');

-- moimcategory
INSERT INTO category (categoryName, categoryImg)
VALUES ('게임/오락','https://categoryfile.s3.ap-northeast-2.amazonaws.com/image/category1.png'),
       ('요리/제빵','https://categoryfile.s3.ap-northeast-2.amazonaws.com/image/category2.png'),
       ('아웃도어/여행','https://categoryfile.s3.ap-northeast-2.amazonaws.com/image/category3.png'),
       ('운동/스포츠','https://categoryfile.s3.ap-northeast-2.amazonaws.com/image/category4.png'),
       ('인문학/책/글','https://categoryfile.s3.ap-northeast-2.amazonaws.com/image/category5.png'),
       ('업종/직무','https://categoryfile.s3.ap-northeast-2.amazonaws.com/image/category6.png'),
       ('외국/언어','https://categoryfile.s3.ap-northeast-2.amazonaws.com/image/category7.png'),
       ('문화/공연/축제','https://categoryfile.s3.ap-northeast-2.amazonaws.com/image/category8.png'),
       ('음악/악기','https://categoryfile.s3.ap-northeast-2.amazonaws.com/image/category9.png'),
       ('공예/만들기','https://categoryfile.s3.ap-northeast-2.amazonaws.com/image/category10.png');
INSERT INTO category (categoryName, categoryImg)
VALUES ('댄스/무용','https://categoryfile.s3.ap-northeast-2.amazonaws.com/image/category11.png'),
       ('봉사활동','https://categoryfile.s3.ap-northeast-2.amazonaws.com/image/category12.png'),
       ('사교/인맥','https://categoryfile.s3.ap-northeast-2.amazonaws.com/image/category13.png'),
       ('차/오토바이','https://categoryfile.s3.ap-northeast-2.amazonaws.com/image/category14.png'),
       ('사진/영상','https://categoryfile.s3.ap-northeast-2.amazonaws.com/image/category15.png'),
       ('야구관람','https://categoryfile.s3.ap-northeast-2.amazonaws.com/image/category16.png'),
       ('반려동물','https://categoryfile.s3.ap-northeast-2.amazonaws.com/image/category17.png'),
       ('가족/결혼','https://categoryfile.s3.ap-northeast-2.amazonaws.com/image/category18.png'),
       ('자유주제','https://categoryfile.s3.ap-northeast-2.amazonaws.com/image/category19.png');