-- bigmoimspring.business definition

CREATE TABLE `business`
(
    `businessNum`  int NOT NULL AUTO_INCREMENT,
    `businessName` varchar(50) DEFAULT NULL,
    PRIMARY KEY (`businessNum`)
);


-- bigmoimspring.category definition

CREATE TABLE `category`
(
    `categoryNum`  int          NOT NULL AUTO_INCREMENT COMMENT '카테고리번호',
    `categoryName` varchar(100) NOT NULL COMMENT '카테고리 명',
    `categoryImg`  varchar(100) DEFAULT NULL,
    PRIMARY KEY (`categoryNum`)
);

-- bigmoimspring.task definition

CREATE TABLE `task`
(
    `taskNum`  int NOT NULL AUTO_INCREMENT,
    `taskName` varchar(50) DEFAULT NULL,
    PRIMARY KEY (`taskNum`)
);


-- bigmoimspring.theme definition

CREATE TABLE `theme`
(
    `themeNum`  int NOT NULL AUTO_INCREMENT,
    `themeName` varchar(100) DEFAULT NULL,
    PRIMARY KEY (`themeNum`)
);


-- bigmoimspring.zipcode definition

CREATE TABLE `zipcode`
(
    `zipcode` char(7) NOT NULL,
    `area1`   char(10) DEFAULT NULL,
    `area2`   char(20) DEFAULT NULL,
    `area3`   char(40) DEFAULT NULL,
    `area4`   char(20) DEFAULT NULL
);

-- bigmoimspring.admin definition

CREATE TABLE `admin`
(
    `adminId`   varchar(50)  NOT NULL COMMENT '관리자아이디',
    `adminPw`   varchar(100) NOT NULL COMMENT '관리자비밀번호',
    `adminName` varchar(50)  NOT NULL COMMENT '관리자이름',
    `adminTel`  varchar(50)  NOT NULL COMMENT '관리자전화번호',
    PRIMARY KEY (`adminId`)
);

-- bigmoimspring.`member` definition
CREATE TABLE `member`
(
    `memberId`       varchar(50)  NOT NULL,
    `memberPw`       varchar(100) NOT NULL,
    `memberName`     varchar(50)  NOT NULL,
    `memberTel`      varchar(50)  NOT NULL,
    `memberBirth`    varchar(10)  NOT NULL,
    `memberImg`      varchar(200) DEFAULT NULL,
    `memberProfile`  varchar(200) DEFAULT NULL,
    `memberGender`   int          NOT NULL,
    `memberAddr`     varchar(100),
    `memberJobAddr`  varchar(100) DEFAULT NULL,
    `memberLikeArea` varchar(100) DEFAULT NULL,
    `categoryNum`    int          DEFAULT NULL,
    `businessNum`    int          DEFAULT NULL,
    `taskNum`        int          DEFAULT NULL,
    `themeNum`       int          DEFAULT NULL,
    PRIMARY KEY (`memberId`),
    KEY              `member_FK` (`businessNum`) USING BTREE,
    KEY              `member_FK_1` (`categoryNum`) USING BTREE,
    KEY              `member_FK_2` (`taskNum`) USING BTREE,
    KEY              `member_FK_3` (`themeNum`) USING BTREE
);

-- bigmoimspring.moim definition

CREATE TABLE `moim`
(
    `moimNum`     int          NOT NULL AUTO_INCREMENT COMMENT '모임번호',
    `moimName`    varchar(100) NOT NULL COMMENT '모임이름',
    `moimArea`    varchar(100) NOT NULL COMMENT '모임 주활동지역',
    `moimHCount`  int                   DEFAULT NULL COMMENT '모임 전체 정원',
    `moimNCount`  int                   DEFAULT '1' COMMENT '모임 현재 인원',
    `memberId`    varchar(50)  NOT NULL COMMENT '모임회원아이디',
    `moimKakao`   varchar(100)          DEFAULT NULL COMMENT '모임 카카오톡 링크',
    `categoryNum` int                   DEFAULT NULL COMMENT '모임 카테고리 번호',
    `moimImg`     varchar(100) NULL COMMENT '모임 사진모음',
    `moimProfile` varchar(2000)         DEFAULT NULL COMMENT '모임 소개 내용',
    `moimDate`    TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '모임개설일자',
    `themeNum`    int                   DEFAULT NULL COMMENT '테마',
    `taskNum`     int                   DEFAULT NULL COMMENT '직무',
    `businessNum` int                   DEFAULT NULL COMMENT '업종',
    `classprice`  varchar(100)          DEFAULT NULL COMMENT '클래스가격',
    `moimOrclass` int          NOT NULL COMMENT '2=모임, 1=클래스',
    PRIMARY KEY (`moimNum`),
    KEY           `moim_FK` (`memberId`) USING BTREE,
    KEY           `moim_FK_1` (`categoryNum`) USING BTREE,
    KEY           `moim_FK_2` (`taskNum`) USING BTREE,
    KEY           `moim_FK_3` (`businessNum`) USING BTREE,
    KEY           `moim_FK_4` (`themeNum`) USING BTREE
);

-- bigmoim.`role` definition
CREATE TABLE `role`
(
    roleIdx    int          NOT NULL AUTO_INCREMENT,
    memberId   varchar(50)  NOT NULL,
    role       varchar(255) NOT NULL,
    moimNum    int,
    createDate TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (roleIdx),
    KEY        `role_FK` (`moimNum`) USING BTREE,
    KEY        `role_FK_1` (`memberId`) USING BTREE
);
-- bigmoimspring.classcomment definition

CREATE TABLE `classcomment`
(
    `ccNum`     int           NOT NULL AUTO_INCREMENT,
    `ccComment` varchar(1000) NOT NULL,
    `memberId`  varchar(100)  NOT NULL,
    `moimNum`   int           NOT NULL,
    `ccDate`    TIMESTAMP     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`ccNum`),
    KEY         `classcomment_FK` (`memberId`) USING BTREE,
    KEY         `classcomment_FK_1` (`moimNum`) USING BTREE
);


-- bigmoimspring.jjimlist definition

CREATE TABLE `jjimlist`
(
    `jjimNum`  int NOT NULL AUTO_INCREMENT,
    `memberId` varchar(50) DEFAULT NULL,
    `moimNum`  int         DEFAULT NULL,
    PRIMARY KEY (`jjimNum`),
    KEY        `jjimlist_FK` (`moimNum`) USING BTREE,
    KEY        `jjimlist_FK_2` (`memberId`) USING BTREE
);


-- bigmoimspring.memberboard definition

CREATE TABLE `memberboard`
(
    `mbNum`     int           NOT NULL AUTO_INCREMENT COMMENT '회원게시글 번호',
    `mbTitle`   varchar(100)  NOT NULL COMMENT '회원게시글 제목',
    `mbContent` varchar(2000) NOT NULL COMMENT '회원게시글 내용',
    `mbDate`    TIMESTAMP     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '회원게시글 작성일자',
    `memberId`  varchar(50)   NOT NULL COMMENT '게시글작성 회원',
    `mbImg`     varchar(100)           DEFAULT NULL COMMENT '게시글 이미지',
    `moimNum`   int           NOT NULL,
    `boardType` int           NOT NULL DEFAULT '0',
    PRIMARY KEY (`mbNum`),
    KEY         `memberboard_FK` (`memberId`) USING BTREE,
    KEY         `memberboard_FK_1` (`moimNum`) USING BTREE
);

-- bigmoimspring.boardcomment definition

CREATE TABLE `boardcomment`
(
    `bcNum`     int       NOT NULL AUTO_INCREMENT,
    `bcContent` varchar(1000)      DEFAULT NULL,
    `memberId`  varchar(50)        DEFAULT NULL,
    `bcDate`    TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `mbNum`     int       NOT NULL,
    PRIMARY KEY (`bcNum`),
    KEY         `bcomment_FK` (`mbNum`) USING BTREE,
    KEY         `bcomment_FK_1` (`memberId`) USING BTREE
);


-- bigmoimspring.moimjoin definition

CREATE TABLE `moimjoin`
(
    `mjNum`     int         NOT NULL AUTO_INCREMENT COMMENT '모임가입번호',
    `moimNum`   int         NOT NULL,
    `memberId`  varchar(50) NOT NULL,
    `mjCheck`   int         NOT NULL DEFAULT '0' COMMENT '0=승인전, 1=승인후',
    `mjDate`    TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '신청일자',
    `mjContent` varchar(100)         DEFAULT NULL,
    PRIMARY KEY (`mjNum`),
    KEY         `moimjoin_FK` (`moimNum`) USING BTREE,
    KEY         `moimjoin_FK_1` (`memberId`) USING BTREE
);


-- bigmoimspring.moimphotos definition

CREATE TABLE `moimphotos`
(
    `photoNum`  int         NOT NULL AUTO_INCREMENT COMMENT '사진첩 번호',
    `moimNum`   int         NOT NULL COMMENT '모임 번호',
    `photo`     varchar(100)         DEFAULT NULL,
    `upDate`    TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `memberId`  varchar(50) NOT NULL,
    `photoName` varchar(100)         DEFAULT NULL,
    PRIMARY KEY (`photoNum`),
    KEY         `moimPhotos_FK` (`moimNum`) USING BTREE,
    KEY         `moimphotos_FK1` (`memberId`) USING BTREE
);


-- bigmoimspring.moimschedule definition

CREATE TABLE `moimschedule`
(
    `msNum`     int       NOT NULL AUTO_INCREMENT,
    `msTime`    varchar(100)       DEFAULT NULL,
    `msArea`    varchar(100)       DEFAULT NULL,
    `moimNum`   int                DEFAULT NULL,
    `msHCount`  int                DEFAULT NULL,
    `memberId`  varchar(50)        DEFAULT NULL,
    `msNCount`  int                DEFAULT '0',
    `msTitle`   varchar(100)       DEFAULT NULL,
    `msContent` varchar(200)       DEFAULT NULL,
    `msDate`    TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`msNum`),
    KEY         `moimschedule_FK` (`memberId`) USING BTREE,
    KEY         `moimschedule_FK_1` (`moimNum`) USING BTREE
);


-- bigmoimspring.recentseen definition

CREATE TABLE `recentseen`
(
    `recentseenNum` int       NOT NULL AUTO_INCREMENT,
    `memberId`      varchar(50)        DEFAULT NULL,
    `moimNum`       int                DEFAULT NULL,
    `rsDate`        TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`recentseenNum`),
    KEY             `recentseen_FK` (`memberId`) USING BTREE,
    KEY             `recentseen_FK_2` (`moimNum`) USING BTREE
);


-- bigmoimspring.schedulejoin definition

CREATE TABLE `schedulejoin`
(
    `sjNum`    int NOT NULL AUTO_INCREMENT,
    `msNum`    int NOT NULL,
    `memberId` varchar(50) DEFAULT NULL,
    `moimNum`  int         DEFAULT NULL,
    PRIMARY KEY (`sjNum`),
    KEY        `schedulejoin_FK` (`memberId`) USING BTREE,
    KEY        `schedulejoin_FK_1` (`msNum`) USING BTREE
);


-- bigmoimspring.notification definition

CREATE TABLE `notification`
(
    `notiNum`  int NOT NULL AUTO_INCREMENT,
    `memberId` varchar(100) DEFAULT NULL,
    `photoNum` int          DEFAULT NULL,
    `mbNum`    int          DEFAULT NULL,
    `msNum`    int          DEFAULT NULL,
    `read`     int NOT NULL DEFAULT '0',
    `ccNum`    int          DEFAULT NULL,
    PRIMARY KEY (`notiNum`),
    KEY        `notification_FK` (`ccNum`) USING BTREE,
    KEY        `notification_FK_2` (`memberId`) USING BTREE,
    KEY        `notification_FK_3` (`mbNum`) USING BTREE,
    KEY        `notification_FK_4` (`photoNum`) USING BTREE,
    KEY        `notification_FK_5` (`msNum`) USING BTREE
);