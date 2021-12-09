create table if not exists user(
	id			integer auto_increment primary key,
	email		varchar(255) not null,
	password	varchar(255) not null
);