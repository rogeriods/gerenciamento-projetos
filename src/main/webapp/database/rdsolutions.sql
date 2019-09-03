CREATE DATABASE  IF NOT EXISTS `grupoindemetal_apps` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `grupoindemetal_apps`;
-- MySQL dump 10.13  Distrib 5.6.13, for osx10.6 (i386)
--
-- Host: 192.168.0.11    Database: grupoindemetal_apps
-- ------------------------------------------------------
-- Server version	5.7.27-0ubuntu0.18.04.1

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
-- Table structure for table `prj_projetos`
--

DROP TABLE IF EXISTS `prj_projetos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `prj_projetos` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_d051y2a9qok79mo0fxpt6amu8` (`descricao`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prj_projetos`
--

LOCK TABLES `prj_projetos` WRITE;
/*!40000 ALTER TABLE `prj_projetos` DISABLE KEYS */;
/*!40000 ALTER TABLE `prj_projetos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prj_desenvolvedores`
--

DROP TABLE IF EXISTS `prj_desenvolvedores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `prj_desenvolvedores` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome_completo` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_gipv4c5ya15cijook44n8uht9` (`nome_completo`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prj_desenvolvedores`
--

LOCK TABLES `prj_desenvolvedores` WRITE;
/*!40000 ALTER TABLE `prj_desenvolvedores` DISABLE KEYS */;
INSERT INTO `prj_desenvolvedores` VALUES (1,'Rogério Domingos');
/*!40000 ALTER TABLE `prj_desenvolvedores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prj_tarefas`
--

DROP TABLE IF EXISTS `prj_tarefas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `prj_tarefas` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `data_conclusao` timestamp NULL DEFAULT NULL,
  `data_criacao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `descricao` varchar(255) DEFAULT NULL,
  `observacoes` text,
  `status` tinyint(1) NOT NULL,
  `id_desenvolvedor` bigint(20) DEFAULT NULL,
  `id_projeto` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1qx5g1f8gfembimb900ioiahn` (`id_desenvolvedor`),
  KEY `FKm1xwlpf1fnl7l8rphtt2cwt4j` (`id_projeto`),
  CONSTRAINT `FK1qx5g1f8gfembimb900ioiahn` FOREIGN KEY (`id_desenvolvedor`) REFERENCES `prj_desenvolvedores` (`id`),
  CONSTRAINT `FKm1xwlpf1fnl7l8rphtt2cwt4j` FOREIGN KEY (`id_projeto`) REFERENCES `prj_projetos` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prj_tarefas`
--

LOCK TABLES `prj_tarefas` WRITE;
/*!40000 ALTER TABLE `prj_tarefas` DISABLE KEYS */;
/*!40000 ALTER TABLE `prj_tarefas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-09-03 15:16:14
