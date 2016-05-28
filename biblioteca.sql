-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         5.6.26 - MySQL Community Server (GPL)
-- SO del servidor:              Win32
-- HeidiSQL Versión:             9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Volcando estructura de base de datos para biblioteca
CREATE DATABASE IF NOT EXISTS `biblioteca` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `biblioteca`;


-- Volcando estructura para tabla biblioteca.autor
CREATE TABLE IF NOT EXISTS `autor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) DEFAULT '0',
  `apellido` varchar(20) DEFAULT '0',
  `nacionalidad` varchar(20) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- La exportación de datos fue deseleccionada.


-- Volcando estructura para tabla biblioteca.bibliotecario
CREATE TABLE IF NOT EXISTS `bibliotecario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL DEFAULT '0',
  `apellido` varchar(50) NOT NULL DEFAULT '0',
  `FechaNacimiento` date NOT NULL DEFAULT '0000-00-00',
  `email` varchar(50) NOT NULL DEFAULT '0',
  `telefono` varchar(50) NOT NULL DEFAULT '0',
  `fechaIngreso` date NOT NULL DEFAULT '0000-00-00',
  `cedula` varchar(50) NOT NULL DEFAULT '0',
  `tanda` varchar(50) NOT NULL DEFAULT '0',
  `calle` varchar(30) DEFAULT NULL,
  `sector` varchar(30) DEFAULT NULL,
  `ciudad` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- La exportación de datos fue deseleccionada.


-- Volcando estructura para tabla biblioteca.estado
CREATE TABLE IF NOT EXISTS `estado` (
  `id` int(11) NOT NULL,
  `condicion` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- La exportación de datos fue deseleccionada.


-- Volcando estructura para tabla biblioteca.estadosistema
CREATE TABLE IF NOT EXISTS `estadosistema` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `libros` int(11) DEFAULT '0',
  `prestados` int(11) DEFAULT '0',
  `recepcion` int(11) DEFAULT '0',
  `usuarios` int(11) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `FK_estadosistema_libros` (`libros`),
  CONSTRAINT `FK_estadosistema_libros` FOREIGN KEY (`libros`) REFERENCES `libros` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- La exportación de datos fue deseleccionada.


-- Volcando estructura para tabla biblioteca.lector
CREATE TABLE IF NOT EXISTS `lector` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL DEFAULT '0',
  `apellido` varchar(50) NOT NULL DEFAULT '0',
  `FechaNacimiento` date NOT NULL DEFAULT '1900-01-01',
  `telefono` varchar(50) NOT NULL DEFAULT '0',
  `categoria` varchar(50) NOT NULL DEFAULT '0',
  `cedula` varchar(50) NOT NULL DEFAULT '0',
  `email` varchar(50) NOT NULL DEFAULT '0',
  `calle` varchar(30) DEFAULT NULL,
  `sector` varchar(30) DEFAULT NULL,
  `ciudad` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- La exportación de datos fue deseleccionada.


-- Volcando estructura para tabla biblioteca.libros
CREATE TABLE IF NOT EXISTS `libros` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(20) DEFAULT NULL,
  `id_autor` int(11) DEFAULT NULL,
  `editor` varchar(20) DEFAULT NULL,
  `genero` varchar(20) DEFAULT NULL,
  `subgenero` varchar(20) DEFAULT NULL,
  `idioma` varchar(20) DEFAULT NULL,
  `id_estado` varchar(20) DEFAULT NULL,
  `categoria` varchar(10) DEFAULT NULL,
  `publicacion` varchar(20) DEFAULT NULL,
  `editorial` varchar(20) DEFAULT NULL,
  `numeroPagina` int(11) DEFAULT NULL,
  `estadoFisico` varchar(20) DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `edicion` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_libros_autor` (`id_autor`),
  CONSTRAINT `FK_libros_autor` FOREIGN KEY (`id_autor`) REFERENCES `autor` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- La exportación de datos fue deseleccionada.


-- Volcando estructura para tabla biblioteca.login
CREATE TABLE IF NOT EXISTS `login` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `usuario` varchar(20) DEFAULT '0',
  `contrasena` varchar(20) DEFAULT '0',
  `permiso` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- La exportación de datos fue deseleccionada.


-- Volcando estructura para tabla biblioteca.prestamo
CREATE TABLE IF NOT EXISTS `prestamo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` date DEFAULT '0000-00-00',
  `horaPrestamo` time DEFAULT '00:00:00',
  `horaEntrega` time DEFAULT '00:00:00',
  `estado` int(11) DEFAULT '0',
  `id_bibliotecario` int(11) DEFAULT '0',
  `id_libro` int(11) DEFAULT '0',
  `id_lector` int(11) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `FK_prestamo_bibliotecario` (`id_bibliotecario`),
  KEY `FK_prestamo_libros` (`id_libro`),
  KEY `FK_prestamo_lector` (`id_lector`),
  KEY `FK_prestamo_estado` (`estado`),
  CONSTRAINT `FK_prestamo_bibliotecario` FOREIGN KEY (`id_bibliotecario`) REFERENCES `bibliotecario` (`id`),
  CONSTRAINT `FK_prestamo_estado` FOREIGN KEY (`estado`) REFERENCES `estado` (`id`),
  CONSTRAINT `FK_prestamo_lector` FOREIGN KEY (`id_lector`) REFERENCES `lector` (`id`),
  CONSTRAINT `FK_prestamo_libros` FOREIGN KEY (`id_libro`) REFERENCES `libros` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- La exportación de datos fue deseleccionada.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
