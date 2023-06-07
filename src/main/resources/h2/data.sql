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
VALUES (1, '해운대 주짓수  TEAM HJ', '부산 해운대구', 100, 2, 'moon', NULL, 4, 'https://moimfile.s3.ap-northeast-2.amazonaws.com/%EC%A3%BC%EC%A7%93%EC%88%9811.png', '안녕하세요! 저희는 해운대구 중동에 위치한 주짓수 도장입니다. 남녀노소 모두 함께 운동할 수 있는 분위기와 언제나 친절한 감독님과 코치들 그리고 다수의 유색벨트 분들이 계십니다. 언제나 환영합니다! 화이팅
카카오톡 오픈채팅 : https://open.kakao.com/o/gt3F2Gnc', now(), 0, 0, 2, NULL, 1);

INSERT INTO moim
(moimNum, moimName, moimArea, moimHCount, moimNCount, memberId, moimKakao, categoryNum, moimImg, moimProfile, moimDate,
 themeNum, taskNum, businessNum, classprice, moimOrclass)
VALUES (2, '해운대 독서 모임', '부산 해운대구', 100, 2, 'ha', NULL, 5, 'https://moimfile.s3.ap-northeast-2.amazonaws.com/moimsampleImg4.png', '반갑습니다! 저희와 함께 독서 토론도 하면서 친목해봐요!
오픈채팅 : https://open.kakao.com/o/gt3F2Gnc', now(), 0, 0, 2, NULL, 2);

INSERT INTO moim
(moimNum, moimName, moimArea, moimHCount, moimNCount, memberId, moimKakao, categoryNum, moimImg, moimProfile, moimDate,
 themeNum, taskNum, businessNum, classprice, moimOrclass)
VALUES (3, '해운대 스프링 스터디 모임', '부산 해운대구', 10, 2, 'lee', NULL, 6, 'https://moimfile.s3.ap-northeast-2.amazonaws.com/1280px-Spring_Framework_Logo_2018.svg.png', '얼른 취업해야죠! 스프링 공부하면서 면접 연습도 해봅시다!
여기는 오픈채팅방 주소입니다! https://open.kakao.com/o/gt3F2Gnc', now(), 0, 0, 2, NULL, 2);

INSERT INTO moim
(moimNum, moimName, moimArea, moimHCount, moimNCount, memberId, moimKakao, categoryNum, moimImg, moimProfile, moimDate,
 themeNum, taskNum, businessNum, classprice, moimOrclass)
VALUES (4, '해운대 반려견 사랑 모임', '부산 해운대구', 30, 2, 'seo', NULL, 8, 'https://moimfile.s3.ap-northeast-2.amazonaws.com/fome.jpg', '반려견을 사랑하는 사람들의 모임입니다! 편하게 문의해주세요!
문의는 오픈채팅방로 부탁드립니다! https://open.kakao.com/o/gt3F2Gnc', now(), 0, 0, 2, NULL, 2);

INSERT INTO moim
(moimNum, moimName, moimArea, moimHCount, moimNCount, memberId, moimKakao, categoryNum, moimImg, moimProfile, moimDate,
 themeNum, taskNum, businessNum, classprice, moimOrclass)
VALUES (5, '해운대 개발자 취업하러가자!', '부산 해운대구', 20, 2, 'chae', NULL, 6, 'https://moimfile.s3.ap-northeast-2.amazonaws.com/moimsampleImg7.png', '개발자로 취업하기 위한 여정을 함께 해보지 않으시겠습니까?
오픈 채팅방으로 와주세요! https://open.kakao.com/o/gt3F2Gnc', now(), 0, 0, 2, NULL, 1);

-- 모임일정
insert into moimschedule (msNum, msTime, msArea, moimNum, msHCount, memberId, msTitle, msContent, msDate)
values (1, '13:33', '부산 해운대구', 1, 10, 'moon', '모임일정테스트1', '모임일정테스트1', now()),
       (2, '15:55', '서울 강남구', 1, 20, 'moon', '모임일정테스트2', '모임일정테스트2', now());

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