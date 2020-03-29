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
       (7, '2017-软件工程01', 3, 1),
       (8, '2017-物联网工程01', 3, 1);


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
        '17132434334', '/wechat/default.png', '17132434334', '计软楼1015', '测试讲师', now(), 1),

        ('admin', '$2a$10$zJu6AZ1YnS0fJSAYlAJ7oOfRF5MescFgvpyE4QWg1G60iuei6OdYi', 'admin', 1, '-', 'admin@szu.edu.cn', '123',
         '123', '/wechat/default.png', '123', '计软楼1015', '系统测试员', now(), 1);

insert into ums_role(name, description, status)
values ('学生', '学生', 1),
       ('学生讲师', '学生讲师', 1),
       ('教师', '教师', 1),
       ('辅导员', '辅导员', 1),
       ('超级管理员', '拥有全部权限', 1);

insert into ums_permission(id, pid, type, name, value, url)
values (1, 0, 0, 'ims-公共信息管理系统', null, null),
       (2, 0, 0, 'ums-用户管理系统', null, null),
       (3, 0, 0, 'cms-课程管理系统', null, null),
       (4, 0, 0, 'sms-监督管理系统', null, null),
       (5, 1, 1, 'ImsSemesterController-学期信息管理', null, null),
       (6, 5, 2, '删除指定id学期信息', 'ims:semester:delete:id', 'GET /ims/semester/delete/{id}'),
       (7, 5, 2, '添加学期信息', 'ims:semester:insert', 'POST /ims/semester/insert'),
       (8, 5, 2, '获取全部学期信息', 'ims:semester:list', 'GET /ims/semester/list'),
       (9, 5, 2, '按年度范围获取学期信息', 'ims:semester:list:range', 'GET /ims/semester/list/range'),
       (10, 5, 2, '更新指定id学期信息', 'ims:semester:update:id', 'POST /ims/semester/update/{id}'),
       (11, 5, 2, '获取指定id学期信息', 'ims:semester:id', 'GET /ims/semester/{id}'),
       (12, 1, 1, 'ImsDepartmentController-部门信息管理', null, null),
       (13, 12, 2, '删除指定id部门信息', 'ims:department:delete:id', 'GET /ims/department/delete/{id}'),
       (14, 12, 2, '添加部门信息', 'ims:department:insert', 'POST /ims/department/insert'),
       (15, 12, 2, '获取所有部门信息', 'ims:department:list', 'GET /ims/department/list'),
       (16, 12, 2, '分页查询部门信息', 'ims:department:list:page', 'GET /ims/department/list/page'),
       (17, 12, 2, '更新指定id部门信息', 'ims:department:update:id', 'POST /ims/department/update/{id}'),
       (18, 12, 2, '获取指定id部门信息', 'ims:department:id', 'GET /ims/department/{id}'),
       (19, 12, 2, '获取指定部门id所属层次信息:向上查找', 'ims:department:id:root', 'GET /ims/department/{id}/root'),
       (20, 12, 2, '获取指定部门id下属部门信息:向下查找', 'ims:department:id:structure', 'GET /ims/department/{id}/structure'),
       (21, 3, 1, 'CmsCourseController-课程信息管理', null, null),
       (22, 21, 2, '删除指定id课程信息', 'cms:course:delete:id', 'GET /cms/course/delete/{id}'),
       (23, 21, 2, '添加课程信息', 'cms:course:insert', 'POST /cms/course/insert'),
       (24, 21, 2, '获取所有课程信息', 'cms:course:list', 'GET /cms/course/list'),
       (25, 21, 2, '分页查询课程信息', 'cms:course:list:page', 'GET /cms/course/list/page'),
       (26, 21, 2, '批量更新课程启用状态', 'cms:course:update:status:batch', 'POST /cms/course/update/status/batch'),
       (27, 21, 2, '批量更新课程学期信息', 'cms:course:update:term:batch', 'POST /cms/course/update/term/batch'),
       (28, 21, 2, '批量更新课程类型', 'cms:course:update:type:batch', 'POST /cms/course/update/type/batch'),
       (29, 21, 2, '更新指定id课程信息', 'cms:course:update:id', 'POST /cms/course/update/{id}'),
       (30, 21, 2, '获取指定id课程信息', 'cms:course:id', 'GET /cms/course/{id}'),
       (31, 3, 1, 'CmsOpenCourseController-开课信息管理', null, null),
       (32, 31, 2, '分页获取开课信息概要信息列表', 'cms:opencourse:list:simple', 'GET /cms/opencourse/list/simple'),
       (33, 31, 2, '新增开课信息：面向开课用户', 'cms:opencourse:insert', 'POST cms/opencourse/insert'),
       (34, 31, 2, '删除开课信息', 'cms:opencourse:delete:id', 'GET /cms/opencourse/delete/{id}'),
       (35, 31, 2, '批量删除开课信息', 'cms:opencourse:delete:batch', 'GET /cms/opencourse/delete/batch'),
       (36, 31, 2, '更新开课信息', 'cms:opencourse:update:id', 'POST /cms/opencourse/update/{id}'),
       (37, 31, 2, '批量更新开课信息状态', 'cms:course:id', 'GET /cms/course/{id}'),
       (38, 3, 1, 'CmsUserOpenCourseRelationController-选课管理', null, null),
       (39, 38, 2, '管理员:分页获取选课信息', 'cms:user-opencourse-relation:list:page:simple', 'GET /cms/user-opencourse-relation/list/page/simple'),
       (40, 38, 2, '学生选课', 'cms:user-opencourse-relation:select:opencourseId', 'GET /cms/user-opencourse-relation/select/{opencourseId}'),
       (41, 38, 2, '学生退课', 'cms:user-opencourse-relation:delete:id', 'GET /cms/user-opencourse-relation/delete/{id}'),
       (42, 38, 2, '管理员：批量删除', 'cms:user-opencourse-relation:delete:batch', 'GET /cms/user-opencourse-relation/delete/batch'),
       (43, 38, 2, '管理员：批量更新选课状态', 'cms:user-opencourse-relation:update:batch', 'GET /cms/user-opencourse-relation/update/batch'),
       (44, 38, 2, '讲师确认', 'cms:user-opencourse-relation:teacher:confirm', 'GET /cms/user-opencourse-relation/teacher/confirm/batch'),
       (45, 38, 2, '学生确认', 'cms:user-opencourse-relation:student:confirm', 'GET /cms/user-opencourse-relation/student/confirm/batch'),
       (46, 38, 2, '获取用户[个人]选课信息', 'cms:user-opencourse-relation:list:student:simple', 'GET /cms/user-opencourse-relation/list/student/simple'),
       (47, 4, 1, 'SmsMessageController-通知管理', null, null),
       (48, 47, 2, '获取指定id通知', 'sms:message:id', 'GET /sms/message/get/{id}'),
       (49, 47, 2, '获取全部通知', 'sms:message:list', 'GET /sms/message/list'),
       (50, 47, 2, '删除通知', 'sms:message:delete:id', 'GET /sms/message/delete/{id}'),
       (51, 47, 2, '新增通知', 'sms:message:insert', 'POST /sms/message/insert'),
       (52, 47, 2, '修改通知', 'sms:message:update:id', 'POST /sms/message/update/{id}');


insert into ums_user_role_relation(user_id, role_id) values
(1, 1), (1, 2), (2, 1), (3, 4), (4, 2), (5, 5);

insert into ums_role_permission_relation(role_id, permission_id) values
(5, 1), (5, 2), (5, 3), (5, 4), (5, 5), (5, 6), (5, 7), (5, 8), (5, 9), (5, 10),
(5, 11), (5, 12), (5, 13), (5, 14), (5, 15), (5, 16), (5, 17), (5, 18), (5, 19), (5, 20),
(5, 21), (5, 22), (5, 23), (5, 24), (5, 25), (5, 26), (5, 27), (5, 28), (5, 29), (5, 30),
(5, 31), (5, 32), (5, 33), (5, 34), (5, 35), (5, 36), (5, 37), (5, 38), (5, 39), (5, 40),
(5, 41), (5, 42), (5, 43), (5, 44), (5, 45), (5, 46), (5, 47), (5, 48), (5, 49), (5, 50),
(5, 51), (5, 52),
(1, 1), (1, 2), (1, 3), (1, 4), (1, 5), (1, 6), (1, 7), (1, 8), (1, 9), (1, 10),
(1, 11), (1, 12), (1, 13), (1, 14), (1, 15), (1, 16), (1, 17), (1, 18), (1, 19), (1, 20),
(1, 21), (1, 22), (1, 23), (1, 24), (1, 25), (1, 26), (1, 27), (1, 28), (1, 29), (1, 30),
(1, 31), (1, 32), (1, 33), (1, 34), (1, 35), (1, 36), (1, 37), (1, 38), (1, 39), (1, 40),
(1, 41), (1, 42), (1, 43), (1, 44), (1, 45), (1, 46), (1, 47), (1, 48), (1, 49), (1, 50),
(1, 51), (1, 52);

insert into cms_course(department_id, name, type, term, status) VALUES
    (1, 'Java程序设计', 1, 1, 1),
    (1, '软件工程', 1, 1, 1),
    (1, '计算机系统3', 1, 1, 1),
    (1, '程序设计基础', 1, 1, 1),
    (1, '数据结构', 1, 1, 1),
    (1, '计算机导论', 1, 1, 1),
    (1, '计算机网络', 1, 1, 1);

insert into cms_opencourse(user_id, course_id, semester_id, select_limit,
                           select_count, note, status, status_comment) values
(1, 1, 8, 5, 0, '以实验教学为主', 1, '审核通过 操作人：系统管理员'),
(1, 2, 8, 3, 0, '周一周二全天有空', 1, '审核通过 操作人：系统管理员'),
(1, 3, 8, 3, 0, '无', 1, '审核通过 操作人：系统管理员');
