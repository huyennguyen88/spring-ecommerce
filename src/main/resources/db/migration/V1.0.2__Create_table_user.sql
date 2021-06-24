CREATE TABLE users (
	id INT NOT NULL AUTO_INCREMENT,
	fullname VARCHAR(255) NOT NULL,
    username VARCHAR(255) NOT NULL UNIQUE,
	email VARCHAR(255) NOT NULL UNIQUE,
	avatar TEXT,
	phone VARCHAR(255),
	address TEXT,
	password VARCHAR(255),
    create_time timestamp default current_timestamp,
    update_time timestamp default current_timestamp on update current_timestamp,
	delete_time timestamp null,
	PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ;