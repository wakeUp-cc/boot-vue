/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : localhost:3306
 Source Schema         : cc

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : 65001

 Date: 19/08/2020 17:01:35
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `seq` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `parent_seq` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '父菜单seq',
  `menu_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单名称',
  `menu_path` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单地址',
  `icon` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图标',
  PRIMARY KEY (`seq`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '菜单管理' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('1', '0', '系统管理', '/system', 'el-icon-s-grid\r\n');
INSERT INTO `menu` VALUES ('2', '1', '用户管理', '/user', 'el-icon-s-custom');
INSERT INTO `menu` VALUES ('3', '1', '菜单管理', '/menu', 'el-icon-tickets');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `seq` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `username` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '账号',
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名称',
  PRIMARY KEY (`seq`) USING BTREE,
  UNIQUE INDEX ```username```(`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('025662b9b74ffca57199c37cef1cfb3a', '1113', '9c3b1830513cc3b8fc4b76635d32e692', '你好');
INSERT INTO `user` VALUES ('452bcefadc4acd50acee1b446a28fbcf', 'cc', 'e0323a9039add2978bf5b49550572c7c', '池');
INSERT INTO `user` VALUES ('a121c3db60ad94797fed23d06140769a', 'huge', 'b7cf27ffe6ea83cdcf8af2ef29de9285', '胡哥');
INSERT INTO `user` VALUES ('b47efa71abc4e3e2863ca5fc2d490f8c', 'qwe', '76d80224611fc919a5d54f0ff9fba446', 'qwe');
INSERT INTO `user` VALUES ('e5ee919d06c0cd1e1aec016cb04162d9', 'admin', '21232f297a57a5a743894a0e4a801fc3', '管理员');

SET FOREIGN_KEY_CHECKS = 1;
