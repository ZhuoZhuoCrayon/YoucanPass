# ------------------------------------------------------------------------------------
# ims-公共信息管理系统
# ------------------------------------------------------------------------------------
drop table if exists ims_department;
create table ims_department
(
    id            bigint(20) auto_increment comment '部门id:primary key',
    department_id bigint(20)   not null comment '父级节点id',
    name          varchar(100) not null comment '部门节点名称',
    type          int(1)       not null comment '节点层级:0->学部/1->学院/2->专业(系)/3->年级-班级',
    status        int(1)       not null default 0 comment '启用状态:0->禁用,1->启用',
    primary key (id)
) engine = InnoDB
  charset = utf8 comment = '学校院系层级表';

drop table if exists ims_semester;
create table ims_semester
(
    id          bigint(20) auto_increment comment '学期信息id:primary key',
    begin_year  int(6)       not null comment '起始年度:2019',
    end_year    int(6)       not null comment '截至年度:2020',
    term        int(1)       not null comment '学期:1->第一学期/2->第二学期',
    description varchar(100) not null comment '学期信息描述:2019-2020学年度第二学期',
    primary key (id)
) engine = InnoDB
  charset = utf8 comment = '学期信息表';


# ------------------------------------------------------------------------------------
# ums-用户管理系统
# ------------------------------------------------------------------------------------
drop table if exists ums_user;
create table ums_user
(
    id                    bigint(20) auto_increment comment '用户id',
    username              varchar(50)  not null unique comment '学号/教工号',
    password              varchar(100) not null comment '密码',
    real_name             varchar(100) not null comment '真实姓名',
    department_id         bigint(100)  not null comment '所属部门节点：学生精确到班级，教师辅导员精确到学院',
    political_affiliation varchar(100) not null comment '政治面貌:预备党员/党员/...',
    email                 varchar(100) comment '邮箱',
    qq                    varchar(20) comment 'QQ账号',
    wechat                varchar(50) comment '微信号',
    wechat_qrcode         varchar(100) comment '微信二维码:图片地址',
    phone                 varchar(50)  not null comment '联系电话',
    address               varchar(200) not null comment '地址:宿舍或办公室',
    note                  text comment '备注信息',
    create_time           datetime     not null comment '创建时间',
    status                int(1) default 1 comment '状态:0->禁用，1->启用',
    primary key (id)
) engine = InnoDB
  charset = utf8 comment = '用户表';

drop table if exists ums_role;
create table ums_role
(
    id          bigint(20) auto_increment comment '角色id:自增',
    name        varchar(100) not null comment '角色名:辅导员/学生讲师/教师/学生',
    description varchar(100) not null comment '角色描述',
    status      int(1)       not null default 0 comment '启用状态:0->禁用/1->启用',
    primary key (id)
) engine = InnoDB
  charset = utf8 comment = '角色表';

drop table if exists ums_permission;
create table ums_permission
(
    id     bigint(20) auto_increment comment '权限id:自增',
    pid    bigint(20)   not null comment '父级权限',
    type   int(1)       not null comment '权限类型:0->管理层/1->管理表/2->绑定权限',
    name   varchar(100) not null comment '权限名称',
    value  varchar(100) comment '权限值:ums:user:insert',
    url    varchar(100) comment '权限路径:/ums/user/insert',
    status int(1)       not null default 1 comment '启用状态:0->禁用/1->启用',
    primary key (id)
) engine = InnoDB
  charset = utf8 comment = '权限表';

drop table if exists ums_user_role_relation;
create table ums_user_role_relation
(
    id      bigint(20) auto_increment comment '用户角色关系id',
    user_id bigint(20) not null comment '学号/教工号(用户id)',
    role_id bigint(20) not null comment '角色id',
    primary key (id)
) engine = InnoDB
  charset = utf8 comment = '用户角色关系表';

drop table if exists ums_role_permission_relation;
create table ums_role_permission_relation
(
    id            bigint(20) auto_increment comment '角色权限关系id',
    role_id       bigint(20) not null comment '角色id',
    permission_id bigint(20) not null comment '权限id',
    primary key (id)
) engine = InnoDB
  charset = utf8 comment = '角色权限关系表';

# ------------------------------------------------------------------------------------
# ------------------------------------------------------------------------------------


# ------------------------------------------------------------------------------------
# cms-课程管理系统
# ------------------------------------------------------------------------------------

drop table if exists cms_course;
create table cms_course
(
    id            bigint(20) auto_increment comment '课程id',
    department_id bigint(20)   not null comment '开课单位id，精确到学院/学部',
    name          varchar(100) not null comment '课程名称',
    type          int(1)       not null comment '课程类型:0->专业核心课/1->专业选修课/2-其他',
    term          int(1)       not null comment '开课学期:1->第一学期/2->第二学期/3->全年开设',
    status        int(1)       not null default 0 comment '启用状态:0->禁用/1->启用',
    primary key (id)
) engine = InnoDB
  charset = utf8 comment = '课程表';

drop table if exists cms_opencourse;
create table cms_opencourse
(
    id             bigint(20) auto_increment comment '开课信息id',
    user_id        bigint(20) not null comment '开课用户id:关联ums_user',
    course_id      bigint(20) not null comment '课程id:关联 cms_course',
    semester_id    bigint(20) not null comment '学期信息id:关联cims_semester',
    select_limit   int(10)    not null default 0 comment '课程人数限制',
    select_count   int(11)             default 0 comment '选课人数',
    note           text comment '课程备注信息',
    status         int(2)     not null default 0 comment '审核状态:-1->未通过审核/0->待审核/1->审核通过（可选）/2->不可选/3->过期不可选',
    status_comment text comment '审核评价',
    primary key (id)
) engine = InnoDB
  charset = utf8 comment = '用户开课信息表';

drop table if exists cms_user_opencourse_relation;
create table cms_user_opencourse_relation
(
    id               bigint(20) auto_increment comment '选课关系id',
    user_id          bigint(20) not null comment '选课用户id:关联ums_user',
    opencourse_id    bigint(20) not null comment '开课信息id:关联cms_opencourse',
    evaluation_level int(1) comment '评价等级:0-5',
    evaluation_text  text comment '评价文本',
    file_url         varchar(100) comment '附件信息:附件信息',
    status           int(2)     not null default 0 comment '选课状态:0->待审核/1->审核通过/2->讲师确认/3->学生确认/4->上课中/5->结课(待评价)/-1->审核不通过/-2->退选',
    status_comment   text comment '审核评价',
    primary key (id)
) engine = InnoDB
  charset = utf8 comment = '选课关系表';

drop table if exists cms_favorite_opencourse;
create table cms_favorite_opencourse
(
    id            bigint(20) auto_increment comment '收藏id',
    user_id       bigint(20) not null comment '用户id:关联ums_user',
    opencourse_id bigint(20) not null comment '开课信息id:关联cms_opencourse',
    semester_id   bigint(20) not null comment '学期信息id:关联ims_semester',
    note          text comment '备注信息',
    primary key (id)
) engine = InnoDB
  charset = utf8 comment = '收藏课程表';

# ------------------------------------------------------------------------------------
# ------------------------------------------------------------------------------------

# ------------------------------------------------------------------------------------
# sms-监督管理系统
# ------------------------------------------------------------------------------------

drop table if exists sms_freetime;
create table sms_freetime
(
    id            bigint(20) auto_increment comment '空闲时间id',
    weekday       int(1) not null comment '空闲天:1-7->周一到周日',
    section_begin int(2) not null comment '空闲开始时间段:1、2......12',
    section_end   int(2) not null comment '空闲结束时间段:1、2......12',
    primary key (id)
) engine = InnoDB
  charset = utf8 comment = '空闲时间表';

drop table if exists sms_user_freetime_relation;
create table sms_user_freetime_relation
(
    id          bigint(20) auto_increment comment '空闲表id:primary key',
    user_id     bigint(20) not null comment '用户id:关联ums_user',
    freetime_id bigint(20) not null comment '空闲时间id:关联sms_freetime',
    primary key (id)
) engine = InnoDB
  charset = utf8 comment = '用户空闲时间表';

drop table if exists sms_opencourse_record;
create table sms_opencourse_record
(
    id                 bigint(20) auto_increment comment '课程记录id:primary key',
    user_opencource_id bigint(20) not null comment '选课关系id:关联cms_user_opencourse_relation(选课关系表)',
    course_date        date       not null comment '上课日期',
    course_time        float      not null comment '上课时间:单位：Hour',
    note               text comment '备注信息',
    commit_date        datetime            default now() comment '提交日期',
    status             int(1)     not null default 0 comment '状态:0->学生未确认/1->学生确认',
    status_comment     text comment '状态信息',
    primary key (id)
) engine = InnoDB
  charset = utf8 comment = '课程学习记录表';


drop table if exists sms_message;
create table sms_message
(
    id          bigint(20) auto_increment comment '通知信息id:primary',
    user_id     bigint(20) not null comment '用户id:关联ums_user',
    commit_date datetime   not null default now() comment '发布日期',
    update_date datetime   not null default now() comment '修改日期',
    title       text comment '标题',
    content     text comment '内容',
    status      int(1)     not null default 0 comment '状态:0->隐藏/1->发布/2-置顶',
    primary key (id)
) engine = InnoDB
  charset = utf8 comment = '站内通知信息表';

drop table if exists sms_follow_student;
create table sms_follow_student
(
    id          bigint(20) auto_increment comment '关注学生序列id:primary',
    user_id     bigint(20) not null comment '用户id:关联ums_user',
    follow_id   bigint(20) not null comment '关注用户id:关联ums_user',
    semester_id bigint(20) not null comment '学期信息id:关联ims_semester',
    note        text comment '备注信息',
    primary key (id)
) engine = InnoDB
  charset = utf8 comment = '关注学生表';

# ------------------------------------------------------------------------------------
# ------------------------------------------------------------------------------------