/*
Navicat MySQL Data Transfer

Source Server         : 本机
Source Server Version : 50613
Source Host           : localhost:3306
Source Database       : login_servlet

Target Server Type    : MYSQL
Target Server Version : 50613
File Encoding         : 65001

Date: 2013-10-15 16:57:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `yx_admin`
-- ----------------------------
DROP TABLE IF EXISTS `yx_admin`;
CREATE TABLE `yx_admin` (
  `adminID` int(11) NOT NULL AUTO_INCREMENT COMMENT '管理员ID',
  `adminName` tinytext COMMENT '用户名(登陆用)',
  `TrueName` tinytext COMMENT '真实姓名',
  `password` tinytext COMMENT '密码',
  `qq` tinytext COMMENT 'QQ',
  `longNum` tinytext COMMENT '长号电话',
  `shortNum` tinytext COMMENT '短号电话',
  `address` tinytext COMMENT '宿舍地址',
  `college` tinytext COMMENT '学院',
  `major` tinytext COMMENT '专业',
  `year` int(11) DEFAULT NULL COMMENT '年级',
  `email` tinytext COMMENT '电子邮箱',
  `adminRight` tinyint(2) DEFAULT NULL COMMENT '管理权限',
  PRIMARY KEY (`adminID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of yx_admin
-- ----------------------------
INSERT INTO `yx_admin` VALUES ('1', 'root', '超级管理员', '21232F297A57A5A743894A0E4A801FC3', null, null, null, null, null, null, null, null, '3');
INSERT INTO `yx_admin` VALUES ('3', 'admin', '叶冠鸿', '21232F297A57A5A743894A0E4A801FC3', '5123456', '12345678910', '123456', ' 地球上', '', '', null, '', '3');

-- ----------------------------
-- Table structure for `yx_user`
-- ----------------------------
DROP TABLE IF EXISTS `yx_user`;
CREATE TABLE `yx_user` (
  `userID` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `studentNum` varchar(12) DEFAULT NULL COMMENT '学号',
  `userName` varchar(20) DEFAULT NULL COMMENT '用户名(登陆用)',
  `TrueName` tinytext COMMENT '真实姓名',
  `password` tinytext COMMENT '密码',
  `qq` tinytext COMMENT 'QQ',
  `longNum` tinytext COMMENT '长号电话',
  `shortNum` tinytext COMMENT '短号',
  `address` tinytext COMMENT '宿舍地址',
  `college` tinytext COMMENT '学院',
  `major` tinytext COMMENT '专业',
  `year` int(11) DEFAULT NULL COMMENT '年级',
  `email` varchar(50) DEFAULT NULL COMMENT '电子邮箱',
  `superUser` tinyint(1) DEFAULT NULL COMMENT '超级用户(1是，0不是)',
  `regTime` bigint(20) DEFAULT NULL COMMENT '注册时间',
  PRIMARY KEY (`userID`),
  UNIQUE KEY `studentNum` (`studentNum`),
  UNIQUE KEY `userName` (`userName`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of yx_user
-- ----------------------------
INSERT INTO `yx_user` VALUES ('1', '123456', 'jeremie', '叶冠鸿', 'E10ADC3949BA59ABBE56E057F20F883E', '', '', '', '', '', '', null, '5490584810@163.com', '1', '1374674353580');
