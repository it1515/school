-- phpMyAdmin SQL Dump
-- version 4.3.11
-- http://www.phpmyadmin.net
--
-- Počítač: 127.0.0.1
-- Vytvořeno: Úte 20. bře 2018, 08:05
-- Verze serveru: 5.6.24
-- Verze PHP: 5.6.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Databáze: `slovnik`
--

-- --------------------------------------------------------

--
-- Struktura tabulky `slovnicek`
--

CREATE TABLE IF NOT EXISTS `slovnicek` (
  `id` int(11) NOT NULL,
  `cs` varchar(50) CHARACTER SET utf8 COLLATE utf8_czech_ci NOT NULL,
  `en` varchar(50) CHARACTER SET utf8 COLLATE utf8_czech_ci NOT NULL,
  `pl` varchar(50) DEFAULT NULL,
  `obtiznost` int(11) NOT NULL DEFAULT '1'
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

--
-- Vypisuji data pro tabulku `slovnicek`
--

INSERT INTO `slovnicek` (`id`, `cs`, `en`, `pl`, `obtiznost`) VALUES
(1, 'počítač', 'computer', 'komputer', 2),
(4, 'plamen', 'flame', 'plomien', 1),
(6, 'oheň', 'fire', 'ogien', 2),
(8, 'léto', 'summer', 'lato', 1),
(9, 'stůl', 'table', 'tabela', 1),
(12, 'trolejbus', 'bus', 'lol', 5),
(13, 'židle', 'chair', 'krzeslo', 1),
(14, 'lano', 'rope', 'lina', 3),
(15, 'řízek', 'schnitzel', 'sadzonki', 4),
(16, 'hledat', 'to search', 'szukaj', 5);

--
-- Klíče pro exportované tabulky
--

--
-- Klíče pro tabulku `slovnicek`
--
ALTER TABLE `slovnicek`
  ADD PRIMARY KEY (`id`), ADD KEY `slovnicek_cs_idx` (`cs`), ADD KEY `slovnicek_en_idx` (`en`);

--
-- AUTO_INCREMENT pro tabulky
--

--
-- AUTO_INCREMENT pro tabulku `slovnicek`
--
ALTER TABLE `slovnicek`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=17;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
