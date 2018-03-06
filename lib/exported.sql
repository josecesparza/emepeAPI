-- MySQL dump 10.13  Distrib 5.7.21, for Linux (x86_64)
--
-- Host: localhost    Database: emepe
-- ------------------------------------------------------
-- Server version	5.7.21-0ubuntu0.16.04.1

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
USE emepeTest;
--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `idcliente` int(11) NOT NULL AUTO_INCREMENT,
  `usuario` varchar(16) DEFAULT NULL,
  `pass` varchar(16) DEFAULT NULL,
  `registrado` tinyint(1) NOT NULL,
  `nombre` varchar(15) NOT NULL,
  `apellidos` varchar(45) NOT NULL,
  `fechaNac` date NOT NULL,
  `genero` tinyint(1) NOT NULL,
  `localidad` varchar(45) NOT NULL,
  `correo` varchar(45) NOT NULL,
  `idtarj` int(11) NOT NULL,
  PRIMARY KEY (`idcliente`),
  KEY `fk_cliente_tarjCredito1_idx` (`idtarj`),
  CONSTRAINT `fk_cliente_tarjCredito1` FOREIGN KEY (`idtarj`) REFERENCES `tarjCredito` (`idtarj`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (0,'pepe','pepe',1,'Pepe','Acheberria Alonso','1980-01-02',0,'Salamanca','pepe@gimail.com',0),(1,'juan','juan',1,'Juan','Alberto Primero','1960-02-04',0,'Pamplona','juan@gimail.com',1);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clires`
--

DROP TABLE IF EXISTS `clires`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clires` (
  `idcliente` int(11) NOT NULL,
  `idrestaurante` int(11) NOT NULL,
  `favorito` tinyint(1) NOT NULL,
  `valoracion` decimal(2,1) DEFAULT NULL,
  PRIMARY KEY (`idcliente`,`idrestaurante`),
  KEY `fk_cliente_has_restaurante_restaurante1_idx` (`idrestaurante`),
  KEY `fk_cliente_has_restaurante_cliente_idx` (`idcliente`),
  CONSTRAINT `fk_cliente_has_restaurante_cliente` FOREIGN KEY (`idcliente`) REFERENCES `cliente` (`idcliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_cliente_has_restaurante_restaurante1` FOREIGN KEY (`idrestaurante`) REFERENCES `restaurante` (`idrestaurante`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clires`
--

LOCK TABLES `clires` WRITE;
/*!40000 ALTER TABLE `clires` DISABLE KEYS */;
INSERT INTO `clires` VALUES (0,0,0,6.5),(0,1,1,8.2),(1,0,1,9.5);
/*!40000 ALTER TABLE `clires` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ingprod`
--

DROP TABLE IF EXISTS `ingprod`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ingprod` (
  `idproducto` int(11) NOT NULL,
  `idingrediente` int(11) NOT NULL,
  PRIMARY KEY (`idproducto`,`idingrediente`),
  KEY `fk_ingprod_producto1_idx` (`idproducto`),
  KEY `fk_ingprod_ingrediente2_idx` (`idingrediente`),
  CONSTRAINT `fk_ingprod_ingrediente2` FOREIGN KEY (`idingrediente`) REFERENCES `ingrediente` (`idingrediente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_ingprod_producto1` FOREIGN KEY (`idproducto`) REFERENCES `producto` (`idproducto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ingprod`
--

LOCK TABLES `ingprod` WRITE;
/*!40000 ALTER TABLE `ingprod` DISABLE KEYS */;
INSERT INTO `ingprod` VALUES (0,0),(0,1),(1,0),(1,1),(1,2),(1,3),(1,4),(2,4),(2,5);
/*!40000 ALTER TABLE `ingprod` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ingrediente`
--

DROP TABLE IF EXISTS `ingrediente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ingrediente` (
  `idingrediente` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `vegano` tinyint(1) DEFAULT NULL,
  `vegetariano` tinytext,
  `gluten` tinyint(1) DEFAULT NULL,
  `lactosa` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`idingrediente`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ingrediente`
--

LOCK TABLES `ingrediente` WRITE;
/*!40000 ALTER TABLE `ingrediente` DISABLE KEYS */;
INSERT INTO `ingrediente` VALUES (0,'queso',0,'1',1,1),(1,'pasta pizza',1,'1',1,0),(2,'bacon',0,'0',0,0),(3,'cebolla',1,'1',0,0),(4,'huevo',0,'1',0,0),(5,'pollo',0,'0',0,0),(6,'patata',0,'0',0,0),(7,'patata',0,'0',0,0),(8,'asado',0,'0',0,0),(9,'asado',0,'0',0,0),(10,'asado',0,'0',0,0),(11,'asado',1,'1',1,1);
/*!40000 ALTER TABLE `ingrediente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `opinion`
--

DROP TABLE IF EXISTS `opinion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `opinion` (
  `idopinion` int(11) NOT NULL AUTO_INCREMENT,
  `opinion` varchar(500) NOT NULL,
  `valoracion` decimal(2,1) unsigned DEFAULT NULL,
  `idcliente` int(11) NOT NULL,
  `idproducto` int(11) NOT NULL,
  PRIMARY KEY (`idopinion`),
  KEY `fk_opinion_cliente1_idx` (`idcliente`),
  KEY `fk_opinion_producto1_idx` (`idproducto`),
  CONSTRAINT `fk_opinion_cliente1` FOREIGN KEY (`idcliente`) REFERENCES `cliente` (`idcliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_opinion_producto1` FOREIGN KEY (`idproducto`) REFERENCES `producto` (`idproducto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `opinion`
--

LOCK TABLES `opinion` WRITE;
/*!40000 ALTER TABLE `opinion` DISABLE KEYS */;
INSERT INTO `opinion` VALUES (0,'Esta pizza esta muy buena',3.5,0,0),(1,'Pues no esta tan buena',4.5,1,0),(2,'Este pollo está bueno',3.6,0,2),(3,'Me gustó mucho el pollo',4.5,1,2);
/*!40000 ALTER TABLE `opinion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `producto` (
  `idproducto` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `precio` decimal(6,2) unsigned NOT NULL,
  `peso` decimal(7,2) unsigned DEFAULT NULL,
  `descripcion` varchar(400) DEFAULT NULL,
  `fechaElab` date NOT NULL,
  `fechaCad` date NOT NULL,
  `idrestaurante` int(11) NOT NULL,
  PRIMARY KEY (`idproducto`),
  KEY `fk_producto_restaurante1_idx` (`idrestaurante`),
  CONSTRAINT `fk_producto_restaurante1` FOREIGN KEY (`idrestaurante`) REFERENCES `restaurante` (`idrestaurante`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES (0,'Pizza 4 quesos',3.50,200.50,'Pizza buena','2018-01-29','2018-01-31',0),(1,'Pizza Carbonara',4.00,200.50,'Pizza no tan buena','2018-02-01','2018-02-03',0),(2,'Pollo asado',2.75,150.50,'Pollo bueno','2018-01-27','2018-01-31',1);
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `restaurante`
--

DROP TABLE IF EXISTS `restaurante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `restaurante` (
  `idrestaurante` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `tipo` varchar(45) DEFAULT NULL,
  `descripcion` varchar(500) DEFAULT NULL,
  `horario` varchar(45) DEFAULT NULL,
  `codEmpresa` varchar(45) NOT NULL,
  `pass` varchar(45) NOT NULL,
  `adreza` varchar(60) NOT NULL,
  `latitud` float(10,6) NOT NULL,
  `longitud` float(10,6) NOT NULL,
  `telefono` varchar(12) NOT NULL,
  `mail` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idrestaurante`),
  UNIQUE KEY `codEmpresa_UNIQUE` (`codEmpresa`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `restaurante`
--

LOCK TABLES `restaurante` WRITE;
/*!40000 ALTER TABLE `restaurante` DISABLE KEYS */;
INSERT INTO `restaurante` VALUES (0,'Dominos Pizza','restaurante','Vendemos pizzas y esas cosas','13:00-18:30','A58818501','dominos','Av. de Blasco Ibáñez, 57, 46021 València',39.475296,0.352595,'963626047','dominos@gimail.com'),(1,'KFC','restaurante','Vendemos pollo firto mu bueno','14:00-20:00','A58898431','kfc','Av. de Blasco Ibáñez, 87, 46022 València',39.475037,-0.352144,'963564151','kfc@yaju.com');
/*!40000 ALTER TABLE `restaurante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tarjCredito`
--

DROP TABLE IF EXISTS `tarjCredito`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tarjCredito` (
  `idtarj` int(11) NOT NULL AUTO_INCREMENT,
  `numero` bigint(16) unsigned NOT NULL,
  PRIMARY KEY (`idtarj`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tarjCredito`
--

LOCK TABLES `tarjCredito` WRITE;
/*!40000 ALTER TABLE `tarjCredito` DISABLE KEYS */;
INSERT INTO `tarjCredito` VALUES (0,1111111111111111),(1,2222222222222222);
/*!40000 ALTER TABLE `tarjCredito` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-03-06 18:49:18
