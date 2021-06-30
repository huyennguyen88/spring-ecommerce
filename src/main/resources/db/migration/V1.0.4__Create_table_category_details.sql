CREATE TABLE category_details (
    id INT NOT NULL AUTO_INCREMENT,
	category_id INT NOT NULL,
	parent_id INT NULL,
	PRIMARY KEY (id),
	FOREIGN KEY (category_id) REFERENCES categories(id),
	FOREIGN KEY (parent_id) REFERENCES categories(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;