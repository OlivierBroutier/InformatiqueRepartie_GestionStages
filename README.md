# Projet de gestion de stages

## Installation du projet

Ouvrez les 2 projets séparément (API, webapp).



### Base de données

Importer le fichier _HUA_BROUTIER_stages.sql_ dans PhpMyAdmin. Le script créé automatiquement la base de données ainsi que l'utilisateur qui s'y connecte.



### Front

Au sein du projet *webapp*, exécutez la commande suivante pour installer les dépendances d

```bash
# Installation des dépendances
npm install
```

Par défaut, IntelliJ crée une configuration pour lancer l'application en cliquant sur le bouton Run en haut à droite. Si la configuration n'existe pas, exécutez à la place la commande :

```bash
# Lancement du front
npm run start
```



### API

Au sein du projet *API*, ouvrir l'onglet _Maven_ tout à droite dans IntelliJ, en vertical, et cliquer sur le bouton de reload des projets pour installer les dépendances.
Par défaut, IntelliJ crée une configuration pour lancer l'application en cliquant sur le bouton Run en haut à droite. Si la configuration n'existe pas, exécutez à la place la commande :

```bash
# Lancement de l'API
./mvnw spring-boot:run
```





### Utilisation de l'application

Une fois le front et le back lancés, l'application est disponible à l'adresse suivante :
http://localhost:4200
