-- phpMyAdmin SQL Dump
-- version 4.0.4.1
-- http://www.phpmyadmin.net
--
-- 主机: 127.0.0.1
-- 生成日期: 2016 �?07 �?29 �?16:16
-- 服务器版本: 5.6.11
-- PHP 版本: 5.5.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- 数据库: `test`
--

-- --------------------------------------------------------

--
-- 表的结构 `student`
--

CREATE TABLE IF NOT EXISTS `student` (
  `studentNo` varchar(12) CHARACTER SET utf8 NOT NULL,
  `password` varchar(20) CHARACTER SET utf8 NOT NULL,
  `studentName` varchar(12) CHARACTER SET utf8 NOT NULL,
  `studentSex` varchar(4) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`studentNo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- 转存表中的数据 `student`
--

INSERT INTO `student` (`studentNo`, `password`, `studentName`, `studentSex`) VALUES
('2013211001', '123456', 'test', '男'),
('2013211002', '123456', 'test0', '女'),
('2013211003', '123456', 'test1', '男'),
('2013211012', '888888', 'test2', '女'),
('2013211013', '123123', 'test3', '女'),
('2013211014', '123000', 'test4', '女'),
('2013211015', '123321', 'test5', '男'),
('2013211055', '123456', 'lala', '女'),
('2013211089', '123456', 'test6', '男'),
('2013211439', 'kings', 'testss', '男'),
('2013211455', 'test66', 'test7', '男'),
('2013211888', '123456', 'test8', '男'),
('2013222444', '123456', 'test9', '男'),
('2013222445', '123456', 'test10', '男');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
