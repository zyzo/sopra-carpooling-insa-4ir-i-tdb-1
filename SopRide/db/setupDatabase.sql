
-- Create database sopra + mysql user account 
CREATE DATABASE soprideshare DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
CREATE USER 'sopra'@'localhost' IDENTIFIED BY 'carpool';
GRANT ALL ON soprideshare.* TO 'sopra'@'localhost' IDENTIFIED BY 'carpool';
