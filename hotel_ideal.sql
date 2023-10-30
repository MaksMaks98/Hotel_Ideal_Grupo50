-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 30-10-2023 a las 02:05:01
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `hotel_ideal`
--
CREATE DATABASE IF NOT EXISTS `hotel_ideal` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `hotel_ideal`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

CREATE TABLE `categoria` (
  `idCategoria` int(11) NOT NULL,
  `nomCategoria` varchar(100) NOT NULL,
  `cantidadCamas` int(11) NOT NULL,
  `cantPersonas` int(11) NOT NULL,
  `tipoCama` varchar(60) NOT NULL,
  `precio` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `categoria`
--

INSERT INTO `categoria` (`idCategoria`, `nomCategoria`, `cantidadCamas`, `cantPersonas`, `tipoCama`, `precio`) VALUES
(9, 'Estándar', 1, 2, '1 cama matrimonial ', 10000),
(10, 'Simple', 1, 1, '1 cama individual', 6000),
(11, 'Doble', 2, 2, '2 individuales', 6000),
(12, 'Triple', 2, 3, '1 cama matrimonial y 1 individual', 8000),
(13, 'Cuádruple', 3, 4, '1 cama matrimonial y 2 individuales', 14000),
(14, 'Suite Lujo', 1, 2, '1 cama king-size', 14000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `habitacion`
--

CREATE TABLE `habitacion` (
  `idHabitacion` int(200) NOT NULL,
  `numHabitacion` int(11) NOT NULL,
  `idCategoria` int(11) NOT NULL,
  `piso` int(11) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `habitacion`
--

INSERT INTO `habitacion` (`idHabitacion`, `numHabitacion`, `idCategoria`, `piso`, `estado`) VALUES
(1, 213, 10, 3, 0),
(2, 513, 11, 5, 1),
(3, 413, 9, 4, 0),
(4, 10, 9, 3, 1),
(6, 9, 13, 0, 0),
(7, 1, 9, 0, 0),
(10, 4, 13, 0, 0),
(11, 7, 13, 0, 0),
(12, 120, 12, 1, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `huesped`
--

CREATE TABLE `huesped` (
  `idHuesped` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `apellido` varchar(30) NOT NULL,
  `dni` varchar(20) NOT NULL,
  `domicilio` varchar(100) NOT NULL,
  `correo` varchar(100) NOT NULL,
  `celular` varchar(20) NOT NULL,
  `estado` tinyint(4) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `huesped`
--

INSERT INTO `huesped` (`idHuesped`, `nombre`, `apellido`, `dni`, `domicilio`, `correo`, `celular`, `estado`) VALUES
(2, 'Pablo', 'Estevanez', '23345567', 'La Plata', 'Pablo_example@gmail.com', '456789087', 0),
(3, 'Ciro', 'Del Barco', '234666786', 'Córdoba', 'Ciro_example@gmail.com', '234555677', 1),
(4, 'María', 'Luisa', '345666789', 'La Pampa', 'MariaL_example@gmail.com', '234555677', 0),
(5, 'Teresa', 'Barrionuevo', '4446786', 'Tucuman', 'Teresa_example@gmail.com', '555577', 1),
(7, 'Elsa', 'Rivero', '678886', 'San Luis', 'Elsa_example@gmail.com', '6666577', 0),
(11, 'Rosa', 'Del Valle', '34555234', 'Catamarca', 'Rosa_example@gmail.com', '234233334', 0),
(16, '', '', '23345568', 'La Plata', 'Pablo_example@gmail.com', '456789087', 0),
(18, '', '', '23345564', 'La Plata', 'Pablo_example@gmail.com', '456789087', 0),
(19, '', '', '23345561', 'La Plata', 'Pablo_example@gmail.com', '456789087', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reserva`
--

CREATE TABLE `reserva` (
  `idReserva` int(11) NOT NULL,
  `idHuesped` int(11) NOT NULL,
  `idHabitacion` int(11) NOT NULL,
  `cantidadPersona` int(11) NOT NULL,
  `fechaIngreso` date NOT NULL,
  `fechaSalida` date NOT NULL,
  `monto` double NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `reserva`
--

INSERT INTO `reserva` (`idReserva`, `idHuesped`, `idHabitacion`, `cantidadPersona`, `fechaIngreso`, `fechaSalida`, `monto`, `estado`) VALUES
(1, 5, 3, 3, '2023-04-21', '2023-04-25', 10000, 0),
(2, 5, 2, 3, '2023-04-13', '2023-04-30', 102000, 1),
(3, 3, 4, 3, '2023-02-10', '2023-05-02', 40000, 1),
(10, 5, 4, 3, '2023-11-30', '2023-12-25', 250000, 0),
(11, 4, 1, 1, '2023-10-27', '2023-10-29', 12000, 1),
(12, 4, 3, 2, '2023-10-27', '2023-11-08', 120000, 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`idCategoria`),
  ADD UNIQUE KEY `idCategoria` (`idCategoria`);

--
-- Indices de la tabla `habitacion`
--
ALTER TABLE `habitacion`
  ADD PRIMARY KEY (`idHabitacion`),
  ADD UNIQUE KEY `numHabitacion` (`numHabitacion`),
  ADD KEY `idCategoria` (`idCategoria`);

--
-- Indices de la tabla `huesped`
--
ALTER TABLE `huesped`
  ADD PRIMARY KEY (`idHuesped`),
  ADD UNIQUE KEY `dni` (`dni`);

--
-- Indices de la tabla `reserva`
--
ALTER TABLE `reserva`
  ADD PRIMARY KEY (`idReserva`),
  ADD KEY `idHuesped` (`idHuesped`,`idHabitacion`),
  ADD KEY `idHabitacion` (`idHabitacion`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `categoria`
--
ALTER TABLE `categoria`
  MODIFY `idCategoria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT de la tabla `habitacion`
--
ALTER TABLE `habitacion`
  MODIFY `idHabitacion` int(200) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `huesped`
--
ALTER TABLE `huesped`
  MODIFY `idHuesped` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT de la tabla `reserva`
--
ALTER TABLE `reserva`
  MODIFY `idReserva` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `habitacion`
--
ALTER TABLE `habitacion`
  ADD CONSTRAINT `habitacion_ibfk_1` FOREIGN KEY (`idCategoria`) REFERENCES `categoria` (`idCategoria`);

--
-- Filtros para la tabla `reserva`
--
ALTER TABLE `reserva`
  ADD CONSTRAINT `reserva_ibfk_1` FOREIGN KEY (`idHabitacion`) REFERENCES `habitacion` (`idHabitacion`),
  ADD CONSTRAINT `reserva_ibfk_2` FOREIGN KEY (`idHuesped`) REFERENCES `huesped` (`idHuesped`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
