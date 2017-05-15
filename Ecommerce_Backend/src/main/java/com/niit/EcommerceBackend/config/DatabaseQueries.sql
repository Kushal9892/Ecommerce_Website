CREATE TABLE Category
(
	categoryID INTEGER IDENTITY,
	categoryName VARCHAR(50),
	categoryDescription VARCHAR(250),
	categoryImageURL VARCHAR(50),
	categoryIsActive BOOLEAN,
	
	CONSTRAINT pk_category_categoryID PRIMARY KEY (categoryID) 
);

INSERT INTO Category (categoryName, categoryDescription, categoryImageURL, categoryIsActive) VALUES ('Laptops', 'This is some description for Laptops!!', 'category1.png', true);
INSERT INTO Category (categoryName, categoryDescription, categoryImageURL, categoryIsActive) VALUES ('Televisions', 'This is some description for Televisions!!', 'category2.png', true);
INSERT INTO Category (categoryName, categoryDescription, categoryImageURL, categoryIsActive) VALUES ('Mobiles', 'This is some description for Mobiles!!', 'category3.png', true);
INSERT INTO Category (categoryName, categoryDescription, categoryImageURL, categoryIsActive) VALUES ('Cameras', 'This is some description for Cameras!!', 'category4.png', true);

CREATE TABLE UserDetails (
	userID IDENTITY,
	userFirstName VARCHAR(50),
	userFLastName VARCHAR(50),
	userRole VARCHAR(50),
	userEnabled BOOLEAN,
	userPassword VARCHAR(50),
	userEmail VARCHAR(50),
	userContactNumber VARCHAR(10),
	
	CONSTRAINT pk_UserDetails_userID PRIMARY KEY(userID)
);

INSERT INTO UserDetails (userFirstName, userFLastName, userRole, userEnabled, userPassword, userEmail, userContactNumber) 
VALUES ('Virat', 'Kohli', 'ADMIN', true, 'admin', 'vk@gmail.com', '8888888888');

INSERT INTO UserDetails (userFirstName, userFLastName, userRole, userEnabled, userPassword, userEmail, userContactNumber) 
VALUES ('Ravindra', 'Jadeja', 'SUPPLIER', true, '12345', 'rj@gmail.com', '9999999999');

INSERT INTO UserDetails (userFirstName, userFLastName, userRole, userEnabled, userPassword, userEmail, userContactNumber) 
VALUES ('Ravichandra', 'Ashwin', 'SUPPLIER', true, '12345', 'ra@gmail.com', '7777777777');

CREATE TABLE Product
(
	productID INTEGER IDENTITY,
	productCode VARCHAR(20),
	productName VARCHAR(50),
	productBrand VARCHAR(50),
	productDescription VARCHAR(250),
	productUnitPrice DECIMAL(10,2),
	productQuantity INTEGER,
	productIsActive BOOLEAN,
	categoryID INT,
	supplierID INT,
	productPurchases INT DEFAULT 0,
	productViews INT DEFAULT 0,
	
	CONSTRAINT pk_Product_productID PRIMARY KEY (productID),
	CONSTRAINT fk_Product_categoryID FOREIGN KEY (categoryID) REFERENCES Category(categoryID),
	CONSTRAINT fk_Product_supplierID FOREIGN KEY (supplierID) REFERENCES UserDetails(userID)
);

INSERT INTO product (productCode, productName, productBrand, productDescription, productUnitPrice, productQuantity, productIsActive, categoryId, supplierId)
VALUES ('PRDABC123DEFX', 'iPhone 5s', 'Apple', 'This is one of the best phone available in the market right now!', 18000, 5, true, 3, 2 );

INSERT INTO product (productCode, productName, productBrand, productDescription, productUnitPrice, productQuantity, productIsActive, categoryId, supplierId)
VALUES ('PRDDEF123DEFX', 'Samsung s7', 'Samsung', 'A smart phone by Samsung!', 32000, 2, true, 3, 3 );

INSERT INTO product (productCode, productName, productBrand, productDescription, productUnitPrice, productQuantity, productIsActive, categoryId, supplierId)
VALUES ('PRDPQR123WGTX', 'Google Pixel', 'Google', 'This is one of the best android smart phone available in the market right now!', 57000, 5, true, 3, 2 );

INSERT INTO product (productCode, productName, productBrand, productDescription, productUnitPrice, productQuantity, productIsActive, categoryId, supplierId)
VALUES ('PRDMNO123PQRX', ' Macbook Pro', 'Apple', 'This is one of the best laptops available in the market right now!', 54000, 3, true, 1, 2 );

INSERT INTO product (productCode, productName, productBrand, productDescription, productUnitPrice, productQuantity, productIsActive, categoryId, supplierId)
VALUES ('PRDABCXYZDEFX', 'Dell Latitude E6510', 'Dell', 'This is one of the best laptop series from Dell that can be used!', 48000, 5, true, 1, 3 );

//Data Base Queries: https://drive.google.com/file/d/0B5VnhmTETsFLd3hBOTJrLUVQbm8/view
