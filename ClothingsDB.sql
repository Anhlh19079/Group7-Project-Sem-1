-- drop database clothingsdb;
create database ClothingsDB;
use ClothingsDB;

create table Users(
user_id int auto_increment primary key not null,
user_name varchar(255) not null,
user_pass varchar(255) not null,
user_phone varchar(255) not null unique,
user_email varchar(255) not null unique,
user_role varchar(255) not null,
user_status varchar(100) not null
);

create table Categories(
cat_id int auto_increment primary key not null,
cat_name varchar(255)
); 
create table Products(
	pro_id int auto_increment primary key not null,
    cat_id int,
    pro_name varchar(200) not null,
    pro_pack varchar(255),
    unit_price double(15,2) default 0,
    pro_amount int not null default 0,
    pro_description varchar(255),
    pro_status varchar(255) not null,
    constraint fk_Products_Categories foreign key(cat_id) references Categories(cat_id)

);

create table Colors(
col_id int auto_increment primary key not null,
col_name varchar(255)
);
create table Product_colors(
pro_id int,
col_id int,
constraint pk_Product_colors primary key(pro_id,col_id),
constraint fk_Product_colors_Colors foreign key(col_id) references Colors(col_id),
constraint fk_Product_colors_Products foreign key(pro_id) references Products(pro_id)
);

create table Sizes(
size_id int auto_increment primary key not null,
size_name varchar(255)
);
create table Product_sizes(
pro_id int,
size_id int ,
constraint pk_Product_sizes primary key(pro_id,size_id),
constraint fk_Product_sizes_Sizes foreign key(size_id) references Sizes(size_id),
constraint fk_Product_sizes_Products foreign key(pro_id) references Products(pro_id)
);

create table Images(
ima_id int auto_increment primary key not null,
ima_url varchar(255)
);
create table Product_images(
pro_id int,
ima_id int,
constraint pk_Product_images primary key(pro_id,ima_id),
constraint fk_Product_images_Images foreign key(ima_id) references Images(ima_id),
constraint fk_Product_images_Products foreign key(pro_id) references Products(pro_id)
);
create table Orders(
	order_id int auto_increment primary key not null,
    user_id int ,
    order_date varchar(255) ,
    order_totalPrice double(15,2),
    order_status varchar(255),
    constraint fk_Orders_Users foreign key(user_id) references Users(user_id)
);

create table OrderDetails(
	order_id int ,
    pro_id int ,
    unit_price double(15,2) not null,
    quantity int not null default 1,
    
    constraint pk_OrderDetails primary key(order_id, pro_id),
    constraint fk_OrderDetails_Orders foreign key(order_id) references Orders(order_id),
    constraint fk_OrderDetails_Products foreign key(pro_id) references Products(pro_id)
);
select User_role, User_Name
from users
where User_pass like "test1";
INSERT INTO `clothingsdb`.`categories` (`cat_name`) VALUES ('Clothings');
INSERT INTO `clothingsdb`.`categories` (`cat_name`) VALUES ('Shoes');
INSERT INTO `clothingsdb`.`categories` (`cat_name`) VALUES ('Hats');


--

INSERT INTO `clothingsdb`.`users` (`user_name`, `user_pass`, `user_phone`, `user_email`, `user_role`,`user_status`) VALUES ('Anhlh', '1010', '0974252893', 'haianh@gmail.com', 'Admin','active');
INSERT INTO `clothingsdb`.`users` (`user_name`, `user_pass`, `user_phone`, `user_email`, `user_role`,`user_status`) VALUES ('Thongnm', '1234', '0165982370', 'thongnm@gmail.com', 'Admin','active');
INSERT INTO `clothingsdb`.`users` (`user_name`, `user_pass`, `user_phone`, `user_email`, `user_role`,`user_status`) VALUES ('tester', '1111', '0329876142', 'test@gmail.com', 'Customer','active');
INSERT INTO `clothingsdb`.`users` (`user_name`, `user_pass`, `user_phone`, `user_email`, `user_role`,`user_status`) VALUES ('root', 'root4', '0123239854', 'root@gmail.com', 'Customer','active');
INSERT INTO `clothingsdb`.`users` (`user_name`, `user_pass`, `user_phone`, `user_email`, `user_role`,`user_status`) VALUES ('root1', 'root1', '0943527412', 'root1@gmail.com', 'Customer','inactive');


--
--

select * from Products where Pro_name like  '%Ao%';

-- 


DELIMITER $$
CREATE PROCEDURE showorder()
BEGIN
   select o.Order_id,o.User_ID,o.Order_date,p.Pro_Name,od.Quantity,o.Order_status 
   from orders as o inner join orderdetails as od on o.Order_id=od.Order_id 
   inner join products as p on od.Pro_id=p.Pro_id;
END; $$
DELIMITER ;
call showorder;
select * from orders where orders.User_id='3';
--
DELIMITER $$
CREATE PROCEDURE showorderbid(IN orderid int)
BEGIN
   select u.user_name,u.user_phone,u.user_email,p.pro_name,p.unit_price,od.quantity,(p.unit_price*od.quantity)total, o.order_totalPrice
   from users as u inner join orders as o on u.user_id=o.user_id 
   inner join orderdetails as od on o.order_id=od.order_id 
   inner join products as p on od.pro_id=p.pro_id
   where o.order_id = orderid and od.order_id=orderid;
END; $$
DELIMITER ;
drop procedure showorderbid;
call showorderbid(2);
--
select od.Order_id,u.User_ID ,p.Pro_id, o.Order_totalPrice , od.Quantity 
from users as u inner join orders as o on u.User_ID=o.User_ID inner join 
orderdetails as od on o.Order_id = od.Order_id inner join 
products as p on od.Pro_id = p.Pro_id
where u.User_ID = 3;
select u.user_name,u.user_phone,u.user_email,o.order_status
from users u inner join orders o on u.user_id=o.user_id
where o.order_id=1 
limit 1;
select order_id 
from orders o inner join users u on o.user_id=u.user_id
where u.user_id = 3; 
