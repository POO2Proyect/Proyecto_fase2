-- phpMyAdmin SQL Dump
-- version 3.4.10.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 11-10-2017 a las 03:35:00
-- Versión del servidor: 5.5.20
-- Versión de PHP: 5.3.10

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `avanceii`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cabanas`
--

CREATE TABLE IF NOT EXISTS `cabanas` (
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

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE IF NOT EXISTS `clientes` (
  `idClientes` varchar(15) COLLATE latin1_spanish_ci NOT NULL,
  `dui` varchar(10) COLLATE latin1_spanish_ci NOT NULL,
  `nombre` varchar(45) COLLATE latin1_spanish_ci NOT NULL,
  `apellido` varchar(45) COLLATE latin1_spanish_ci NOT NULL,
  `telefono` varchar(45) COLLATE latin1_spanish_ci NOT NULL,
  `movil` varchar(45) COLLATE latin1_spanish_ci NOT NULL,
  `edad` varchar(10) COLLATE latin1_spanish_ci DEFAULT NULL,
  `correo` varchar(45) COLLATE latin1_spanish_ci NOT NULL,
  `direccion` varchar(45) COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`idClientes`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`idClientes`, `dui`, `nombre`, `apellido`, `telefono`, `movil`, `edad`, `correo`, `direccion`) VALUES
('MM132118', '0520269051', 'nestor', 'Suarez', '73933882', '25015230', '22', 'inestormelara@gmail.com', 'san salvador');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

CREATE TABLE IF NOT EXISTS `empleado` (
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

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estadoofertareservacion`
--

CREATE TABLE IF NOT EXISTS `estadoofertareservacion` (
  `idEstadoOfertaReservacion` int(11) NOT NULL AUTO_INCREMENT,
  `estado` varchar(45) COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`idEstadoOfertaReservacion`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ofertas`
--

CREATE TABLE IF NOT EXISTS `ofertas` (
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
  KEY `fk_Ofertas_estado_idx` (`idEstadoOfertaReservacion`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ofertaservicio`
--

CREATE TABLE IF NOT EXISTS `ofertaservicio` (
  `idOfertaServicio` int(11) NOT NULL AUTO_INCREMENT,
  `idOferta` varchar(15) COLLATE latin1_spanish_ci DEFAULT NULL,
  `idServicio` varchar(15) COLLATE latin1_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`idOfertaServicio`),
  KEY `fk_OfertaServicio_Oferta_idx` (`idOferta`),
  KEY `fk_OfertaServicio_Servicio_idx` (`idServicio`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `perfilempleados`
--

CREATE TABLE IF NOT EXISTS `perfilempleados` (
  `idPerfilEmpleados` int(11) NOT NULL,
  `perfil` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`idPerfilEmpleados`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reservacion`
--

CREATE TABLE IF NOT EXISTS `reservacion` (
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
  KEY `fk_Reservacion_estadoReservacion_idx` (`idEstadoOfertaReservacion`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `servicios`
--

CREATE TABLE IF NOT EXISTS `servicios` (
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
  KEY `fk_Servicios_transporte_idx` (`idTransporte`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipodestino`
--

CREATE TABLE IF NOT EXISTS `tipodestino` (
  `idTipoDestino` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) COLLATE latin1_spanish_ci NOT NULL,
  `direccion` varchar(45) COLLATE latin1_spanish_ci NOT NULL,
  `caracteristicas` varchar(245) COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`idTipoDestino`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tour`
--

CREATE TABLE IF NOT EXISTS `tour` (
  `idTour` varchar(15) COLLATE latin1_spanish_ci NOT NULL,
  `codTour` varchar(45) COLLATE latin1_spanish_ci NOT NULL,
  `nombre` varchar(45) COLLATE latin1_spanish_ci DEFAULT NULL,
  `PrecioUni` varchar(45) COLLATE latin1_spanish_ci DEFAULT NULL,
  `idDestino` int(11) NOT NULL,
  `duracion` varchar(45) COLLATE latin1_spanish_ci DEFAULT NULL,
  `descripcion` varchar(45) COLLATE latin1_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`idTour`),
  KEY `fk_Tour_destino_idx` (`idDestino`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `transporte`
--

CREATE TABLE IF NOT EXISTS `transporte` (
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

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE IF NOT EXISTS `usuarios` (
  `idUsuarios` varchar(15) COLLATE latin1_spanish_ci NOT NULL,
  `usuario` varchar(45) COLLATE latin1_spanish_ci NOT NULL,
  `password` varchar(45) COLLATE latin1_spanish_ci NOT NULL,
  `idCliente` varchar(15) COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`idUsuarios`),
  KEY `fk_Usuarios_cliente_idx` (`idCliente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuariosempleados`
--

CREATE TABLE IF NOT EXISTS `usuariosempleados` (
  `idUsuariosEmpleados` varchar(15) COLLATE latin1_spanish_ci NOT NULL,
  `usuarioEmp` varchar(45) COLLATE latin1_spanish_ci NOT NULL,
  `passwordEmp` varchar(45) COLLATE latin1_spanish_ci NOT NULL,
  `idEmpleado` varchar(15) COLLATE latin1_spanish_ci NOT NULL,
  `idPerfil` int(11) NOT NULL,
  `fechaCreacion` datetime DEFAULT NULL,
  PRIMARY KEY (`idUsuariosEmpleados`),
  KEY `fk_UsuariosEmpleados_empleado_idx` (`idEmpleado`),
  KEY `fk_UsuariosEmpleados_perfil_idx` (`idPerfil`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `ofertas`
--
ALTER TABLE `ofertas`
  ADD CONSTRAINT `fk_Ofertas_estado` FOREIGN KEY (`idEstadoOfertaReservacion`) REFERENCES `estadoofertareservacion` (`idEstadoOfertaReservacion`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `ofertaservicio`
--
ALTER TABLE `ofertaservicio`
  ADD CONSTRAINT `fk_OfertaServicio_Oferta` FOREIGN KEY (`idOferta`) REFERENCES `ofertas` (`idOfertas`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_OfertaServicio_Servicio` FOREIGN KEY (`idServicio`) REFERENCES `servicios` (`idServicios`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `reservacion`
--
ALTER TABLE `reservacion`
  ADD CONSTRAINT `fk_Reservacion_cliente` FOREIGN KEY (`idCliente`) REFERENCES `clientes` (`idClientes`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_Reservacion_empleado` FOREIGN KEY (`idEmpleado`) REFERENCES `empleado` (`idEmpleado`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_Reservacion_estadoReservacion` FOREIGN KEY (`idEstadoOfertaReservacion`) REFERENCES `estadoofertareservacion` (`idEstadoOfertaReservacion`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_Reservacion_servicio` FOREIGN KEY (`idServicio`) REFERENCES `servicios` (`idServicios`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `servicios`
--
ALTER TABLE `servicios`
  ADD CONSTRAINT `fk_Servicios_cabana` FOREIGN KEY (`idCabanas`) REFERENCES `cabanas` (`idCabanas`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_Servicios_tour` FOREIGN KEY (`idTour`) REFERENCES `tour` (`idTour`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_Servicios_transporte` FOREIGN KEY (`idTransporte`) REFERENCES `transporte` (`idTransporte`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `tour`
--
ALTER TABLE `tour`
  ADD CONSTRAINT `fk_Tour_destino` FOREIGN KEY (`idDestino`) REFERENCES `tipodestino` (`idTipoDestino`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD CONSTRAINT `fk_Usuarios_cliente` FOREIGN KEY (`idCliente`) REFERENCES `clientes` (`idClientes`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `usuariosempleados`
--
ALTER TABLE `usuariosempleados`
  ADD CONSTRAINT `fk_UsuariosEmpleados_empleado` FOREIGN KEY (`idEmpleado`) REFERENCES `empleado` (`idEmpleado`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_UsuariosEmpleados_perfil` FOREIGN KEY (`idPerfil`) REFERENCES `perfilempleados` (`idPerfilEmpleados`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
