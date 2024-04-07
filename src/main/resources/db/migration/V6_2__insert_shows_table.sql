/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  fotso
 * Created: 12 févr. 2024
 */

INSERT INTO `shows` (`id`, `slug`, `title`, `description`, `poster_url`, `bookable`, `price`, `created_at`, `updated_at`, `location_id`)
VALUES
        (1, 'ayiti', 'Ayiti', 'Un homme est bloqué à l’aéroport. Questionné par les douaniers, il doit alors justifier son identité, et surtout prouver qu\'il est haïtien – qu\'est-ce qu\'être haïtien ?', 'ayiti.jpg', 1, '9.00', '2020-04-21 19:08:44.583000', NULL, 1),
        (2, 'cible-mouvante', 'Cible mouvante', 'Dans ce « thriller d’anticipation », des adultes semblent alimenter et véhiculer une crainte féroce envers les enfants âgés entre 10 et 12 ans.', 'cible.jpg', 1, '9.00', '2020-04-21 19:08:53.156000', NULL, 2),
        (3, 'ceci-nest-pas-un-chanteur-belge', 'Ceci n\'est pas un chanteur belge', 'Non peut-être ?! Entre Magritte (pour le surréalisme comique) et Maigret (pour le réalisme mélancolique), ce dixième opus semalien propose quatorze nouvelles chansons mêlées à de petits textes humoristiques et à quelques fortes images poétiques.', 'claudebelgesaison220.jpg', 1, '5.50', '2020-04-21 19:08:53.189000', '2020-04-21 19:08:53.189000', NULL),
        (4, 'manneke', 'Manneke… !', 'A tour de rôle, Pierre se joue de ses oncles, tantes, grands-parents et surtout de sa mère.', 'wayburn.jpg', 1, '10.50', '2020-04-21 19:09:02.426000', '2020-04-21 19:09:02.426000', 3),
        (5, 'example', 'Example Show', 'Description of the example show', 'example.jpg', 1, '8.00', '2024-04-06 12:00:00', NULL, 1),
        (6, 'another-one', 'Another Show', 'Description of another show', 'another.jpg', 1, '7.50', '2024-04-06 12:00:00', NULL, 2),
        (7, 'funny-comedy', 'Funny Comedy', 'Description of the funny comedy show', 'funny.jpg', 1, '6.00', '2024-04-06 12:00:00', NULL, 1),
        (8, 'drama-theatre', 'Drama Theatre', 'Description of the drama theatre show', 'drama.jpg', 1, '10.00', '2024-04-06 12:00:00', NULL, 3),
        (9, 'musical-night', 'Musical Night', 'Description of the musical night show', 'musical.jpg', 1, '12.00', '2024-04-06 12:00:00', NULL, 2),
        (10, 'magic-show', 'Magic Show', 'Description of the magic show', 'magic.jpg', 1, '15.00', '2024-04-06 12:00:00', NULL, 1);
