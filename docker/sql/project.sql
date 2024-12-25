CREATE DATABASE IF NOT EXISTS masterdb CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

USE masterdb;

CREATE TABLE `t_order_info` (
                                `id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
                                `user_id` BIGINT(20) NOT NULL COMMENT '用户id',
                                `user_name` VARCHAR(255) NOT NULL COMMENT '用户名',
                                `phone` VARCHAR(20) NOT NULL COMMENT '手机号',
                                `address` VARCHAR(255) DEFAULT NULL COMMENT '地址',
                                `total_price` DECIMAL(10, 2) NOT NULL COMMENT '商品价格（总价）',
                                `is_deleted` TINYINT(1) NOT NULL DEFAULT '0' COMMENT '删除标志位。0：未删除；1：已删除',
                                `gmt_create` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                `gmt_updated` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                                PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='订单表';

CREATE TABLE `t_order_item_info` (
                                     `id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
                                     `order_id` BIGINT(20) NOT NULL COMMENT '订单id',
                                     `pro_id` BIGINT(20) NOT NULL COMMENT '商品id',
                                     `pro_name` VARCHAR(255) NOT NULL COMMENT '商品名称',
                                     `pro_price` DECIMAL(10, 2) NOT NULL COMMENT '商品价格（单价）',
                                     `number` INT(11) NOT NULL COMMENT '购买数量',
                                     `is_deleted` TINYINT(1) NOT NULL DEFAULT '0' COMMENT '删除标志位。0：未删除；1：已删除',
                                     `gmt_create` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                     `gmt_updated` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                                     PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='订单项表';

CREATE TABLE `t_product_info` (
                                  `id` BIGINT ( 20 ) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
                                  `pro_name` VARCHAR ( 255 ) NOT NULL COMMENT '商品名称',
                                  `pro_price` DECIMAL ( 10, 2 ) NOT NULL COMMENT '商品价格',
                                  `pro_stock` INT ( 11 ) NOT NULL COMMENT '商品库存',
                                  `is_deleted` TINYINT ( 1 ) NOT NULL DEFAULT '0' COMMENT '删除标志位。0：未删除；1：已删除',
                                  `gmt_create` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                  `gmt_updated` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                                  PRIMARY KEY ( `id` )
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '商品表';

INSERT INTO `t_product_info` ( `pro_name`, `pro_price`, `pro_stock` )
VALUES
    ( 'iphone 15 pro', 8888.00, 10 );

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
