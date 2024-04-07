/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  fotso
 * Created: 10 févr. 2024
 */

INSERT INTO `locations` (`id`, `locality_id`, `slug`, `designation`, `address`, `website`, `phone`)
VALUES
    (1, 4, 'espace-delvaux-la-venerie', 'Espace Delvaux / La Vénerie', '3 rue Gratès', 'https://www.lavenerie.be', '+32 (0)2/663.85.50'),
    (2, 1, 'dexia-art-center', 'Dexia Art Center', '50 rue de l\'Ecuyer', NULL, NULL),
    (3, 1, 'la-samaritaine', 'La Samaritaine', '16 rue de la samaritaine', 'http://www.lasamaritaine.be/', NULL),
    (4, 1, 'espace-magh', 'Espace Magh', '17 rue du Poinçon', 'http://www.espacemagh.be', '+32 (0)2/274.05.10'),
    (5, 2, 'theatre-le-public', 'Théâtre Le Public', '76A rue Braemt', 'https://theatrelepublic.be/', '+32 (0)2/223.32.08'),
    (6, 2, 'theatre-national', 'Théâtre National', '111 boulevard Emile Jacqmain', 'https://www.theatrenational.be/', '+32 (0)2/203.53.03'),
    (7, 3, 'theatre-de-la-toison-d-or', 'Théâtre de la Toison d\'Or', '396 avenue Louise', 'https://www.ttotheatre.com/', '+32 (0)2/511.33.95'),
    (8, 3, 'theatre-marni', 'Théâtre Marni', '24 rue de Vergnies', 'https://www.marni.be/', '+32 (0)2/639.09.80'),
    (9, 4, 'theatre-du-vaudeville', 'Théâtre du Vaudeville', '69 Galerie de la Reine', 'https://www.levarietes.be/', '+32 (0)2/514.47.00'),
    (10, 5, 'theatre-de-poche', 'Théâtre de Poche', '1A chemin du Gymnase', 'https://www.theatredupoche.be/', '+32 (0)2/649.17.27');

