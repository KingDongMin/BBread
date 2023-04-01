create table admin(
id varchar2(20) primary key,
pass varchar2(20),
name varchar2(20),
phone varchar2(20)
);

create table member(
id varchar2(20) primary key,
pass varchar2(20),
name varchar2(20),
email varchar2(40),
address varchar2(100),
phone varchar2(20),
useyn char(1) default 'y',
indate date default sysdate
);


create table product(
pseq number(10) primary key,
name varchar2(40),
kind varchar2(20),
price number(10) default 0,
content varchar2(1000),
image varchar2(50),
useyn char(1) default 'y',
bestyn char(1) default 'n',
indate date default sysdate
);

create table cart(
bseq number(10) primary key,
mid varchar2(20) references member(id),
pseq number(10) references product(pseq),
quantity number(5) default 1,
result char(1) default 'n',
indate date default sysdate
);

create table orders(
oseq number(10) primary key,
mid varchar2(20) references member(id),
indate date default sysdate
);

create table order_detail(
odseq number(10) primary key,
oseq number(10) references orders(oseq),
pseq number(10) references product(pseq),
quantity number(5) default 1,
result char(1) default 'n'
);

create table qna(
qseq number(10) primary key,
title varchar2(30),
inquiry varchar2(1000),
answer varchar2(1000),
mid varchar2(20),
result char(1) default 'n',
indate date default sysdate
);

commit;

select * from tabs; -- 해당 계정에서 생성한 테이블 목록을 조회함

desc member; -- 테이블 컬럼 구조 아는 명령어 : desc