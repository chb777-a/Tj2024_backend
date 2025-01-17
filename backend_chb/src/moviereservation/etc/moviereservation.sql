drop database if exists moviereservation;                
create database moviereservation;           
use moviereservation;     
  
create table admin(
        adminId int unsigned auto_increment , 
    aid varchar(20) not null unique ,
    apw varchar(20) not null ,
    aname varchar(20) not null ,
    constraint primary key( adminId )
); 
# [1] 회원테이블 샘플 레코드 삽입
insert into admin ( aid, apw ,aname) values( 'admin1' , '1234' , '최홍빈' );
insert into admin ( aid, apw ,aname) values( 'admin2' , '2345' , '이민수' );
insert into admin ( aid, apw ,aname) values( 'admin3' , '3456' , '장민우' );
insert into admin ( aid, apw ,aname) values( 'admin4' , '4567' , '류예나' );

create table member(
        memberId int unsigned auto_increment , 
    mid varchar(20) not null unique ,
    mpw varchar(20) not null ,
    mname varchar(20) not null ,
    mbirth varchar(10),
    constraint primary key( memberId )
); 
# [1] 회원테이블 샘플 레코드 삽입
insert into member ( mid, mpw ,mname, mbirth) values( 'guest1' , '1234' , '최홍빈' , '1994-01-09' );
insert into member ( mid, mpw ,mname, mbirth) values( 'guest2' , '2345' , '이민수' , '1999-10-09');
insert into member ( mid, mpw ,mname, mbirth) values( 'guest3' , '3456' , '장민우' , '2000-08-17' );
insert into member ( mid, mpw ,mname, mbirth) values( 'guest4' , '4567' , '류예나' , '2001-03-05' );



    create table categorie(
        genreId int unsigned auto_increment,
    genreName char(10) not null,
     constraint primary key( genreId )
    );
    
insert into categorie (genreName ) values( '액션' );
insert into categorie (genreName ) values( '판타지' );
insert into categorie (genreName ) values( '로맨스' );
insert into categorie (genreName ) values( '드라마' );
insert into categorie (genreName ) values( '미스터리' );

create table movie(
        movieId int unsigned auto_increment , 
    movieName varchar(30) not null,
    runTime tinyint unsigned not null,
    movieGrade varchar(10) not null,
    genreId int unsigned not null,
    constraint foreign key(genreId) references categorie(genreId),
    constraint primary key( movieId )
); 

insert into movie (movieName,runTime,movieGrade,genreId) values( '아바타',166,'15세',2);
insert into movie (movieName,runTime,movieGrade,genreId) values( '기생충',131,'15세',1);
insert into movie (movieName,runTime,movieGrade,genreId) values( '하얼빈',115,'15세',4);
insert into movie (movieName,runTime,movieGrade,genreId) values( '인턴',121,'12세',4);
insert into movie (movieName,runTime,movieGrade,genreId) values( '파묘',134,'15세',5);
insert into movie (movieName,runTime,movieGrade,genreId) values( '소방관',106,'12세',4);

select * from movie;


create table theater(
theaterId tinyint unsigned,
seat tinyint unsigned not null,
screen varchar(20) not null,
constraint primary key (theaterId)
);

insert into theater (theaterId,seat,screen) values( 1,135,'2D');
insert into theater (theaterId,seat,screen) values( 2,100,'2D');
insert into theater (theaterId,seat,screen) values( 3,100,'2D');
insert into theater (theaterId,seat,screen) values( 4,100,'IMAX');

create table movieReview(
reviewId int unsigned auto_increment,
reviewTitle varchar(20) not null,
reviewContent varchar(100) not null,
reviewRating int not null,
reviewDate varchar(20) not null,
memberId int unsigned,
movieId int unsigned,
constraint foreign key(memberId) references member(memberId),
constraint foreign key(movieId) references movie(movieId),
constraint primary key (reviewId)
);
insert into movieReview(reviewTitle, reviewContent, reviewRating,reviewDate,memberId,movieId) values('정말 재밌어요!', '배우들 연기도 좋고 스토리가 탄탄해서 정말 재미있었어요', 5,'2025-01-01',4,1);
insert into movieReview(reviewTitle, reviewContent, reviewRating,reviewDate,memberId,movieId) values('가족들끼리 보기 좋은 영화', '감동이 있어서 가족들끼리 보기 좋은 영화같네요', 3,'2025-01-07',2,1);
insert into movieReview(reviewTitle, reviewContent, reviewRating,reviewDate,memberId,movieId) values('좋아하는 감독이라 챙겨봤습니다', '좋아하는 감독인만큼 재밌게 본 거 같네요', 5,'2025-01-07',1,2);
insert into movieReview(reviewTitle, reviewContent, reviewRating,reviewDate,memberId,movieId) values('해외에서 극찬한 영화', '우리나라 감성에 맞는지는 모르겠지만 해외에서 반응이 좋은 이유를 알겠네요', 3,'2025-01-07',3,3);
insert into movieReview(reviewTitle, reviewContent, reviewRating,reviewDate,memberId,movieId) values('2025년 첫 영화 관람', '2025년 된 기념으로 제일 땡기는 영화 봤는데 나름 재미있고 의미있었어요', 5,'2025-01-07',3,1);

select * from movieReview;

create table timeTable(
    timepk int unsigned auto_increment,
	startTime varchar(10),
    finishTime varchar(10),
    movieDate varchar(10),
    theaterId tinyint unsigned,
    movieId int unsigned,
    constraint primary key (timepk),
    constraint foreign key(theaterId) references theater(theaterId),
    constraint foreign key(movieId ) references movie(movieId)
);
insert into timeTable(startTime,finishTime,movieDate,theaterId,movieId) values('12:00','14:46','2025-01-07',4,1);
insert into timeTable(startTime,finishTime,movieDate,theaterId,movieId) values('14:20','16:31','2025-01-05',2,2);
insert into timeTable(startTime,finishTime,movieDate,theaterId,movieId) values('18:40','20:35','2025-01-03',3,3);
insert into timeTable(startTime,finishTime,movieDate,theaterId,movieId) values('19:30','21:31','2025-01-03',2,4);
insert into timeTable(startTime,finishTime,movieDate,theaterId,movieId) values('20:00','14:46','2025-01-07',1,5);
insert into timeTable(startTime,finishTime,movieDate,theaterId,movieId) values('21:10','22:14','2025-01-07',4,1);


create table resv(
resvId int unsigned auto_increment,
resvDate varchar(10),
memberId int unsigned,
timepk int unsigned not null,
constraint primary key (resvId),
constraint foreign key(memberId ) references member(memberId),
constraint foreign key(timepk) references timeTable(timepk)
);
insert into resv(resvDate,memberId,timepk) values('2025-01-02',3,1);
insert into resv(resvDate,memberId,timepk) values('2025-01-02',1,2);
insert into resv(resvDate,memberId,timepk) values('2025-01-02',2,3);
insert into resv(resvDate,memberId,timepk) values('2025-01-01',4,6);
select * from resv;
create table resvSeat(
resvId2 int unsigned auto_increment,
seatNum smallint not null,
resvId int unsigned,
constraint primary key (resvId2),
constraint foreign key(resvId) references resv(resvId)
);

insert into resvSeat(seatNum,resvId) values(30,1);
insert into resvSeat(seatNum,resvId) values(31,1);
insert into resvSeat(seatNum,resvId) values(12,3);
insert into resvSeat(seatNum,resvId) values(33,4);



