DROP SCHEMA IF EXISTS DeansBeans ;
CREATE SCHEMA IF NOT EXISTS DeansBeans ;

Use DeansBeans ;

DROP TABLE IF EXISTS customers;
CREATE TABLE customers
(
  CustomerID int NOT NULL AUTO_INCREMENT,
  CustomerName varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  AddressLine1 varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  AddressLine2 varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  AddressLine3 varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  Postcode char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  Phone char(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  Email varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  SecurityQuestion varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  SecurityQuestionAnswer varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (CustomerID)
);

LOCK TABLES customers WRITE;
INSERT 
INTO customers 
	(CustomerID, CustomerName, AddressLine1, AddressLine2, AddressLine3, Postcode, Phone, Email, SecurityQuestion, SecurityQuestionAnswer) 
VALUES 
	(1,'Billie Blender','1 the High Street','Sunnyville',NULL,'SN1 1TW','01234567890','Billie@Blender.com','Favourite Roast','Classic'),
	(2,'Graham Grounds','3 Reachout Street','Forthestarsto','Berks','FT3 7QE','02456123987','Graham@Grounds.co.uk','Favourite Coffee Additive','Maple Syrup'),
	(3,'Philippa Filter','33 Loopdloop Road','Inverto','Lancs','IN5 7DD','07555182736','Philippa@Filter.gov','Favourite Style','Americano'),
	(4,'Kofi Kreme','74 Cirrus Avenue','Clouding','E Sussex','CL9 0PQ','07400563824','Kofi@Kreme.co.uk','A word that rhymes with bean','Sheen');
UNLOCK TABLES;

DROP TABLE IF EXISTS degreesofroast;
CREATE TABLE degreesofroast
(
  DegreeOfRoastID int NOT NULL AUTO_INCREMENT,
  RoastType char(10) NOT NULL,
  PRIMARY KEY (DegreeOfRoastID)
);

LOCK TABLES degreesofroast WRITE;
INSERT 
INTO degreesofroast 
	(DegreeOfRoastID, RoastType) 
VALUES 
	(1,'Raw'),
	(2,'Light'),
	(3,'Medium'),
	(4,'Dark'),
	(5,'Burnt'),
	(6,'Cremated');
UNLOCK TABLES;

DROP TABLE IF EXISTS formats;
CREATE TABLE formats 
(
  FormatID int NOT NULL AUTO_INCREMENT,
  FormatDescription varchar(50) NOT NULL,
  PRIMARY KEY (`FormatID`)
);

LOCK TABLES formats WRITE;
INSERT 
INTO formats 
	(FormatID, FormatDescription) 
VALUES 
	(1,'Whole Beans'),
    (2,'Coarse Ground'),
    (3,'Medium Ground'),
    (4,'Fine Ground'),
    (5,'Dust'),
    (6,'Nespresso (Pod)'),
    (7,'Dolce Gusto (Pod)'),
    (8,'Tassimo (Pod)'),
    (9,'Lavazza (pod)');
UNLOCK TABLES;

DROP TABLE IF EXISTS products;
CREATE TABLE products 
(
  ProductID int NOT NULL AUTO_INCREMENT,
  ProductName varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  Description varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  RecommendedRetailPrice decimal(18,2) NOT NULL,
  WholesalePrice decimal(18,2) NOT NULL,
  DiscountType char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  DiscountPercentage int DEFAULT NULL,
  PRIMARY KEY (ProductID)
);

LOCK TABLES products WRITE;
INSERT 
INTO products 
	(ProductID, ProductName, Description, RecommendedRetailPrice, WholesalePrice, DiscountType, DiscountPercentage) 
VALUES 
	(1,'Lava Java','Lava Java is made from molten beans generated by geothermal energy and expelled through fractures in planetary crust or eruptions, usually at temperatures from 700 to 1,200 °C (1,292 to 2,192 °F). The structures resulting from subsequent solidification and cooling are then harvested, washed and tumbled before being reconstituted back into beans and then treated like any other bean. Bagged in our own factories. ',8.17,4.05,NULL,NULL),
    (2,'Arabica Erotica','The queen of coffee, possibly the best aphrodisiac out there. Hint\'s of Dior, Canel, Klien and Versace...',12.00,6.00,'B',NULL),
    (3,'Old Knobler','Made with a selected single piece of roasted English oak (sustainably resourced).  this solid coffee is both distinctive and durable. Usually grown for it’s cob nuts, the natural beauty and taste hardwood gives to coffee is one of the industy\'s best kept secrets. With a honey coloured hue this light yet strong coffee is a durable accessory long associated with the English countryside. With a complex frame, this coffee is a reliable companion with flavours that last and linger on the tongue. ',11.00,5.59,'P',10),
    (4,'Justa Robusta','A simple, medium roast robusta coffee. Your stock \"go to\" coffee for your day to day requirements. ',9.95,4.22,'B',NULL),
    (5,'Robusta Crusta','Puts hairs on your chest (and probably other body parts too)',10.99,5.49,'P',5),
    (6,'Maple Bacon','If you like bacon, you’ll have to try this lightly roasted coffee drink! Especially geared toward the morning coffee drinker (for those who like their eggs and bacon), this roast comes from Boca Java and has strong piggy bacon overtones. Probably best enjoyed with your fried eggs, beans and toast. These beans are 100% Vegan. ',5.00,2.30,'T',NULL),
    (7,'Weasel Puke','This one is definitely not for the faint-hearted and the name may already be making you feel a little queasy. These coffee beans are eaten by weasels which leaves a residue in their mouths. This residue is carefully removed (weasels have very sharp teeth), cleansed, roasted and bagged ready for you to enjoy. ',4.17,2.05,'T',NULL),
    (8,'Old Warthog','Warthog hide is traditionally beaten with hickory sticks before being soaked in a wash of cured leaf juice. You can smell the roasting beans from a good 500 metres away',8.29,4.01,'F',NULL),
    (9,'Star Wars Vader’s Dark Side','Get in touch with the dark side of the force with this truly dark brew. After one shot of this you\'ll know who your father is.',5.00,2.50,'F',NULL),
    (10,'Death Wish','One mug of this will fully stoke your anxiety, insomnia, dizziness, digestive system, muscle breakdown, addiction, blood pressure and heart rate, but fatigue will be a thing of the past.',9.00,4.50,NULL,NULL),
    (11,'Fix','One of the strongest coffees on the market. Never mind the taste, just wait for the caffeine hit...aaahhh',6.95,5.00,NULL,NULL),
    (12,'Mother’s Little Helper','A strong brew best disguised with a lot of milky froth. Expect hints of quinine, tonic and a dash of lemon.',5.00,2.50,NULL,NULL),
    (13,'Vanilla Flavored Monkey Spit','Before roasting these beans are sucked on by monkeys and then when they’re finished they spit them out. The beans are then collected and are prized for their spectacular vanilla flavor. The farmer in Taiwan got sick of his beans being eaten by monkeys and so decided to actually try one himself to see what he was missing. Needless to say he liked it, and decided to share Vanilla flavored Monkey Spit Coffee with the world. Enjoy!',5.00,2.50,NULL,NULL),
    (14,'The Cheap and Nasty','A really cheap and nasty coffee with a really rather alarming after taste. You have been warned',1.99,0.99,NULL,NULL),
    (16,'Kopi Luwak','Made from the faeces of cats that eat the coffee beans, it contains a bunch of excellent enzymes, supposedly good for you. The poo is washed before it’s roasted and the roasting is done at over 220 Deg C (the raw bean version is still available but not recommended). For poo coffee, it’s really pricey; expect to pay from £30 a cup',127.49,63.99,NULL,NULL),
    (17,'The Cockney Knees-Up','A brew that\'s guaranteed to get you moving in the same way a good old fashioned sing song in an east-end pub used to do. Hints of apples and pears.',8.00,4.00,NULL,NULL),
    (18,'Beery Nice Espresso','A medium roasted robusta bean that\'s been boiled and marianated in the finest northern ale. Not to be taken before any kind of car journey if you\'re the one behind the wheel.',8.43,4.22,NULL,NULL);
UNLOCK TABLES;

DROP TABLE IF EXISTS orders;
CREATE TABLE orders
(
  OrderID int NOT NULL AUTO_INCREMENT,
  CustomerID int NOT NULL,
  OrderDate date NOT NULL,
  OrderTotal decimal(18,2) NOT NULL,
  OrderStatus int NOT NULL,
  PRIMARY KEY (OrderID),
  KEY FK_Orders_Customers (CustomerID),
  CONSTRAINT FK_Orders_Customers FOREIGN KEY (CustomerID) REFERENCES customers (customerid)
);

LOCK TABLES orders WRITE;
INSERT 
INTO orders 
	(OrderID, CustomerID, OrderDate, OrderTotal, OrderStatus) 
VALUES 
	(1,1,'2019-06-12',30.17,1),
    (2,2,'2019-07-01',81.95,2),
    (3,2,'2019-09-02',408.64,1),
    (4,2,'2019-10-28',24.47,1);
UNLOCK TABLES;

DROP TABLE IF EXISTS orderitems;
CREATE TABLE orderitems 
(
  OrderItemID int NOT NULL AUTO_INCREMENT,
  OrderID int NOT NULL,
  ProductID int NOT NULL,
  PurchasePrice decimal(18,2) NOT NULL,
  Quantity int NOT NULL,
  FormatID int DEFAULT NULL,
  DegreeOfRoastID int DEFAULT NULL,
  PRIMARY KEY (OrderItemID),
  KEY FK_OrderItems_Orders (OrderID),
  KEY FK_OrderItems_Products (ProductID),
  KEY FK_OrderItems_Formats (FormatID),
  KEY FK_OrderItems_DegreesOfRoast (DegreeOfRoastID),
  CONSTRAINT FK_OrderItems_DegreesOfRoast FOREIGN KEY (DegreeOfRoastID) REFERENCES degreesofroast (DegreeOfRoastID),
  CONSTRAINT FK_OrderItems_Formats FOREIGN KEY (FormatID) REFERENCES formats (formatid),
  CONSTRAINT FK_OrderItems_Orders FOREIGN KEY (OrderID) REFERENCES orders (orderid),
  CONSTRAINT FK_OrderItems_Products FOREIGN KEY (ProductID) REFERENCES products (productid)
);

LOCK TABLES orderitems WRITE;
INSERT 
INTO orderitems 
	(OrderItemID, OrderID, ProductID, PurchasePrice, Quantity, FormatID, DegreeOfRoastID) 
VALUES 
	(1,1,1,8.17,1,1,1),
    (2,1,2,12.00,1,1,5),
    (3,1,6,5.00,2,9,6),
    (4,2,2,12.00,6,3,5),
    (5,2,4,9.95,1,4,2),
    (6,3,1,8.17,1,4,3),
    (7,3,10,9.00,2,4,4),
    (8,3,16,127.49,3,5,2),
    (9,4,1,8.17,1,6,3),
    (10,4,7,4.17,2,7,4),
    (11,4,14,1.99,4,8,2);
UNLOCK TABLES;