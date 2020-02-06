package com.crayon.youcanpass.common.constant;
import com.crayon.youcanpass.model.ImsSemester;

/**
 * @Classname ImsConstant
 * @Description 公共信息管理：常量区
 * @Date 2020/2/5 14:52
 * @Created by Crayon
 */
public class ImsConstant {
    public static final String[] TREMS = {"学期信息", "第一学期", "第二学期"};

    /**
     * 根据年度、学期信息，转化为学期描述信息
     */
    public static String parseSemesterDescription(ImsSemester semester){
        StringBuilder sb = new StringBuilder();
        sb.append(semester.getBeginYear());
        sb.append("-");
        sb.append(semester.getEndYear());
        sb.append("学年度");
        sb.append(TREMS[semester.getTerm()]);
        return sb.toString();
    }
}
