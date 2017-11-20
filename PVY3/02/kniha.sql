-- phpMyAdmin SQL Dump
-- version 4.3.11
-- http://www.phpmyadmin.net
--
-- Počítač: 127.0.0.1
-- Vytvořeno: Pon 16. říj 2017, 08:29
-- Verze serveru: 5.6.24
-- Verze PHP: 5.6.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Databáze: `it3prog`
--

-- --------------------------------------------------------

--
-- Struktura tabulky `kniha`
--

CREATE TABLE IF NOT EXISTS `kniha` (
  `Kodknihy` int(6) unsigned NOT NULL,
  `Titul` varchar(100) COLLATE utf8_czech_ci NOT NULL,
  `Popis` text COLLATE utf8_czech_ci,
  `RokVydani` year(4) DEFAULT NULL,
  `Cena` decimal(6,2) DEFAULT NULL,
  `Typ` enum('poezie','próza','drama') CHARACTER SET utf8 DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8 COLLATE=utf8_czech_ci;

--
-- Vypisuji data pro tabulku `kniha`
--

INSERT INTO `kniha` (`Kodknihy`, `Titul`, `Popis`, `RokVydani`, `Cena`, `Typ`) VALUES
(1, 'Šibeničník', 'Výbor z poezie francouzského básníka Francoise Villona', 1987, '25.00', 'poezie'),
(3, 'Má bohéma', 'Poezie Arthura Rimbauda', 1977, '35.00', 'poezie'),
(4, 'Hvězdný déšť', 'Výbor z poezie', 1989, '28.00', 'poezie'),
(5, 'Doktor Živago', 'Román z ruského prostředí v letech 1902 až 1940', 1990, '48.00', 'próza'),
(28, 'Indiánské léto', 'Reportážní črty které místy přecházejí v báseň nebo v povídku. Aškenazy úřijel do New Yorku jako zpravodaj na zasedání OSN a využil volného času k poznání života Ameriky - dotýká se problémů USA, ale i moderního života vůbec. Jsou zde i prosté lyrické scény - pozorování elektrické krásy s okna hotelu apod. Nad vším je jemný opar smutku.', 1956, '22.00', 'próza'),
(41, 'Žhář', 'Hrdinou románu je patnáctiletý syn hostinského Kamil v malém městečku u pruských hranic - prožívá pubertální krizi; připadá si osamocený, nepochopený, touží po sebeuplatnění. V rodině jeho otce Simona však vládne podivný citový chlad - jeho mnohem mladší žena je nešťastná, nepřilne ani ke svým dětem - k sedmnáctileté Elišce. Matka žije jako cizinka ve své rodině a nakonec si vytvoří se zděděného nábytku po rodičích svůj dřívější svět. K Elišce přijde na návštěvu Dora - citově a mravně narušené děvče z internátu, které si  začne s Kamilem eroticky zahrávat a zároveň ho pokořuje - žádá, aby pro ni něco velkého udělal. Kamil, který trpí svou ošklivostí, chce dokázat Doře i sám sobě svou hodnotu, a pro to po náhodném požáru v městečku napíše dva paličské listy. Po obou skutečně následují požáry - zakládají je však 3 kumpáni, kteří zneužili psychózy a vyřizují si své účty. Kamil se matce přiznává a ta pochopí, že děti potřebují lásku a přibližuje se k nim ze své cizoty.', 1937, '20.00', 'próza');

--
-- Klíče pro exportované tabulky
--

--
-- Klíče pro tabulku `kniha`
--
ALTER TABLE `kniha`
  ADD PRIMARY KEY (`Kodknihy`), ADD KEY `titul` (`Titul`), ADD KEY `rok` (`RokVydani`), ADD KEY `cena` (`Cena`);

--
-- AUTO_INCREMENT pro tabulky
--

--
-- AUTO_INCREMENT pro tabulku `kniha`
--
ALTER TABLE `kniha`
  MODIFY `Kodknihy` int(6) unsigned NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=42;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
