CREATE TABLE `localities` (
    `id` INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `postal_code` VARCHAR(6) NOT NULL,
    `locality` VARCHAR(60) NOT NULL

);

/*CREATE TABLE `roles` (
    `id` INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `role` varchar(60)
);

CREATE TABLE `role_user` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `role_id` INT NOT NULL,
    `user_id` INT NOT NULL,
    FOREIGN KEY (`role_id`) REFERENCES roles(`id`),
    FOREIGN KEY (`user_id`) REFERENCES users(`id`),
    PRIMARY KEY (`id`)
);
  */

CREATE TABLE `artists` (
    `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `firstname` VARCHAR(60) NOT NULL,
    `lastname` VARCHAR(60) NOT NULL

);

CREATE TABLE `types` (
    `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `type` VARCHAR(60) NOT NULL
);

CREATE TABLE `users` (
    `id` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `login` varchar(60) COLLATE utf8mb4_unicode_ci NOT NULL,
    `password` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
    `firstname` varchar(60) COLLATE utf8mb4_unicode_ci NOT NULL,
    `lastname` varchar(60) COLLATE utf8mb4_unicode_ci NOT NULL,
    `email` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
    `language` varchar(2) COLLATE utf8mb4_unicode_ci NOT NULL,
    `role` enum('admin','member','') COLLATE utf8mb4_unicode_ci NOT NULL,
    `created_at` datetime NOT NULL DEFAULT current_timestamp()

);

CREATE TABLE `artist_type` (
    `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `artist_id` INT NOT NULL,
    `type_id` INT NOT NULL,
    FOREIGN KEY (`artist_id`) REFERENCES artists(`id`),
    FOREIGN KEY (`type_id`) REFERENCES types(`id`)

);

CREATE TABLE `shows` (
    `id` INT(11) AUTO_INCREMENT PRIMARY KEY,
    `slug` VARCHAR(60),
    `title` VARCHAR(255),
    `description` TEXT,
    `poster_url` VARCHAR(255),
    `location_id` INT(11),
    `bookable` TINYINT,
    `price` DECIMAL(10,2)

);

CREATE TABLE `locations` (
    `id` INT(11) AUTO_INCREMENT PRIMARY KEY,
    `slug` VARCHAR(60),
    `designation` VARCHAR(60),
    `address` VARCHAR(255),
    `locality_id` INT(11),
    `website` VARCHAR(255),
    `phone` VARCHAR(30),
    FOREIGN KEY (`locality_id`) REFERENCES localities(`id`)
);

CREATE TABLE `representations` (
    `id` INT(11) AUTO_INCREMENT PRIMARY KEY,
    `show_id` int(11),
    `when` datetime,
    `location_id` INT(11),
    FOREIGN KEY (`show_id`) REFERENCES shows(`id`),
    FOREIGN KEY (`location_id`) REFERENCES locations(`id`)
);

CREATE TABLE `representation_user` (
    `id` INT(11) AUTO_INCREMENT ,
    `representaion_id` int(11),
    `user_id` INT(11),
    `places` INT(11),
    FOREIGN KEY (`representaion_id`) REFERENCES representations(`id`),
    FOREIGN KEY (`user_id`) REFERENCES users(`id`)

);

CREATE TABLE `artist_type_show` (
    `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `artist_id` INT NOT NULL,
    `show_id` INT NOT NULL,
    FOREIGN KEY (`artist_id`) REFERENCES artists(`id`),
    FOREIGN KEY (`show_id`) REFERENCES shows(`id`)
);






