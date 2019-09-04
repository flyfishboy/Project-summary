/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : d_keshe

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2019-01-18 00:26:03
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `board`
-- ----------------------------
DROP TABLE IF EXISTS `board`;
CREATE TABLE `board` (
  `b_id` bigint(20) NOT NULL,
  `b_nickname` varchar(20) DEFAULT NULL,
  `b_content` varchar(500) DEFAULT NULL,
  `b_date` varchar(100) DEFAULT NULL,
  `b_type` bigint(20) DEFAULT NULL COMMENT '留言种类（留言、通知）',
  PRIMARY KEY (`b_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of board
-- ----------------------------
INSERT INTO `board` VALUES ('1', '游客1', '你猜我说啥', '2019-01-01', null);

-- ----------------------------
-- Table structure for `file`
-- ----------------------------
DROP TABLE IF EXISTS `file`;
CREATE TABLE `file` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `file_name` varchar(255) DEFAULT NULL,
  `workname` varchar(255) DEFAULT NULL COMMENT '任务名',
  `s_id` bigint(20) DEFAULT NULL,
  `t_id` bigint(20) DEFAULT NULL COMMENT '老师工号',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of file
-- ----------------------------
INSERT INTO `file` VALUES ('1', '16204201-课设数据库.txt', '第二次作业', '16204201', '1620421');
INSERT INTO `file` VALUES ('2', '16200101-pom.xml.txt', '第四次作业', '16200101', '1620011');
INSERT INTO `file` VALUES ('3', '16200102-笔记.txt', '第四次作业', '16200102', '1620011');
INSERT INTO `file` VALUES ('4', '16200110-s_apply.xml', '第四次作业', '16200110', '1620011');

-- ----------------------------
-- Table structure for `position`
-- ----------------------------
DROP TABLE IF EXISTS `position`;
CREATE TABLE `position` (
  `n_id` bigint(30) NOT NULL AUTO_INCREMENT,
  `t_id` bigint(30) DEFAULT NULL,
  `d_name` varchar(80) DEFAULT NULL,
  `lon` double(100,10) DEFAULT NULL,
  `lat` double(100,10) DEFAULT NULL,
  PRIMARY KEY (`n_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of position
-- ----------------------------
INSERT INTO `position` VALUES ('2', '0', '谷歌科技', '23.0000000000', '32.0000000000');
INSERT INTO `position` VALUES ('3', '1620011', '', '10.0000000000', '10.0000000000');
INSERT INTO `position` VALUES ('4', '0', '恒生电子科技', '35.0000000000', '26.0000000000');
INSERT INTO `position` VALUES ('5', '0', '科创有线', '21.0000000000', '18.0000000000');

-- ----------------------------
-- Table structure for `practice`
-- ----------------------------
DROP TABLE IF EXISTS `practice`;
CREATE TABLE `practice` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `s_id` bigint(30) DEFAULT NULL,
  `s_name` varchar(50) DEFAULT NULL,
  `s_sex` varchar(30) DEFAULT NULL,
  `p_bdate` varchar(30) DEFAULT NULL,
  `p_edate` varchar(30) DEFAULT NULL,
  `p_type` varchar(30) DEFAULT NULL,
  `p_unit` varchar(100) DEFAULT NULL,
  `p_uphone` bigint(30) DEFAULT NULL,
  `t_id` bigint(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of practice
-- ----------------------------
INSERT INTO `practice` VALUES ('15', '16204101', '李翔', '男', '2019-01-01', '2019-01-30', '还未实习', '天旭科技', '6522134', '1620411');
INSERT INTO `practice` VALUES ('16', '16204102', '江辰', '男', '2019-01-01', '2019-01-31', '还未实习', '阿里巴巴', '6532165', '1620411');
INSERT INTO `practice` VALUES ('17', '16204103', '石立山', '男', '2019-01-28', '2019-01-31', '还未实习', '华为科技', '6350028', '1620411');
INSERT INTO `practice` VALUES ('18', '16204104', '李云龙', '男', '2019-01-01', '2019-01-28', '还未实习', '华为科技', '65123158', '1620411');
INSERT INTO `practice` VALUES ('20', '16204201', '苏幼微', '女', '2017-11-09', '2019-01-30', '正在实习', '阿里巴巴', '635524', '1620421');
INSERT INTO `practice` VALUES ('21', '16204203', '李倩倩', '女', '2017-01-04', '2019-01-10', '还未实习', '华为科技', '659931', '1620421');
INSERT INTO `practice` VALUES ('22', '16200101', '张敏', '男', '2019-01-01', '2019-01-29', '正在实习', '恒生电子科技', '659931', '1620011');
INSERT INTO `practice` VALUES ('23', '16200102', '张思德', '男', '2019-01-01', '2019-01-29', '正在实习', '谷歌科技', '659931', '1620011');
INSERT INTO `practice` VALUES ('24', '16200103', '谢安', '男', '2019-01-01', '2019-01-29', '正在实习', '三菱汽车', '659931', '1620011');
INSERT INTO `practice` VALUES ('25', '16200104', '李白', '男', '2019-01-02', '2019-01-31', '还未实习', '科创有线', '659931', '1620011');
INSERT INTO `practice` VALUES ('26', '16200105', '李乐', '男', '2019-01-01', '2019-01-31', '还未实习', '大亚湾石油', '659931', '1620011');
INSERT INTO `practice` VALUES ('27', '16200106', '吴天', '男', '2019-01-01', '2019-01-30', '还未实习', '惠州房产', '659931', '1620011');
INSERT INTO `practice` VALUES ('28', '16200108', '张婉儿', '男', '2019-01-01', '2019-01-30', '还未实习', '泰豪动漫', '659931', '1620011');
INSERT INTO `practice` VALUES ('29', '16200109', '萨德', '女', '2019-01-01', '2019-01-29', '还未实习', '网易科技', '635524', '1620011');
INSERT INTO `practice` VALUES ('30', '16200110', '李非', '女', '2019-01-23', '2019-01-31', '还未实习', '阿里巴巴', '662454554', '1620011');

-- ----------------------------
-- Table structure for `practice_work`
-- ----------------------------
DROP TABLE IF EXISTS `practice_work`;
CREATE TABLE `practice_work` (
  `m_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `m_title` varchar(255) DEFAULT NULL,
  `m_content` varchar(4000) DEFAULT NULL,
  `m_date` varchar(100) DEFAULT NULL,
  `m_grade` float(4,2) DEFAULT NULL,
  `s_id` bigint(20) DEFAULT NULL,
  `t_id` bigint(30) DEFAULT NULL,
  PRIMARY KEY (`m_id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of practice_work
-- ----------------------------
INSERT INTO `practice_work` VALUES ('16', '第一次作业', '本周实习情况汇报', '2019-01-23', '-1.00', '0', '1620411');
INSERT INTO `practice_work` VALUES ('17', '第一次作业', '上一周实习心得', '2019-01-01', '-1.00', '0', '1620421');
INSERT INTO `practice_work` VALUES ('18', '第二次作业', '实习心得', '2019-01-30', '-1.00', '0', '1620421');
INSERT INTO `practice_work` VALUES ('19', '第二次作业', '', '2019-01-16 13:32:39', '-1.00', '16204201', '1620421');
INSERT INTO `practice_work` VALUES ('20', '第一次作业', '本周实习情况汇报', '2019-01-01', '-1.00', '0', '1620011');
INSERT INTO `practice_work` VALUES ('21', '第二次作业', '第二阶段实习', '2019-01-01', '-1.00', '0', '1620011');
INSERT INTO `practice_work` VALUES ('25', '第四次作业', '第三阶段实习', '2019-01-31', '-1.00', '0', '1620011');
INSERT INTO `practice_work` VALUES ('26', '第五次作业', '第四阶段心得', '2019-02-27', '-1.00', '0', '1620011');
INSERT INTO `practice_work` VALUES ('28', '第四次作业', '', '2019-01-16 15:24:38', '-1.00', '16200101', '1620011');
INSERT INTO `practice_work` VALUES ('29', '第四次作业', '', '2019-01-16 15:25:54', '-1.00', '16200102', '1620011');
INSERT INTO `practice_work` VALUES ('30', '第四次作业', '', '2019-01-16 15:40:18', '-1.00', '16200110', '1620011');

-- ----------------------------
-- Table structure for `p_apply`
-- ----------------------------
DROP TABLE IF EXISTS `p_apply`;
CREATE TABLE `p_apply` (
  `Id` bigint(50) NOT NULL AUTO_INCREMENT,
  `s_id` bigint(50) DEFAULT NULL,
  `s_name` varchar(50) DEFAULT NULL,
  `date` varchar(20) DEFAULT NULL,
  `state` varchar(30) DEFAULT NULL,
  `t_id` bigint(30) DEFAULT NULL,
  `p_bdate` varchar(20) DEFAULT NULL,
  `p_edate` varchar(20) DEFAULT NULL,
  `p_type` varchar(20) DEFAULT NULL,
  `p_unit` varchar(50) DEFAULT NULL,
  `p_uphone` bigint(30) DEFAULT NULL,
  `s_sex` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of p_apply
-- ----------------------------
INSERT INTO `p_apply` VALUES ('9', '16204101', '李翔', '2019-01-16 11:08:40', 'true', '1620411', '2019-01-01', '2019-01-30', '还未实习', '天旭科技', '6522134', '男');
INSERT INTO `p_apply` VALUES ('11', '16204102', '江辰', '2019-01-16 11:23:38', 'true', '1620411', '2019-01-01', '2019-01-31', '还未实习', '阿里巴巴', '6532165', '男');
INSERT INTO `p_apply` VALUES ('12', '16204103', '石立山', '2019-01-16 11:29:13', 'true', '1620411', '2019-01-28', '2019-01-31', '还未实习', '华为科技', '6350028', '男');
INSERT INTO `p_apply` VALUES ('13', '16204105', '刘莹莹', '2019-01-16 11:41:13', 'false', '1620411', '2019-01-01', '2019-01-31', '还未实习', '恒生电子科技', '635524', '女');
INSERT INTO `p_apply` VALUES ('17', '16204203', '李倩倩', '2019-01-16 13:42:37', 'true', '1620421', '2017-01-04', '2019-01-10', '还未实习', '华为科技', '659931', '女');
INSERT INTO `p_apply` VALUES ('18', '16200101', '张敏', '2019-01-16 14:27:47', 'true', '1620011', '2019-01-01', '2019-01-29', '还未实习', '恒生电子科技', '659931', '男');
INSERT INTO `p_apply` VALUES ('19', '16200102', '张思德', '2019-01-16 14:29:01', 'true', '1620011', '2019-01-01', '2019-01-29', '还未实习', '谷歌科技', '659931', '男');
INSERT INTO `p_apply` VALUES ('20', '16200103', '谢安', '2019-01-16 14:29:44', 'true', '1620011', '2019-01-01', '2019-01-29', '还未实习', '三菱汽车', '659931', '男');
INSERT INTO `p_apply` VALUES ('21', '16200104', '李白', '2019-01-16 14:31:08', 'true', '1620011', '2019-01-02', '2019-01-31', '还未实习', '科创有线', '659931', '男');
INSERT INTO `p_apply` VALUES ('22', '16200105', '李乐', '2019-01-16 14:32:03', 'true', '1620011', '2019-01-01', '2019-01-31', '还未实习', '大亚湾石油', '659931', '男');
INSERT INTO `p_apply` VALUES ('23', '16200106', '吴天', '2019-01-16 14:32:47', 'true', '1620011', '2019-01-01', '2019-01-30', '还未实习', '惠州房产', '659931', '男');
INSERT INTO `p_apply` VALUES ('24', '16200107', '周大叔', '2019-01-16 14:33:25', 'false', '1620011', '2019-01-01', '2019-01-29', '还未实习', '峰创科技', '659931', '男');
INSERT INTO `p_apply` VALUES ('25', '16200108', '张婉儿', '2019-01-16 14:34:15', 'true', '1620011', '2019-01-01', '2019-01-30', '还未实习', '泰豪动漫', '659931', '男');
INSERT INTO `p_apply` VALUES ('26', '16200109', '萨德', '2019-01-16 14:35:00', 'true', '1620011', '2019-01-01', '2019-01-29', '还未实习', '网易科技', '635524', '女');
INSERT INTO `p_apply` VALUES ('27', '16200110', '李非', '2019-01-16 15:38:24', 'true', '1620011', '2019-01-23', '2019-01-31', '还未实习', '阿里巴巴', '662454554', '女');

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `s_id` bigint(20) NOT NULL DEFAULT '0',
  `s_name` varchar(50) DEFAULT NULL,
  `s_password` varchar(100) DEFAULT NULL,
  `s_sex` varchar(10) DEFAULT NULL,
  `s_birthday` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `s_class` bigint(20) DEFAULT NULL,
  `s_profession` varchar(50) DEFAULT NULL,
  `s_phone` bigint(20) DEFAULT NULL,
  `s_qq` bigint(20) DEFAULT NULL,
  `t_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`s_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('16200101', '张敏', '12345678', '男', '1997/2/12', '162001', '嵌入式', '12545685412', '45689758', '1620011');
INSERT INTO `student` VALUES ('16200102', '张思德', '12345678', '男', '1997/3/12', '162001', '嵌入式', '12545685413', '45689759', '1620011');
INSERT INTO `student` VALUES ('16200103', '谢安', '12345678', '男', '1997/4/12', '162001', '嵌入式', '12545685414', '45689760', '1620011');
INSERT INTO `student` VALUES ('16200104', '李白', '12345678', '男', '1997/5/12', '162001', '嵌入式', '12545685415', '45689761', '1620011');
INSERT INTO `student` VALUES ('16200105', '李乐', '12345678', '男', '1997/6/12', '162001', '嵌入式', '12545685416', '45689762', '1620011');
INSERT INTO `student` VALUES ('16200106', '吴天', '12345678', '男', '1997/7/12', '162001', '嵌入式', '12545685417', '45689763', '1620011');
INSERT INTO `student` VALUES ('16200107', '周大叔', '12345678', '男', '1997/8/12', '162001', '嵌入式', '12545685418', '45689764', '1620011');
INSERT INTO `student` VALUES ('16200108', '张婉儿', '12345678', '男', '1997/9/12', '162001', '嵌入式', '12545685419', '45689765', '1620011');
INSERT INTO `student` VALUES ('16200109', '萨德', '12345678', '女', '1999/9/25', '162001', '嵌入式', '12545685420', '45689766', '1620011');
INSERT INTO `student` VALUES ('16200110', '李非', '12345678', '女', '1999/9/26', '162001', '嵌入式', '12545685421', '45689767', '1620011');
INSERT INTO `student` VALUES ('16200111', '牛顿', '12345678', '女', '1999/9/27', '162001', '嵌入式', '12545685422', '45689768', '1620011');
INSERT INTO `student` VALUES ('16200112', '李里', '12345678', '女', '1999/9/28', '162001', '嵌入式', '12545685423', '45689769', '1620011');
INSERT INTO `student` VALUES ('16200113', '秦卓珈 ', '12345678', '女', '1999/9/29', '162001', '嵌入式', '12545685424', '45689770', '1620011');
INSERT INTO `student` VALUES ('16200114', '徐如华', '200101', '女', '1999/9/30', '162001', '嵌入式', '12545685425', '45689771', '1620011');
INSERT INTO `student` VALUES ('16200115', '韩一芳', '200101', '女', '1999/10/1', '162001', '嵌入式', '12545685426', '45689772', '1620011');
INSERT INTO `student` VALUES ('16204101', '李翔', '12345678', '男', '1997-01-01', '162041', '软件工程', '15583211654', '351165425', '1620411');
INSERT INTO `student` VALUES ('16204102', '江辰', '12345678', '男', '1998-02-03', '162041', '软件工程', '15532168521', '651156', '1620411');
INSERT INTO `student` VALUES ('16204103', '石立山', '12345678', '男', '2011-01-12', '162041', '软件工程', '17346625633', '95346722', '1620411');
INSERT INTO `student` VALUES ('16204104', '李云龙', '12345678', '男', '2010-01-24', '162041', '软件工程', '151791232699', '653246', '1620411');
INSERT INTO `student` VALUES ('16204105', '刘莹莹', '12345678', '女', '2019-01-30', '162041', '软件工程', '15179120503', '6533241', '1620411');
INSERT INTO `student` VALUES ('16204106', '王晓云', '12345678', '男', '1996-05-06', '162041', '软件工程', '16321521997', '4564564', '1620411');
INSERT INTO `student` VALUES ('16204107', '钱德勒', '12345678', '男', '2019-01-24', '16204107', '软件工程', '15532162158', '6533215', '1620411');
INSERT INTO `student` VALUES ('16204201', '苏幼微', '12345678', '女', '1999-01-09', '162042', '艺术设计', '15579136521', '435435', '1620421');
INSERT INTO `student` VALUES ('16204202', '桃小妖', '12345678', '男', '1996-05-13', '162042', '艺术设计', '15573215186', '651156', '1620421');
INSERT INTO `student` VALUES ('16204203', '李倩倩', '12345678', '女', '1997-02-07', '162042', '艺术设计', '15578321540', '561611651', '1620421');
INSERT INTO `student` VALUES ('16204204', '张云川', '12345678', '男', '1995-05-08', '162042', '艺术设计', '15578213156', '5464646', '1620421');
INSERT INTO `student` VALUES ('16204205', '周武', '12345678', '男', '1999-11-04', '162042', '艺术设计', '16231856416', '6512254', '1620421');
INSERT INTO `student` VALUES ('16204206', '刘志宝 ', '12345678', '女', '1996-4-18', '162002', '大数据', '12545685572', '652231', '1620421');
INSERT INTO `student` VALUES ('16204207', '申莹洋 ', '12345678', '男', '1996-4-19', '162002', '大数据', '12545685573', '328856', '1620421');
INSERT INTO `student` VALUES ('16204208', ' 周岚青', '12345678', '男', '1996-04-10', '162042', '大数据', '12545685574', '45689920', '1620421');
INSERT INTO `student` VALUES ('16204209', '张淑馨', '12345678', '男', '1996-04-11', '162042', '大数据', '12545685575', '45689921', '1620421');
INSERT INTO `student` VALUES ('16204210', ' 郭银汝', '12345678', '男', '1996-04-12', '162042', '大数据', '12545685576', '45689922', '1620421');

-- ----------------------------
-- Table structure for `s_apply`
-- ----------------------------
DROP TABLE IF EXISTS `s_apply`;
CREATE TABLE `s_apply` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '学生信息申请表ID',
  `date` varchar(100) DEFAULT NULL COMMENT '申请时间',
  `state` varchar(100) DEFAULT NULL,
  `t_id` bigint(20) DEFAULT NULL,
  `s_id` bigint(20) DEFAULT NULL,
  `s_name` varchar(50) DEFAULT NULL,
  `s_sex` varchar(20) DEFAULT NULL,
  `s_class` bigint(20) DEFAULT NULL,
  `s_profession` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_apply
-- ----------------------------

-- ----------------------------
-- Table structure for `teacher`
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `t_id` bigint(20) NOT NULL,
  `t_name` varchar(50) DEFAULT NULL,
  `t_password` varchar(100) DEFAULT NULL,
  `t_sex` varchar(10) DEFAULT NULL,
  `t_birthday` varchar(100) DEFAULT NULL,
  `t_profession` varchar(50) DEFAULT NULL,
  `t_phone` bigint(20) DEFAULT NULL,
  `t_qq` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`t_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('1601521', '朱大幅', '12345678', '男', '2019-01-01', '飞航学院', '15178214530', '65165');
INSERT INTO `teacher` VALUES ('1611015', '王大大', '12345678', '男', '2019-01-01', '材料科学', '15178214530', '65165');
INSERT INTO `teacher` VALUES ('1611016', '李大全', '12345678', '男', '2019-01-01', '土木建设', '15178214530', '65165');
INSERT INTO `teacher` VALUES ('1611017', '张全蛋', '12345678', '女', '2019-01-01', '软件工程', '15142315681', '6625782');
INSERT INTO `teacher` VALUES ('1611018', '刘帅帅', '12345678', '男', '2019-01-01', '航制学院', '15178214530', '65288712');
INSERT INTO `teacher` VALUES ('1620011', '吴宇', '12345678', '男', '1987-08-04', '嵌入式', '15579130105', '651565');
INSERT INTO `teacher` VALUES ('1620411', '吴丽萍', '12345678', '女', '1987-08-04', '软件工程', '15179121087', '1963677458');
INSERT INTO `teacher` VALUES ('1620421', '刘大大', '12345678', '男', '1997-08-21', '艺术设计', '15179826521', '236615720');

-- ----------------------------
-- Table structure for `t_admin`
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin` (
  `a_id` bigint(20) NOT NULL,
  `a_name` varchar(50) DEFAULT NULL,
  `a_password` varchar(100) DEFAULT NULL,
  `a_sex` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`a_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_admin
-- ----------------------------
INSERT INTO `t_admin` VALUES ('12345', '刘大大', '12345', '男');
INSERT INTO `t_admin` VALUES ('123456', '李大大', '123456', '女');
