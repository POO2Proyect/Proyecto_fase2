-- MySQL dump 10.13  Distrib 5.7.19, for Linux (x86_64)
--
-- Host: localhost    Database: ProyectoPOO2
-- ------------------------------------------------------
-- Server version	5.7.19-0ubuntu0.16.04.1

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
-- Table structure for table `Cabanas`
--

DROP TABLE IF EXISTS `Cabanas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Cabanas` (
  `idCabanas` varchar(15) COLLATE latin1_spanish_ci NOT NULL,
  `codCabana` varchar(45) COLLATE latin1_spanish_ci NOT NULL,
  `nombre` varchar(45) COLLATE latin1_spanish_ci NOT NULL,
  `numLocal` decimal(10,0) DEFAULT NULL,
  `capacidad` int(11) DEFAULT NULL,
  `precioDia` decimal(10,2) DEFAULT NULL,
  `precioNoche` decimal(10,2) DEFAULT NULL,
  `precioDN` decimal(10,2) DEFAULT NULL,
  `descripcion` varchar(345) COLLATE latin1_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`idCabanas`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Cabanas`
--

LOCK TABLES `Cabanas` WRITE;
/*!40000 ALTER TABLE `Cabanas` DISABLE KEYS */;
/*!40000 ALTER TABLE `Cabanas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Clientes`
--

DROP TABLE IF EXISTS `Clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Clientes` (
  `idClientes` varchar(15) COLLATE latin1_spanish_ci NOT NULL,
  `dui` varchar(10) COLLATE latin1_spanish_ci NOT NULL,
  `nombre` varchar(45) COLLATE latin1_spanish_ci NOT NULL,
  `apellido` varchar(45) COLLATE latin1_spanish_ci NOT NULL,
  `telefono` varchar(45) COLLATE latin1_spanish_ci NOT NULL,
  `movil` varchar(45) COLLATE latin1_spanish_ci NOT NULL,
  `fechaNacimiento` date DEFAULT NULL,
  `correo` varchar(45) COLLATE latin1_spanish_ci NOT NULL,
  `direccion` varchar(45) COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`idClientes`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Clientes`
--

LOCK TABLES `Clientes` WRITE;
/*!40000 ALTER TABLE `Clientes` DISABLE KEYS */;
/*!40000 ALTER TABLE `Clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Empleado`
--

DROP TABLE IF EXISTS `Empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Empleado` (
  `idEmpleado` varchar(15) COLLATE latin1_spanish_ci NOT NULL,
  `codEmpleado` varchar(45) COLLATE latin1_spanish_ci NOT NULL,
  `nombre` varchar(45) COLLATE latin1_spanish_ci NOT NULL,
  `apellido` varchar(45) COLLATE latin1_spanish_ci NOT NULL,
  `fechaNacimiento` date DEFAULT NULL,
  `correo` varchar(145) COLLATE latin1_spanish_ci NOT NULL,
  `telefono` varchar(15) COLLATE latin1_spanish_ci DEFAULT NULL,
  `movil` varchar(15) COLLATE latin1_spanish_ci DEFAULT NULL,
  `idcargo` varchar(15) COLLATE latin1_spanish_ci NOT NULL,
  `direccion` varchar(245) COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`idEmpleado`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Empleado`
--

LOCK TABLES `Empleado` WRITE;
/*!40000 ALTER TABLE `Empleado` DISABLE KEYS */;
/*!40000 ALTER TABLE `Empleado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `EstadoOfertaReservacion`
--

DROP TABLE IF EXISTS `EstadoOfertaReservacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `EstadoOfertaReservacion` (
  `idEstadoOfertaReservacion` int(11) NOT NULL AUTO_INCREMENT,
  `estado` varchar(45) COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`idEstadoOfertaReservacion`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `EstadoOfertaReservacion`
--

LOCK TABLES `EstadoOfertaReservacion` WRITE;
/*!40000 ALTER TABLE `EstadoOfertaReservacion` DISABLE KEYS */;
/*!40000 ALTER TABLE `EstadoOfertaReservacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `OfertaServicio`
--

DROP TABLE IF EXISTS `OfertaServicio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `OfertaServicio` (
  `idOfertaServicio` int(11) NOT NULL AUTO_INCREMENT,
  `idOferta` varchar(15) COLLATE latin1_spanish_ci DEFAULT NULL,
  `idServicio` varchar(15) COLLATE latin1_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`idOfertaServicio`),
  KEY `fk_OfertaServicio_Oferta_idx` (`idOferta`),
  KEY `fk_OfertaServicio_Servicio_idx` (`idServicio`),
  CONSTRAINT `fk_OfertaServicio_Oferta` FOREIGN KEY (`idOferta`) REFERENCES `Ofertas` (`idOfertas`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_OfertaServicio_Servicio` FOREIGN KEY (`idServicio`) REFERENCES `Servicios` (`idServicios`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `OfertaServicio`
--

LOCK TABLES `OfertaServicio` WRITE;
/*!40000 ALTER TABLE `OfertaServicio` DISABLE KEYS */;
/*!40000 ALTER TABLE `OfertaServicio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Ofertas`
--

DROP TABLE IF EXISTS `Ofertas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Ofertas` (
  `idOfertas` varchar(15) COLLATE latin1_spanish_ci NOT NULL,
  `codOferta` varchar(45) COLLATE latin1_spanish_ci DEFAULT NULL,
  `nombre` varchar(45) COLLATE latin1_spanish_ci DEFAULT NULL,
  `fechaCreacion` date DEFAULT NULL,
  `fechaVence` date DEFAULT NULL,
  `procentaje` varchar(45) COLLATE latin1_spanish_ci DEFAULT NULL,
  `descripcion` varchar(45) COLLATE latin1_spanish_ci DEFAULT NULL,
  `idEstadoOfertaReservacion` int(11) NOT NULL,
  `idOfertaServicio` int(11) NOT NULL,
  PRIMARY KEY (`idOfertas`),
  KEY `fk_Ofertas_estado_idx` (`idEstadoOfertaReservacion`),
  CONSTRAINT `fk_Ofertas_estado` FOREIGN KEY (`idEstadoOfertaReservacion`) REFERENCES `EstadoOfertaReservacion` (`idEstadoOfertaReservacion`) ON DELETE cascade ON UPDATE cascade
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Ofertas`
--

LOCK TABLES `Ofertas` WRITE;
/*!40000 ALTER TABLE `Ofertas` DISABLE KEYS */;
/*!40000 ALTER TABLE `Ofertas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PerfilEmpleados`
--

DROP TABLE IF EXISTS `PerfilEmpleados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PerfilEmpleados` (
  `idPerfilEmpleados` int(11) NOT NULL,
  `perfil` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`idPerfilEmpleados`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PerfilEmpleados`
--

LOCK TABLES `PerfilEmpleados` WRITE;
/*!40000 ALTER TABLE `PerfilEmpleados` DISABLE KEYS */;
/*!40000 ALTER TABLE `PerfilEmpleados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Reservacion`
--

DROP TABLE IF EXISTS `Reservacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Reservacion` (
  `idReservacion` int(11) NOT NULL,
  `codReservacion` varchar(45) COLLATE latin1_spanish_ci NOT NULL,
  `valorAnticipo` decimal(10,2) NOT NULL,
  `procentaje` varchar(45) COLLATE latin1_spanish_ci NOT NULL,
  `FechaHoraReservacion` datetime DEFAULT NULL,
  `fechaHoraLlegada` datetime DEFAULT NULL,
  `fechaHoraIda` datetime DEFAULT NULL,
  `idCliente` varchar(15) COLLATE latin1_spanish_ci NOT NULL,
  `idEmpleado` varchar(15) COLLATE latin1_spanish_ci NOT NULL,
  `idServicio` varchar(15) COLLATE latin1_spanish_ci NOT NULL,
  `idEstadoOfertaReservacion` int(11) NOT NULL,
  PRIMARY KEY (`idReservacion`),
  KEY `fk_Reservacion_cliente_idx` (`idCliente`),
  KEY `fk_Reservacion_empleado_idx` (`idEmpleado`),
  KEY `fk_Reservacion_servicio_idx` (`idServicio`),
  KEY `fk_Reservacion_estadoReservacion_idx` (`idEstadoOfertaReservacion`),
  CONSTRAINT `fk_Reservacion_cliente` FOREIGN KEY (`idCliente`) REFERENCES `Clientes` (`idClientes`) ON DELETE cascade ON UPDATE cascade,
  CONSTRAINT `fk_Reservacion_empleado` FOREIGN KEY (`idEmpleado`) REFERENCES `Empleado` (`idEmpleado`) ON DELETE cascade ON UPDATE cascade,
  CONSTRAINT `fk_Reservacion_estadoReservacion` FOREIGN KEY (`idEstadoOfertaReservacion`) REFERENCES `EstadoOfertaReservacion` (`idEstadoOfertaReservacion`) ON DELETE cascade ON UPDATE cascade,
  CONSTRAINT `fk_Reservacion_servicio` FOREIGN KEY (`idServicio`) REFERENCES `Servicios` (`idServicios`) ON DELETE cascade ON UPDATE cascade
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Reservaci
--

LOCK TABLES `Reservacion` WRITE;
/*!40000 ALTER TABLE `Reservacion` DISABLE KEYS */;
/*!40000 ALTER TABLE `Reservacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Servicios`
--

DROP TABLE IF EXISTS `Servicios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Servicios` (
  `idServicios` varchar(15) COLLATE latin1_spanish_ci NOT NULL,
  `nombre` varchar(45) COLLATE latin1_spanish_ci NOT NULL,
  `precio` varchar(45) COLLATE latin1_spanish_ci DEFAULT NULL,
  `horario` datetime DEFAULT NULL,
  `descripcion` varchar(145) COLLATE latin1_spanish_ci DEFAULT NULL,
  `idCabanas` varchar(15) COLLATE latin1_spanish_ci NOT NULL,
  `idTour` varchar(15) COLLATE latin1_spanish_ci NOT NULL,
  `idTransporte` varchar(15) COLLATE latin1_spanish_ci NOT NULL,
  `estadoServicio` varchar(45) CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (`idServicios`),
  KEY `fk_Servicios_tour_idx` (`idTour`),
  KEY `fk_Servicios_cabana_idx` (`idCabanas`),
  KEY `fk_Servicios_transporte_idx` (`idTransporte`),
  CONSTRAINT `fk_Servicios_cabana` FOREIGN KEY (`idCabanas`) REFERENCES `Cabanas` (`idCabanas`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_Servicios_tour` FOREIGN KEY (`idTour`) REFERENCES `Tour` (`idTour`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_Servicios_transporte` FOREIGN KEY (`idTransporte`) REFERENCES `Transporte` (`idTransporte`) ON DELETE cascade ON UPDATE cascade
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Servicios`
--

LOCK TABLES `Servicios` WRITE;
/*!40000 ALTER TABLE `Servicios` DISABLE KEYS */;
/*!40000 ALTER TABLE `Servicios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TipoDestino`
--

DROP TABLE IF EXISTS `TipoDestino`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TipoDestino` (
  `idTipoDestino` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) COLLATE latin1_spanish_ci NOT NULL,
  `direccion` varchar(45) COLLATE latin1_spanish_ci NOT NULL,
  `caracteristicas` varchar(245) COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`idTipoDestino`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TipoDestino`
--

LOCK TABLES `TipoDestino` WRITE;
/*!40000 ALTER TABLE `TipoDestino` DISABLE KEYS */;
/*!40000 ALTER TABLE `TipoDestino` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Tour`
--

DROP TABLE IF EXISTS `Tour`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Tour` (
  `idTour` varchar(15) COLLATE latin1_spanish_ci NOT NULL,
  `codTour` varchar(45) COLLATE latin1_spanish_ci NOT NULL,
  `nombre` varchar(45) COLLATE latin1_spanish_ci DEFAULT NULL,
  `PrecioUni` varchar(45) COLLATE latin1_spanish_ci DEFAULT NULL,
  `idDestino` int(11) NOT NULL,
  `duracion` varchar(45) COLLATE latin1_spanish_ci DEFAULT NULL,
  `descripcion` varchar(45) COLLATE latin1_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`idTour`),
  KEY `fk_Tour_destino_idx` (`idDestino`),
  CONSTRAINT `fk_Tour_destino` FOREIGN KEY (`idDestino`) REFERENCES `TipoDestino` (`idTipoDestino`) ON DELETE cascade ON UPDATE cascade
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Tour`
--

LOCK TABLES `Tour` WRITE;
/*!40000 ALTER TABLE `Tour` DISABLE KEYS */;
/*!40000 ALTER TABLE `Tour` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Transporte`
--

DROP TABLE IF EXISTS `Transporte`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Transporte` (
  `idTransporte` varchar(15) COLLATE latin1_spanish_ci NOT NULL,
  `placa` varchar(45) COLLATE latin1_spanish_ci NOT NULL,
  `marca` varchar(45) COLLATE latin1_spanish_ci DEFAULT NULL,
  `modelo` varchar(45) COLLATE latin1_spanish_ci DEFAULT NULL,
  `color` varchar(45) COLLATE latin1_spanish_ci DEFAULT NULL,
  `tipo` varchar(45) COLLATE latin1_spanish_ci DEFAULT NULL,
  `capacidad` int(11) DEFAULT NULL,
  `precio` decimal(10,2) DEFAULT NULL,
  `foto` varchar(45) COLLATE latin1_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`idTransporte`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Transporte`
--

LOCK TABLES `Transporte` WRITE;
/*!40000 ALTER TABLE `Transporte` DISABLE KEYS */;
/*!40000 ALTER TABLE `Transporte` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Usuarios`
--

DROP TABLE IF EXISTS `Usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Usuarios` (
  `idUsuarios` varchar(15) COLLATE latin1_spanish_ci NOT NULL,
  `usuario` varchar(45) COLLATE latin1_spanish_ci NOT NULL,
  `password` varchar(45) COLLATE latin1_spanish_ci NOT NULL,
  `idCliente` varchar(15) COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`idUsuarios`),
  KEY `fk_Usuarios_cliente_idx` (`idCliente`),
  CONSTRAINT `fk_Usuarios_cliente` FOREIGN KEY (`idCliente`) REFERENCES `Clientes` (`idClientes`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Usuarios`
--

LOCK TABLES `Usuarios` WRITE;
/*!40000 ALTER TABLE `Usuarios` DISABLE KEYS */;
/*!40000 ALTER TABLE `Usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `UsuariosEmpleados`
--

DROP TABLE IF EXISTS `UsuariosEmpleados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `UsuariosEmpleados` (
  `idUsuariosEmpleados` varchar(15) COLLATE latin1_spanish_ci NOT NULL,
  `usuarioEmp` varchar(45) COLLATE latin1_spanish_ci NOT NULL,
  `passwordEmp` varchar(45) COLLATE latin1_spanish_ci NOT NULL,
  `idEmpleado` varchar(15) COLLATE latin1_spanish_ci NOT NULL,
  `idPerfil` int(11) NOT NULL,
  `fechaCreacion` datetime DEFAULT NULL,
  PRIMARY KEY (`idUsuariosEmpleados`),
  KEY `fk_UsuariosEmpleados_empleado_idx` (`idEmpleado`),
  KEY `fk_UsuariosEmpleados_perfil_idx` (`idPerfil`),
  CONSTRAINT `fk_UsuariosEmpleados_empleado` FOREIGN KEY (`idEmpleado`) REFERENCES `Empleado` (`idEmpleado`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_UsuariosEmpleados_perfil` FOREIGN KEY (`idPerfil`) REFERENCES `PerfilEmpleados` (`idPerfilEmpleados`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `UsuariosEmpleados`
--

LOCK TABLES `UsuariosEmpleados` WRITE;
/*!40000 ALTER TABLE `UsuariosEmpleados` DISABLE KEYS */;
/*!40000 ALTER TABLE `UsuariosEmpleados` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-10-10  2:16:25
