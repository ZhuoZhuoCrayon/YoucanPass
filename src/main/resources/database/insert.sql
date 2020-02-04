# ------------------------------------------------------------------------------------
# ims-公共信息管理系统
# ------------------------------------------------------------------------------------
insert into ims_department(department_id, name, type, status)
values (0, '计算机与软件学院', 1, 1),
       (0, '(师范)教育学部' , 0, 1),
       (2, '教育学院', 1, 1),
       (2, '心理学院', 1, 1),
       (2, '体育学院', 1, 1),
       (1, '计算机科学与技术', 2, 1),
       (1, '软件工程', 2, 1),
       (1, '物联网工程', 2, 1),
       (6, '2017-计算机科学与技术01', 3, 1),
       (7, '2017-软件工程01', 2, 1),
       (8, '2017-物联网工程01', 2, 1);


insert into ims_semester(begin_year, end_year, term, description)
values (2016, 2017, 1, '2016-2017学年度第一学期'),
       (2016, 2017, 2, '2016-2017学年度第二学期'),
       (2017, 2018, 1, '2017-2018学年度第一学期'),
       (2017, 2018, 2, '2017-2018学年度第二学期'),
       (2018, 2019, 1, '2018-2019学年度第一学期'),
       (2018, 2019, 2, '2018-2019学年度第二学期'),
       (2019, 2020, 1, '2019-2020学年度第一学期'),
       (2019, 2020, 2, '2019-2020学年度第二学期'),
       (2020, 2021, 1, '2020-2021学年度第一学期'),
       (2020, 2021, 2, '2020-2021学年度第二学期');


# ------------------------------------------------------------------------------------
# ums-用户管理系统
# ------------------------------------------------------------------------------------

insert into ums_user(username, password, real_name, department_id, political_affiliation, email, qq,
                     wechat, wechat_qrcode, phone, address, note, create_time, status)
values ('2017151019', '$2a$10$9mzVyi84DDoDxyoZEfsaYOFw7KFIWbpTmGC285VRJOE3hhJugqy2O', '蔡晓鑫', 10, '预备党员', '873217631@qq.com', '873217631',
        '15625266605', '/wechat/default.png', '15625266605', '计软楼716', '测试学生讲师', now(), 1),

       ('2017151112', '$2a$10$YrSb5ipWcWMuvq1QH7t97.PLU./VbHFiAaOeIiaO1Z84sUP5OePOi', '小新', 11,  '共青团员', '812322433@qq.com', '812322433',
        '15986867085', '/wechat/default.png', '15986867085', '计软楼720', '测试学生', now(), 1),

       ('241541', '$2a$10$/XiyNo.BW5xHzAmuq5RPQuUFiD8IiW0DfIkau3fryfwRw/hp36ic2', '小高', 1, '中共党员', 'xiaogao@szu.edu.cn', '88888',
        '13945677565', '/wechat/default.png', '13945677565', '计软楼824', '测试辅导员', now(), 1),

       ('5888', '$2a$10$YmYAq47kfSZcSZITn.1LOOggFuXpWfRz/hjSSugibWMXS.C4dilVe', '白老师', 1, '群众', 'baitea@szu.edu.cn', '152266',
        '17132434334', '/wechat/default.png', '17132434334', '计软楼1015', '测试讲师', now(), 1);


insert into ums_role(name, description, status)
values ('学生', '学生', 1),
       ('学生讲师', '学生讲师', 1),
       ('教师', '教师', 1),
       ('辅导员', '辅导员', 1);

insert into ums_permission(pid, type, name, value, url)
values (0, 0, 'ims-公共信息管理系统', null, null),
       (0, 0, 'ums-用户管理系统', null, null),
       (0, 0, 'cms-课程管理系统', null, null),
       (0, 0, 'sms-监督管理系统', null, null),
       (1, 1, 'ims_college(学院/部表)', null, null),
       (1, 1, 'ims_semester(学期信息表)', null, null),
       (2, 1, 'ums_user(用户表)', null, null),
       (2, 1, 'ums_role(角色表)', null, null),
       (2, 1, 'ums_permission(权限表)', null, null),
       (2, 1, 'ums_user_role_relation(用户角色关系表)', null, null),
       (2, 1, 'ums_role_permission_relation(角色权限关系表)', null, null),
       (3, 1, 'cms_course(课程表)', null, null),
       (3, 1, 'cms_opencourse(用户开课信息表)', null, null),
       (3, 1, 'cms_user_opencourse_relation(选课关系表)', null, null),
       (3, 1, 'cms_favorite_course(收藏课程表)', null, null),
       (4, 1, 'sms_freetime(空闲时间表)', null, null),
       (4, 1, 'sms_user_freetime_relation(用户空闲时间表)', null, null),
       (4, 1, 'sms_opencourse_record(课程学习记录表)', null, null),
       (4, 1, 'sms_message(站内通知信息表)', null, null),
       (4, 1, 'sms_follow_student(关注学生表)', null, null),
       (5, 2, '查看学院/部信息', 'ims:college:read', '/ims/college/get'),
       (5, 2, '添加学院/部信息', 'ims:college:insert', '/ims/college/insert'),
       (5, 2, '修改学院/部信息', 'ims:college:update', '/ims/college/update'),
       (5, 2, '删除学院/部信息', 'ims:college:delete', '/ims/college/delete'),
       (6, 2, '查看学期信息', 'ims:semester:read', '/ims/semester/get'),
       (6, 2, '添加学期信息', 'ims:semester:insert', '/ims/semester/insert'),
       (6, 2, '修改学期信息', 'ims:semester:update', '/ims/semester/update'),
       (6, 2, '删除学期信息', 'ims:semester:delete', '/ims/semester/delete'),
       (7, 2, '查看用户信息', 'ums:user:read', '/ums/user/get'),
       (7, 2, '添加用户信息', 'ums:user:insert', '/ums/user/insert'),
       (7, 2, '修改用户信息', 'ums:user:update', '/ums/user/update'),
       (7, 2, '删除用户信息', 'ums:user:delete', '/ums/user/delete'),
       (8, 2, '查看角色信息', 'ums:role:read', '/ums/role/get'),
       (8, 2, '添加角色信息', 'ums:role:insert', '/ums/role/insert'),
       (8, 2, '修改角色信息', 'ums:role:update', '/ums/role/update'),
       (8, 2, '删除角色信息', 'ums:role:delete', '/ums/role/delete'),
       (9, 2, '查看权限信息', 'ums:permission:read', '/ums/permission/get'),
       (9, 2, '添加权限信息', 'ums:permission:insert', '/ums/permission/insert'),
       (9, 2, '修改权限信息', 'ums:permission:update', '/ums/permission/update'),
       (9, 2, '删除权限信息', 'ums:permission:delete', '/ums/permission/delete'),
       (10, 2, '查看用户角色关系信息', 'ums:user_role_relation:read', '/ums/user_role_relation/get'),
       (10, 2, '添加用户角色关系信息', 'ums:user_role_relation:insert', '/ums/user_role_relation/insert'),
       (10, 2, '修改用户角色关系信息', 'ums:user_role_relation:update', '/ums/user_role_relation/update'),
       (10, 2, '删除用户角色关系信息', 'ums:user_role_relation:delete', '/ums/user_role_relation/delete'),
       (11, 2, '查看角色权限关系', 'ums:role_permission_relation:read', '/ums/role_permission_relation/get'),
       (11, 2, '添加角色权限关系', 'ums:role_permission_relation:insert', '/ums/role_permission_relation/insert'),
       (11, 2, '修改角色权限关系', 'ums:role_permission_relation:update', '/ums/role_permission_relation/update'),
       (11, 2, '删除角色权限关系', 'ums:role_permission_relation:delete', '/ums/role_permission_relation/delete');

insert into ums_user_role_relation(user_id, role_id) values
(1, 1), (1, 2), (2, 1), (3, 4), (4, 2);

insert into ums_role_permission_relation(role_id, permission_id) values
(1, 21), (1, 25),
(2, 21), (2, 25),
(3, 21), (3, 25),
(4, 21), (4, 22), (4, 23), (4, 24), (4, 25), (4, 26), (4, 27), (4, 28);