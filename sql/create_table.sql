-- auto-generated definition
create table user
(
    username     varchar(256)                           null comment '用户昵称',
    id           bigint auto_increment comment 'id'
        primary key,
    userAccount  varchar(256)                           null comment '账号',
    avatarUrl    varchar(1024)                          null comment '用户头像',
    gender       varchar(256) default '男'              null comment '性别 男 女',
    userPassword varchar(512)                           not null comment '密码',
    phone        varchar(128)                           null comment '电话',
    email        varchar(512)                           null comment '邮箱',
    userStatus   int          default 0                 not null comment '状态 0 - 正常 1-注销 2-封号',
    createTime   datetime     default CURRENT_TIMESTAMP null comment '创建时间',
    updateTime   datetime     default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete     tinyint      default 0                 not null comment '是否删除',
    userRole     varchar(256) default 'user'            not null comment 'user-普通用户 admin-管理员 ban-封号',
    userCode     varchar(512)                           null comment '用户编号'
)
    comment '用户';
