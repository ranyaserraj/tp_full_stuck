# Spring Boot + React Full Stack Application

Application full-stack de gestion de voitures avec Spring Boot, React, MariaDB, Prometheus et Grafana.

## Architecture
- **Backend**: Spring Boot 3.3.5 + Spring Data REST + JPA + Lombok + Spring Security + Actuator
- **Frontend**: React 18 + React Bootstrap + React Router + Axios + Font Awesome
- **Base de données**: MariaDB 11.0
- **Monitoring**: Prometheus + Grafana
- **Conteneurisation**: Docker + Docker Compose

## Démarrage rapide
```bash
docker-compose up -d --build
```

## Accès aux services
- **Frontend**: http://localhost:3000
- **Backend API**: http://localhost:8080/voitures
- **Swagger UI**: http://localhost:8080/swagger-ui.html
- **Prometheus**: http://localhost:9090
- **Grafana**: http://localhost:3001 (admin/admin)
- **MariaDB**: localhost:3306 (root/ranyaa)

## Fonctionnalités
- CRUD complet des voitures (Ajouter, Modifier, Lister, Supprimer)
- Relation ManyToOne/OneToMany (Voiture ↔ Propriétaire)
- API REST sécurisée avec Spring Security
- Documentation OpenAPI / Swagger
- Métriques et monitoring avec Prometheus et Grafana
- Dashboards Grafana prédéfinis (CPU, Mémoire, HTTP, Base de données)

## Technologies
**Backend**: Java 17, Maven, Spring Boot, Hibernate, MariaDB  
**Frontend**: React, Bootstrap, Axios  
**DevOps**: Docker, Docker Compose, Nginx  
**Monitoring**: Prometheus, Grafana, Micrometer

