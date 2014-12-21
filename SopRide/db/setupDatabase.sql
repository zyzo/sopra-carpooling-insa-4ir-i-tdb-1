-- Create database sopra + mysql user account
-- Last updated : 21/12/2014

CREATE DATABASE sopride DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
CREATE USER 'sopra'@'localhost' IDENTIFIED BY 'carpool';
GRANT ALL ON sopride.* TO 'sopra'@'localhost' IDENTIFIED BY 'carpool';

-- Structure de la table `address`
--

CREATE TABLE IF NOT EXISTS `address` (
  `idAddress` int(11) NOT NULL AUTO_INCREMENT,
  `postcode` int(11) NOT NULL,
  `city` varchar(50) NOT NULL,
  `street` varchar(50) NOT NULL,
  PRIMARY KEY (`idAddress`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `admin`
--

CREATE TABLE IF NOT EXISTS `admin` (
  `id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `car_pooling_infos`
--

CREATE TABLE IF NOT EXISTS `car_pooling_infos` (
  `id_carpooling_infos` int(11) NOT NULL AUTO_INCREMENT,
  `home` int(11) NOT NULL,
  `car_pooling_workplace` int(11) NOT NULL,
  `morning_hour` time NOT NULL,
  `night_hour` time NOT NULL,
  `days` int(11) NOT NULL,
  `notify` char(1) NOT NULL,
  `driver` char(1) NOT NULL,
  PRIMARY KEY (`id_carpooling_infos`),
  KEY `days` (`days`),
  KEY `car_pooling_workplace` (`car_pooling_workplace`),
  KEY `home` (`home`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` char(50) NOT NULL,
  `password` char(30) NOT NULL,
  `last_name` char(30) DEFAULT NULL,
  `first_name` char(30) DEFAULT NULL,
  `phone` int(11) DEFAULT NULL,
  `number_connections` int(11) NOT NULL,
  `last_connected_date` datetime NOT NULL,
  `id_car_pooling_infos` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`),
  KEY `password` (`password`),
  KEY `id_car_pooling_infos` (`id_car_pooling_infos`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `workingdays`
--

CREATE TABLE IF NOT EXISTS `workingdays` (
  `id_workingdays` int(11) NOT NULL AUTO_INCREMENT,
  `lundi` tinyint(1) NOT NULL,
  `mardi` tinyint(1) NOT NULL,
  `mercredi` tinyint(1) NOT NULL,
  `jeudi` tinyint(1) NOT NULL,
  `vendredi` tinyint(1) NOT NULL,
  `samedi` tinyint(1) NOT NULL,
  `dimanche` tinyint(1) NOT NULL,
  PRIMARY KEY (`id_workingdays`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `workplaces`
--

CREATE TABLE IF NOT EXISTS `workplaces` (
  `workplace_name` int(11) NOT NULL,
  PRIMARY KEY (`workplace_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `admin`
--
ALTER TABLE `admin`
  ADD CONSTRAINT `userIsAdminFK` FOREIGN KEY (`id`) REFERENCES `users` (`id`) ON DELETE CASCADE;

--
-- Contraintes pour la table `car_pooling_infos`
--
ALTER TABLE `car_pooling_infos`
  ADD CONSTRAINT `car_pooling_infos_ibfk_3` FOREIGN KEY (`home`) REFERENCES `address` (`idAddress`),
  ADD CONSTRAINT `car_pooling_infos_ibfk_1` FOREIGN KEY (`car_pooling_workplace`) REFERENCES `workplaces` (`workplace_name`),
  ADD CONSTRAINT `car_pooling_infos_ibfk_2` FOREIGN KEY (`days`) REFERENCES `workingdays` (`id_workingdays`);

--
-- Contraintes pour la table `workplaces`
--
ALTER TABLE `workplaces`
  ADD CONSTRAINT `workplaces_ibfk_1` FOREIGN KEY (`workplace_name`) REFERENCES `address` (`idAddress`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
