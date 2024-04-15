CREATE DATABASE  IF NOT EXISTS `banco_ds` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `banco_ds`;
-- MySQL dump 10.13  Distrib 5.6.23, for Win64 (x86_64)
--
-- Host: localhost    Database: banco_ds
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.24-MariaDB

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
-- Table structure for table `produto`
--

DROP TABLE IF EXISTS `produto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `produto` (
  `idProduto` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `valor` float(10,2) NOT NULL,
  `desconto` float(10,2) DEFAULT NULL,
  `valorFinal` float(10,2) NOT NULL,
  `imagem` longblob DEFAULT NULL,
  `categoria` int(11) NOT NULL,
  `clube` int(11) NOT NULL,
  PRIMARY KEY (`idProduto`),
  KEY `clube` (`clube`),
  KEY `categoria` (`categoria`),
  CONSTRAINT `produto_ibfk_1` FOREIGN KEY (`clube`) REFERENCES `clube` (`idClube`),
  CONSTRAINT `produto_ibfk_2` FOREIGN KEY (`categoria`) REFERENCES `categoria` (`idCategoria`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produto`
--

LOCK TABLES `produto` WRITE;
/*!40000 ALTER TABLE `produto` DISABLE KEYS */;
INSERT INTO `produto` VALUES (1,'Smartphone',1500.00,100.00,1400.00,NULL,1,1),(2,'Notebook',2500.00,200.00,2300.00,NULL,1,2),(3,'Camiseta',50.00,10.00,45.00,NULL,2,1),(4,'Tênis',200.00,20.00,180.00,NULL,3,3),(5,'Sofá',800.00,50.00,750.00,NULL,4,1),(6,'TV',1000.00,100.00,900.00,NULL,1,3),(7,'Vestido',80.00,5.00,75.00,NULL,2,2),(8,'Bicicleta',300.00,30.00,270.00,NULL,3,1),(9,'Mesa',150.00,15.00,135.00,NULL,4,2),(10,'Cadeira',50.00,5.00,45.00,NULL,4,3),(11,'Produto A',50.00,5.00,45.00,NULL,1,1),(12,'Produto B',30.00,0.00,30.00,NULL,2,1),(13,'Produto C',20.00,2.00,18.00,NULL,1,2),(14,'Produto D',45.00,3.50,41.50,NULL,3,2),(15,'Produto E',60.00,0.00,60.00,NULL,2,3),(16,'Produto F',25.00,1.00,24.00,NULL,1,3),(17,'Produto G',35.00,0.00,35.00,NULL,2,1),(18,'Produto H',40.00,4.00,36.00,NULL,3,2),(19,'Produto I',55.00,5.50,49.50,NULL,1,3),(20,'Produto J',70.00,0.00,70.00,NULL,2,1),(21,'Produto K',15.00,1.50,13.50,NULL,3,1),(22,'Produto L',28.00,0.00,28.00,NULL,1,2),(23,'Produto M',38.00,3.80,34.20,NULL,2,2),(24,'Produto N',48.00,0.00,48.00,NULL,3,3),(25,'Produto O',65.00,6.50,58.50,NULL,1,3),(26,'Produto P',22.00,2.20,19.80,NULL,2,1),(27,'Produto Q',33.00,0.00,33.00,NULL,3,2),(28,'Produto R',42.00,4.20,37.80,NULL,1,3),(29,'Produto S',58.00,0.00,58.00,NULL,2,1),(30,'Produto T',17.00,1.70,15.30,NULL,3,2),(31,'Produto U',27.00,0.00,27.00,NULL,1,3),(32,'Produto V',37.00,3.70,33.30,NULL,2,3),(33,'Produto W',46.00,0.00,46.00,NULL,3,1),(34,'Produto X',62.00,6.20,55.80,NULL,1,1),(35,'Produto Y',19.00,1.90,17.10,NULL,2,2),(36,'Produto Z',31.00,0.00,31.00,NULL,3,3),(37,'Produto AA',41.00,4.10,36.90,NULL,1,1),(38,'Produto AB',56.00,0.00,56.00,NULL,2,2),(39,'Produto AC',23.00,2.30,20.70,NULL,3,3),(40,'Produto AD',34.00,0.00,34.00,NULL,1,2);
/*!40000 ALTER TABLE `produto` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-04-15 17:33:55
