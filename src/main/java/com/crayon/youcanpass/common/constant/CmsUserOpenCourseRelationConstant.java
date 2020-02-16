package com.crayon.youcanpass.common.constant;

/**
 * @Classname CmsUserOpenCourseRelationConstant
 * @Description 选课信息常量类
 * @Date 2020/2/16 17:40
 * @Created by Crayon
 */
public class CmsUserOpenCourseRelationConstant {
    public static final int FAILED_AUDIT = -1;      //审核不通过
    public static final int WAITING_AUDIT = 0;      //待审核
    public static final int WAITING_TEACHER_CONFIRM = 1;   //等待讲师审核
    public static final int WAITING_STUDENT_CONFIRM = 2;    //等待学生审核
    public static final int ING = 3;                    //上课中
    public static final int END = 4;                    //结课，待评价
}
