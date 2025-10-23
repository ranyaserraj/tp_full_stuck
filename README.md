# Spring Boot + React Full Stack Application

Application full-stack de gestion de voitures avec Spring Boot, React, MariaDB, Prometheus et Grafana.

## Architecture
- **Backend**: Spring Boot 3.3.5 + Spring Data REST + JPA + Lombok + Spring Security + Actuator
- **Frontend**: React 18 + React Bootstrap + React Router + Axios + Font Awesome
- **Base de données**: MariaDB 11.0
- **Monitoring**: Prometheus + Grafana
- **Conteneurisation**: Docker + Docker Compose

## 🐳 Lancement des 5 images Docker

### Prérequis
- Docker Desktop installé et démarré
- Ports disponibles : 3000, 8080, 3306, 9090, 3001

### Démarrage rapide - Lancer tous les services
```bash
docker-compose up -d --build
```

### Commandes détaillées

#### 1. Construire et démarrer les 5 conteneurs
```bash
docker-compose up -d --build
```
Cette commande va :
- 🗄️ Créer et lancer **MariaDB** (Base de données)
- 🚀 Construire et lancer **Backend Spring Boot** (API REST)
- ⚛️ Construire et lancer **Frontend React** (Interface utilisateur)
- 📊 Lancer **Prometheus** (Collecte des métriques)
- 📈 Lancer **Grafana** (Visualisation des dashboards)

#### 2. Vérifier l'état des conteneurs
```bash
docker-compose ps
```

#### 3. Voir les logs des services
```bash
# Tous les services
docker-compose logs -f

# Un service spécifique
docker-compose logs -f backend
docker-compose logs -f frontend
docker-compose logs -f mariadb
docker-compose logs -f prometheus
docker-compose logs -f grafana
```

#### 4. Arrêter tous les services
```bash
docker-compose down
```

#### 5. Arrêter et supprimer les volumes (données)
```bash
docker-compose down -v
```

#### 6. Redémarrer un service spécifique
```bash
docker-compose restart backend
docker-compose restart frontend
```

### Les 5 conteneurs Docker

| Service | Container Name | Image | Port | Description |
|---------|---------------|-------|------|-------------|
| 🗄️ MariaDB | `springdatarest-mariadb` | `mariadb:11.0` | 3306 | Base de données relationnelle |
| 🚀 Backend | `springdatarest-backend` | Custom Build | 8080 | API REST Spring Boot |
| ⚛️ Frontend | `springdatarest-frontend` | Custom Build | 3000 | Interface React avec Nginx |
| 📊 Prometheus | `springdatarest-prometheus` | `prom/prometheus:latest` | 9090 | Collecte des métriques |
| 📈 Grafana | `springdatarest-grafana` | `grafana/grafana:latest` | 3001 | Dashboards de monitoring |

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

