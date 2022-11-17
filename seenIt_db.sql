/*drop database postgresleotest;*/
/*drop user seenIt;*/

/*create user seenIt with password 'password';*/
/*create database postgresleotest with template=template0
 * owner=seenitpostgres;*/
\connect postgresleotest;

ALTER TABLE IF EXISTS et_categories DROP CONSTRAINT cat_users_fk;
ALTER TABLE IF EXISTS et_transactions DROP CONSTRAINT trans_cat_fk;
ALTER TABLE IF EXISTS et_transactions DROP CONSTRAINT trans_users_fk;

DROP TABLE IF EXISTS et_users, et_categories, et_transactions;
DROP SEQUENCE IF EXISTS et_users_seq;
DROP SEQUENCE IF EXISTS et_transactions_seq;
DROP SEQUENCE IF EXISTS et_categories_seq;

alter default privileges grant all on tables to seenitpostgres;
alter default privileges grant all on sequences to seenitpostgres;

create table et_users(
user_id integer primary key not null,
first_name varchar(20) not null,
last_name varchar(20) not null,
email varchar(30) not null,
password text not null
);

create table et_categories(
category_id integer primary key not null,
user_id integer not null,
title varchar(20) not null,
description varchar(50) not null,
seconddescription varchar(100)
);

alter table et_categories add constraint cat_users_fk
foreign key (user_id) references et_users(user_id);

create table et_transactions(
transaction_id integer primary key not null,
category_id integer not null,
user_id integer not null,
amount numeric(10,2) not null,
note varchar(50) not null,
transaction_date timestamp not null
);

alter table et_transactions add constraint trans_cat_fk
foreign key (category_id) references et_categories(category_id);
alter table et_transactions add constraint trans_users_fk
foreign key (user_id) references et_users(user_id);

create sequence et_users_seq increment 1 start 1;
create sequence et_categories_seq increment 1 start 1;
create sequence et_transactions_seq increment 1 start 1000;