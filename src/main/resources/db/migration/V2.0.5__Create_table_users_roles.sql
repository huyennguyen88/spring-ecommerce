create table users_roles (
	id INT NOT NULL auto_increment,
	user_id INT NOT NULL,
	role_id INT NOT NULL,
    PRIMARY KEY (id),
	FOREIGN KEY (user_id) REFERENCES users(id),
	FOREIGN KEY (role_id) REFERENCES roles(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
