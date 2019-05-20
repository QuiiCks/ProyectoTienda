-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost:3306
-- Tiempo de generación: 20-05-2019 a las 06:12:24
-- Versión del servidor: 5.7.23
-- Versión de PHP: 7.1.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `proyectotienda`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `coches`
--

CREATE TABLE `coches` (
  `id` int(11) NOT NULL,
  `Matricula` varchar(10) NOT NULL,
  `Marca` varchar(10) DEFAULT NULL,
  `Modelo` varchar(30) DEFAULT NULL,
  `Ano` varchar(4) DEFAULT NULL,
  `Precio` varchar(10) DEFAULT NULL,
  `KM` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `coches`
--

INSERT INTO `coches` (`id`, `Matricula`, `Marca`, `Modelo`, `Ano`, `Precio`, `KM`) VALUES
(4, '3203DXB', 'Toyota', 'Pryus', '2016', '60000', 0),
(7, '6545KKK', 'Volvo', 'S80', '2019', '50000', 0),
(9, '3526WQW', 'Seat', 'Ibiza', '2019', '15000', 0),
(12, '4555ADF', 'Opel', 'Corsa', '2000', '5000', 50000),
(14, '9754WDR', 'Ford', 'S-Max', '2015', '5000', 5000),
(15, '6548ASD', 'Opel', 'Corsa', '2016', '2000', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `seguro`
--

CREATE TABLE `seguro` (
  `id_matricula` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido1` varchar(50) DEFAULT NULL,
  `apellido2` varchar(50) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `seguro`
--

INSERT INTO `seguro` (`id_matricula`, `nombre`, `apellido1`, `apellido2`, `email`) VALUES
(4, 'Javi', 'Ruiz', 'Anaya', 'javi@javi.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `users`
--

CREATE TABLE `users` (
  `User` varchar(10) NOT NULL,
  `Password` varchar(12) DEFAULT NULL,
  `Rol` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `users`
--

INSERT INTO `users` (`User`, `Password`, `Rol`) VALUES
('', '', 'Admin'),
('123', '', ''),
('alvaro', '123456', 'Usuario'),
('Javi', '123456', 'Admin'),
('maximo', '123456', 'Admin'),
('nanaya44', 'nanaya44', 'Usuario');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `coches`
--
ALTER TABLE `coches`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`User`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `coches`
--
ALTER TABLE `coches`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
