CREATE TABLE Products (
	id INT NOT NULL AUTO_INCREMENT,
	name VARCHAR(255) NOT NULL,
	description TEXT,
	image TEXT NOT NULL,
	quantity INT NOT NULL,
	price decimal(15,0) NOT NULL,
	category_id INT NOT NULL,
    create_time timestamp default current_timestamp,
    update_time timestamp default current_timestamp on update current_timestamp,
    delete_time timestamp null,
	PRIMARY KEY (id),
	FOREIGN KEY (category_id) REFERENCES Categories(id)
);