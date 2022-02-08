create table reimbursement(
	id integer primary key,
	amount integer,
	submitted timestamp,
	resolved timestamp,
	description varchar(250),
	receipt bytea,
	author integer references users(id),
	resolver integer references users(id),
	status_id integer references reimbursement_status(id),
	type_id integer references reimbursement_type(id)
)

create table users(
	id integer primary key,
	username varchar(50) unique,
	password varchar(50),
	first_name varchar(100),
	last_name varchar(100),
	email varchar(150) unique,
	role_id integer references user_roles(id)
)

create table reimbursement_status(
	id integer primary key,
	status varchar(10)
)

create table reimbursement_type(
	id integer primary key,
	user_type varchar(10)
)

create table user_roles(
	id integer primary key,
	user_role varchar(10)
)