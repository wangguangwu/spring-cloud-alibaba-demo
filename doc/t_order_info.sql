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