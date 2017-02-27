CREATE DATABASE  IF NOT EXISTS `cinema` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `cinema`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: cinema
-- ------------------------------------------------------
-- Server version	5.7.16-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `surname` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (10,'as','sdfs','gasdfg@asd.pl'),(11,'','',''),(12,'','',''),(13,'','',''),(14,'','',''),(15,'Leszek','Anonimowy','sdfasd@wp.pl'),(16,'Leszek','Anonimowy','sdfasd@wp.pl');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movie`
--

DROP TABLE IF EXISTS `movie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `movie` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `country` varchar(45) DEFAULT NULL,
  `year` int(11) DEFAULT NULL,
  `category` varchar(45) DEFAULT NULL,
  `release_date` datetime DEFAULT NULL,
  `directing` varchar(100) DEFAULT NULL,
  `actors` varchar(100) DEFAULT NULL,
  `language` varchar(45) DEFAULT NULL,
  `picture_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie`
--

LOCK TABLES `movie` WRITE;
/*!40000 ALTER TABLE `movie` DISABLE KEYS */;
INSERT INTO `movie` VALUES (1,'Jak zostać kotem','Chiny,Francja',2016,'Familijny, Komedia','2016-08-16 00:00:00','Barry Sonnenfeld','Kevin Spacey, Jennifer Garner, Robbie Amell, Cheryl Hines','Dubbing PL','jak_zostac_kotem.jpg'),(2,'Siedmiu wspaniałych','USA',2016,'Akcja','2016-09-23 00:00:00','Antoine Fuqua','Denzel Washington, Chris Pratt, Ethan Hawke, Vincent D\'Onofrio','Napisy PL','siedmiu_wspanialych.jpg'),(3,'Dziewczyna z pociągu','USA',2016,'Dramat, Thriller','2016-10-07 00:00:00','Tate Taylor','Emily Blunt, Rebecca Ferguson, Laura Prepon, Luke Evans','Napisy PL','dziewczyna_z_pociagu.jpg'),(4,'Wołyń','Polska',2016,'Wojenny\n','2016-10-07 00:00:00','Wojciech Smarzowski','Michalina Łabacz, Arkadiusz Jakubik, Wasyl Wasylik, Adrian Zaremba','Napisy PL','wolyn.jpg');
/*!40000 ALTER TABLE `movie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reservation` (
  `screening_id` int(11) NOT NULL,
  `seat_id` int(11) NOT NULL,
  `customer_id` int(11) NOT NULL,
  PRIMARY KEY (`screening_id`,`seat_id`),
  KEY `screening_id_idx` (`screening_id`),
  KEY `seat_id_idx` (`seat_id`),
  KEY `customer_id_idx` (`customer_id`),
  CONSTRAINT `customer_id` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `screening_id` FOREIGN KEY (`screening_id`) REFERENCES `screening` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `seat_id` FOREIGN KEY (`seat_id`) REFERENCES `seat` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservation`
--

LOCK TABLES `reservation` WRITE;
/*!40000 ALTER TABLE `reservation` DISABLE KEYS */;
INSERT INTO `reservation` VALUES (7,87,10),(7,88,10),(1,13,11),(1,14,11),(2,28,15),(2,29,15),(8,28,15),(8,29,15);
/*!40000 ALTER TABLE `reservation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `screening`
--

DROP TABLE IF EXISTS `screening`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `screening` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date_time` datetime DEFAULT NULL,
  `movie_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `movie_id_idx` (`movie_id`),
  CONSTRAINT `movie_id` FOREIGN KEY (`movie_id`) REFERENCES `movie` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `screening`
--

LOCK TABLES `screening` WRITE;
/*!40000 ALTER TABLE `screening` DISABLE KEYS */;
INSERT INTO `screening` VALUES (1,'2016-10-27 20:00:00',1),(2,'2016-10-28 20:00:00',1),(3,'2016-10-29 18:00:00',1),(4,'2016-10-30 15:00:00',1),(5,'2016-10-27 22:00:00',2),(6,'2016-11-04 20:00:00',2),(7,'2016-10-28 22:00:00',2),(8,'2016-10-30 18:00:00',2),(9,'2016-10-29 20:00:00',3),(10,'2016-10-27 18:00:00',3),(11,'2016-10-30 22:00:00',3),(12,'2016-11-01 22:00:00',3),(13,'2016-11-03 15:00:00',4),(14,'2016-11-04 15:00:00',4),(15,'2016-11-05 20:00:00',4),(16,'2016-11-06 20:00:00',4);
/*!40000 ALTER TABLE `screening` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seat`
--

DROP TABLE IF EXISTS `seat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seat` (
  `id` int(11) NOT NULL,
  `row` int(11) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seat`
--

LOCK TABLES `seat` WRITE;
/*!40000 ALTER TABLE `seat` DISABLE KEYS */;
INSERT INTO `seat` VALUES (1,1,1),(2,1,2),(3,1,3),(4,1,4),(5,1,5),(6,1,6),(7,1,7),(8,1,8),(9,1,9),(10,1,10),(11,1,11),(12,2,1),(13,2,2),(14,2,3),(15,2,4),(16,2,5),(17,2,6),(18,2,7),(19,2,8),(20,2,9),(21,2,10),(22,2,11),(23,3,1),(24,3,2),(25,3,3),(26,3,4),(27,3,5),(28,3,6),(29,3,7),(30,3,8),(31,3,9),(32,3,10),(33,3,11),(34,4,1),(35,4,2),(36,4,3),(37,4,4),(38,4,5),(39,4,6),(40,4,7),(41,4,8),(42,4,9),(43,4,10),(44,4,11),(45,5,1),(46,5,2),(47,5,3),(48,5,4),(49,5,5),(50,5,6),(51,5,7),(52,5,8),(53,5,9),(54,5,10),(55,5,11),(56,6,1),(57,6,2),(58,6,3),(59,6,4),(60,6,5),(61,6,6),(62,6,7),(63,6,8),(64,6,9),(65,6,10),(66,6,11),(67,7,1),(68,7,2),(69,7,3),(70,7,4),(71,7,5),(72,7,6),(73,7,7),(74,7,8),(75,7,9),(76,7,10),(77,7,11),(78,8,1),(79,8,2),(80,8,3),(81,8,4),(82,8,5),(83,8,6),(84,8,7),(85,8,8),(86,8,9),(87,8,10),(88,8,11);
/*!40000 ALTER TABLE `seat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  `password_hash` varchar(100) DEFAULT NULL,
  `role` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'demo@localhost','$2a$10$ebyC4Z5WtCXXc.HGDc1Yoe6CLFzcntFmfse6/pTj7CeDY5I05w16C','ADMIN');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-02-27 19:59:26
