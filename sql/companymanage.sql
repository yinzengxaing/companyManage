/*
Navicat MySQL Data Transfer

Source Server         : companyManage
Source Server Version : 50528
Source Host           : 172.21.3.2:3306
Source Database       : companymanage

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2017-06-22 15:57:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for company_admin
-- ----------------------------
DROP TABLE IF EXISTS `company_admin`;
CREATE TABLE `company_admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `loginname` varchar(50) NOT NULL,
  `loginpassword` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of company_admin
-- ----------------------------
INSERT INTO `company_admin` VALUES ('1', '孔留锋', 'kongliufeng', '123456');
INSERT INTO `company_admin` VALUES ('2', '殷曾祥', 'yinzengxiang', '123456');
INSERT INTO `company_admin` VALUES ('3', '张韬祥', 'zhangtaoxiang', '123456');

-- ----------------------------
-- Table structure for company_employee
-- ----------------------------
DROP TABLE IF EXISTS `company_employee`;
CREATE TABLE `company_employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '员工主键',
  `name` varchar(50) NOT NULL COMMENT '姓名',
  `sex` varchar(10) NOT NULL,
  `birthday` varchar(50) NOT NULL COMMENT '生日',
  `education` varchar(50) NOT NULL COMMENT '学历',
  `address` varchar(50) NOT NULL COMMENT '住址',
  `phoneNumber` varchar(50) NOT NULL COMMENT '电话',
  `department` varchar(50) NOT NULL COMMENT '部门',
  `duty` varchar(50) NOT NULL COMMENT '职务',
  `employeeState` tinyint(2) NOT NULL DEFAULT '1' COMMENT '员工状态：1，存在，0，删除（不存在）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of company_employee
-- ----------------------------
INSERT INTO `company_employee` VALUES ('1', '孔留锋', '男', '1996-04-15', '大学本科', '郑州科学大道166号', '18749281008', '开发部', '前端工程师', '1');
INSERT INTO `company_employee` VALUES ('11', '殷曾祥', '男', '2017-06-05', '大学本科', '郑州科学大道166号', '18888888888', '开发部', '架构师', '1');
INSERT INTO `company_employee` VALUES ('14', '张韬祥', '男', '1996-10-18', '大学本科', '郑州科学大道166号', '15194543183', '开发部', '开发工程师', '1');
INSERT INTO `company_employee` VALUES ('15', '刘五', '男', '2017-06-10', '大学专科', '郑州科学大道166号', '13549385830', '财务部', '前端工程师', '1');
INSERT INTO `company_employee` VALUES ('16', '柳絮', '男', '2017-06-10', '大学专科', '郑州科学大道166号', '13549385830', '人力资源部', '产品经理', '1');
INSERT INTO `company_employee` VALUES ('17', '丁一', '女', '2017-06-10', '大学本科', '郑州科学大道166号', '13549385830', '财务部', '策划经理', '1');
INSERT INTO `company_employee` VALUES ('18', '王二', '男', '2017-06-10', '大学本科', '郑州科学大道166号', '13549385830', '人力资源部', '策划经理', '1');
INSERT INTO `company_employee` VALUES ('19', '小狗', '男', '2017-06-10', '博士研究生', '郑州科学大道166号', '13549385830', '人力资源部', '策划经理', '1');
INSERT INTO `company_employee` VALUES ('20', '沙沙', '男', '2017-06-10', '大学专科', '郑州科学大道166号', '13549385830', '人力资源部', '产品经理', '1');
INSERT INTO `company_employee` VALUES ('21', '王二', '男', '2017-06-10', '大学本科', '郑州科学大道166号', '13549385830', '人力资源部', '策划经理', '0');
INSERT INTO `company_employee` VALUES ('22', '小牛', '女', '2017-06-06', '博士研究生', '北京', '15946461259', '行政部', '测试工程师', '0');
INSERT INTO `company_employee` VALUES ('23', '王蛋', '女', '2017-06-10', '大学本科', '郑州科学大道166号', '13986452879', '后勤部', '策划经理', '1');
INSERT INTO `company_employee` VALUES ('24', '高富帅', '男', '2017-06-27', '博士研究生', '喜欢你', '18625776286', '行政部', '产品经理', '1');
INSERT INTO `company_employee` VALUES ('25', '111', '男', '2017-07-04', '大学本科', '12', '18625776286', '行政部', '架构师', '0');
INSERT INTO `company_employee` VALUES ('26', '程子谦', '男', '2017-06-07', '大学专科', '喜欢你', '13555666547', '开发部', '测试工程师', '0');
INSERT INTO `company_employee` VALUES ('27', '徐招娣', '男', '2017-06-07', '大学专科', '喜欢你', '13555666547', '开发部', '产品经理', '1');
INSERT INTO `company_employee` VALUES ('28', '小孟', '男', '2017-06-15', '大学专科', '喜欢你', '15998444658', '后勤部', '运维工程师', '1');
INSERT INTO `company_employee` VALUES ('29', '顾胜男', '男', '2017-06-15', '大学专科', '喜欢你', '15998444658', '市场营销部', '产品经理', '1');
INSERT INTO `company_employee` VALUES ('30', '黍闵', '女', '2017-06-15', '大学本科', '123', '15639254856', '人力资源部', '运维工程师', '1');
INSERT INTO `company_employee` VALUES ('31', '陈晓', '女', '2017-06-15', '大学本科', '123', '15998328512', '开发部', '运维工程师', '1');
INSERT INTO `company_employee` VALUES ('32', '莫笑', '男', '2017-06-15', '大学专科', '123', '15998444658', '财务部', '前端工程师', '1');
INSERT INTO `company_employee` VALUES ('33', '路晋', '男', '2017-06-14', '大学专科', '喜欢你', '15555211314', '市场营销部', '策划经理', '1');
INSERT INTO `company_employee` VALUES ('34', '田武', '男', '2017-06-19', '大学专科', '多啦A梦之伴我成长', '18596425631', '人力资源部', '策划经理', '1');
INSERT INTO `company_employee` VALUES ('35', '小夫', '男', '2017-06-21', '大学专科', '多啦A梦之伴我成长', '13336488647', '行政部', '运维工程师', '1');
INSERT INTO `company_employee` VALUES ('36', '静香', '女', '2017-06-21', '大学专科', '多啦A梦之伴我成长', '13336488647', '开发部', '策划经理', '1');
INSERT INTO `company_employee` VALUES ('37', '胖虎', '男', '2017-06-14', '博士研究生', '多啦A梦之伴我成长', '15846477853', '开发部', '测试工程师', '1');
INSERT INTO `company_employee` VALUES ('38', '大熊', '男', '2017-06-14', '博士研究生', '多啦A梦之伴我成长', '15846477853', '人力资源部', '测试工程师', '1');
INSERT INTO `company_employee` VALUES ('39', 'A梦', '男', '2017-06-14', '大学专科', '多啦A梦之伴我成长', '15846477853', '开发部', '测试工程师', '1');
INSERT INTO `company_employee` VALUES ('40', '伊丽莎白', '女', '2017-07-01', '大学专科', '加勒比', '18749281008', '财务部', '开发工程师', '1');
INSERT INTO `company_employee` VALUES ('41', '亨利', '男', '2017-06-24', '大学专科', '加勒比', '18935789802', '人力资源部', '策划经理', '1');
INSERT INTO `company_employee` VALUES ('42', '萨拉查', '男', '2017-07-04', '大学本科', '加勒比', '18625776286', '人力资源部', '策划经理', '1');
INSERT INTO `company_employee` VALUES ('43', '王一', '男', '2017-07-08', '大学本科', '加勒比', '15635824569', '行政部', '策划经理', '0');
INSERT INTO `company_employee` VALUES ('44', '杰克', '男', '2017-07-08', '大学专科', '加勒比', '18916542589', '行政部', '策划经理', '0');

-- ----------------------------
-- Table structure for company_news
-- ----------------------------
DROP TABLE IF EXISTS `company_news`;
CREATE TABLE `company_news` (
  `id` int(30) NOT NULL AUTO_INCREMENT COMMENT '新闻公告主键',
  `title` varchar(100) NOT NULL COMMENT '标题',
  `content` varchar(100) NOT NULL COMMENT '内容',
  `createTime` varchar(300) NOT NULL COMMENT '创建时间',
  `createId` int(30) NOT NULL COMMENT '创建人id',
  `newsState` tinyint(2) NOT NULL DEFAULT '1' COMMENT '新闻状态：0：删除   1：存在  默认为1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of company_news
-- ----------------------------
INSERT INTO `company_news` VALUES ('12', '2017年第二次例会', '在会议室102，各个人员需要到齐，签到记得来', '2017-06-22', '1', '1');
INSERT INTO `company_news` VALUES ('13', '2017年第九次例会', '今天开会，不许迟到！！今天开会，不许迟到！！今天开会，不许迟到！！', '2017-09-02', '1', '1');
INSERT INTO `company_news` VALUES ('18', '2017年第六次例会', '开会地点在会议室102，各个人员需要到齐，签到', '2017-06-27', '1', '1');
INSERT INTO `company_news` VALUES ('23', '2017年第八次例会', '今天开会，不许迟到！！今天开会，不许迟到！！今天开会，不许迟到！！', '2017-07-04', '1', '1');
INSERT INTO `company_news` VALUES ('24', '2017年第三次例会', '开会地点在会议室102，各个人员需要到齐，签到记得来', '2017-06-25', '1', '1');
INSERT INTO `company_news` VALUES ('26', '2017年第四次例会', '在会议室102，各个人员需要到齐，签到记得来', '2017-06-25', '1', '1');
INSERT INTO `company_news` VALUES ('27', '2017年第五次例会', '在会议室102，各个人员需要到齐，签到记得来', '2017-06-25', '1', '1');
INSERT INTO `company_news` VALUES ('29', '2017年第七次例会', '开会地点在会议室102，各个人员需要到齐，签到', '2017-07-01', '1', '1');
INSERT INTO `company_news` VALUES ('34', '2017年第十次例会', '今天开会，不许迟到！！今天开会，不许迟到！！今天开会，不许迟到！！', '2017-09-04', '1', '1');
INSERT INTO `company_news` VALUES ('35', '2017年第一次例会', '会议第一次召开', '2017-06-16', '1', '1');
INSERT INTO `company_news` VALUES ('36', '2017年 第1号公告', '落实房地产开发醒目资金情况明细表：1....\n2..........\n3.....', '2017-09-05', '1', '1');
INSERT INTO `company_news` VALUES ('37', '哈哈哈哈', '111222', '2017-06-27', '1', '1');
INSERT INTO `company_news` VALUES ('38', '11', '11', '2017-06-22', '1', '1');
INSERT INTO `company_news` VALUES ('39', '2017最后一次例会', '啊啊啊啊啊', '2017-06-21', '1', '1');
INSERT INTO `company_news` VALUES ('40', '2017 第二号公告', '湿哒哒湿哒哒收到蓄电池vcc', '2017-06-15', '1', '1');
INSERT INTO `company_news` VALUES ('41', 'dsada', 'asd', '2017-06-13', '1', '1');
INSERT INTO `company_news` VALUES ('42', 'dasd', 'sdada', '2017-06-20', '1', '1');
INSERT INTO `company_news` VALUES ('43', 'asdasda', 'sadadasd', '2017-07-05', '1', '1');
INSERT INTO `company_news` VALUES ('44', 'dfsdfasf', 'fdsfsdf', '2017-06-17', '1', '1');
INSERT INTO `company_news` VALUES ('45', 'sdas', 'sada', '2017-06-06', '1', '1');
INSERT INTO `company_news` VALUES ('46', 'dsaa', 'adsad', '2017-05-30', '1', '1');
INSERT INTO `company_news` VALUES ('47', 'uuy', 'try', '2017-06-21', '1', '1');
INSERT INTO `company_news` VALUES ('48', '1', '23', '2017-05-30', '1', '1');
INSERT INTO `company_news` VALUES ('49', '委屈翁多大所', '我去', '2017-06-06', '1', '1');
INSERT INTO `company_news` VALUES ('50', '112323', '试试', '2017-06-07', '1', '1');
INSERT INTO `company_news` VALUES ('51', '123213', '王企鹅', '2017-06-13', '2', '1');
INSERT INTO `company_news` VALUES ('52', '十大大时代才是', '阿萨德', '2017-06-13', '1', '1');

-- ----------------------------
-- Table structure for company_train
-- ----------------------------
DROP TABLE IF EXISTS `company_train`;
CREATE TABLE `company_train` (
  `trainId` int(5) unsigned NOT NULL AUTO_INCREMENT COMMENT '培训id',
  `trainTitle` varchar(50) NOT NULL COMMENT '标题',
  `trainLecturer` varchar(11) NOT NULL COMMENT '职务信息的id',
  `trainTime` varchar(50) NOT NULL COMMENT '培训时间',
  `other` varchar(255) NOT NULL DEFAULT '' COMMENT '内容',
  `createId` varchar(11) NOT NULL DEFAULT '1111' COMMENT '创建人id',
  `state` tinyint(2) DEFAULT '1' COMMENT '当前状态：1表示存在  0 表示删除',
  PRIMARY KEY (`trainId`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of company_train
-- ----------------------------
INSERT INTO `company_train` VALUES ('1', '123456789', '2', '3', '4', '1', '0');
INSERT INTO `company_train` VALUES ('2', '12', '1', '123', '131', '12', '0');
INSERT INTO `company_train` VALUES ('3', '1', '3', '123', '123', '2', '0');
INSERT INTO `company_train` VALUES ('4', '1', '1asdasf', '2017-06-15', '1', '1', '0');
INSERT INTO `company_train` VALUES ('5', '1', '1', '1', '1', '1', '0');
INSERT INTO `company_train` VALUES ('6', '1', '1', '2017-06-15', 'aaaaaa', '1', '0');
INSERT INTO `company_train` VALUES ('7', '计算机组成原理', '张韬祥', '2017-06-24', '复习备战', '1111', '1');
INSERT INTO `company_train` VALUES ('8', '数据结构', '蔡渠', '2017-06-24', '复习备战期末', '1111', '1');
INSERT INTO `company_train` VALUES ('9', '马克思', '列宁', '2017-06-25', '我睡得晚所大大无所', '1111', '1');
INSERT INTO `company_train` VALUES ('10', '大学读写译', '奥巴马', '2017-06-24', '……', '1111', '0');
INSERT INTO `company_train` VALUES ('11', 'asdf', 'asdf', '2017-06-21', 'asdfasdfasdfsdfasdf', '1111', '0');
INSERT INTO `company_train` VALUES ('12', '大学视听说', '克朗普', '2017-06-24', '……', '1111', '0');
INSERT INTO `company_train` VALUES ('13', '', '', '', '4', '1111', '0');
INSERT INTO `company_train` VALUES ('14', '', '', '', '4', '1111', '0');
INSERT INTO `company_train` VALUES ('15', '123', '123', '2017-06-22', '132', '1111', '1');
INSERT INTO `company_train` VALUES ('16', '1122', '123', '2017-06-29', '132133133', '1111', '1');
INSERT INTO `company_train` VALUES ('17', '1123', '1123', '2017-06-22', '1321313', '1111', '1');
INSERT INTO `company_train` VALUES ('18', '1124', '123', '2017-06-22', '132132', '1111', '0');
INSERT INTO `company_train` VALUES ('19', '1125', '123', '2017-06-09', '1321313', '1111', '0');
INSERT INTO `company_train` VALUES ('20', '13213', '132131', '313', '131', '1111', '0');
INSERT INTO `company_train` VALUES ('21', 'asfasd', 'asdf', '2017-06-14', 'asfasdf', '1111', '0');
INSERT INTO `company_train` VALUES ('22', '萨达', '萨达', '2017-07-03', '爱迪生', '1111', '0');

-- ----------------------------
-- Table structure for company_wages
-- ----------------------------
DROP TABLE IF EXISTS `company_wages`;
CREATE TABLE `company_wages` (
  `wageId` int(5) unsigned NOT NULL AUTO_INCREMENT COMMENT '工资id',
  `workerId` int(5) NOT NULL COMMENT '存放员工的id',
  `wageBase` float(10,2) NOT NULL DEFAULT '0.00',
  `wagePlace` float(10,2) NOT NULL DEFAULT '0.00',
  `wageAdd` float(10,2) NOT NULL DEFAULT '0.00' COMMENT '表示加班工资',
  `wageOutAch` float(10,2) NOT NULL DEFAULT '0.00' COMMENT '绩效奖',
  `wageLengYear` float(10,2) NOT NULL DEFAULT '0.00' COMMENT '工龄奖',
  `wageSum` float(10,2) NOT NULL DEFAULT '0.00' COMMENT '工资合计',
  `wageState` tinyint(2) NOT NULL DEFAULT '1' COMMENT '状态 1表示存在 0 表示删除',
  PRIMARY KEY (`wageId`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of company_wages
-- ----------------------------
INSERT INTO `company_wages` VALUES ('2', '1', '8888.00', '6666.00', '888.00', '666.00', '66666.00', '83774.00', '1');
INSERT INTO `company_wages` VALUES ('4', '11', '1212.30', '121.00', '121.00', '121.00', '121.00', '1696.30', '1');
INSERT INTO `company_wages` VALUES ('5', '14', '12.00', '12.00', '12.00', '121.00', '2.00', '159.00', '1');
INSERT INTO `company_wages` VALUES ('6', '15', '12.00', '12.00', '12.00', '12.00', '12.00', '60.00', '1');
INSERT INTO `company_wages` VALUES ('7', '16', '15.00', '15.00', '13.00', '15.00', '15.00', '73.00', '1');
INSERT INTO `company_wages` VALUES ('8', '23', '1288.00', '10.00', '100.00', '1000.00', '999999.00', '1002397.00', '1');
INSERT INTO `company_wages` VALUES ('9', '18', '212.00', '123.00', '13.00', '1.00', '132.00', '481.00', '1');
INSERT INTO `company_wages` VALUES ('10', '20', '132.00', '13.00', '13.00', '13.00', '123.00', '294.00', '1');
INSERT INTO `company_wages` VALUES ('11', '21', '123.00', '465.00', '7498.00', '123.00', '465.00', '8674.00', '0');
INSERT INTO `company_wages` VALUES ('12', '17', '20.00', '20.00', '20.00', '20.00', '20.00', '100.00', '1');
INSERT INTO `company_wages` VALUES ('13', '19', '12.00', '12.00', '12.00', '12.00', '12.00', '60.00', '1');
INSERT INTO `company_wages` VALUES ('14', '22', '12.00', '12.00', '12.00', '12.00', '12.00', '60.00', '0');
INSERT INTO `company_wages` VALUES ('15', '24', '112.00', '12.00', '12.00', '12.00', '123.00', '271.00', '1');
INSERT INTO `company_wages` VALUES ('16', '42', '12.00', '12.00', '12.00', '11.00', '11.00', '58.00', '1');
INSERT INTO `company_wages` VALUES ('17', '44', '1231.30', '11.00', '124.00', '154.00', '163.21', '1683.51', '0');
INSERT INTO `company_wages` VALUES ('18', '26', '12232.00', '96.00', '0.00', '0.00', '0.00', '12328.00', '0');

-- ----------------------------
-- Table structure for test
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `id` varchar(2) DEFAULT NULL,
  `name` varchar(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of test
-- ----------------------------
INSERT INTO `test` VALUES ('as', 'as');
