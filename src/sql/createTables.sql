
create PROCEDURE createTables ()
BEGIN 
create table user (
	id int primary key auto_increment,
	name varchar(40), 
	age int(2), 
	address varchar(40)
);

create table product (
	id int primary key auto_increment,
	name varchar(40), 
	category_id int,
    FOREIGN KEY (category_id) references category(id) 
);


create table category (
	id int primary key auto_increment,
	name varchar(40)
);


create table sales (
	id int primary key auto_increment,
	product_id int, 
    user_id int,
    sold_at datetime  DEFAULT CURRENT_TIMESTAMP,
    foreign key (product_id) references product(id), 
    foreign key (user_id) references user(id)
);
END