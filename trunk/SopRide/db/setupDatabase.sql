-- Create database sopra + mysql user account 
CREATE DATABASE sopride DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
CREATE USER 'sopra'@'localhost' IDENTIFIED BY 'carpool';
GRANT ALL ON sopride.* TO 'sopra'@'localhost' IDENTIFIED BY 'carpool';

CREATE TABLE sopride.address (
  idAddress int(11) NOT NULL,
  postcode int(11) NOT NULL,
  city varchar(50) NOT NULL,
  street varchar(50) NOT NULL,
  PRIMARY KEY (idAddress)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



CREATE TABLE sopride.car_pooling_infos (
  id_carpooling_infos int(11) NOT NULL,
  home int(11) NOT NULL,
  car_pooling_workplace int(11) NOT NULL,
  morning_hour time NOT NULL,
  night_hour time NOT NULL,
  days int(11) NOT NULL,
  notify tinyint(1) NOT NULL,
  driver tinyint(1) NOT NULL,
  PRIMARY KEY (id_carpooling_infos)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



CREATE TABLE sopride.users (
  Id int(11) NOT NULL,
  email char(50) NOT NULL,
  password char(30) NOT NULL,
  last_name char(30) NOT NULL,
  first_name char(30) NOT NULL,
  phone int(11) NOT NULL,
  admin tinyint(1) NOT NULL,
  number_connection int(11) NOT NULL,
  last_connected_date datetime NOT NULL,
  id_car_pooling_infos int(11) NOT NULL,
  PRIMARY KEY (Id),
  UNIQUE KEY email (email),
  KEY password (password),
  KEY id_car_pooling_infos (id_car_pooling_infos)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




CREATE TABLE sopride.workingdays (
  id_workingdays int(11) NOT NULL,
  lundi tinyint(1) NOT NULL,
  mardi tinyint(1) NOT NULL,
  mercredi tinyint(1) NOT NULL,
  jeudi tinyint(1) NOT NULL,
  vendredi tinyint(1) NOT NULL,
  samedi tinyint(1) NOT NULL,
  dimanche tinyint(1) NOT NULL,
  PRIMARY KEY (id_workingdays)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE sopride.workplaces (
  workplace_name int(11) NOT NULL,
  PRIMARY KEY (workplace_name)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


