/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  fotso
 * Created: 13 févr. 2024
 */

CREATE TABLE `representations` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `show_id` int(11) NOT NULL,
  `location_id` int(11) DEFAULT NULL,
  `when` datetime(6) NOT NULL,
  `placeAvailable`int(11),
 PRIMARY KEY(id)
) ENGINE=InnoDB DEFAULT CHARSET= utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Index pour la table `representations`
--
ALTER TABLE `representations`
  ADD KEY `representations_location_id_a6832141_fk_locations_id` (`location_id`);

ALTER TABLE `representations`
  ADD KEY `representations_show_id_a6832141_fk_shows_id` (`show_id`);
ALTER TABLE `representations`
    ADD KEY `representations_placeAvailable_a6832141_fk_locations_id` (`placeAvailable`);

--
-- Contraintes pour la table `shows`
--
ALTER TABLE `representations`
  ADD CONSTRAINT `representations_location_id_a6832141_fk_locations_id` FOREIGN KEY (`location_id`) REFERENCES `locations` (`id`) ON UPDATE CASCADE ON DELETE RESTRICT;

ALTER TABLE `representations`
  ADD CONSTRAINT `representations_show_id_a6832141_fk_shows_id` FOREIGN KEY (`show_id`) REFERENCES `shows` (`id`) ON UPDATE CASCADE ON DELETE RESTRICT;

