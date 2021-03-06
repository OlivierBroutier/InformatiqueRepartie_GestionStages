-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : ven. 28 jan. 2022 à 22:15
-- Version du serveur : 10.4.21-MariaDB
-- Version de PHP : 7.3.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `hua_broutier_geststages`
--

DROP DATABASE IF EXISTS hua_broutier_geststages;
DROP USER IF EXISTS 'hua_broutier_usergs'@'%';

CREATE DATABASE hua_broutier_geststages ;
USE hua_broutier_geststages ;

CREATE USER 'hua_broutier_usergs'@'%' IDENTIFIED BY 'mdpGS';
GRANT ALL PRIVILEGES ON hua_broutier_geststages.* TO 'hua_broutier_usergs'@'%';

-- --------------------------------------------------------

--
-- Structure de la table `classe`
--

CREATE TABLE `classe` (
  `num_classe` int(32) NOT NULL,
  `nom_classe` varchar(128) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `classe`
--

INSERT INTO `classe` (`num_classe`, `nom_classe`) VALUES
(1, 'SIO1-SLAM'),
(2, 'SIO2-SLAM'),
(3, 'CG1'),
(4, 'CG2'),
(5, 'AM1'),
(6, 'AM2'),
(7, 'NRC1'),
(8, 'NRC2'),
(9, 'SN1'),
(10, 'SN2'),
(11, 'SIO1-SISR'),
(12, 'SIO2-SISR');

-- --------------------------------------------------------

--
-- Structure de la table `entreprise`
--

CREATE TABLE `entreprise` (
  `num_entreprise` int(32) NOT NULL,
  `raison_sociale` varchar(128) NOT NULL,
  `nom_contact` varchar(128) DEFAULT NULL,
  `nom_resp` varchar(128) DEFAULT NULL,
  `rue_entreprise` varchar(128) DEFAULT NULL,
  `cp_entreprise` int(32) DEFAULT NULL,
  `ville_entreprise` varchar(128) NOT NULL,
  `tel_entreprise` varchar(32) DEFAULT NULL,
  `fax_entreprise` varchar(32) DEFAULT NULL,
  `email` varchar(128) DEFAULT NULL,
  `observation` text DEFAULT NULL,
  `site_entreprise` varchar(128) DEFAULT NULL,
  `niveau` varchar(32) NOT NULL,
  `en_activite` tinyint(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `entreprise`
--

INSERT INTO `entreprise` (`num_entreprise`, `raison_sociale`, `nom_contact`, `nom_resp`, `rue_entreprise`, `cp_entreprise`, `ville_entreprise`, `tel_entreprise`, `fax_entreprise`, `email`, `observation`, `site_entreprise`, `niveau`, `en_activite`) VALUES
(1, 'Webzine Maker (Campusplex)', 'Antoine Dupont', 'Antoine Dupont', '12 Rue Général Fiorella', 20000, 'Ajaccio', '01 02 03 04 05', '01 02 03 04 05', 'contact@infos.fr', '', 'http://www.wmaker.net/', 'BAC+1/BAC+2', 1),
(2, 'DuoApps (Campusplex)', 'Bernard Jean', 'Bernard Jean', '12 Rue Général Fiorella', 20000, 'Ajaccio', '01 02 03 04 05', '01 02 03 04 05', 'contact@infos.fr', '', 'http://www.duoapps.com/', 'BAC+1/BAC+2', 1),
(3, 'Ollandini', 'Etienne Jacques', 'Gilbert Durand', '1 Rue Paul Colonna d\'Istria', 20000, 'Ajaccio', '01 02 03 04 05', '01 02 03 04 05', 'contact@infos.fr', '', 'http://www.ollandini.fr/', 'BAC+2', 1),
(4, 'Conseil Départemental de la Corse du Sud', 'Juliette André', 'Juliette André', '4 Cours Napoléon', 20183, 'Ajaccio', '01 02 03 04 05', '01 02 03 04 05', 'contact@infos.fr', '', 'http://www.cg-corsedusud.fr', 'BAC+1/BAC+2', 1),
(5, 'Communauté d\'Agglomération du Pays Ajaccien (CAPA)', 'Pierre Paul', 'Pierre Paul', '18 rue Comte de Marbeuf', 20000, 'Ajaccio', '01 02 03 04 05', '01 02 03 04 05', 'contact@infos.fr', '', 'http://www.ca-ajaccien.fr/', 'BAC+1/BAC+2', 1),
(6, 'Centre Hospitalier Miséricorde', 'Gerard Blanc', '', 'Av Impératrice Eugénie', 20303, 'Ajaccio', '01 02 03 04 05', '01 02 03 04 05', 'contact@infos.fr', '', '', 'Bac+1/Bac+2', 1),
(7, 'IPC - Informatique Professionnelle Corse', 'Elisabeth Dubreuil', 'Elisabeth Dubreuil', 'Parc San Lazaro - Av Napoléon III', 20000, 'Ajaccio', '01 02 03 04 05', '01 02 03 04 05', 'contact@infos.fr', '', 'http://www.ipc-corse.com', 'Bac+1/Bac+2', 1),
(8, 'La Poste - Centre financier d\'Ajaccio', 'Pierre Roger', '', '22 avenue du Colonel Colonna d\'Ornano', 20090, 'Ajaccio', '01 02 03 04 05', '01 02 03 04 05', 'contact@infos.fr', '', '', 'BAC+1/BAC+2', 1),
(9, 'Conseil Départemental de la Corse du Sud', 'Jacques Antoine', '', '8 Cours général Leclerc', 20000, 'Ajaccio', '01 02 03 04 05', '01 02 03 04 05', 'contact@infos.fr', '', 'http://www.cg-corsedusud.fr', 'BAC+1', 1),
(10, 'IRA de Bastia', 'Jean Lurat', 'Jean Lurat', 'Quai des Martyrs de la Libération', 20200, 'Bastia', '01 02 03 04 05', '01 02 03 04 05', 'contact@infos.fr', '', 'https://www.ira-bastia.fr', 'BAC+1/BAC+2', 1),
(11, 'ARS - Agence Régionale de la Santé', 'Marie Gibe', '', 'Route Saint-Joseph', 20090, 'Ajaccio', '01 02 03 04 05', '01 02 03 04 05', 'contact@infos.fr', '', 'http://www.ars.corse.sante.fr/Internet.corse.0.html', 'BAC+1/BAC+2', 1),
(12, 'Lycée Montesoro', 'Alexandre Aed', '', 'rue de la 4éme DMM', 20200, 'Bastia', '01 02 03 04 05', '01 02 03 04 05', 'contact@infos.fr', '', '', 'BAC+1/BAC+2', 1),
(13, 'Rectorat de Corse', 'Paule André', 'Le Recteur', 'Bd Pascal Rossini', 20192, 'Ajaccio', '01 02 03 04 05', '01 02 03 04 05', 'contact@infos.fr', '', 'http://www.ac-corse.fr', 'BAC+1/BAC+2', 1),
(14, 'EDF - SEI Centre de Corse', 'Hugo Milau', '', '2 Avenue Impératrice Eugénie', 20000, 'Ajaccio', '01 02 03 04 05', '01 02 03 04 05', 'contact@infos.fr', '', '', 'BAC+1/BAC+2', 1),
(15, 'France 3 Corse Via Stella', 'Jean Tele', '', '8 Rue André Touranjon', 20700, 'Ajaccio', '01 02 03 04 05', '01 02 03 04 05', 'contact@infos.fr', '', '', 'BAC+1/BAC+2', 1),
(16, 'CCI  Corse du Sud', 'Sophie Bato', '', 'Gare maritime', 20000, 'Ajaccio', '01 02 03 04 05', '01 02 03 04 05', 'contact@infos.fr', '', 'http://www.2a.cci.fr', 'BAC+2', 1),
(17, 'Conseil Départemental de la Corse du Sud', 'Albert Dupont', 'Edith Robe', '8 Cours général Leclerc', 20000, 'Ajaccio', '01 02 03 04 05', '01 02 03 04 05', 'contact@infos.fr', '', 'http://www.cg-corsedusud.fr', 'BAC+2', 1),
(18, 'SARL OCTAEDRA', 'Julie Resp', 'Julie Resp', 'Route du Vazzio pont du Ricanto', 20090, 'Ajaccio', '01 02 03 04 05', '01 02 03 04 05', 'contact@infos.fr', '', 'http://www.aria-tourisme.com', 'BAC+1/BAC+2', 1),
(19, 'ESI-DGFIP d\'Ajaccio', 'Didier Tresor', '', 'Immeuble Castellani Saint-Joseph', 20090, 'Ajaccio', '01 02 03 04 05', '01 02 03 04 05', 'contact@infos.fr', '', '', 'BAC+1/BAC+2', 1),
(20, 'Rocca Transport', 'Bruno Trans', '', 'ZI Baleone', 20501, 'Ajaccio', '01 02 03 04 05', '01 02 03 04 05', 'contact@infos.fr', '', 'http://www.rocca-transports.fr', 'BAC+1/BAC+2', 1),
(21, 'EDF Corse', 'Christophe Elec', '', '2 Avenue Impératrice', 20174, 'Ajaccio', '01 02 03 04 05', '01 02 03 04 05', 'contact@infos.fr', '', '', 'BAC+1', 1),
(22, 'PIC Informatique', 'Paul Pic', 'Paul Pic', 'Immeuble LOGOS, Avenue du mont Thabor', 20000, 'Ajaccio', '01 02 03 04 05', '01 02 03 04 05', 'contact@infos.fr', '', '', 'BAC+1', 1),
(23, 'Servitec Calvi', 'Pierre Henriet', '', 'Lieu-Dit Campo Longo, Route de Calenzana', 20260, 'Calvi', '01 02 03 04 05', '01 02 03 04 05', 'contact@infos.fr', '', '', 'BAC+1', 1),
(24, 'ARS - Agence Régionale de la Santé', 'Albert Mirou', '', 'Route Saint-Joseph', 20000, 'Ajaccio', '01 02 03 04 05', '01 02 03 04 05', 'contact@infos.fr', '', 'http://www.ars.corse.sante.fr/Internet.corse.0.html', 'BAC+1', 1),
(25, 'Crédit Agricole', 'Paul Paul', '', '1 Avenue Napoléon III', 20090, 'Ajaccio', '01 02 03 04 05', '01 02 03 04 05', 'contact@infos.fr', '', '', 'BAC+1/BAC+2', 1),
(26, 'Raffalli Travaux Publics', 'Lucien Turin', '', 'Zone Industrielle Caldaniccia', 20167, 'Sarrola-Carcopino', '01 02 03 04 05', '01 02 03 04 05', 'contact@infos.fr', '', '', 'BAC+1/BAC+2', 1),
(27, 'Centre Hospitalier de Bastia', 'Michel Oliver', '', 'Bastia', 20600, 'Bastia', '01 02 03 04 05', '01 02 03 04 05', 'contact@infos.fr', '', 'http://www.ch-bastia.fr/', 'BAC+1/BAC+2', 1),
(28, 'CTC - Collectivité Territoriale de Corse', 'Pierre Valert', '', 'Service Recherche 22 cours Grandval', 20187, 'Ajaccio', '01 02 03 04 05', '01 02 03 04 05', 'contact@infos.fr', '', 'http://www.corse.fr', 'BAC+1', 1),
(29, 'CTC - Collectivité Territoriale de Corse', 'Lucie Dupond', '', 'Service SIG - 22 cours Grandval', 20000, 'Ajaccio', '01 02 03 04 05', '01 02 03 04 05', 'contact@infos.fr', '', 'http://www.corse.fr', 'BAC+1/BAC+2', 1),
(30, 'CTC - Collectivité Territoriale de Corse', 'Jean-Pierre Moulin', '', 'DSI - 22 cours Grandval', 20000, 'Ajaccio', '01 02 03 04 05', '01 02 03 04 05', 'contact@infos.fr', '', 'http://www.corse.fr', 'BAC+1/BAC+2', 1),
(31, 'GIRTEC', 'Louise Map', '', '28 cours Grandval', 20000, 'Ajaccio', '01 02 03 04 05', '01 02 03 04 05', 'contact@infos.fr', '', 'http://www.cg-corsedusud.fr/collectivite-departementale/ses-partenaires/le-girtec/', 'BAC+1/BAC+2', 1),
(32, 'SAGES Informatique', 'Alain Ged', '', 'Lieu-dit Pernicaggio, ZA de la Caldaniccia', 20167, 'Sarrola-Carcopino', '01 02 03 04 05', '01 02 03 04 05', 'contact@infos.fr', '', 'http://www.sages-informatique.com', 'BAC+1/BAC+2', 1),
(33, 'Nextiraone', 'Edouard Network', '', 'Chemin de Pietralba', 20090, 'Ajaccio', '01 02 03 04 05', '01 02 03 04 05', 'contact@infos.fr', '', 'http://www.nextiraone.fr/fr/home', 'BAC+1/BAC+2', 1),
(44, 'Julie HUA', 'Julie HUA', 'Julie HUA', 'CSDV', 69200, 'Vénissieux', '06 16 62 23 04', 'VD', 'Juliehua11@yahoo.com', 'VD', 'VD', 'VD', 1);

-- --------------------------------------------------------

--
-- Structure de la table `etudiant`
--

CREATE TABLE `etudiant` (
  `num_etudiant` int(32) NOT NULL,
  `nom_etudiant` varchar(64) NOT NULL,
  `prenom_etudiant` varchar(64) NOT NULL,
  `annee_obtention` date DEFAULT NULL,
  `login` varchar(8) NOT NULL,
  `mdp` varchar(30) NOT NULL,
  `num_classe` int(32) NOT NULL,
  `en_activite` tinyint(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `etudiant`
--

INSERT INTO `etudiant` (`num_etudiant`, `nom_etudiant`, `prenom_etudiant`, `annee_obtention`, `login`, `mdp`, `num_classe`, `en_activite`) VALUES
(8, 'Bentot', 'Pascal', NULL, 'benpas01', 'benpas01', 1, 1),
(11, 'Tusseau', 'Louis', NULL, 'tuslou01', 'tuslou01', 2, 1),
(12, 'Finck', 'Jacques', NULL, 'finjac01', 'finjac01', 1, 1),
(14, 'Andre', 'David', NULL, 'anddav01', 'anddav01', 2, 1),
(15, 'Bedos', 'Christian', NULL, 'bedchr01', 'bedchr01', 2, 1),
(16, 'Cadic', 'Eric', NULL, 'caderi01', 'caderi01', 3, 1),
(17, 'Desmarquest', 'Nathalie', NULL, 'desnat01', 'desnat01', 3, 1),
(18, 'Desnost', 'Pierre', NULL, 'despie01', 'despie01', 4, 1),
(19, 'Eynde', 'Valérie', NULL, 'eynval01', 'eynval01', 4, 1),
(20, 'Frémont', 'Fernande', NULL, 'frefer01', 'frefer01', 5, 1),
(21, 'Guest', 'Alain', NULL, 'gueala01', 'gueala01', 5, 1),
(22, 'Bioret', 'Luc', NULL, 'bioluc01', 'bioluc01', 6, 1),
(23, 'Bunisset', 'Denise', NULL, 'bunden01', 'bunden01', 6, 1),
(24, 'Bunisset', 'Francis', NULL, 'bunfra01', 'bunfra01', 7, 1),
(25, 'Villechane', 'Louis', NULL, 'villou01', 'villou01', 7, 1),
(26, 'De', 'Philippe', NULL, 'de_phi01', 'de_phi01', 8, 1),
(27, 'Debelle', 'Michel', NULL, 'debmic01', 'debmic01', 8, 1),
(28, 'Debelle', 'Jeanne', NULL, 'debjea01', 'debjea01', 9, 1),
(29, 'Cottin', 'Vincenne', NULL, 'cotvin01', 'cotvin01', 9, 1),
(30, 'Charoze', 'Catherine', NULL, 'chacat01', 'chacat01', 10, 1),
(31, 'Cacheux', 'Bernard', NULL, 'cacber01', 'cacber01', 10, 1),
(32, 'Dupond', 'Jean', NULL, 'dupjea01', 'dupjea01', 11, 1),
(33, 'Durand', 'Simon', NULL, 'dursim01', 'dursim01', 11, 1),
(34, 'Leroy', 'Edouard', NULL, 'leredo01', 'leredo01', 12, 1),
(35, 'Duval', 'Eric', NULL, 'duveri01', 'duveri01', 12, 1);

-- --------------------------------------------------------

--
-- Structure de la table `message`
--

CREATE TABLE `message` (
  `num_message` int(32) NOT NULL,
  `num_expediteur_etudiant` int(32) DEFAULT NULL,
  `num_expediteur_prof` int(32) DEFAULT NULL,
  `sujet` text NOT NULL,
  `message` text NOT NULL,
  `supprime` tinyint(1) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `message`
--

INSERT INTO `message` (`num_message`, `num_expediteur_etudiant`, `num_expediteur_prof`, `sujet`, `message`, `supprime`) VALUES
(1, NULL, 1, 'Recherche de stage', 'Please need help need stage', 0),
(2, 8, NULL, ':hj', ':h', 0),
(3, NULL, 1, 'Pierre ton stage', 'Bonjour Pierre, \n\nAs-tu envoyé ta demande pour l\'entreprise Devvvv ? \n\n', 0),
(4, NULL, 1, 'a tous ', 'bonjour a vous les etudiants', 0),
(5, 8, NULL, 'a tous les profs', 'bonjour, c\'est Pascal Bentot. Je vous signale que mon stage a été trouvé', 0);

-- --------------------------------------------------------

--
-- Structure de la table `message_etudiant`
--

CREATE TABLE `message_etudiant` (
  `num_message` int(32) NOT NULL,
  `num_etudiant` int(32) NOT NULL,
  `lu` tinyint(1) DEFAULT 0,
  `supprime` tinyint(1) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `message_etudiant`
--

INSERT INTO `message_etudiant` (`num_message`, `num_etudiant`, `lu`, `supprime`) VALUES
(1, 8, 0, 1),
(3, 18, 0, 0),
(4, 8, 0, 0),
(4, 11, 0, 0),
(4, 12, 0, 0),
(4, 14, 0, 0),
(4, 15, 0, 0),
(4, 16, 0, 0),
(4, 17, 0, 0),
(4, 18, 0, 0),
(4, 19, 0, 0),
(4, 20, 0, 0),
(4, 21, 0, 0),
(4, 22, 0, 0),
(4, 23, 0, 0),
(4, 24, 0, 0),
(4, 25, 0, 0),
(4, 26, 0, 0),
(4, 27, 0, 0),
(4, 28, 0, 0),
(4, 29, 0, 0),
(4, 30, 0, 0),
(4, 31, 0, 0),
(4, 32, 0, 0),
(4, 33, 0, 0),
(4, 34, 0, 0),
(4, 35, 0, 0);

-- --------------------------------------------------------

--
-- Structure de la table `message_professeur`
--

CREATE TABLE `message_professeur` (
  `num_message` int(32) NOT NULL,
  `num_prof` int(32) NOT NULL,
  `lu` tinyint(1) DEFAULT 0,
  `supprime` tinyint(1) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `message_professeur`
--

INSERT INTO `message_professeur` (`num_message`, `num_prof`, `lu`, `supprime`) VALUES
(1, 2, 0, 0),
(2, 3, 0, 0),
(5, 1, 0, 0),
(5, 2, 0, 0),
(5, 3, 0, 0),
(5, 5, 0, 0),
(5, 6, 0, 0),
(5, 7, 0, 0),
(5, 8, 0, 0),
(5, 9, 0, 0),
(5, 10, 0, 0),
(5, 11, 0, 0),
(5, 12, 0, 0),
(5, 13, 0, 0),
(5, 14, 0, 0),
(5, 15, 0, 0),
(5, 16, 0, 0);

-- --------------------------------------------------------

--
-- Structure de la table `mission`
--

CREATE TABLE `mission` (
  `num_mission` int(32) NOT NULL,
  `libelle` varchar(128) NOT NULL,
  `num_stage` int(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `mission`
--

INSERT INTO `mission` (`num_mission`, `libelle`, `num_stage`) VALUES
(1, 'Découverte de l\'entreprise', 1),
(2, 'Prise en main de l\'outil de versioning', 1),
(4, 'Découverte de l\'entreprise', 3),
(5, 'Analyse et mise à jour de la documentation technique de l\'application \"appProj\"', 3),
(6, 'Découverte de l\'entreprise', 5),
(7, 'Prise en main de l\'API \"comJSON\"', 5),
(9, 'mj', 9),
(10, 'Mission a ', 10),
(11, 'mission 1', 11),
(12, 'missio, 2', 11);

-- --------------------------------------------------------

--
-- Structure de la table `professeur`
--

CREATE TABLE `professeur` (
  `num_prof` int(32) NOT NULL,
  `nom_prof` varchar(64) NOT NULL,
  `prenom_prof` varchar(64) NOT NULL,
  `login` varchar(8) NOT NULL,
  `mdp` varchar(8) NOT NULL,
  `email` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `professeur`
--

INSERT INTO `professeur` (`num_prof`, `nom_prof`, `prenom_prof`, `login`, `mdp`, `email`) VALUES
(1, 'Shavert', 'Anne-Lucie', 'shaann01', 'shaann01', 'shaann01@llb.fr'),
(2, 'Gaudin', 'Jules', 'gaujul01', 'gaujul01', 'gaujul01@llb.fr'),
(3, 'Zerbib', 'Gilles', 'zergil01', 'zergil01', 'zergil01@llb.fr'),
(5, 'Di Conota', 'Prosper', 'di_pro01', 'di_pro01', 'di_pro01@llb.fr'),
(6, 'Ferdinand', 'Anne-Lucie', 'ferann01', 'ferann01', 'ferann01@llb.fr'),
(7, 'Chamois', 'Andrew', 'chaand01', 'chaand01', 'chaand01@llb.fr'),
(8, 'Lirevien', 'John', 'lirjoh01', 'lirjoh01', 'lirjoh01@llb.fr'),
(9, 'Fortin', 'François', 'forfra01', 'forfra01', 'forfra01@llb.fr'),
(10, 'Segura', 'Irénée', 'segire01', 'segire01', 'segire01@llb.fr'),
(11, 'Pistache', 'Christophe', 'pischr01', 'pischr01', 'pischr01@llb.fr'),
(12, 'Cherioux', 'Aurèle', 'cheaur01', 'cheaur01', 'cheaur01@llb.fr'),
(13, 'Certifat', 'Alice', 'cerali01', 'cerali01', 'cerali01@llb.fr'),
(14, 'Pastor', 'Camille', 'pascam01', 'pascam01', 'pascam01@llb.fr'),
(15, 'Hansbern', 'Johnny', 'hanjoh01', 'hanjoh01', 'hanjoh01@llb.fr'),
(16, 'Billahian', 'Andrée', 'biland01', 'biland01', 'biland01@llb.fr');

-- --------------------------------------------------------

--
-- Structure de la table `prof_classe`
--

CREATE TABLE `prof_classe` (
  `num_prof` int(32) NOT NULL,
  `num_classe` int(32) NOT NULL,
  `est_prof_principal` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `prof_classe`
--

INSERT INTO `prof_classe` (`num_prof`, `num_classe`, `est_prof_principal`) VALUES
(1, 1, 1),
(1, 2, 0),
(2, 1, 0),
(2, 2, 1),
(3, 1, 0),
(3, 2, 0),
(5, 3, 1),
(5, 4, 0),
(6, 3, 0),
(6, 4, 1),
(7, 3, 0),
(7, 4, 0),
(8, 5, 1),
(8, 6, 0),
(9, 5, 0),
(9, 6, 1),
(10, 5, 0),
(10, 6, 0),
(11, 7, 1),
(11, 8, 0),
(12, 7, 0),
(12, 8, 1),
(13, 7, 0),
(13, 8, 0),
(14, 9, 1),
(14, 10, 0),
(15, 9, 0),
(15, 10, 1),
(16, 9, 0),
(16, 10, 0);

-- --------------------------------------------------------

--
-- Structure de la table `specialite`
--

CREATE TABLE `specialite` (
  `num_spec` int(32) NOT NULL,
  `libelle` varchar(128) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `specialite`
--

INSERT INTO `specialite` (`num_spec`, `libelle`) VALUES
(1, 'SLAM'),
(2, 'SISR'),
(3, 'AM'),
(4, 'SN'),
(5, 'CG'),
(6, 'NRC');

-- --------------------------------------------------------

--
-- Structure de la table `spec_entreprise`
--

CREATE TABLE `spec_entreprise` (
  `num_entreprise` int(32) NOT NULL,
  `num_spec` int(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `spec_entreprise`
--

INSERT INTO `spec_entreprise` (`num_entreprise`, `num_spec`) VALUES
(1, 1),
(1, 2),
(2, 1),
(3, 1),
(3, 2),
(4, 1),
(5, 1),
(5, 2),
(6, 2),
(7, 2),
(8, 2),
(9, 2),
(10, 2),
(11, 2),
(12, 2),
(13, 2),
(14, 2),
(15, 1),
(16, 1),
(16, 2),
(17, 2),
(18, 1),
(19, 1),
(20, 2),
(21, 2),
(22, 1),
(23, 2),
(24, 1),
(25, 2),
(26, 1),
(27, 2),
(28, 2),
(29, 1),
(30, 2),
(31, 1),
(32, 1),
(33, 2),
(44, 4);

-- --------------------------------------------------------

--
-- Structure de la table `stage`
--

CREATE TABLE `stage` (
  `num_stage` int(32) NOT NULL,
  `debut_stage` datetime NOT NULL,
  `fin_stage` datetime NOT NULL,
  `type_stage` varchar(128) DEFAULT NULL,
  `desc_projet` text DEFAULT NULL,
  `observation_stage` text DEFAULT NULL,
  `num_etudiant` int(32) NOT NULL,
  `num_prof` int(32) NOT NULL,
  `num_entreprise` int(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `stage`
--

INSERT INTO `stage` (`num_stage`, `debut_stage`, `fin_stage`, `type_stage`, `desc_projet`, `observation_stage`, `num_etudiant`, `num_prof`, `num_entreprise`) VALUES
(1, '2015-07-13 00:00:00', '2016-08-31 00:00:00', 'alternance', 'Apprentissage sur 1 ans.</br>\r\nParticipation aux différents projets de l\'entreprise.</br>\r\nDéveloppement et maintenance de plugins.', ':k:', 8, 2, 1),
(3, '2016-01-11 00:00:00', '2016-02-19 00:00:00', 'stage', 'Mise à jour de la documentation des applications métiers de l\'entreprise.\r\nDéveloppement d\'un module d\'authentification.', '', 11, 1, 4),
(5, '2017-01-08 00:00:00', '2017-02-17 00:00:00', 'stage', 'Evolution de l\'application de gestion de projets utilisée par l\'entreprise.<br/>\r\nParticipation à l\'assistance utilisateur pour les divers logiciels développés en interne.', NULL, 11, 2, 5),
(9, '2022-01-25 00:00:00', '2022-01-31 00:00:00', 'alternance', 'k!k', 'mkj', 8, 6, 3),
(10, '2022-01-26 00:00:00', '2022-01-31 00:00:00', 'stage', 'Un stage encadré', 'pas d\'observation', 17, 9, 1),
(11, '2022-02-17 00:00:00', '2022-01-30 00:00:00', 'alternance', 'une alternance', 'qsdfg', 20, 14, 8);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `classe`
--
ALTER TABLE `classe`
  ADD PRIMARY KEY (`num_classe`);

--
-- Index pour la table `entreprise`
--
ALTER TABLE `entreprise`
  ADD PRIMARY KEY (`num_entreprise`);

--
-- Index pour la table `etudiant`
--
ALTER TABLE `etudiant`
  ADD PRIMARY KEY (`num_etudiant`),
  ADD KEY `num_classe` (`num_classe`);

--
-- Index pour la table `message`
--
ALTER TABLE `message`
  ADD PRIMARY KEY (`num_message`),
  ADD KEY `num_expediteur_etudiant` (`num_expediteur_etudiant`),
  ADD KEY `num_expediteur_prof` (`num_expediteur_prof`);

--
-- Index pour la table `message_etudiant`
--
ALTER TABLE `message_etudiant`
  ADD PRIMARY KEY (`num_message`,`num_etudiant`),
  ADD KEY `message_etudiant_ibfk_2` (`num_etudiant`);

--
-- Index pour la table `message_professeur`
--
ALTER TABLE `message_professeur`
  ADD PRIMARY KEY (`num_message`,`num_prof`),
  ADD KEY `message_prof_ibfk_2` (`num_prof`);

--
-- Index pour la table `mission`
--
ALTER TABLE `mission`
  ADD PRIMARY KEY (`num_mission`),
  ADD KEY `num_stage` (`num_stage`);

--
-- Index pour la table `professeur`
--
ALTER TABLE `professeur`
  ADD PRIMARY KEY (`num_prof`);

--
-- Index pour la table `prof_classe`
--
ALTER TABLE `prof_classe`
  ADD PRIMARY KEY (`num_prof`,`num_classe`),
  ADD KEY `num_classe` (`num_classe`);

--
-- Index pour la table `specialite`
--
ALTER TABLE `specialite`
  ADD PRIMARY KEY (`num_spec`);

--
-- Index pour la table `spec_entreprise`
--
ALTER TABLE `spec_entreprise`
  ADD PRIMARY KEY (`num_entreprise`,`num_spec`),
  ADD KEY `num_spec` (`num_spec`);

--
-- Index pour la table `stage`
--
ALTER TABLE `stage`
  ADD PRIMARY KEY (`num_stage`),
  ADD KEY `num_etudiant` (`num_etudiant`),
  ADD KEY `num_prof` (`num_prof`),
  ADD KEY `num_entreprise` (`num_entreprise`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `classe`
--
ALTER TABLE `classe`
  MODIFY `num_classe` int(32) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT pour la table `entreprise`
--
ALTER TABLE `entreprise`
  MODIFY `num_entreprise` int(32) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=45;

--
-- AUTO_INCREMENT pour la table `etudiant`
--
ALTER TABLE `etudiant`
  MODIFY `num_etudiant` int(32) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;

--
-- AUTO_INCREMENT pour la table `message`
--
ALTER TABLE `message`
  MODIFY `num_message` int(32) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `mission`
--
ALTER TABLE `mission`
  MODIFY `num_mission` int(32) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT pour la table `professeur`
--
ALTER TABLE `professeur`
  MODIFY `num_prof` int(32) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT pour la table `specialite`
--
ALTER TABLE `specialite`
  MODIFY `num_spec` int(32) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT pour la table `stage`
--
ALTER TABLE `stage`
  MODIFY `num_stage` int(32) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `etudiant`
--
ALTER TABLE `etudiant`
  ADD CONSTRAINT `etudiant_ibfk_1` FOREIGN KEY (`num_classe`) REFERENCES `classe` (`num_classe`);

--
-- Contraintes pour la table `message`
--
ALTER TABLE `message`
  ADD CONSTRAINT `message_ibfk_1` FOREIGN KEY (`num_expediteur_etudiant`) REFERENCES `etudiant` (`num_etudiant`),
  ADD CONSTRAINT `message_ibfk_2` FOREIGN KEY (`num_expediteur_prof`) REFERENCES `professeur` (`num_prof`);

--
-- Contraintes pour la table `message_etudiant`
--
ALTER TABLE `message_etudiant`
  ADD CONSTRAINT `message_etudiant_ibfk_1` FOREIGN KEY (`num_message`) REFERENCES `message` (`num_message`),
  ADD CONSTRAINT `message_etudiant_ibfk_2` FOREIGN KEY (`num_etudiant`) REFERENCES `etudiant` (`num_etudiant`);

--
-- Contraintes pour la table `message_professeur`
--
ALTER TABLE `message_professeur`
  ADD CONSTRAINT `message_prof_ibfk_1` FOREIGN KEY (`num_message`) REFERENCES `message` (`num_message`),
  ADD CONSTRAINT `message_prof_ibfk_2` FOREIGN KEY (`num_prof`) REFERENCES `professeur` (`num_prof`);

--
-- Contraintes pour la table `mission`
--
ALTER TABLE `mission`
  ADD CONSTRAINT `mission_ibfk_1` FOREIGN KEY (`num_stage`) REFERENCES `stage` (`num_stage`);

--
-- Contraintes pour la table `prof_classe`
--
ALTER TABLE `prof_classe`
  ADD CONSTRAINT `prof_classe_ibfk_1` FOREIGN KEY (`num_prof`) REFERENCES `professeur` (`num_prof`),
  ADD CONSTRAINT `prof_classe_ibfk_2` FOREIGN KEY (`num_classe`) REFERENCES `classe` (`num_classe`);

--
-- Contraintes pour la table `spec_entreprise`
--
ALTER TABLE `spec_entreprise`
  ADD CONSTRAINT `spec_entreprise_ibfk_1` FOREIGN KEY (`num_entreprise`) REFERENCES `entreprise` (`num_entreprise`),
  ADD CONSTRAINT `spec_entreprise_ibfk_2` FOREIGN KEY (`num_spec`) REFERENCES `specialite` (`num_spec`);

--
-- Contraintes pour la table `stage`
--
ALTER TABLE `stage`
  ADD CONSTRAINT `stage_ibfk_1` FOREIGN KEY (`num_etudiant`) REFERENCES `etudiant` (`num_etudiant`),
  ADD CONSTRAINT `stage_ibfk_2` FOREIGN KEY (`num_prof`) REFERENCES `professeur` (`num_prof`),
  ADD CONSTRAINT `stage_ibfk_3` FOREIGN KEY (`num_entreprise`) REFERENCES `entreprise` (`num_entreprise`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
