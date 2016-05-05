-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 05-05-2016 a las 17:25:32
-- Versión del servidor: 5.7.11-log
-- Versión de PHP: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `biblioteca`
--
CREATE DATABASE IF NOT EXISTS `biblioteca` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `biblioteca`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `autor`
--

DROP TABLE IF EXISTS `autor`;
CREATE TABLE IF NOT EXISTS `autor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL DEFAULT '0',
  `apellido` varchar(75) NOT NULL DEFAULT '0',
  `nacionalidad` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bibliotecario`
--

DROP TABLE IF EXISTS `bibliotecario`;
CREATE TABLE IF NOT EXISTS `bibliotecario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL DEFAULT '0',
  `apellido` varchar(50) NOT NULL DEFAULT '0',
  `direccion` varchar(50) NOT NULL DEFAULT '0',
  `FechaNacimiento` date NOT NULL DEFAULT '0000-00-00',
  `email` varchar(50) NOT NULL DEFAULT '0',
  `telefono` varchar(50) NOT NULL DEFAULT '0',
  `fechaIngreso` date NOT NULL DEFAULT '0000-00-00',
  `cedula` varchar(50) NOT NULL DEFAULT '0',
  `categoria` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estadosistema`
--

DROP TABLE IF EXISTS `estadosistema`;
CREATE TABLE IF NOT EXISTS `estadosistema` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `libros` int(11) NOT NULL DEFAULT '0',
  `prestados` int(11) NOT NULL DEFAULT '0',
  `recepcion` int(11) NOT NULL DEFAULT '0',
  `usuarios` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `FK_estadosistema_libros` (`libros`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `lector`
--

DROP TABLE IF EXISTS `lector`;
CREATE TABLE IF NOT EXISTS `lector` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL DEFAULT '0',
  `apellido` varchar(50) NOT NULL DEFAULT '0',
  `FechaNacimiento` date NOT NULL DEFAULT '0000-00-00',
  `telefono` varchar(50) NOT NULL DEFAULT '0',
  `categoria` varchar(50) NOT NULL DEFAULT '0',
  `cedula` varchar(50) NOT NULL DEFAULT '0',
  `direccion` varchar(50) NOT NULL DEFAULT '0',
  `email` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libros`
--

DROP TABLE IF EXISTS `libros`;
CREATE TABLE IF NOT EXISTS `libros` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Titulo` varchar(50) DEFAULT NULL,
  `id_autor` int(11) DEFAULT '0',
  `editor` varchar(50) DEFAULT '0',
  `genero` varchar(50) DEFAULT '0',
  `subgenero` varchar(50) DEFAULT '0',
  `idioma` varchar(50) DEFAULT '0',
  `id_estado` varchar(50) DEFAULT '0',
  `categoria` varchar(50) DEFAULT '0',
  `publicacion` varchar(50) DEFAULT '0',
  `editorial` varchar(50) DEFAULT '0',
  `numeroPagina` int(11) DEFAULT '0',
  `estadoFisico` varchar(50) DEFAULT '0',
  `cantidad` int(11) DEFAULT '0',
  `edicion` varchar(50) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `FK_libros_autor` (`id_autor`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `login`
--

DROP TABLE IF EXISTS `login`;
CREATE TABLE IF NOT EXISTS `login` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `usuario` varchar(50) DEFAULT '0',
  `contrasena` varchar(50) DEFAULT '0',
  `permiso` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `prestamo`
--

DROP TABLE IF EXISTS `prestamo`;
CREATE TABLE IF NOT EXISTS `prestamo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL DEFAULT '0000-00-00',
  `horaPrestamo` time NOT NULL DEFAULT '00:00:00',
  `horaEntrega` time NOT NULL DEFAULT '00:00:00',
  `estado` varchar(50) NOT NULL DEFAULT '0',
  `id_bibliotecario` int(11) NOT NULL DEFAULT '0',
  `id_libro` int(11) NOT NULL DEFAULT '0',
  `id_lector` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `FK_prestamo_bibliotecario` (`id_bibliotecario`),
  KEY `FK_prestamo_libros` (`id_libro`),
  KEY `FK_prestamo_lector` (`id_lector`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `estadosistema`
--
ALTER TABLE `estadosistema`
  ADD CONSTRAINT `FK_estadosistema_libros` FOREIGN KEY (`libros`) REFERENCES `libros` (`id`);

--
-- Filtros para la tabla `libros`
--
ALTER TABLE `libros`
  ADD CONSTRAINT `FK_libros_autor` FOREIGN KEY (`id_autor`) REFERENCES `autor` (`id`);

--
-- Filtros para la tabla `prestamo`
--
ALTER TABLE `prestamo`
  ADD CONSTRAINT `FK_prestamo_bibliotecario` FOREIGN KEY (`id_bibliotecario`) REFERENCES `bibliotecario` (`id`),
  ADD CONSTRAINT `FK_prestamo_lector` FOREIGN KEY (`id_lector`) REFERENCES `lector` (`id`),
  ADD CONSTRAINT `FK_prestamo_libros` FOREIGN KEY (`id_libro`) REFERENCES `libros` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
