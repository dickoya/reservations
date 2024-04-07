/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  fotso
 * Created: 15 févr. 2024
 */

INSERT INTO `users` (`id`, `login`, `password`, `firstname`, `lastname`, `email`, `language`, `created_at`)
VALUES
        (1, 'bob', '', 'Bob', 'Sull', 'bob@sull.com','fr','2010-01-01 12:00:00'),
        (2, 'lana', '', 'Lana', 'Sull', 'lana@sull.com','fr','2010-01-01 12:00:00'),
        (3, 'affiliate', '', 'Affi', 'Liate', 'contact@affiliate.com','fr','2020-01-01 12:00:00'),
        (4, 'john', '', 'John', 'Doe', 'john@doe.com','en','2022-05-15 09:30:00'),
        (5, 'alice', '', 'Alice', 'Smith', 'alice@smith.com','fr','2023-08-20 14:45:00'),
        (6, 'charlie', '', 'Charlie', 'Brown', 'charlie@brown.com','nl','2021-11-10 18:20:00'),
        (7, 'emily', '', 'Emily', 'Jones', 'emily@jones.com','fr','2019-04-30 11:10:00'),
        (8, 'david', '', 'David', 'Johnson', 'david@johnson.com','en','2020-12-05 16:55:00'),
        (9, 'emma', '', 'Emma', 'Davis', 'emma@davis.com','fr','2022-02-28 08:00:00'),
        (10, 'george', '', 'George', 'Wilson', 'george@wilson.com','nl','2023-10-15 20:30:00');
