CREATE TABLE Category
(
	categoryID INTEGER IDENTITY,
	categoryName VARCHAR(50),
	categoryDescription VARCHAR(250),
	categoryIsActive BOOLEAN,
	
	CONSTRAINT pk_category_id PRIMARY KEY (categoryID) 
);

CREATE TABLE Product
(
	productID INTEGER IDENTITY,
	productName VARCHAR(50),
	productDescription VARCHAR(250),
	productBrand VARCHAR(50),
	productQuantity INTEGER,
	productAmount DOUBLE,
	productIsActive BOOLEAN,
	
	CONSTRAINT pk_product_id PRIMARY KEY (productID),
	CONSTRAINT fk_category_id FOREIGN KEY (categoryID) REFERENCES Category(categoryID)
);