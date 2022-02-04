create table reimbursement(
	id integer primary key,
	amount integer,
	submitted timestamp,
	resolved timestamp,
	description varchar(250),
	receipt blob,
	author integer,
	resolver integer,
	status_id integer,
	type_id integer
)

create table users(
	id integer primary key,
	username varchar(50),
	password varchar(50),
	first_name varchar(100),
	last_name varchar(100),
	email varchar(150),
	role_id integer
)

create table reimbursement_status(
	id integer primary key,
	status varchar(10)
)

create table reimbursement_type(
	id integer primary key,
	type varchar(10)
)

create table user_roles(
	id integer primary key,
	role varchar(10)
)