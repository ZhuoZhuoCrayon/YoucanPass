package com.crayon.youcanpass.dto;

import com.crayon.youcanpass.model.ImsDepartment;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @Classname ImsDepartmentTreeNode
 * @Description 部门树状结构
 * @Date 2020/2/6 17:23
 * @Created by Crayon
 */
@Getter
@Setter
public class ImsDepartmentTreeNode extends ImsDepartment {
    @ApiModelProperty(value = "部门下属子节点")
    private List<ImsDepartmentTreeNode> departmentChildList;
}
