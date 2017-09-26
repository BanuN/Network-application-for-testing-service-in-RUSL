-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 29, 2015 at 09:27 PM
-- Server version: 5.0.45-community-nt
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `examdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `questionsstore`
--

CREATE TABLE IF NOT EXISTS `questionsstore` (
  `qid` int(11) NOT NULL default '0',
  `question` varchar(100) NOT NULL default '',
  `op1` varchar(45) NOT NULL default '',
  `op2` varchar(45) NOT NULL default '',
  `op3` varchar(45) NOT NULL default '',
  `op4` varchar(45) NOT NULL default '',
  `answer` varchar(55) NOT NULL default '',
  PRIMARY KEY  (`qid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `questionsstore`
--

INSERT INTO `questionsstore` (`qid`, `question`, `op1`, `op2`, `op3`, `op4`, `answer`) VALUES
(1, 'Entomology is the science that studies', 'Behavior of human beings', 'Insects', 'mamals', 'The formation of rocks', 'Insects'),
(2, 'For which of the following disciplines is Nobel Prize awarded?', 'Physics and Chemistry', 'Physiology or Medicine', 'Literature, Peace and Economics', 'All of the above', 'All of the above'),
(3, 'Hitler party which came into power in 1933 is known as', 'Labour Party', 'Nazi Party', 'Ku-Klux-Klan', 'Democratic Party', 'Nazi Party'),
(4, 'Fathometer is used to measure', 'Earthquakes', 'Rainfall', 'Ocean depth', 'Sound intensity', 'Ocean depth'),
(5, 'First China War was fought between', 'China and Britain', 'China and France', 'China and Egypt', 'China and Greek', 'China and Britain'),
(6, 'Federation Cup, World Cup, Allywyn International Trophy and Challenge Cup are awardedto?', 'Tennis', 'Volleyball', 'Basketball', 'Cricket', 'Volleyball'),
(7, 'Each year World Red Cross and Red Crescent Day is celebrated on', 'May 8', 'May 18', 'June 8', 'June 18', 'May 8'),
(8, 'Headquarters of UNO are situated at', 'New York, USA', 'Haque (Netherlands)', 'Geneva', 'Paris', 'New York, USA'),
(9, 'For galvanizing iron which of the following metals is used?', 'Aluminium', 'Copper', 'Copper', 'Zinc', 'Zinc'),
(10, 'During World War II, when did Germany attack France?', '1940', '1941', '1942', '1943', '1940');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
