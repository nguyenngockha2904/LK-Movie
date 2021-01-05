-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: movie
-- ------------------------------------------------------
-- Server version	8.0.21

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
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `ADMIN_ID` int NOT NULL AUTO_INCREMENT,
  `ADMIN_HOTEN` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `ADMIN_EMAIL` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `ADMIN_GIOITINH` int DEFAULT NULL,
  `ADMIN_USERNAME` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `ADMIN_PASSWORD` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `ADMIN_DIACHI` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `ADMIN_CMND` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `ADMIN_AVATAR` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `ADMIN_TINHTRANG` int DEFAULT NULL,
  `ADMIN_SDT` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `ADMIN_CHUCVU` int DEFAULT NULL,
  `ADMIN_NGAYSINH` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `admin_role` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ADMIN_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (13,'string','string',0,'lanpro','$2a$10$qVYKs/gAjzHFHOTgNLiG0eAZyJ73lYerVcbuH3hWI0jJeZqJBFjIC','string','string','string',0,'string',0,'string','ROLE_ADMIN');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cumrap`
--

DROP TABLE IF EXISTS `cumrap`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cumrap` (
  `CUMRAP_ID` int NOT NULL AUTO_INCREMENT,
  `HETHONGRAP_ID` int DEFAULT NULL,
  `TENCUMRAP` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `BIDANH` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `LOGO` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `DIACHI` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `hethongrap_hethongrap_id` int DEFAULT NULL,
  PRIMARY KEY (`CUMRAP_ID`),
  KEY `FKnhv5hhxb8wgmqm1kqia44pj4q` (`HETHONGRAP_ID`),
  KEY `FKt04nf6k900035dhl1232jox4w` (`hethongrap_hethongrap_id`),
  CONSTRAINT `FK_SOHUU` FOREIGN KEY (`HETHONGRAP_ID`) REFERENCES `hethongrap` (`HETHONGRAP_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKnhv5hhxb8wgmqm1kqia44pj4q` FOREIGN KEY (`HETHONGRAP_ID`) REFERENCES `hethongrap` (`HETHONGRAP_ID`),
  CONSTRAINT `FKt04nf6k900035dhl1232jox4w` FOREIGN KEY (`hethongrap_hethongrap_id`) REFERENCES `hethongrap` (`HETHONGRAP_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cumrap`
--

LOCK TABLES `cumrap` WRITE;
/*!40000 ALTER TABLE `cumrap` DISABLE KEYS */;
INSERT INTO `cumrap` VALUES (4,2,'CGV Thủ Đức','cgv-thu-duc','cgv-thu-duc-logo','20 Võ Văn Ngân, Quận Thủ Đức, TPHCM',NULL),(5,2,'CGV Hồng Thập Tự','cgv-hong-thap-tu','cgv-hong-thap-tu-logo','20 Hồng Thập Tự, Sài Gòn',NULL);
/*!40000 ALTER TABLE `cumrap` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `danhgia`
--

DROP TABLE IF EXISTS `danhgia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `danhgia` (
  `DANHGIA_ID` int NOT NULL AUTO_INCREMENT,
  `USER_ID` int DEFAULT NULL,
  `PHIM_ID` int DEFAULT NULL,
  `MADANHGIA` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `NOIDUNGDANHGIA` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`DANHGIA_ID`),
  KEY `FK8wraa328cmebg7wh30rs42dlc` (`PHIM_ID`),
  KEY `FKl9iirh904mnbot7yyb7q5wdh` (`USER_ID`),
  CONSTRAINT `FK8wraa328cmebg7wh30rs42dlc` FOREIGN KEY (`PHIM_ID`) REFERENCES `phim` (`PHIM_ID`),
  CONSTRAINT `FK_DANHGIA` FOREIGN KEY (`USER_ID`) REFERENCES `user` (`USER_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_DUOCDANHGIA` FOREIGN KEY (`PHIM_ID`) REFERENCES `phim` (`PHIM_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKl9iirh904mnbot7yyb7q5wdh` FOREIGN KEY (`USER_ID`) REFERENCES `user` (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `danhgia`
--

LOCK TABLES `danhgia` WRITE;
/*!40000 ALTER TABLE `danhgia` DISABLE KEYS */;
/*!40000 ALTER TABLE `danhgia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ghe`
--

DROP TABLE IF EXISTS `ghe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ghe` (
  `GHE_ID` int NOT NULL AUTO_INCREMENT,
  `RAP_ID` int DEFAULT NULL,
  `MAGHE` char(20) COLLATE utf8_bin DEFAULT NULL,
  `TENGHE` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `TINHTRANG` int DEFAULT NULL,
  `LOAIGHE` int DEFAULT NULL,
  `GIAGHE` decimal(8,0) DEFAULT NULL,
  PRIMARY KEY (`GHE_ID`),
  KEY `FK3vmjxg9w3h9luqdwleb9j6tgh` (`RAP_ID`),
  CONSTRAINT `FK3vmjxg9w3h9luqdwleb9j6tgh` FOREIGN KEY (`RAP_ID`) REFERENCES `rap` (`RAP_ID`),
  CONSTRAINT `FK_GOM` FOREIGN KEY (`RAP_ID`) REFERENCES `rap` (`RAP_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ghe`
--

LOCK TABLES `ghe` WRITE;
/*!40000 ALTER TABLE `ghe` DISABLE KEYS */;
INSERT INTO `ghe` VALUES (1,7,'MG1','A1',0,1,1000),(2,7,'MG2','A2',0,1,1220);
/*!40000 ALTER TABLE `ghe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hethongrap`
--

DROP TABLE IF EXISTS `hethongrap`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hethongrap` (
  `HETHONGRAP_ID` int NOT NULL AUTO_INCREMENT,
  `MAHETHONGRAP` char(20) COLLATE utf8_bin DEFAULT NULL,
  `TENHETHONGRAP` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `BIDANH` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `LOGO` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`HETHONGRAP_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hethongrap`
--

LOCK TABLES `hethongrap` WRITE;
/*!40000 ALTER TABLE `hethongrap` DISABLE KEYS */;
INSERT INTO `hethongrap` VALUES (2,'MLC1','CGV','cgv','cgv-logo');
/*!40000 ALTER TABLE `hethongrap` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (14);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lichchieu`
--

DROP TABLE IF EXISTS `lichchieu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lichchieu` (
  `LICHCHIEU_ID` int NOT NULL AUTO_INCREMENT,
  `PHIM_ID` int DEFAULT NULL,
  `RAP_ID` int DEFAULT NULL,
  `MALICHCHIEU` char(20) COLLATE utf8_bin DEFAULT NULL,
  `THOIGIANBATDAUCHIEU` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `THOIGIANKETTHUC` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `HESOCHENHLECH` decimal(8,0) DEFAULT NULL,
  PRIMARY KEY (`LICHCHIEU_ID`),
  KEY `FKjs1c7paq4hcd1raem16cny8tu` (`PHIM_ID`),
  KEY `FKo4ku5238npymv75sv0nous82t` (`RAP_ID`),
  CONSTRAINT `FK_CO` FOREIGN KEY (`PHIM_ID`) REFERENCES `phim` (`PHIM_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_CO1` FOREIGN KEY (`RAP_ID`) REFERENCES `rap` (`RAP_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKjs1c7paq4hcd1raem16cny8tu` FOREIGN KEY (`PHIM_ID`) REFERENCES `phim` (`PHIM_ID`),
  CONSTRAINT `FKo4ku5238npymv75sv0nous82t` FOREIGN KEY (`RAP_ID`) REFERENCES `rap` (`RAP_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lichchieu`
--

LOCK TABLES `lichchieu` WRITE;
/*!40000 ALTER TABLE `lichchieu` DISABLE KEYS */;
/*!40000 ALTER TABLE `lichchieu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phim`
--

DROP TABLE IF EXISTS `phim`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `phim` (
  `PHIM_ID` int NOT NULL AUTO_INCREMENT,
  `MAPHIM` char(20) COLLATE utf8_bin DEFAULT NULL,
  `TENPHIM` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `BIDANH` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `MOTA` longtext COLLATE utf8_bin,
  `TRAILER` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `NGAYKHOICHIEU` char(20) COLLATE utf8_bin DEFAULT NULL,
  `DANHGIA` int DEFAULT NULL,
  `HINHANH` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `BANNER` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`PHIM_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phim`
--

LOCK TABLES `phim` WRITE;
/*!40000 ALTER TABLE `phim` DISABLE KEYS */;
INSERT INTO `phim` VALUES (7,'MVC1','John Wick','john-wick1','Babayaga1','no','20/10/2019',5,'no','johnwick-banner'),(8,'MVC8','John Wick','john-wick1','Babayaga1','no','20/10/2019',5,'no','johnwick-banner'),(9,'MVC9','John Wick','john-wick1','Babayaga1','no','20/10/2019',5,'no','johnwick-banner');
/*!40000 ALTER TABLE `phim` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rap`
--

DROP TABLE IF EXISTS `rap`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rap` (
  `RAP_ID` int NOT NULL AUTO_INCREMENT,
  `CUMRAP_ID` int DEFAULT NULL,
  `MARAP` char(20) COLLATE utf8_bin DEFAULT NULL,
  `TENRAP` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`RAP_ID`),
  KEY `FK1guhiqht525u3s5nyhb3y42hk` (`CUMRAP_ID`),
  CONSTRAINT `FK1guhiqht525u3s5nyhb3y42hk` FOREIGN KEY (`CUMRAP_ID`) REFERENCES `cumrap` (`CUMRAP_ID`),
  CONSTRAINT `FK_HAVE` FOREIGN KEY (`CUMRAP_ID`) REFERENCES `cumrap` (`CUMRAP_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rap`
--

LOCK TABLES `rap` WRITE;
/*!40000 ALTER TABLE `rap` DISABLE KEYS */;
INSERT INTO `rap` VALUES (7,4,'MR1','Rap 1'),(8,4,'MR8','Rap 2');
/*!40000 ALTER TABLE `rap` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `USER_ID` int NOT NULL AUTO_INCREMENT,
  `MAUSER` char(20) COLLATE utf8_bin DEFAULT NULL,
  `USERNAME` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `PASSWORD` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `SDT` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `HOTEN` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `AVATAR` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `EMAIL` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `GIOITINH` int DEFAULT NULL,
  `role` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (8,'US1','nam','123','1232234567','nam','string','nam@gmail.com',1,'ROLE_USER'),(9,'US9','nam1','$2a$10$AGwV76TS.47kkfYeE3/6HOFBCfovIXim8bf.ihcWiitCSR29bPEda','1232234564','nam','string','nam1@gmail.com',1,'ROLE_ADMIN'),(10,'US10','lan','$2a$10$YyDGAO52cmeKD6kMGD.I3OkwQ941QQeJ0RSNOY9Cq.zgtS/T/Ax2S','01234543213','nguyen lan','string','nguyenlan@gmail.com',1,'ROLE_USER');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ve`
--

DROP TABLE IF EXISTS `ve`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ve` (
  `VE_ID` int NOT NULL AUTO_INCREMENT,
  `LICHCHIEU_ID` int NOT NULL,
  `USER_ID` int DEFAULT NULL,
  `MAVE` char(20) COLLATE utf8_bin DEFAULT NULL,
  `TENVE` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `MAGHE` char(20) COLLATE utf8_bin DEFAULT NULL,
  `GIAVE` decimal(30,0) DEFAULT NULL,
  `TINHTRANGVE` int DEFAULT NULL,
  PRIMARY KEY (`VE_ID`),
  KEY `FK30k1grqt7pimuol5xm2d5ak25` (`LICHCHIEU_ID`),
  KEY `FKh9v65pjxdlmbamjamw3iv2ucr` (`USER_ID`),
  CONSTRAINT `FK30k1grqt7pimuol5xm2d5ak25` FOREIGN KEY (`LICHCHIEU_ID`) REFERENCES `lichchieu` (`LICHCHIEU_ID`),
  CONSTRAINT `FK_DATVE` FOREIGN KEY (`USER_ID`) REFERENCES `user` (`USER_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_THUOC` FOREIGN KEY (`LICHCHIEU_ID`) REFERENCES `lichchieu` (`LICHCHIEU_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKh9v65pjxdlmbamjamw3iv2ucr` FOREIGN KEY (`USER_ID`) REFERENCES `user` (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ve`
--

LOCK TABLES `ve` WRITE;
/*!40000 ALTER TABLE `ve` DISABLE KEYS */;
/*!40000 ALTER TABLE `ve` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-27  0:21:30
