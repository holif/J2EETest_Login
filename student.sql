/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50611
Source Host           : 127.0.0.1:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50611
File Encoding         : 65001

Date: 2017-07-12 23:02:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `studentNo` varchar(12) CHARACTER SET utf8 NOT NULL,
  `password` varchar(20) CHARACTER SET utf8 NOT NULL,
  `studentName` varchar(12) CHARACTER SET utf8 NOT NULL,
  `studentSex` varchar(4) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`studentNo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('2013211001', '123456', 'test', '男');
INSERT INTO `student` VALUES ('2013211002', '123456', 'test0', '女');
INSERT INTO `student` VALUES ('2013211003', '123456', 'test1', '男');
INSERT INTO `student` VALUES ('2013211012', '888888', 'test2', '女');
INSERT INTO `student` VALUES ('2013211013', '123123', 'test3', '女');
INSERT INTO `student` VALUES ('2013211014', '123000', 'test4', '女');
INSERT INTO `student` VALUES ('2013211015', '123321', 'test5', '男');
INSERT INTO `student` VALUES ('2013211055', '123456', 'lala', '女');
INSERT INTO `student` VALUES ('2013211089', '123456', 'test6', '男');
INSERT INTO `student` VALUES ('2013211439', 'kings', 'baalhuo', '男');
INSERT INTO `student` VALUES ('2013211455', 'test66', 'test7', '男');
INSERT INTO `student` VALUES ('2013211888', '123456', 'test8', '男');
INSERT INTO `student` VALUES ('2013222444', '123456', 'test9', '男');
INSERT INTO `student` VALUES ('2013222445', '123456', 'test10', '男');
