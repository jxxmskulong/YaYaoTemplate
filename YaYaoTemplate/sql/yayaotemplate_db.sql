# 数据库 
#创建数据库
DROP DATABASE IF EXISTS yayaotemplate_db;
CREATE DATABASE yayaotemplate_db;

#使用数据库 
use yayaotemplate_db;
#创建用户表 
CREATE TABLE user_tb(
user_id int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
nice_name varchar(255) NOT NULL COMMENT '昵称',
name varchar(255) NOT NULL COMMENT '账户名',
password varchar(255) NOT NULL COMMENT '密码',
reg_time timestamp NOT NULL COMMENT '注册时间',
last_login_time timestamp  NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后登陆时间',
PRIMARY KEY (user_id),
key idx_reg_time(reg_time),
key idx_last_login_time(last_login_time)
)ENGINE = InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='用户表';
insert into 
	user_tb(nice_name,name,password)
values
	('聂跃','15111336587','123456');
