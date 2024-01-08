-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jan 03, 2024 at 04:18 PM
-- Server version: 8.0.30
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tubes2023`
--

-- --------------------------------------------------------

--
-- Table structure for table `akun`
--

CREATE TABLE `akun` (
  `id` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `nomor_hp` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `akun`
--

INSERT INTO `akun` (`id`, `username`, `password`, `email`, `nomor_hp`) VALUES
('1a21ef86-4868-4797-bbcc-ee782d24001b', 'Ilham', 'iLham', 'iLham@gmail.com', '080808080808'),
('c6c79d0d-2d0c-46a2-a797-15533fa73d54', 'test', 'test', 'test', '52');

-- --------------------------------------------------------

--
-- Table structure for table `mitra`
--

CREATE TABLE `mitra` (
  `id` varchar(255) NOT NULL,
  `foto_profile` varchar(255) NOT NULL,
  `akun_id` varchar(255) NOT NULL,
  `nama_lengkap` varchar(255) NOT NULL,
  `tanggal_lahir` varchar(255) NOT NULL,
  `no_rekening` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `alamat_tinggal` varchar(255) NOT NULL,
  `foto_ktp` varchar(255) NOT NULL,
  `foto_kk` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `mitra`
--

INSERT INTO `mitra` (`id`, `foto_profile`, `akun_id`, `nama_lengkap`, `tanggal_lahir`, `no_rekening`, `alamat_tinggal`, `foto_ktp`, `foto_kk`) VALUES
('848d05b6-d59b-422e-977b-f9bda0aa0d32', 'test', 'c6c79d0d-2d0c-46a2-a797-15533fa73d54', 'test', 'test', 'test', 'test', 'test', 'test'),
('fb951480-17f2-4044-811e-1a83d19da0fa', 'qwer.jpg', '1a21ef86-4868-4797-bbcc-ee782d24001b', 'Ilham Gunawan', 'Ilham.jpg', '19239128412', 'Jl. Cepat Gerak', 'KTP.jpg', 'KK.jpg');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `akun`
--
ALTER TABLE `akun`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `mitra`
--
ALTER TABLE `mitra`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
