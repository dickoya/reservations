/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  fotso
 * Created: 15 févr. 2024
 */

CREATE TABLE `representation_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `representation_id` int(11) NOT NULL,
  `places` int(11) NOT NULL,
  PRIMARY KEY(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Index pour la table `reservations`
--
ALTER TABLE `representation_user`
  ADD KEY `user_id` (`user_id`);

ALTER TABLE `representation_user`
  ADD KEY `representation_id` (`representation_id`);

--
-- Contraintes pour la table `reservations`
--
ALTER TABLE `representation_user`
  ADD CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON UPDATE CASCADE ON DELETE RESTRICT;

ALTER TABLE `representation_user`
  ADD CONSTRAINT `representation_id` FOREIGN KEY (`representation_id`) REFERENCES `representations` (`id`) ON UPDATE CASCADE ON DELETE RESTRICT;

ALTER TABLE `representation_user`
    ADD KEY `places` (`places`);

