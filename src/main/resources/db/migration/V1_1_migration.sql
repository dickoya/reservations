CREATE TABLE `localities` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `postal_code` VARCHAR(6) NOT NULL,
    `locality` VARCHAR(60) NOT NULL,
    PRIMARY KEY (`id`)
);


CREATE TABLE `artists` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `firstname` VARCHAR(60) NOT NULL,
    `lastname` VARCHAR(60) NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `types` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `type` VARCHAR(60) NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `users` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `login` varchar(60) COLLATE utf8mb4_unicode_ci NOT NULL,
    `password` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
    `firstname` varchar(60) COLLATE utf8mb4_unicode_ci NOT NULL,
    `lastname` varchar(60) COLLATE utf8mb4_unicode_ci NOT NULL,
    `email` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
    `langue` varchar(2) COLLATE utf8mb4_unicode_ci NOT NULL,
    `role` enum('admin','member','') COLLATE utf8mb4_unicode_ci NOT NULL,
    `created_at` datetime NOT NULL DEFAULT current_timestamp(),
    PRIMARY KEY (`id`)
);

CREATE TABLE `artist_type` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `artist_id` INT NOT NULL,
    `type_id` INT NOT NULL,
    FOREIGN KEY (`artist_id`) REFERENCES artists(`id`),
    FOREIGN KEY (`type_id`) REFERENCES types(`id`),
    PRIMARY KEY (`id`)
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
    `id` INT NOT NULL AUTO_INCREMENT,
    `artist_id` INT NOT NULL,
    `show_id` INT NOT NULL,
    FOREIGN KEY (`artist_id`) REFERENCES artists(`id`),
    FOREIGN KEY (`show_id`) REFERENCES shows(`id`),
    PRIMARY KEY (`id`)
);

#  INSERTION

INSERT INTO shows (slug, title, description, poster_url, location_id, bookable, price)
VALUES  ('slug1', 'Show 1 Title', 'Description for Show 1', 'http://example.com/poster1.jpg', 1, 1, 25.00),
        ('slug2', 'Show 2 Title', 'Description for Show 2', 'http://example.com/poster2.jpg', 2, 0, 30.00),
        ('slug3', 'Show 3 Title', 'Description for Show 3', 'http://example.com/poster3.jpg', 3, 1, 20.00),
        ('slug4', 'Show 4 Title', 'Description for Show 4', 'http://example.com/poster4.jpg', 4, 0, 35.00),
        ('slug5', 'Show 5 Title', 'Description for Show 5', 'http://example.com/poster5.jpg', 5, 1, 40.00),
        ('slug6', 'Show 6 Title', 'Description for Show 6', 'http://example.com/poster6.jpg', 6, 1, 45.00),
        ('slug7', 'Show 7 Title', 'Description for Show 7', 'http://example.com/poster7.jpg', 7, 1, 50.00),
        ('slug8', 'Show 8 Title', 'Description for Show 8', 'http://example.com/poster8.jpg', 8, 0, 55.00),
        ('slug9', 'Show 9 Title', 'Description for Show 9', 'http://example.com/poster9.jpg', 9, 1, 60.00),
        ('slug10', 'Show 10 Title', 'Description for Show 10', 'http://example.com/poster10.jpg', 10, 1, 65.00);

INSERT INTO localities (postal_code, locality)
VALUES  ('10001', 'New York'),
        ('20001', 'Washington DC'),
        ('30001', 'Atlanta'),
        ('40001', 'Los Angeles'),
        ('50001', 'Chicago'),
        ('60001', 'Houston'),
        ('70001', 'New Orleans'),
        ('80001', 'Denver'),
        ('90001', 'San Francisco'),
        ('100001', 'Seattle');


INSERT INTO locations (slug, designation, address, locality_id, website, phone)
VALUES  ('location1', 'Location 1 Designation', '123 Street, City1', 1, 'www.location1.com', '123-456-7890'),
        ('location2', 'Location 2 Designation', '456 Avenue, City2', 2, 'www.location2.com', '456-789-0123'),
        ('location3', 'Location 3 Designation', '789 Road, City3', 3, 'www.location3.com', '789-012-3456'),
        ('location4', 'Location 4 Designation', '321 Boulevard, City4', 4, 'www.location4.com', '321-654-9870'),
        ('location5', 'Location 5 Designation', '654 Lane, City5', 5, 'www.location5.com', '654-987-0123'),
        ('location6', 'Location 6 Designation', '987 Court, City6', 6, 'www.location6.com', '987-012-3456'),
        ('location7', 'Location 7 Designation', '1234 Park, City7', 7, 'www.location7.com', '1234-567-8901'),
        ('location8', 'Location 8 Designation', '5678 Square, City8', 8, 'www.location8.com', '5678-901-2345'),
        ('location9', 'Location 9 Designation', '9012 Drive, City9', 9, 'www.location9.com', '9012-345-6789'),
        ('location10', 'Location 10 Designation', '345 Court, City10', 10, 'www.location10.com', '345-678-9012');

INSERT INTO representations (show_id, `when`, location_id)
VALUES  (1, '2024-02-21 10:00:00', 1),
        (2, '2024-02-22 11:00:00', 2),
        (3, '2024-02-23 12:00:00', 3),
        (4, '2024-02-24 13:00:00', 4),
        (5, '2024-02-25 14:00:00', 5),
        (6, '2024-02-26 15:00:00', 6),
        (7, '2024-02-27 16:00:00', 7),
        (8, '2024-02-28 17:00:00', 8),
        (9, '2024-02-29 18:00:00', 9),
        (10, '2024-03-01 19:00:00', 10);

INSERT INTO representation_user (representaion_id, user_id, places)
VALUES  (1, 1, 2),
        (2, 2, 3),
        (3, 3, 1),
        (4, 4, 4),
        (5, 5, 2),
        (6, 6, 3),
        (7, 7, 1),
        (8, 8, 4),
        (9, 9, 2),
        (10, 10, 3);

INSERT INTO artists (firstname, lastname)
VALUES  ('Luc', 'Dubois'),
        ('Sophie', 'Lambert'),
        ('Pierre', 'Martens'),
        ('Julie', 'De Smet'),
        ('Philippe', 'Vandenberghe'),
        ('Isabelle', 'Deschamps'),
        ('Jean', 'Leclerc'),
        ('Marie', 'Dumont'),
        ('François', 'Leroy'),
        ('Catherine', 'Jacobs');

-- Assurez-vous que les identifiants `artist_id` correspondent à des artistes existants dans la table `artists`.
-- De même, assurez-vous que les identifiants `type_id` correspondent à des types existants dans la table `types`.

INSERT INTO artist_type (artist_id, type_id)
VALUES  (1, 1),
        (2, 2),
        (3, 3),
        (4, 1),
        (5, 2),
        (6, 3),
        (7, 1),
        (8, 2),
        (9, 3),
        (10, 1);


-- Assurez-vous que les identifiants `artist_id` correspondent à des artistes existants dans la table `artists`.
-- De même, assurez-vous que les identifiants `show_id` correspondent à des spectacles existants dans la table `shows`.

INSERT INTO artist_type_show (artist_id, show_id)
VALUES  (1, 1),
        (2, 2),
        (3, 3),
        (4, 4),
        (5, 5),
        (6, 6),
        (7, 7),
        (8, 8),
        (9, 9),
        (10, 10);

INSERT INTO users (login, password, firstname, lastname, email, langue, role)
VALUES  ('user1', 'password1', 'John', 'Doe', 'john@example.com', 'en', 'admin'),
        ('user2', 'password2', 'Jane', 'Smith', 'jane@example.com', 'fr', 'member'),
        ('user3', 'password3', 'Michael', 'Johnson', 'michael@example.com', 'en', 'member'),
        ('user4', 'password4', 'Emily', 'Williams', 'emily@example.com', 'fr', 'member'),
        ('user5', 'password5', 'Christopher', 'Brown', 'chris@example.com', 'en', 'member'),
        ('user6', 'password6', 'Jessica', 'Jones', 'jessica@example.com', 'fr', 'member'),
        ('user7', 'password7', 'Daniel', 'Garcia', 'daniel@example.com', 'en', 'member'),
        ('user8', 'password8', 'Sarah', 'Martinez', 'sarah@example.com', 'fr', 'member'),
        ('user9', 'password9', 'David', 'Rodriguez', 'david@example.com', 'en', 'member'),
        ('user10', 'password10', 'Jennifer', 'Davis', 'jennifer@example.com', 'fr', 'member');


INSERT INTO locations (slug, designation, address, locality_id, website, phone)
VALUES  ('location1', 'Location 1 Designation', '123 Rue de la Liberté', 1, 'www.location1.com', '+32 123 456 789'),
        ('location2', 'Location 2 Designation', '456 Avenue des Arts', 2, 'www.location2.com', '+32 987 654 321'),
        ('location3', 'Location 3 Designation', '789 Boulevard de la République', 3, 'www.location3.com', '+32 456 789 123'),
        ('location4', 'Location 4 Designation', '321 Rue Royale', 4, 'www.location4.com', '+32 321 654 987'),
        ('location5', 'Location 5 Designation', '654 Boulevard du Midi', 5, 'www.location5.com', '+32 654 987 321'),
        ('location6', 'Location 6 Designation', '987 Rue de l\'Esplanade', 6, 'www.location6.com', '+32 789 123 456'),
        ('location7', 'Location 7 Designation', '1234 Avenue Louise', 7, 'www.location7.com', '+32 1234 567 890'),
        ('location8', 'Location 8 Designation', '5678 Chaussée de Wavre', 8, 'www.location8.com', '+32 5678 901 234'),
        ('location9', 'Location 9 Designation', '9012 Rue du Commerce', 9, 'www.location9.com', '+32 9012 345 678'),
        ('location10', 'Location 10 Designation', '345 Avenue de la Gare', 10, 'www.location10.com', '+32 345 678 901');





