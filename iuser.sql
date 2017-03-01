-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 2017-03-01 07:44:24
-- 服务器版本： 10.1.21-MariaDB
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `iuser`
--

-- --------------------------------------------------------

--
-- 表的结构 `user`
--

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `uname` char(36) NOT NULL DEFAULT '',
  `pwd` char(100) NOT NULL DEFAULT '',
  `sex` enum('男','女','保密') NOT NULL DEFAULT '保密',
  `address` varchar(255) NOT NULL DEFAULT '',
  `email` varchar(100) DEFAULT NULL,
  `tel` varchar(255) NOT NULL DEFAULT '',
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `user`
--

INSERT INTO `user` (`id`, `uname`, `pwd`, `sex`, `address`, `email`, `tel`, `createtime`) VALUES
(10, 'test3', '//*EsV4cKkAjOT|jaFI1YzVeUchj*HZSaDdoaDlEsM0pSSVdhV1I3YTAe*zMhOEAzEsDkcMg*//', '男', '上海', '8888899999@qq.com', '13678888998', '2017-02-28 13:40:45'),
(9, 'test2', '//*EsV4cKkAjVzIwMzcwYzEsjUj|haEk3*e*8dcFhYehKaDczdjBe*1ce*zMhOEAzEsDkcMg*//', '男', '北京', 'taochenghong@126.com', '13788978787', '2017-02-28 13:17:45'),
(8, 'test', '//*EsV4cKkAj*D|h*UozUjc0aHY3Sjc3Mko5S8Z8MHYySTEsjOUpo*GEe*zMhOEAzEsDkcMg*//', '男', '北京', 'taochenghong@126.com', '13788978787', '2017-02-28 13:13:23');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id` (`id`);

--
-- 在导出的表使用AUTO_INCREMENT
--

--
-- 使用表AUTO_INCREMENT `user`
--
ALTER TABLE `user`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
