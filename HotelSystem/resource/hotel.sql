/*
 Navicat MySQL Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : localhost:3306
 Source Schema         : hotel

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 07/06/2023 10:18:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '登录帐户',
  `pwd` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '登录密码',
  `lasttime` datetime NULL DEFAULT NULL COMMENT '最后登录时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for consumorder
-- ----------------------------
DROP TABLE IF EXISTS `consumorder`;
CREATE TABLE `consumorder`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `rid` int NULL DEFAULT NULL COMMENT '关联房间id',
  `gid` int NULL DEFAULT NULL COMMENT '商品关联',
  `num` int NULL DEFAULT NULL COMMENT '商品数量',
  `consumdate` datetime NULL DEFAULT NULL COMMENT '消费时间',
  `amount` int NULL DEFAULT NULL COMMENT '消费金额',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for goodsinfo
-- ----------------------------
DROP TABLE IF EXISTS `goodsinfo`;
CREATE TABLE `goodsinfo`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `price` int NULL DEFAULT NULL,
  `num` int NULL DEFAULT NULL,
  `tid` int NULL DEFAULT NULL,
  `type` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for goodstype
-- ----------------------------
DROP TABLE IF EXISTS `goodstype`;
CREATE TABLE `goodstype`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `typename` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '类别名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for memberinfo
-- ----------------------------
DROP TABLE IF EXISTS `memberinfo`;
CREATE TABLE `memberinfo`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '会员姓名',
  `idnum` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '身份证号',
  `birth` date NULL DEFAULT NULL COMMENT '出生日期',
  `age` int NULL DEFAULT NULL COMMENT '年龄',
  `gender` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '会员性别',
  `tel` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '联系电话',
  `levelid` int NULL DEFAULT NULL COMMENT '关联等级id',
  `level` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '会员等级',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for memberlevel
-- ----------------------------
DROP TABLE IF EXISTS `memberlevel`;
CREATE TABLE `memberlevel`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `level` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '会员等级',
  `low` int NULL DEFAULT NULL COMMENT '等级最低消费值',
  `high` int NULL DEFAULT NULL COMMENT '等级最高消费值',
  `discount` double NULL DEFAULT NULL COMMENT '享受折扣',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for orderinfo
-- ----------------------------
DROP TABLE IF EXISTS `orderinfo`;
CREATE TABLE `orderinfo`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `ordernum` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '订单号',
  `rid` int NULL DEFAULT NULL COMMENT '房间id关联',
  `mid` int NULL DEFAULT NULL COMMENT '会员id关联',
  `price` int NULL DEFAULT NULL COMMENT '房间价格',
  `discount` double NULL DEFAULT NULL COMMENT '享受折扣',
  `deposit` int NULL DEFAULT NULL COMMENT '押金',
  `daynum` int NULL DEFAULT NULL COMMENT '预计天数',
  `indate` datetime NULL DEFAULT NULL COMMENT '到店时间',
  `outdate` datetime NULL DEFAULT NULL COMMENT '离店时间',
  `membernum` int NULL DEFAULT NULL COMMENT '人数',
  `advance` int NULL DEFAULT NULL COMMENT '预收款',
  `actualprice` int NULL DEFAULT NULL COMMENT '实际价格',
  `paymentway` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '支付方式 现金 支付宝 微信  云闪付 数字货币 其他',
  `otherconsum` int NULL DEFAULT NULL COMMENT '其他消费',
  `total` int NULL DEFAULT NULL COMMENT '应付总额',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for roominfo
-- ----------------------------
DROP TABLE IF EXISTS `roominfo`;
CREATE TABLE `roominfo`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `level` int NULL DEFAULT NULL COMMENT '所在楼层',
  `tid` int NULL DEFAULT NULL COMMENT '房间类型',
  `roomnum` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '房间号码',
  `price` int NULL DEFAULT NULL COMMENT '价格',
  `deposit` int NULL DEFAULT NULL COMMENT '押金',
  `tel` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '分机号码',
  `status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '1 空  2 有客  3 空脏',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `roominfo_ibfk_1`(`tid`) USING BTREE,
  CONSTRAINT `roominfo_ibfk_1` FOREIGN KEY (`tid`) REFERENCES `roomtype` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for roomtype
-- ----------------------------
DROP TABLE IF EXISTS `roomtype`;
CREATE TABLE `roomtype`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '类型名称',
  `price` int NULL DEFAULT NULL COMMENT '房型价格',
  `deposit` int NULL DEFAULT NULL COMMENT '押金',
  `bednum` int NULL DEFAULT NULL COMMENT '床位数',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
