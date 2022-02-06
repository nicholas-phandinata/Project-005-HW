-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 04, 2022 at 03:31 AM
-- Server version: 10.4.8-MariaDB
-- PHP Version: 7.3.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_android`
--

-- --------------------------------------------------------

--
-- Table structure for table `tb_nasabah`
--

CREATE TABLE `tb_nasabah` (
  `id` int(11) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `alamat` varchar(70) NOT NULL,
  `no_rekening` varchar(10) NOT NULL,
  `no_telephone` varchar(12) NOT NULL,
  `pekerjaan` varchar(50) NOT NULL,
  `saldo` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_nasabah`
--

INSERT INTO `tb_nasabah` (`id`, `nama`, `alamat`, `no_rekening`, `no_telephone`, `pekerjaan`, `saldo`) VALUES
(1, 'Sana Minatozaki', 'Jl Twice 26', '8770013950', '081122334400', 'Pegawai Swasta', '100500000'),
(2, 'Chou Tzu-yu', 'Jl Twice 23', '8770013951', '081122334401', 'Pegawai Swasta', '80500000'),
(3, 'Lee Ji Eun', 'Jl IU 29', '8770013952', '081122334402', 'Pengusaha', '900500000'),
(4, 'Kim Ji Soo', 'Jl BP 27', '8770013953', '081122334403', 'Artis', '600500000'),
(5, 'Ju Jingyi', 'Jl SNH 28', '8770013954', '081122334404', 'Artis', '700500000'),
(6, 'Chrissy Costanza', 'Jl ATC 27', '8770013955', '081122334405', 'Penyanyi', '800000000'),
(7, 'Laura Vandervoort', 'Jl SV 38', '8770013956', '081122334406', 'Pegawai Swasta', '200500000'),
(8, 'Peter Parker', 'Jl Brooklyn 20', '8770013957', '081122334407', 'Pegawai Swasta', '150500000'),
(9, 'Barry Allen', 'Jl Central 21', '8770013958', '081122334408', 'Pegawai Swasta', '180500000'),
(10, 'Clark Kent', 'Jl Metro 22', '8770013959', '081122334409', 'Pegawai Swasta', '170500000');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_nasabah`
--
ALTER TABLE `tb_nasabah`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tb_nasabah`
--
ALTER TABLE `tb_nasabah`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
