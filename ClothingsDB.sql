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
INSERT INTO `clothingsdb`.`products` (`pro_id`, `cat_id`, `pro_name`, `pro_pack`, `unit_price`, `pro_amount`, `pro_description`, `pro_status`) VALUES ('1', '1', 'Coat', 'single', '200000', '97', 'Hermes,LV,GUCCI...', 'con hang');
INSERT INTO `clothingsdb`.`products` (`pro_id`, `cat_id`, `pro_name`, `pro_pack`, `unit_price`, `pro_amount`, `pro_description`, `pro_status`) VALUES ('2', '1', 'T-Shirt', 'single', '150000', '98', 'T-shirt kieu dang moi...', 'con hang');
INSERT INTO `clothingsdb`.`products` (`pro_id`, `cat_id`, `pro_name`, `pro_pack`, `unit_price`, `pro_amount`, `pro_description`, `pro_status`) VALUES ('3', '3', 'Mu Gucci Original GG Canvas', 'single', '200000', '86', 'chat lieu vai Canvas,in hinh GG...', 'con hang');
INSERT INTO `clothingsdb`.`products` (`pro_id`, `cat_id`, `pro_name`, `pro_pack`, `unit_price`, `pro_amount`, `pro_description`, `pro_status`) VALUES ('4', '2', 'Giay Vans old skool', 'double', '189000', '97', 'vai cao cap,de cao su...', 'con hang');
INSERT INTO `clothingsdb`.`products` (`pro_id`, `cat_id`, `pro_name`, `pro_pack`, `unit_price`, `pro_amount`, `pro_description`, `pro_status`) VALUES ('5', '2', 'GIAY DOMBA NAM HIGH POIN', 'double', '980000', '49', 'kieu dang basi,co dien ,lich lam...', 'con hang');
INSERT INTO `clothingsdb`.`products` (`pro_id`, `cat_id`, `pro_name`, `pro_pack`, `unit_price`, `pro_amount`, `pro_description`, `pro_status`) VALUES ('6', '2', 'Ao khoac kaki jean nam', 'single', '156000', '100', 'Thiet ke noi bat ,phong cach...', 'con hang');
INSERT INTO `clothingsdb`.`products` (`pro_id`, `cat_id`, `pro_name`, `pro_pack`, `unit_price`, `pro_amount`, `pro_description`, `pro_status`) VALUES ('7', '1', 'Ao Phong', 'single', '190000', '97', 'vai cotton , thoang mat...', 'con hang');

--
INSERT INTO `clothingsdb`.`sizes` (`size_id`, `size_name`) VALUES ('1', 'm');
INSERT INTO `clothingsdb`.`sizes` (`size_id`, `size_name`) VALUES ('2', 'l');
INSERT INTO `clothingsdb`.`sizes` (`size_id`, `size_name`) VALUES ('3', 'xl');
INSERT INTO `clothingsdb`.`sizes` (`size_id`, `size_name`) VALUES ('4', 'm');
INSERT INTO `clothingsdb`.`sizes` (`size_id`, `size_name`) VALUES ('5', 'l');
INSERT INTO `clothingsdb`.`sizes` (`size_id`, `size_name`) VALUES ('6', 'xl');
INSERT INTO `clothingsdb`.`sizes` (`size_id`, `size_name`) VALUES ('7', 'l');
INSERT INTO `clothingsdb`.`sizes` (`size_id`, `size_name`) VALUES ('8', 'xl');
INSERT INTO `clothingsdb`.`sizes` (`size_id`, `size_name`) VALUES ('9', '36');
INSERT INTO `clothingsdb`.`sizes` (`size_id`, `size_name`) VALUES ('10', '37');
INSERT INTO `clothingsdb`.`sizes` (`size_id`, `size_name`) VALUES ('11', '38');
INSERT INTO `clothingsdb`.`sizes` (`size_id`, `size_name`) VALUES ('12', '39');
INSERT INTO `clothingsdb`.`sizes` (`size_id`, `size_name`) VALUES ('13', '40');
INSERT INTO `clothingsdb`.`sizes` (`size_id`, `size_name`) VALUES ('14', '42');
INSERT INTO `clothingsdb`.`sizes` (`size_id`, `size_name`) VALUES ('15', '38');
INSERT INTO `clothingsdb`.`sizes` (`size_id`, `size_name`) VALUES ('16', '39');
INSERT INTO `clothingsdb`.`sizes` (`size_id`, `size_name`) VALUES ('17', '40');
INSERT INTO `clothingsdb`.`sizes` (`size_id`, `size_name`) VALUES ('18', '41');
INSERT INTO `clothingsdb`.`sizes` (`size_id`, `size_name`) VALUES ('19', '42');
INSERT INTO `clothingsdb`.`sizes` (`size_id`, `size_name`) VALUES ('20', 'l');
INSERT INTO `clothingsdb`.`sizes` (`size_id`, `size_name`) VALUES ('21', 'm');
INSERT INTO `clothingsdb`.`sizes` (`size_id`, `size_name`) VALUES ('22', 'xl');
INSERT INTO `clothingsdb`.`sizes` (`size_id`, `size_name`) VALUES ('23', 'm');
INSERT INTO `clothingsdb`.`sizes` (`size_id`, `size_name`) VALUES ('24', 'l');
--
INSERT INTO `clothingsdb`.`product_sizes` (`pro_id`, `size_id`) VALUES ('1', '1');
INSERT INTO `clothingsdb`.`product_sizes` (`pro_id`, `size_id`) VALUES ('1', '2');
INSERT INTO `clothingsdb`.`product_sizes` (`pro_id`, `size_id`) VALUES ('1', '3');
INSERT INTO `clothingsdb`.`product_sizes` (`pro_id`, `size_id`) VALUES ('2', '4');
INSERT INTO `clothingsdb`.`product_sizes` (`pro_id`, `size_id`) VALUES ('2', '5');
INSERT INTO `clothingsdb`.`product_sizes` (`pro_id`, `size_id`) VALUES ('2', '6');
INSERT INTO `clothingsdb`.`product_sizes` (`pro_id`, `size_id`) VALUES ('3', '7');
INSERT INTO `clothingsdb`.`product_sizes` (`pro_id`, `size_id`) VALUES ('3', '8');
INSERT INTO `clothingsdb`.`product_sizes` (`pro_id`, `size_id`) VALUES ('4', '9');
INSERT INTO `clothingsdb`.`product_sizes` (`pro_id`, `size_id`) VALUES ('4', '10');
INSERT INTO `clothingsdb`.`product_sizes` (`pro_id`, `size_id`) VALUES ('4', '11');
INSERT INTO `clothingsdb`.`product_sizes` (`pro_id`, `size_id`) VALUES ('4', '12');
INSERT INTO `clothingsdb`.`product_sizes` (`pro_id`, `size_id`) VALUES ('4', '13');
INSERT INTO `clothingsdb`.`product_sizes` (`pro_id`, `size_id`) VALUES ('4', '14');
INSERT INTO `clothingsdb`.`product_sizes` (`pro_id`, `size_id`) VALUES ('5', '15');
INSERT INTO `clothingsdb`.`product_sizes` (`pro_id`, `size_id`) VALUES ('5', '16');
INSERT INTO `clothingsdb`.`product_sizes` (`pro_id`, `size_id`) VALUES ('5', '17');
INSERT INTO `clothingsdb`.`product_sizes` (`pro_id`, `size_id`) VALUES ('5', '18');
INSERT INTO `clothingsdb`.`product_sizes` (`pro_id`, `size_id`) VALUES ('5', '19');
INSERT INTO `clothingsdb`.`product_sizes` (`pro_id`, `size_id`) VALUES ('6', '20');
INSERT INTO `clothingsdb`.`product_sizes` (`pro_id`, `size_id`) VALUES ('6', '21');
INSERT INTO `clothingsdb`.`product_sizes` (`pro_id`, `size_id`) VALUES ('6', '22');
INSERT INTO `clothingsdb`.`product_sizes` (`pro_id`, `size_id`) VALUES ('7', '23');
INSERT INTO `clothingsdb`.`product_sizes` (`pro_id`, `size_id`) VALUES ('7', '24');
--
INSERT INTO `clothingsdb`.`colors` (`col_id`, `col_name`) VALUES ('1', 'Grey');
INSERT INTO `clothingsdb`.`colors` (`col_id`, `col_name`) VALUES ('2', 'Black');
INSERT INTO `clothingsdb`.`colors` (`col_id`, `col_name`) VALUES ('3', 'white');
INSERT INTO `clothingsdb`.`colors` (`col_id`, `col_name`) VALUES ('4', 'white');
INSERT INTO `clothingsdb`.`colors` (`col_id`, `col_name`) VALUES ('5', 'grey');
INSERT INTO `clothingsdb`.`colors` (`col_id`, `col_name`) VALUES ('6', 'black');
INSERT INTO `clothingsdb`.`colors` (`col_id`, `col_name`) VALUES ('7', 'black');
INSERT INTO `clothingsdb`.`colors` (`col_id`, `col_name`) VALUES ('8', 'black');
INSERT INTO `clothingsdb`.`colors` (`col_id`, `col_name`) VALUES ('9', 'white');
INSERT INTO `clothingsdb`.`colors` (`col_id`, `col_name`) VALUES ('10', 'orange');
INSERT INTO `clothingsdb`.`colors` (`col_id`, `col_name`) VALUES ('11', 'pink');
INSERT INTO `clothingsdb`.`colors` (`col_id`, `col_name`) VALUES ('12', 'brown');
INSERT INTO `clothingsdb`.`colors` (`col_id`, `col_name`) VALUES ('13', 'yellow');
INSERT INTO `clothingsdb`.`colors` (`col_id`, `col_name`) VALUES ('14', 'green moss');
INSERT INTO `clothingsdb`.`colors` (`col_id`, `col_name`) VALUES ('15', 'black');
INSERT INTO `clothingsdb`.`colors` (`col_id`, `col_name`) VALUES ('16', 'white');

--
INSERT INTO `clothingsdb`.`product_colors` (`pro_id`, `col_id`) VALUES ('1', '1');
INSERT INTO `clothingsdb`.`product_colors` (`pro_id`, `col_id`) VALUES ('1', '2');
INSERT INTO `clothingsdb`.`product_colors` (`pro_id`, `col_id`) VALUES ('2', '3');
INSERT INTO `clothingsdb`.`product_colors` (`pro_id`, `col_id`) VALUES ('2', '4');
INSERT INTO `clothingsdb`.`product_colors` (`pro_id`, `col_id`) VALUES ('2', '5');
INSERT INTO `clothingsdb`.`product_colors` (`pro_id`, `col_id`) VALUES ('3', '6');
INSERT INTO `clothingsdb`.`product_colors` (`pro_id`, `col_id`) VALUES ('4', '7');
INSERT INTO `clothingsdb`.`product_colors` (`pro_id`, `col_id`) VALUES ('5', '8');
INSERT INTO `clothingsdb`.`product_colors` (`pro_id`, `col_id`) VALUES ('5', '9');
INSERT INTO `clothingsdb`.`product_colors` (`pro_id`, `col_id`) VALUES ('6', '10');
INSERT INTO `clothingsdb`.`product_colors` (`pro_id`, `col_id`) VALUES ('6', '11');
INSERT INTO `clothingsdb`.`product_colors` (`pro_id`, `col_id`) VALUES ('6', '12');
INSERT INTO `clothingsdb`.`product_colors` (`pro_id`, `col_id`) VALUES ('6', '13');
INSERT INTO `clothingsdb`.`product_colors` (`pro_id`, `col_id`) VALUES ('6', '14');
INSERT INTO `clothingsdb`.`product_colors` (`pro_id`, `col_id`) VALUES ('6', '15');
INSERT INTO `clothingsdb`.`product_colors` (`pro_id`, `col_id`) VALUES ('7', '16');
--
INSERT INTO `clothingsdb`.`images` (`ima_id`, `ima_url`) VALUES ('1', 'qqqqqqqqqqqqqqqqqqqhuiddce');
INSERT INTO `clothingsdb`.`images` (`ima_id`, `ima_url`) VALUES ('2', 'dvuecedwucevbaeucgberudcvv');
INSERT INTO `clothingsdb`.`images` (`ima_id`, `ima_url`) VALUES ('3', 'hazdaddddddddddd');
INSERT INTO `clothingsdb`.`images` (`ima_id`, `ima_url`) VALUES ('4', 'rtbvrbrrfrgtyuxxqwdwefrrfef');
INSERT INTO `clothingsdb`.`images` (`ima_id`, `ima_url`) VALUES ('5', 'asfggtgfdcdfvbfv');
INSERT INTO `clothingsdb`.`images` (`ima_id`, `ima_url`) VALUES ('6', 'efthyuujujnuyhbtggvgrtnyyu');
INSERT INTO `clothingsdb`.`images` (`ima_id`, `ima_url`) VALUES ('7', 'fvgtyhtfdsasfdghnhyttredvf');
--
INSERT INTO `clothingsdb`.`product_images` (`pro_id`, `ima_id`) VALUES ('1', '1');
INSERT INTO `clothingsdb`.`product_images` (`pro_id`, `ima_id`) VALUES ('1', '2');
INSERT INTO `clothingsdb`.`product_images` (`pro_id`, `ima_id`) VALUES ('2', '3');
INSERT INTO `clothingsdb`.`product_images` (`pro_id`, `ima_id`) VALUES ('3', '3');
INSERT INTO `clothingsdb`.`product_images` (`pro_id`, `ima_id`) VALUES ('4', '4');
INSERT INTO `clothingsdb`.`product_images` (`pro_id`, `ima_id`) VALUES ('5', '5');
INSERT INTO `clothingsdb`.`product_images` (`pro_id`, `ima_id`) VALUES ('6', '6');
INSERT INTO `clothingsdb`.`product_images` (`pro_id`, `ima_id`) VALUES ('7', '7');

--
INSERT INTO `clothingsdb`.`orders` (`order_id`, `user_id`, `order_date`, `order_totalPrice`, `order_status`) VALUES ('1', '3', '16/9/2020', '928000', 'pending');
INSERT INTO `clothingsdb`.`orders` (`order_id`, `user_id`, `order_date`, `order_totalPrice`, `order_status`) VALUES ('2', '3', '16/9/2020', '200000', 'pending');
INSERT INTO `clothingsdb`.`orders` (`order_id`, `user_id`, `order_date`, `order_totalPrice`, `order_status`) VALUES ('3', '3', '16/9/2020', '200000', 'pending');
INSERT INTO `clothingsdb`.`orders` (`order_id`, `user_id`, `order_date`, `order_totalPrice`, `order_status`) VALUES ('4', '4', '16/9/2020', '1130000', 'pending');
INSERT INTO `clothingsdb`.`orders` (`order_id`, `user_id`, `order_date`, `order_totalPrice`, `order_status`) VALUES ('5', '4', '16/9/2020', '589000', 'pending');
INSERT INTO `clothingsdb`.`orders` (`order_id`, `user_id`, `order_date`, `order_totalPrice`, `order_status`) VALUES ('6', '3', '16/9/2020', '580000', 'pending');

--
INSERT INTO `clothingsdb`.`orderdetails` (`order_id`, `pro_id`, `unit_price`, `quantity`) VALUES ('1', '1', '200000', '1');
INSERT INTO `clothingsdb`.`orderdetails` (`order_id`, `pro_id`, `unit_price`, `quantity`) VALUES ('1', '2', '150000', '1');
INSERT INTO `clothingsdb`.`orderdetails` (`order_id`, `pro_id`, `unit_price`, `quantity`) VALUES ('1', '3', '200000', '1');
INSERT INTO `clothingsdb`.`orderdetails` (`order_id`, `pro_id`, `unit_price`, `quantity`) VALUES ('1', '4', '189000', '2');
INSERT INTO `clothingsdb`.`orderdetails` (`order_id`, `pro_id`, `unit_price`, `quantity`) VALUES ('2', '1', '200000', '1');
INSERT INTO `clothingsdb`.`orderdetails` (`order_id`, `pro_id`, `unit_price`, `quantity`) VALUES ('3', '3', '200000', '1');
INSERT INTO `clothingsdb`.`orderdetails` (`order_id`, `pro_id`, `unit_price`, `quantity`) VALUES ('4', '2', '150000', '1');
INSERT INTO `clothingsdb`.`orderdetails` (`order_id`, `pro_id`, `unit_price`, `quantity`) VALUES ('4', '5', '980000', '1');
INSERT INTO `clothingsdb`.`orderdetails` (`order_id`, `pro_id`, `unit_price`, `quantity`) VALUES ('5', '1', '200000', '1');
INSERT INTO `clothingsdb`.`orderdetails` (`order_id`, `pro_id`, `unit_price`, `quantity`) VALUES ('5', '3', '200000', '1');
INSERT INTO `clothingsdb`.`orderdetails` (`order_id`, `pro_id`, `unit_price`, `quantity`) VALUES ('5', '4', '189000', '1');
INSERT INTO `clothingsdb`.`orderdetails` (`order_id`, `pro_id`, `unit_price`, `quantity`) VALUES ('6', '3', '200000', '1');
INSERT INTO `clothingsdb`.`orderdetails` (`order_id`, `pro_id`, `unit_price`, `quantity`) VALUES ('6', '7', '190000', '2');

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
call showorderbid(1);
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
select order_id from orders o inner join users u on o.user_id=u.user_id where u.user_id =3;
