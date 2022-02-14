create table users (
	id serial not null,
	username varchar(50),
	"password" varchar(50),
	first_name varchar(100),
	last_name varchar(100),
	email varchar(150),
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

select * from reimbursement;

insert into reimbursement (amount, submitted, resolved, description, receipt, author, resolver, status_id, type_id) values (200,'2017-03-31 9:30:20','2017-03-31 9:30:20','Money','',0,0,0,0);