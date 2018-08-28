-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 27, 2018 at 10:59 PM
-- Server version: 10.1.28-MariaDB
-- PHP Version: 7.1.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `kartonpredmeta`
--

-- --------------------------------------------------------

--
-- Table structure for table `institucija`
--

CREATE TABLE `institucija` (
  `sifraInstitucije` int(20) NOT NULL,
  `nazivInstitucije` varchar(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `institucija`
--

INSERT INTO `institucija` (`sifraInstitucije`, `nazivInstitucije`) VALUES
(1, 'Matematicki fakultet'),
(2, 'Fakultet organizacionih nauka'),
(6, 'Elektrotehnicki fakultet');

-- --------------------------------------------------------

--
-- Table structure for table `kartonpredmeta`
--

CREATE TABLE `kartonpredmeta` (
  `kartonPredmetaID` int(20) NOT NULL,
  `cilj` varchar(10000) DEFAULT NULL,
  `ishod` varchar(10000) DEFAULT NULL,
  `sadrzaj` varchar(10000) DEFAULT NULL,
  `predmetID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `kartonpredmeta`
--

INSERT INTO `kartonpredmeta` (`kartonPredmetaID`, `cilj`, `ishod`, `sadrzaj`, `predmetID`) VALUES
(2, 'Usposvwve', 'vebnyn5', 'ny5m5mu', 3),
(3, 'rebt5n4r6', 'gebr4j5u', 'wgeh4h', 3);

-- --------------------------------------------------------

--
-- Table structure for table `katedra`
--

CREATE TABLE `katedra` (
  `sifraKatedre` int(10) UNSIGNED NOT NULL,
  `nazivKatedre` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `katedra`
--

INSERT INTO `katedra` (`sifraKatedre`, `nazivKatedre`) VALUES
(1, 'Katedra za informacione sisteme'),
(3, 'Katedra za elektronsko poslovanje'),
(4, 'Katedra za softversko inzenjerstvo'),
(6, 'Katedra za menadzment'),
(7, 'Katedra za operacioni menadzment'),
(8, 'Katedra za markerting'),
(10, 'Katedra za simulaciju');

-- --------------------------------------------------------

--
-- Table structure for table `korisnik`
--

CREATE TABLE `korisnik` (
  `korisnikID` int(11) NOT NULL,
  `KorisnickoIme` varchar(50) DEFAULT NULL,
  `Lozinka` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `uloga` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `korisnik`
--

INSERT INTO `korisnik` (`korisnikID`, `KorisnickoIme`, `Lozinka`, `email`, `uloga`) VALUES
(1, 'admin', 'admin123', 'admin@gmail.com', 'administrator'),
(2, 'pera', 'pera123', NULL, 'korisnik'),
(3, 'zika', 'zika123', NULL, 'korisnik');

-- --------------------------------------------------------

--
-- Table structure for table `predmet`
--

CREATE TABLE `predmet` (
  `predmetID` int(11) NOT NULL,
  `nazivPredmeta` varchar(100) NOT NULL,
  `brojESPB` int(50) NOT NULL,
  `sifraKatedre` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `predmet`
--

INSERT INTO `predmet` (`predmetID`, `nazivPredmeta`, `brojESPB`, `sifraKatedre`) VALUES
(3, 'Projektovanje softvera', 6, 4),
(5, 'Mobilno poslovanje', 4, 1),
(6, 'Menadzment', 4, 6),
(8, 'Ekonomija', 6, 6);

-- --------------------------------------------------------

--
-- Table structure for table `predmetzaposleni`
--

CREATE TABLE `predmetzaposleni` (
  `predmetID` int(11) NOT NULL,
  `zaposleniID` int(11) NOT NULL,
  `tipNastave` varchar(30) DEFAULT NULL,
  `studijskiProgramPredmetID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `predmetzaposleni`
--

INSERT INTO `predmetzaposleni` (`predmetID`, `zaposleniID`, `tipNastave`, `studijskiProgramPredmetID`) VALUES
(3, 5, 'Predavanja', 3);

-- --------------------------------------------------------

--
-- Table structure for table `studijskiprogram`
--

CREATE TABLE `studijskiprogram` (
  `studijskiProgramID` int(20) NOT NULL,
  `nazivStudijskogPrograma` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `studijskiprogram`
--

INSERT INTO `studijskiprogram` (`studijskiProgramID`, `nazivStudijskogPrograma`) VALUES
(1, 'Informacioni sistemi i tehnologije'),
(2, 'Menadzment'),
(3, 'Kvalitet');

-- --------------------------------------------------------

--
-- Table structure for table `studijskiprogramsemestar`
--

CREATE TABLE `studijskiprogramsemestar` (
  `predmetID` int(11) NOT NULL,
  `studijskiProgramID` int(11) NOT NULL,
  `semestar` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `studijskiprogramsemestar`
--

INSERT INTO `studijskiprogramsemestar` (`predmetID`, `studijskiProgramID`, `semestar`) VALUES
(3, 1, 6),
(3, 2, 1),
(3, 3, 4),
(5, 3, 2),
(6, 3, 1);

-- --------------------------------------------------------

--
-- Table structure for table `zaposleni`
--

CREATE TABLE `zaposleni` (
  `zaposleniID` int(20) NOT NULL,
  `ime` varchar(50) DEFAULT NULL,
  `prezime` varchar(50) DEFAULT NULL,
  `titula` varchar(50) DEFAULT NULL,
  `datumRodjenja` date DEFAULT NULL,
  `sifraKatedre` int(10) UNSIGNED NOT NULL,
  `zvanjeID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `zaposleni`
--

INSERT INTO `zaposleni` (`zaposleniID`, `ime`, `prezime`, `titula`, `datumRodjenja`, `sifraKatedre`, `zvanjeID`) VALUES
(4, 'Marko', 'Markovic', 'phD', '1960-06-12', 1, 1),
(5, 'Jovan', 'Jovanovic', 'phD', '1970-06-11', 1, 2),
(6, 'Stefan', 'Stefanovic', 'phD', '1974-09-02', 1, 1),
(7, 'Marija', 'Martinovic', 'phD', '1977-03-05', 1, 2),
(17, 'Zika', 'Zikic', 'phD', '2018-06-06', 1, 1),
(18, 'fvdf', 'vb d', 'bd', '2018-06-26', 1, 1),
(19, 'Marko', 'Markovic', 'phD', '2018-06-08', 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `zvanje`
--

CREATE TABLE `zvanje` (
  `zvanjeID` int(20) NOT NULL,
  `nazivZvanja` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `zvanje`
--

INSERT INTO `zvanje` (`zvanjeID`, `nazivZvanja`) VALUES
(1, 'Profesor'),
(2, 'Asistent');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `institucija`
--
ALTER TABLE `institucija`
  ADD PRIMARY KEY (`sifraInstitucije`);

--
-- Indexes for table `kartonpredmeta`
--
ALTER TABLE `kartonpredmeta`
  ADD PRIMARY KEY (`kartonPredmetaID`),
  ADD KEY `predmetID` (`predmetID`);

--
-- Indexes for table `katedra`
--
ALTER TABLE `katedra`
  ADD PRIMARY KEY (`sifraKatedre`);

--
-- Indexes for table `korisnik`
--
ALTER TABLE `korisnik`
  ADD PRIMARY KEY (`korisnikID`);

--
-- Indexes for table `predmet`
--
ALTER TABLE `predmet`
  ADD PRIMARY KEY (`predmetID`),
  ADD KEY `sifraKatedre` (`sifraKatedre`);

--
-- Indexes for table `predmetzaposleni`
--
ALTER TABLE `predmetzaposleni`
  ADD PRIMARY KEY (`predmetID`,`zaposleniID`),
  ADD KEY `zaposleniID` (`zaposleniID`),
  ADD KEY `studijskiProgramPredmetID` (`studijskiProgramPredmetID`);

--
-- Indexes for table `studijskiprogram`
--
ALTER TABLE `studijskiprogram`
  ADD PRIMARY KEY (`studijskiProgramID`);

--
-- Indexes for table `studijskiprogramsemestar`
--
ALTER TABLE `studijskiprogramsemestar`
  ADD PRIMARY KEY (`predmetID`,`studijskiProgramID`),
  ADD KEY `studijskiProgramID` (`studijskiProgramID`);

--
-- Indexes for table `zaposleni`
--
ALTER TABLE `zaposleni`
  ADD PRIMARY KEY (`zaposleniID`),
  ADD KEY `sifraKatedre` (`sifraKatedre`),
  ADD KEY `zvanjeID` (`zvanjeID`);

--
-- Indexes for table `zvanje`
--
ALTER TABLE `zvanje`
  ADD PRIMARY KEY (`zvanjeID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `institucija`
--
ALTER TABLE `institucija`
  MODIFY `sifraInstitucije` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `kartonpredmeta`
--
ALTER TABLE `kartonpredmeta`
  MODIFY `kartonPredmetaID` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `katedra`
--
ALTER TABLE `katedra`
  MODIFY `sifraKatedre` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `korisnik`
--
ALTER TABLE `korisnik`
  MODIFY `korisnikID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `predmet`
--
ALTER TABLE `predmet`
  MODIFY `predmetID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `studijskiprogram`
--
ALTER TABLE `studijskiprogram`
  MODIFY `studijskiProgramID` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `zaposleni`
--
ALTER TABLE `zaposleni`
  MODIFY `zaposleniID` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `zvanje`
--
ALTER TABLE `zvanje`
  MODIFY `zvanjeID` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `kartonpredmeta`
--
ALTER TABLE `kartonpredmeta`
  ADD CONSTRAINT `kartonpredmeta_ibfk_1` FOREIGN KEY (`predmetID`) REFERENCES `predmet` (`predmetID`);

--
-- Constraints for table `predmet`
--
ALTER TABLE `predmet`
  ADD CONSTRAINT `predmet_ibfk_1` FOREIGN KEY (`sifraKatedre`) REFERENCES `katedra` (`sifraKatedre`);

--
-- Constraints for table `predmetzaposleni`
--
ALTER TABLE `predmetzaposleni`
  ADD CONSTRAINT `predmetzaposleni_ibfk_3` FOREIGN KEY (`predmetID`) REFERENCES `predmet` (`predmetID`),
  ADD CONSTRAINT `predmetzaposleni_ibfk_4` FOREIGN KEY (`zaposleniID`) REFERENCES `zaposleni` (`zaposleniID`),
  ADD CONSTRAINT `predmetzaposleni_ibfk_5` FOREIGN KEY (`studijskiProgramPredmetID`) REFERENCES `studijskiprogramsemestar` (`studijskiProgramID`),
  ADD CONSTRAINT `predmetzaposleni_ibfk_6` FOREIGN KEY (`predmetID`) REFERENCES `studijskiprogramsemestar` (`predmetID`);

--
-- Constraints for table `studijskiprogramsemestar`
--
ALTER TABLE `studijskiprogramsemestar`
  ADD CONSTRAINT `studijskiprogramsemestar_ibfk_1` FOREIGN KEY (`predmetID`) REFERENCES `predmet` (`predmetID`),
  ADD CONSTRAINT `studijskiprogramsemestar_ibfk_2` FOREIGN KEY (`studijskiProgramID`) REFERENCES `studijskiprogram` (`studijskiProgramID`);

--
-- Constraints for table `zaposleni`
--
ALTER TABLE `zaposleni`
  ADD CONSTRAINT `zaposleni_ibfk_1` FOREIGN KEY (`sifraKatedre`) REFERENCES `katedra` (`sifraKatedre`),
  ADD CONSTRAINT `zaposleni_ibfk_2` FOREIGN KEY (`zvanjeID`) REFERENCES `zvanje` (`zvanjeID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
