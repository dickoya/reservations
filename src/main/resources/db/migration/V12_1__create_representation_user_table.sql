/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  fotso
 * Created: 15 févr. 2024
 */

CREATE TABLE `representations_users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `representation_id` int(11) NOT NULL,
  `number_of_place` int(11) NOT NULL,
  `is_paid` bool NOT NULL default false,
  PRIMARY KEY(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Index pour la table `reservations`
--
ALTER TABLE `representations_users`
  ADD KEY `user_id` (`user_id`);

ALTER TABLE `representations_users`
  ADD KEY `representation_id` (`representation_id`);

--
-- Contraintes pour la table `reservations`
--
ALTER TABLE `representations_users`
  ADD CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON UPDATE CASCADE ON DELETE RESTRICT;

ALTER TABLE `representations_users`
  ADD CONSTRAINT `representation_id` FOREIGN KEY (`representation_id`) REFERENCES `representations` (`id`) ON UPDATE CASCADE ON DELETE RESTRICT;

ALTER TABLE `representations_users`
    ADD KEY `places` (`number_of_place`);

