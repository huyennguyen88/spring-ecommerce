CREATE TABLE Categories (
	id INT NOT NULL AUTO_INCREMENT,
	name VARCHAR(255) NOT NULL,
	parent_id INT NULL,
	PRIMARY KEY (id),
	FOREIGN KEY (parent_id) REFERENCES Categories(id)
);