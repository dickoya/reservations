/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  fotso
 * Created: 13 févr. 2024
 */

INSERT INTO `representations` (`id`, `show_id`, `location_id`, `when`, `placeAvailable`)
VALUES
        (1, 1, 1, '2012-10-12 13:30', 100),
        (2, 1, 2, '2012-10-12 20:30', 50),
        (3, 2, NULL, '2012-10-02 20:30', 15),
        (4, 3, NULL, '2012-10-16 20:30', 30),
        (5, 4, NULL, '2012-10-20 18:00', 80),
        (6, 5, NULL, '2012-11-05 19:00', 40),
        (7, 6, NULL, '2012-11-10 21:00', 60),
        (8, 7, NULL, '2012-11-15 19:30', 25),
        (9, 8, NULL, '2012-11-22 20:00', 70),
        (10, 9, NULL, '2012-11-30 18:30', 90);

