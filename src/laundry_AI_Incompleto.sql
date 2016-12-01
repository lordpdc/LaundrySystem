-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 01-12-2016 a las 17:46:06
-- Versión del servidor: 10.1.19-MariaDB
-- Versión de PHP: 5.6.28

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
-- Estructura de tabla para la tabla `customertable`
--

CREATE TABLE `customertable` (
  `id` int(11) NOT NULL,
  `name` varchar(120) NOT NULL,
  `phone` varchar(120) NOT NULL,
  `mail` varchar(120) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `purchasedetailstable`
--

CREATE TABLE `purchasedetailstable` (
  `id` int(11) NOT NULL,
  `idInvoicePurchase` int(11) NOT NULL,
  `idConsumable` int(11) NOT NULL,
  `priceConsumable` double NOT NULL,
  `quantityConsumable` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `purchaseinvoicetable`
--

CREATE TABLE `purchaseinvoicetable` (
  `id` int(11) NOT NULL,
  `idSupplier` int(11) NOT NULL,
  `date` date NOT NULL,
  `totalPrice` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `saledetailstable`
--

CREATE TABLE `saledetailstable` (
  `id` int(11) NOT NULL,
  `idSaleInvoice` int(11) NOT NULL,
  `idService` int(11) NOT NULL,
  `amount` double NOT NULL,
  `price` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `saleinvoicetable`
--

CREATE TABLE `saleinvoicetable` (
  `id` int(11) NOT NULL,
  `idCustomer` int(11) NOT NULL,
  `date` date NOT NULL,
  `totalPrice` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `servicetable`
--

CREATE TABLE `servicetable` (
  `id` int(11) NOT NULL,
  `name` varchar(120) NOT NULL,
  `description` varchar(240) NOT NULL,
  `unitariPrice` double NOT NULL
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
-- Indices de la tabla `customertable`
--
ALTER TABLE `customertable`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `purchasedetailstable`
--
ALTER TABLE `purchasedetailstable`
  ADD PRIMARY KEY (`id`,`idInvoicePurchase`,`idConsumable`),
  ADD KEY `idConsumable` (`idConsumable`),
  ADD KEY `idInvoicePurchase` (`idInvoicePurchase`) USING BTREE;

--
-- Indices de la tabla `purchaseinvoicetable`
--
ALTER TABLE `purchaseinvoicetable`
  ADD PRIMARY KEY (`id`,`idSupplier`),
  ADD KEY `idSupplier` (`idSupplier`);

--
-- Indices de la tabla `saledetailstable`
--
ALTER TABLE `saledetailstable`
  ADD PRIMARY KEY (`id`,`idSaleInvoice`,`idService`),
  ADD KEY `idSaleInvoice` (`idSaleInvoice`),
  ADD KEY `idService` (`idService`);

--
-- Indices de la tabla `saleinvoicetable`
--
ALTER TABLE `saleinvoicetable`
  ADD PRIMARY KEY (`id`,`idCustomer`),
  ADD KEY `idCustomer` (`idCustomer`);

--
-- Indices de la tabla `servicetable`
--
ALTER TABLE `servicetable`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `suppliertable`
--
ALTER TABLE `suppliertable`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id` (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `customertable`
--
ALTER TABLE `customertable`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `purchasedetailstable`
--
ALTER TABLE `purchasedetailstable`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `saledetailstable`
--
ALTER TABLE `saledetailstable`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `saleinvoicetable`
--
ALTER TABLE `saleinvoicetable`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `servicetable`
--
ALTER TABLE `servicetable`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `suppliertable`
--
ALTER TABLE `suppliertable`
  MODIFY `id` int(12) NOT NULL AUTO_INCREMENT;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `purchasedetailstable`
--
ALTER TABLE `purchasedetailstable`
  ADD CONSTRAINT `purchasedetailstable_ibfk_1` FOREIGN KEY (`idInvoicePurchase`) REFERENCES `purchaseinvoicetable` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `purchasedetailstable_ibfk_2` FOREIGN KEY (`idConsumable`) REFERENCES `consumabletable` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
