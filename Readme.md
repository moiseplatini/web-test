# Projet Spring Boot - Gestion des Personnes et des Emplois

Ce projet est une application Spring Boot qui expose une API REST pour gérer les informations sur les personnes et leurs emplois.

## Configuration

- Java 11
- Spring Boot 2.6.3
- Base de données H2 (en mémoire)

## Installation
1. importer l'application
2. Lancer l'application : `mvn spring-boot:run`
3. le fichier data.sql contient les donnees de test

L'application sera accessible à l'adresse http://localhost:8081.

## Endpoints

- Sauvegardent une nouvelle personne. Attention, seules les personnes de moins de 150 ans peuvent être enregistrées. Sinon, renvoyez une erreur.
- Permettent d'ajouter un emploi à une personne avec une date de début et de fin d'emploi. Pour le poste actuellement occupé, la date de fin n'est pas obligatoire. Une personne peut avoir plusieurs emplois aux dates qui se chevauchent.
- Renvoient toutes les personnes enregistrées par ordre alphabétique, et indiquent également leur âge et leur(s) emploi(s) actuel(s).
- Renvoient toutes les personnes ayant travaillé pour une entreprise donnée.
- Renvoient tous les emplois d'une personne entre deux plages de dates.


Manquement:

les tests unitaire et les tests d'itegration n'ont pas ete implemente