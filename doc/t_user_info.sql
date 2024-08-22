CREATE TABLE `t_user_info` (
  `id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` VARCHAR(255) NOT NULL COMMENT '用户名',
  `password` VARCHAR(255) NOT NULL COMMENT '密码',
  `phone` VARCHAR(20) NOT NULL COMMENT '手机号',
  `address` VARCHAR(255) DEFAULT NULL COMMENT '地址',
  `is_deleted` TINYINT(1) NOT NULL DEFAULT '0' COMMENT '删除标志位。0：未删除；1：已删除',
  `gmt_create` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_updated` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户表';

INSERT INTO `t_user_info` (`username`, `password`, `phone`, `address`, `is_deleted`, `gmt_create`, `gmt_updated`)
VALUES ('张三', '123456', '112233445566', '安徽省芜湖市', 0, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
