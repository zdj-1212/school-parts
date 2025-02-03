## 一个简单的‘校园兼职平台’
**前端的登录页面（HTML）使用的是GitHub中一个开源项目，剩余前端页面使用的是远古技术（JSP）,应用程序服务器使用的是tomcat；详细内容请查看源码**
**数据库名：schoolpart**
创建表：create table partcomment
(
    id      int(255) not null
        primary key,
    bid     int(255) null,
    comment text     null
)
;

create table parts
(
    id       int(255)     not null
        primary key,
    partname varchar(255) null,
    message  text         null
)
;

create table user
(
    sno      varchar(255) not null
        primary key,
    name     varchar(255) null,
    partid   int(255)     not null,
    password varchar(255) null,
    flag     int(1)       not null
)
;

create table usertem
(
    sno      varchar(255) not null
        primary key,
    name     varchar(255) null,
    partid   int(255)     null,
    password varchar(255) null,
    flag     int(1)       not null
)
;

