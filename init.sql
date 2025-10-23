-- Script d'initialisation de la base de données
-- Ce script est exécuté automatiquement au démarrage du conteneur MariaDB

-- Créer la base de données si elle n'existe pas (normalement créée par MYSQL_DATABASE)
CREATE DATABASE IF NOT EXISTS compagnie CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

-- Utiliser la base de données
USE compagnie;

-- Les tables seront créées automatiquement par Spring Boot avec Hibernate
-- Ce fichier peut être utilisé pour des configurations supplémentaires si nécessaire

SELECT 'Base de données compagnie initialisée avec succès!' AS Message;

