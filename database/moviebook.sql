-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 30, 2023 at 04:27 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `moviebook`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `email` varchar(100) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `email`, `username`, `password`) VALUES
(1, 'admin@gmail.comm', 'admin', 'admin123'),
(2, 'user@gmail.com', 'useruser', 'useruser'),
(3, 'netacad@gmail.com', 'cisco', 'cisco123'),
(4, 'admin@gmail.com', 'user1', 'user1234'),
(5, 'user2@gmail.com', 'user2', 'user2222'),
(6, 'adm@gmail.com', 'adm', '12345678');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `id` int(100) NOT NULL,
  `type` varchar(100) NOT NULL,
  `movieTitle` varchar(100) NOT NULL,
  `quantity` int(100) NOT NULL,
  `total` double NOT NULL,
  `date` date DEFAULT NULL,
  `time` time DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`id`, `type`, `movieTitle`, `quantity`, `total`, `date`, `time`) VALUES
(4, 'Normal Class', 'Howl Moving Castle', 2, 20, '2023-12-30', '03:43:03'),
(5, 'Special Class', 'Ponyo', 3, 75, '2023-12-30', '03:46:38'),
(6, 'Special Class', 'Ponyo', 4, 100, '2023-12-30', '03:48:45'),
(7, 'Special & Normal Class', 'Grave of the Fireflies', 5, 80, '2023-12-30', '05:49:10'),
(8, 'Special & Normal Class', 'Ponyo', 5, 80, '2023-12-30', '09:53:42');

-- --------------------------------------------------------

--
-- Table structure for table `customer_info`
--

CREATE TABLE `customer_info` (
  `id` int(100) NOT NULL,
  `customer_id` int(100) NOT NULL,
  `type` varchar(100) NOT NULL,
  `movieTitle` varchar(100) NOT NULL,
  `total` double NOT NULL,
  `quantity` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customer_info`
--

INSERT INTO `customer_info` (`id`, `customer_id`, `type`, `movieTitle`, `total`, `quantity`) VALUES
(2, 6, 'Special Class', 'Ponyo', 100, 4),
(3, 7, 'Special & Normal Class', 'Grave of the Fireflies', 80, 5),
(4, 8, 'Special & Normal Class', 'Ponyo', 80, 5);

-- --------------------------------------------------------

--
-- Table structure for table `movie`
--

CREATE TABLE `movie` (
  `id` int(250) NOT NULL,
  `movieTitle` varchar(100) NOT NULL,
  `genre` varchar(100) NOT NULL,
  `duration` varchar(100) NOT NULL,
  `image` varchar(500) NOT NULL,
  `date` date DEFAULT NULL,
  `current` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `movie`
--

INSERT INTO `movie` (`id`, `movieTitle`, `genre`, `duration`, `image`, `date`, `current`) VALUES
(1, 'Ponyo', 'Fantasy', '2:04:54', 'C:\\\\Users\\\\Elga\\\\Documents\\\\prl23\\\\MovieTicketBookingManagement\\\\src\\\\poster\\\\ponyo.png', '2023-12-04', 'Showing'),
(2, 'The Boy and The Heron', 'Adventure', '2:56:32', 'C:\\\\Users\\\\Elga\\\\Documents\\\\prl23\\\\MovieTicketBookingManagement\\\\src\\\\poster\\\\the boy and the heron.png', '2023-12-10', 'Showing'),
(3, 'Howl Moving Castle', 'Fantasy', '2:03:30', 'C:\\\\Users\\\\Elga\\\\Documents\\\\prl23\\\\MovieTicketBookingManagement\\\\src\\\\poster\\\\howls moving castle.png', '2023-12-10', 'End Showing');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `customer_info`
--
ALTER TABLE `customer_info`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `movie`
--
ALTER TABLE `movie`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `customer_info`
--
ALTER TABLE `customer_info`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
