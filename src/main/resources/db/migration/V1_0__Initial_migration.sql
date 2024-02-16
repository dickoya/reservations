CREATE TABLE artists (
    id int PRIMARY KEY AUTO_INCREMENT,
    firstname VARCHAR(255) NOT NULL,
    lastname VARCHAR(255) NOT NULL
);
INSERT INTO `artists` (`id`, `firstname`, `lastname`) VALUES
    (7, 'Laurent', 'Caron'),
    (8, 'Élena', 'Perez'),
    (9, 'Guillaume', 'Alexandre'),
    (10, 'Claude', 'Semal'),
    (11, 'Laurence', 'Warin'),
    (12, 'Pierre', 'Wayburn'),
    (13, 'Gwendoline', 'Gauthier');

CREATE TABLE `users` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `login` varchar(60) COLLATE utf8mb4_unicode_ci NOT NULL,
    `password` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
    `firstname` varchar(60) COLLATE utf8mb4_unicode_ci NOT NULL,
    `lastname` varchar(60) COLLATE utf8mb4_unicode_ci NOT NULL,
    `email` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
    `langue` varchar(2) COLLATE utf8mb4_unicode_ci NOT NULL,
    `role` enum('admin','member','') COLLATE utf8mb4_unicode_ci NOT NULL,
    `created_at` datetime NOT NULL,
    PRIMARY KEY(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO `users` (`id`, `login`, `password`, `firstname`, `lastname`, `email`, `langue`, `role`, `created_at`) VALUES
    (1, 'ibra', '12345678', 'Ibrahima', 'Diallo', 'ibrahim@sull.com','fr','admin','2010-01-01 12:00:00'),
    (2, 'jerome', '12345678', 'Jerome', 'Dumont', 'jerome.dumont@sull.com','en','member','2010-01-01 12:00:00');

CREATE TABLE `shows` (
    `id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `title` VARCHAR(255) NOT NULL,
    `slug` VARCHAR(255) NOT NULL UNIQUE


);
INSERT INTO `shows` (
    `title`,
    `slug`

) VALUES (
             'Le Malade Imaginaire',
             'le-malade-imaginaire-bruxelles'


         ), (
             'Le Bourgeois Gentilhomme',
             'le-bourgeois-gentilhomme-bruxelles'


         ), (
             'Hamlet',
             'hamlet-bruxelles'
         ), (
             'Romeo et Juliette',
             'romeo-et-juliette-bruxelles'
         ), (
             'La Métamorphose des papillons',
             'la-metamorphose-des-papillons-bruxelles'
         ), (
             'Le Roi Lear',
             'le-roi-lear-bruxelles'

         ), (
             'Le Misanthrope',
             'le-misanthrope-bruxelles'

         ), (
             'Cyrano de Bergerac',
             'cyrano-de-bergerac-bruxelles'

         ), (
             'La Cantatrice Chauve',
             'la-cantatrice-chauve-anvers'

         ), (
             'Le Songe dune nuit dété',
             'le-songe-dune-nuit-dete-anvers'

         ), (
             'Le Cid',
             'le-cid-anvers'

         ), (
             'La Tragédie de Macbeth',
             'la-tragedie-de-macbeth-anvers'
         ), (
             'La Flûte enchantée',
             'la-flute-enchantee-anvers'
         ), (
             'Le Bourgeois gentilhomme',
             'le-bourgeois-gentilhomme-anvers'
         );