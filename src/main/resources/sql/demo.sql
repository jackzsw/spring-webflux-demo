CREATE TABLE `client_user` (
  `user_id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '用户唯一标示',
  `username` varchar(64) DEFAULT NULL COMMENT '名称',
  `phone_number` varchar(64) DEFAULT NULL COMMENT '手机号',
  `gender` tinyint(1) DEFAULT '0' COMMENT '0 未知 1 男 2 女',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;