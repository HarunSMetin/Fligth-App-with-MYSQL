CREATE DATABASE  IF NOT EXISTS `flightapp` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `flightapp`;
-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: flightapp
-- ------------------------------------------------------
-- Server version	8.0.30

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `airplane`
--

DROP TABLE IF EXISTS `airplane`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `airplane` (
  `airplane_id` varchar(15) NOT NULL,
  `seat_count` int DEFAULT NULL,
  `airport_id` varchar(15) NOT NULL,
  PRIMARY KEY (`airplane_id`),
  KEY `airport_id` (`airport_id`),
  CONSTRAINT `airplane_ibfk_1` FOREIGN KEY (`airport_id`) REFERENCES `airport` (`airport_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `airplane`
--

LOCK TABLES `airplane` WRITE;
/*!40000 ALTER TABLE `airplane` DISABLE KEYS */;
INSERT INTO `airplane` VALUES ('U1',6,'01'),('U2',6,'01'),('U3',5,'02'),('U4',7,'03');
/*!40000 ALTER TABLE `airplane` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `airport`
--

DROP TABLE IF EXISTS `airport`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `airport` (
  `airport_id` varchar(15) NOT NULL,
  `airport_name` varchar(30) NOT NULL,
  `airport_loc` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`airport_id`,`airport_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `airport`
--

LOCK TABLES `airport` WRITE;
/*!40000 ALTER TABLE `airport` DISABLE KEYS */;
INSERT INTO `airport` VALUES ('01','Samsun Airport','Samsun Çarşamba'),('02','Esenboğa Airport','Ankara Akyurt'),('03','Dalaman Airport','Muğla Dalaman'),('04','Atatürk Airport','İstanbul Bakırköy');
/*!40000 ALTER TABLE `airport` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `copilot`
--

DROP TABLE IF EXISTS `copilot`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `copilot` (
  `crew_id` varchar(15) NOT NULL,
  `co_pilot_ssn` varchar(11) NOT NULL,
  PRIMARY KEY (`crew_id`),
  KEY `co_pilot_ssn` (`co_pilot_ssn`),
  CONSTRAINT `copilot_ibfk_1` FOREIGN KEY (`co_pilot_ssn`) REFERENCES `user` (`user_ssn`),
  CONSTRAINT `copilot_ibfk_2` FOREIGN KEY (`crew_id`) REFERENCES `crew` (`crew_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `copilot`
--

LOCK TABLES `copilot` WRITE;
/*!40000 ALTER TABLE `copilot` DISABLE KEYS */;
INSERT INTO `copilot` VALUES ('C1','1415');
/*!40000 ALTER TABLE `copilot` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `crew`
--

DROP TABLE IF EXISTS `crew`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `crew` (
  `crew_id` varchar(15) NOT NULL,
  `airplane_id` varchar(15) NOT NULL,
  PRIMARY KEY (`crew_id`),
  KEY `airplane_id` (`airplane_id`),
  CONSTRAINT `crew_ibfk_1` FOREIGN KEY (`airplane_id`) REFERENCES `airplane` (`airplane_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crew`
--

LOCK TABLES `crew` WRITE;
/*!40000 ALTER TABLE `crew` DISABLE KEYS */;
INSERT INTO `crew` VALUES ('C1','U1'),('C2','U2'),('C3','U3');
/*!40000 ALTER TABLE `crew` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flightinfo`
--

DROP TABLE IF EXISTS `flightinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `flightinfo` (
  `flight_id` varchar(15) NOT NULL,
  `plane_gate` varchar(15) NOT NULL,
  `departure_date` date DEFAULT NULL,
  `departure_time` varchar(15) DEFAULT NULL,
  `where_from` varchar(50) DEFAULT NULL,
  `where_to` varchar(50) DEFAULT NULL,
  `airport_id` varchar(15) NOT NULL,
  `airport_name` varchar(30) NOT NULL,
  `airplane_id` varchar(15) NOT NULL,
  PRIMARY KEY (`flight_id`),
  KEY `airport_id` (`airport_id`,`airport_name`),
  KEY `airplane_id` (`airplane_id`),
  CONSTRAINT `flightinfo_ibfk_1` FOREIGN KEY (`airport_id`, `airport_name`) REFERENCES `airport` (`airport_id`, `airport_name`),
  CONSTRAINT `flightinfo_ibfk_2` FOREIGN KEY (`airplane_id`) REFERENCES `airplane` (`airplane_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flightinfo`
--

LOCK TABLES `flightinfo` WRITE;
/*!40000 ALTER TABLE `flightinfo` DISABLE KEYS */;
INSERT INTO `flightinfo` VALUES ('F1','G1','2022-08-16','15.15','Samsun Çarşamba','Muğla Dalaman','01','Samsun Airport','U1'),('F2','G2','2022-08-17','23.30','Ankara Akyurt','Samsun Çarşamba','02','Esenboğa Airport','U3'),('F3','G1','2022-08-20','05.30','Muğla Dalaman','Ankara Akyurt','03','Dalaman Airport','U2');
/*!40000 ALTER TABLE `flightinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hostess`
--

DROP TABLE IF EXISTS `hostess`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hostess` (
  `crew_id` varchar(15) NOT NULL,
  `hostess_ssn` varchar(11) NOT NULL,
  KEY `hostess_ssn` (`hostess_ssn`),
  KEY `crew_id` (`crew_id`),
  CONSTRAINT `hostess_ibfk_1` FOREIGN KEY (`hostess_ssn`) REFERENCES `user` (`user_ssn`),
  CONSTRAINT `hostess_ibfk_2` FOREIGN KEY (`crew_id`) REFERENCES `crew` (`crew_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hostess`
--

LOCK TABLES `hostess` WRITE;
/*!40000 ALTER TABLE `hostess` DISABLE KEYS */;
INSERT INTO `hostess` VALUES ('C1','1213'),('C2','789');
/*!40000 ALTER TABLE `hostess` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pilot`
--

DROP TABLE IF EXISTS `pilot`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pilot` (
  `crew_id` varchar(15) NOT NULL,
  `pilot_ssn` varchar(11) NOT NULL,
  PRIMARY KEY (`crew_id`),
  KEY `pilot_ssn` (`pilot_ssn`),
  CONSTRAINT `pilot_ibfk_1` FOREIGN KEY (`crew_id`) REFERENCES `crew` (`crew_id`),
  CONSTRAINT `pilot_ibfk_2` FOREIGN KEY (`pilot_ssn`) REFERENCES `user` (`user_ssn`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pilot`
--

LOCK TABLES `pilot` WRITE;
/*!40000 ALTER TABLE `pilot` DISABLE KEYS */;
INSERT INTO `pilot` VALUES ('C1','1011');
/*!40000 ALTER TABLE `pilot` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seat`
--

DROP TABLE IF EXISTS `seat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `seat` (
  `seat_num` varchar(15) NOT NULL,
  `is_booked` tinyint(1) DEFAULT NULL,
  `airplane_id` varchar(15) NOT NULL,
  PRIMARY KEY (`seat_num`),
  KEY `airplane_id` (`airplane_id`),
  CONSTRAINT `seat_ibfk_1` FOREIGN KEY (`airplane_id`) REFERENCES `airplane` (`airplane_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seat`
--

LOCK TABLES `seat` WRITE;
/*!40000 ALTER TABLE `seat` DISABLE KEYS */;
INSERT INTO `seat` VALUES ('1',1,'U3'),('10',0,'U2'),('11',0,'U2'),('2',0,'U3'),('3',0,'U3'),('4',1,'U3'),('5',1,'U3'),('6',0,'U2'),('7',1,'U2'),('8',0,'U2'),('9',0,'U2');
/*!40000 ALTER TABLE `seat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket`
--

DROP TABLE IF EXISTS `ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ticket` (
  `pnr` varchar(15) NOT NULL,
  `seat_num` varchar(15) DEFAULT NULL,
  `flight_id` varchar(15) NOT NULL,
  `airplane_id` varchar(15) NOT NULL,
  `airport_id` varchar(15) NOT NULL,
  `airport_name` varchar(30) NOT NULL,
  `pas_ssn` varchar(11) NOT NULL,
  PRIMARY KEY (`pnr`),
  KEY `flight_id` (`flight_id`),
  KEY `airport_id` (`airport_id`,`airport_name`),
  KEY `pas_ssn` (`pas_ssn`),
  KEY `ticket_ibfk_1` (`seat_num`),
  CONSTRAINT `ticket_ibfk_1` FOREIGN KEY (`seat_num`) REFERENCES `seat` (`seat_num`),
  CONSTRAINT `ticket_ibfk_2` FOREIGN KEY (`flight_id`) REFERENCES `flightinfo` (`flight_id`),
  CONSTRAINT `ticket_ibfk_3` FOREIGN KEY (`airport_id`, `airport_name`) REFERENCES `airport` (`airport_id`, `airport_name`),
  CONSTRAINT `ticket_ibfk_4` FOREIGN KEY (`pas_ssn`) REFERENCES `user` (`user_ssn`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket`
--

LOCK TABLES `ticket` WRITE;
/*!40000 ALTER TABLE `ticket` DISABLE KEYS */;
INSERT INTO `ticket` VALUES ('P111','2','F2','U3','02','Esenboğa Airport','456'),('P112','5','F2','U3','02','Esenboğa Airport','789'),('P113','1','F2','U3','02','Esenboğa Airport','1011'),('P114','7','F3','U2','03','Dalaman Airport','1011');
/*!40000 ALTER TABLE `ticket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_ssn` varchar(11) NOT NULL,
  `user_password` varchar(25) NOT NULL,
  `user_mail` varchar(100) DEFAULT NULL,
  `user_tel` varchar(13) DEFAULT NULL,
  `user_adress` varchar(100) DEFAULT NULL,
  `fname` varchar(25) DEFAULT NULL,
  `lname` varchar(25) DEFAULT NULL,
  `acceslevel` int DEFAULT '0',
  `user_birthdate` date DEFAULT NULL,
  `user_age` smallint DEFAULT NULL,
  PRIMARY KEY (`user_ssn`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('1011','111','sss@gmail.com','1111111111','Hatay','Hasan','Han',0,'2000-12-20',22),('1213','111','sss@gmail.com','2222222222','Hatay','Hande','Çetin',0,'2000-07-10',22),('123','123','hsm@gmail.com','5985965321','Samsun','Harun','Çetin',1,'1998-10-20',24),('1415','111','sss@gmail.com','3333333333','Hatay','Metin','Çetin',0,'2001-11-21',21),('1617','1617','den@gmail.com','3259542687','Samsun','Handan','Çetin',0,'1976-10-15',46),('1819','1819','oa@gmail.com','5641237856','Ankara','Osman','Abul',1,'1970-08-19',52),('2021','2021','sda@outlook.com','5894325412','Çorum','Ahmet','Budak',0,'1999-07-06',23),('456','456','hhh@gmail.com','5555555555','Ankara','Serkan','Metin',0,'1999-11-20',22),('789','789','sss@gmail.com','8988989866','Hatay','İzzet','Han',0,'2002-12-20',20);
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

-- Dump completed on 2022-08-20 13:44:11
