create table reimbursement(
	id integer primary key,
	amount integer,
	submitted timestamp,
	resolved timestamp,
	description varchar2(250),
	receipt blob,
	author integer references user,
	resolver integer REFERENCES user,
	status_id integer references reimbursement_status,
	type_id integer REFERENCES reimbursement_type
)

create table user(
	id integer primary key,
	username varchar2(50),
	password varchar2(50),
	first_name varchar2(100),
	last_name varchar2(100),
	email varchar2(150),
	role_id integer REFERENCES user_roles
)

create table reimbursement_status(
	id integer primary key,
	status varchar2(10)
)

create table reimbursement_type(
	id integer primary key,
	type varchar2(10)
)

create table user_roles(
	id integer primary key,
	role varchar2(10)
)