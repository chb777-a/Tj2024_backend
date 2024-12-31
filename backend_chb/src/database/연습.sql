# 과제1
create database kiosk; #[1] DB 생성
use kiosk; #[2] DB 사용 활성화

#주의할 점은 테이블 생성시 상위PK 테이블 먼저 생성

#[3] 카테고리 테이블
create table category(
con int auto_increment , # 카테고리 번호
cname varchar(30) not null , #카테고리 명
constraint primary key(cno) #pk 필드 선정
);

#[4] 제품 테이블
create table product(
pno int auto_increment , #제품번호
pname varchar(100) not null , #제품명
pprice int unsigned default 0 , #제품가격
constraint primary key(pno) , #pk필드 설정
cno int ,#fk필드 선언(pk필드와 동일한 타입 권장)
constraint foreign key(cno) references category(cno) # fk필드 설정
);

#[5] 주문 테이블
create table porder(
	pono int auto_increment , # 주문번호
    podate datetime default now() , # 주문 날짜 , 현재 시스템 날짜 설정
    constraint primary key(pono) # pk필드 설정
);

#[6] 주문상세 테이블
create table porderdetail(
	podno int auto_increment , # 주문상세
    podamount tinyint unsigned not null , # 주문수량
    constraint primary key(podno) , # 주문상세 pk 설정
    pno int , # 제품번호 fk 필드
    constraint foreign key(pno) references product(pno) ,
    pono int , #주문번호fk 필드
    constraint foreign key(pono) references porder(pono)
);

# 테이블 간의 관계를 시각적으로 표현 : ERD 다이어그램
# 워크밴치에서 테이블 ERD 다이어그램 만든느 방법 : 상단의 Database => Reverse Engineer => next => DB선택 => next , next