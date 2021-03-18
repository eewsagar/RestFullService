-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 18, 2021 at 03:47 PM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 8.0.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `humkin`
--

-- --------------------------------------------------------

--
-- Table structure for table `bloodbank`
--

CREATE TABLE `bloodbank` (
  `name` text DEFAULT NULL,
  `email` text DEFAULT NULL,
  `phone` decimal(20,0) DEFAULT NULL,
  `city` tinytext DEFAULT NULL,
  `address` tinytext DEFAULT NULL,
  `pincode` decimal(20,0) DEFAULT NULL,
  `bbid` decimal(20,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bloodbank`
--

INSERT INTO `bloodbank` (`name`, `email`, `phone`, `city`, `address`, `pincode`, `bbid`) VALUES
('nagpur', 'nagpur@gmail.com', '8956235689', 'nagpur', 'nagpur', '987456321', '1'),
('city bank', 'nagpur@gmail.com', '8956235689', 'nagpur', 'nagpur', '987456321', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `camps`
--

CREATE TABLE `camps` (
  `bbid` int(11) DEFAULT NULL,
  `name` text DEFAULT NULL,
  `cdate` date DEFAULT NULL,
  `phone` decimal(10,0) DEFAULT NULL,
  `location` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `donation`
--

CREATE TABLE `donation` (
  `adhaar` varchar(125) DEFAULT NULL,
  `bbid` varchar(75) DEFAULT NULL,
  `nid` varchar(75) DEFAULT NULL,
  `quantity` varchar(75) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `donor`
--

CREATE TABLE `donor` (
  `adhaar` int(11) DEFAULT NULL,
  `bbid` int(11) DEFAULT NULL,
  `fname` text DEFAULT NULL,
  `lname` text DEFAULT NULL,
  `email` text DEFAULT NULL,
  `phone` decimal(10,0) DEFAULT NULL,
  `gender` text DEFAULT NULL,
  `blood` text DEFAULT NULL,
  `dob` text DEFAULT NULL,
  `location` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `hospitals`
--

CREATE TABLE `hospitals` (
  `bbid` int(11) DEFAULT NULL,
  `name` text DEFAULT NULL,
  `phone` text DEFAULT NULL,
  `location` text DEFAULT NULL,
  `address` text DEFAULT NULL,
  `pin` decimal(6,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `manager`
--

CREATE TABLE `manager` (
  `bbid` int(11) DEFAULT NULL,
  `fname` text DEFAULT NULL,
  `lname` text DEFAULT NULL,
  `email` text DEFAULT NULL,
  `phone` int(11) DEFAULT NULL,
  `password` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `manager`
--

INSERT INTO `manager` (`bbid`, `fname`, `lname`, `email`, `phone`, `password`) VALUES
(1, 'sagar', 'verma', 'eew2@gmail.com', 2147483647, '8989');

-- --------------------------------------------------------

--
-- Table structure for table `nurses`
--

CREATE TABLE `nurses` (
  `bbid` int(11) DEFAULT NULL,
  `fname` text DEFAULT NULL,
  `lname` text DEFAULT NULL,
  `email` text DEFAULT NULL,
  `phone` decimal(10,0) DEFAULT NULL,
  `gender` text DEFAULT NULL,
  `location` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `transfer`
--

CREATE TABLE `transfer` (
  `hid` int(11) DEFAULT NULL,
  `bbid` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `blood` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
