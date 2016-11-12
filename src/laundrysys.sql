-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 01-10-2016 a las 23:55:43
-- Versión del servidor: 10.1.10-MariaDB
-- Versión de PHP: 7.0.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `laundrysys`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `consumabletable`
--

CREATE TABLE `consumabletable` (
  `id` int(11) NOT NULL,
  `name` varchar(120) NOT NULL,
  `description` varchar(240) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detailpurchasetable`
--

CREATE TABLE `detailpurchasetable` (
  `id` int(11) NOT NULL,
  `idInvoicePurchase` int(11) NOT NULL,
  `idConsumable` int(11) NOT NULL,
  `priceConsumable` double NOT NULL,
  `quantityConsumable` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `invoicepurchasetable`
--

CREATE TABLE `invoicepurchasetable` (
  `id` int(11) NOT NULL,
  `idSupplier` int(11) NOT NULL,
  `date` date NOT NULL,
  `totalPrice` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `suppliertable`
--

CREATE TABLE `suppliertable` (
  `id` int(12) NOT NULL,
  `name` varchar(120) NOT NULL,
  `address` varchar(240) NOT NULL,
  `telephone` varchar(60) NOT NULL,
  `mail` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `consumabletable`
--
ALTER TABLE `consumabletable`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id` (`id`),
  ADD KEY `id_2` (`id`);

--
-- Indices de la tabla `detailpurchasetable`
--
ALTER TABLE `detailpurchasetable`
  ADD PRIMARY KEY (`id`,`idInvoicePurchase`,`idConsumable`),
  ADD KEY `idInvoicePurchase` (`idInvoicePurchase`),
  ADD KEY `idConsumable` (`idConsumable`);

--
-- Indices de la tabla `invoicepurchasetable`
--
ALTER TABLE `invoicepurchasetable`
  ADD PRIMARY KEY (`id`,`idSupplier`);

--
-- Indices de la tabla `suppliertable`
--
ALTER TABLE `suppliertable`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id` (`id`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `detailpurchasetable`
--
ALTER TABLE `detailpurchasetable`
  ADD CONSTRAINT `detailpurchasetable_ibfk_1` FOREIGN KEY (`idInvoicePurchase`) REFERENCES `invoicepurchasetable` (`id`),
  ADD CONSTRAINT `detailpurchasetable_ibfk_2` FOREIGN KEY (`idConsumable`) REFERENCES `consumabletable` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
