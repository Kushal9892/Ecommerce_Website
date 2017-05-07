CREATE TABLE Category
(
	categoryID INTEGER IDENTITY,
	categoryName VARCHAR(50),
	categoryDescription VARCHAR(250),
	categoryImageURL VARCHAR(50),
	categoryIsActive BOOLEAN,
	
	CONSTRAINT pk_category_categoryID PRIMARY KEY (categoryID) 
);

INSERT INTO Category (categoryID, categoryName, categoryDescription, categoryImageURL, categoryIsActive) VALUES ('Laptops', 'This is some description for Laptops!!', 'category1.png', true);
INSERT INTO Category (categoryID, categoryName, categoryDescription, categoryImageURL, categoryIsActive) VALUES ('Televisions', 'This is some description for Televisions!!', 'category2.png', true);
INSERT INTO Category (categoryID, categoryName, categoryDescription, categoryImageURL, categoryIsActive) VALUES ('Mobiles', 'This is some description for Mobiles!!', 'category3.png', true);

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



