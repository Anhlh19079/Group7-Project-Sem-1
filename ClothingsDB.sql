create database ClothingsDB;
use ClothingsDB;
-- drop database clothingsdb;
create table Users(
User_ID int auto_increment primary key not null,
User_Name varchar(255) not null,
User_Pass varchar(255) not null,
User_Role varchar(255) not null
);

create table Products(
	Pro_id int auto_increment primary key,
    Pro_name varchar(200) not null,
    Unit_price double(15,2) default 0,
    Pro_amount int not null default 0,
    Pro_status varchar(255) not null, 
    Pro_description varchar(255)
);

create table Orders(
	Order_id int auto_increment primary key,
    User_id int,
    Order_date datetime default now(),
    Order_status varchar(255),
    constraint fk_Orders_Users foreign key(User_ID) references Users(User_ID)
);

create table OrderDetails(
	Order_id int not null,
    Pro_id int not null,
    Unit_price double(15,2) not null,
    quantity int not null default 1,
    constraint pk_OrderDetails primary key(Order_id, Pro_id),
    constraint fk_OrderDetails_Orders foreign key(Order_id) references Orders(Order_id),
    constraint fk_OrderDetails_Products foreign key(Pro_id) references Products(Pro_id)
);
select User_role, User_Name
from users
where User_pass like "test1";
--
INSERT INTO `clothingsdb`.`users` (`User_Name`, `User_Pass`, `User_Role`) VALUES ('Anhlh', '1234', 'Admin');
INSERT INTO `clothingsdb`.`users` (`User_Name`, `User_Pass`, `User_Role`) VALUES ('Thongnm', '123321', 'Admin');
INSERT INTO `clothingsdb`.`users` (`User_Name`, `User_Pass`, `User_Role`) VALUES ('Test', 'test1', 'Customer');
INSERT INTO `clothingsdb`.`users` (`User_Name`, `User_Pass`, `User_Role`) VALUES ('Test2', 'test2', 'Admin');



-- 
INSERT INTO `clothingsdb`.`products` (`Pro_name`, `Unit_price`, `Pro_amount`, `Pro_status`, `Pro_description`) VALUES ('ao dai', '400000', '30', '1', 'trang,den,vang,do');
INSERT INTO `clothingsdb`.`products` (`Pro_name`, `Unit_price`, `Pro_amount`, `Pro_status`, `Pro_description`) VALUES ('ao khoac long', '1000000', '11', '1', 'dep,giu am tot');
