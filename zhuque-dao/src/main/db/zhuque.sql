# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 182.92.173.117 (MySQL 5.5.28-log)
# Database: zhuque
# Generation Time: 2019-01-16 10:51:58 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table ad_group
# ------------------------------------------------------------

DROP TABLE IF EXISTS `ad_group`;

CREATE TABLE `ad_group` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `campaign_id` int(11) NOT NULL COMMENT '推广活动id',
  `scheduling` varchar(1024) DEFAULT NULL COMMENT '广告投放排期',
  `deliver_method` int(4) DEFAULT '0' COMMENT '投放方式:0-正常/1-匀速',
  `begin_time` timestamp NULL DEFAULT NULL COMMENT '投放开始时间',
  `end_time` timestamp NULL DEFAULT NULL COMMENT '投放结束时间',
  `deliver_times` int(20) DEFAULT NULL COMMENT '投放时间段,用24位bitset表示',
  `limit` int(11) DEFAULT NULL COMMENT '每日限额, 单位元',
  `promotion_type` int(4) DEFAULT '1' COMMENT '推广类型,包括3-ios应用、2-安卓应用以及1-网站',
  `landing_page` varchar(128) DEFAULT NULL COMMENT '落地页',
  `cost_type` int(4) DEFAULT '0' COMMENT '计费类型,1:cpm;2:cpc;3:cpa;4:ocpa;5:ocpc',
  `app_id` varchar(32) DEFAULT NULL COMMENT 'ios应用appstore id',
  `pkg_name` varchar(100) DEFAULT NULL COMMENT '安卓应用包名',
  `bid_strategy` int(4) DEFAULT NULL COMMENT '出价策略,0:手动出价;1:智能出价',
  `freq_capping_enabled` tinyint(1) DEFAULT NULL COMMENT '是否启用频次控制',
  `frequency` varchar(255) DEFAULT NULL COMMENT '频次限制',
  `freq_capping_type` int(11) DEFAULT NULL COMMENT '频次控制类型, 1-设备; 2-IP',
  `status` int(4) DEFAULT '1' COMMENT '状态,0:无效;1:有效;2:运行中;3:过期;4:停止',
  `target_area` varchar(256) DEFAULT NULL COMMENT '地域定向',
  `target_lbs` varchar(255) DEFAULT NULL COMMENT '商圈定向',
  `target_os` int(4) DEFAULT NULL COMMENT '操作系统定向,0:不限;1:ios;2:安卓',
  `target_behavior` varchar(100) DEFAULT NULL COMMENT '行为定向',
  `target_media` varchar(256) DEFAULT NULL COMMENT '媒体定向,支持多个媒体定向',
  `target_terminal` int(4) DEFAULT '0' COMMENT '终端定向,0:不限;1:移动端;2:pc端;3:wap',
  `target_device_type` int(11) DEFAULT NULL COMMENT '定向设备类型,包括phone,pad,tv',
  `target_model` int(11) DEFAULT NULL COMMENT '设备型号定向',
  `target_carrier` int(11) DEFAULT NULL COMMENT '运营商',
  `target_connection_type` int(11) DEFAULT NULL COMMENT '网络类型定向',
  `target_device` varchar(512) DEFAULT NULL COMMENT '设备定向, 多个设备id逗号分隔',
  `target_interests` int(11) DEFAULT NULL COMMENT '商业兴趣定向',
  `target_audience` int(11) DEFAULT NULL COMMENT '受众定向, 人群包id',
  `target_ext` varchar(4096) DEFAULT NULL COMMENT '扩展定向,用json表示',
  `deal_id` varchar(32) DEFAULT NULL COMMENT '私有化交易ID,pmp或PD使用',
  `imp_trackers` varchar(1024) DEFAULT NULL COMMENT '第三方点击监测url',
  `clk_trackers` varchar(1024) DEFAULT NULL COMMENT '第三方曝光监测url',
  `bid_price` int(11) DEFAULT NULL COMMENT '广告出价,单位分,只在bid_strategy为手动出价的时候有效',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL,
  `ad_position_id` int(11) DEFAULT NULL COMMENT '广告位id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='广告组(系列),广告投放定向设定';



# Dump of table ad_position
# ------------------------------------------------------------

DROP TABLE IF EXISTS `ad_position`;

CREATE TABLE `ad_position` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '广告位id',
  `uuid` varchar(32) NOT NULL COMMENT '广告位唯一标识符',
  `name` varchar(100) DEFAULT NULL COMMENT '广告位名称',
  `description` varchar(1024) DEFAULT NULL COMMENT '广告位描述',
  `demo_url` varchar(512) DEFAULT NULL COMMENT 'demo url',
  `creative_type` int(11) DEFAULT NULL COMMENT '广告类型,1:banner;2:video;3:native;4:audio; 5:reward_video;',
  `status` int(11) DEFAULT NULL COMMENT '广告位状态,0:无效;1:有效',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL,
  `template_id` int(11) DEFAULT NULL COMMENT '模板id',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_unique_ad_pos_uid` (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统广告位';



# Dump of table ad_position_floor
# ------------------------------------------------------------

DROP TABLE IF EXISTS `ad_position_floor`;

CREATE TABLE `ad_position_floor` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='广告位底价';



# Dump of table advertiser
# ------------------------------------------------------------

DROP TABLE IF EXISTS `advertiser`;

CREATE TABLE `advertiser` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `advertiser_audit_id` int(11) DEFAULT NULL COMMENT '广告主id(真实)',
  `agent_id` int(11) DEFAULT NULL,
  `name` varchar(255) NOT NULL COMMENT '广告主名称',
  `industry_id` int(11) DEFAULT NULL COMMENT '所属行业',
  `website` varchar(255) DEFAULT NULL COMMENT '客户网址',
  `address` varchar(255) DEFAULT NULL COMMENT '联系地址',
  `phone` varchar(32) DEFAULT NULL COMMENT '联系电话',
  `contacts` int(11) DEFAULT NULL COMMENT '联系人',
  `audit_status` int(11) DEFAULT NULL COMMENT '审核状态',
  `audit_comments` varchar(255) DEFAULT NULL COMMENT '审核备注',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '最后更新时间',
  `status` int(4) DEFAULT NULL COMMENT '状态,0-无效、1-有效，2-余额不足',
  `deleted` tinyint(1) DEFAULT '0' COMMENT '是否删除,1-删除,0-未删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='广告主';



# Dump of table advertiser_audit
# ------------------------------------------------------------

DROP TABLE IF EXISTS `advertiser_audit`;

CREATE TABLE `advertiser_audit` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL COMMENT '广告主名称',
  `industry_id` int(11) DEFAULT NULL COMMENT '所属行业',
  `website` varchar(255) DEFAULT NULL COMMENT '客户网址',
  `address` varchar(255) DEFAULT NULL COMMENT '联系地址',
  `phone` varchar(32) DEFAULT NULL COMMENT '联系电话',
  `contacts` int(11) DEFAULT NULL COMMENT '联系人',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '最后更新时间',
  `status` int(4) DEFAULT NULL COMMENT '状态,0-无效、1-有效',
  `deleted` tinyint(1) DEFAULT '0' COMMENT '是否删除,1-删除,0-未删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用来向ad-exchange审核的广告主';



# Dump of table advertiser_bill
# ------------------------------------------------------------

DROP TABLE IF EXISTS `advertiser_bill`;

CREATE TABLE `advertiser_bill` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '账单id',
  `advertiser_id` int(11) DEFAULT NULL COMMENT '广告主id',
  `bill_type` int(11) DEFAULT NULL COMMENT '类型: 1-充值; 2-退款',
  `price` double DEFAULT NULL COMMENT '金额',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
  `comments` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '账单备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='广告主账单';



# Dump of table advertiser_qualification
# ------------------------------------------------------------

DROP TABLE IF EXISTS `advertiser_qualification`;

CREATE TABLE `advertiser_qualification` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `advertiser_audit_id` int(11) NOT NULL COMMENT '广告主id',
  `qualification_name` varchar(255) DEFAULT NULL COMMENT '广告主资质名称',
  `qualification_file_url` varchar(255) DEFAULT NULL COMMENT '资质文件url',
  PRIMARY KEY (`id`,`advertiser_audit_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='广告主资质';



# Dump of table agent
# ------------------------------------------------------------

DROP TABLE IF EXISTS `agent`;

CREATE TABLE `agent` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '代理商名称',
  `logo_url` varchar(128) DEFAULT NULL COMMENT '代理商logo',
  `contacts` varchar(100) DEFAULT NULL COMMENT '联系人',
  `address` varchar(255) DEFAULT NULL COMMENT '联系地址',
  `phone` varchar(20) DEFAULT NULL COMMENT '联系电话',
  `balance` double DEFAULT NULL COMMENT '账户余额',
  `profit_margin` double DEFAULT NULL COMMENT '利润率',
  `bid_mode` int(1) DEFAULT '2' COMMENT '广告出价方式, 1-定价(fixed); 2-竞价(bid)',
  `bid_weight` double DEFAULT NULL COMMENT '出价系数',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL,
  `status` int(4) DEFAULT NULL COMMENT '代理商状态,0-无效、1-有效、2-余额不足',
  `deleted` tinyint(1) DEFAULT '0' COMMENT '是否删除,0-正常,1-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='代理商';



# Dump of table agent_bill
# ------------------------------------------------------------

DROP TABLE IF EXISTS `agent_bill`;

CREATE TABLE `agent_bill` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `agent_id` int(11) DEFAULT NULL COMMENT '代理商id',
  `bill_type` int(11) DEFAULT NULL COMMENT '账单类型: 1-充值; 2-退款',
  `price` double DEFAULT NULL COMMENT '账单金额',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '账单创建时间',
  `comments` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='代理商账单';



# Dump of table agent_floor
# ------------------------------------------------------------

DROP TABLE IF EXISTS `agent_floor`;

CREATE TABLE `agent_floor` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='代理商底价配置';



# Dump of table campaign
# ------------------------------------------------------------

DROP TABLE IF EXISTS `campaign`;

CREATE TABLE `campaign` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '推广活动id',
  `advertiser_id` int(10) unsigned DEFAULT NULL COMMENT '广告主id',
  `name` varchar(255) NOT NULL COMMENT '推广活动名称',
  `budget` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '每日预算/限额',
  `status` int(4) DEFAULT NULL COMMENT '推广状态,0-无效、1-有效、4-超限额',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  `deleted` tinyint(1) DEFAULT '0' COMMENT '删除状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='推广活动';



# Dump of table creative
# ------------------------------------------------------------

DROP TABLE IF EXISTS `creative`;

CREATE TABLE `creative` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '创意id,主键自增',
  `creative_url` varchar(128) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `ad_group_id` int(11) NOT NULL COMMENT '推广单元id',
  `html_snippet` varchar(4096) DEFAULT NULL COMMENT '动态广告素材内容',
  `audit_status` int(11) DEFAULT NULL COMMENT '审核状态',
  `audit_comments` varchar(256) DEFAULT NULL COMMENT '审核备注',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL,
  `status` int(11) DEFAULT NULL COMMENT '状态',
  `deleted` tinyint(1) DEFAULT '0' COMMENT '删除状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='广告(创意)';



# Dump of table dsp
# ------------------------------------------------------------

DROP TABLE IF EXISTS `dsp`;

CREATE TABLE `dsp` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL COMMENT 'dsp名称',
  `token` varchar(32) DEFAULT NULL,
  `uuid` varchar(32) NOT NULL COMMENT 'dspid, 32位字符串',
  `rtb_url` varchar(255) DEFAULT NULL,
  `qps` int(11) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `status` int(11) unsigned DEFAULT '1' COMMENT 'dsp状态: 1-正常,0-关闭',
  `contacts` varchar(100) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `phone` varchar(32) DEFAULT NULL,
  `email` varchar(64) DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='第三方广告平台';



# Dump of table dsp_target
# ------------------------------------------------------------

DROP TABLE IF EXISTS `dsp_target`;

CREATE TABLE `dsp_target` (
  `id` int(11) NOT NULL,
  `dsp_id` int(11) DEFAULT NULL,
  `targets` varchar(4096) DEFAULT NULL COMMENT 'dsp流量定向',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='dsp受众定向设置';



# Dump of table material
# ------------------------------------------------------------

DROP TABLE IF EXISTS `material`;

CREATE TABLE `material` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '素材id',
  `name` varchar(100) DEFAULT NULL COMMENT '素材名称',
  `type` int(11) DEFAULT NULL COMMENT '素材类型, 1-图片，2-视频，3-音频',
  `url` varchar(255) DEFAULT NULL COMMENT '素材url',
  `tags` varchar(255) DEFAULT NULL COMMENT '素材标签',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `status` int(11) DEFAULT NULL COMMENT '素材状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='广告素材';



# Dump of table media_ad_position
# ------------------------------------------------------------

DROP TABLE IF EXISTS `media_ad_position`;

CREATE TABLE `media_ad_position` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `ad_position_id` int(11) DEFAULT NULL COMMENT '广告位id',
  `media_id` int(11) DEFAULT NULL COMMENT '媒体id',
  `media_position_id` varchar(32) DEFAULT NULL COMMENT '媒体广告位id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='媒体广告位';



# Dump of table sys_log
# ------------------------------------------------------------

DROP TABLE IF EXISTS `sys_log`;

CREATE TABLE `sys_log` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table template
# ------------------------------------------------------------

DROP TABLE IF EXISTS `template`;

CREATE TABLE `template` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(128) DEFAULT NULL,
  `type` int(11) DEFAULT NULL COMMENT '模板类型',
  `spec` varchar(2048) DEFAULT NULL COMMENT '模板定义',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新日期',
  `status` int(11) DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT '0' COMMENT '删除状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='广告位模板';



# Dump of table user
# ------------------------------------------------------------

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统用户';




/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
