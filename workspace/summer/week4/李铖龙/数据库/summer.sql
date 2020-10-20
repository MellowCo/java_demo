/*
 Navicat MySQL Data Transfer

 Source Server         : li
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : localhost:3306
 Source Schema         : summer

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : 65001

 Date: 26/07/2019 14:47:06
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('li', 'li1234');

-- ----------------------------
-- Table structure for carport
-- ----------------------------
DROP TABLE IF EXISTS `carport`;
CREATE TABLE `carport`  (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `cimg` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `cinfo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `cname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `crent` double(255, 0) NULL DEFAULT NULL,
  `status` int(2) NULL DEFAULT NULL,
  PRIMARY KEY (`cid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 27 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of carport
-- ----------------------------
INSERT INTO `carport` VALUES (1, 'images/雪佛兰新科鲁兹.jpg', '三厢|1.5自动|乘坐5人', '雪佛兰新科鲁兹', 99, -1);
INSERT INTO `carport` VALUES (2, 'images/雪佛兰科鲁兹.jpg', '三厢|1.5自动|乘坐5人', '雪佛兰科鲁兹', 100, -1);
INSERT INTO `carport` VALUES (3, 'images/大众朗逸.jpg', '三厢|1.6自动|乘坐5人', '大众朗逸', 100, -1);
INSERT INTO `carport` VALUES (4, 'images/别克英朗.jpg', '三厢|1.5自动|乘坐5人', '别克英朗', 112, -1);
INSERT INTO `carport` VALUES (5, 'images/别克昂科拉.jpg', 'SUV|1.4T自动|乘坐5人', '别克昂科拉', 130, -1);
INSERT INTO `carport` VALUES (6, 'images/宝沃BX5.jpg', 'SUV|1.4T自动|乘坐5人', '宝沃BX5', 144, -1);
INSERT INTO `carport` VALUES (7, 'images/起亚K5.jpg', '三厢|2.0自动|乘坐5人', '起亚K5', 163, -1);
INSERT INTO `carport` VALUES (8, 'images/路虎发现神行.jpg', 'SUV|2.0T自动|乘坐5人', '路虎发现神行', 713, -1);
INSERT INTO `carport` VALUES (9, 'images/大众朗逸.jpg', '三厢|1.6手动|乘坐5人', '大众朗逸', 89, -1);
INSERT INTO `carport` VALUES (10, 'images/dsadad.jpg', '而我却二无群二群翁额', 'dsadad', 100, -1);
INSERT INTO `carport` VALUES (11, 'images/zzm.jpg', 'szzzm', 'zzm', 1, 1);
INSERT INTO `carport` VALUES (14, 'images/li.jpg', 'niubi', 'li', 1000000, 1);
INSERT INTO `carport` VALUES (15, 'images/zzm1.jpg', 'zzm', 'zzm', 1, 1);
INSERT INTO `carport` VALUES (16, 'images/雪佛兰科鲁兹.jpg', '三厢|1.5自动|乘坐5人', '雪佛兰科鲁兹', 121, 1);
INSERT INTO `carport` VALUES (17, 'images/雪佛兰科沃兹.jpg', '三厢|1.5自动|乘坐5人', '雪佛兰科沃兹', 121, 1);
INSERT INTO `carport` VALUES (18, 'images/沃尔沃S90.jpg', '三厢|2.0T自动|乘坐5人', '沃尔沃S90', 791, -1);
INSERT INTO `carport` VALUES (19, 'images/路虎揽胜极光.jpg', 'SUV|2.0T自动|乘坐5人', '路虎揽胜极光', 765, -1);
INSERT INTO `carport` VALUES (20, 'images/别克GL8.jpg', '7座|2.4自动|乘坐7人', '别克GL8', 494, -1);
INSERT INTO `carport` VALUES (21, 'images/大众速腾时尚版.jpg', '自动|5座', '大众速腾时尚版', 102, -1);
INSERT INTO `carport` VALUES (22, 'images/大众朗逸或同组车型.jpg', '自动|5座', '大众朗逸或同组车型', 102, -1);
INSERT INTO `carport` VALUES (23, 'images/宝马3系.jpg', '随机分配如宝马320Li', '宝马3系', 500, -1);
INSERT INTO `carport` VALUES (24, 'images/eee.jpg', 'eeee', 'eee', 1000, -1);
INSERT INTO `carport` VALUES (25, 'images/ddd.jpg', 'dddd', 'ddd', 1, -1);
INSERT INTO `carport` VALUES (26, 'images/lcl.jpg', 'lcl', 'lcl', 100, 1);

-- ----------------------------
-- Table structure for corder
-- ----------------------------
DROP TABLE IF EXISTS `corder`;
CREATE TABLE `corder`  (
  `oid` int(11) NOT NULL AUTO_INCREMENT,
  `cid` int(11) NULL DEFAULT NULL,
  `cname` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `crent` double(255, 0) NULL DEFAULT NULL,
  `takeTime` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `getTime` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `status` int(2) NULL DEFAULT NULL,
  PRIMARY KEY (`oid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of corder
-- ----------------------------
INSERT INTO `corder` VALUES (1, 11, 'zzm', '111@qq.com', 100, '2019-07-25 12:16', '2019-07-27 12:16', -1);
INSERT INTO `corder` VALUES (2, 11, 'zzm', '111@qq.com', 100, '2019-07-25 12:16', '2019-07-27 12:16', -1);
INSERT INTO `corder` VALUES (3, 10, 'dsadad', '799478052@qq.com', 320, '2019-07-24 19:40', '2019-07-26 19:40', -1);
INSERT INTO `corder` VALUES (4, 5, '别克昂科拉', '799478052@qq.com', 380, '2019-07-24 19:40', '2019-07-26 19:40', -1);
INSERT INTO `corder` VALUES (5, 10, 'dsadad', '799478052@qq.com', 320, '2019-07-24 19:40', '2019-07-26 19:40', -1);
INSERT INTO `corder` VALUES (6, 11, 'zzm', '799478052@qq.com', 122, '2019-07-24 21:40', '2019-07-26 21:40', -1);
INSERT INTO `corder` VALUES (7, 4, '别克英朗', '361209603@qq.com', 344, '2019-07-24 22:22', '2019-07-26 22:22', -1);
INSERT INTO `corder` VALUES (8, 7, '起亚K5', '361209603@qq.com', 446, '2019-07-24 22:23', '2019-07-26 22:23', -1);
INSERT INTO `corder` VALUES (9, 6, '宝沃BX5', '361209603@qq.com', 408, '2019-07-24 22:23', '2019-07-26 22:23', -1);
INSERT INTO `corder` VALUES (10, 5, '别克昂科拉', '799478052@qq.com', 380, '2019-07-25 09:10', '2019-07-27 09:10', -1);
INSERT INTO `corder` VALUES (11, 11, 'zzm', '361209603@qq.com', 122, '2019-07-25 09:12', '2019-07-27 09:12', -1);
INSERT INTO `corder` VALUES (12, 5, '别克昂科拉', '799478052@qq.com', 380, '2019-07-25 09:27', '2019-07-27 09:27', -1);
INSERT INTO `corder` VALUES (13, 5, '别克昂科拉', '799478052@qq.com', 380, '2019-07-25 09:27', '2019-07-27 09:27', -1);
INSERT INTO `corder` VALUES (14, 6, '宝沃BX5', '799478052@qq.com', 408, '2019-07-25 09:27', '2019-07-27 09:27', -1);
INSERT INTO `corder` VALUES (15, 11, 'zzm', '799478052@qq.com', 122, '2019-07-25 12:16', '2019-07-27 12:16', -1);
INSERT INTO `corder` VALUES (16, 11, 'zzm', 'lcl@qq.com', 122, '2019-07-25 20:29', '2019-07-27 20:29', -1);
INSERT INTO `corder` VALUES (17, 14, 'li', 'lcl@qq.com', 2000120, '2019-07-25 20:37', '2019-07-27 20:37', -1);
INSERT INTO `corder` VALUES (18, 14, 'li', '111@qq.com', 2000120, '2019-07-26 10:27', '2019-07-28 10:27', -1);
INSERT INTO `corder` VALUES (19, 11, 'zzm', 'lc@qq.com', 122, '2019-07-26 13:28', '2019-07-28 13:28', -1);
INSERT INTO `corder` VALUES (20, 25, 'ddd', 'lc@qq.com', 122, '2019-07-26 13:29', '2019-07-28 13:29', -1);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `pwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `tel` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `status` int(2) NULL DEFAULT NULL,
  PRIMARY KEY (`email`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('111@qq.com', 'lil', '111111', '男', '1111111', '绍兴', -1);
INSERT INTO `user` VALUES ('22322@qq.com', 'qwqw', 'qqqqqq', '男', '11111111111111111', '宁波', -1);
INSERT INTO `user` VALUES ('2232@qq.com', 'qwqw', 'qqqqqq', '男', '11111111111111111', '宁波', 1);
INSERT INTO `user` VALUES ('32331@qq.com', '233333333333', '222222', '男', '132121312', '北京', 1);
INSERT INTO `user` VALUES ('3323@qq.com', '233333333333', '222222', '男', '132121312', '北京', 1);
INSERT INTO `user` VALUES ('33311@qq.com', '233333333333', '222222', '男', '132121312', '北京', 1);
INSERT INTO `user` VALUES ('3331@qq.com', '233333333333', '222222', '男', '132121312', '北京', 1);
INSERT INTO `user` VALUES ('333211@qq.com', '233333333333', '222222', '男', '132121312', '北京', 1);
INSERT INTO `user` VALUES ('333@qq.com', '233333333333', '222222', '男', '132121312', '北京', 1);
INSERT INTO `user` VALUES ('3612029603@qq.com', 'aaaaa', '111111', '女', '11111111', '上海', 1);
INSERT INTO `user` VALUES ('36120960311@qq.com', 'aaaaa', '111111', '女', '11111111', '上海', 1);
INSERT INTO `user` VALUES ('3612096031@qq.com', 'aaaaa', '111111', '女', '11111111', '上海', 1);
INSERT INTO `user` VALUES ('361209603@qq.com', 'aaaaa', '111111', '女', '11111111', '上海', 1);
INSERT INTO `user` VALUES ('361220960311@qq.com', 'aaaaa', '111111', '女', '11111111', '上海', -1);
INSERT INTO `user` VALUES ('36122096031@qq.com', 'aaaaa', '111111', '女', '11111111', '上海', -1);
INSERT INTO `user` VALUES ('79947805211@qq.com', 'limellow', '111111', '男', '222222222', '宁波', 1);
INSERT INTO `user` VALUES ('7994780521@qq.com', 'limellow', '111111', '男', '222222222', '宁波', -1);
INSERT INTO `user` VALUES ('799478052@qq.com', 'limellow', '111111', '男', '222222222', '宁波', 1);
INSERT INTO `user` VALUES ('dsad@qq.com', '111111', '111111', '男', 'sadasd', '北京', 1);
INSERT INTO `user` VALUES ('lc@qq.com', 'lil', '111111', '男', '111111111111', '北京', 1);
INSERT INTO `user` VALUES ('lcl@qq.com', 'lcl', '111111', '男', '15167627621', '宁波', 1);
INSERT INTO `user` VALUES ('zzm@qq.com', 'zzm', '111111', '男', '1111', '北京', 1);

SET FOREIGN_KEY_CHECKS = 1;
