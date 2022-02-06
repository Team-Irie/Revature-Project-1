create table reimbursement(
	id integer primary key,
	amount integer,
	submitted timestamp,
	resolved timestamp,
	description varchar(250),
	receipt bytea,
	author integer references users,
	resolver integer references users,
	status_id smallint references reimbursement_status,
	type_id smallint references reimbursement_type
)

create table users(
	id integer primary key,
	username varchar(50) unique,
	password varchar(50),
	first_name varchar(100),
	last_name varchar(100),
	email varchar(150) unique,
	role_id smallint references user_roles
)

create table reimbursement_status(
	id smallint primary key,
	status varchar(10)
)

create table reimbursement_type(
	id smallint primary key,
	user_type varchar(10)
)

create table user_roles(
	id smallint primary key,
	user_role varchar(10)
)

drop table user_roles;
drop table reimbursement_type;
drop table reimbursement_status;
drop table reimbursement;
drop table users;