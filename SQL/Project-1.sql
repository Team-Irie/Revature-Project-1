create table users (
	id serial not null,
	username varchar(50) unique,
	"password" varchar(50),
	first_name varchar(100),
	last_name varchar(100),
	email varchar(150) unique,
	role_id int
);

create table user_roles (
	id int not null,
	user_role varchar(10)
);

create table reimbursement_type (
	id int not null,
	user_type varchar(10)
);

create table reimbursement_status (
	id int not null,
	status varchar(10)
);

create table reimbursement (
	id serial not null,
	amount int,
	submitted timestamp,
	resolved timestamp,
	description varchar(250),
	receipt bytea,
	author int,
	resolver int,
	status_id int,
	type_id int
);