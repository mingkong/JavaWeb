/*---------------------------- */
/*--- 2013-04-20               */
/*-----------------------------*/
CREATE DATABASE MAS_TEST DEFAULT CHARACTER SET utf8;
GRANT ALL PRIVILEGES ON MAS_TEST.* TO 'test'@'localhost' IDENTIFIED BY 'test' WITH GRANT OPTION;
GRANT ALL PRIVILEGES ON MAS_TEST.* TO 'test'@'%' IDENTIFIED BY 'test' WITH GRANT OPTION;
use MAS_TEST;

/*==============================================================*/
/* Table: KDB_AUTH                                              */
/*==============================================================*/
create table KDB_AUTH
(
   UUID_                varchar(50) not null,
   NAME_                varchar(50) not null,
   REMARK_              varchar(500),
   DFLAG                char(1),
   UPDATE_TIME          varchar(20),
   AUTH_DEF             text,
   primary key (UUID_)
);

/*==============================================================*/
/* Table: KDB_DEPT                                              */
/*==============================================================*/
create table KDB_DEPT
(
   UUID_                varchar(50) not null,
   NAME_                varchar(50) not null,
   OWN_DEPT             varchar(50),
   SORT_NUM             int,
   TYPE_                char(2),
   CREATE_DATE          varchar(10),
   UPDATE_TIME          varchar(20),
   REMARK_              varchar(500),
   DFLAG_               char(1),
   primary key (UUID_)
);

/*==============================================================*/
/* Table: KDB_D_ROLE                                            */
/*==============================================================*/
create table KDB_D_ROLE
(
   DEPT_KEY             varchar(50) not null,
   ROLE_KEY             varchar(50) not null,
   primary key (ROLE_KEY, DEPT_KEY)
);

/*==============================================================*/
/* Table: KDB_LINK                                              */
/*==============================================================*/
create table KDB_LINK
(
   UUID_                varchar(50) not null,
   NAME_                varchar(50) not null,
   TYPE_                char(1),
   URL_                 varchar(200),
   primary key (UUID_)
);

/*==============================================================*/
/* Table: KDB_ROLE                                              */
/*==============================================================*/
create table KDB_ROLE
(
   UUID_                varchar(50) not null,
   NAME_                varchar(50) not null,
   REMARK_              varchar(500),
   DFLAG                char(1),
   UPDATE_TIME          varchar(20),
   AUTHS_               text,
   primary key (UUID_)
);

/*==============================================================*/
/* Table: KDB_USER                                              */
/*==============================================================*/
create table KDB_USER
(
   UUID_                varchar(50) not null,
   NAME_                varchar(50) not null,
   PASSWORD_            varchar(50),
   OWN_DEPT             varchar(50),
   PHONE_               varchar(20),
   MAIN_QQ              varchar(20),
   TYPE_                char(2),
   SEX_                 char(1),
   IDCARD_              varchar(20),
   BIRTH_DATE           varchar(10),
   UPDATE_TIME          varchar(20),
   STATUS_              char(1),
   DFLAG_               char(1),
   primary key (UUID_)
);

/*==============================================================*/
/* Table: KDB_U_ROLE                                            */
/*==============================================================*/
create table KDB_U_ROLE
(
   USER_KEY             varchar(50) not null,
   ROLE_KEY             varchar(50) not null,
   primary key (USER_KEY, ROLE_KEY)
);
