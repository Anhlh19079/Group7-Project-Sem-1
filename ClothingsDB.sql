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

create table Products(
	pro_id int auto_increment primary key not null,
    pro_name varchar(200) not null,
    unit_price double(15,2) default 0,
    pro_amount int not null default 0,
    pro_description varchar(255),
    pro_status varchar(255) not null
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
INSERT INTO `clothingsdb`.`products` (`Pro_name`, `Unit_price`, `Pro_amount`, `Pro_status`, `Pro_description`) VALUES ('ao dai', '400000', '30', '1', 'trang,den,vang,do');
INSERT INTO `clothingsdb`.`products` (`Pro_name`, `Unit_price`, `Pro_amount`, `Pro_status`, `Pro_description`) VALUES ('ao khoac long', '1000000', '11', '1', 'dep,giu am tot');
INSERT INTO `clothingsdb`.`products` (`Pro_name`, `Unit_price`, `Pro_amount`, `Pro_status`, `Pro_description`) VALUES ('Quan Jeans', '250000', '100', '1', 'unisex,olor dark(blue,black)');
INSERT INTO `clothingsdb`.`products` (`Pro_name`, `Unit_price`, `Pro_amount`, `Pro_status`, `Pro_description`) VALUES ('T-Shirt', '100000', '50', '1', 'nam ,nu,type:all');
INSERT INTO `clothingsdb`.`products` (`Pro_name`, `Unit_price`, `Pro_amount`, `Pro_status`, `Pro_description`) VALUES ('Ao phong', '80000', '40', '1', 'tay dai ,ngan,5 mau ');
INSERT INTO `clothingsdb`.`products` (`Pro_name`, `Unit_price`, `Pro_amount`, `Pro_status`, `Pro_description`) VALUES ('quan den', '200000', '10', '1', '...');

select u.user_id , u.user_name, o.order_id,o.order_date
from users as u inner join orders as o on u.user_id=o.user_id;
select * from orders where user_id like '1';
select user_id from users where user_name like 'Anhlh' and user_pass like '1234';
drop procedure showorder;

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

select od.Order_id,u.User_ID ,p.Pro_id, o.Order_totalPrice , od.Quantity 
from users as u inner join orders as o on u.User_ID=o.User_ID inner join 
orderdetails as od on o.Order_id = od.Order_id inner join 
products as p on od.Pro_id = p.Pro_id
where u.User_ID = 3;
