# Projet reservations

#### Présentation du projet

Le projet consiste à informatiser la gestion des réservations de spectacles d’une société de production. Celle-ci gère un catalogue reprenant des spectacles, leurs auteurs et leurs metteurs en scènes, les comédiens, ainsi que les lieux et les dates de représentations.

L’internaute pourra consulter librement le catalogue des spectacles affichant le lieu et les prochaines dates de représentation.

Il pourra effectuer des recherches, des tris et des filtres à travers les pages du catalogue.

Le membre pourra réserver des places pour une représentation d’un spectacle, consulter la liste de ses réservations et modifier ses données de profil.

L’administrateur pourra gérer son catalogue à travers un back-office sécurisé. Par exemple, il pourra ajouter, modifier et supprimer un spectacle manuellement, importer/exporter des données au format CSV, mais aussi mettre à jour la liste des spectacles grâce aux nouveautés publiées par un Web service tiers.

À son tour, l’application devra produire d’une part son propre Web service (une API authentifiée avec système d’affiliation), d’autre part un flux RSS (par exemple, la liste des prochaines représentations).


### API    
Voici un exemple simple d'interaction avec une API RESTful :

Pour récupérer une liste d'utilisateurs : GET /users
Pour récupérer un utilisateur spécifique : GET /users/{id}
Pour créer un nouvel utilisateur : POST /users
Pour mettre à jour un utilisateur existant : PUT /users/{id}
Pour supprimer un utilisateur : DELETE /users/{id}



### Commit majeur : 
Date: 17/03/2024
J’ai apporté des modifications au projet 
afin de le rendre plus accessible à tous les membres du groupe
