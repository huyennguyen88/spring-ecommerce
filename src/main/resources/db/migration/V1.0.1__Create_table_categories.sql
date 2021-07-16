CREATE TABLE categories (
	id INT NOT NULL AUTO_INCREMENT,
	name VARCHAR(255) NOT NULL,
    created_date timestamp default current_timestamp,
    updated_date timestamp default current_timestamp on update current_timestamp,
    deleted_date timestamp NULL,
    created_by INT NULL,
    updated_by INT NULL,
	PRIMARY KEY (id),
    FOREIGN KEY (created_by) REFERENCES users(id),
    FOREIGN KEY (updated_by) REFERENCES users(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;