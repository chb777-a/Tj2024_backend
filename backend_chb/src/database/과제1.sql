# 과제1
create database mk1; #[1] DB 생성
use mk1; #[2] DB 사용 활성화

#주의할 점은 테이블 생성시 상위PK 테이블 먼저 생성

#회원 테이블
create table member(
mno int auto_increment , # 회원 번호
id varchar(20) , # 회원 아이디 20글자
pw varchar(20) , # 회원 비밀번호 20글자
constraint primary key(mno) ,
name varchar(10) not null , # 회원 이름 10글자
email varchar(40) # 회원 이메일 40글자
);

# 카테고리 테이블
create table category(
cno int auto_increment , # 카테고리 상품 번호
cateName varchar(10) not null , # 카테고리 이름
constraint primary key(cno)
);

# 제품 테이블
create table product(
pno int auto_increment , # 제품 번호
productName varchar(50) not null , #제품명
price smallint unsigned default 0 , #제품가격
constraint primary key(pno) ,
cno int ,
constraint foreign key(cno) references category(cno)
);

# 주문 테이블
create table porder(
	pono int auto_increment , # 주문번호
    podate datetime default now() , # 주문 날짜 , 현재 시스템 날짜 설정
    constraint primary key(pono) ,
    mno int ,
    constraint foreign key(mno) references member(mno)
);

# 주문상세 테이블
create table porderdetail(
	odno int auto_increment , # 주문상세
    orderCount int unsigned not null , # 주문수량
    totalPrice int unsigned not null , # 총주문금액
    constraint primary key(odno) , # 주문상세 pk 설정
    pno int , # 제품번호 fk 필드
    constraint foreign key(pno) references product(pno) ,
    ono int , #주문번호fk 필드
    constraint foreign key(ono) references porder(pono)
);

# 테이블 간의 관계를 시각적으로 표현 : ERD 다이어그램
# 워크밴치에서 테이블 ERD 다이어그램 만든느 방법 : 상단의 Database => Reverse Engineer => next => DB선택 => next , next
show databases;