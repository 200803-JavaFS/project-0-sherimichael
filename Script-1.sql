
drop table if exists accounts;
drop table if exists users cascade;

--DDL

create table users (
	user_id SERIAL primary key,
	user_type INTEGER,
	first_name VARCHAR(30),
	last_name VARCHAR(41),
	email VARCHAR(50),
	pword VARCHAR(15)
);

--DML
insert into users (user_type, first_name, last_name, email, pword)
	values (1, 'Sarah', 'Williams', 'sarah@email.com', 'password'),
           (1, 'Lillian', 'Jones','lillian@email.com', 'password'),
           (1, 'John', 'Schmidt', 'john@email.com', 'password'),
           (2, 'Norman','Reppen', 'norman@email.com', 'password'),
           (2, 'Margo', 'Schoen','margo@email.com','password'),
           (3, 'Barbara', 'Celis', 'barb@email.com', 'password'),
           (3, 'Laura', 'Jones','laura@email.com', 'password'),
           (4, 'Jasen', 'Schrock', 'jasen@email.com', 'password');
           (4, 'Clare', 'Portinga','clare@email.com','password'),
           (4, 'Barbara', 'Kriete', 'barbara@email.com', 'password'),
           (4, 'Jill', 'Hartman', 'jill@email.com', 'password'),
           (4, 'Brad', 'Nadig', 'brad@email.com', 'password');
          
--DQL
select * from users;


--DDL
create table accounts (
	acnt_id SERIAL primary key,
	acnt_type INTEGER,
	balance numeric(8,2),
	acnt_status INTEGER,
	user_id_fk  INTEGER references users(user_id)
);

alter table accounts 
add constraint user_id_fk 
foreign Key(user_id) 
references users(user_id);
			
--DML

insert into accounts (acnt_type, balance, acnt_status, user_id_fk)
	values (1, 25716.25, 1,1),
	       (2, 11222.13, 1,2),
	       (1, 2569, 2,3),
           (3, 0,3,4),
           (3, 0, 3,5),
           (3, 0,3,6),
           (3, 0, 3,7),
           (4, 2569, 2,8);
	       
--DQL

select * from accounts;


--*****************************************
	       
