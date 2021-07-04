CREATE TABLE categories (
	id INT NOT NULL AUTO_INCREMENT,
	name VARCHAR(255) NOT NULL,
    created_date timestamp default current_timestamp,
    updated_date timestamp default current_timestamp on update current_timestamp,
    deleted_date timestamp null,
	PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;