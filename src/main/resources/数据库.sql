-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: 127.0.0.1    Database: MysqlTest
-- ------------------------------------------------------
-- Server version	5.7.19

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
-- Table structure for table `Server`
--

DROP TABLE IF EXISTS `Server`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Server` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(45) NOT NULL,
  `price` float NOT NULL,
  `config` varchar(45) DEFAULT NULL,
  `personId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Server`
--

LOCK TABLES `Server` WRITE;
/*!40000 ALTER TABLE `Server` DISABLE KEYS */;
INSERT INTO `Server` VALUES (1,'成都',15000,'Linux6.5',2),(2,'武汉',16000,'Linux7.0',1),(3,'成都',14800,'windows',3),(4,'广东',17800,'Linux',2),(5,'上海',12334,'window',2),(6,'深圳',23445,'Linux',3),(7,'北京',13456,'window',1),(8,'深圳',245467,'Linux5.6',3);
/*!40000 ALTER TABLE `Server` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `imageData`
--

DROP TABLE IF EXISTS `imageData`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `imageData` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `imagePath` varchar(225) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `imageData`
--

LOCK TABLES `imageData` WRITE;
/*!40000 ALTER TABLE `imageData` DISABLE KEYS */;
INSERT INTO `imageData` VALUES (34,'/img/Screenshot_2017-08-15-11-44-44-985_com.westarsoft.png'),(35,'/img/Screenshot_2017-08-15-11-44-44-985_com.westarsoft.png'),(36,'/img/Screenshot_2017-08-15-11-44-44-985_com.westarsoft.png'),(37,'/img/Screenshot_2017-08-15-11-44-44-985_com.westarsoft.png'),(38,'/img/Screenshot_2017-08-15-20-04-42-274_com.westarsoft.png'),(39,'/img/Screenshot_2017-08-21-09-15-38-654_com.westarsoft.png'),(40,'/img/廉政教育.png'),(41,'/img/屏幕快照 2017-09-11 下午4.27.37.png'),(42,'/img/屏幕快照 2017-09-11 上午11.29.57.png'),(43,'/img/屏幕快照 2017-09-11 上午11.29.57.png'),(44,'/img/屏幕快照 2017-09-11 上午11.29.57.png');
/*!40000 ALTER TABLE `imageData` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `person` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) NOT NULL,
  `websiteId` int(11) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `websiteId` (`websiteId`),
  CONSTRAINT `person_ibfk_1` FOREIGN KEY (`websiteId`) REFERENCES `websites` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES (1,'小明',1,'1234'),(2,'小李',4,'1234'),(3,'小唐',6,'1234');
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `websites`
--

DROP TABLE IF EXISTS `websites`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `websites` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `url` varchar(45) NOT NULL,
  `alexa` int(11) NOT NULL,
  `country` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `websites`
--

LOCK TABLES `websites` WRITE;
/*!40000 ALTER TABLE `websites` DISABLE KEYS */;
INSERT INTO `websites` VALUES (1,'淘宝','www.taobao.com',100,'cn'),(2,'百度','www.baidu.com',30,'cn'),(3,'Google','www.google.com',130,'us'),(4,'微博','www.weibo.com',35,'cn'),(5,'京东','www.jingdong.com',35,'cn'),(6,'facebook','www.facebook.com',60,'us'),(7,'苹果','www.apple.com',80,'us');
/*!40000 ALTER TABLE `websites` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-09-22 17:04:25
